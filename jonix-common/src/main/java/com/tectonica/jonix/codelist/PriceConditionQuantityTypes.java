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

package com.tectonica.jonix.codelist;

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 168 (Price condition quantity type)
 */
interface CodeList168 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 168</b>
 * <p>
 * Description: Price condition quantity type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist168">ONIX
 * Codelist 168 in Reference Guide</a>
 */
public enum PriceConditionQuantityTypes implements OnixCodelist, CodeList168 {
    /**
     * The price condition quantity represents a time period
     */
    Time_period("01", "Time period"), //

    /**
     * The price condition quantity is a number of updates
     */
    Number_of_updates("02", "Number of updates"), //

    /**
     * Use with Price condition type 06 and a Quantity of units. Price is valid when purchased with a specific number of
     * products from a list of product identifiers provided in the associated &lt;ProductIdentifier&gt; composites. Use
     * for example when describing a price for this product which is valid if it is purchased along with any two from a
     * list of other products &lt;p&gt;NOTE: Introduced in Onix3
     */
    Number_of_linked_products("03", "Number of linked products");

    public final String code;
    public final String description;

    PriceConditionQuantityTypes(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static PriceConditionQuantityTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (PriceConditionQuantityTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
