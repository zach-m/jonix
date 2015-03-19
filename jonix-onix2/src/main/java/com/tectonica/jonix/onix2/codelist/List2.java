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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Product composition
 */
public enum List2
{
	Single_item_retail_product("00"), //

	/**
	 * Multiple-item product retailed as a whole.
	 */
	Multiple_item_retail_product("10"), //

	/**
	 * Used when an ONIX record is required for a collection-as-a-whole, even though it is not currently retailed as such.
	 */
	Multiple_item_collection_retailed_as_separate_parts("11"), //

	/**
	 * Product not for retail, and not carrying retail items, eg empty dumpbin, empty counterpack, promotional material.
	 */
	Trade_only_product("20"), //

	/**
	 * Carrying multiple copies for retailing as separate items, eg shrink-wrapped trade pack, filled dumpbin, filled counterpack.
	 */
	Multiple_item_trade_pack("30"), //

	/**
	 * Carrying multiple copies, primarily for retailing as separate items. The pack may be split and retailed as separate items OR retailed
	 * as a single item. Use instead of Multiple item trade pack (code 30) only if the data provider specifically wishes to make explicit
	 * that the pack may optionally be retailed as a whole.
	 */
	Multiple_item_pack("31");

	public final String value;

	private List2(String value)
	{
		this.value = value;
	}

	public static List2 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List2 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
