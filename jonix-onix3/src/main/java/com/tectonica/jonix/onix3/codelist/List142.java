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

package com.tectonica.jonix.onix3.codelist;

import java.util.HashMap;
import java.util.Map;

/**
 * Position on product
 */
public enum List142
{
	/**
	 * Position unknown or unspecified.
	 */
	Unknown___unspecified("00"), //

	/**
	 * The back cover of a book.
	 */
	Cover_4("01"), //

	/**
	 * The inside back cover of a book.
	 */
	Cover_3("02"), //

	/**
	 * The inside front cover of a book.
	 */
	Cover_2("03"), //

	/**
	 * The front cover of a book.
	 */
	Cover_1("04"), //

	/**
	 * The spine of a book.
	 */
	On_spine("05"), //

	/**
	 * Used only for boxed products.
	 */
	On_box("06"), //

	/**
	 * Used only for products fitted with hanging tags.
	 */
	On_tag("07"), //

	/**
	 * Not be used for books unless they are contained within outer packaging.
	 */
	On_bottom("08"), //

	/**
	 * Not be used for books unless they are contained within outer packaging.
	 */
	On_back("09"), //

	/**
	 * Used only for products packaged in outer sleeves.
	 */
	On_outer_sleeve___back("10"), //

	/**
	 * Used only for products packaged in shrink-wrap or other removable wrapping.
	 */
	On_removable_wrapping("11");

	public final String value;

	private List142(String value)
	{
		this.value = value;
	}

	private static Map<String, List142> map;

	private static Map<String, List142> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List142 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List142 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
