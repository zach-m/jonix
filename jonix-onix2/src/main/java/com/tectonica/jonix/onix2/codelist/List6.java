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

package com.tectonica.jonix.onix2.codelist;

import java.util.Map;
import java.util.HashMap;

/**
 * Barcode indicator
 */
public enum List6
{
	Not_barcoded("00"), //

	Barcoded__scheme_unspecified("01"), //

	/**
	 * Position unspecified.
	 */
	EAN13("02"), //

	/**
	 * Position unspecified.
	 */
	EAN13_5__US_dollar_price_encoded_("03"), //

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
	UPC12__item_specific_("06"), //

	/**
	 * AKA item/price: position unspecified.
	 */
	UPC12_5__item_specific_("07"), //

	/**
	 * AKA price/item: position unspecified.
	 */
	UPC12__price_point_("08"), //

	/**
	 * AKA price/item: position unspecified.
	 */
	UPC12_5__price_point_("09"), //

	/**
	 * ‘Cover 4’ is defined as the back cover of a book.
	 */
	EAN13_on_cover_4("10"), //

	/**
	 * ‘Cover 4’ is defined as the back cover of a book.
	 */
	EAN13_5_on_cover_4__US_dollar_price_encoded_("11"), //

	/**
	 * AKA item/price; ‘cover 4’ is defined as the back cover of a book.
	 */
	UPC12__item_specific__on_cover_4("12"), //

	/**
	 * AKA item/price; ‘cover 4’ is defined as the back cover of a book.
	 */
	UPC12_5__item_specific__on_cover_4("13"), //

	/**
	 * AKA price/item; ‘cover 4’ is defined as the back cover of a book.
	 */
	UPC12__price_point__on_cover_4("14"), //

	/**
	 * AKA price/item; ‘cover 4’ is defined as the back cover of a book.
	 */
	UPC12_5__price_point__on_cover_4("15"), //

	/**
	 * ‘Cover 3’ is defined as the inside back cover of a book.
	 */
	EAN13_on_cover_3("16"), //

	/**
	 * ‘Cover 3’ is defined as the inside back cover of a book.
	 */
	EAN13_5_on_cover_3__US_dollar_price_encoded_("17"), //

	/**
	 * AKA item/price; ‘cover 3’ is defined as the inside back cover of a book.
	 */
	UPC12__item_specific__on_cover_3("18"), //

	/**
	 * AKA item/price; ‘cover 3’ is defined as the inside back cover of a book.
	 */
	UPC12_5__item_specific__on_cover_3("19"), //

	/**
	 * AKA price/item; ‘cover 3’ is defined as the inside back cover of a book.
	 */
	UPC12__price_point__on_cover_3("20"), //

	/**
	 * AKA price/item; ‘cover 3’ is defined as the inside back cover of a book.
	 */
	UPC12_5__price_point__on_cover_3("21"), //

	/**
	 * ‘Cover 2’ is defined as the inside front cover of a book.
	 */
	EAN13_on_cover_2("22"), //

	/**
	 * ‘Cover 2’ is defined as the inside front cover of a book.
	 */
	EAN13_5_on_cover_2__US_dollar_price_encoded_("23"), //

	/**
	 * AKA item/price; ‘cover 2’ is defined as the inside front cover of a book.
	 */
	UPC12__item_specific__on_cover_2("24"), //

	/**
	 * AKA item/price; ‘cover 2’ is defined as the inside front cover of a book.
	 */
	UPC12_5__item_specific__on_cover_2("25"), //

	/**
	 * AKA price/item; ‘cover 2’ is defined as the inside front cover of a book.
	 */
	UPC12__price_point__on_cover_2("26"), //

	/**
	 * AKA price/item; ‘cover 2’ is defined as the inside front cover of a book.
	 */
	UPC12_5__price_point__on_cover_2("27"), //

	/**
	 * To be used only on boxed products.
	 */
	EAN13_on_box("28"), //

	/**
	 * To be used only on boxed products.
	 */
	EAN13_5_on_box__US_dollar_price_encoded_("29"), //

	/**
	 * AKA item/price; to be used only on boxed products.
	 */
	UPC12__item_specific__on_box("30"), //

	/**
	 * AKA item/price; to be used only on boxed products.
	 */
	UPC12_5__item_specific__on_box("31"), //

	/**
	 * AKA price/item; to be used only on boxed products.
	 */
	UPC12__price_point__on_box("32"), //

	/**
	 * AKA price/item; to be used only on boxed products.
	 */
	UPC12_5__price_point__on_box("33"), //

	/**
	 * To be used only on products fitted with hanging tags.
	 */
	EAN13_on_tag("34"), //

	/**
	 * To be used only on products fitted with hanging tags.
	 */
	EAN13_5_on_tag__US_dollar_price_encoded_("35"), //

	/**
	 * AKA item/price; to be used only on products fitted with hanging tags.
	 */
	UPC12__item_specific__on_tag("36"), //

	/**
	 * AKA item/price; to be used only on products fitted with hanging tags.
	 */
	UPC12_5__item_specific__on_tag("37"), //

