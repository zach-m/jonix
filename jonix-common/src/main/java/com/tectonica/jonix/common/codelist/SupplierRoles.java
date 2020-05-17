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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 93 (Supplier role)
 */
interface CodeList93 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 93</b>
 * <p>
 * Description: Supplier role
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_49.html#codelist93">ONIX
 *      Codelist 93 in Reference Guide</a>
 */
public enum SupplierRoles implements OnixCodelist, CodeList93 {
    /**
     * Default
     */
    Unspecified("00", "Unspecified"),

    /**
     * Publisher as supplier to retail trade outlets
     */
    Publisher_to_retailers("01", "Publisher to retailers"),

    Publisher_s_exclusive_distributor_to_retailers("02", "Publisher’s exclusive distributor to retailers"),

    Publisher_s_non_exclusive_distributor_to_retailers("03", "Publisher’s non-exclusive distributor to retailers"),

    /**
     * Wholesaler supplying retail trade outlets
     */
    Wholesaler("04", "Wholesaler"),

    /**
     * DEPRECATED - use &lt;MarketRepresentation&gt; (ONIX 2.1) or &lt;MarketPublishingDetail&gt; (ONIX 3.0) to specify
     * a sales agent
     */
    Sales_agent("05", "Sales agent"),

    /**
     * In a specified supply territory. Use only where exclusive/non-exclusive status is not known. Prefer 02 or 03 as
     * appropriate, where possible
     */
    Publisher_s_distributor_to_retailers("06", "Publisher’s distributor to retailers"),

    /**
     * Where a POD product is supplied to retailers and/or consumers direct from a POD source
     */
    POD_supplier("07", "POD supplier"),

    Retailer("08", "Retailer"),

    /**
     * Publisher as supplier direct to consumers and/or institutional customers
     */
    Publisher_to_end_customers("09", "Publisher to end-customers"),

    /**
     * Intermediary as exclusive distributor direct to consumers and/or institutional customers
     */
    Exclusive_distributor_to_end_customers("10", "Exclusive distributor to end-customers"),

    /**
     * Intermediary as non-exclusive distributor direct to consumers and/or institutional customers
     */
    Non_exclusive_distributor_to_end_customers("11", "Non-exclusive distributor to end-customers"),

    /**
     * Use only where exclusive/non-exclusive status is not known. Prefer 10 or 11 as appropriate, where possible
     */
    Distributor_to_end_customers("12", "Distributor to end-customers"),

    /**
     * Intermediary as exclusive distributor to retailers and direct to consumers and/or institutional customers. For
     * use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Exclusive_distributor_to_retailers_and_end_customers("13", "Exclusive distributor to retailers and end-customers"),

    /**
     * Intermediary as non-exclusive distributor to retailers and direct to consumers and/or institutional customers.
     * For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Non_exclusive_distributor_to_retailers_and_end_customers("14",
        "Non-exclusive distributor to retailers and end-customers"),

    /**
     * Use only where exclusive/non-exclusive status is not known. Prefer codes 13 or 14 as appropriate whenever
     * possible. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Distributor_to_retailers_and_end_customers("15", "Distributor to retailers and end-customers");

    public final String code;
    public final String description;

    SupplierRoles(String code, String description) {
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

    private static volatile Map<String, SupplierRoles> map;

    private static Map<String, SupplierRoles> map() {
        Map<String, SupplierRoles> result = map;
        if (result == null) {
            synchronized (SupplierRoles.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (SupplierRoles e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static SupplierRoles byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
