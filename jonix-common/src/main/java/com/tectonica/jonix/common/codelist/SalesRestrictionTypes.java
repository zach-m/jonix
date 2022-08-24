/*
 * Copyright (C) 2012-2022 Zach Melamed
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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 71 (Sales restriction type)
 */
interface CodeList71 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 71</b>
 * <p>
 * Description: Sales restriction type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_58.html#codelist71">ONIX
 *      Codelist 71 in Reference Guide</a>
 */
public enum SalesRestrictionTypes implements OnixCodelist, CodeList71 {
    /**
     * Restriction must be described in &lt;SalesRestrictionDetail&gt; (ONIX 2.1) or &lt;SalesRestrictionNote&gt; (ONIX
     * 3.0)
     */
    Unspecified_see_text("00", "Unspecified – see text"),

    /**
     * Sales rights (or market distribution rights) apply to sales through designated retailer(s), which must be
     * identified or named in an instance of the &lt;SalesOutlet&gt; composite. Use only when it is not possible to
     * assign the more explicit codes 04 or 05
     */
    Retailer_exclusive_own_brand("01", "Retailer exclusive / own brand"),

    /**
     * Sales rights (or market distribution rights) apply to sales though office supplies channels. Specific outlet(s)
     * may be identified or named in an instance of the &lt;SalesOutlet&gt; composite
     */
    Through_office_supplies_outlets_only("02", "Through office supplies outlets only"),

    /**
     * For an ISBN that is assigned for a publisher's internal purposes
     */
    Internal_publisher_use_only_do_not_list("03", "Internal publisher use only: do not list"),

    /**
     * Sales rights (or market distribution rights) apply to sales (under the publisher's brand / imprint) through the
     * designated retailer(s), which must be identified or named in an instance of the &lt;SalesOutlet&gt; composite
     */
    Retailer_exclusive("04", "Retailer exclusive"),

    /**
     * Sales rights (or market distribution rights) apply to sales (under the retailer's own brand / imprint) through
     * the designated retailer(s), which must be identified or named in an instance of the &lt;SalesOutlet&gt; composite
     */
    Retailer_own_brand("05", "Retailer own brand"),

    /**
     * Sales rights (or market distribution rights) apply to supplies to libraries
     */
    To_libraries_only("06", "To libraries only"),

    /**
     * Sales rights (or market distribution rights) apply to supplies to schools
     */
    To_schools_only("07", "To schools only"),

    /**
     * Indexed for the German market - in Deutschland indiziert
     */
    Indiziert("08", "Indiziert"),

    /**
     * Sales rights (or market distribution rights) apply to supplies other than to libraries
     */
    Except_to_libraries("09", "Except to libraries"),

    /**
     * Sales rights (or market distribution rights) apply to sales though news outlet channels (newsstands / newsagents)
     */
    Through_news_outlets_only("10", "Through news outlets only"),

    /**
     * Sales rights (or market distribution rights) apply to sales other than through designated retailer(s), which must
     * be identified or named in the &lt;SalesOutlet&gt; composite
     */
    Retailer_exception("11", "Retailer exception"),

    /**
     * Sales rights (or market distribution rights) apply to supplies other than to organisations or services offering
     * consumers subscription access to a catalog of books
     */
    Except_to_subscription_services("12", "Except to subscription services"),

    /**
     * Sales rights (or market distribution rights) apply to supplies to organisations or services offering consumers
     * subscription access to a catalog of books
     */
    To_subscription_services_only("13", "To subscription services only"),

    /**
     * Sales rights (or market distribution rights) apply to sales other than through online retail channels
     */
    Except_through_online_retail("14", "Except through online retail"),

    /**
     * Sales rights (or market distribution rights) apply to sales through online retail channels
     */
    Through_online_retail_only("15", "Through online retail only"),

    /**
     * Sales rights (or market distribution rights) apply to supplies other than to schools. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Except_to_schools("16", "Except to schools"),

    /**
     * POD copies may be manufactured at any time, either to fulfill a customer order immediately or to replace a
     * minimal stockholding (ie near-inventoryless). Only valid in ONIX 3.0
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Through_Inventoryless_POD("17", "Through Inventoryless POD"),

    /**
     * POD copies may be manfactured only to fulfill a customer order immediately while out of stock and awaiting
     * delivery of further stock from the supplier. Only valid in ONIX 3.0
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Through_Stock_Protection_POD("18", "Through Stock Protection POD"),

    /**
     * Not eligible for POD. Only valid in ONIX 3.0
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Except_through_POD("19", "Except through POD"),

    /**
     * Positive indication that no sales restrictions apply, for example to indicate the product may be sold both online
     * and in bricks-and mortar retail, or to subscription services and non-subscription customers. For use in ONIX 3.0
     * only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    No_restrictions_on_sales("99", "No restrictions on sales");

    public final String code;
    public final String description;

    SalesRestrictionTypes(String code, String description) {
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

    private static volatile Map<String, SalesRestrictionTypes> map;

    private static Map<String, SalesRestrictionTypes> map() {
        Map<String, SalesRestrictionTypes> result = map;
        if (result == null) {
            synchronized (SalesRestrictionTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (SalesRestrictionTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static SalesRestrictionTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
