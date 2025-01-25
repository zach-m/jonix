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
import com.tectonica.jonix.JonixRecords;
import com.tectonica.jonix.common.OnixVersion;
import com.tectonica.jonix.common.codelist.ContributorRoles;
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.PriceTypes;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.ResourceContentTypes;
import com.tectonica.jonix.common.codelist.ResourceForms;
import com.tectonica.jonix.common.codelist.TitleTypes;
import com.tectonica.jonix.unify.base.BasePrice;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.util.JonixUtil;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestReadMeCode {
    @Test
    @Ignore
    public void test1() {
        Jonix
            //.source(new File("./src/test/resources/Onix3.1-single-ref.xml"))
            .source(new File("C:\\DEV-ZACH\\Jonix\\jonix\\jonix\\src\\test\\resources\\samples"), "*.xml", false) //
            .onSourceStart(src -> {
                // after the <Header> of the current ONIX source has been processed, we take a look at the source properties
                System.out.printf(">> Opening %s (ONIX release %s)%n", src.sourceName(), src.onixRelease());
                src.header().map(Jonix::toBaseHeader)
                    .ifPresent(header -> System.out.printf(">> Sent from: %s%n", header.senderName));
            }).onSourceEnd(src -> {
                // we finalize the processing of the ONIX source
                System.out.printf("<< Processed %d products (total %d) %n", src.productCount(), src.productGlobalCount());
            }).stream() // iterates over all the products contained in all ONIX sources
            .map(
                Jonix::toBaseProduct) // transforms any ONIX-2 or ONIX-3 product into a unified, version-agnostic, object
            .forEach(product -> {
                String ref = product.info.recordReference;
                String isbn13 = product.info.findProductId(ProductIdentifierTypes.ISBN_13);
                String title = product.titles.findTitleText(TitleTypes.Distinctive_title_book);
                List<String> authors = product.contributors.getDisplayNames(ContributorRoles.By_author);

                System.out.println("ref                 = " + ref);
                System.out.println("isbn13              = " + isbn13);
                System.out.println("title               = " + title);
                System.out.println("authors             = " + authors);
                System.out.println("--------------------------------------------------------------------------------");
            });
    }

    @Test
    @Ignore
    public void test2() {
        Jonix
            //.source(new File("./src/test/resources/Onix3.1-single-ref.xml"))
            .source(new File("C:\\DEV-ZACH\\Jonix\\jonix\\jonix\\src\\test\\resources\\samples"), "onix*.xml", false) //
            .onSourceStart(src -> {
                // safeguard: we skip ONIX-2 files
                if (src.onixVersion() == OnixVersion.ONIX2) {
                    src.skipSource();
                }
            }).onSourceEnd(src -> {
                System.out.printf("<< Processed %d products from %s %n", src.productCount(), src.sourceName());
            }).stream() // iterate over the products contained in all ONIX sources
            .map(Jonix::toProduct3).forEach(product -> {
                // take the information you need from the current product
                String ref = product.recordReference().value;

                String isbn13 =
                    product.productIdentifiers().find(ProductIdentifierTypes.ISBN_13).map(pi -> pi.idValue().value)
                        .orElse(null);

                String title = product.descriptiveDetail().titleDetails()
                    .filter(td -> td.titleType().value == TitleTypes.Distinctive_title_book).firstOrEmpty().titleElements()
                    .firstOrEmpty().titleWithoutPrefix().value;

                List<String> authors = product.descriptiveDetail().contributors()
                    .filter(c -> c.contributorRoles().values().contains(ContributorRoles.By_author)).stream().map(
                        c -> c.personName().value().orElse(
                            c.nameIdentifiers().find(NameIdentifierTypes.Proprietary).flatMap(ni -> ni.idTypeName().value())
                                .orElse("N/A"))).collect(Collectors.toList());

                String frontCoverImageLink = product.collateralDetail().supportingResources()
                    .filter(sr -> sr.resourceContentType().value == ResourceContentTypes.Front_cover).firstOrEmpty()
                    .resourceVersions().filter(rv -> rv.resourceForm().value == ResourceForms.Downloadable_file).first()
                    .map(rv -> rv.resourceLinks().firstValueOrNull()).orElse(null);

                System.out.println("ref                 = " + ref);
                System.out.println("isbn13              = " + isbn13);
                System.out.println("title               = " + title);
                System.out.println("authors             = " + authors);
                System.out.println("frontCoverImageLink = " + frontCoverImageLink);
                System.out.println("--------------------------------------------------------------------------------");
            });
    }

    @Test
    @Ignore
    public void test3() {
        Jonix.source(new File("C:\\DEV-ZACH\\Jonix\\jonix\\jonix\\src\\test\\resources\\samples"), "onix*.xml", false)
            .stream().forEach(record -> {
                if (record.product.onixVersion() == OnixVersion.ONIX2) {
                    com.tectonica.jonix.onix2.Product product = Jonix.toProduct2(record);
                    // TODO: write ONIX-2 specific code
                } else {
                    com.tectonica.jonix.onix3.Product product = Jonix.toProduct3(record);
                    // TODO: write ONIX-3 specific code
                }
            });
    }

    @Test
    @Ignore
    public void test4() {
        // the following is a set of the price-types we will look for in the ONIX records
        Set<PriceTypes> requestedPrices = JonixUtil.setOf(PriceTypes.RRP_including_tax, PriceTypes.RRP_excluding_tax);

        JonixRecords records =
            Jonix.source(new File("C:\\DEV-ZACH\\Jonix\\jonix\\jonix\\src\\test\\resources\\samples"), "onix*.xml",
                false);

        // we start going over the ONIX records, looking the Unified version of them
        records.streamUnified().forEach(rec -> {
            BaseProduct product = rec.product;
            String title = product.titles.findTitleText(TitleTypes.Distinctive_title_book);
            List<String> authors = product.contributors.getDisplayNames(ContributorRoles.By_author);
            List<BasePrice> prices = product.supplyDetails.findPrices(requestedPrices);
            List<String> priceLabels = prices.stream().map(bp -> bp.priceAmountAsStr + " " + bp.currencyCode.code)
                .collect(Collectors.toList());
            System.out.printf("The book '%s' by %s costs: %s%n", title, authors, priceLabels);
            //if (rec.source.productGlobalCount() == 10) {
            //    rec.breakStream();
            //    System.out.println("BREAKING");
            //}
        });
    }

    @Test
    @Ignore
    public void test5() {
        JonixRecords jonixRecords =
            Jonix.source(new File("C:\\DEV-ZACH\\Jonix\\jonix\\jonix\\src\\test\\resources\\samples"), "onix*.xml",
                    false) //
                .onSourceStart(src -> System.out.printf("%s [%s]%n", src.sourceName(), src.onixRelease()));
        jonixRecords.scanHeaders();
        System.out.println("----------------------------------------------------------------------------------");
        jonixRecords.stream().map(Jonix::toBaseProduct).forEach(p -> System.out.println(p.info.recordReference));
    }
}
