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
 * Image/audio/video file type code
 */
public enum List38
{
	/**
	 * Link to a location where the whole product may be found – used for epublications.
	 */
	Whole_product("01"), //

	Application__software_demo("02"), //

	/**
	 * Includes cover, back cover, spine and – where appropriate – any flaps. Quality unspecified: if sending both a standard quality and a
	 * high quality image, use 03 for standard quality and 05 for high quality.
	 */
	Image__whole_cover("03"), //

	/**
	 * Quality unspecified: if sending both a standard quality and a high quality image, use 04 for standard quality and 06 for high
	 * quality.
	 */
	Image__front_cover("04"), //

	/**
	 * Should have a minimum resolution of 300 dpi when rendered at the intended size for display or print.
	 */
	Image__whole_cover__high_quality("05"), //

	/**
	 * Should have a minimum resolution of 300 dpi when rendered at the intended size for display or print.
	 */
	Image__front_cover__high_quality("06"), //

	Image__front_cover_thumbnail("07"), //

	Image__contributor_s_("08"), //

	/**
	 * Use for an image, other than a logo, that is part of the ‘branding’ of a series.
	 */
	Image__for_series("10"), //

	Image__series_logo("11"), //

	/**
	 * Use only for a logo which is specific to an individual product.
	 */
	Image__product_logo("12"), //

	Image__Master_brand_logo("16"), //

	Image__publisher_logo("17"), //

	Image__imprint_logo("18"), //

	Image__table_of_contents("22"), //

	/**
	 * Use for inside page image for book, or screenshot for software or game (revised definition from Issue 8).
	 */
	Image__sample_content("23"), //

	/**
	 * Quality unspecified: if sending both a standard quality and a high quality image, use 24 for standard quality and 25 for high
	 * quality.
	 */
	Image__back_cover("24"), //

	/**
	 * Should have a minimum resolution of 300 dpi when rendered at the intended size for display or print.
	 */
	Image__back_cover__high_quality("25"), //

	Image__back_cover_thumbnail("26"), //

	Image__other_cover_material("27"), //

	Image__promotional_material("28"), //

	Video_segment__unspecified("29"), //

	Audio_segment__unspecified("30"), //

	Video__author_presentation___commentary("31"), //

	Video__author_interview("32"), //

	Video__author_reading("33"), //

	Video__cover_material("34"), //

	Video__sample_content("35"), //

	Video__promotional_material("36"), //

	Video__review("37"), //

	Video__other_commentary___discussion("38"), //

	Audio__author_presentation___commentary("41"), //

	Audio__author_interview("42"), //

	Audio__author_reading("43"), //

	Audio__sample_content("44"), //

	Audio__promotional_material("45"), //

	Audio__review("46"), //

	Audio__other_commentary___discussion("47"), //

	/**
	 * Use for ‘look inside’ facility or ‘widget’.
	 */
	Application__sample_content("51"), //

	Application__promotional_material("52");

	public final String value;

	private List38(String value)
	{
		this.value = value;
	}

	private static Map<String, List38> map;

	private static Map<String, List38> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List38 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List38 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
