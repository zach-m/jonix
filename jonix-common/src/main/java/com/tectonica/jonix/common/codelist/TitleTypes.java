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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 15 (Title type)
 */
interface CodeList15 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 15</b>
 * <p>
 * Description: Title type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist15">ONIX
 *      Codelist 15 in Reference Guide</a>
 */
public enum TitleTypes implements OnixCodelist, CodeList15 {
    Undefined("00", "Undefined"),

    /**
     * The full text of the distinctive title of the item, without abbreviation or abridgement. For books, where the
     * title alone is not distinctive, elements may be taken from a set or series title and part number etc to create a
     * distinctive title. Where the item is an omnibus edition containing two or more works by the same author, and
     * there is no separate combined title, a distinctive title may be constructed by concatenating the individual
     * titles, with suitable punctuation, as in 'Pride and prejudice / Sense and sensibility / Northanger Abbey'
     */
    Distinctive_title_book("01",
        "Distinctive title (book); Cover title (serial); Title on item (serial content item or reviewed resource)"),

    /**
     * Serials only
     */
    ISSN_key_title_of_serial("02", "ISSN key title of serial"),

    /**
     * Where the subject of the ONIX record is a translated item
     */
    Title_in_original_language("03", "Title in original language"),

    /**
     * For serials: an acronym or initialism of Title Type 01, eg 'JAMA', 'JACM'
     */
    Title_acronym_or_initialism("04", "Title acronym or initialism"),

    /**
     * An abbreviated form of Title Type 01
     */
    Abbreviated_title("05", "Abbreviated title"),

    /**
     * A translation of Title Type 01 into another language
     */
    Title_in_other_language("06", "Title in other language"),

    /**
     * Serials only: when a journal issue is explicitly devoted to a specified topic
     */
    Thematic_title_of_journal_issue("07", "Thematic title of journal issue"),

    /**
     * Books or serials: when an item was previously published under another title
     */
    Former_title("08", "Former title"),

    /**
     * For books: the title carried in a book distributor's title file: frequently incomplete, and may include elements
     * not properly part of the title
     */
    Distributor_s_title("10", "Distributor’s title"),

    /**
     * An alternative title that appears on the cover of a book
     */
    Alternative_title_on_cover("11", "Alternative title on cover"),

    /**
     * An alternative title that appears on the back of a book
     */
    Alternative_title_on_back("12", "Alternative title on back"),

    /**
     * An expanded form of the title, eg the title of a school text book with grade and type and other details added to
     * make the title meaningful, where otherwise it would comprise only the curriculum subject. This title type is
     * required for submissions to the Spanish ISBN Agency
     */
    Expanded_title("13", "Expanded title"),

    /**
     * An alternative title that the book is widely known by, whether it appears on the book or not
     */
    Alternative_title("14", "Alternative title");

    public final String code;
    public final String description;

    TitleTypes(String code, String description) {
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

    private static volatile Map<String, TitleTypes> map;

    private static Map<String, TitleTypes> map() {
        Map<String, TitleTypes> result = map;
        if (result == null) {
            synchronized (TitleTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (TitleTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static TitleTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
