package com.tectonica.jonix;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import com.tectonica.jonix.JonixChunksHandler.OnChunkListener;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * Given an ONIX filename and a {@link OnJonixItemListener} event listener, this parser will fire an event for each top-level tag (i.e. <code>HEADER</code> or
 * <code>PRODUCT</code>) of the file. It is designed to deal with infinitely large ONIX files.<br/>
 * <br/>
 * The parser uses the JAXB framework to unmarshall the XML into Java objects. This gives us good validation for the input file and prevents typos in the
 * code stemming from manual translation from XML tags into Java members. The JAXB-annotated classes were automatically created using JAXB's <code>xjc</code>
 * compiler, executed on EDItEUR-provided XML schemas (<code>.xsd</code> files).<br/>
 * In order to prepare for a potentially very large input file, we add an intermediate layer of <code>SAX</code> parser, preventing JAXB from reading the entire
 * file into memory.
 * 
 * @author Zach Melamed
 * 
 * @see {@link JonixProduct}
 * @see {@link JonixHeader}
 * 
 */
public class JonixParser
{
	/**
	 * An interface for a user-provided event listener fired by {@link JonixParser} whenever the parsing of an ONIX top-level tag (i.e. <code>HEADER</code> or
	 * <code>PRODUCT</code>) completes
	 */
	public static interface OnJonixItemListener
	{
		public void onHeader(JonixHeader header);

		public void onProduct(JonixProduct product, int index);
	}

	private final JonixPackages jonixPackage;
	private final XMLReader saxReader;

	/**
	 * Initializes the parser in accordance with a specific ONIX Xml schema (passed as {@link JonixPackages}. This initialization is likely to take a few
	 * seconds.
	 * 
	 * @param jonixPackage
	 *            identifies the ONIX Xml schema with which the input file complies
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws JAXBException
	 */
	public JonixParser(JonixPackages jonixPackage) throws SAXException, ParserConfigurationException, JAXBException
	{
		this.jonixPackage = jonixPackage;

		// we don't carry on with the process if the required package isn't supported yet
		if (jonixPackage.productMapper == null)
			throw new UnsupportedOperationException("package " + jonixPackage.name() + " is still unimplemented");

		// obtain an XML parser from a standard SAX-parser
		saxReader = createFactory().newSAXParser().getXMLReader();

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
	private SAXParserFactory createFactory()
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

	/**
	 * An internally-used event listener. Fired up when the JAXB framework has done unmarshalling an XML tag, it calls the proper <code>mapper</code>, to
	 * transform the raw JAXB object into a Jonix, package-independent object, containing the most important information from the original tag (either
	 * <code>HEADER</code> or <code>PRODUCT</code>). Once mapping is done, it fires the external event listener, provided by the user.
	 */
	private class OnChunkListenerImpl implements OnChunkListener
	{
		int productCount = 0;
		private OnJonixItemListener onJonixItemListener;

		public void reset(OnJonixItemListener onJonixItemListener)
		{
			productCount = 0;
			this.onJonixItemListener = onJonixItemListener;
		}

		@Override
		public void onChunk(Object onixObj)
		{
//			JonixUtils.print(onixObj, System.out);
			if (onixObj.getClass().getSimpleName().equals("Product"))
			{
				JonixProduct product = jonixPackage.productMapper.execute(onixObj);
				onJonixItemListener.onProduct(product, ++productCount);
			}
			else if (onixObj.getClass().getSimpleName().equals("Header") && jonixPackage.headerMapper != null)
			{
				JonixHeader header = jonixPackage.headerMapper.execute(onixObj);
				onJonixItemListener.onHeader(header);
			}
		}
	};

	private OnChunkListenerImpl onChunkListener = new OnChunkListenerImpl();

	/**
	 * Parses the given ONIX file, firing events whenever atop-level tag (<code>HEADER</code> or <code>PRODUCT</code>) has been parsed.
	 * 
	 * @param fileName
	 * @param onJonixItemListener
	 * @throws IOException
	 * @throws SAXException
	 */
	public void parse(String fileName, final OnJonixItemListener onJonixItemListener) throws IOException, SAXException
	{
		onChunkListener.reset(onJonixItemListener);

		if (onJonixItemListener != null) // not too useful to parse if nobody is listening..
			saxReader.parse(new InputSource(fileName));
	}

	/**
	 * Returns the number of products parsed in the previous run of {@link JonixParser#parse(String, OnJonixItemListener)}.
	 */
	public int getProductCount()
	{
		return onChunkListener.productCount;
	}
}
