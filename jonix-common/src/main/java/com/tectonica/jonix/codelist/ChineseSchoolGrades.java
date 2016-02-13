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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 227</b>
 * <p>
 * Description: Chinese School Grade Code &lt;p&gt;NOTE: Introduced in Onix3
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum ChineseSchoolGrades
{
	/**
	 * Typical age less than 3
	 */
	Preschool("P"), //

	/**
	 * Typical age 3&#8211;5
	 */
	Kindergarten("K"), //

	/**
	 * Typical age 6
	 */
	Primary_school_First_grade("1"), //

	/**
	 * Typical age 7
	 */
	Primary_school_Second_grade("2"), //

	/**
	 * Typical age 8
	 */
	Primary_school_Third_grade("3"), //

	/**
	 * Typical age 9
	 */
	Primary_school_Fourth_grade("4"), //

	/**
	 * Typical age 10
	 */
	Primary_school_Fifth_grade("5"), //

	/**
	 * Typical age 11
	 */
	Primary_school_Sixth_grade("6"), //

	/**
	 * Typical age 12
	 */
	Junior_secondary_school_Seventh_grade("7"), //

	/**
	 * Typical age 13
	 */
	Junior_secondary_school_Eighth_grade("8"), //

	/**
	 * Typical age 14
	 */
	Junior_secondary_school_Ninth_grade("9"), //

	/**
	 * Typical age 15
	 */
	Senior_secondary_school_Tenth_grade("10"), //

	/**
	 * Typical age 16
	 */
	Senior_secondary_school_Eleventh_grade("11"), //

	/**
	 * Typical age 17
	 */
	Senior_secondary_school_Twelfth_grade("12"), //

	/**
	 * Typical age 18
	 */
	University_first_year("13"), //

	/**
	 * Typical age 19
	 */
	University_second_year("14"), //

	/**
	 * Typical age 20
	 */
	University_third_year("15"), //

	/**
	 * Typical age 21
	 */
	University_fourth_year("16"), //

	/**
	 * Typical age 22+
	 */
	Graduate_level("17");

	public final String value;

	private ChineseSchoolGrades(String value)
	{
		this.value = value;
	}

	private static Map<String, ChineseSchoolGrades> map;

	private static Map<String, ChineseSchoolGrades> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ChineseSchoolGrades e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ChineseSchoolGrades byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