	/**
	 * AKA price/item; to be used only on products fitted with hanging tags.
	 */
	UPC12__price_point__on_tag("38"), //

	/**
	 * AKA price/item; to be used only on products fitted with hanging tags.
	 */
	UPC12_5__price_point__on_tag("39"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_on_bottom("40"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_5_on_bottom__US_dollar_price_encoded_("41"), //

	/**
	 * AKA item/price; not be used on books unless they are contained within outer packaging.
	 */
	UPC12__item_specific__on_bottom("42"), //

	/**
	 * AKA item/price; not be used on books unless they are contained within outer packaging.
	 */
	UPC12_5__item_specific__on_bottom("43"), //

	/**
	 * AKA price/item; not be used on books unless they are contained within outer packaging.
	 */
	UPC12__price_point__on_bottom("44"), //

	/**
	 * AKA price/item; not be used on books unless they are contained within outer packaging.
	 */
	UPC12_5__price_point__on_bottom("45"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_on_back("46"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_5_on_back__US_dollar_price_encoded_("47"), //

	/**
	 * AKA item/price; not be used on books unless they are contained within outer packaging.
	 */
	UPC12__item_specific__on_back("48"), //

	/**
	 * AKA item/price; not be used on books unless they are contained within outer packaging.
	 */
	UPC12_5__item_specific__on_back("49"), //

	/**
	 * AKA price/item; not be used on books unless they are contained within outer packaging.
	 */
	UPC12__price_point__on_back("50"), //

	/**
	 * AKA price/item; not be used on books unless they are contained within outer packaging.
	 */
	UPC12_5__price_point__on_back("51"), //

	/**
	 * To be used only on products packaged in outer sleeves.
	 */
	EAN13_on_outer_sleeve_back("52"), //

	/**
	 * To be used only on products packaged in outer sleeves.
	 */
	EAN13_5_on_outer_sleeve_back__US_dollar_price_encoded_("53"), //

	/**
	 * AKA item/price; to be used only on products packaged in outer sleeves.
	 */
	UPC12__item_specific__on_outer_sleeve_back("54"), //

	/**
	 * AKA item/price; to be used only on products packaged in outer sleeves.
	 */
	UPC12_5__item_specific__on_outer_sleeve_back("55"), //

	/**
	 * AKA price/item; to be used only on products packaged in outer sleeves.
	 */
	UPC12__price_point__on_outer_sleeve_back("56"), //

	/**
	 * AKA price/item; to be used only on products packaged in outer sleeves.
	 */
	UPC12_5__price_point__on_outer_sleeve_back("57"), //

	/**
	 * Position unspecified.
	 */
	EAN13_5__no_price_encoded_("58"), //

	/**
	 * ‘Cover 4’ is defined as the back cover of a book.
	 */
	EAN13_5_on_cover_4__no_price_encoded_("59"), //

	/**
	 * ‘Cover 3’ is defined as the inside back cover of a book.
	 */
	EAN13_5_on_cover_3__no_price_encoded_("60"), //

	/**
	 * ‘Cover 2’ is defined as the inside front cover of a book.
	 */
	EAN13_5_on_cover_2__no_price_encoded_("61"), //

	/**
	 * To be used only on boxed products.
	 */
	EAN13_5_on_box__no_price_encoded_("62"), //

	/**
	 * To be used only on products fitted with hanging tags.
	 */
	EAN13_5_on_tag__no_price_encoded_("63"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_5_on_bottom__no_price_encoded_("64"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_5_on_back__no_price_encoded_("65"), //

	/**
	 * To be used only on products packaged in outer sleeves.
	 */
	EAN13_5_on_outer_sleeve_back__no_price_encoded_("66"), //

	/**
	 * Position unspecified.
	 */
	EAN13_5__CAN_dollar_price_encoded_("67"), //

	/**
	 * ‘Cover 4’ is defined as the back cover of a book.
	 */
	EAN13_5_on_cover_4__CAN_dollar_price_encoded_("68"), //

	/**
	 * ‘Cover 3’ is defined as the inside back cover of a book.
	 */
	EAN13_5_on_cover_3__CAN_dollar_price_encoded_("69"), //

	/**
	 * ‘Cover 2’ is defined as the inside front cover of a book.
	 */
	EAN13_5_on_cover_2__CAN_dollar_price_encoded_("70"), //

	/**
	 * To be used only on boxed products.
	 */
	EAN13_5_on_box__CAN_dollar_price_encoded_("71"), //

	/**
	 * To be used only on products fitted with hanging tags.
	 */
	EAN13_5_on_tag__CAN_dollar_price_encoded_("72"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_5_on_bottom__CAN_dollar_price_encoded_("73"), //

	/**
	 * Not be used on books unless they are contained within outer packaging.
	 */
	EAN13_5_on_back__CAN_dollar_price_encoded_("74"), //

	/**
	 * To be used only on products packaged in outer sleeves.
	 */
	EAN13_5_on_outer_sleeve_back__CAN_dollar_price_encoded_("75");

	public final String value;

	private List6(String value)
	{
		this.value = value;
	}

	private static Map<String, List6> map;

	private static Map<String, List6> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List6 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List6 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
