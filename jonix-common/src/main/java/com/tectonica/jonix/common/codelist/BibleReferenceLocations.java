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

import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 87 (Bible reference location)
 */
interface CodeList87 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 87</b>
 * <p>
 * Description: Bible reference location
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_62.html#codelist87">ONIX
 *      Codelist 87 in Reference Guide</a>
 */
public enum BibleReferenceLocations implements OnixCodelist, CodeList87 {
    /**
     * References are printed in a narrow column in the center of the page between two columns of text
     */
    Center_column("CCL", "Center column"),

    /**
     * References are printed at the foot of the page
     */
    Page_end("PGE", "Page end"),

    /**
     * References are printed in a column to the side of the scripture
     */
    Side_column("SID", "Side column"),

    /**
     * References are printed at the end of the applicable verse
     */
    Verse_end("VER", "Verse end"),

    /**
     * The person creating the ONIX record does not know where the references are located
     */
    Unknown("UNK", "Unknown"),

    /**
     * Other locations not otherwise identified
     */
    Other("ZZZ", "Other");

    public final String code;
    public final String description;

    BibleReferenceLocations(String code, String description) {
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

    public static BibleReferenceLocations byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (BibleReferenceLocations e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<BibleReferenceLocations> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
