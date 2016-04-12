/*
 * Copyright (C) 2012 Zach Melamed
 * 
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

/**
 * An XML data extraction class, intended for XML sources that have the following properties:
 * <p>
 * <ul>
 * <li>May be infinitely large (can't be held in memory in its entirety)
 * <li>Has a repetitive structure, where sub-XML records of interest are all located at some constant depth/level
 * </ul>
 * <p>
 * The XML source will be broken into 'chunks', each representing one XML sub-tree positioned at the target depth
 * (assuming it is small enough to fit in memory). The chunk will be passed to the caller as an in-memory DOM
 * {@link Element}.
 * <p>
 * For example, given the following XML:
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;
 * &lt;Level1&gt;
 *     &lt;Level2a&gt;
 *         ..
 *         &lt;Level3a&gt;
 *             ..
 *             &lt;Level4&gt;
 *                 ..
 *             &lt;/Level4&gt;
 *             ..
 *         &lt;/Level3a&gt;
 *          
 *         &lt;Level3b&gt;
 *             ..
 *         &lt;/Level3b&gt;
 *         ..
 *     &lt;/Level2a&gt;
 *      
 *     &lt;Level2b&gt;
 *     ..
 *     &lt;/Level2b&gt;
 * &lt;/Level1&gt; *
 * </pre>
 * 
 * Requesting a target depth of 2 would yield two chunks, {@code <Level2a>..</Level2a>} (including its entire sub-tree),
 * and {@code <Level2b>..</Level2b>}.
 * <p>
 * The main API of this class is {@link XmlChunker#parse(InputStream, String, int, Listener)}.
 * 
 * @author Zach Melamed
 */
public class XmlChunker
{
	private static final XMLInputFactory inputFactory;
	private static final TransformerFactory transformerFactory;
	private static final XmlChunkerEndDocument endDocumentEvent = new XmlChunkerEndDocument();

	static
	{
		inputFactory = XMLInputFactory.newInstance();

		// no need to validate, or even try to access, the remote DTD file
		inputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, Boolean.FALSE);

		// no need to validate internal entities - this is important because ONIX files are designed to contain HTML
		// sections inside them. these sections may include entities (such as '&nbsp;') that aren't XML-compatible
		inputFactory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);

		// this is our Transformer of choice
		System.setProperty("javax.xml.transform.TransformerFactory",
				"com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
		transformerFactory = TransformerFactory.newInstance();
	}

	/**
	 * An interface that the user of {@link XmlChunker} must implement in order to get the 'chunks' extracted from the
	 * XML source
	 * 
	 * @author Zach Melamed
	 */
	public static interface Listener
	{
		/**
		 * Fired for elements in the XML source positioned at a level lower than the target depth, giving the user a
		 * chance to look at their name and attributes
		 * 
		 * @param depth
		 *            level at which the element is positioned
		 * @param element
		 *            the element itself (this is NOT a DOM element)
		 */
		public void onPreTargetStart(int depth, StartElement element);

		/**
		 * Fired with an in-memory DOM representation of an XML sub-tree positioned at the target depth
		 * 
		 * @return whether or not to continue to the next chunk (i.e. false means break the parsing)
		 */
		public boolean onChunk(Element element);
	}

	/**
	 * Extracts 'chunks' of an XML source into a user-provided {@link Listener}
	 * 
	 * @param is
	 *            the {@link InputStream} of the XML source
	 * @param encoding
	 *            the text encoding of the XML source (use {@code "UTF-8"} if not sure)
	 * @param targetDepth
	 *            the level at which the chunks are positioned in the XML source
	 * @param listener
	 *            an implementation of a {@link Listener} for taking the chunks
	 */
	public static void parse(InputStream is, String encoding, int targetDepth, Listener listener)
	{
		int depth = -1;
		List<XMLEvent> events = null;

		try
		{
			XMLEventReader reader = inputFactory.createXMLEventReader(is, encoding);
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
						boolean resume = listener.onChunk(element);
						events = null;
						if (!resume)
							break;
					}
					depth--;
				}
			}
		}
		catch (XMLStreamException e)
		{
			e.printStackTrace();
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

	/**
	 * Transforms a DOM {@link Element} into an XML text
	 * 
	 * @param elem
	 *            the element to transform into text
	 * @param strip
	 *            if true, removes the containing tag of the XML node
	 * @return an XML text representation of the given element
	 */
	public static String elementToString(Element elem, boolean strip)
	{
		StringWriter sw = new StringWriter();
		try
		{
			Transformer t = transformerFactory.newTransformer();
			t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			t.transform(new DOMSource(elem), new StreamResult(sw));
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
