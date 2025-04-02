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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 100 (Discount code type)
 */
interface CodeList100 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 100</b>
 * <p>
 * Description: Discount code type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_69.html#codelist100">ONIX
 *      Codelist 100 in Reference Guide</a>
 */
public enum DiscountCodeTypes implements OnixCodelist, CodeList100 {
    /**
     * UK publisher's or distributor's discount group code in a format specified by BIC to ensure uniqueness (a
     * five-letter prefix allocated by BIC, plus one to three alphanumeric characters - normally digits - chosen by the
     * supplier). See https://bic.org.uk/resources/discount-group-codes/
     */
    BIC_discount_group_code("01", "BIC discount group code"),

    /**
     * A publisher's or supplier's own code which identifies a trade discount category, as specified in
     * &lt;DiscountCodeTypeName&gt;. The actual discount for each code is set by trading partner agreement (applies to
     * goods supplied on standard trade discounting terms)
     */
    Proprietary_discount_code("02", "Proprietary discount code"),

    /**
     * Terms code used in the Netherlands book trade
     */
    Boeksoort("03", "Boeksoort"),

    /**
     * Terms code used in German ONIX applications
     */
    German_terms_code("04", "German terms code"),

    /**
     * A publisher's or supplier's own code which identifies a commission rate category, as specified in
     * &lt;DiscountCodeTypeName&gt;. The actual commission rate for each code is set by trading partner agreement
     * (applies to goods supplied on agency terms)
     */
    Proprietary_commission_code("05", "Proprietary commission code"),

    /**
     * UK publisher's or distributor's commission group code in format specified by BIC to ensure uniqueness. Format is
     * identical to BIC discount group code, but indicates a commission rather than a discount (applies to goods
     * supplied on agency terms)
     */
    BIC_commission_group_code("06", "BIC commission group code"),

    /**
     * ISNI-based discount group scheme devised initially by the German IG ProduktMetadaten, in a format comprised of
     * the supplier's 16-digit ISNI, followed by a hyphen and one to three alphanumeric characters - normally digits -
     * chosen by the supplier. These characters are the index to a discount percentage in a table shared in advance by
     * the supplier with individual customers. In this way, a supplier may maintain individual product-specific discount
     * arrangements with each customer. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    ISNI_based_discount_group_code("07", "ISNI-based discount group code");

    public final String code;
    public final String description;

    DiscountCodeTypes(String code, String description) {
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

    public static DiscountCodeTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (DiscountCodeTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<DiscountCodeTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
