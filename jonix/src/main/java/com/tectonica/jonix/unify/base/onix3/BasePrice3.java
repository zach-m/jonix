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

package com.tectonica.jonix.unify.base.onix3;

import com.tectonica.jonix.onix3.Price;
import com.tectonica.jonix.unify.base.BasePrice;

/**
 * ONIX3 concrete implementation for {@link BasePrice}
 *
 * @author Zach Melamed
 */
public class BasePrice3 extends BasePrice {
    private static final long serialVersionUID = 1L;

    public BasePrice3(Price p) {
        extract(p, this);
    }

    public static void extract(Price p, BasePrice dest) {
        dest.priceType = p.priceType().value;
        dest.priceAmount = p.priceAmount().value;
        dest.priceAmountAsStr = (dest.priceAmount == null) ? "" : dest.priceAmount.toString();
        dest.currencyCode = p.currencyCode().value;
    }
}