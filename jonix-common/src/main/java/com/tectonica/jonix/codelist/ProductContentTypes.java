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

import com.tectonica.jonix.OnixCodelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 81 (Product content type)
 */
interface CodeList81 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 81</b>
 * <p>
 * Description: Product content type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist81">ONIX
 * Codelist 81 in Reference Guide</a>
 */
public enum ProductContentTypes implements OnixCodelist, CodeList81 {
    /**
     * Readable text of the main work: this value is required, together with applicable &lt;ProductForm&gt; and
     * &lt;ProductFormDetail&gt; values, to designate an e-book or other digital or physical product whose primary
     * content is eye-readable text
     */
    Text_eye_readable("10", "Text (eye-readable)"), //

    /**
     * E-publication contains a significant number of actionable cross-references, hyperlinked notes and annotations, or
     * with other actionable links between largely textual elements (eg quiz/test questions, 'choose your own ending'
     * etc)
     */
    Extensive_links_between_internal_content("15", "Extensive links between internal content"), //

    /**
     * E-publication contains a significant number of actionable (clickable) web links
     */
    Extensive_links_to_external_content("14", "Extensive links to external content"), //

    /**
     * Publication contains additional textual content such as interview, feature article, essay, bibliography,
     * quiz/test, other background material or text that is not included in a primary or 'unenhanced' version
     */
    Additional_eye_readable_text_not_part_of_main_work("16", "Additional eye-readable text not part of main work"), //

    /**
     * Publication contains a significant number of web links (printed URLs, QR codes etc). For use in ONIX 3.0 only
     * &lt;p&gt;NOTE: Introduced in Onix3
     */
    Additional_eye_readable_links_to_external_content("41", "Additional eye-readable links to external content"), //

    /**
     * eg Teaser chapter &lt;p&gt;NOTE: Introduced in Onix3
     */
    Promotional_text_for_other_book_product("17", "Promotional text for other book product"), //

    /**
     * null &lt;p&gt;NOTE: Introduced in Onix3
     */
    Musical_notation("11", "Musical notation"), //

    /**
     * Use only when no more detailed specification is provided &lt;p&gt;NOTE: Introduced in Onix3
     */
    Still_images_graphics("07", "Still images / graphics"), //

    /**
     * Whether in a plate section / insert, or not &lt;p&gt;NOTE: Introduced in Onix3
     */
    Photographs("18", "Photographs"), //

    /**
     * Including other 'mechanical' (ie non-photographic) illustrations &lt;p&gt;NOTE: Introduced in Onix3
     */
    Figures_diagrams_charts_graphs("19", "Figures, diagrams, charts, graphs"), //

    /**
     * Publication is enhanced with additional images or graphical content such as supplementary photographs that are
     * not included in a primary or 'unenhanced' version &lt;p&gt;NOTE: Introduced in Onix3
     */
    Additional_images_graphics_not_part_of_main_work("20", "Additional images / graphics not part of main work"), //

    /**
     * null &lt;p&gt;NOTE: Introduced in Onix3
     */
    Maps_and_or_other_cartographic_content("12", "Maps and/or other cartographic content"), //

    /**
     * eg Questions or student exercises, problems, quizzes or tests (as an integral part of the work). For use in ONIX
     * 3.0 only &lt;p&gt;NOTE: Introduced in Onix3
     */
    Assessment_material("42", "Assessment material"), //

    /**
     * Audio recording of a reading of a book or other text &lt;p&gt;NOTE: Introduced in Onix3
     */
    Audiobook("01", "Audiobook"), //

    /**
     * Audio recording of a drama or other spoken word performance &lt;p&gt;NOTE: Introduced in Onix3
     */
    Performance_spoken_word("02", "Performance – spoken word"), //

    /**
     * eg an interview, speech, lecture or discussion, not a 'reading' or 'performance') &lt;p&gt;NOTE: Introduced in
     * Onix3
     */
    Other_speech_content("13", "Other speech content"), //

    /**
     * Audio recording of a music performance, including musical drama and opera &lt;p&gt;NOTE: Introduced in Onix3
     */
    Music_recording("03", "Music recording"), //

    /**
     * Audio recording of other sound, eg birdsong &lt;p&gt;NOTE: Introduced in Onix3
     */
    Other_audio("04", "Other audio"), //

    /**
     * Audio recording of a reading, performance or dramatization of part of the work &lt;p&gt;NOTE: Introduced in
     * Onix3
     */
    Partial_performance_spoken_word("21", "Partial performance – spoken word"), //

    /**
     * Product is enhanced with audio recording of full or partial reading, performance, dramatization, interview,
     * background documentary or other audio content not included in the primary or 'unenhanced' version &lt;p&gt;NOTE:
     * Introduced in Onix3
     */
    Additional_audio_content_not_part_of_main_work("22", "Additional audio content not part of main work"), //

