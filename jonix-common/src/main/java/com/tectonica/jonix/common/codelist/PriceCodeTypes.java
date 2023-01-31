/*
 * Copyright (C) 2012-2023 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 179 (Price code type)
 */
interface CodeList179 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 179</b>
 * <p>
 * Description: Price code type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_60.html#codelist179">ONIX
 *      Codelist 179 in Reference Guide</a>
 */
public enum PriceCodeTypes implements OnixCodelist, CodeList179 {
    /**
     * A publisher or retailer's proprietary code list as specified in &lt;PriceCodeTypeName&gt; which identifies
     * particular codes with particular price points, price tiers or bands
     */
    Proprietary("01", "Proprietary"),

    /**
     * Price Code scheme for Finnish Pocket Books (Pokkareiden hintaryhm&#228;). Price codes expressed as letters A-J in
     * &lt;PriceCode&gt;
     */
    Finnish_Pocket_Book_price_code("02", "Finnish Pocket Book price code"),

    /**
     * Price Code scheme for Finnish Miki Books (Miki-kirjojen hintaryhm&#228;). Price codes expressed as an integer 1-n
     * in &lt;PriceCode&gt;
     */
    Finnish_Miki_Book_price_code("03", "Finnish Miki Book price code");

    public final String code;
    public final String description;

    PriceCodeTypes(String code, String description) {
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

    public static PriceCodeTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (PriceCodeTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
