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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList60
 * <p>
 * Unit of pricing code
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum UnitOfPricings
{
	/**
	 * Default.
	 */
	Per_copy_of_whole_product("00"), //

	Per_page_for_printed_loose_leaf_content_only("01");

	public final String value;

	private UnitOfPricings(String value)
	{
		this.value = value;
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
