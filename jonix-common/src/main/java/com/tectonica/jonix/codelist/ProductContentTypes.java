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

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 81</b>
 * <p>
 * Description: Product content type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist81">ONIX
 *      Codelist 81 in Reference Guide</a>
 */
public enum ProductContentTypes implements OnixCodelist
{
	/**
	 * Readable text of the main work: this value is required, together with applicable &lt;ProductForm&gt; and
	 * &lt;ProductFormDetail&gt; values, to designate an e-book or other digital product whose primary content is
	 * eye-readable text
	 */
	Text_eye_readable("10", "Text (eye-readable)"), //

	/**
	 * E-publication is enhanced with a significant number of actionable cross-references, hyperlinked notes and
	 * annotations, or with other links between largely textual elements (eg quiz/test questions, 'choose your own
	 * ending' etc)
	 */
	Extensive_links_between_internal_content("15", "Extensive links between internal content"), //

	/**
	 * E-publication is enhanced with a significant number of actionable (clickable) web links
	 */
	Extensive_links_to_external_content("14", "Extensive links to external content"), //

	/**
	 * E-publication is enhanced with additional textual content such as interview, feature article, essay,
	 * bibliography, quiz/test, other background material or text that is not included in a primary or 'unenhanced'
	 * version
	 */
	Additional_eye_readable_text_not_part_of_main_work("16", "Additional eye-readable text not part of main work"), //

	/**
	 * eg Teaser chapter
	 */
	Promotional_text_for_other_book_product("17", "Promotional text for other book product"), //

	Musical_notation("11", "Musical notation"), //

	/**
	 * Use only when no more detailed specification is provided
	 */
	Still_images_graphics("07", "Still images / graphics"), //

	/**
	 * Whether in a plate section / insert, or not
	 */
	Photographs("18", "Photographs"), //

	/**
	 * Including other 'mechanical' (ie non-photographic) illustrations
	 */
	Figures_diagrams_charts_graphs("19", "Figures, diagrams, charts, graphs"), //

	/**
	 * E-publication is enhanced with additional images or graphical content such as supplementary photographs that are
	 * not included in a primary or 'unenhanced' version
	 */
	Additional_images_graphics_not_part_of_main_work("20", "Additional images / graphics not part of main work"), //

	Maps_and_or_other_cartographic_content("12", "Maps and/or other cartographic content"), //

	/**
	 * Audio recording of a reading of a book or other text
	 */
	Audiobook("01", "Audiobook"), //

	/**
	 * Audio recording of a drama or other spoken word performance
	 */
	Performance_spoken_word("02", "Performance – spoken word"), //

	/**
	 * eg an interview, not a 'reading' or 'performance')
	 */
	Other_speech_content("13", "Other speech content"), //

	/**
	 * Audio recording of a music performance, including musical drama and opera
	 */
	Music_recording("03", "Music recording"), //

	/**
	 * Audio recording of other sound, eg birdsong
	 */
	Other_audio("04", "Other audio"), //

	/**
	 * Audio recording of a reading, performance or dramatization of part of the work
	 */
	Partial_performance_spoken_word("21", "Partial performance – spoken word"), //

	/**
	 * Product is enhanced with audio recording of full or partial reading, performance, dramatization, interview,
	 * background documentary or other audio content not included in the primary or 'unenhanced' version
	 */
	Additional_audio_content_not_part_of_main_work("22", "Additional audio content not part of main work"), //

	/**
	 * eg Reading of teaser chapter
	 */
	Promotional_audio_for_other_book_product("23", "Promotional audio for other book product"), //

	/**
	 * Includes Film, video, animation etc. Use only when no more detailed specification is provided. Formerly 'Moving
	 * images'
	 */
	Video("06", "Video"), //

	Video_recording_of_a_reading("26", "Video recording of a reading"), //

	/**
	 * Video recording of a drama or other performance, including musical performance
	 */
	Performance_visual("27", "Performance – visual"), //

	/**
	 * eg animated diagrams, charts, graphs or other illustrations
	 */
	Animated_interactive_illustrations("24", "Animated / interactive illustrations"), //

	/**
	 * eg cartoon, animatic or CGI animation
	 */
	Narrative_animation("25", "Narrative animation"), //

	/**
	 * Other video content eg interview, not a reading or performance
	 */
	Other_video("28", "Other video"), //

	/**
	 * Video recording of a reading, performance or dramatization of part of the work
	 */
	Partial_performance_video("29", "Partial performance – video"), //

	/**
	 * E-publication is enhanced with video recording of full or partial reading, performance, dramatization, interview,
	 * background documentary or other content not included in the primary or 'unenhanced' version
	 */
	Additional_video_content_not_part_of_main_work("30", "Additional video content not part of main work"), //

	/**
	 * eg Book trailer
	 */
	Promotional_video_for_other_book_product("31", "Promotional video for other book product"), //

	/**
	 * No multi-user functionality. Formerly just 'Game'
	 */
	Game_Puzzle("05", "Game / Puzzle"), //

	/**
	 * Includes some degree of multi-user functionality
	 */
	Contest("32", "Contest"), //

	/**
	 * Largely 'content free'
	 */
	Software("08", "Software"), //

	/**
	 * Data files
	 */
	Data("09", "Data"), //

	Data_set_plus_software("33", "Data set plus software"), //

	/**
	 * Intended to be filled in by the reader
	 */
	Blank_pages("34", "Blank pages"), //

	/**
	 * Use only where type of advertising content is not stated
	 */
	Advertising_content("35", "Advertising content"), //

	/**
	 * 'Back ads' - promotional pages for other books (that do not include sample content, cf codes 17, 23)
	 */
	Advertising_first_party("37", "Advertising – first party"), //

	/**
	 * Eg to obtain discounts on other products
	 */
	Advertising_coupons("36", "Advertising – coupons"), //

	Advertising_third_party_display("38", "Advertising – third party display"), //

	Advertising_third_party_textual("39", "Advertising – third party textual");

	public final String code;
	public final String description;

	private ProductContentTypes(String code, String description)
	{
		this.code = code;
		this.description = description;
	}

	@Override
	public String getCode()
	{
		return code;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	private static volatile Map<String, ProductContentTypes> map;

	private static Map<String, ProductContentTypes> map()
	{
		Map<String, ProductContentTypes> result = map;
		if (result == null)
		{
			synchronized (ProductContentTypes.class)
			{
				result = map;
				if (result == null)
				{
					result = new HashMap<>();
					for (ProductContentTypes e : values())
						result.put(e.code, e);
					map = result;
				}
			}
		}
		return result;
	}

	public static ProductContentTypes byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
