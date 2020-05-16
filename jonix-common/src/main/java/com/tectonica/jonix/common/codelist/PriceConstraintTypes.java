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
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist230">ONIX
 *      Codelist 230 in Reference Guide</a>
 */
public enum PriceConstraintTypes implements OnixCodelist, CodeList230 {
    /**
     * Allows positive indication that there are no additional constraints (other than those specified in
     * &lt;EpubUsageConstraint&gt;) - the default if &lt;PriceConstraint&gt; is omitted
     */
    No_constraints("00", "No constraints"),

    /**
     * Lendable by the purchaser to other device owner, account holder or patron, eg library lending (use where the
     * library product is not identified with a separate &lt;ProductIdentifier&gt; from the consumer product). The
     * 'primary' copy becomes unusable while the secondary copy is on loan, unless a number of concurrent borrowers is
     * also specified
     */
    Lend("06", "Lend"),

    /**
     * E-publication license is time-limited. Use with code 02 from List 146 and a time period in days, weeks or months
     * in &lt;PriceConstraintLimit&gt;. The purchased copy becomes unusable when the license expires
     */
    Time_limited_license("07", "Time-limited license"),

    /**
     * Maximum number of consecutive loans or loan extensions (eg from a library) to a single device owner, account
     * holder or patron. Note that a limit of 1 indicates that a loan cannot be renewed or extended
     */
    Loan_renewal("08", "Loan renewal"),

    /**
     * E-publication license is multi-user. Maximum number of concurrent users licensed to use the product should be
     * given in &lt;PriceConstraintLimit&gt;
     */
    Multi_user_license("09", "Multi-user license"),

    /**
     * Preview locally before purchase. Allows a retail customer, account holder or patron to view a proportion of the
     * book (or the whole book, if no proportion is specified) before purchase, but ONLY while located physically in the
     * retailer's store (eg while logged on to the store wifi). Also applies to borrowers making use of 'acquisition on
     * demand' models in libraries
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Preview_on_premises("10", "Preview on premises");

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

    public static PriceConstraintTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (PriceConstraintTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
