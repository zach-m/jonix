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
 * Enum that corresponds to ONIX's CodeList81
 * <p>
 * Product content type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists/">http://www.editeur.org/14/code-lists/</a>
 */
public enum ProductContentTypes
{
	/**
	 * Readable text of the main work: this value is required, together with applicable <ProductForm> and <ProductFormDetail> values, to
	 * designate an e-book or other digital product whose primary content is eye-readable text.
	 */
	Text_eye_readable("10"), //

	/**
	 * E-publication is enhanced with a significant number of actionable cross-references, hyperlinked notes and annotations, or with other
	 * links between largely textual elements (eg quiz/test questions, ‘choose your own ending’ etc).
	 */
	Extensive_links_between_internal_content("15"), //

	/**
	 * E-publication is enhanced with a significant number of actionable (clickable) web links.
	 */
	Extensive_links_to_external_content("14"), //

	/**
	 * E-publication is enhanced with additional textual content such as interview, feature article, essay, bibliography, quiz/test, other
	 * background material or text that is not included in a primary or ‘unenhanced’ version.
	 */
	Additional_eye_readable_text_not_part_of_main_work("16"), //

	/**
	 * eg Teaser chapter.
	 */
	Promotional_text_for_other_book_product("17"), //

	Musical_notation("11"), //

	/**
	 * Use only when no more detailed specification is provided.
	 */
	Still_images_graphics("07"), //

	/**
	 * Whether in a plate section / insert, or not.
	 */
	Photographs("18"), //

	/**
	 * Including other ‘mechanical’ (ie non-photographic) illustrations.
	 */
	Figures_diagrams_charts_graphs("19"), //

	/**
	 * E-publication is enhanced with additional images or graphical content such as supplementary photographs that are not included in a
	 * primary or ‘unenhanced’ version.
	 */
	Additional_images_graphics_not_part_of_main_work("20"), //

	Maps_and_or_other_cartographic_content("12"), //

	/**
	 * Audio recording of a reading of a book or other text.
	 */
	Audiobook("01"), //

	/**
	 * Audio recording of a drama or other spoken word performance.
	 */
	Performance_spoken_word("02"), //

	/**
	 * eg an interview, not a ‘reading’ or ‘performance’).
	 */
	Other_speech_content("13"), //

	/**
	 * Audio recording of a music performance, including musical drama and opera.
	 */
	Music_recording("03"), //

	/**
	 * Audio recording of other sound, eg birdsong.
	 */
	Other_audio("04"), //

	/**
	 * Audio recording of a reading, performance or dramatization of part of the work.
	 */
	Partial_performance_spoken_word("21"), //

	/**
	 * Product is enhanced with audio recording of full or partial reading, performance, dramatization, interview, background documentary or
	 * other audio content not included in the primary or ‘unenhanced’ version.
	 */
	Additional_audio_content_not_part_of_main_work("22"), //

	/**
	 * eg Reading of teaser chapter.
	 */
	Promotional_audio_for_other_book_product("23"), //

	/**
	 * Includes Film, video, animation etc. Use only when no more detailed specification is provided. Formerly ‘Moving images’.
	 */
	Video("06"), //

	Video_recording_of_a_reading("26"), //

	/**
	 * Video recording of a drama or other performance, including musical performance.
	 */
	Performance_visual("27"), //

	/**
	 * eg animated diagrams, charts, graphs or other illustrations.
	 */
	Animated_interactive_illustrations("24"), //

	/**
	 * eg cartoon, animatic or CGI animation.
	 */
	Narrative_animation("25"), //

	/**
	 * Other video content eg interview, not a reading or performance.
	 */
	Other_video("28"), //

	/**
	 * Video recording of a reading, performance or dramatization of part of the work.
	 */
	Partial_performance_video("29"), //

	/**
	 * E-publication is enhanced with video recording of full or partial reading, performance, dramatization, interview, background
	 * documentary or other content not included in the primary or ‘unenhanced’ version.
	 */
	Additional_video_content_not_part_of_main_work("30"), //

	/**
	 * eg Book trailer.
	 */
	Promotional_video_for_other_book_product("31"), //

	/**
	 * No multi-user functionality. Formerly just ‘Game’.
	 */
	Game_Puzzle("05"), //

	/**
	 * Includes some degree of multi-user functionality.
	 */
	Contest("32"), //

	/**
	 * Largely ‘content free’.
	 */
	Software("08"), //

	/**
	 * Data files.
	 */
	Data("09"), //

	Data_set_plus_software("33"), //

	/**
	 * Intended to be filled in by the reader.
	 */
	Blank_pages("34"), //

	/**
	 * Use only where type of advertising content is not stated.
	 */
	Advertising_content("35"), //

	/**
	 * ‘Back ads’ – promotional pages for other books (that do not include sample content, cf codes 17, 23).
	 */
	Advertising_first_party("37"), //

	/**
	 * Eg to obtain discounts on other products.
	 */
	Advertising_coupons("36"), //

	Advertising_third_party_display("38"), //

	Advertising_third_party_textual("39");

	public final String value;

	private ProductContentTypes(String value)
	{
		this.value = value;
	}

	private static Map<String, ProductContentTypes> map;

	private static Map<String, ProductContentTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ProductContentTypes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ProductContentTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
