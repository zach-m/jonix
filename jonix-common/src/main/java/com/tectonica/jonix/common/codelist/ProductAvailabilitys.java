/*
 * Copyright (C) 2012-2024 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 65 (Product availability)
 */
interface CodeList65 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 65</b>
 * <p>
 * Description: Product availability
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_67.html#codelist65">ONIX
 *      Codelist 65 in Reference Guide</a>
 */
public enum ProductAvailabilitys implements OnixCodelist, CodeList65 {
    /**
     * Product was announced, and subsequently abandoned by the publisher. No expected availability date should be
     * included in &lt;SupplyDate&gt;
     */
    Cancelled("01", "Cancelled"),

    /**
     * Product is not yet available from the supplier, and the publisher indicates that it has been postponed
     * indefinitely. Should be used in preference to code 10 where the publisher has indicated that a
     * previously-announced publication date is no longer correct, and no new date has yet been announced. No expected
     * avalabilty date should be included in &lt;SupplyDate&gt;. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Not_yet_available_postponed_indefinitely("09", "Not yet available, postponed indefinitely"),

    /**
     * Product is not yet available (requires expected date, either as &lt;ExpectedShipDate&gt; (ONIX 2.1) or as
     * &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded '08' (ONIX 3.0 or later), except in exceptional
     * circumstances where no date is known)
     */
    Not_yet_available("10", "Not yet available"),

    /**
     * Product is not yet available, but will be a stock item when available (requires expected date, either as
     * &lt;ExpectedShipDate&gt; (ONIX 2.1) or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded '08' (ONIX 3.0 or
     * later), except in exceptional circumstances where no date is known). Used particularly for imports which have
     * been published in the country of origin but have not yet arrived in the importing country
     */
    Awaiting_stock("11", "Awaiting stock"),

    /**
     * Product is not yet available, to be published as print-on-demand only (requires expected date, either as
     * &lt;ExpectedShipDate&gt; (ONIX 2.1) or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded '08' (ONIX 3.0 or
     * later), except in exceptional circumstances where no date is known). May apply either to a POD successor to an
     * existing conventional edition, when the successor will be published under a different ISBN (normally because
     * different trade terms apply); or to a title that is being published as a POD original
     */
    Not_yet_available_will_be_POD("12", "Not yet available, will be POD"),

    /**
     * Product is available from the supplier (form of availability unspecified)
     */
    Available("20", "Available"),

    /**
     * Product is available from the supplier as a stock item
     */
    In_stock("21", "In stock"),

    /**
     * Product is available from the supplier as a non-stock item, by special order. Where possible, an
     * &lt;OrderTime&gt; should be included
     */
    To_order("22", "To order"),

    /**
     * Product is available from the supplier by print-on-demand. If the fulfillment delay is likely to be more than 24
     * hours, an &lt;OrderTime&gt; should be included
     */
    POD("23", "POD"),

    /**
     * Product is temporarily unavailable: temporarily unavailable from the supplier (reason unspecified) (requires
     * expected date, either as &lt;ExpectedShipDate&gt; (ONIX 2.1) or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt;
     * coded '08' (ONIX 3.0 or later), except in exceptional circumstances where no date is known)
     */
    Temporarily_unavailable("30", "Temporarily unavailable"),

    /**
     * Product is stock item, but is temporarily out of stock (requires expected date, either as
     * &lt;ExpectedShipDate&gt; (ONIX 2.1) or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded '08' (ONIX 3.0 or
     * later), except in exceptional circumstances where no date is known)
     */
    Out_of_stock("31", "Out of stock"),

    /**
     * Product is temporarily unavailable, and is reprinting (requires expected date, either as &lt;ExpectedShipDate&gt;
     * (ONIX 2.1) or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded '08' (ONIX 3.0 or later), except in
     * exceptional circumstances where no date is known)
     */
    Reprinting("32", "Reprinting"),

    /**
     * Product is temporarily unavailable, awaiting reissue (requires expected date, either as &lt;ExpectedShipDate&gt;
     * (ONIX 2.1) or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded '08' (ONIX 3.0 or later), except in
     * exceptional circumstances where no date is known)
     */
    Awaiting_reissue("33", "Awaiting reissue"),

