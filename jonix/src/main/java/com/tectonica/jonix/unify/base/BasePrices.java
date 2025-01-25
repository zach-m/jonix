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

package com.tectonica.jonix.unify.base;

import com.tectonica.jonix.common.codelist.CurrencyCodes;
import com.tectonica.jonix.common.codelist.PriceTypes;
import com.tectonica.jonix.unify.base.util.LazyList;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A {@link List} containing the multiple instances of ONIX &lt;Price&gt; that may exist in ONIX supply-details
 *
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BasePrices extends LazyList<BasePrice> {
    public List<BasePrice> findPrices(Set<PriceTypes> requestedTypes) {
        List<BasePrice> matches = new ArrayList<>();
        for (BasePrice price : this) {
            if (requestedTypes.contains(price.priceType)) {
                matches.add(price);
            }
        }
        return matches;
    }

    public String findRetailPrice(CurrencyCodes currency, boolean includingTax) {
        for (BasePrice price : this) {
            PriceTypes type = price.priceType;
            boolean correctType = (includingTax && type == PriceTypes.RRP_including_tax)
                || (!includingTax && type == PriceTypes.RRP_excluding_tax);
            if (correctType && (price.currencyCode == currency)) {
                return price.priceAmountAsStr;
            }
        }
        return null;
    }
}
