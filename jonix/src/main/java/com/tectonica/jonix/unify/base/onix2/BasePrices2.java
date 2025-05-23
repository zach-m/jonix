/*
 * Copyright (C) 2012-2025 Zach Melamed
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

import com.tectonica.jonix.onix2.SupplyDetail;
import com.tectonica.jonix.unify.base.BasePrice;
import com.tectonica.jonix.unify.base.BasePrices;
import com.tectonica.jonix.unify.base.util.Helper;

import java.util.List;

/**
 * ONIX2 concrete implementation for {@link BasePrices}
 *
 * @author Zach Melamed
 */
public class BasePrices2 extends BasePrices {
    private static final long serialVersionUID = 1L;

    private final transient SupplyDetail supplyDetail;

    private final transient BaseFactory2 factory;

    public BasePrices2(SupplyDetail supplyDetail) {
        this(supplyDetail, BaseFactory2.DEFAULT);
    }

    public BasePrices2(SupplyDetail supplyDetail, BaseFactory2 factory) {
        this.factory = factory;
        this.supplyDetail = supplyDetail;
    }

    @Override
    protected List<BasePrice> initialize() {
        return Helper.createList(supplyDetail.prices(), factory.basePriceFactory);
    }
}