    /**
     * eg Reading of teaser chapter &lt;p&gt;NOTE: Introduced in Onix3
     */
    Promotional_audio_for_other_book_product("23", "Promotional audio for other book product"), //

    /**
     * Includes Film, video, animation etc. Use only when no more detailed specification is provided. Formerly 'Moving
     * images' &lt;p&gt;NOTE: Introduced in Onix3
     */
    Video("06", "Video"), //

    /**
     * null &lt;p&gt;NOTE: Introduced in Onix3
     */
    Video_recording_of_a_reading("26", "Video recording of a reading"), //

    /**
     * Video recording of a drama or other performance, including musical performance &lt;p&gt;NOTE: Introduced in
     * Onix3
     */
    Performance_visual("27", "Performance – visual"), //

    /**
     * eg animated diagrams, charts, graphs or other illustrations &lt;p&gt;NOTE: Introduced in Onix3
     */
    Animated_interactive_illustrations("24", "Animated / interactive illustrations"), //

    /**
     * eg cartoon, animatic or CGI animation &lt;p&gt;NOTE: Introduced in Onix3
     */
    Narrative_animation("25", "Narrative animation"), //

    /**
     * Other video content eg interview, not a reading or performance &lt;p&gt;NOTE: Introduced in Onix3
     */
    Other_video("28", "Other video"), //

    /**
     * Video recording of a reading, performance or dramatization of part of the work &lt;p&gt;NOTE: Introduced in
     * Onix3
     */
    Partial_performance_video("29", "Partial performance – video"), //

    /**
     * E-publication is enhanced with video recording of full or partial reading, performance, dramatization, interview,
     * background documentary or other content not included in the primary or 'unenhanced' version &lt;p&gt;NOTE:
     * Introduced in Onix3
     */
    Additional_video_content_not_part_of_main_work("30", "Additional video content not part of main work"), //

    /**
     * eg Book trailer &lt;p&gt;NOTE: Introduced in Onix3
     */
    Promotional_video_for_other_book_product("31", "Promotional video for other book product"), //

    /**
     * No multi-user functionality. Formerly just 'Game' &lt;p&gt;NOTE: Introduced in Onix3
     */
    Game_Puzzle("05", "Game / Puzzle"), //

    /**
     * Includes some degree of multi-user functionality &lt;p&gt;NOTE: Introduced in Onix3
     */
    Contest("32", "Contest"), //

    /**
     * Largely 'content free' &lt;p&gt;NOTE: Introduced in Onix3
     */
    Software("08", "Software"), //

    /**
     * Data files &lt;p&gt;NOTE: Introduced in Onix3
     */
    Data("09", "Data"), //

    /**
     * null &lt;p&gt;NOTE: Introduced in Onix3
     */
    Data_set_plus_software("33", "Data set plus software"), //

    /**
     * Entire pages or blank spaces, forms, boxes etc, intended to be filled in by the reader &lt;p&gt;NOTE: Introduced
     * in Onix3
     */
    Blank_pages_or_spaces("34", "Blank pages or spaces"), //

    /**
     * Use only where type of advertising content is not stated &lt;p&gt;NOTE: Introduced in Onix3
     */
    Advertising_content("35", "Advertising content"), //

    /**
     * 'Back ads' - promotional pages for other books (that do not include sample content, cf codes 17, 23)
     * &lt;p&gt;NOTE: Introduced in Onix3
     */
    Advertising_first_party("37", "Advertising – first party"), //

    /**
     * Eg to obtain discounts on other products &lt;p&gt;NOTE: Introduced in Onix3
     */
    Advertising_coupons("36", "Advertising – coupons"), //

    /**
     * null &lt;p&gt;NOTE: Introduced in Onix3
     */
    Advertising_third_party_display("38", "Advertising – third party display"), //

    /**
     * null &lt;p&gt;NOTE: Introduced in Onix3
     */
    Advertising_third_party_textual("39", "Advertising – third party textual"), //

    /**
     * E-publication contains microprograms written (eg) in Javascript and executed within the reading system. For use
     * in ONIX 3.0 only &lt;p&gt;NOTE: Introduced in Onix3
     */
    Scripting("40", "Scripting"), //

