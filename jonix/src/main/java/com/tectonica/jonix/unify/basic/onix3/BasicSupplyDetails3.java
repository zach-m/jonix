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

package com.tectonica.jonix.unify.basic.onix3;

import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.onix3.ProductSupply;
import com.tectonica.jonix.onix3.SupplyDetail;
import com.tectonica.jonix.unify.basic.BasicSupplyDetail;
import com.tectonica.jonix.unify.basic.BasicSupplyDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * ONIX3 concrete implementation for {@link BasicSupplyDetails}
 *
 * @author Zach Melamed
 */
public class BasicSupplyDetails3 extends BasicSupplyDetails {
    private static final long serialVersionUID = 1L;

    private final transient Product product;

    public BasicSupplyDetails3(Product product) {
        this.product = product;
    }

    @Override
    protected List<BasicSupplyDetail> initialize() {
        List<BasicSupplyDetail> list = new ArrayList<>();
        for (ProductSupply ps : product.productSupplys()) { // scanning all markets, maybe not good idea
            for (SupplyDetail supplyDetail : ps.supplyDetails()) {
                list.add(new BasicSupplyDetail3(supplyDetail));
            }
        }
        return list;
    }
}
