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

package com.tectonica.jonix.common.struct;

import com.tectonica.jonix.common.JonixStruct;
import com.tectonica.jonix.common.codelist.DiscountTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This class is a {@link JonixStruct} that represents Onix3 <code>&lt;Discount></code>.
 * <p>
 * It can be retrieved from the composite by invoking its <code>asStruct()</code> method.
 */
@SuppressWarnings("serial")
public class JonixDiscount implements JonixStruct, Serializable {
    public static final JonixDiscount EMPTY = new JonixDiscount();

    public DiscountTypes discountType;

    /**
     * Raw Format: Positive real number, with explicit decimal point when required, or zero, as appropriate for the
     * units specified in &lt;EpubUsageUnit&gt;
     * <p>
     * (type: dt.PositiveDecimal)
     */
    public Double quantity;

    /**
     * Raw Format: Positive number, here necessarily an integer, or zero. Suggested maximum length 7 digits
     * <p>
     * (type: dt.PositiveDecimal)
     */
    public Double toQuantity;

    /**
     * Raw Format: Real number between zero and 100 (inclusive), including explicit decimal point when required,
     * suggested maximum length 6 characters
     * <p>
     * (type: dt.PercentDecimal)
     */
    public Double discountPercent;

    /**
     * Raw Format: Positive real number, with explicit decimal point when required, or zero, suggested maximum length 12
     * characters
     * <p>
     * (type: dt.PositiveDecimal)
     */
    public Double discountAmount;
}
