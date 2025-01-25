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

import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.TitleTypes;
import com.tectonica.jonix.common.struct.JonixTitle;
import com.tectonica.jonix.json.JonixJson;
import com.tectonica.jonix.onix2.Header;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.xmlchunk.XmlChunker;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

public class TestXmlChunkerWithProducts {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestXmlChunkerWithProducts.class);

    @Test
    @Ignore
    // ignored by default. the sample files are not checked in to SCM
    public void readProductsAndExtractProperties() throws FileNotFoundException {
        File samples = new File("..", "samples");
        if (!samples.exists()) {
            LOGGER.warn("Samples directory is missing: {}", samples.getAbsolutePath());
            LOGGER.warn("Skipping");
            return;
        }

        final File file = new File(samples, "onix-2/SB/SB.xml");
        if (!file.exists()) {
            throw new RuntimeException("couldn't found " + file.getAbsolutePath());
        }

        LOGGER.debug("Opening {}..", file.getAbsolutePath());

        XmlChunker.parse(new FileInputStream(file), "UTF-8", 2, new XmlChunker.Listener() {
            private int count = 0;

            @Override
            public boolean onChunk(Element element) {
                final String nodeName = element.getNodeName();
                if (nodeName.equals(Header.refname) || nodeName.equals(Header.shortname)) {
                    Header header = new Header(element);
                    System.out.println(header.fromCompany().value);
                } else if (nodeName.equals(Product.refname) || nodeName.equals(Product.shortname)) {
                    // parse a Product XML element into a corresponding Java structure
                    Product product = new Product(element);

                    // get some basic properties of the book
                    Optional<JonixTitle> title = product.titles().findAsStruct(TitleTypes.Distinctive_title_book);
                    String titleValue = title.map(t -> t.titleText).orElse("N/A");

                    String isbnValue = product.productIdentifiers().find(ProductIdentifierTypes.ISBN_13)
                        .map(pid -> pid.idValue().value).orElse("N/A");
                    String seriesPrefix =
                        product.seriess().isEmpty() ? "" : product.seriess().get(0).titleOfSeries().value + " / ";

                    // print
                    ++count;
                    LOGGER.debug(
                        String.format("#%04d: title='%s', isbn='%s'", count, seriesPrefix + titleValue, isbnValue));

                    // in rare cases where there is no title, we print the entire product record (as JSON)
                    if (!title.isPresent()) {
                        LOGGER.debug(JonixJson.toJson(product, false));
                    }
                }
                return true;
            }

            @Override
            public void onPreTargetStart(int depth, StartElement element) {
                final Attribute release = element.getAttributeByName(new QName("release"));
                boolean isOnix2 = (release == null || release.getValue().startsWith("2"));
                if (!isOnix2) {
                    throw new RuntimeException("this test is suitable for Onix2 only at this time");
                }
            }
        });

        LOGGER.debug("** DONE");
    }

    @Test
    @Ignore
    public void readProductsAndExtractPropertiesOnix3() throws FileNotFoundException {
        File samples = new File("..", "samples");
        if (!samples.exists()) {
            LOGGER.warn("Samples directory is missing: {}", samples.getAbsolutePath());
            LOGGER.warn("Skipping");
            return;
        }

        final File file = new File(samples, "onix-3/BQ.onix");
        if (!file.exists()) {
            throw new RuntimeException("couldn't found " + file.getAbsolutePath());
        }

        LOGGER.debug("Opening {}..", file.getAbsolutePath());

        XmlChunker.parse(new FileInputStream(file), "UTF-8", 2, new XmlChunker.Listener() {
            @Override
            public boolean onChunk(Element element) {
                final String nodeName = element.getNodeName();
                if (nodeName.equals(Header.refname) || nodeName.equals(Header.shortname)) {
                    com.tectonica.jonix.onix3.Header header = new com.tectonica.jonix.onix3.Header(element);
                    System.out.println(header.sender().senderName().value);
                    return false;
                }
                return true;
            }

            @Override
            public void onPreTargetStart(int depth, StartElement element) {
                final Attribute release = element.getAttributeByName(new QName("release"));
                boolean isOnix2 = (release == null || release.getValue().startsWith("2"));
                if (isOnix2) {
                    throw new RuntimeException("this test is suitable for Onix3 only at this time");
                }
            }
        });

        LOGGER.debug("** DONE");
    }
}
