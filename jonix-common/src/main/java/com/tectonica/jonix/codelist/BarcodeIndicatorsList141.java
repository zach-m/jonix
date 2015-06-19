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

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList141
 * <p>
 * Barcode indicator
 * 
 * @see <a href="http://www.editeur.org/14/code-lists/">http://www.editeur.org/14/code-lists/</a>
 */
public enum BarcodeIndicatorsList141
{
	Not_barcoded("00"), //

	Barcoded_scheme_unspecified("01"), //

	GTIN_13("02"), //

	GTIN_13_5_US_dollar_price_encoded("03"), //

	GTIN_13_5_CAN_dollar_price_encoded("04"), //

	GTIN_13_5_no_price_encoded("05"), //

	/**
	 * AKA item/price.
	 */
	UPC_12_item_specific("06"), //

	/**
	 * AKA item/price.
	 */
	UPC_12_5_item_specific("07"), //

	/**
	 * AKA price/item.
	 */
	UPC_12_price_point("08"), //

	/**
	 * AKA price/item.
	 */
	UPC_12_5_price_point("09");

	public final String value;

	private BarcodeIndicatorsList141(String value)
	{
		this.value = value;
	}

	private static Map<String, BarcodeIndicatorsList141> map;

	private static Map<String, BarcodeIndicatorsList141> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (BarcodeIndicatorsList141 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static BarcodeIndicatorsList141 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
