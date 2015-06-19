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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList38
 * <p>
 * Image/audio/video file type code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists/">http://www.editeur.org/14/code-lists/</a>
 */
public enum ImageAudioVideoFileTypes
{
	/**
	 * Link to a location where the whole product may be found – used for epublications.
	 */
	Whole_product("01"), //

	Application_software_demo("02"), //

	/**
	 * Includes cover, back cover, spine and – where appropriate – any flaps. Quality unspecified: if sending both a standard quality and a
	 * high quality image, use 03 for standard quality and 05 for high quality.
	 */
	Image_whole_cover("03"), //

	/**
	 * Quality unspecified: if sending both a standard quality and a high quality image, use 04 for standard quality and 06 for high
	 * quality.
	 */
	Image_front_cover("04"), //

	/**
	 * Should have a minimum resolution of 300 dpi when rendered at the intended size for display or print.
	 */
	Image_whole_cover_high_quality("05"), //

	/**
	 * Should have a minimum resolution of 300 dpi when rendered at the intended size for display or print.
	 */
	Image_front_cover_high_quality("06"), //

	Image_front_cover_thumbnail("07"), //

	Image_contributor_s("08"), //

	/**
	 * Use for an image, other than a logo, that is part of the ‘branding’ of a series.
	 */
	Image_for_series("10"), //

	Image_series_logo("11"), //

	/**
	 * Use only for a logo which is specific to an individual product.
	 */
	Image_product_logo("12"), //

	Image_Master_brand_logo("16"), //

	Image_publisher_logo("17"), //

	Image_imprint_logo("18"), //

	Image_table_of_contents("22"), //

	/**
	 * Use for inside page image for book, or screenshot for software or game (revised definition from Issue 8).
	 */
	Image_sample_content("23"), //

	/**
	 * Quality unspecified: if sending both a standard quality and a high quality image, use 24 for standard quality and 25 for high
	 * quality.
	 */
	Image_back_cover("24"), //

	/**
	 * Should have a minimum resolution of 300 dpi when rendered at the intended size for display or print.
	 */
	Image_back_cover_high_quality("25"), //

	Image_back_cover_thumbnail("26"), //

	Image_other_cover_material("27"), //

	Image_promotional_material("28"), //

	Video_segment_unspecified("29"), //

	Audio_segment_unspecified("30"), //

	Video_author_presentation_commentary("31"), //

	Video_author_interview("32"), //

	Video_author_reading("33"), //

	Video_cover_material("34"), //

	Video_sample_content("35"), //

	Video_promotional_material("36"), //

	Video_review("37"), //

	Video_other_commentary_discussion("38"), //

	Audio_author_presentation_commentary("41"), //

	Audio_author_interview("42"), //

	Audio_author_reading("43"), //

	Audio_sample_content("44"), //

	Audio_promotional_material("45"), //

	Audio_review("46"), //

	Audio_other_commentary_discussion("47"), //

	/**
	 * Use for ‘look inside’ facility or ‘widget’.
	 */
	Application_sample_content("51"), //

	Application_promotional_material("52");

	public final String value;

	private ImageAudioVideoFileTypes(String value)
	{
		this.value = value;
	}

	private static Map<String, ImageAudioVideoFileTypes> map;

	private static Map<String, ImageAudioVideoFileTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ImageAudioVideoFileTypes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ImageAudioVideoFileTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
