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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Element;

import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.struct.JonixProductIdentifier;
import com.tectonica.jonix.struct.JonixTitle;
import com.tectonica.jonix.util.JSON;
import com.tectonica.xmlchunk.XmlChunker;

public class TestXmlChunkerWithProducts
{
	@Before
	public void setUp() throws Exception
	{}

	@After
	public void tearDown() throws Exception
	{}

	@Test
	@Ignore
	// ignored by default. the sample files are not checked in to SCM
	public void readProductsAndExtractProperties() throws FileNotFoundException
	{
		final File file = new File("../onix_samples/ONIX2/SB_Ref.xml"); // SB_short.xml
		if (!file.exists())
			throw new RuntimeException("couldn't found " + file.getAbsolutePath());

		XmlChunker.parse(new FileInputStream(file), "UTF-8", 2, new XmlChunker.Listener()
		{
			private int count = 0;

			@Override
			public void onTarget(Element element)
			{
				final String nodeName = element.getNodeName();
				if (nodeName.equals(Product.refname) || nodeName.equals(Product.shortname))
				{
					// parse a Product XML element into a corresponding Java structure
					Product product = new Product(element);

					// get some basic properties of the book
					JonixProductIdentifier isbn = product.findProductIdentifier(ProductIdentifierTypes.ISBN_13);
					JonixTitle title = product.findTitle(TitleTypes.Distinctive_title_book);
					String titleValue = (title == null) ? "N/A" : title.titleText;
					String isbnValue = (isbn == null) ? "N/A" : isbn.idValue;
					boolean hasSeriesInfo = (product.seriess != null) && !product.seriess.isEmpty();
					String seriesTitleValue = hasSeriesInfo ? product.seriess.get(0).titleOfSeries.value + " / " : "";

					// print
					++count;
					System.out.println(String.format("#%04d: title='%s', isbn='%s'", count, seriesTitleValue
							+ titleValue, isbnValue));

					// in rare cases where there is no title, we print the entire XML record (as JSON)
					if (title == null)
						System.err.println(JSON.toJson(product));
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

		System.err.println("** DONE");
	}
}
