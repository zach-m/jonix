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

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 23 (Extent type)
 */
interface CodeList23 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 23</b>
 * <p>
 * Description: Extent type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_49.html#codelist23">ONIX
 *      Codelist 23 in Reference Guide</a>
 */
public enum ExtentTypes implements OnixCodelist, CodeList23 {
    /**
     * The highest-numbered page in a single numbered sequence of main content, usually the highest Arabic-numbered page
     * in a book; or, for books without page numbers or (rarely) with multiple numbered sequences of main content, the
     * total number of pages that carry the main content of the book. Note that this may include numbered but otherwise
     * blank pages (eg pages inserted to ensure chapters start on a recto page) and may exclude unnumbered (but
     * contentful) pages such as those in inserts/plate sections. It should exclude pages of back matter (eg any index)
     * even when their numbering sequence continues from the main content. Either this or the Content Page count is the
     * preferred page count for most books for the general reader. For books with substantial front and/or back matter,
     * include also Front matter (03) and Back matter (04) page counts, or Total numbered pages (05). For books with
     * inserts (plate sections), also include Total unnumbered insert page count whenever possible
     */
    Main_content_page_count("00", "Main content page count"),

    /**
     * Number of words or characters of natural language text
     */
    Total_text_length("02", "Total text length"),

    /**
     * The total number of numbered (usually Roman-numbered) pages that precede the main content of a book. This usually
     * consists of various title and imprint pages, table of contents, an introduction, preface, foreword, etc
     */
    Front_matter_page_count("03", "Front matter page count"),

    /**
     * The total number of numbered (often Roman-numbered) pages that follow the main content of a book. This usually
     * consists of an afterword, appendices, endnotes, index, etc. It excludes extracts or 'teaser' material from other
     * works, and blank (or advertising) pages that are present only for convenience of printing and binding
     */
    Back_matter_page_count("04", "Back matter page count"),

    /**
     * The sum of all Roman- and Arabic-numbered pages. Note that this may include numbered but otherwise blank pages
     * (eg pages inserted to ensure chapters start on a recto page) and may exclude unnumbered (but contentful) pages
     * such as those in inserts/plate sections. It is the sum of the main content (00), front matter (03) and back
     * matter (04) page counts
     */
    Total_numbered_pages("05", "Total numbered pages"),

    /**
     * The total number of pages in a book, including unnumbered pages, front matter, back matter, etc. This includes
     * any extracts or 'teaser' material from other works, and blank pages at the back that carry no content and are
     * present only for convenience of printing and binding
     */
    Production_page_count("06", "Production page count"),

    /**
     * The total number of pages of the book counting the cover as page 1. This page count type should be used only for
     * digital publications delivered with fixed pagination
     */
    Absolute_page_count("07", "Absolute page count"),

    /**
     * The total number of pages (equivalent to the Content page count, code 11) in the print counterpart of a digital
     * product delivered without fixed pagination, or of an audio product
     */
    Number_of_pages_in_print_counterpart("08", "Number of pages in print counterpart"),

    /**
     * Total duration in time, expressed in the specified extent unit. This is the 'running time' equivalent of code 11
     */
    Duration("09", "Duration"),

    /**
     * An estimate of the number of 'pages' in a digital product delivered without fixed pagination, and with no print
     * counterpart, given as an indication of the size of the work. Equivalent to code 08, but exclusively for digital
     * or audio products
     */
    Notional_number_of_pages_in_digital_product("10", "Notional number of pages in digital product"),

    /**
     * The sum of all Roman- and Arabic-numbered and contentful unnumbered pages. Sum of page counts with codes 00, 03,
     * 04 and 12, and also the sum of 05 and 12
     */
    Content_page_count("11", "Content page count"),

    /**
     * The total number of unnumbered pages with content inserted within the main content of a book - for example
     * inserts/plate sections that are not numbered
     */
    Total_unnumbered_insert_page_count("12", "Total unnumbered insert page count"),

    /**
     * Duration in time, expressed in the specified extent units, of introductory matter. This is the 'running time'
     * equivalent of code 03, and comprises any significant amount of running time represented by a musical intro,
     * announcements, titles, introduction or other material prefacing the main content
     */
    Duration_of_introductory_matter("13", "Duration of introductory matter"),

    /**
     * Duration in time, expressed in the specified extent units, of the main content. This is the 'running time'
     * equivalent of code 00, and excludes time represented by announcements, titles, introduction or other prefatory
     * material or 'back matter'
     */
    Duration_of_main_content("14", "Duration of main content"),

    /**
     * Duration in time, expressed in the specified extent units, of any content that follows the main content of a
     * book. This may consist of an afterword, appendices, endnotes, end music etc. It excludes extracts or 'teaser'
     * material from other works. This is the 'running time' equivalent of code 04
     */
    Duration_of_back_matter("15", "Duration of back matter"),

    /**
     * Duration in time, expressed in the specified extent units, of the complete content of a book. This is the
     * 'running time' equivalent of code 06, and includes time represented by musical themes, announcements, titles,
     * introductory and other prefatory material, plus 'back matter' such as any afterword, appendices, plus any
     * extracts or 'teaser' material from other works
     */
    Production_duration("16", "Production duration"),

    /**
     * Approximate size of a digital file, expressed in the specified extent unit
     */
    Filesize("22", "Filesize");

    public final String code;
    public final String description;

    ExtentTypes(String code, String description) {
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

    private static volatile Map<String, ExtentTypes> map;

    private static Map<String, ExtentTypes> map() {
        Map<String, ExtentTypes> result = map;
        if (result == null) {
            synchronized (ExtentTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ExtentTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ExtentTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
