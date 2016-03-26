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

package com.tectonica.jonix.basic;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TextTypes;

/**
 * Contains the essential information included in ONIX2 &lt;OtherText&gt; / ONIX3 &lt;TextContent&gt;
 * <p>
 * NOTE: to access the information, use the public fields directly. No getters() are included..
 * 
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BasicText implements Serializable
{
	public TextTypes textType;
	public TextFormats textFormat;
	public String text;

	public String getUnescapedText()
	{
		if ((textFormat == TextFormats.XHTML) || (textFormat == TextFormats.XML) || (textFormat == TextFormats.HTML))
		{
			try
			{
				return unescape(text);
			}
			catch (XMLStreamException e)
			{
				// ignore
			}
		}
		return text;
	}

	private static final XMLInputFactory inputFactory;

	static
	{
		inputFactory = XMLInputFactory.newInstance();

		// no need to validate, or even try to access, the remote DTD file
		inputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, Boolean.FALSE);

		// no need to validate internal entities - this is important because ONIX files are designed to contain HTML
		// sections inside them. these sections may include entities (such as '&nbsp;') that aren't XML-compatible
		inputFactory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);
	}

	private static String unescape(String escaped) throws XMLStreamException
	{
		XMLStreamReader reader = inputFactory.createXMLStreamReader(new StringReader("<xml>" + escaped + "</xml>"));
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