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
 * marker interface to assist in IDE navigation to code-list 42 (Text item type)
 */
interface CodeList42 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 42</b>
 * <p>
 * Description: Text item type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist42">ONIX
 *      Codelist 42 in Reference Guide</a>
 */
public enum TextItemTypes implements OnixCodelist, CodeList42 {
    /**
     * A complete work which is published as a content item in a product which carries two or more such works, eg when
     * two or three novels are published in a single omnibus volume
     */
    Textual_work("01", "Textual work"),

    /**
     * Text components such as Preface, Introduction etc which appear as preliminaries to the main body of text content
     * in a product
     */
    Front_matter("02", "Front matter"),

    /**
     * Text components such as Part, Chapter, Section etc which appear as part of the main body of text content in a
     * product
     */
    Body_matter("03", "Body matter"),

    /**
     * Text components such as Index which appear after the main body of text in a product
     */
    Back_matter("04", "Back matter"),

    /**
     * For journals
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Serial_item_miscellaneous_or_unspecified("10", "Serial item, miscellaneous or unspecified"),

    /**
     * For journals
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Research_article("11", "Research article"),

    /**
     * For journals
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Review_article("12", "Review article"),

    /**
     * For journals
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Letter("13", "Letter"),

    /**
     * For journals
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Short_communication("14", "Short communication"),

    /**
     * For journals
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Erratum("15", "Erratum"),

    /**
     * For journals
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Abstract("16", "Abstract"),

    /**
     * For journals
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Book_review_or_review_of_other_publication("17", "Book review (or review of other publication)"),

    /**
     * For journals
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Editorial("18", "Editorial"),

    /**
     * For journals
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Product_review("19", "Product review"),

    /**
     * Jonix-Comment: Deprecated in Onix3
     */
    Index("20", "Index"),

    /**
     * For journals
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Obituary("21", "Obituary");

    public final String code;
    public final String description;

    TextItemTypes(String code, String description) {
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

    private static volatile Map<String, TextItemTypes> map;

    private static Map<String, TextItemTypes> map() {
        Map<String, TextItemTypes> result = map;
        if (result == null) {
            synchronized (TextItemTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (TextItemTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static TextItemTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
