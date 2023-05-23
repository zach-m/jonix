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
import com.tectonica.jonix.common.codelist.ProductForms;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.json.JonixJson;
import com.tectonica.jonix.onix3.DescriptiveDetail;
import com.tectonica.jonix.unify.BaseUnifier;
import com.tectonica.jonix.unify.JonixUnifier;
import com.tectonica.jonix.unify.base.BaseDescription;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.BaseTitle;
import com.tectonica.jonix.unify.base.onix2.BaseDescription2;
import com.tectonica.jonix.unify.base.onix2.BaseFactory2;
import com.tectonica.jonix.unify.base.onix2.BaseTitle2;
import com.tectonica.jonix.unify.base.onix3.BaseDescription3;
import com.tectonica.jonix.unify.base.onix3.BaseFactory3;
import com.tectonica.jonix.unify.base.onix3.BaseTitle3;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCustomUnifier {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestCustomUnifier.class);

    @After
    public void tearDown() {
        LOGGER.debug("***********************************************************************************");
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
            .forEach(record -> LOGGER.debug(JonixJson.toJson(record.product)));
    }

    @Test
    public void testCustomUnifier() {
        String onix3Resource = "/samples/onix3-multiple.xml";
        Jonix.source(getClass().getResourceAsStream(onix3Resource)).streamUnified(MyUnifier.unifier)
            .forEach(record -> LOGGER.debug(JonixJson.toJson(record.product)));
        Jonix.source(getClass().getResourceAsStream(onix3Resource)).streamUnified(MyUnifierExtendingBase.unifier)
            .forEach(record -> LOGGER.debug(JonixJson.toJson(record.product)));
    }
}
