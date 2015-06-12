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
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

import com.tectonica.jonix.onix2.Product;

public class TestSingle
{

	@Before
	public void setUp() throws Exception
	{}

	@After
	public void tearDown() throws Exception
	{}

	private static Document docOf(String xmlResourceName)
	{
		try (InputStream is = TestSingle.class.getResourceAsStream(xmlResourceName))
		{
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			// disable dtd validation
			docBuilder.setEntityResolver(new EntityResolver()
			{
				@Override
				public InputSource resolveEntity(String publicId, String systemId)
				{
					return new InputSource(new StringReader(""));
				}
			});
			return docBuilder.parse(is);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testViaDOM()
	{
		final Document doc = docOf("/single-book-onix2.xml");
		final NodeList products = doc.getElementsByTagName("Product");
		for (int i = 0; i < products.getLength(); i++)
		{
			final Element productElem = (Element) products.item(i);
			final Product product = new Product(productElem);
			System.out.println(JSON.toJson(product));
		}
	}

	@Test
	public void testViaReader()
	{
		Onix2Reader reader = new Onix2Reader()
		{
			@Override
			protected void onProduct(Product product)
			{
				System.out.println(JSON.toJson(product));
			}
		};

		reader.read(getClass().getResourceAsStream("/single-book-onix2.xml"));
	}
}
