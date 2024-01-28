/*
 * Copyright (C) 2012-2024 Zach Melamed
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
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.external.MyCustomBaseUnifier2.MyDescription;
import com.tectonica.jonix.external.MyCustomBaseUnifier2.MyTitle;
import com.tectonica.jonix.json.JonixJson;
import com.tectonica.jonix.unify.JonixUnifier;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.BaseTitle;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCustomUnifier {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestCustomUnifier.class);

    @Test
    public void testAllCustomUnifiers() {
        String onix3Resource = "/samples/onix3-multiple.xml";
        Jonix.source(getClass().getResourceAsStream(onix3Resource)).streamUnified(MyCustomUnifier.unifier)
            .forEach(record -> LOGGER.debug(JonixJson.toJson(record.product)));
        Jonix.source(getClass().getResourceAsStream(onix3Resource)).streamUnified(MyCustomBaseUnifier1.unifier)
            .forEach(record -> LOGGER.trace(JonixJson.toJson(record.product)));
        Jonix.source(getClass().getResourceAsStream(onix3Resource)).streamUnified(MyCustomBaseUnifier2.unifier)
            .forEach(record -> LOGGER.trace(JonixJson.toJson(record.product)));
    }

    @Test
    public void testCustomFactories() {
        String onix3Resource = "/single-book-onix3.xml";

        // pass 1: stream-based + JSON
        Jonix.source(getClass().getResourceAsStream(onix3Resource))
            .streamUnified(MyCustomBaseUnifier2.factory2, MyCustomBaseUnifier2.factory3)
            .forEach(record -> LOGGER.debug(JonixJson.toJson(record.product)));

        // pass 2: iterator-based (verbose and manual approach)
        for (JonixRecord record : Jonix.source(getClass().getResourceAsStream(onix3Resource))) {
            BaseProduct product = JonixUnifier.unifyProduct(record.product, MyCustomBaseUnifier2.unifier);
            String isbn13 = product.info.findJonixProductId(ProductIdentifierTypes.ISBN_13).idValue;
            LOGGER.debug("Custom fields for ISBN " + isbn13);
            Assert.assertTrue(product.description instanceof MyDescription);
            LOGGER.debug("ProductFormCode=" + ((MyDescription) product.description).productFormCode);
            for (BaseTitle title : product.titles) {
                Assert.assertTrue(title instanceof MyTitle);
                LOGGER.debug("Prefix=" + ((MyTitle) title).titlePrefix);
            }
        }
    }
}
