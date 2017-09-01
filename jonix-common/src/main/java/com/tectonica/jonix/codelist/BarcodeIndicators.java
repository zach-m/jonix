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

package com.tectonica.jonix.codelist;

import com.tectonica.jonix.OnixCodelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 6 (Barcode indicator)
 */
interface CodeList6 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 6</b>
 * <p>
 * Description: Barcode indicator
 *
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist6">ONIX
 * Codelist 6 in Reference Guide</a>
 */
public enum BarcodeIndicators implements OnixCodelist, CodeList6 {
    Not_barcoded("00", "Not barcoded"), //

    Barcoded_scheme_unspecified("01", "Barcoded, scheme unspecified"), //

    /**
     * Position unspecified
     */
    EAN13("02", "EAN13"), //

    /**
     * Position unspecified
     */
    EAN13_5_US_dollar_price_encoded("03", "EAN13+5 (US dollar price encoded)"), //

    /**
     * Type and position unspecified. DEPRECATED: if possible, use more specific values below
     */
    UPC12("04", "UPC12"), //

    /**
     * Type and position unspecified. DEPRECATED: if possible, use more specific values below
     */
    UPC12_5("05", "UPC12+5"), //

    /**
     * AKA item/price: position unspecified
     */
    UPC12_item_specific("06", "UPC12 (item-specific)"), //

    /**
     * AKA item/price: position unspecified
     */
    UPC12_5_item_specific("07", "UPC12+5 (item-specific)"), //

    /**
     * AKA price/item: position unspecified
     */
    UPC12_price_point("08", "UPC12 (price-point)"), //

    /**
     * AKA price/item: position unspecified
     */
    UPC12_5_price_point("09", "UPC12+5 (price-point)"), //

    /**
     * 'Cover 4' is defined as the back cover of a book
     */
    EAN13_on_cover_4("10", "EAN13 on cover 4"), //

    /**
     * 'Cover 4' is defined as the back cover of a book
     */
    EAN13_5_on_cover_4_US_dollar_price_encoded("11", "EAN13+5 on cover 4 (US dollar price encoded)"), //

    /**
     * AKA item/price; 'cover 4' is defined as the back cover of a book
     */
    UPC12_item_specific_("12", "UPC12 (item-specific) on cover 4"), //

    /**
     * AKA item/price; 'cover 4' is defined as the back cover of a book
     */
    UPC12_5_item_specific_("13", "UPC12+5 (item-specific) on cover 4"), //

    /**
     * AKA price/item; 'cover 4' is defined as the back cover of a book
     */
    UPC12_price_point_("14", "UPC12 (price-point) on cover 4"), //

    /**
     * AKA price/item; 'cover 4' is defined as the back cover of a book
     */
    UPC12_5_price_point_("15", "UPC12+5 (price-point) on cover 4"), //

    /**
     * 'Cover 3' is defined as the inside back cover of a book
     */
    EAN13_on_cover_3("16", "EAN13 on cover 3"), //

    /**
     * 'Cover 3' is defined as the inside back cover of a book
     */
    EAN13_5_on_cover_3_US_dollar_price_encoded("17", "EAN13+5 on cover 3 (US dollar price encoded)"), //

    /**
     * AKA item/price; 'cover 3' is defined as the inside back cover of a book
     */
    UPC12_item_specific__("18", "UPC12 (item-specific) on cover 3"), //

    /**
     * AKA item/price; 'cover 3' is defined as the inside back cover of a book
     */
    UPC12_5_item_specific__("19", "UPC12+5 (item-specific) on cover 3"), //

    /**
     * AKA price/item; 'cover 3' is defined as the inside back cover of a book
     */
    UPC12_price_point__("20", "UPC12 (price-point) on cover 3"), //

    /**
     * AKA price/item; 'cover 3' is defined as the inside back cover of a book
     */
    UPC12_5_price_point__("21", "UPC12+5 (price-point) on cover 3"), //

    /**
     * 'Cover 2' is defined as the inside front cover of a book
     */
    EAN13_on_cover_2("22", "EAN13 on cover 2"), //

    /**
     * 'Cover 2' is defined as the inside front cover of a book
     */
    EAN13_5_on_cover_2_US_dollar_price_encoded("23", "EAN13+5 on cover 2 (US dollar price encoded)"), //

    /**
     * AKA item/price; 'cover 2' is defined as the inside front cover of a book
     */
    UPC12_item_specific___("24", "UPC12 (item-specific) on cover 2"), //

    /**
     * AKA item/price; 'cover 2' is defined as the inside front cover of a book
     */
    UPC12_5_item_specific___("25", "UPC12+5 (item-specific) on cover 2"), //

