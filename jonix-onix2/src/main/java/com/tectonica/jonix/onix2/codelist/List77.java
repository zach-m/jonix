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
 * North American school or college grade
 */
public enum List77
{
	/**
	 * Age typically 0-4 years.
	 */
	Preschool("P"), //

	/**
	 * Age typically 5 years.
	 */
	Kindergarten("K"), //

	/**
	 * Age typically 6 years.
	 */
	First_Grade("1"), //

	/**
	 * Age typically 7 years.
	 */
	Second_Grade("2"), //

	/**
	 * Age typically 8 years.
	 */
	Third_Grade("3"), //

	/**
	 * Age typically 9 years.
	 */
	Fourth_Grade("4"), //

	/**
	 * Age typically 10 years.
	 */
	Fifth_Grade("5"), //

	/**
	 * Age typically 11 years.
	 */
	Sixth_Grade("6"), //

	/**
	 * Age typically 12 years.
	 */
	Seventh_Grade("7"), //

	/**
	 * Age typically 13 years.
	 */
	Eighth_Grade("8"), //

	/**
	 * High School Freshman – age typically 14 years.
	 */
	Ninth_Grade("9"), //

	/**
	 * High School Sophomore – age typically 15 years.
	 */
	Tenth_Grade("10"), //

	/**
	 * High School Junior – age typically 16 years.
	 */
	Eleventh_Grade("11"), //

	/**
	 * High School Senior – age typically 17 years.
	 */
	Twelfth_Grade("12"), //

	/**
	 * Age typically 18 years.
	 */
	College_Freshman("13"), //

	/**
	 * Age typically 19 years.
	 */
	College_Sophomore("14"), //

	/**
	 * Age typically 20 years.
	 */
	College_Junior("15"), //

	/**
	 * Age typically 21 years.
	 */
	College_Senior("16"), //

	/**
	 * Age typically 22+ years.
	 */
	College_Graduate_Student("17");

	public final String value;

	private List77(String value)
	{
		this.value = value;
	}

	private static Map<String, List77> map;

	private static Map<String, List77> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List77 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List77 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
