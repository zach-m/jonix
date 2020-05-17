/*
 * Copyright (C) 2012 Zach Melamed
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
        extract(product, this);
    }

    public static void extract(Product product, BaseProduct dest) {
        dest.rawProduct = product;

        dest.info = new BaseInfo2(product);
        dest.description = new BaseDescription2(product);
        dest.publishingDetails = new BasePublishingDetails2(product);
        dest.titles = new BaseTitles2(product);
        dest.contributors = new BaseContributors2(product);
        dest.collections = new BaseCollections2(product);
        dest.subjects = new BaseSubjects2(product);
        dest.texts = new BaseTexts2(product);
        dest.publishers = new BasePublishers2(product);
        dest.imprints = new BaseImprints2(product);
        dest.supplyDetails = new BaseSupplyDetails2(product);
        dest.salesRightss = new BaseSalesRightss2(product);
    }
}