    /**
     * AKA price/item; 'cover 2' is defined as the inside front cover of a book
     */
    UPC12_price_point___("26", "UPC12 (price-point) on cover 2"), //

    /**
     * AKA price/item; 'cover 2' is defined as the inside front cover of a book
     */
    UPC12_5_price_point___("27", "UPC12+5 (price-point) on cover 2"), //

    /**
     * To be used only on boxed products
     */
    EAN13_on_box("28", "EAN13 on box"), //

    /**
     * To be used only on boxed products
     */
    EAN13_5_on_box_US_dollar_price_encoded("29", "EAN13+5 on box (US dollar price encoded)"), //

    /**
     * AKA item/price; to be used only on boxed products
     */
    UPC12_item_specific____("30", "UPC12 (item-specific) on box"), //

    /**
     * AKA item/price; to be used only on boxed products
     */
    UPC12_5_item_specific____("31", "UPC12+5 (item-specific) on box"), //

    /**
     * AKA price/item; to be used only on boxed products
     */
    UPC12_price_point____("32", "UPC12 (price-point) on box"), //

    /**
     * AKA price/item; to be used only on boxed products
     */
    UPC12_5_price_point____("33", "UPC12+5 (price-point) on box"), //

    /**
     * To be used only on products fitted with hanging tags
     */
    EAN13_on_tag("34", "EAN13 on tag"), //

    /**
     * To be used only on products fitted with hanging tags
     */
    EAN13_5_on_tag_US_dollar_price_encoded("35", "EAN13+5 on tag (US dollar price encoded)"), //

    /**
     * AKA item/price; to be used only on products fitted with hanging tags
     */
    UPC12_item_specific_____("36", "UPC12 (item-specific) on tag"), //

    /**
     * AKA item/price; to be used only on products fitted with hanging tags
     */
    UPC12_5_item_specific_____("37", "UPC12+5 (item-specific) on tag"), //

    /**
     * AKA price/item; to be used only on products fitted with hanging tags
     */
    UPC12_price_point_____("38", "UPC12 (price-point) on tag"), //

    /**
     * AKA price/item; to be used only on products fitted with hanging tags
     */
    UPC12_5_price_point_____("39", "UPC12+5 (price-point) on tag"), //

    /**
     * Not be used on books unless they are contained within outer packaging
     */
    EAN13_on_bottom("40", "EAN13 on bottom"), //

    /**
     * Not be used on books unless they are contained within outer packaging
     */
    EAN13_5_on_bottom_US_dollar_price_encoded("41", "EAN13+5 on bottom (US dollar price encoded)"), //

    /**
     * AKA item/price; not be used on books unless they are contained within outer packaging
     */
    UPC12_item_specific______("42", "UPC12 (item-specific) on bottom"), //

    /**
     * AKA item/price; not be used on books unless they are contained within outer packaging
     */
    UPC12_5_item_specific______("43", "UPC12+5 (item-specific) on bottom"), //

    /**
     * AKA price/item; not be used on books unless they are contained within outer packaging
     */
    UPC12_price_point______("44", "UPC12 (price-point) on bottom"), //

    /**
     * AKA price/item; not be used on books unless they are contained within outer packaging
     */
    UPC12_5_price_point______("45", "UPC12+5 (price-point) on bottom"), //

    /**
     * Not be used on books unless they are contained within outer packaging
     */
    EAN13_on_back("46", "EAN13 on back"), //

    /**
     * Not be used on books unless they are contained within outer packaging
     */
    EAN13_5_on_back_US_dollar_price_encoded("47", "EAN13+5 on back (US dollar price encoded)"), //

    /**
     * AKA item/price; not be used on books unless they are contained within outer packaging
     */
    UPC12_item_specific_______("48", "UPC12 (item-specific) on back"), //

    /**
     * AKA item/price; not be used on books unless they are contained within outer packaging
     */
    UPC12_5_item_specific_______("49", "UPC12+5 (item-specific) on back"), //

    /**
     * AKA price/item; not be used on books unless they are contained within outer packaging
     */
    UPC12_price_point_______("50", "UPC12 (price-point) on back"), //

    /**
     * AKA price/item; not be used on books unless they are contained within outer packaging
     */
    UPC12_5_price_point_______("51", "UPC12+5 (price-point) on back"), //

    /**
     * To be used only on products packaged in outer sleeves
     */
    EAN13_on_outer_sleeve_back("52", "EAN13 on outer sleeve/back"), //

