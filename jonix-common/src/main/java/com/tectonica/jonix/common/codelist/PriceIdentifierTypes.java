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

import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 217 (Price identifier type)
 */
interface CodeList217 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 217</b>
 * <p>
 * Description: Price identifier type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_62.html#codelist217">ONIX
 *      Codelist 217 in Reference Guide</a>
 */
public enum PriceIdentifierTypes implements OnixCodelist, CodeList217 {
    /**
     * Note that &lt;IDTypeName&gt; is required for proprietary identifiers
     */
    Proprietary("01", "Proprietary"),

    /**
     * Proprietary identifier uniquely identifies price amount and currency. Two unrelated products with the same price
     * amount carry the same identifier, though their price types may be different
     */
    Proprietary_price_point_identifier("02", "Proprietary price point identifier"),

    /**
     * Proprietary identifier uniquely identifies price type, qualifier and any constraints and conditions. Two
     * unrelated products with the same price type carry the same identifier, though their price points may be different
     */
    Proprietary_price_type_identifier("03", "Proprietary price type identifier"),

    /**
     * Proprietary identifier identifies a unique combination of price point and type, though two unrelated products may
     * carry the same identifier if all details of their prices are identical
     */
    Proprietary_price_point_and_type_identifier("04", "Proprietary price point and type identifier"),

    /**
     * Proprietary identifier is unique to a single price point, price type and product. No two products can carry the
     * same identifier, even if all details of their prices are identical
     */
    Proprietary_unique_price_identifier("05", "Proprietary unique price identifier"),

    /**
     * Proprietary identifier uniquely identifies a specific combination of product, price amount and currency,
     * independent of the price type
     */
    Proprietary_product_price_point_identifier("06", "Proprietary product price point identifier"),

    /**
     * Proprietary identifier uniquely identifies a specific combination of product, price type, qualifier and any
     * constraints and conditions, independent of the price amount and currency. A product with the same product price
     * type identififer may carry differing price amounts, currencies at different points in time
     */
    Proprietary_product_price_type_identifier("07", "Proprietary product price type identifier");

    public final String code;
    public final String description;

    PriceIdentifierTypes(String code, String description) {
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

    public static PriceIdentifierTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (PriceIdentifierTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<PriceIdentifierTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
