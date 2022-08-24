/*
 * Copyright (C) 2012-2022 Zach Melamed
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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 156 (Cited content type)
 */
interface CodeList156 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 156</b>
 * <p>
 * Description: Cited content type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_58.html#codelist156">ONIX
 *      Codelist 156 in Reference Guide</a>
 */
public enum CitedContentTypes implements OnixCodelist, CodeList156 {
    /**
     * The full text of a review in a third-party publication in any medium
     */
    Review("01", "Review"),

    Bestseller_list("02", "Bestseller list"),

    /**
     * Other than a review
     */
    Media_mention("03", "Media mention"),

    /**
     * Inclusion in a program such as 'Chicago Reads', 'Seattle Reads', 'Canada Reads', 'One Dublin, one book'
     */
    One_locality_one_book_program("04", "‘One locality, one book’ program"),

    /**
     * For example a 'best books of the year' or '25 books you should have read' list, without regard to their
     * bestseller status
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Curated_list("05", "Curated list"),

    /**
     * For example a third party podcast episode, social media message, newsletter issue, other commentary (see also
     * code 03 for very brief items)
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Commentary_discussion("06", "Commentary / discussion");

    public final String code;
    public final String description;

    CitedContentTypes(String code, String description) {
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

    public static CitedContentTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (CitedContentTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
