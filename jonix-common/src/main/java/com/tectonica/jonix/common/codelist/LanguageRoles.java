/*
 * Copyright (C) 2012-2023 Zach Melamed
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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 22 (Language role)
 */
interface CodeList22 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 22</b>
 * <p>
 * Description: Language role
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_61.html#codelist22">ONIX
 *      Codelist 22 in Reference Guide</a>
 */
public enum LanguageRoles implements OnixCodelist, CodeList22 {
    Language_of_text("01", "Language of text"),

    /**
     * Where the text in the original language is NOT part of the current product
     */
    Original_language_of_a_translated_text("02", "Original language of a translated text"),

    /**
     * Where different from language of text: used mainly for serials
     */
    Language_of_abstracts("03", "Language of abstracts"),

    /**
     * Where the text in the original language is part of a bilingual or multilingual product
     */
    Original_language_in_a_multilingual_edition("06", "Original language in a multilingual edition"),

    /**
     * Where the text in a translated language is part of a bilingual or multilingual product
     */
    Translated_language_in_a_multilingual_edition("07", "Translated language in a multilingual edition"),

    /**
     * For example, on an audiobook or video product. Use for the only available audio track, or where there are
     * multiple tracks (eg on a DVD), for an alternate language audio track that is NOT the original. (In the latter
     * case, use code 11 for the original language audio if it is included in the product, or code 10 to identify an
     * original language that is not present in the product)
     */
    Language_of_audio_track("08", "Language of audio track"),

    /**
     * For example, on a DVD
     */
    Language_of_subtitles("09", "Language of subtitles"),

    /**
     * Where the audio in the original language is NOT part of the current product
     */
    Language_of_original_audio_track("10", "Language of original audio track"),

    /**
     * Where the audio in the original language is part of a multilingual product with multiple audio tracks
     */
    Original_language_audio_track_in_a_multilingual_product("11",
        "Original language audio track in a multilingual product"),

    /**
     * Use for the language of footnotes, endnotes, annotations or commentary, instructions or guidance for use etc,
     * where it is different from the language of the main text
     */
    Language_of_notes("12", "Language of notes"),

    /**
     * Use for the language of any introductory text, prologue, etc, or epilogue, end matter, etc, where it is different
     * from the language of the main text. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Language_of_introduction_end_matter("13", "Language of introduction / end matter"),

    /**
     * Eg for the book 'Ingles para latinos', English. For phrasebooks and language teaching, learning or study
     * material. Wherever possible, the language should also be listed as the subject of the book. Only for use in ONIX
     * 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Target_language_of_teaching_learning("14", "Target language of teaching / learning"),

    /**
     * Use of significant words, phrases, quotations or short passages from a language other than the main language of
     * the text, as an integral part of the text. This does not include 'loanwords', academic Latin, etc. Only for use
     * in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Additional_vocabulary_text_in_this_language("15", "Additional vocabulary / text in this language"),

    /**
     * Language to which specified rights apply
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Rights_language("04", "Rights language"),

    /**
     * Language to which specified rights do not apply
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Rights_excluded_language("05", "Rights-excluded language");

    public final String code;
    public final String description;

    LanguageRoles(String code, String description) {
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

    private static volatile Map<String, LanguageRoles> map;

    private static Map<String, LanguageRoles> map() {
        Map<String, LanguageRoles> result = map;
        if (result == null) {
            synchronized (LanguageRoles.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (LanguageRoles e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static LanguageRoles byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
