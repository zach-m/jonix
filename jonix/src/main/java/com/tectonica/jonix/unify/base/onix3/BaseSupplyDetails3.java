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
import com.tectonica.jonix.onix3.ProductSupply;
import com.tectonica.jonix.unify.base.BaseSupplyDetail;
import com.tectonica.jonix.unify.base.BaseSupplyDetails;
import com.tectonica.jonix.unify.base.util.Helper;

import java.util.ArrayList;
import java.util.List;

/**
 * ONIX3 concrete implementation for {@link BaseSupplyDetails}
 *
 * @author Zach Melamed
 */
public class BaseSupplyDetails3 extends BaseSupplyDetails {
    private static final long serialVersionUID = 1L;

    private final transient Product product;

    private final transient BaseFactory3 factory;

    public BaseSupplyDetails3(Product product) {
        this(product, BaseFactory3.DEFAULT);
    }

    public BaseSupplyDetails3(Product product, BaseFactory3 factory) {
        this.factory = factory;
        this.product = product;
    }

    @Override
    protected List<BaseSupplyDetail> initialize() {
        List<BaseSupplyDetail> list = new ArrayList<>();
        for (ProductSupply ps : product.productSupplys()) { // scanning all markets, maybe not good idea
            list.addAll(Helper.createList(ps.supplyDetails(), factory.baseSupplyDetailFactory));
        }
        return list;
    }
}
