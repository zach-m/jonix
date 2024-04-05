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

import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 171 (Tax type)
 */
interface CodeList171 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 171</b>
 * <p>
 * Description: Tax type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_65.html#codelist171">ONIX
 *      Codelist 171 in Reference Guide</a>
 */
public enum TaxTypes implements OnixCodelist, CodeList171 {
    /**
     * TVA, IVA, MwSt, GST etc, levied incrementally at all parts of the supply chain
     */
    VAT_Value_added_tax("01", "VAT (Value-added tax)"),

    /**
     * General sales tax, levied on retail sales
     */
    GST_Sales_tax("02", "GST (Sales tax)"),

    /**
     * 'Green' or eco-tax, levied to encourage responsible production or disposal, used only where this is identified
     * separately from value-added or sales taxes
     */
    ECO("03", "ECO");

    public final String code;
    public final String description;

    TaxTypes(String code, String description) {
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

    public static TaxTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (TaxTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<TaxTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
