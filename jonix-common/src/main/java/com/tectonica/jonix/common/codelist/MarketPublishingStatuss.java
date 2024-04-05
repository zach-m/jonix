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
 * marker interface to assist in IDE navigation to code-list 68 (Market publishing status)
 */
interface CodeList68 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 68</b>
 * <p>
 * Description: Market publishing status
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_65.html#codelist68">ONIX
 *      Codelist 68 in Reference Guide</a>
 */
public enum MarketPublishingStatuss implements OnixCodelist, CodeList68 {
    /**
     * Status is not specified (as distinct from unknown): the default if the &lt;MarketPublishingStatus&gt; element is
     * not sent
     */
    Unspecified("00", "Unspecified"),

    /**
     * The product was announced for publication in this market, and subsequently abandoned. A market publication date
     * must not be sent
     */
    Cancelled("01", "Cancelled"),

    /**
     * Not yet published in this market, should be accompanied by expected local publication date
     */
    Forthcoming("02", "Forthcoming"),

    /**
     * The product was announced for publication in this market, and subsequently postponed with no expected local
     * publication date. A market publication date must not be sent
     */
    Postponed_indefinitely("03", "Postponed indefinitely"),

    /**
     * The product was published in this market, and is still active in the sense that the publisher will accept orders
     * for it, though it may or may not be immediately available, for which see &lt;SupplyDetail&gt;
     */
    Active("04", "Active"),

    /**
     * Responsibility for the product in this market has been transferred elsewhere (with details of acquiring publisher
     * representative in this market if possible in PR.25 (in ONIX 2.1) OR P.25 (in ONIX 3.0 or later))
     */
    No_longer_our_product("05", "No longer our product"),

    /**
     * The product was active in this market, but is now inactive in the sense that (a) the publisher representative
     * (local publisher or sales agent) cannot fulfill orders for it, though stock may still be available elsewhere in
     * the supply chain, and (b) there are no current plans to bring it back into stock in this market. Code 06 does not
     * specifically imply that returns are or are not still accepted
     */
    Out_of_stock_indefinitely("06", "Out of stock indefinitely"),

    /**
     * The product was active in this market, but is now permanently inactive in this market in the sense that (a) the
     * publisher representative (local publisher or sales agent) will not accept orders for it, though stock may still
     * be available elsewhere in the supply chain, and (b) the product will not be made available again in this market
     * under the same ISBN. Code 07 normally implies that the publisher will not accept returns beyond a specified date
     */
    Out_of_print("07", "Out of print"),

    /**
     * The product was active in this market, but is now permanently or indefinitely inactive in the sense that the
     * publisher representative (local publisher or sales agent) will not accept orders for it, though stock may still
     * be available elsewhere in the supply chain. Code 08 covers both of codes 06 and 07, and may be used where the
     * distinction between those values is either unnecessary or meaningless
     */
    Inactive("08", "Inactive"),

    /**
     * The sender of the ONIX record does not know the current publishing status in this market
     */
    Unknown("09", "Unknown"),

    /**
     * The product is no longer available in this market from the publisher representative (local publisher or sales
     * agent), under the current ISBN, at the current price. It may be available to be traded through another channel,
     * usually at a reduced price
     */
    Remaindered("10", "Remaindered"),

    /**
     * Withdrawn from sale in this market, typically for legal reasons or to avoid giving offence
     */
    Withdrawn_from_sale("11", "Withdrawn from sale"),

    /**
     * Either no rights are held for the product in this market, or for other reasons the publisher has decided not to
     * make it available in this market
     */
    Not_available_in_this_market("12", "Not available in this market"),

    /**
     * The product is published and active in this market but, as a publishing decision, its constituent parts are not
     * sold separately - only in an assembly or as part of a pack, eg with Product composition code 01. Also use with
     * Product composition codes 30, 31 where depending on product composition and pricing, items in the pack may be
     * saleable separately at retail
     */
    Active_but_not_sold_separately("13", "Active, but not sold separately"),

    /**
     * The product is published in this market and active, but is not available to all customer types, typically because
     * the market is split between exclusive sales agents for different market segments. In ONIX 2.1, should be
     * accompanied by a free-text statement in &lt;MarketRestrictionDetail&gt; describing the nature of the restriction.
     * In ONIX 3.0 or later, the &lt;SalesRestriction&gt; composite in Group P.24 should be used
     */
    Active_with_market_restrictions("14", "Active, with market restrictions"),

    /**
     * Recalled in this market for reasons of consumer safety
     */
    Recalled("15", "Recalled"),

    /**
     * Temporarily withdrawn from sale in this market, typically for quality or technical reasons. In ONIX 3.0 or later,
     * must be accompanied by expected availability date coded '22' within the &lt;MarketDate&gt; composite, except in
     * exceptional circumstances where no date is known
     */
    Temporarily_withdrawn_from_sale("16", "Temporarily withdrawn from sale"),

    /**
     * Withdrawn permanently from sale in this market. Effectively synonymous with 'Out of print' (code 07), but
     * specific to downloadable and online digital products (where no 'stock' would remain in the supply chain). Only
     * for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Permanently_withdrawn_from_sale("17", "Permanently withdrawn from sale"),

    /**
     * The various constituent parts of a product are published and active in this market but, as a publishing decision,
     * they are not sold together as a single product - eg with Product composition code 11 - and are only available as
     * a number of individual items. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Active_but_not_sold_as_set("18", "Active, but not sold as set");

    public final String code;
    public final String description;

    MarketPublishingStatuss(String code, String description) {
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

    private static volatile Map<String, MarketPublishingStatuss> map;

    private static Map<String, MarketPublishingStatuss> map() {
        Map<String, MarketPublishingStatuss> result = map;
        if (result == null) {
            synchronized (MarketPublishingStatuss.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (MarketPublishingStatuss e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static MarketPublishingStatuss byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<MarketPublishingStatuss> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
