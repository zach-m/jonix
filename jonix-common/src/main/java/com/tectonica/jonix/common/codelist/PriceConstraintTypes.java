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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 230 (Price constraint type)
 */
interface CodeList230 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 230</b>
 * <p>
 * Description: Price constraint type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_71.html#codelist230">ONIX
 *      Codelist 230 in Reference Guide</a>
 */
public enum PriceConstraintTypes implements OnixCodelist, CodeList230 {
    /**
     * Allows positive indication that there are no additional constraints (other than those specified in
     * &lt;EpubUsageConstraint&gt;). By convention, use 01 in &lt;PriceConstraintStatus&gt;
     */
    No_price_specific_constraints("00", "No price-specific constraints"),

    /**
     * Preview before purchase. Allows a retail customer, account holder or patron to view or listen to a proportion of
     * the book before purchase. Also applies to borrowers making use of 'acquisition on demand' models in libraries,
     * and to 'subscription' models where the purchase is made on behalf of the reader. Generally used here to specify
     * different preview percentages across different customer types. Note that any Sales embargo date (in
     * &lt;PublishingDate&gt; or &lt;MarketDate&gt;) also applies to provision of previews, unless an explicit date is
     * provided for the preview
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Preview("01", "Preview"),

    /**
     * Make physical copy of extract
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Print("02", "Print"),

    /**
     * Make digital copy of extract
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Copy_paste("03", "Copy / paste"),

    /**
     * Lendable by the purchaser to another device owner or account holder or patron, eg 'Lend-to-a-friend', or library
     * lending (where the library product has a separate &lt;ProductIdentifier&gt; from the consumer product -&#160;but
     * for this prefer code 16). The 'primary' copy becomes unusable while the secondary copy is 'lent' unless a number
     * of concurrent borrowers is also specified
     */
    Lend("06", "Lend"),

    /**
     * E-publication license is time-limited. Use with code 02 from List 146 and either a time period in days, weeks or
     * months in &lt;PriceConstraintLimit&gt;, or a Valid until date in &lt;PriceConstraintLimit&gt;. The purchased copy
     * becomes unusable when the license expires. For clarity, a perpetual license is the default, but may be specified
     * explicitly with code 01 from list 146, or with code 02 and a limit &lt;Quantity&gt; of 0 days
     */
    Time_limited_license("07", "Time-limited license"),

    /**
     * Maximum number of consecutive loans or loan extensions (usually from a library) to a single device owner or
     * account holder or patron. Note that a limit of 1 indicates that a loan cannot be renewed or extended
     */
    Library_loan_renewal("08", "Library loan renewal"),

    /**
     * E-publication license is multi-user. Maximum number of concurrent users licensed to use the product should be
     * given in &lt;PriceConstraintLimit&gt;. For clarity, unlimited concurrency is the default, but may be specified
     * explicitly with code 01 from list 146, or with code 02 and a limit &lt;Quantity&gt; of 0 users
     */
    Multi_user_license("09", "Multi-user license"),

    /**
     * Preview locally before purchase. Allows a retail customer, account holder or patron to view a proportion of the
     * book (or the whole book, if no proportion is specified) before purchase, but ONLY while located physically in the
     * retailer's store (eg while logged on to the store wifi). Also applies to borrowers making use of 'acquisition on
     * demand' models in libraries
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Preview_on_premises("10", "Preview on premises"),

    /**
     * Make use of the content of the product (text, images, audio etc) or the product metadata or supporting resources
     * for extraction of useful (and possibly new) information through automated computer analysis, or for training of
     * tools for such analysis (including training of generative AI models). By convention, use 01 or 03 in
     * &lt;EpubUsageStatus&gt;. Note 03 should be regarded as 'prohibited to the full extent allowed by law', or
     * otherwise expressly reserved by the rightsholder, as in some jurisdictions, TDM may be subject to copyright
     * exception (eg for not-for-profit purposes), subject to optional reservation, or allowed under 'fair use' doctrine
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Text_and_data_mining("11", "Text and data mining"),

    /**
     * Loanable by the purchaser (usually a library) to other device owner or account holder or patron, eg library
     * lending (whether or not the library product has a separate &lt;ProductIdentifier&gt; from the consumer product).
     * The 'primary' copy becomes unusable while the secondary copy is 'on loan' unless a number of concurrent borrowers
     * is also specified. Use code 08 to specify any limit on loan renewals
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Library_loan("16", "Library loan");

    public final String code;
    public final String description;

    PriceConstraintTypes(String code, String description) {
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

    private static volatile Map<String, PriceConstraintTypes> map;

    private static Map<String, PriceConstraintTypes> map() {
        Map<String, PriceConstraintTypes> result = map;
        if (result == null) {
            synchronized (PriceConstraintTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (PriceConstraintTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static PriceConstraintTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<PriceConstraintTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
