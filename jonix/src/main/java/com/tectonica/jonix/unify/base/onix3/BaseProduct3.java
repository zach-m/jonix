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
        rawProduct = product;

        info = new BaseInfo3(product);
        description = new BaseDescription3(product);
        publishingDetails = new BasePublishingDetails3(product);
        titles = new BaseTitles3(product);
        contributors = new BaseContributors3(product);
        collections = new BaseCollections3(product);
        subjects = new BaseSubjects3(product);
        texts = new BaseTexts3(product);
        publishers = new BasePublishers3(product);
        imprints = new BaseImprints3(product);
        supplyDetails = new BaseSupplyDetails3(product);
        salesRightss = new BaseSalesRightss3(product);
    }
}
