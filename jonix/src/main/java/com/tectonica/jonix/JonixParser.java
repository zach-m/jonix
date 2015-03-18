package com.tectonica.jonix;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.io.input.BOMInputStream;
import com.tectonica.jonix.JonixChunksHandler.OnChunkListener;
import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * Core class for parsing an Onix source (either file or a general {@link InputStream}).
 * <p>
 * Using this class directly is a rare use-case. Consider using a subclass of {@link JonixScanner} instead.
 * <p>
 * Given an event listener (a {@link JonixParserListener} implementation), this class fires events for each top-level tag (i.e. <code>HEADER</code> or
 * <code>PRODUCT</code>) of the source. It is designed to deal with infinitely large ONIX files. The parsing process includes reading the header and products
 * one by one, turn them into Java objects (this part is done by the JAXB processor), process these objects into {@link JonixTag}s consisting of the elements
 * and composites of the header/product in question.
 * <p>
 * The parser uses the JAXB framework to unmarshall the XML into Java objects. This gives a good validation for the input file and prevents typos in the code
 * stemming from manual translation from XML tags into Java members. The JAXB-annotated classes were automatically created using JAXB's <code>xjc</code>
 * compiler, executed on EDItEUR-provided XML schemas (<code>.xsd</code> files).<br/>
 * In order to prepare for a potentially very large input file, we add an intermediate layer of <code>SAX</code> parser, preventing JAXB from reading the entire
 * file into memory.
 * 
 * @author Zach Melamed
 * 
 * @param <H>
 *            the {@link JonixTag} representing the HEADER tag of each ONIX record
 * @param <P>
 *            the {@link JonixTag} representing the PRODUCT tag of each ONIX record
 */
public class JonixParser<H extends JonixTag, P extends JonixTag>
{
	public static final String DEFAULT_INPUT_CHARSET = "UTF8";

	/**
	 * An interface for generating new {@link JonixTag}s, capable of processing JAXB-generated Java object. Its two methods are fired during the parsing of an
	 * ONIX source whenever a top-level tag is reached
	 */
	public static interface JonixFactory<H extends JonixTag, P extends JonixTag>
	{
		H newHeaderProcessor(JonixResolver resolver);

		P newProductProcessor(JonixResolver resolver);
	}

	/**
	 * An interface for acting on parsed and processed {@link JonixTag}s during the parsing process. Its two methods are fired whenever the parsing of an ONIX
	 * top-level tag (i.e. <code>HEADER</code> or <code>PRODUCT</code>) completes.
	 */
	public static interface JonixParserListener<H extends JonixTag, P extends JonixTag>
	{
		public void onHeader(H header);

		public void onProduct(P product, int index);
	}

	private final JonixPackages jonixPackage;
	private JonixParserListener<H, P> jonixParserListener;
	private final JonixFactory<H, P> jonixFactory;
	private final XMLReader saxReader;

	/**
	 * Initializes the parser in accordance with a specific ONIX schema (passed as {@link JonixPackages}). This initialization is likely to take a few
	 * seconds. In addition to the requested package, the caller is required to pass a {@link JonixFactory} whose job will be to instantiate the
	 * {@link JonixTag}s representing each parsed top-level tag (header/product).
	 */
	public JonixParser(JonixPackages jonixPackage, JonixFactory<H, P> jonixFactory) throws SAXException, ParserConfigurationException, JAXBException
	{
		// we don't carry on with the process if the required package isn't supported yet
		if (jonixPackage.resolver == null)
			throw new UnsupportedOperationException("package " + jonixPackage.name() + " is still unimplemented");

		if (jonixFactory == null)
			throw new NullPointerException("factory must be passed to the parser");

		this.jonixPackage = jonixPackage;
		this.jonixFactory = jonixFactory;

		// obtain an XML parser from a standard SAX-parser
		saxReader = createSAXFactory().newSAXParser().getXMLReader();

		// let JAXB framework learn the requested schema. may take a few seconds..
		JAXBContext context = JAXBContext.newInstance(jonixPackage.onixPackage);

		// the ONIX file can be very large, we'll use a chunk-by-chunk content handler
		ContentHandler handler = new JonixChunksHandler(context, jonixPackage.onixNameSpace, onChunkListener);
		saxReader.setContentHandler(handler);
	}

	/**
	 * Creates a non-validating SAX factory
	 * 
	 * @return
	 *         the created factory
	 */
	private SAXParserFactory createSAXFactory()
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(false);
		try
		{
			factory.setFeature("http://xml.org/sax/features/validation", false);
			factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
			factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
			factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		}
		catch (Exception e)
		{
			// not critical, we can continue
		}
		return factory;
	}

	public JonixParserListener<H, P> getJonixParserListener()
	{
		return jonixParserListener;
	}

	public void setJonixParserListener(JonixParserListener<H, P> jonixParserListener)
	{
		this.jonixParserListener = jonixParserListener;
	}

	/**
	 * An internally-used event listener. Fired up when the JAXB framework has done unmarshalling an XML tag, it calls the proper <code>mapper</code>, to
	 * transform the raw JAXB object into a Jonix, package-independent object, containing the most important information from the original tag (either
	 * <code>HEADER</code> or <code>PRODUCT</code>). Once mapping is done, it fires the external event listener, provided by the user.
	 */
	private class OnChunkListenerImpl implements OnChunkListener
	{
		private int productCount = 0;

		public void reset()
		{
			productCount = 0;
		}

		@Override
		public void onChunk(Object onixObj)
		{
			JonixResolver resolver = jonixPackage.resolver;
			ONIX onixType = resolver.onixTypeOf(onixObj);
			if (onixType == ONIX.Product)
			{
				P product = jonixFactory.newProductProcessor(resolver);
				product.process(onixObj);
				jonixParserListener.onProduct(product, ++productCount);
			}
			else if (onixType == ONIX.Header)
			{
				H header = jonixFactory.newHeaderProcessor(resolver);
				header.process(onixObj);
				jonixParserListener.onHeader(header);
			}
		}
	};

	private OnChunkListenerImpl onChunkListener = new OnChunkListenerImpl();

	/**
	 * Parses the given ONIX file, firing events whenever atop-level tag (<code>HEADER</code> or <code>PRODUCT</code>) has been parsed.
	 * 
	 * @param fileName
	 * @throws IOException
	 * @throws SAXException
	 */
	public void parse(String fileName) throws IOException, SAXException
	{
		parse(new FileInputStream(fileName));
	}

	public void parse(InputStream source) throws IOException, SAXException
	{
		parse(source, DEFAULT_INPUT_CHARSET);
	}

	public void parse(InputStream source, String charsetName) throws IOException, SAXException
	{
		if (jonixParserListener != null) // not too useful to parse if nobody is listening..
		{
			onChunkListener.reset();
			saxReader.parse(new InputSource(new InputStreamReader(new BOMInputStream(source), charsetName)));
		}
	}

	/**
	 * Returns the number of products parsed in the previous run of {@link JonixParser#parse(String, JonixParserListener)}.
	 */
	public int getProductCount()
	{
		return onChunkListener.productCount;
	}
}