    /**
     * To be used only on products packaged in outer sleeves
     */
    EAN13_5_on_outer_sleeve_back_US_dollar_price_encoded("53",
        "EAN13+5 on outer sleeve/back (US dollar price encoded)"), //

    /**
     * AKA item/price; to be used only on products packaged in outer sleeves
     */
    UPC12_item_specific________("54", "UPC12 (item-specific) on outer sleeve/back"), //

    /**
     * AKA item/price; to be used only on products packaged in outer sleeves
     */
    UPC12_5_item_specific________("55", "UPC12+5 (item-specific) on outer sleeve/back"), //

    /**
     * AKA price/item; to be used only on products packaged in outer sleeves
     */
    UPC12_price_point________("56", "UPC12 (price-point) on outer sleeve/back"), //

    /**
     * AKA price/item; to be used only on products packaged in outer sleeves
     */
    UPC12_5_price_point________("57", "UPC12+5 (price-point) on outer sleeve/back"), //

    /**
     * Position unspecified
     */
    EAN13_5_no_price_encoded("58", "EAN13+5 (no price encoded)"), //

    /**
     * 'Cover 4' is defined as the back cover of a book
     */
    EAN13_5_on_cover_4_no_price_encoded("59", "EAN13+5 on cover 4 (no price encoded)"), //

    /**
     * 'Cover 3' is defined as the inside back cover of a book
     */
    EAN13_5_on_cover_3_no_price_encoded("60", "EAN13+5 on cover 3 (no price encoded)"), //

    /**
     * 'Cover 2' is defined as the inside front cover of a book
     */
    EAN13_5_on_cover_2_no_price_encoded("61", "EAN13+5 on cover 2 (no price encoded)"), //

    /**
     * To be used only on boxed products
     */
    EAN13_5_on_box_no_price_encoded("62", "EAN13+5 on box (no price encoded)"), //

    /**
     * To be used only on products fitted with hanging tags
     */
    EAN13_5_on_tag_no_price_encoded("63", "EAN13+5 on tag (no price encoded)"), //

    /**
     * Not be used on books unless they are contained within outer packaging
     */
    EAN13_5_on_bottom_no_price_encoded("64", "EAN13+5 on bottom (no price encoded)"), //

    /**
     * Not be used on books unless they are contained within outer packaging
     */
    EAN13_5_on_back_no_price_encoded("65", "EAN13+5 on back (no price encoded)"), //

    /**
     * To be used only on products packaged in outer sleeves
     */
    EAN13_5_on_outer_sleeve_back_no_price_encoded("66", "EAN13+5 on outer sleeve/back (no price encoded)"), //

    /**
     * Position unspecified
     */
    EAN13_5_CAN_dollar_price_encoded("67", "EAN13+5 (CAN dollar price encoded)"), //

    /**
     * 'Cover 4' is defined as the back cover of a book
     */
    EAN13_5_on_cover_4_CAN_dollar_price_encoded("68", "EAN13+5 on cover 4 (CAN dollar price encoded)"), //

    /**
     * 'Cover 3' is defined as the inside back cover of a book
     */
    EAN13_5_on_cover_3_CAN_dollar_price_encoded("69", "EAN13+5 on cover 3 (CAN dollar price encoded)"), //

    /**
     * 'Cover 2' is defined as the inside front cover of a book
     */
    EAN13_5_on_cover_2_CAN_dollar_price_encoded("70", "EAN13+5 on cover 2 (CAN dollar price encoded)"), //

    /**
     * To be used only on boxed products
     */
    EAN13_5_on_box_CAN_dollar_price_encoded("71", "EAN13+5 on box (CAN dollar price encoded)"), //

    /**
     * To be used only on products fitted with hanging tags
     */
    EAN13_5_on_tag_CAN_dollar_price_encoded("72", "EAN13+5 on tag (CAN dollar price encoded)"), //

    /**
     * Not be used on books unless they are contained within outer packaging
     */
    EAN13_5_on_bottom_CAN_dollar_price_encoded("73", "EAN13+5 on bottom (CAN dollar price encoded)"), //

    /**
     * Not be used on books unless they are contained within outer packaging
     */
    EAN13_5_on_back_CAN_dollar_price_encoded("74", "EAN13+5 on back (CAN dollar price encoded)"), //

    /**
     * To be used only on products packaged in outer sleeves
     */
    EAN13_5_on_outer_sleeve_back_CAN_dollar_price_encoded("75",
        "EAN13+5 on outer sleeve/back (CAN dollar price encoded)");

    public final String code;
    public final String description;

    private BarcodeIndicators(String code, String description) {
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
}
