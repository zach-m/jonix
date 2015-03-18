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

/**
 * Book form detail
 */
public enum List8
{
	/**
	 * DEPRECATED.
	 */
	A_format_paperback("01"), //

	/**
	 * ‘B’ format paperback: UK 198 x 129 mm – DEPRECATED.
	 */
	B_format_paperback("02"), //

	/**
	 * ‘C’ format paperback: UK 216 x 135 mm – DEPRECATED.
	 */
	C_format_paperback("03"), //

	/**
	 * DEPRECATED.
	 */
	Paper_over_boards("04"), //

	/**
	 * DEPRECATED.
	 */
	Cloth("05"), //

	/**
	 * DEPRECATED.
	 */
	With_dust_jacket("06"), //

	/**
	 * DEPRECATED.
	 */
	Reinforced_binding("07");

	public final String value;

	private List8(String value)
	{
		this.value = value;
	}

	public static List8 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List8 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
