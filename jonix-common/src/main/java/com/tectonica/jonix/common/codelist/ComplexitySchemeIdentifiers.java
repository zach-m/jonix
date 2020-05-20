/*
 * Copyright (C) 2012-2020 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 32 (Complexity scheme identifier)
 */
interface CodeList32 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 32</b>
 * <p>
 * Description: Complexity scheme identifier
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_49.html#codelist32">ONIX
 *      Codelist 32 in Reference Guide</a>
 */
public enum ComplexitySchemeIdentifiers implements OnixCodelist, CodeList32 {
    /**
     * For example AD or HL. DEPRECATED in ONIX 3 - use code 06 instead
     */
    Lexile_code("01", "Lexile code"),

    /**
     * For example 880L. DEPRECATED in ONIX 3 - use code 06 instead
     */
    Lexile_number("02", "Lexile number"),

    /**
     * Fry readability metric based on number of sentences and syllables per 100 words. Expressed as an integer from 1
     * to 15 in &lt;ComplexityCode&gt;
     */
    Fry_Readability_score("03", "Fry Readability score"),

    /**
     * UK Institute of Education Book Bands for Guided Reading scheme (see
     * https://www.ucl.ac.uk/reading-recovery-europe/ilc/publications/which-book-why). &lt;ComplexityCode&gt; is a
     * color, eg 'Pink A' or 'Copper'
     */
    IoE_Book_Band("04", "IoE Book Band"),

    /**
     * &lt;ComplexityCode&gt; is a code from 'A' to Z+'. See
     * http://www.fountasandpinnellleveledbooks.com/aboutLeveledTexts.aspx
     */
    Fountas_Pinnell_Text_Level_Gradient("05", "Fountas & Pinnell Text Level Gradient"),

    /**
     * The Lexile measure in &lt;ComplexityCode&gt; combines the Lexile number (for example 620L or 880L) and optionally
     * the Lexile code (for example AD or HL). Examples might be '880L', 'AD0L' or 'HL600L'. See
     * https://lexile.com/about-lexile/lexile-overview/
     */
    Lexile_measure("06", "Lexile measure"),

    /**
     * Advantage-TASA Open Standard book readability score, used for example within the Renaissance Learning Accelerated
     * Reader scheme. &lt;ComplexityCode&gt; is the 'Book Level', a real number between 0 and 17. See
     * http://www.renaissance.com/products/accelerated-reader/atos-analyzer
     */
    ATOS_for_Books("07", "ATOS for Books"),

    /**
     * Flesch-Kincaid Grade Level Formula, a standard readability measure based on the weighted number of syllables per
     * word and words per sentence. &lt;ComplexityCode&gt; is a real number typically between about -1 and 20
     */
    Flesch_Kincaid_Grade_Level("08", "Flesch-Kincaid Grade Level"),

    /**
     * Use this code for books levelled by the publisher or a third party using the Fountas and Pinnell Guided Reading
     * methodology
     */
    Guided_Reading_Level("09", "Guided Reading Level"),

    /**
     * Used for books aimed at K-2 literacy intervention. &lt;ComplexityCode&gt; is an integer between 1 and 20
     */
    Reading_Recovery_Level("10", "Reading Recovery Level");

    public final String code;
    public final String description;

    ComplexitySchemeIdentifiers(String code, String description) {
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

    private static volatile Map<String, ComplexitySchemeIdentifiers> map;

    private static Map<String, ComplexitySchemeIdentifiers> map() {
        Map<String, ComplexitySchemeIdentifiers> result = map;
        if (result == null) {
            synchronized (ComplexitySchemeIdentifiers.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ComplexitySchemeIdentifiers e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ComplexitySchemeIdentifiers byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
