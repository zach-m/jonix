package com.tectonica.jonix;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilterImpl;

/**
 * A bridge between SAX and JAXB used internally to prevent JAXB from reading the entire ONIX file it unmarshalls into memory. Another
 * function provided by this filter is the manual injection of the correct XML namespace expected by ONIX tags, even if the file itself
 * doesn't contain them.
 * <p>
 * The implementation of this class was inspired by the <i>partial-unmarshalling</i> demo application provided with the <a
 * href="http://jaxb.java.net">JAXB Reference Implementation</a>. The idea is simple - use SAX, not JAXB, to read the entire document, but
 * along the way, make as many 'small' and short-lived instances of JAXB parser (a.k.a <code>Unmarshaller</code>) as needed, to deal with
 * parsing of local, safe-contained tags (i.e. <code>PRODUCT</code>, for instance).
 * 
 * @author Zach Melamed
 * 
 */
public class JonixChunksHandler extends XMLFilterImpl
{
	public static interface OnChunkListener
	{
		public void onChunk(Object onixObj);
	}

	private final JAXBContext context;
	private String globalNS;
	private OnChunkListener onChunkListener;
	private int depth = 0;

	public JonixChunksHandler(JAXBContext context, String globalNS, OnChunkListener onChunkListener)
	{
		this.context = context;
		this.globalNS = globalNS;
		this.onChunkListener = onChunkListener;
	}

	private Locator locator;

	@Override
	public void setDocumentLocator(Locator locator)
	{
		super.setDocumentLocator(locator);
		this.locator = locator;
	}

	private UnmarshallerHandler unmarshallerHandler;

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException
	{
		// only top-level elements require special treatment
		if (depth == 1)
		{
			// we started a top-level element (HEADER or PRODUCT) in SAX, now we create a new, short-lived, instance of JAXB parser
			// (Unmarshaller) to
			// handle only the internal content of this top-level tag
			Unmarshaller unmarshaller;
			try
			{
				unmarshaller = context.createUnmarshaller();
			}
			catch (JAXBException e)
			{
				throw new SAXException(e);
			}

			// technically, we trick JAXB into thinking that this tag is in fact the beginning of a new XML document
			unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
			setContentHandler(unmarshallerHandler);
			unmarshallerHandler.startDocument();
			unmarshallerHandler.setDocumentLocator(locator);
		}

		// when internal tags (below top-level) start, we simply let the SAX reader progress, with the JAXB-unmarshaller being the content
		// handler
		super.startElement(globalNS, localName, qName, atts);
		depth++;
	}

	private DefaultHandler nullHandler = new DefaultHandler();

	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException
	{
		super.endElement(globalNS, localName, qName);
		depth--;

		if (depth == 1)
		{
			// the top-level tag has ended, we wrap up the tag streaming, and ask the unmarshaller to do the actual parsing
			unmarshallerHandler.endDocument();
			setContentHandler(nullHandler);
			try
			{
				Object onixObj = unmarshallerHandler.getResult(); // parses the top-level tag (and children) passed to it as a virtual XML
																	// document
				onChunkListener.onChunk(onixObj);
			}
			catch (JAXBException je)
			{
				System.err.println("unable to process line " + locator.getLineNumber());
				return;
			}
			unmarshallerHandler = null;
		}
	}
}
