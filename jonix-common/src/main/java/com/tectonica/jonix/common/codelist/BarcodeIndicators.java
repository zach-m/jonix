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
 * marker interface to assist in IDE navigation to code-list 141 (Barcode indicator)
 */
interface CodeList141 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 141</b>
 * <p>
 * Description: Barcode indicator
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_69.html#codelist141">ONIX
 *      Codelist 141 in Reference Guide</a>
 */
public enum BarcodeIndicators implements OnixCodelist, CodeList141 {
    Not_barcoded("00", "Not barcoded"),

    Barcoded_scheme_unspecified("01", "Barcoded, scheme unspecified"),

    /**
     * Barcode uses 13-digit EAN symbology (version NR without 5-digit extension). See (eg)
     * https://bic.org.uk/wp-content/uploads/2022/11/2019.05.31-Bar-Coding-for-Books-rev-09.pdf or
     * https://www.bisg.org/barcoding-guidelines-for-the-us-book-industry
     */
    GTIN_13("02", "GTIN-13"),

    /**
     * EAN symbology (version NK, first digit of 5-digit extension is 1-5)
     */
    GTIN_13_5_US_dollar_price_encoded("03", "GTIN-13+5 (US dollar price encoded)"),

    /**
     * EAN symbology (version NK, first digit of 5-digit extension is 6)
     */
    GTIN_13_5_CAN_dollar_price_encoded("04", "GTIN-13+5 (CAN dollar price encoded)"),

    /**
     * EAN symbology (version NF, 5-digit extension is 90000-98999 for proprietary use - extension does not indicate a
     * price)
     */
    GTIN_13_5_no_price_encoded("05", "GTIN-13+5 (no price encoded)"),

    /**
     * AKA item/price
     */
    UPC_12_item_specific("06", "UPC-12 (item-specific)"),

    /**
     * AKA item/price
     */
    UPC_12_5_item_specific("07", "UPC-12+5 (item-specific)"),

    /**
     * AKA price/item
     */
    UPC_12_price_point("08", "UPC-12 (price-point)"),

    /**
     * AKA price/item
     */
    UPC_12_5_price_point("09", "UPC-12+5 (price-point)"),

    /**
     * EAN symbology (version NK, first digit of 5-digit extension is 0)
     * <p>
     * JONIX adds: Not included in Onix2
     */
    GTIN_13_5_UK_Pound_Sterling_price_encoded("10", "GTIN-13+5 (UK Pound Sterling price encoded)"),

    /**
     * EAN symbology (version NK, price currency by local agreement)
     * <p>
     * JONIX adds: Not included in Onix2
     */
    GTIN_13_5_other_price_encoded("11", "GTIN-13+5 (other price encoded)"),

    /**
     * EAN symbology (two-digit extension, normally indicating periodical issue number)
     * <p>
     * JONIX adds: Not included in Onix2
     */
    GTIN_13_2("12", "GTIN-13+2"),

    /**
     * EAN symbology (five-digit extension, normally indicating periodical issue number)
     * <p>
     * JONIX adds: Not included in Onix2
     */
    GTIN_13_5("13", "GTIN-13+5");

    public final String code;
    public final String description;

    BarcodeIndicators(String code, String description) {
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

    private static volatile Map<String, BarcodeIndicators> map;

    private static Map<String, BarcodeIndicators> map() {
        Map<String, BarcodeIndicators> result = map;
        if (result == null) {
            synchronized (BarcodeIndicators.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (BarcodeIndicators e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static BarcodeIndicators byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<BarcodeIndicators> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
