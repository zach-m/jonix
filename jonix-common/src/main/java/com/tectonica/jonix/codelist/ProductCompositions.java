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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 2</b>
 * <p>
 * Description: Product composition
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum ProductCompositions
{
	Single_item_retail_product("00", "Single-item retail product"), //

	/**
	 * Multiple-item product retailed as a whole
	 */
	Multiple_item_retail_product("10", "Multiple-item retail product"), //

	/**
	 * Used when an ONIX record is required for a collection-as-a-whole, even though it is not currently retailed as
	 * such
	 */
	Multiple_item_collection_retailed_as_separate_parts("11", "Multiple-item collection, retailed as separate parts"), //

	/**
	 * Product not for retail, and not carrying retail items, eg empty dumpbin, empty counterpack, promotional material
	 */
	Trade_only_product("20", "Trade-only product"), //

	/**
	 * Carrying multiple copies for retailing as separate items, eg shrink-wrapped trade pack, filled dumpbin, filled
	 * counterpack
	 */
	Multiple_item_trade_pack("30", "Multiple-item trade pack"), //

	/**
	 * Carrying multiple copies, primarily for retailing as separate items. The pack may be split and retailed as
	 * separate items OR retailed as a single item. Use instead of Multiple item trade pack (code 30) only if the data
	 * provider specifically wishes to make explicit that the pack may optionally be retailed as a whole
	 */
	Multiple_item_pack("31", "Multiple-item pack");

	public final String value;
	public final String label;

	private ProductCompositions(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static ProductCompositions byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (ProductCompositions e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
