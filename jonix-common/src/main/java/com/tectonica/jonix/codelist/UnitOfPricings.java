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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 60</b>
 * <p>
 * Description: Unit of pricing code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist60">ONIX
 *      Codelist 60 in Reference Guide</a>
 */
public enum UnitOfPricings
{
	/**
	 * Default
	 */
	Per_copy_of_whole_product("00", "Per copy of whole product"), //

	Per_page_for_printed_loose_leaf_content_only("01", "Per page for printed loose-leaf content only");

	public final String value;
	public final String label;

	private UnitOfPricings(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static UnitOfPricings byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (UnitOfPricings e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
