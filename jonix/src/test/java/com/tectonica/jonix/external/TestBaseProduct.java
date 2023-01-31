/*
 * Copyright (C) 2012-2023 Zach Melamed
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
import com.tectonica.jonix.JonixSource;
import com.tectonica.jonix.common.codelist.ProductForms;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.json.JonixJson;
import com.tectonica.jonix.onix3.DescriptiveDetail;
import com.tectonica.jonix.unify.BaseUnifier;
import com.tectonica.jonix.unify.CustomUnifier;
import com.tectonica.jonix.unify.JonixUnifier;
import com.tectonica.jonix.unify.UnifiedRecord;
import com.tectonica.jonix.unify.base.BaseDescription;
import com.tectonica.jonix.unify.base.BaseHeader;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.BaseTitle;
import com.tectonica.jonix.unify.base.onix2.BaseDescription2;
import com.tectonica.jonix.unify.base.onix2.BaseFactory2;
import com.tectonica.jonix.unify.base.onix2.BaseHeader2;
import com.tectonica.jonix.unify.base.onix2.BaseProduct2;
import com.tectonica.jonix.unify.base.onix2.BaseTitle2;
import com.tectonica.jonix.unify.base.onix3.BaseDescription3;
import com.tectonica.jonix.unify.base.onix3.BaseFactory3;
import com.tectonica.jonix.unify.base.onix3.BaseHeader3;
import com.tectonica.jonix.unify.base.onix3.BaseProduct3;
import com.tectonica.jonix.unify.base.onix3.BaseTitle3;
import com.tectonica.xmlchunk.XmlChunker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class TestBaseProduct {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBaseProduct.class);

    private static final String PRODUCT_REF = com.tectonica.jonix.onix2.Product.refname;
    private static final String PRODUCT_SHORT = com.tectonica.jonix.onix2.Product.shortname;

    @After
    public void tearDown() {
        LOGGER.debug("***********************************************************************************");
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
                    LOGGER.debug(JonixJson.productToJson(product, false));
                    LOGGER.debug("BASIC ONIX2  ------------------------------------------------------------");
                    LOGGER.debug(JonixJson.objectToJson(bp));
                }
                return true;
            }

        });
    }

    private String jsonDirect = null;
    private String jsonViaReader = null;

    @Test
    public void readSingleProductOfOnix3AlsoWithReader() {
        String onix3Resource = "/single-book-onix3.xml";
        InputStream stream = getClass().getResourceAsStream(onix3Resource);

        XmlChunker.parse(stream, "UTF-8", 2, new XmlChunker.Listener() {

            @Override
            public void onPreTargetStart(int depth, StartElement element) {
                final Attribute release = element.getAttributeByName(new QName("release"));
                boolean isOnix2 = (release == null || release.getValue().startsWith("2"));
                if (isOnix2) {
                    throw new RuntimeException("this test is suitable for Onix3");
                }
            }

            @Override
            public boolean onChunk(Element element) {
                final String nodeName = element.getNodeName();
                if (nodeName.equals(PRODUCT_REF) || nodeName.equals(PRODUCT_SHORT)) {
                    final com.tectonica.jonix.onix3.Product product = new com.tectonica.jonix.onix3.Product(element);
                    BaseProduct bp = new BaseProduct3(product);
                    LOGGER.debug("RAW ONIX3  --------------------------------------------------------------");
                    LOGGER.debug(JonixJson.productToJson(product, false));
                    LOGGER.debug("BASIC ONIX3  ------------------------------------------------------------");
                    LOGGER.debug(jsonDirect = JonixJson.objectToJson(bp));
                }
                return true;
            }

        });

        // read the same file, this time using a JonixReader
        Jonix.source(getClass().getResourceAsStream(onix3Resource)).streamUnified().limit(1)
            .forEach(record -> jsonViaReader = JonixJson.objectToJson(record.product));

        // compare the JSON received in both methods
        assertEquals(jsonDirect, jsonViaReader);
    }

    @Test
    public void readMultipleProductsWithReader() throws IOException {
        File folder = new File("./src/test/resources/samples");
        class Target {
            public List<String> jsons;

            void readJson(String jsonFileName) {
                try (Stream<String> lines = Files.lines(new File(jsonFileName).toPath())) {
                    jsons = lines.collect(Collectors.toList());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        final Target target = new Target();
        Jonix.source(folder, "*.xml", false).onSourceStart(jonixSource -> {
                System.out.println("Validating " + jonixSource);
                assert jonixSource.file != null;
                target.readJson(jonixSource.file.getAbsolutePath().replace(".xml", ".json"));
            }).stream()
            .forEach(record -> {

                //BaseRecord baseRecord = JonixUnifier.unifyRecord(record);
                //String isbn13 = baseRecord.product.info.findProductId(ProductIdentifierTypes.ISBN_13);
                //String title = baseRecord.product.getLabel();
                //System.out.println(JonixJson.objectToJson(baseRecord.product));

                String json = JonixJson.productToJson(record.product, false);
                String targetJson = target.jsons.get(0);
                //System.out.println("ACTUAL:   " + json);
                //System.out.println("EXPECTED: " + targetJson);
                assertEquals("Difference in source " + record.source, targetJson.length(), json.length());
                target.jsons.remove(0);
            });
    }

    @Test
    public void testCustomFactories() {

        // example 1: extend class BaseTitle with the field titlePrefix (using succinct Java code)

        class MyTitle extends BaseTitle {
            public String titlePrefix;
        }
        BaseFactory2 factory2 = new BaseFactory2().setBaseTitleFactory(title -> new MyTitle() {{
            BaseTitle2.extract(title, this); // first parse whatever BaseTitle2 was parsing
            titlePrefix = title.titlePrefix().value;
        }});
        BaseFactory3 factory3 = new BaseFactory3().setBaseTitleFactory(title -> new MyTitle() {{
            BaseTitle3.extract(title, this); // first parse whatever BaseTitle3 was parsing
            titlePrefix = title.titleElements().get(0).titlePrefix().value;
        }});

        // example 2: extend BaseDescription with the field productFormCode (using more verbose Java code)

        class MyDescription extends BaseDescription {
            public String productFormCode;
        }
        class MyDescription2 extends MyDescription {
            MyDescription2(com.tectonica.jonix.onix2.Product product) {
                BaseDescription2.extract(product, this);
                productFormCode = product.productForm().value().map(fv -> fv.code).orElse(null);
            }
        }
        class MyDescription3 extends MyDescription {
            MyDescription3(com.tectonica.jonix.onix3.Product product) {
                BaseDescription3.extract(product, this);
                DescriptiveDetail dd = product.descriptiveDetail();
                if (dd.exists()) {
                    productFormCode = dd.productForm().value().map(ProductForms::getCode).orElse(null);
                }
            }
        }
        factory2.setBaseDescriptionFactory(MyDescription2::new);
        factory3.setBaseDescriptionFactory(MyDescription3::new);

        // test unified result
        String onix3Resource = "/single-book-onix3.xml";

        // pass 1: iterator-based (verbose and manual approach)
        BaseUnifier myUnifier = new BaseUnifier(factory2, factory3);
        for (JonixRecord record : Jonix.source(getClass().getResourceAsStream(onix3Resource))) {
            BaseProduct product = JonixUnifier.unifyProduct(record.product, myUnifier);
            String isbn13 = product.info.findJonixProductId(ProductIdentifierTypes.ISBN_13).idValue;
            LOGGER.debug("Custom fields for ISBN " + isbn13);
            Assert.assertTrue(product.description instanceof MyDescription);
            LOGGER.debug("ProductFormCode=" + ((MyDescription) product.description).productFormCode);
            for (BaseTitle title : product.titles) {
                Assert.assertTrue(title instanceof MyTitle);
                LOGGER.debug("Prefix=" + ((MyTitle) title).titlePrefix);
            }
        }

        // pass 2: stream-based + JSON
        Jonix.source(getClass().getResourceAsStream(onix3Resource)).streamUnified(factory2, factory3).limit(1)
            .forEach(record -> LOGGER.debug(JonixJson.objectToJson(record.product)));
    }

    @Test
    @Ignore
    public void testCustomUnifier() {
        class MyBaseProduct extends BaseProduct {
            public String extraFields;
        }

        class MyBaseProduct2 extends MyBaseProduct {
            public MyBaseProduct2(com.tectonica.jonix.onix2.Product product) {
                extraFields = "";
            }
        }
        class MyBaseProduct3 extends MyBaseProduct {
            public MyBaseProduct3(com.tectonica.jonix.onix3.Product product) {
                extraFields = "";
            }
        }
        class MyBaseRecord extends UnifiedRecord<MyBaseProduct> {
            public MyBaseRecord(JonixSource source, MyBaseProduct product) {
                super(source, product);
            }
        }
        class MyCustomUnifier implements CustomUnifier<MyBaseProduct, BaseHeader, MyBaseRecord> {
            @Override
            public MyBaseRecord unifiedRecord(JonixRecord record) {
                return new MyBaseRecord(record.source, unifiedProduct(record.product));
            }

            @Override
            public MyBaseProduct extractProduct2(com.tectonica.jonix.onix2.Product onixProduct2) {
                MyBaseProduct2 dest = new MyBaseProduct2(onixProduct2);
                BaseProduct2.extract(onixProduct2, dest);
                return dest;
            }

            @Override
            public MyBaseProduct extractProduct3(com.tectonica.jonix.onix3.Product onixProduct3) {
                MyBaseProduct3 dest = new MyBaseProduct3(onixProduct3);
                BaseProduct3.extract(onixProduct3, dest);
                return dest;
            }

            @Override
            public BaseHeader extractHeader2(com.tectonica.jonix.onix2.Header onixHeader) {
                return new BaseHeader2(onixHeader);
            }

            @Override
            public BaseHeader extractHeader3(com.tectonica.jonix.onix3.Header onixHeader) {
                return new BaseHeader3(onixHeader);
            }
        }

        String onix3Resource = "/single-book-onix3.xml";
        Jonix.source(getClass().getResourceAsStream(onix3Resource)).streamUnified(new MyCustomUnifier()).limit(1)
            .forEach(record -> LOGGER.debug(JonixJson.objectToJson(record.product)));
    }
}