    /**
     * Product is temporarily withdrawn from sale, possibly for quality or technical reasons. Requires expected
     * availability date, either as &lt;ExpectedShipDate&gt; (ONIX 2.1) or as &lt;SupplyDate&gt; with
     * &lt;SupplyDateRole&gt; coded '08' (ONIX 3.0 or later), except in exceptional circumstances where no date is known
     */
    Temporarily_withdrawn_from_sale("34", "Temporarily withdrawn from sale"),

    /**
     * Product is not available from the supplier (for any reason)
     */
    Not_available_reason_unspecified("40", "Not available (reason unspecified)"),

    /**
     * Product is unavailable, but a successor product or edition is or will be available from the supplier (identify
     * successor in &lt;RelatedProduct&gt;)
     */
    Not_available_replaced_by_new_product("41", "Not available, replaced by new product"),

    /**
     * Product is unavailable, but the same content is or will be available from the supplier in an alternative format
     * (identify other format product in &lt;RelatedProduct&gt;)
     */
    Not_available_other_format_available("42", "Not available, other format available"),

    /**
     * Product is no longer available from the supplier. Identify new supplier in &lt;NewSupplier&gt; if possible
     */
    No_longer_supplied_by_the_supplier("43", "No longer supplied by the supplier"),

    /**
     * Product is not available to trade, apply direct to publisher
     */
    Apply_direct("44", "Apply direct"),

    /**
     * Product must be bought as part of a set or trade pack (identify set or pack in &lt;RelatedProduct&gt; using code
     * 02). Individual copies of the product are not available from the supplier, but packs of copies are available, and
     * individual copies of the product may typically be sold at retail
     */
    Not_sold_separately("45", "Not sold separately"),

    /**
     * Product is withdrawn from sale, possibly permanently. May be for legal reasons or to avoid giving offence
     */
    Withdrawn_from_sale("46", "Withdrawn from sale"),

    /**
     * Product has been remaindered and is no longer available from the supplier in the normal way, but may be available
     * under different terms and conditions in order to dispose of excess stock
     */
    Remaindered("47", "Remaindered"),

    /**
     * Product is out of print, but a print-on-demand edition is or will be available under a different ISBN. Use only
     * when the POD successor has a different ISBN, normally because different trade terms apply
     */
    Not_available_replaced_by_POD("48", "Not available, replaced by POD"),

    /**
     * Product has been recalled, possibly for reasons of consumer safety
     */
    Recalled("49", "Recalled"),

    /**
     * Contents of set or pack must be bought as individual items (identify contents of set or oack in
     * &lt;RelatedProduct&gt; using code 01). Used when a collection that is not sold as a set nevertheless has its own
     * ONIX record
     */
    Not_sold_as_set("50", "Not sold as set"),

    /**
     * Product is unavailable from the supplier, no successor product or alternative format is available or planned. Use
     * this code only when the publisher has indicated the product is out of print
     */
    Not_available_publisher_indicates_OP("51", "Not available, publisher indicates OP"),

    /**
     * Product is unavailable from the supplier in this market, no successor product or alternative format is available
     * or planned. Use this code when a publisher has indicated the product is permanently unavailable (in this market)
     * while remaining available elsewhere
     */
    Not_available_publisher_no_longer_sells_product_in_this_market("52",
        "Not available, publisher no longer sells product in this market"),

    /**
     * Sender has not received any recent update for this product from the publisher or supplier (for use when the
     * sender is a data aggregator). The definition of 'recent' must be specified by the aggregator, or by agreement
     * between parties to an exchange
     */
    No_recent_update_received("97", "No recent update received"),

    /**
     * Sender is no longer receiving any updates from the publisher or supplier of this product (for use when the sender
     * is a data aggregator)
     */
    No_longer_receiving_updates("98", "No longer receiving updates"),

    /**
     * Product availability not known to sender
     */
    Contact_supplier("99", "Contact supplier");

    public final String code;
    public final String description;

    ProductAvailabilitys(String code, String description) {
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

    private static volatile Map<String, ProductAvailabilitys> map;

    private static Map<String, ProductAvailabilitys> map() {
        Map<String, ProductAvailabilitys> result = map;
        if (result == null) {
            synchronized (ProductAvailabilitys.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ProductAvailabilitys e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ProductAvailabilitys byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<ProductAvailabilitys> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
