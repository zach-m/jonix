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

package com.tectonica.jonix.codegen.util;

import com.tectonica.jonix.codegen.generator.Parser;
import com.tectonica.jonix.codegen.metadata.OnixMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

public class ParseUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParseUtil.class);

    public static OnixMetadata parse(OnixSpecs specs) throws IOException, ParserConfigurationException, SAXException {
        Document codelistDoc = docOf(specs.codelistXsd);
        Document structureDoc = docOf(specs.structureXsd);

        final Parser parser = new Parser(specs.onixVersion, specs.isShort, specs.codelistIssue);
        parser.analyzeSchema(codelistDoc, new File(specs.codelistXsd).getName());
        parser.analyzeSchema(structureDoc, new File(specs.structureXsd).getName());
        parser.postAnalysis(specs.specHtml);

        LOGGER.info(">>> Successfully processed " + specs.structureXsd);

        return parser.getMetadata();
    }

    private static Document docOf(String xmlResourceName) throws ParserConfigurationException, SAXException,
        IOException {
        try (InputStream is = ParseUtil.class.getResourceAsStream(xmlResourceName)) {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            // disable dtd validation
            docBuilder.setEntityResolver((publicId, systemId) -> new InputSource(new StringReader("")));
            return docBuilder.parse(is);
        }
    }
}
