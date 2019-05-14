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

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public class TestSingleOnix {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestSingleOnix.class);

    @Test
    public void testSingleOnix2() {
        testViaAPI("/single-book-onix2.xml", 3241, OnixVersion.ONIX2);
        testViaDOM("/single-book-onix2.xml", 3241, OnixVersion.ONIX2);
    }

    @Test
    public void testSingleOnix3() {
        testViaAPI("/single-book-onix3-short.xml", 16021, OnixVersion.ONIX3);
        testViaAPI("/single-book-onix3.xml", 16021, OnixVersion.ONIX3);
        testViaDOM("/single-book-onix3.xml", 16021, OnixVersion.ONIX3);
    }

    private void testViaAPI(String xmlResourceName, int expectedLength, OnixVersion expectedOnixVersion) {
        InputStream source = getClass().getResourceAsStream(xmlResourceName);
        boolean entered = false;
        for (JonixRecord record : Jonix.source(source)) {
            Assert.assertFalse(entered); // there should be exactly one product in the file
            entered = true;
            assertEquals(expectedOnixVersion, record.source.onixVersion);

            String json = JonixJson.productToJson(record.product, false);
            LOGGER.debug("API: {}", json); // or: JonixJson.productToJson(record.product);
            assertEquals(expectedLength, json.length());
        }
    }

    private void testViaDOM(String xmlResourceName, int expectedLength, OnixVersion expectedOnixVersion) {
        final Document doc = docOf(xmlResourceName);
        final NodeList products = doc.getElementsByTagName("Product");
        assertEquals(products.getLength(), 1);

        final Element productElem = (Element) products.item(0);
        final OnixProduct product;
        if (expectedOnixVersion == OnixVersion.ONIX2) {
            product = new com.tectonica.jonix.onix2.Product(productElem);
        } else {
            product = new com.tectonica.jonix.onix3.Product(productElem);
        }

        String json = JonixJson.productToJson(product, false);
        LOGGER.debug("DOM: {}", json); // or: JonixJson.productToJson(product);
        assertEquals(expectedLength, json.length());
    }

    private Document docOf(String xmlResourceName) {
        try (InputStream is = getClass().getResourceAsStream(xmlResourceName)) {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilderFactory.setCoalescing(true); // required for Jonix classes to properly process CDATA nodes
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            // disable dtd validation
            docBuilder.setEntityResolver((publicId, systemId) -> new InputSource(new StringReader("")));
            return docBuilder.parse(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
