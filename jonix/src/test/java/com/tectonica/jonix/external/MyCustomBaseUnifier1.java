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
import com.tectonica.jonix.common.codelist.ProductForms;
import com.tectonica.jonix.unify.CustomUnifier;
import com.tectonica.jonix.unify.UnifiedRecord;
import com.tectonica.jonix.unify.base.BaseHeader;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.onix2.BaseHeader2;
import com.tectonica.jonix.unify.base.onix2.BaseProduct2;
import com.tectonica.jonix.unify.base.onix3.BaseHeader3;
import com.tectonica.jonix.unify.base.onix3.BaseProduct3;

/**
 * This class demonstrates how to write a {@link CustomUnifier} for your own needs, adding to the existing fields
 * extracted by {@link BaseProduct}.The approach presented here is simplistic and meant for small additions in to the
 * {@link BaseProduct} class. All the added fields will be held by the {@link BaseProduct} itself, which we subclass
 * directly. If you want a higher granularity, i.e. scatter the extracted fields to the various {@code Base*} classes,
 * take a look at {@link MyCustomBaseUnifier2}.
 * <p>
 * Make sure to put your code in the 3 places where the comments indicate {@code TODO}. It is also advised to separate
 * {@code MyBaseProduct}, {@code MyBaseProduct2} and {@code MyBaseProduct3} to separate files.
 * <p>
 * Once defined, the Unifier can be used as a stream of Unified objects (i.e. of type {@code MyBaseProduct}), e.g.:
 * <pre>
 * Jonix.source(...).streamUnified(MyUnifierExtendingBase.unifier).forEach(record -> ...)
 * </pre>
 */
public class MyCustomBaseUnifier1
    implements CustomUnifier<MyCustomBaseUnifier1.MyBaseProduct, BaseHeader, MyCustomBaseUnifier1.MyBaseRecord> {

    public static final MyCustomBaseUnifier1 unifier = new MyCustomBaseUnifier1();

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // USER CODE - REPLACE THE TODOs in BASE-CLASS AND TWO SUB-CLASSES
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static class MyBaseProduct extends BaseProduct {
        // TODO declare unified fields, for example:

        public String productFormCode;
    }

    public static class MyBaseProduct2 extends MyBaseProduct {
        public MyBaseProduct2(com.tectonica.jonix.onix2.Product product) {
            BaseProduct2.extract(product, this);

            // TODO populate fields of base-class. In our example:

            productFormCode = product.productForm().value().map(fv -> fv.code).orElse(null);
        }
    }

    public static class MyBaseProduct3 extends MyBaseProduct {
        public MyBaseProduct3(com.tectonica.jonix.onix3.Product product) {
            BaseProduct3.extract(product, this);

            // TODO populate fields of base-class. In our example:

            productFormCode = product.descriptiveDetail().productForm().value().map(ProductForms::getCode).orElse(null);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // BOILERPLATE CODE - NO NEED TO CHANGE ANYTHING
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static class MyBaseRecord extends UnifiedRecord<MyBaseProduct> {
        public MyBaseRecord(JonixSource source, MyBaseProduct product) {
            super(source, product);
        }
    }

    @Override
    public MyBaseRecord unifiedRecord(JonixRecord record) {
        return new MyBaseRecord(record.source, unifiedProduct(record.product));
    }

    @Override
    public MyBaseProduct extractProduct2(com.tectonica.jonix.onix2.Product onixProduct2) {
        return new MyBaseProduct2(onixProduct2);
    }

    @Override
    public MyBaseProduct extractProduct3(com.tectonica.jonix.onix3.Product onixProduct3) {
        return new MyBaseProduct3(onixProduct3);
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
