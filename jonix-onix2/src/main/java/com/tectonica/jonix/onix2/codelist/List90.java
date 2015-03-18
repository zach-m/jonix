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
 * Religious text feature code
 */
public enum List90
{
	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Academic_year("01"), //

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Catechistic_year("02"), //

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Liturgical_year("03"), //

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Advent_and_Christmas("04"), //

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Blessings("05"), //

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Scholastic_cycles("06"), //

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Confirmation_and_Holy_Communion("07"), //

	/**
	 * For example, summer camps and other youth recreational activities: use with code 01 in <ReligiousTextFeatureType>.
	 */
	Summer_activites("08"), //

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Easter("09"), //

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Lent("10"), //

	/**
	 * Use with code 01 in <ReligiousTextFeatureType>.
	 */
	Marian_themes("11");

	public final String value;

	private List90(String value)
	{
		this.value = value;
	}

	private static Map<String, List90> map;

	private static Map<String, List90> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List90 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List90 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
