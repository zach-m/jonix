/*
 * Copyright (C) 2012-2024 Zach Melamed
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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_67.html#codelist81">ONIX
 *      Codelist 81 in Reference Guide</a>
 */
public enum ProductContentTypes implements OnixCodelist, CodeList81 {
    /**
     * Readable text of the main content: this value is required, together with applicable &lt;ProductForm&gt; and
     * &lt;ProductFormDetail&gt; values, to designate an e-book or other digital or physical product whose primary
     * content is text. Note 'text' is 'text-as-text', not 'text as an image' or images of text
     */
    Text("10", "Text"),

    /**
     * E-publication contains a significant number of actionable (clickable) cross-references, hyperlinked notes and
     * annotations, or with other actionable links between largely textual elements (eg quiz/test questions, 'choose
     * your own ending' etc)
     */
    Extensive_links_between_internal_content("15", "Extensive links between internal content"),

    /**
     * E-publication contains a significant number of actionable (clickable) web links to external content, downloadable
     * resources, supplementary material, etc
     */
    Extensive_links_to_external_content("14", "Extensive links to external content"),

    /**
     * Publication contains actionable (clickable) links to external interactive content. Only for use in ONIX 3.0 or
     * later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Links_to_external_interactive_content("51", "Links to external interactive content"),

    /**
     * Publication contains additional textual content such as an interview, feature article, essay, bibliography,
     * quiz/test, other background material, or text that is not included in a primary or 'unenhanced' version. Note
     * 'text' is 'text-as-text', not 'text as an image' or images of text
     */
    Additional_text_not_part_of_main_content("16", "Additional text not part of main content"),

    /**
     * Including text-as-text embedded in diagrams, charts, or within images containing speech balloons, thought
     * bubbles, captions etc. Note this does not include 'text as an image' or images of text (for which see code 49).
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Text_within_images("45", "Text within images"),

    /**
     * Publication contains a significant number of web links (printed URLs, QR codes etc). Only for use in ONIX 3.0 or
     * later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Additional_eye_readable_links_to_external_content("41", "Additional eye-readable links to external content"),

    /**
     * Publication contains supplementary text as promotional content such as, for example, a teaser chapter
     */
    Promotional_text_for_other_book_product("17", "Promotional text for other book product"),

    Musical_notation("11", "Musical notation"),

    /**
     * Includes any type of illustrations. Use only when no more detailed specification is provided
     */
    Still_images_graphics("07", "Still images / graphics"),

    /**
     * Whether in a plate section / insert, or not
     */
    Photographs("18", "Photographs"),

    /**
     * Including other 'mechanical' (ie non-photographic) illustrations
     */
    Figures_diagrams_charts_graphs("19", "Figures, diagrams, charts, graphs"),

    /**
     * Publication is enhanced with additional images or graphical content such as supplementary photographs that are
     * not included in a primary or 'unenhanced' version
     */
    Additional_images_graphics_not_part_of_main_work("20", "Additional images / graphics not part of main work"),

    Maps_and_or_other_cartographic_content("12", "Maps and/or other cartographic content"),

    /**
     * Indicates that the publication contains chemical notations, formulae. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Chemical_content("47", "Chemical content"),

    /**
     * Indicates that the publication contains mathematical notation, equations, formulae. Only for use in ONIX 3.0 or
     * later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Mathematical_content("48", "Mathematical content"),

    /**
     * Publication contains visual content that is purely decorative and are not necessary to understanding of the
     * content. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Decorative_images_or_graphics("46", "Decorative images or graphics"),

    /**
     * eg Questions or student exercises, problems, quizzes or tests (as an integral part of the work). Only for use in
     * ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Assessment_material("42", "Assessment material"),

    /**
     * Audio recording of a reading of a book or other text
     */
    Audiobook("01", "Audiobook"),

    /**
     * Audio recording of a drama or other spoken word performance
     */
    Performance_spoken_word("02", "Performance – spoken word"),

    /**
     * eg an interview, speech, lecture or commentary / discussion, not a 'reading' or 'performance')
     */
    Other_speech_content("13", "Other speech content"),

    /**
     * Audio recording of a music performance, including musical drama and opera
     */
    Music_recording("03", "Music recording"),

