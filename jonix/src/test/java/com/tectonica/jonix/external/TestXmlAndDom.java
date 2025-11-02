/*
 * Copyright (C) 2012-2025 Zach Melamed
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

package com.tectonica.jonix.external;

import com.tectonica.jonix.Jonix;
import com.tectonica.jonix.JonixRecord;
import com.tectonica.jonix.common.OnixProduct;
import com.tectonica.jonix.common.OnixVersion;
import com.tectonica.jonix.common.codelist.PublishingDateRoles;
import com.tectonica.jonix.common.codelist.SupplyDateRoles;
import com.tectonica.jonix.json.JonixJson;
import com.tectonica.jonix.onix2.OnSaleDate;
import com.tectonica.jonix.onix2.SupplyDetail;
import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.onix2.BaseProduct2;
import com.tectonica.xmlchunk.XmlChunker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class TestXmlAndDom {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestXmlAndDom.class);

    private static final String PRODUCT_REF = com.tectonica.jonix.onix2.Product.refname;
    private static final String PRODUCT_SHORT = com.tectonica.jonix.onix2.Product.shortname;

    @After
    public void tearDown() {
        LOGGER.debug("***********************************************************************************");
    }

    @Test
    public void testSingleOnix2() {
        testViaAPI("/single-book-onix2.xml", 3285, OnixVersion.ONIX2);
        testViaDOM("/single-book-onix2.xml", 3285, OnixVersion.ONIX2);
    }

    @Test
    public void testSingleOnix3() {
        testViaAPI("/single-book-onix3-short.xml", 16127, OnixVersion.ONIX3);
        testViaAPI("/single-book-onix3.xml", 16127, OnixVersion.ONIX3);
        testViaDOM("/single-book-onix3.xml", 16127, OnixVersion.ONIX3);
    }

    private void testViaAPI(String xmlResourceName, int expectedLength, OnixVersion expectedOnixVersion) {
        InputStream source = getClass().getResourceAsStream(xmlResourceName);
        boolean entered = false;
        for (JonixRecord record : Jonix.source(source)) {
            //codeSnippet(record);
            Assert.assertFalse(entered); // there should be exactly one product in the file
            entered = true;
            assertEquals(expectedOnixVersion, record.source.onixVersion());

            String json = JonixJson.toJson(record.product, false);
            //System.out.println("------------------------------------------------------");
            //System.out.println(json);
            //System.out.println("------------------------------------------------------");
            LOGGER.debug("API: {}", json); // or: JonixJson.productToJson(record.product);
            assertEquals(expectedLength, json.length());
        }
    }

    private void codeSnippet(JonixRecord record) {
        List<String> allDates = new ArrayList<>();
        boolean isOnix3 = record.product instanceof Product;
        if (isOnix3) {
            com.tectonica.jonix.onix3.Product p3 = (com.tectonica.jonix.onix3.Product) record.product;
            // PublishingDetail/PublishingDate[PublishingDateRole='02']/Date
            p3.publishingDetail().publishingDates().find(PublishingDateRoles.Sales_embargo_date)
                .map(pd -> pd.date().value).ifPresent(allDates::add);
            // ProductSupply/SupplyDetail/SupplyDate[SupplyDateRole='02']/Date
            // ProductSupply/SupplyDetail/SupplyDate[SupplyDateRole='08']/Date
            p3.productSupplys().forEach(ps -> ps.supplyDetails().forEach(sp -> sp.supplyDates()
                .findAll(SupplyDateRoles.Sales_embargo_date, SupplyDateRoles.Expected_availability_date)
                .forEach(sd -> allDates.add(sd.date().value))));
        } else { // ONIX2
            // SupplyDetail/OnSaleDate
            com.tectonica.jonix.onix2.Product p2 = (com.tectonica.jonix.onix2.Product) record.product;
            allDates.addAll(p2.supplyDetails().stream().map(SupplyDetail::onSaleDate).filter(OnSaleDate::exists)
                .map(osd -> osd.value).collect(Collectors.toList()));
        }
        System.out.println(allDates);
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

        String json = JonixJson.toJson(product, false);
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

    @Test
    public void readSingleProductOfOnix2() {
        InputStream stream = getClass().getResourceAsStream("/single-book-onix2.xml");

        XmlChunker.parse(stream, "UTF-8", 2, new XmlChunker.Listener() {

            @Override
            public void onPreTargetStart(int depth, StartElement element) {
                final Attribute release = element.getAttributeByName(new QName("release"));
                boolean isOnix2 = (release == null || release.getValue().startsWith("2"));
                if (!isOnix2) {
                    throw new RuntimeException("this test is suitable for Onix2");
                }
            }

            @Override
            public boolean onChunk(Element element) {
                final String nodeName = element.getNodeName();
                if (nodeName.equals(PRODUCT_REF) || nodeName.equals(PRODUCT_SHORT)) {
                    // run the auto-generated code for low-level parsing of an Onix2 <Product> record
                    final com.tectonica.jonix.onix2.Product product = new com.tectonica.jonix.onix2.Product(element);
                    // create a unified-version of the product
                    final BaseProduct bp = new BaseProduct2(product);
                    LOGGER.debug("RAW ONIX2  --------------------------------------------------------------");
                    LOGGER.debug(JonixJson.toJson(product, false));
                    LOGGER.debug("BASIC ONIX2  ------------------------------------------------------------");
                    LOGGER.debug(JonixJson.toJson(bp));
                }
                return true;
            }
        });
    }
}
