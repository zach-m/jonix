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
 * marker interface to assist in IDE navigation to code-list 166 (Supply date role)
 */
interface CodeList166 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 166</b>
 * <p>
 * Description: Supply date role
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_60.html#codelist166">ONIX
 *      Codelist 166 in Reference Guide</a>
 */
public enum SupplyDateRoles implements OnixCodelist, CodeList166 {
    /**
     * If there is an embargo on retail sales (of copies from the supplier) before a certain date and this is later than
     * any general or market-wide embargo date, the date from which the embargo is lifted and retail sales and
     * fulfillment of pre-orders are permitted. Use code 02 here ONLY in the exceptional case when the embargo is
     * supplier-specific. More general market-wide or global sales embargos should be specified in &lt;MarketDate&gt; or
     * &lt;PublishingDate&gt; codes. In the absence of any supplier-specific, market-wide or general embargo date,
     * retail sales and pre-order fulfillment may begin as soon as stock is available to the retailer
     */
    Sales_embargo_date("02", "Sales embargo date"),

    /**
     * The date on which physical stock is expected to be available to be shipped from the supplier to retailers, or a
     * digital product is expected to be released by the publisher or digital asset distributor to retailers or their
     * retail platform providers
     */
    Expected_availability_date("08", "Expected availability date"),

    /**
     * Last date when returns will be accepted, generally for a product which is being remaindered or put out of print
     */
    Last_date_for_returns("18", "Last date for returns"),

    /**
     * Latest date on which an order may be placed for guaranteed delivery prior to the publication date. May or may not
     * be linked to a special reservation or pre-publication price
     */
    Reservation_order_deadline("25", "Reservation order deadline"),

    /**
     * Latest date on which existing owners or licensees may download or re-download a copy of the product. Existing
     * users may continue to use their local copy of the product
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Last_redownload_date("29", "Last redownload date"),

    /**
     * Date on which any required technical protection measures (DRM) support will be withdrawn. DRM-protected products
     * may not be usable after this date
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Last_TPM_date("30", "Last TPM date"),

    /**
     * The date on which physical stock is expected to be delivered to the supplier from the manufacturer or from a
     * primary distributor. For the distributor or wholesaler (the supplier) this is the 'goods in' date, as contrasted
     * with the Expected availability date, code 08, which is the 'goods out' date
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Expected_warehouse_date("34", "Expected warehouse date"),

    /**
     * First date on which the supplier specified in &lt;NewSupplier&gt; will accept orders. Note the first date would
     * typically be the day after the old supplier end date, but they may overlap if there is an agreement to forward
     * any orders between old and new supplier for fulfillment
     */
    New_supplier_start_date("50", "New supplier start date"),

    /**
     * Last date on which the supplier specified in &lt;Supplier&gt; will accept orders. New supplier should be
     * specified where available. Note last date would typically be the day before the new supplier start date, but they
     * may overlap if there is an agreement to forward any orders between old and new supplier for fulfillment
     */
    Supplier_end_date("51", "Supplier end date");

    public final String code;
    public final String description;

    SupplyDateRoles(String code, String description) {
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

    private static volatile Map<String, SupplyDateRoles> map;

    private static Map<String, SupplyDateRoles> map() {
        Map<String, SupplyDateRoles> result = map;
        if (result == null) {
            synchronized (SupplyDateRoles.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (SupplyDateRoles e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static SupplyDateRoles byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
