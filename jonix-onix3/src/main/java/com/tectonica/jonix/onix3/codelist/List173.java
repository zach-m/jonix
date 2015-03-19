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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Price date role
 */
public enum List173
{
	/**
	 * Date on which a price becomes effective.
	 */
	From_date("14"), //

	/**
	 * Date on which a price ceases to be effective.
	 */
	Until_date("15"), //

	/**
	 * Combines From date and Until date to define a period (both dates are inclusive). Use with for example dateformat 06.
	 */
	From_until_date("24");

	public final String value;

	private List173(String value)
	{
		this.value = value;
	}

	public static List173 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List173 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
