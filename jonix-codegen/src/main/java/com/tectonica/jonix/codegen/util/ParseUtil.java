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
import com.tectonica.jonix.codegen.generator.Parser.OnixVersion;
import com.tectonica.jonix.codegen.metadata.OnixMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ParseUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParseUtil.class);

    public static final String RES_CODELIST_2 = "/xsd/onix2/ONIX_BookProduct_CodeLists.xsd";
    public static final String RES_REF_2 = "/xsd/onix2/ONIX_BookProduct_Release2.1_reference.xsd";
    public static final String RES_SHORT_2 = "/xsd/onix2/ONIX_BookProduct_Release2.1_short.xsd";
    public static final String RES_HTML_SPEC_2 = "/xsd/onix2/ONIX_for_Books_Format_Specification_2.1.4.html";

    public static final String RES_CODELIST_3 = "/xsd/onix3/ONIX_BookProduct_CodeLists.xsd";
    public static final String RES_REF_3 = "/xsd/onix3/ONIX_BookProduct_3.0_reference.xsd";
    public static final String RES_SHORT_3 = "/xsd/onix3/ONIX_BookProduct_3.0_short.xsd";
    public static final String RES_HTML_SPEC_3 = "/xsd/onix3/ONIX_for_Books_Format_Specification_3.0.6.html";

    public static final Set<String> SPACEABLE_REF_2 = new HashSet<>(Arrays.asList("RegionCode", "RightsCountry",
        "RightsTerritory", "SupplyToCountry", "SupplyToTerritory", "SupplyToCountryExcluded", "Territory",
        "CountryExcluded", "TerritoryExcluded", "MarketCountry", "MarketTerritory", "MarketCountryExcluded"));

    public static final Set<String> SPACEABLE_SHORT_2 = new HashSet<>(Arrays.asList("b398", "b090", "b388", "j138",
        "j397", "j140", "j303", "j304", "j308", "j403", "j404", "j405"));

    // NOTE: this list was assembled by searching "separated by spaces" in ONIX_for_Books_Format_Specification_3.x.html
    public static final Set<String> SPACEABLE_REF_3 = new HashSet<>(Arrays.asList("CountriesIncluded",
        "RegionsIncluded", "CountriesExcluded", "RegionsExcluded"));

    // NOTE: this list contains the short-version of the tags in SPACEABLE_REF_3
    public static final Set<String> SPACEABLE_SHORT_3 = new HashSet<>(Arrays.asList("x449", "x450", "x451", "x452"));

    public static OnixMetadata parse(OnixVersion onixVersion, boolean isShort, String mainXsd, String codelistXsd,
                                     Set<String> spaceables, String specHtml)
        throws IOException, ParserConfigurationException, SAXException {
        Document codelistDoc = docOf(codelistXsd);
        Document mainDoc = docOf(mainXsd);

        final Parser parser = new Parser(onixVersion, isShort, spaceables);
        parser.analyzeSchema(codelistDoc);
        parser.analyzeSchema(mainDoc);
        parser.postAnalysis(specHtml);

        LOGGER.info(">>> Successfully processed " + mainXsd);

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
