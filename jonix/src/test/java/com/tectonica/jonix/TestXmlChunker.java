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

import javax.xml.stream.events.StartElement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;

import com.tectonica.xmlchunk.XmlChunker;

public class TestXmlChunker
{
	@Before
	public void setUp() throws Exception
	{}

	@After
	public void tearDown() throws Exception
	{}

	@Test
	public void xmlReadParseAndThenWriteAsXml()
	{
		InputStream stream = TestXmlChunker.class.getResourceAsStream("/single-book-onix2.xml");
		XmlChunker.parse(stream, "UTF-8", 2, new XmlChunker.Listener()
		{
			@Override
			public boolean onChunk(Element element)
			{
				// turn the DOM element back to XML
				String asXml = XmlChunker.elementToString(element, false);

				System.out.println("\t" + asXml);
				System.out.println("------------------------------------------------------------------------------");
				
				return true;
			}

			@Override
			public void onPreTargetStart(int depth, StartElement element)
			{
				final String localPart = element.getName().getLocalPart();
				System.out.println("FOUND TAG: " + localPart + " @ " + depth);
				System.out.println("------------------------------------------------------------------------------");
			}
		});
	}
}
