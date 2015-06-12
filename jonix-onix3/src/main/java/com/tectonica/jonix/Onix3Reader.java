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
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;

import org.w3c.dom.Element;

import com.tectonica.jonix.onix3.Header;
import com.tectonica.jonix.onix3.Product;
import com.tectonica.repackaged.org.apache.commons.io.input.BOMInputStream;
import com.tectonica.xmlchunk.XmlChunker;

/**
 * Simple base class for reading ONIX3 sources from an XML source
 * <p>
 * Subclasses need to override {@link #onProduct(Product)} and optionally {@link #onHeader(Header)}
 */
public abstract class Onix3Reader
{
	protected int productNo = 0;

	public int getProductNo()
	{
		return productNo;
	}

	public void read(final InputStream source)
	{
		read(source, "UTF-8");
	}

	public void read(final String fileName) throws FileNotFoundException
	{
		read(fileName, "UTF-8");
	}

	public void read(final String fileName, final String encoding) throws FileNotFoundException
	{
		read(new FileInputStream(fileName), encoding);
	}

	public void read(final InputStream source, final String encoding)
	{
		XmlChunker.parse(new BOMInputStream(source), encoding, 2, new XmlChunker.Listener()
		{
			@Override
			public void onPreTargetStart(int depth, StartElement element)
			{
				if (!element.getName().getLocalPart().equalsIgnoreCase("ONIXMessage"))
					throw new RuntimeException("file doesn't start with the mandatory <ONIXMessage> tag");
				final Attribute release = element.getAttributeByName(new QName("release"));
				boolean isOnix2 = (release == null || release.getValue().startsWith("2"));
				boolean isOnix3 = (release != null && release.getValue().startsWith("3"));
				if (!isOnix3)
					throw new RuntimeException(isOnix2 ? "Source is an ONIX2 file, not ONIX3"
							: "Source doesn't seem to be an ONIX3 file");
			}

			@Override
			public void onChunk(Element element)
			{
				final String nodeName = element.getNodeName();
				if (nodeName.equalsIgnoreCase("Header"))
				{
					onHeader(new Header(element));
				}
				else if (nodeName.equalsIgnoreCase("Product"))
				{
					++productNo;
					onProduct(new Product(element));
				}
			}
		});
	}

	protected void onHeader(Header header)
	{}

	protected abstract void onProduct(Product product);
}
