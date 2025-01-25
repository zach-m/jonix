/*
 * Copyright (C) 2012-2025 Zach Melamed
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
import java.util.Optional;

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 64 (Publishing status)
 */
interface CodeList64 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 64</b>
 * <p>
 * Description: Publishing status
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_68.html#codelist64">ONIX
 *      Codelist 64 in Reference Guide</a>
 */
public enum PublishingStatuss implements OnixCodelist, CodeList64 {
    /**
     * Status is not specified (as distinct from unknown): the default if the &lt;PublishingStatus&gt; element is not
     * sent. Also to be used in applications where the element is considered mandatory, but the sender of the ONIX
     * message chooses not to pass on status information
     */
    Unspecified("00", "Unspecified"),

    /**
     * The product was announced, and subsequently abandoned; the &lt;PublicationDate&gt; element in ONIX 2.1 or its
     * equivalent in &lt;PublishingDate&gt; in ONIX 3.0 or later must not be sent
     */
    Cancelled("01", "Cancelled"),

    /**
     * Not yet published; must be accompanied by the expected date in &lt;PublicationDate&gt; in ONIX 2.1, or its
     * equivalent in the &lt;PublishingDate&gt; composite in ONIX 3.0 or later
     */
    Forthcoming("02", "Forthcoming"),

    /**
     * The product was announced, and subsequently postponed with no expected publication date; the
     * &lt;PublicationDate&gt; element in ONIX 2.1, or its equivalent as a &lt;PublishingDate&gt; composite in ONIX 3.0
     * or later, must not be sent
     */
    Postponed_indefinitely("03", "Postponed indefinitely"),

    /**
     * The product was published, and is still active in the sense that the publisher will accept orders for it, though
     * it may or may not be immediately available, for which see &lt;SupplyDetail&gt;
     */
    Active("04", "Active"),

    /**
     * Ownership of the product has been transferred to another publisher (with details of acquiring publisher if
     * possible in PR.19 (ONIX 2.1) OR P.19 (ONIX 3.0 or later))
     */
    No_longer_our_product("05", "No longer our product"),

    /**
     * The product was active, but is now inactive in the sense that (a) the publisher cannot fulfill orders for it,
     * though stock may still be available elsewhere in the supply chain, and (b) there are no current plans to bring it
     * back into stock. Use this code for 'reprint under consideration'. Code 06 does not specifically imply that
     * returns are or are not still accepted
     */
    Out_of_stock_indefinitely("06", "Out of stock indefinitely"),

    /**
     * The product was active, but is now permanently inactive in the sense that (a) the publisher will not accept
     * orders for it, though stock may still be available elsewhere in the supply chain, and (b) the product will not be
     * made available again under the same ISBN. Code 07 normally implies that the publisher will not accept returns
     * beyond a specified date
     */
    Out_of_print("07", "Out of print"),

    /**
     * The product was active, but is now permanently or indefinitely inactive in the sense that the publisher will not
     * accept orders for it, though stock may still be available elsewhere in the supply chain. Code 08 covers both of
     * codes 06 and 07, and may be used where the distinction between those values is either unnecessary or meaningless
     */
    Inactive("08", "Inactive"),

    /**
     * The sender of the ONIX record does not know the current publishing status
     */
    Unknown("09", "Unknown"),

    /**
     * The product is no longer available from the current publisher, under the current ISBN, at the current price. It
     * may be available to be traded through another channel. A Publishing Status code 10 'Remaindered' usually but not
     * always means that the publisher has decided to sell off excess inventory of the book. Copies of books that are
     * remaindered are often made available in the supply chain at a reduced price. However, such remainders are often
     * sold under a product identifier that differs from the ISBN on the full-priced copy of the book. A Publishing
     * Status code 10 'Remaindered' on a given product record may or may not be followed by a Publishing Status code 06
     * 'Out of Stock Indefinitely' or 07 'Out of Print': the practise varies from one publisher to another. Some
     * publishers may revert to a Publishing Status code 04 'Active' if a desired inventory level on the product in
     * question has subsequently been reached. No change in rights should ever be inferred from this (or any other)
     * Publishing Status code value
     */
    Remaindered("10", "Remaindered"),

    /**
     * Withdrawn, typically for legal reasons or to avoid giving offence
     */
    Withdrawn_from_sale("11", "Withdrawn from sale"),

    /**
     * Recalled for reasons of consumer safety. Deprecated, use code 15 instead
     */
    Recalled("12", "Recalled"),

    /**
     * The product is published and active but, as a publishing decision, its constituent parts are not sold separately
     * - only in an assembly or as part of a pack, eg with Product composition code 01. Also use with Product
     * composition codes 30, 31 where depending on product composition and pricing, items in the pack may or may not be
     * saleable separately at retail
     */
    Active_but_not_sold_separately("13", "Active, but not sold separately"),

    /**
     * Recalled for reasons of consumer safety
     */
    Recalled_("15", "Recalled"),

    /**
     * Withdrawn temporarily, typically for quality or technical reasons. In ONIX 3.0 or later, must be accompanied by
     * expected availability date coded '22' within the &lt;PublishingDate&gt; composite, except in exceptional
     * circumstances where no date is known
     */
    Temporarily_withdrawn_from_sale("16", "Temporarily withdrawn from sale"),

    /**
     * Withdrawn permanently from sale in all markets. Effectively synonymous with 'Out of print' (code 07), but
     * specific to downloadable and online digital products (where no 'stock' would remain in the supply chain)
     */
    Permanently_withdrawn_from_sale("17", "Permanently withdrawn from sale"),

    /**
     * The various constituent parts of a product are published and active but, as a publishing decision, they are not
     * sold together as a single product - eg with Product composition code 11 - and are only available as a number of
     * individual items. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Active_but_not_sold_as_set("18", "Active, but not sold as set");

    public final String code;
    public final String description;

    PublishingStatuss(String code, String description) {
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

    private static volatile Map<String, PublishingStatuss> map;

    private static Map<String, PublishingStatuss> map() {
        Map<String, PublishingStatuss> result = map;
        if (result == null) {
            synchronized (PublishingStatuss.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (PublishingStatuss e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static PublishingStatuss byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<PublishingStatuss> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