    /**
     * Audio recording of other sound, eg birdsong, sound effects, ASMR material
     */
    Other_audio("04", "Other audio"),

    /**
     * At least some text - including text within other images - is 'text as an image' (ie a picture of text). Only for
     * use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Images_of_text("49", "Images of text"),

    /**
     * Audio recording of a reading, performance or dramatization of part of the work
     */
    Partial_performance_spoken_word("21", "Partial performance – spoken word"),

    /**
     * Product includes additional pre-recorded audio of any supplementary material such as full or partial reading,
     * lecture, performance, dramatization, interview, background documentary or other audio content not included in the
     * primary or 'unenhanced' version
     */
    Additional_audio_content_not_part_of_main_content("22", "Additional audio content not part of main content"),

    /**
     * eg Reading of teaser chapter
     */
    Promotional_audio_for_other_book_product("23", "Promotional audio for other book product"),

    /**
     * Includes Film, video, animation etc. Use only when no more detailed specification is provided. Formerly 'Moving
     * images'
     */
    Video("06", "Video"),

    Video_recording_of_a_reading("26", "Video recording of a reading"),

    /**
     * Publication contains video material with no audio recording or narration (but may have music or textual
     * subtitles) . Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Video_content_without_audio("50", "Video content without audio"),

    /**
     * Video recording of a drama or other performance, including musical performance
     */
    Performance_visual("27", "Performance – visual"),

    /**
     * eg animated diagrams, charts, graphs or other illustrations (usually without sound)
     */
    Animated_interactive_illustrations("24", "Animated / interactive illustrations"),

    /**
     * eg cartoon, animatic or CGI animation (usually includes sound)
     */
    Narrative_animation("25", "Narrative animation"),

    /**
     * Other video content eg interview, not a reading or performance
     */
    Other_video("28", "Other video"),

    /**
     * Video recording of a reading, performance or dramatization of part of the work
     */
    Partial_performance_video("29", "Partial performance – video"),

    /**
     * E-publication is enhanced with video recording of full or partial reading, performance, dramatization, interview,
     * background documentary or other content not included in the primary or 'unenhanced' version
     */
    Additional_video_content_not_part_of_main_work("30", "Additional video content not part of main work"),

    /**
     * eg Book trailer
     */
    Promotional_video_for_other_book_product("31", "Promotional video for other book product"),

    /**
     * No multi-user functionality. Formerly just 'Game'
     */
    Game_Puzzle("05", "Game / Puzzle"),

    /**
     * Includes some degree of multi-user functionality
     */
    Contest("32", "Contest"),

    /**
     * Largely 'content free'
     */
    Software("08", "Software"),

    /**
     * Data files
     */
    Data("09", "Data"),

    Data_set_plus_software("33", "Data set plus software"),

    /**
     * Entire pages or blank spaces, forms, boxes, write-in pages etc, intended to be filled in by the reader
     */
    Blank_pages_or_spaces("34", "Blank pages or spaces"),

    /**
     * Use only where type of advertising content is not stated
     */
    Advertising_content("35", "Advertising content"),

    /**
     * 'Back ads' - promotional content for other books (that does not include sample content of those books, cf codes
     * 17, 23)
     */
    Advertising_first_party("37", "Advertising – first party"),

    /**
     * Eg to obtain discounts on other products
     */
    Advertising_coupons("36", "Advertising – coupons"),

    Advertising_third_party_display("38", "Advertising – third party display"),

    Advertising_third_party_textual("39", "Advertising – third party textual"),

    /**
     * E-publication contains microprograms written (eg) in Javascript and executed within the reading system. Only for
     * use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Scripting("40", "Scripting"),

    /**
     * E-publication contains pop-ups or other functionality offering (eg) term definitions, cross-links or glossary
     * entries [Note this should not include (eg) dictionary functionality that is part of the reading system.] Only for
     * use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Scripted_pop_ups("43", "Scripted pop-ups"),

    /**
     * Or pictorial narrative, usually panel-based. Images displayed in a specific order for the purpose of graphic
     * storytelling or giving information (eg graphic novels, comics and manga). May include text integrated into the
     * image (as speech and thought bubbles, textual 'sound' effects, captions etc). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Sequential_art("44", "Sequential art");

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

    public static Optional<ProductContentTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
