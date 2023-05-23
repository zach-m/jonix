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

import com.tectonica.jonix.JonixRecord;
import com.tectonica.jonix.JonixSource;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.unify.CustomUnifier;
import com.tectonica.jonix.unify.UnifiedProduct;
import com.tectonica.jonix.unify.UnifiedRecord;
import com.tectonica.jonix.unify.base.BaseHeader;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.onix2.BaseHeader2;
import com.tectonica.jonix.unify.base.onix3.BaseHeader3;

/**
 * This class demonstrates how to write a {@link CustomUnifier} for your own needs from scratch. Using this approach you
 * can extract only the fields you're interested in. If, however, you're looking to start from the various fields
 * extracted by {@link BaseProduct} and then add a few of your own, take a look at {@link MyCustomBaseUnifier1} and
 * {@link MyCustomBaseUnifier2}.
 * <p>
 * Make sure to put your code in the 3 places where the comments indicate {@code TODO}. It is also advised to separate
 * {@code MyProduct}, {@code MyProduct2} and {@code MyProduct3} to separate files.
 * <p>
 * Once defined, the Unifier can be used as a stream of Unified objects (i.e. of type {@code MyProduct}), e.g.:
 * <pre>
 * Jonix.source(...).streamUnified(MyUnifer.unifier).forEach(record -> ...)
 * </pre>
 */
public class MyCustomUnifier implements CustomUnifier<MyCustomUnifier.MyProduct, BaseHeader, MyCustomUnifier.MyRecord> {

    public static final MyCustomUnifier unifier = new MyCustomUnifier(); // usage: Jonix.source().streamUnified(MyUnifer.unifier)

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // USER CODE - REPLACE THE TODOs in BASE-CLASS AND TWO SUB-CLASSES
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static class MyProduct extends UnifiedProduct {
        // TODO declare unified fields, for example:

        public String recordReference;
        public String isbn13;
        public String productForm;
    }

    public static class MyProduct2 extends MyProduct {
        public MyProduct2(com.tectonica.jonix.onix2.Product product) {
            // TODO populate fields of base-class. In our example:

            recordReference = product.recordReference().value;
            isbn13 = product.productIdentifiers().find(ProductIdentifierTypes.ISBN_13).map(pi -> pi.idValue().value)
                .orElse(null);
            productForm = product.productForm().value().map(pf -> pf.description).orElse(null);
        }
    }

    public static class MyProduct3 extends MyProduct {
        public MyProduct3(com.tectonica.jonix.onix3.Product product) {
            // TODO populate fields of base-class. In our example:

            recordReference = product.recordReference().value;
            isbn13 = product.productIdentifiers().find(ProductIdentifierTypes.ISBN_13).map(pi -> pi.idValue().value)
                .orElse(null);
            productForm = product.descriptiveDetail().productForm().value().map(pf -> pf.description).orElse(null);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // BOILERPLATE CODE - NO NEED TO CHANGE ANYTHING
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static class MyRecord extends UnifiedRecord<MyProduct> {
        public MyRecord(JonixSource source, MyProduct product) {
            super(source, product);
        }
    }

    @Override
    public MyRecord unifiedRecord(JonixRecord record) {
        return new MyRecord(record.source, unifiedProduct(record.product));
    }

    @Override
    public MyProduct extractProduct2(com.tectonica.jonix.onix2.Product onixProduct2) {
        return new MyProduct2(onixProduct2);
    }

    @Override
    public MyProduct extractProduct3(com.tectonica.jonix.onix3.Product onixProduct3) {
        return new MyProduct3(onixProduct3);
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
