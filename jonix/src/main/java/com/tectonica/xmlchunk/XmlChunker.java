package com.tectonica.xmlchunk;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;

public class XmlChunker
{
	private static final XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	private static final TransformerFactory transformerFactory;
	private static final XmlChunkerEndDocument endDocumentEvent = new XmlChunkerEndDocument();

	static
	{
		System.setProperty("javax.xml.transform.TransformerFactory", "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
		transformerFactory = TransformerFactory.newInstance();
	}

	public static interface Listener
	{
		public void onPreTargetStart(int depth, StartElement element);

		public void onTarget(Element element);
	}

	public static void parse(InputStream is, int targetDepth, Listener listener)
	{
		int depth = -1;
		List<XMLEvent> events = null;

		try
		{
			XMLEventReader reader = inputFactory.createXMLEventReader(is);
			XMLEvent startDocumentEvent = null;

			while (reader.hasNext())
			{
				XMLEvent event;
				event = reader.nextEvent();

				if (event.isStartDocument())
				{
					depth = 0;
					startDocumentEvent = event;
				}

				if (depth < 0)
					continue;

				if (event.isStartElement())
				{
					depth++;
					if (depth < targetDepth)
						listener.onPreTargetStart(depth, event.asStartElement());
					else if (depth == targetDepth)
						events = new ArrayList<XMLEvent>();
				}

				if (events != null)
					events.add(event);

				if (event.isEndElement())
				{
					if (depth == targetDepth)
					{
						List<XMLEvent> domEvents = new ArrayList<XMLEvent>();
						domEvents.add(startDocumentEvent);
						domEvents.addAll(events);
						domEvents.add(endDocumentEvent);
						Element element = elementFromEvents(domEvents, reader);
						listener.onTarget(element);
						events = null;
					}
					depth--;
				}
			}
		}
		catch (XMLStreamException e)
		{
			throw new RuntimeException(e);
		}
	}

	private static Element elementFromEvents(List<XMLEvent> domEvents, XMLEventReader reader) throws XMLStreamException
	{
		XmlChunkerReader xmlEventReader = new XmlChunkerReader(domEvents, reader);

		DOMResult dom = new DOMResult();

		try
		{
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(new StAXSource(xmlEventReader), dom);
			return (Element) dom.getNode().getFirstChild();
		}
		catch (TransformerException e)
		{
			throw new RuntimeException(e);
		}
	}

	public static String elementToString(Element node, boolean strip)
	{
		StringWriter sw = new StringWriter();
		try
		{
			Transformer t = transformerFactory.newTransformer();
			t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			t.transform(new DOMSource(node), new StreamResult(sw));
		}
		catch (TransformerException e)
		{
			throw new RuntimeException(e);
		}
		final String content = sw.toString();

		if (strip)
		{
			final int beginIndex = content.indexOf(">") + 1;
			final int endIndex = content.lastIndexOf("<");
			if (endIndex > beginIndex)
				return content.substring(beginIndex, endIndex);
		}
		return content;
	}
}
