/*
 * Copyright (C) 2012-2020 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 54 (Availability status code)
 */
interface CodeList54 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 54</b>
 * <p>
 * Description: Availability status code
 * <p>
 * Jonix-Comment: Deprecated in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_36.html#codelist54">ONIX
 *      Codelist 54 in Reference Guide</a>
 */
public enum AvailabilityStatuss implements OnixCodelist, CodeList54 {
    /**
     * Publication abandoned after having been announced
     */
    Cancelled("AB", "Cancelled"),

    /**
     * Apply direct to publisher, item not available to trade
     */
    Available_direct_from_publisher_only("AD", "Available direct from publisher only"),

    /**
     * Check with customer service
     */
    Availability_uncertain("CS", "Availability uncertain"),

    /**
     * Wholesaler or vendor only
     */
    No_longer_stocked_by_us("EX", "No longer stocked by us"),

    /**
     * In-print and in stock
     */
    Available("IP", "Available"),

    /**
     * May be accompanied by an estimated average time to supply
     */
    Manufactured_on_demand("MD", "Manufactured on demand"),

    /**
     * MUST be accompanied by an expected availability date
     */
    Not_yet_published("NP", "Not yet published"),

    /**
     * Wholesaler or vendor only: MUST be accompanied by expected availability date
     */
    Newly_catalogued_not_yet_in_stock("NY", "Newly catalogued, not yet in stock"),

    /**
     * This format is out of print, but another format is available: should be accompanied by an identifier for the
     * alternative product
     */
    Other_format_available("OF", "Other format available"),

    /**
     * No current plan to reprint
     */
    Out_of_stock_indefinitely("OI", "Out of stock indefinitely"),

    /**
     * Discontinued, deleted from catalogue
     */
    Out_of_print("OP", "Out of print"),

    /**
     * This edition is out of print, but a new edition has been or will soon be published: should be accompanied by an
     * identifier for the new edition
     */
    Replaced_by_new_edition("OR", "Replaced by new edition"),

    /**
     * Publication has been announced, and subsequently postponed with no new date
     */
    Publication_postponed_indefinitely("PP", "Publication postponed indefinitely"),

    /**
     * Supply of this item has been transferred to another publisher or distributor: should be accompanied by an
     * identifier for the new supplier
     */
    Refer_to_another_supplier("RF", "Refer to another supplier"),

    Remaindered("RM", "Remaindered"),

    /**
     * MUST be accompanied by an expected availability date
     */
    Reprinting("RP", "Reprinting"),

    /**
     * Use instead of RP as a last resort, only if it is really impossible to give an expected availability date
     */
    Reprinting_undated("RU", "Reprinting, undated"),

    /**
     * This item is not stocked but has to be specially ordered from a supplier (eg import item not stocked locally):
     * may be accompanied by an estimated average time to supply
     */
    Special_order("TO", "Special order"),

    /**
     * Wholesaler or vendor only
     */
    Temporarily_out_of_stock_because_publisher_cannot_supply("TP",
        "Temporarily out of stock because publisher cannot supply"),

    /**
     * MUST be accompanied by an expected availability date
     */
    Temporarily_unavailable("TU", "Temporarily unavailable"),

    /**
     * The item is out of stock but will be reissued under the same ISBN: MUST be accompanied by an expected
     * availability date and by the reissue date in the &lt;Reissue&gt; composite. See notes on the &lt;Reissue&gt;
     * composite for details on treatment of availability status during reissue
     */
    Unavailable_awaiting_reissue("UR", "Unavailable, awaiting reissue"),

    /**
     * MUST be accompanied by the remainder date
     */
    Will_be_remaindered_as_of_date("WR", "Will be remaindered as of (date)"),

    /**
     * Typically, withdrawn indefinitely for legal reasons
     */
    Withdrawn_from_sale("WS", "Withdrawn from sale");

    public final String code;
    public final String description;

    AvailabilityStatuss(String code, String description) {
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

    private static volatile Map<String, AvailabilityStatuss> map;

    private static Map<String, AvailabilityStatuss> map() {
        Map<String, AvailabilityStatuss> result = map;
        if (result == null) {
            synchronized (AvailabilityStatuss.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (AvailabilityStatuss e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static AvailabilityStatuss byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
