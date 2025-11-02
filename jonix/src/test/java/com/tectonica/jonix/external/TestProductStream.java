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
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.ResourceContentTypes;
import com.tectonica.jonix.common.codelist.ResourceForms;
import com.tectonica.jonix.common.codelist.ResourceVersionFeatureTypes;
import com.tectonica.jonix.common.codelist.SupportingResourceFileFormats;
import com.tectonica.jonix.json.JonixJson;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.onix3.BaseProduct3;
import com.tectonica.xmlchunk.XmlChunker;
import org.junit.After;
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
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestProductStream {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestProductStream.class);

    private static final String PRODUCT_REF = com.tectonica.jonix.onix2.Product.refname;
    private static final String PRODUCT_SHORT = com.tectonica.jonix.onix2.Product.shortname;

    @After
    public void tearDown() {
        LOGGER.debug("***********************************************************************************");
    }

    private String baseViaXml = null;
    private String baseViaStream = null;

    @Test
    public void readSingleProductOfOnix3AlsoAsStream() {
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
                    LOGGER.debug(JonixJson.toJson(product, false));
                    LOGGER.debug("BASIC ONIX3  ------------------------------------------------------------");
                    LOGGER.debug(baseViaXml = JonixJson.toJson(bp));
                }
                return true;
            }

        });

        // read the same file, this time using a JonixReader
        Jonix.source(getClass().getResourceAsStream(onix3Resource)).streamUnified().limit(1)
            .forEach(record -> baseViaStream = JonixJson.toJson(record.product));

        // compare the JSON received in both methods
        assertEquals(baseViaXml, baseViaStream);
    }

    @Test
    public void readSingleProductOfOnix31_Ref_Short() {
        String onix31_ref = "/Onix3.1-single-ref.xml";
        String onix31_short = "/Onix3.1-single-short.xml";
        String refJson = Jonix.source(getClass().getResourceAsStream(onix31_ref))
            .onSourceStart(src -> assertEquals(src.onixRelease(), "3.1")).stream()
            .map(record -> JonixJson.toJson(record.product)).findFirst().orElse(null);
        String shortJson = Jonix.source(getClass().getResourceAsStream(onix31_short)).stream()
            .map(record -> JonixJson.toJson(record.product)).findFirst().orElse(null);
        //System.out.println(refJson);
        //System.out.println(shortJson);
        assertEquals(refJson, shortJson);
    }

    @Test
    public void testNullFreeDive() {
        String onix31_ref = "/Onix3.1-single-ref.xml";
        Jonix.source(getClass().getResourceAsStream(onix31_ref)).stream().findFirst().map(r -> r.product)
            .map(Jonix::toProduct3).ifPresent(product -> {
                System.out.println(product.onixVersion() + " ; " + product.onixRelease());

                // lookup using matching() and firstOrEmpty()
                String coverLink = product.collateralDetail().supportingResources()
                    .filter(sr -> sr.resourceContentType().value == ResourceContentTypes.Front_cover).firstOrEmpty()
                    .resourceVersions().filter(rv -> rv.resourceForm().value == ResourceForms.Downloadable_file).first()
                    .map(rv -> rv.resourceLinks().firstValueOrNull()).orElse(null);

                // look for non-existing value
                String md5_hash =
                    product.collateralDetail().supportingResources().firstOrEmpty().resourceVersions().firstOrEmpty()
                        .resourceVersionFeatures().findOrEmpty(ResourceVersionFeatureTypes.MD5_hash_value)
                        .featureValue().value;

                // look for non-existing value
                NameIdentifierTypes clearlyNull =
                    product.descriptiveDetail().contributors().firstOrEmpty().alternativeNames().firstOrEmpty()
                        .nameIdentifiers().findAll(NameIdentifierTypes.SAN).firstOrEmpty().nameIDType().value;

                //System.out.println(coverLink);
                //System.out.println(SupportingResourceFileFormats.codeToDesciption(md5_hash));
                //System.out.println(clearlyNull);
                assertNotNull(coverLink);
                assertNull(SupportingResourceFileFormats.codeToDesciption(md5_hash));
                assertNull(clearlyNull);
            });
    }

    static class Target {
        public List<String> jsons;
        private Path jsonFilePath;

        void setJsonPath(File xmlFile) {
            this.jsonFilePath = new File(xmlFile.getAbsolutePath().replace(".xml", ".json")).toPath();
        }

        void readJson(File xmlFile) {
            this.setJsonPath(xmlFile);
            try (Stream<String> lines = Files.lines(this.jsonFilePath)) {
                jsons = lines.collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        void createJsonFile(File xmlFile) {
            this.setJsonPath(xmlFile);
            try {
                Files.deleteIfExists(this.jsonFilePath);
                Files.createFile(this.jsonFilePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        void appendToJsonFile(String json) {
            try {
                Files.write(this.jsonFilePath, (json + "\n").getBytes(), StandardOpenOption.APPEND);
                System.out.println("Added json to " + this.jsonFilePath.getFileName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void streamMultipleProducts() throws IOException {
        File folder = new File("./src/test/resources/samples");
        final Target target = new Target();

        Jonix.source(folder, "*.xml", false).onSourceStart(jonixSource -> {
            System.out.println("Validating " + jonixSource);
            assert jonixSource.file != null;
            target.readJson(jonixSource.file);
        }).stream().forEach(record -> {

            //BaseRecord baseRecord = JonixUnifier.unifyRecord(record);
            //String isbn13 = baseRecord.product.info.findProductId(ProductIdentifierTypes.ISBN_13);
            //String title = baseRecord.product.getLabel();
            //System.out.println(JonixJson.toJson(baseRecord.product));

            //System.out.println(record.productCount() +" | " + record.source.productCount());
            //if (record.productCount() == 10) {
            //    System.out.println("Breaking current source");
            //    record.breakCurrentSource();
            //} else if (record.productCount() == 30) {
            //    System.out.println("Breaking stream");
            //    record.breakStream();
            //}

            String json = JonixJson.toJson(record.product, false, true);
            String targetJson = target.jsons.get(0);
            //System.out.println(json);
            //System.out.println("ACTUAL:   " + json);
            //System.out.println("EXPECTED: " + targetJson);
            assertEquals("Difference in source " + record.source, targetJson.length(), json.length());
            assertEquals("Difference in source " + record.source, targetJson, json);
            target.jsons.remove(0);
        });
    }

    @Test
    @Ignore
    public void generateJsonFiles() {
        final Target target = new Target();
        List<String> fs = List.of("./src/test/resources/samples", "./src/test/resources");
        List<String> gs = List.of("*.xml", "single-book-*.xml");
        for (int i = 0; i < fs.size(); i++) {
            Jonix.source(new File(fs.get(i)), gs.get(i), false).onSourceStart(jonixSource -> {
                assert jonixSource.file != null;
                System.out.println("Converting " + jonixSource);
                target.createJsonFile(jonixSource.file);
            }).stream().forEach(record -> {
                String json = JonixJson.toJson(record.product, false, true);
                target.appendToJsonFile(json);
            });
        }
    }
}
