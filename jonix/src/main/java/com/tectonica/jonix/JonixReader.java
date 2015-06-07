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

public class JonixReader<H, P>
{
	protected final JonixContext<H, P> context;
	protected Object rawOnixObject;

	public JonixReader(JonixContext<H, P> context)
	{
		if (context == null)
			throw new NullPointerException("context is required");
		this.context = context;
	}

	public static interface JonixReaderListener<H, P>
	{
		public void onHeader(H header);

		public void onProduct(P product, int index);
	}

	private JonixReaderListener<H, P> listener;

	public JonixReaderListener<H, P> getListener()
	{
		return listener;
	}

	public void setListener(JonixReaderListener<H, P> listener)
	{
		this.listener = listener;
	}

	public void read(String fileName) throws IOException, SAXException
	{
		read(new FileInputStream(fileName));
	}

	public void read(InputStream source)
	{
		if (listener != null) // not too useful to parse if nobody is listening..
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
						{
							com.tectonica.jonix.onix2.Header h2 = new com.tectonica.jonix.onix2.Header(element);
							header = context.createFrom(h2);
							rawOnixObject = h2;
						}
						else if (isOnix3)
						{
							com.tectonica.jonix.onix3.Header h3 = new com.tectonica.jonix.onix3.Header(element);
							header = context.createFrom(h3);
							rawOnixObject = h3;
						}
						else
							throw new RuntimeException("Couldn't determine the ONIX version of the file");
						listener.onHeader(header);
					}
					else if (nodeName.equalsIgnoreCase("Product"))
					{
						final P product;
						if (isOnix2)
						{
							com.tectonica.jonix.onix2.Product p2 = new com.tectonica.jonix.onix2.Product(element);
							product = context.createFrom(p2);
							rawOnixObject = p2;
						}
						else if (isOnix3)
						{
							com.tectonica.jonix.onix3.Product p3 = new com.tectonica.jonix.onix3.Product(element);
							product = context.createFrom(p3);
							rawOnixObject = p3;
						}
						else
							throw new RuntimeException("Couldn't determine the ONIX version of the file");
						listener.onProduct(product, ++productCount);
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
						throw new RuntimeException("file doesn't comply with neither ONIX2 nor ONIX3");
				}
			});
		}
	}
}
