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

package com.tectonica.jonix.struct;

import com.tectonica.jonix.JonixKeyedStruct;
import com.tectonica.jonix.codelist.PriceConditionQuantityTypes;
import com.tectonica.jonix.codelist.QuantityUnits;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class JonixPriceConditionQuantity implements JonixKeyedStruct<PriceConditionQuantityTypes>, Serializable {
    public static JonixPriceConditionQuantity EMPTY = new JonixPriceConditionQuantity();

    /**
     * the key of this struct (by which it can be looked up)
     */
    public PriceConditionQuantityTypes priceConditionQuantityType;

    /**
     * Raw Format: Positive real number, with explicit decimal point when required, or zero, as appropriate for the
     * units specified in &lt;EpubUsageUnit&gt;
     * <p>
     * (type: dt.PositiveDecimal)
     */
    public Double quantity;

    public QuantityUnits quantityUnit;

    @Override
    public PriceConditionQuantityTypes key() {
        return priceConditionQuantityType;
    }
}
