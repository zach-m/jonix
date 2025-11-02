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
 * marker interface to assist in IDE navigation to code-list 170 (Discount type)
 */
interface CodeList170 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 170</b>
 * <p>
 * Description: Discount type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_71.html#codelist170">ONIX
 *      Codelist 170 in Reference Guide</a>
 */
public enum DiscountTypes implements OnixCodelist, CodeList170 {
    /**
     * Discount applied to all units in a qualifying order. The default if no &lt;DiscountType&gt; is specified
     */
    Rising_discount("01", "Rising discount"),

    /**
     * Additional discount may be applied retrospectively, based on number of units ordered over a specific period
     */
    Rising_discount_cumulative("02", "Rising discount (cumulative)"),

    /**
     * Discount applied to marginal units in a qualifying order
     */
    Progressive_discount("03", "Progressive discount"),

    /**
     * Previous orders within a specific time period are counted when calculating a progressive discount
     */
    Progressive_discount_cumulative("04", "Progressive discount (cumulative)");

    public final String code;
    public final String description;

    DiscountTypes(String code, String description) {
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

    public static DiscountTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (DiscountTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<DiscountTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
