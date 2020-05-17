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
        extract(product, this);
    }

    public static void extract(Product product, BaseProduct dest) {
        dest.rawProduct = product;

        dest.info = new BaseInfo3(product);
        dest.description = new BaseDescription3(product);
        dest.publishingDetails = new BasePublishingDetails3(product);
        dest.titles = new BaseTitles3(product);
        dest.contributors = new BaseContributors3(product);
        dest.collections = new BaseCollections3(product);
        dest.subjects = new BaseSubjects3(product);
        dest.texts = new BaseTexts3(product);
        dest.publishers = new BasePublishers3(product);
        dest.imprints = new BaseImprints3(product);
        dest.supplyDetails = new BaseSupplyDetails3(product);
        dest.salesRightss = new BaseSalesRightss3(product);
    }
}
