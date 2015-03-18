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

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * ONIX Adult Audience rating
 */
public enum List203
{
	Unrated("00"), //

	/**
	 * The publisher states that the product is suitable for any adult audience.
	 */
	Any_adult_audience("01"), //

	/**
	 * The publisher warns the content may offend parts of the adult audience (for any reason).
	 */
	Content_warning("02"), //

	/**
	 * The publisher warns the product includes content of an explicit sexual nature.
	 */
	Content_warning__sex_("03"), //

	/**
	 * The publisher warns the product includes content of a violent nature.
	 */
	Content_warning__violence_("04"), //

	/**
	 * The publisher warns the product includes content involving misuse of drugs.
	 */
	Content_warning__drug_taking_("05"), //

	/**
	 * The publisher warns the product includes extreme / offensive / explicit language.
	 */
	Content_warning__language_("06"), //

	/**
	 * The publisher warns the product includes content involving intolerance of particular groups (eg religious, ethnic, racial, social).
	 */
	Content_warning__intolerance_("07");

	public final String value;

	private List203(String value)
	{
		this.value = value;
	}

	private static Map<String, List203> map;

	private static Map<String, List203> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List203 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List203 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
