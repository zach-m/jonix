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

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 167 (Price condition type)
 */
interface CodeList167 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 167</b>
 * <p>
 * Description: Price condition type
 *
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist167">ONIX
 * Codelist 167 in Reference Guide</a>
 */
public enum PriceConditionTypes implements OnixCodelist, CodeList167 {
    /**
     * Allows positive indication that there are no conditions (the default if &lt;PriceCondition&gt; is omitted)
     */
    No_conditions("00", "No conditions"), //

    /**
     * Purchase at this price includes specified updates
     */
    Includes_updates("01", "Includes updates"), //

    /**
     * Purchase at this price requires commitment to purchase specified updates, not included in price
     */
    Must_also_purchase_updates("02", "Must also purchase updates"), //

    /**
     * Updates may be purchased separately, no minimum commitment required
     */
    Updates_available("03", "Updates available"), //

    /**
     * Purchase at this price requires prior purchase of other product
     */
    Linked_prior_purchase_price("05", "Linked prior purchase price"), //

    /**
     * Purchase at this price requires simultaneous purchase of other product
     */
    Linked_price("06", "Linked price"), //

    /**
     * The duration of the rental to which the price applies
     */
    Rental_duration("10", "Rental duration"), //

    /**
     * Purchase at this price requires prior rental of the product. &lt;PriceConditionQuantity&gt; gives minimum prior
     * rental period, and &lt;ProductIdentifier&gt; may be used if rental uses a different product identifier
     */
    Rental_to_purchase("11", "Rental to purchase"), //

    /**
     * Upgrade to longer rental duration. &lt;PriceConditionQuantity&gt; gives minimum prior rental duration. Separate
     * price condition with rental duration (code 10) specifies the new combined rental duration
     */
    Rental_extension("12", "Rental extension");

    public final String code;
    public final String description;

    private PriceConditionTypes(String code, String description) {
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

    private static volatile Map<String, PriceConditionTypes> map;

    private static Map<String, PriceConditionTypes> map() {
        Map<String, PriceConditionTypes> result = map;
        if (result == null) {
            synchronized (PriceConditionTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (PriceConditionTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static PriceConditionTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
