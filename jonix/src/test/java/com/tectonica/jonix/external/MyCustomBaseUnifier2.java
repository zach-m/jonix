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

import com.tectonica.jonix.common.codelist.ProductForms;
import com.tectonica.jonix.unify.BaseUnifier;
import com.tectonica.jonix.unify.CustomUnifier;
import com.tectonica.jonix.unify.base.BaseDescription;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.BaseTitle;
import com.tectonica.jonix.unify.base.onix2.BaseDescription2;
import com.tectonica.jonix.unify.base.onix2.BaseFactory2;
import com.tectonica.jonix.unify.base.onix2.BaseTitle2;
import com.tectonica.jonix.unify.base.onix3.BaseDescription3;
import com.tectonica.jonix.unify.base.onix3.BaseFactory3;
import com.tectonica.jonix.unify.base.onix3.BaseTitle3;

/**
 * This class demonstrates how to write a {@link CustomUnifier} for your own needs, adding to the existing fields
 * extracted by {@link BaseProduct}. The approach presented here is "surgical", allowing you to extend specific
 * {@code Base*} classes held by the container {@link BaseProduct}. This way, the various fields that you extract from
 * the source can be scattered in several {@code Base} classes, and not only under {@link BaseProduct}. This approach
 * also allows to build modular unifiers, mixing-and-matched different replacement of {@code Base*} classes.
 * <p>
 * In particular, this exemplary class modifies {@link BaseDescription} and {@link BaseTitle}, using two slightly
 * different Java syntaxes.
 * <p>
 * Once defined, the Unifier can be used as a stream of Unified objects (of type {@link BaseProduct}), e.g.:
 * <pre>
 * Jonix.source(...).streamUnified(MyUnifierModifyingBase.unifier).forEach(record -> ...)
 * </pre>
 */
public class MyCustomBaseUnifier2 {
    static final BaseFactory2 factory2 = new BaseFactory2();
    static final BaseFactory3 factory3 = new BaseFactory3();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Custom extension to BaseDescription (add the field productFormCode), using verbose syntax.
    //
    // NOTE: The 3 classes below are typically stored in different file(s), making the organization modular
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static class MyDescription extends BaseDescription {
        public String productFormCode;
    }

    public static class MyDescription2 extends MyDescription {
        MyDescription2(com.tectonica.jonix.onix2.Product product) {
            BaseDescription2.extract(product, this);
            productFormCode = product.productForm().value().map(fv -> fv.code).orElse(null);
        }
    }

    public static class MyDescription3 extends MyDescription {
        MyDescription3(com.tectonica.jonix.onix3.Product product) {
            BaseDescription3.extract(product, this);
            productFormCode = product.descriptiveDetail().productForm().value().map(ProductForms::getCode).orElse(null);
        }
    }

    static {
        factory2.setBaseDescriptionFactory(MyDescription2::new);
        factory3.setBaseDescriptionFactory(MyDescription3::new);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Custom extension to BaseTitle (add the field titlePrefix), using concise (anonymous classes) syntax
    //
    // NOTE: the class and the static-block below are intended for minor extensions. It's not a modular syntax.
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static class MyTitle extends BaseTitle {
        public String titlePrefix;
    }

    static {
        factory2.setBaseTitleFactory(title -> new MyTitle() {{
            BaseTitle2.extract(title, this); // first parse whatever BaseTitle2 was parsing
            titlePrefix = title.titlePrefix().value;
        }});
        factory3.setBaseTitleFactory(title -> new MyTitle() {{
            BaseTitle3.extract(title, this); // first parse whatever BaseTitle3 was parsing
            titlePrefix = title.titleElements().get(0).titlePrefix().value;
        }});
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // the BaseUnifier to use for unification
    // IMPORTANT: must be at the BOTTOM of this class!
    public static BaseUnifier unifier = new BaseUnifier(factory2, factory3);
}
