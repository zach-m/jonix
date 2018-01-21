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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 138 (Transliteration scheme code)
 */
interface CodeList138 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 138</b>
 * <p>
 * Description: Transliteration scheme code
 *
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist138">ONIX
 * Codelist 138 in Reference Guide</a>
 */
public enum TransliterationSchemes implements OnixCodelist, CodeList138 {
    /**
     * Transliteration of Cyrillic characters - Slavic languages
     */
    Finnish_standard_SFS_4900("SFS4900", "Finnish standard SFS 4900"), //

    /**
     * Transliteration and transcription of Greek characters
     */
    Finnish_standard_SFS_5807("SFS5807", "Finnish standard SFS 5807"), //

    /**
     * Transliteration of Arabic characters
     */
    Finnish_standard_SFS_5755("SFS5755", "Finnish standard SFS 5755"), //

    /**
     * Transliteration of Hebrew characters
     */
    Finnish_standard_SFS_5824("SFS3602", "Finnish standard SFS 5824"), //

    /**
     * Documentation - Romanization of Japanese (kana script)
     */
    ISO_3602("ISO3602", "ISO 3602"), //

    /**
     * Information and documentation - Romanization of Chinese
     */
    ISO_7098("ISO7098", "ISO 7098");

    public final String code;
    public final String description;

    private TransliterationSchemes(String code, String description) {
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

    public static TransliterationSchemes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (TransliterationSchemes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
