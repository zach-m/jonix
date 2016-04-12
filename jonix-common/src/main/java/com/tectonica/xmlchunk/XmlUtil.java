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

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;

public class XmlUtil
{
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
			Transformer t = XmlChunkerContext.transformerFactory.newTransformer();
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

	/**
	 * Transforms an escaped XML into the original, "un-escaped" value (for example turn &amp;lt;Hello&amp;gt; into
	 * &lt;Hello&gt;)
	 * 
	 * @param escaped
	 *            the escaped XML string
	 * @return the un-escaped XML string
	 * @throws XMLStreamException
	 */
	public static String unescape(String escaped) throws XMLStreamException
	{
		if (escaped == null)
			return null;
		XMLStreamReader reader = XmlChunkerContext.inputFactory.createXMLStreamReader(new StringReader("<xml>"
				+ escaped + "</xml>"));
		StringWriter sw = new StringWriter(escaped.length());
		while (reader.hasNext())
		{
			reader.next();
			if (reader.hasText())
				sw.append(reader.getText());
		}
		return sw.toString();
	}
}
