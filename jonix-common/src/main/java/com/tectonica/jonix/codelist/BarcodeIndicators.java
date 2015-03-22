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

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList6
 * <p>
 * Barcode indicator
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum BarcodeIndicators
{
	Not_barcoded("00"), //

	Barcoded_scheme_unspecified("01"), //

	/**
	 * Position unspecified.
	 */
	EAN13("02"), //

	/**
	 * Position unspecified.
	 */
	EAN13_5_US_dollar_price_encoded("03"), //

	/**
	 * Type and position unspecified. DEPRECATED: if possible, use more specific values below.
	 */
	UPC12("04"), //

	/**
	 * Type and position unspecified. DEPRECATED: if possible, use more specific values below.
	 */
	UPC12_5("05"), //

	/**
	 * AKA item/price: position unspecified.
	 */
	UPC12_item_specific("06"), //

	/**
	 * AKA item/price: position unspecified.
	 */
	UPC12_5_item_specific("07"), //

	/**
	 * AKA price/item: position unspecified.
	 */
	UPC12_price_point("08"), //

	/**
	 * AKA price/item: position unspecified.
	 */
	UPC12_5_price_point("09"), //

	/**
	 * ‘Cover 4’ is defined as the back cover of a book.
	 */
	EAN13_on_cover_4("10"), //

	/**
	 * ‘Cover 4’ is defined as the back cover of a book.
	 */
	EAN13_5_on_cover_4_US_dollar_price_encoded("11"), //

	/**
	 * AKA item/price; ‘cover 4’ is defined as the back cover of a book.
	 */
	UPC12_item_specific_("12"), //

	/**
	 * AKA item/price; ‘cover 4’ is defined as the back cover of a book.
	 */
	UPC12_5_item_specific_("13"), //

	/**
	 * AKA price/item; ‘cover 4’ is defined as the back cover of a book.
	 */
	UPC12_price_point_("14"), //

	/**
	 * AKA price/item; ‘cover 4’ is defined as the back cover of a book.
	 */
	UPC12_5_price_point_("15"), //

	/**
	 * ‘Cover 3’ is defined as the inside back cover of a book.
	 */
	EAN13_on_cover_3("16"), //

	/**
	 * ‘Cover 3’ is defined as the inside back cover of a book.
	 */
	EAN13_5_on_cover_3_US_dollar_price_encoded("17"), //

	/**
	 * AKA item/price; ‘cover 3’ is defined as the inside back cover of a book.
	 */
	UPC12_item_specific__("18"), //

	/**
	 * AKA item/price; ‘cover 3’ is defined as the inside back cover of a book.
	 */
	UPC12_5_item_specific__("19"), //

	/**
	 * AKA price/item; ‘cover 3’ is defined as the inside back cover of a book.
	 */
	UPC12_price_point__("20"), //

	/**
	 * AKA price/item; ‘cover 3’ is defined as the inside back cover of a book.
	 */
	UPC12_5_price_point__("21"), //

	/**
	 * ‘Cover 2’ is defined as the inside front cover of a book.
	 */
	EAN13_on_cover_2("22"), //

	/**
	 * ‘Cover 2’ is defined as the inside front cover of a book.
	 */
	EAN13_5_on_cover_2_US_dollar_price_encoded("23"), //

	/**
	 * AKA item/price; ‘cover 2’ is defined as the inside front cover of a book.
	 */
	UPC12_item_specific___("24"), //

	/**
	 * AKA item/price; ‘cover 2’ is defined as the inside front cover of a book.
	 */
	UPC12_5_item_specific___("25"), //

	/**
	 * AKA price/item; ‘cover 2’ is defined as the inside front cover of a book.
	 */
	UPC12_price_point___("26"), //

	/**
	 * AKA price/item; ‘cover 2’ is defined as the inside front cover of a book.
	 */
	UPC12_5_price_point___("27"), //

	/**
	 * To be used only on boxed products.
	 */
	EAN13_on_box("28"), //

	/**
	 * To be used only on boxed products.
	 */
	EAN13_5_on_box_US_dollar_price_encoded("29"), //

	/**
	 * AKA item/price; to be used only on boxed products.
	 */
	UPC12_item_specific____("30"), //

	/**
	 * AKA item/price; to be used only on boxed products.
	 */
	UPC12_5_item_specific____("31"), //

	/**
	 * AKA price/item; to be used only on boxed products.
	 */
	UPC12_price_point____("32"), //

	/**
	 * AKA price/item; to be used only on boxed products.
	 */
	UPC12_5_price_point____("33"), //

	/**
	 * To be used only on products fitted with hanging tags.
	 */
	EAN13_on_tag("34"), //

	/**
	 * To be used only on products fitted with hanging tags.
	 */
	EAN13_5_on_tag_US_dollar_price_encoded("35"), //

	/**
	 * AKA item/price; to be used only on products fitted with hanging tags.
	 */
	UPC12_item_specific_____("36"), //

	/**
	 * AKA item/price; to be used only on products fitted with hanging tags.
	 */
	UPC12_5_item_specific_____("37"), //

	/**
	 * AKA price/item; to be used only on products fitted with hanging tags.
	 */
	UPC12_price_point_____("38"), //

	/**
	 * AKA price/item; to be used only on products fitted with hanging tags.
	 */
	UPC12_5_price_point_____("39"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_on_bottom("40"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_5_on_bottom_US_dollar_price_encoded("41"), //

	/**
	 * AKA item/price; not be used on books unless they are contained within outer packaging.
	 */
	UPC12_item_specific______("42"), //

	/**
	 * AKA item/price; not be used on books unless they are contained within outer packaging.
	 */
	UPC12_5_item_specific______("43"), //

	/**
	 * AKA price/item; not be used on books unless they are contained within outer packaging.
	 */
	UPC12_price_point______("44"), //

	/**
	 * AKA price/item; not be used on books unless they are contained within outer packaging.
	 */
	UPC12_5_price_point______("45"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_on_back("46"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_5_on_back_US_dollar_price_encoded("47"), //

	/**
	 * AKA item/price; not be used on books unless they are contained within outer packaging.
	 */
	UPC12_item_specific_______("48"), //

	/**
	 * AKA item/price; not be used on books unless they are contained within outer packaging.
	 */
	UPC12_5_item_specific_______("49"), //

	/**
	 * AKA price/item; not be used on books unless they are contained within outer packaging.
	 */
	UPC12_price_point_______("50"), //

	/**
	 * AKA price/item; not be used on books unless they are contained within outer packaging.
	 */
	UPC12_5_price_point_______("51"), //

	/**
	 * To be used only on products packaged in outer sleeves.
	 */
	EAN13_on_outer_sleeve_back("52"), //

	/**
	 * To be used only on products packaged in outer sleeves.
	 */
	EAN13_5_on_outer_sleeve_back_US_dollar_price_encoded("53"), //

	/**
	 * AKA item/price; to be used only on products packaged in outer sleeves.
	 */
	UPC12_item_specific________("54"), //

	/**
	 * AKA item/price; to be used only on products packaged in outer sleeves.
	 */
	UPC12_5_item_specific________("55"), //

	/**
	 * AKA price/item; to be used only on products packaged in outer sleeves.
	 */
	UPC12_price_point________("56"), //

	/**
	 * AKA price/item; to be used only on products packaged in outer sleeves.
	 */
	UPC12_5_price_point________("57"), //

	/**
	 * Position unspecified.
	 */
	EAN13_5_no_price_encoded("58"), //

	/**
	 * ‘Cover 4’ is defined as the back cover of a book.
	 */
	EAN13_5_on_cover_4_no_price_encoded("59"), //

	/**
	 * ‘Cover 3’ is defined as the inside back cover of a book.
	 */
	EAN13_5_on_cover_3_no_price_encoded("60"), //

	/**
	 * ‘Cover 2’ is defined as the inside front cover of a book.
	 */
	EAN13_5_on_cover_2_no_price_encoded("61"), //

	/**
	 * To be used only on boxed products.
	 */
	EAN13_5_on_box_no_price_encoded("62"), //

	/**
	 * To be used only on products fitted with hanging tags.
	 */
	EAN13_5_on_tag_no_price_encoded("63"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_5_on_bottom_no_price_encoded("64"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_5_on_back_no_price_encoded("65"), //

	/**
	 * To be used only on products packaged in outer sleeves.
	 */
	EAN13_5_on_outer_sleeve_back_no_price_encoded("66"), //

	/**
	 * Position unspecified.
	 */
	EAN13_5_CAN_dollar_price_encoded("67"), //

	/**
	 * ‘Cover 4’ is defined as the back cover of a book.
	 */
	EAN13_5_on_cover_4_CAN_dollar_price_encoded("68"), //

	/**
	 * ‘Cover 3’ is defined as the inside back cover of a book.
	 */
	EAN13_5_on_cover_3_CAN_dollar_price_encoded("69"), //

	/**
	 * ‘Cover 2’ is defined as the inside front cover of a book.
	 */
	EAN13_5_on_cover_2_CAN_dollar_price_encoded("70"), //

	/**
	 * To be used only on boxed products.
	 */
	EAN13_5_on_box_CAN_dollar_price_encoded("71"), //

	/**
	 * To be used only on products fitted with hanging tags.
	 */
	EAN13_5_on_tag_CAN_dollar_price_encoded("72"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_5_on_bottom_CAN_dollar_price_encoded("73"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_5_on_back_CAN_dollar_price_encoded("74"), //

	/**
	 * To be used only on products packaged in outer sleeves.
	 */
	EAN13_5_on_outer_sleeve_back_CAN_dollar_price_encoded("75");

	public final String value;

	private BarcodeIndicators(String value)
	{
		this.value = value;
	}

	private static Map<String, BarcodeIndicators> map;

	private static Map<String, BarcodeIndicators> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (BarcodeIndicators e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static BarcodeIndicators byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
