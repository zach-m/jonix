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

import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;

import com.tectonica.jonix.basic.BasicHeader;
import com.tectonica.jonix.basic.BasicProduct;
import com.tectonica.xmlchunk.XmlChunker;

public class TestBasicProduct
{
	private static final String refname = com.tectonica.jonix.onix2.Product.refname;
	private static final String shortname = com.tectonica.jonix.onix2.Product.shortname;

	@Before
	public void setUp() throws Exception
	{}

	@After
	public void tearDown() throws Exception
	{
		System.out.println("\n***********************************************************************************");
	}

	@Test
	public void readSingleProductOfOnix2()
	{
		InputStream stream = getClass().getResourceAsStream("/single-book-onix2.xml");

		XmlChunker.parse(stream, "UTF-8", 2, new XmlChunker.Listener()
		{
			@Override
			public void onTarget(Element element)
			{
				final String nodeName = element.getNodeName();
				if (nodeName.equals(refname) || nodeName.equals(shortname))
				{
					final com.tectonica.jonix.onix2.Product product = new com.tectonica.jonix.onix2.Product(element);
					BasicProduct bp = new BasicProduct(product);
					System.out.println("\nRAW ONIX2  --------------------------------------------------------------");
					System.out.println(JonixUtil.toJson(product));
					System.out.println("\nBASIC ONIX2  ------------------------------------------------------------");
					System.out.println(JonixUtil.toJson(bp));
				}
			}

			@Override
			public void onPreTargetStart(int depth, StartElement element)
			{
				final Attribute release = element.getAttributeByName(new QName("release"));
				boolean isOnix2 = (release == null || release.getValue().startsWith("2"));
				if (!isOnix2)
					throw new RuntimeException("this test is suitable for Onix2 only at this time");
			}
		});
	}

	private String jsonDirect = null;
	private String jsonViaReader = null;

	@Test
	public void readSingleProductOfOnix3AlsoWithReader()
	{
		String resourceName = "/single-book-onix3.xml";

		InputStream stream = getClass().getResourceAsStream(resourceName);

		XmlChunker.parse(stream, "UTF-8", 2, new XmlChunker.Listener()
		{
			@Override
			public void onTarget(Element element)
			{
				final String nodeName = element.getNodeName();
				if (nodeName.equals(refname) || nodeName.equals(shortname))
				{
					final com.tectonica.jonix.onix3.Product product = new com.tectonica.jonix.onix3.Product(element);
					BasicProduct bp = new BasicProduct(product);
					System.out.println("\nRAW ONIX3  --------------------------------------------------------------");
					System.out.println(JonixUtil.toJson(product));
					System.out.println("\nBASIC ONIX3  ------------------------------------------------------------");
					System.out.println(jsonDirect = JonixUtil.toJson(bp));
				}
			}

			@Override
			public void onPreTargetStart(int depth, StartElement element)
			{
				final Attribute release = element.getAttributeByName(new QName("release"));
				boolean isOnix2 = (release == null || release.getValue().startsWith("2"));
				if (isOnix2)
					throw new RuntimeException("this test is suitable for Onix3 only at this time");
			}
		});

		// read the same file, this time using a JonixReader
		JonixReader<BasicHeader, BasicProduct> reader = new JonixReader<BasicHeader, BasicProduct>(Jonix.BASIC_CONTEXT)
		{
			@Override
			protected void onProduct(BasicProduct product)
			{
				jsonViaReader = JonixUtil.toJson(product);
			}
		};
		reader.read(getClass().getResourceAsStream(resourceName));

		// compare the JSON received in both methods
		org.junit.Assert.assertEquals(jsonDirect, jsonViaReader);
	}
}
