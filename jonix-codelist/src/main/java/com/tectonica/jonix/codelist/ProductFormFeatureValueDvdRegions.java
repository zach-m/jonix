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

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList76
 * <p>
 * Product form feature value – DVD region codes
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum ProductFormFeatureValueDvdRegions
{
	/**
	 * DVD or Blu-Ray.
	 */
	All_regions("0"), //

	/**
	 * US, US Territories, Canada.
	 */
	DVD_region_1("1"), //

	/**
	 * Japan, Europe, South Africa and Middle East (including Egypt).
	 */
	DVD_region_2("2"), //

	/**
	 * Southeast Asia, Hong Kong, Macau, South Korea, and Taiwan.
	 */
	DVD_region_3("3"), //

	/**
	 * Australia, New Zealand, Pacific Islands, Central America, Mexico, South America and the Caribbean.
	 */
	DVD_region_4("4"), //

	/**
	 * Eastern Europe (former Soviet Union), Indian subcontinent, Africa, North Korea and Mongolia.
	 */
	DVD_region_5("5"), //

	/**
	 * People’s Republic of China (except Macau and Hong Kong).
	 */
	DVD_region_6("6"), //

	/**
	 * Reserved for future use.
	 */
	DVD_region_7("7"), //

	/**
	 * International venues: aircraft, cruise ships etc.
	 */
	DVD_region_8("8"), //

	/**
	 * North America, Central America, South America, Japan, Taiwan, North Korea, South Korea, Hong Kong, and Southeast Asia.
	 */
	Blu_Ray_region_A("A"), //

	/**
	 * Most of Europe, Greenland, French territories, Middle East, Africa, Australia, and New Zealand, plus all of Oceania.
	 */
	Blu_Ray_region_B("B"), //

	/**
	 * India, Bangladesh, Nepal, Mainland China, Pakistan, Russia, Ukraine, Belarus, Central, and South Asia.
	 */
	Blu_Ray_region_C("C");

	public final String value;

	private ProductFormFeatureValueDvdRegions(String value)
	{
		this.value = value;
	}

	private static Map<String, ProductFormFeatureValueDvdRegions> map;

	private static Map<String, ProductFormFeatureValueDvdRegions> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ProductFormFeatureValueDvdRegions e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ProductFormFeatureValueDvdRegions byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
