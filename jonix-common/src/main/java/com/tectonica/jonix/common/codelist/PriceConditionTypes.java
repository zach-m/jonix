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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_63.html#codelist167">ONIX
 *      Codelist 167 in Reference Guide</a>
 */
public enum PriceConditionTypes implements OnixCodelist, CodeList167 {
    /**
     * Allows positive indication that there are no conditions (the default if &lt;PriceCondition&gt; is omitted)
     */
    No_conditions("00", "No conditions"),

    /**
     * Purchase at this price includes specified updates
     */
    Includes_updates("01", "Includes updates"),

    /**
     * Purchase at this price requires commitment to purchase specified updates, not included in price
     */
    Must_also_purchase_updates("02", "Must also purchase updates"),

    /**
     * Updates may be purchased separately, no minimum commitment required
     */
    Updates_available("03", "Updates available"),

    /**
     * Use with &lt;PriceConditionQuantity&gt; and &lt;ProductIdentifier&gt;. Purchase at this price requires commitment
     * to purchase the specified linked product, which is not included in the price
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Linked_subsequent_purchase_price("04", "Linked subsequent purchase price"),

    /**
     * Use with &lt;PriceConditionQuantity&gt; and &lt;ProductIdentifier&gt;. Purchase at this price requires prior
     * purchase of the specified linked product
     */
    Linked_prior_purchase_price("05", "Linked prior purchase price"),

    /**
     * Use with &lt;PriceConditionQuantity&gt; and &lt;ProductIdentifier&gt;. Purchase at this price requires
     * simultaneous purchase of the specified linked product, which is not included in the price
     */
    Linked_price("06", "Linked price"),

    /**
     * The rental or subscription will automatically renew at the end of the period unless actively cancelled
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Auto_renewing("07", "Auto-renewing"),

    /**
     * Purchase at this price includes the price of the specified other product
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Combined_price("08", "Combined price"),

    /**
     * The duration of the rental to which the price applies. Deprecated, use &lt;PriceConstraint&gt; instead
     */
    Rental_duration("10", "Rental duration"),

    /**
     * Purchase at this price requires prior rental of the product. &lt;PriceConditionQuantity&gt; gives minimum prior
     * rental period, and &lt;ProductIdentifier&gt; may be used if rental uses a different product identifier
     */
    Rental_to_purchase("11", "Rental to purchase"),

    /**
     * Upgrade to longer rental duration. &lt;PriceConditionQuantity&gt; gives minimum prior rental duration, and
     * &lt;ProductIdentifier&gt; may be used if rental uses a different product identifier. Separate price constraint
     * with time limited license duration (code 07) specifies the new combined rental duration
     */
    Rental_extension("12", "Rental extension");

    public final String code;
    public final String description;

    PriceConditionTypes(String code, String description) {
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

    public static Optional<PriceConditionTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
