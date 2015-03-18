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

package com.tectonica.jonix.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.tectonica.jonix.codegen.Parser;
import com.tectonica.jonix.metadata.OnixMetadata;

public class ParseUtil
{
	public static final String RES_CODELIST_2 = "/xsd/onix2/ONIX_BookProduct_CodeLists.xsd";
	public static final String RES_REF_2 = "/xsd/onix2/ONIX_BookProduct_Release2.1_reference.xsd";
	public static final String RES_SHORT_2 = "/xsd/onix2/ONIX_BookProduct_Release2.1_short.xsd";
	public static final String RES_CODELIST_3 = "/xsd/onix3/ONIX_BookProduct_CodeLists.xsd";
	public static final String RES_REF_3 = "/xsd/onix3/ONIX_BookProduct_3.0_reference.xsd";
	public static final String RES_SHORT_3 = "/xsd/onix3/ONIX_BookProduct_3.0_short.xsd";

	public static OnixMetadata parse(String mainXsd, String codelistXsd) throws IOException, ParserConfigurationException, SAXException
	{
		Document codelistDoc = docOf(codelistXsd);
		Document mainDoc = docOf(mainXsd);

		final Parser parser = new Parser();
		parser.analyzeSchema(codelistDoc);
		parser.analyzeSchema(mainDoc);

		final OnixMetadata metadata = parser.getMetadata();
//		metadata.sort();

		return metadata;
	}

	private static Document docOf(String xmlResourceName) throws ParserConfigurationException, SAXException, IOException
	{
		try (InputStream is = ParseUtil.class.getResourceAsStream(xmlResourceName))
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
	}
}
