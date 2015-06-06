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

package com.tectonica.jonix;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.tectonica.repackaged.org.apache.commons.io.input.BOMInputStream;
import com.tectonica.xmlchunk.XmlChunker;

public class JonixParser<H, P>
{
	protected final JonixContext<H, P> context;

	public JonixParser(JonixContext<H, P> context)
	{
		if (context == null)
			throw new NullPointerException("context is required");
		this.context = context;
	}

	public static interface JonixParserListener<H, P>
	{
		public void onHeader(H header);

		public void onProduct(P product, int index);
	}

	private JonixParserListener<H, P> jonixParserListener;

	public JonixParserListener<H, P> getJonixParserListener()
	{
		return jonixParserListener;
	}

	public void setJonixParserListener(JonixParserListener<H, P> jonixParserListener)
	{
		this.jonixParserListener = jonixParserListener;
	}

	public void parse(String fileName) throws IOException, SAXException
	{
		parse(new FileInputStream(fileName));
	}

	public void parse(InputStream source)
	{
		if (jonixParserListener != null) // not too useful to parse if nobody is listening..
		{
			XmlChunker.parse(new BOMInputStream(source), 2, new XmlChunker.Listener()
			{
				private int productCount = 0;
				boolean isOnix2 = false;
				boolean isOnix3 = false;

				@Override
				public void onTarget(Element element)
				{
					final String nodeName = element.getNodeName();
					if (nodeName.equalsIgnoreCase("Header"))
					{
						final H header;
						if (isOnix2)
							header = context.createFrom(new com.tectonica.jonix.onix2.Header(element));
						else if (isOnix3)
							header = context.createFrom(new com.tectonica.jonix.onix3.Header(element));
						else
							throw new RuntimeException("Couldn't determine the ONIX version of the file");
						jonixParserListener.onHeader(header);
					}
					else if (nodeName.equalsIgnoreCase("Product"))
					{
						final P product;
						if (isOnix2)
							product = context.createFrom(new com.tectonica.jonix.onix2.Product(element));
						else if (isOnix3)
							product = context.createFrom(new com.tectonica.jonix.onix3.Product(element));
						else
							throw new RuntimeException("Couldn't determine the ONIX version of the file");
						jonixParserListener.onProduct(product, ++productCount);
					}
				}

				@Override
				public void onPreTargetStart(int depth, StartElement element)
				{
					if (!element.getName().getLocalPart().equalsIgnoreCase("ONIXMessage"))
						throw new RuntimeException("file doesn't start with the mandatory <ONIXMessage> tag");
					final Attribute release = element.getAttributeByName(new QName("release"));
					isOnix2 = (release == null || release.getValue().startsWith("2"));
					isOnix3 = (release != null && release.getValue().startsWith("3"));
					if (!isOnix2 && !isOnix3)
						throw new RuntimeException("file doesn't comply with neither Onix2 nor Onix3");
				}
			});
		}
	}
}
