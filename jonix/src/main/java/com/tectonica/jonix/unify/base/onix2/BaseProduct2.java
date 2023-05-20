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

package com.tectonica.jonix.unify.base.onix2;

import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.unify.base.BaseProduct;

/**
 * ONIX2 concrete implementation for {@link BaseProduct}
 *
 * @author Zach Melamed
 */
public class BaseProduct2 extends BaseProduct {
    private static final long serialVersionUID = 1L;

    public BaseProduct2(Product product) {
        this(product, BaseFactory2.DEFAULT);
    }

    public BaseProduct2(Product product, BaseFactory2 factory) {
        extract(product, this, factory);
    }

    public static void extract(Product product, BaseProduct dest) {
        extract(product, dest, BaseFactory2.DEFAULT);
    }

    public static void extract(Product product, BaseProduct dest, BaseFactory2 factory) {
        dest.info = factory.baseInfoFactory.apply(product);
        dest.description = factory.baseDescriptionFactory.apply(product);
        dest.publishingDetails = factory.basePublishingDetailsFactory.apply(product);
        dest.titles = new BaseTitles2(product, factory);
        dest.contributors = new BaseContributors2(product, factory);
        dest.collections = new BaseCollections2(product, factory);
        dest.subjects = new BaseSubjects2(product, factory); // TODO: map, not list, factory not effective
        dest.texts = new BaseTexts2(product, factory);
        dest.publishers = new BasePublishers2(product, factory);
        dest.imprints = new BaseImprints2(product, factory);
        dest.supplyDetails = new BaseSupplyDetails2(product, factory);
        dest.salesRightss = new BaseSalesRightss2(product, factory);
    }
}
