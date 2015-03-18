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

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Barcode indicator
 */
public enum List141
{
	Not_barcoded("00"), //

	Barcoded__scheme_unspecified("01"), //

	GTIN_13("02"), //

	GTIN_13_5__US_dollar_price_encoded_("03"), //

	GTIN_13_5__CAN_dollar_price_encoded_("04"), //

	GTIN_13_5__no_price_encoded_("05"), //

	/**
	 * AKA item/price.
	 */
	UPC_12__item_specific_("06"), //

	/**
	 * AKA item/price.
	 */
	UPC_12_5__item_specific_("07"), //

	/**
	 * AKA price/item.
	 */
	UPC_12__price_point_("08"), //

	/**
	 * AKA price/item.
	 */
	UPC_12_5__price_point_("09");

	public final String value;

	private List141(String value)
	{
		this.value = value;
	}

	private static Map<String, List141> map;

	private static Map<String, List141> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List141 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List141 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