    /**
     * eg Teaser chapter &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Promotional_text_for_other_book_product_("17", "Promotional text for other book product"), //

    /**
     * null &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Musical_notation_("11", "Musical notation"), //

    /**
     * Use only when no more detailed specification is provided &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Still_images_graphics_("07", "Still images / graphics"), //

    /**
     * Whether in a plate section / insert, or not &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Photographs_("18", "Photographs"), //

    /**
     * Including other 'mechanical' (ie non-photographic) illustrations &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Figures_diagrams_charts_graphs_("19", "Figures, diagrams, charts, graphs"), //

    /**
     * E-publication is enhanced with additional images or graphical content such as supplementary photographs that are
     * not included in a primary or 'unenhanced' version &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Additional_images_graphics_not_part_of_main_work_("20", "Additional images / graphics not part of main work"), //

    /**
     * null &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Maps_and_or_other_cartographic_content_("12", "Maps and/or other cartographic content"), //

    /**
     * Audio recording of a reading of a book or other text &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Audiobook_("01", "Audiobook"), //

    /**
     * Audio recording of a drama or other spoken word performance &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Performance_spoken_word_("02", "Performance – spoken word"), //

    /**
     * eg an interview, not a 'reading' or 'performance') &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Other_speech_content_("13", "Other speech content"), //

    /**
     * Audio recording of a music performance, including musical drama and opera &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Music_recording_("03", "Music recording"), //

    /**
     * Audio recording of other sound, eg birdsong &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Other_audio_("04", "Other audio"), //

    /**
     * Audio recording of a reading, performance or dramatization of part of the work &lt;p&gt;NOTE: Deprecated in
     * Onix3
     */
    Partial_performance_spoken_word_("21", "Partial performance – spoken word"), //

    /**
     * Product is enhanced with audio recording of full or partial reading, performance, dramatization, interview,
     * background documentary or other audio content not included in the primary or 'unenhanced' version &lt;p&gt;NOTE:
     * Deprecated in Onix3
     */
    Additional_audio_content_not_part_of_main_work_("22", "Additional audio content not part of main work"), //

    /**
     * eg Reading of teaser chapter &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Promotional_audio_for_other_book_product_("23", "Promotional audio for other book product"), //

    /**
     * Includes Film, video, animation etc. Use only when no more detailed specification is provided. Formerly 'Moving
     * images' &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Video_("06", "Video"), //

    /**
     * null &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Video_recording_of_a_reading_("26", "Video recording of a reading"), //

    /**
     * Video recording of a drama or other performance, including musical performance &lt;p&gt;NOTE: Deprecated in
     * Onix3
     */
    Performance_visual_("27", "Performance – visual"), //

    /**
     * eg animated diagrams, charts, graphs or other illustrations &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Animated_interactive_illustrations_("24", "Animated / interactive illustrations"), //

    /**
     * eg cartoon, animatic or CGI animation &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Narrative_animation_("25", "Narrative animation"), //

    /**
     * Other video content eg interview, not a reading or performance &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Other_video_("28", "Other video"), //

    /**
     * Video recording of a reading, performance or dramatization of part of the work &lt;p&gt;NOTE: Deprecated in
     * Onix3
     */
    Partial_performance_video_("29", "Partial performance – video"), //

    /**
     * E-publication is enhanced with video recording of full or partial reading, performance, dramatization, interview,
     * background documentary or other content not included in the primary or 'unenhanced' version &lt;p&gt;NOTE:
     * Deprecated in Onix3
     */
    Additional_video_content_not_part_of_main_work_("30", "Additional video content not part of main work"), //

    /**
     * eg Book trailer &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Promotional_video_for_other_book_product_("31", "Promotional video for other book product"), //

    /**
     * No multi-user functionality. Formerly just 'Game' &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Game_Puzzle_("05", "Game / Puzzle"), //

    /**
     * Includes some degree of multi-user functionality &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Contest_("32", "Contest"), //

    /**
     * Largely 'content free' &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Software_("08", "Software"), //

    /**
     * Data files &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Data_("09", "Data"), //

    /**
     * null &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Data_set_plus_software_("33", "Data set plus software"), //

    /**
     * Intended to be filled in by the reader &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Blank_pages("34", "Blank pages"), //

    /**
     * Use only where type of advertising content is not stated &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Advertising_content_("35", "Advertising content"), //

    /**
     * 'Back ads' - promotional pages for other books (that do not include sample content, cf codes 17, 23)
     * &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Advertising_first_party_("37", "Advertising – first party"), //

    /**
     * Eg to obtain discounts on other products &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Advertising_coupons_("36", "Advertising – coupons"), //

    /**
     * null &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Advertising_third_party_display_("38", "Advertising – third party display"), //

    /**
     * null &lt;p&gt;NOTE: Deprecated in Onix3
     */
    Advertising_third_party_textual_("39", "Advertising – third party textual");

    public final String code;
    public final String description;

    ProductContentTypes(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private static volatile Map<String, ProductContentTypes> map;

    private static Map<String, ProductContentTypes> map() {
        Map<String, ProductContentTypes> result = map;
        if (result == null) {
            synchronized (ProductContentTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ProductContentTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ProductContentTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
