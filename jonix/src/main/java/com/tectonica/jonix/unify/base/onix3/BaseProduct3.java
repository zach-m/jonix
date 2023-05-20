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

package com.tectonica.jonix.unify.base.onix3;

import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.unify.base.BaseProduct;

/**
 * ONIX3 concrete implementation for {@link BaseProduct}
 *
 * @author Zach Melamed
 */
public class BaseProduct3 extends BaseProduct {
    private static final long serialVersionUID = 1L;

    public BaseProduct3(Product product) {
        this(product, BaseFactory3.DEFAULT);
    }

    public BaseProduct3(Product product, BaseFactory3 factory) {
        extract(product, this, factory);
    }

    public static void extract(Product product, BaseProduct dest) {
        extract(product, dest, BaseFactory3.DEFAULT);
    }

    public static void extract(Product product, BaseProduct dest, BaseFactory3 factory) {
        dest.info = factory.baseInfoFactory.apply(product);
        dest.description = factory.baseDescriptionFactory.apply(product);
        dest.publishingDetails = factory.basePublishingDetailsFactory.apply(product);
        dest.titles = new BaseTitles3(product, factory);
        dest.contributors = new BaseContributors3(product, factory);
        dest.collections = new BaseCollections3(product, factory);
        dest.subjects = new BaseSubjects3(product, factory); // TODO: map, not list, factory not effective
        dest.texts = new BaseTexts3(product, factory);
        dest.publishers = new BasePublishers3(product, factory);
        dest.imprints = new BaseImprints3(product, factory);
        dest.supplyDetails = new BaseSupplyDetails3(product, factory);
        dest.salesRightss = new BaseSalesRightss3(product, factory);
    }
}
