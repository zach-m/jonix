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
 * marker interface to assist in IDE navigation to code-list 14 (Text case flag)
 */
interface CodeList14 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 14</b>
 * <p>
 * Description: Text case flag
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_58.html#codelist14">ONIX
 *      Codelist 14 in Reference Guide</a>
 */
public enum TextCaseFlags implements OnixCodelist, CodeList14 {
    /**
     * Default
     */
    Undefined("00", "Undefined"),

    /**
     * Initial capitals on first word and subsequently on proper names only, eg 'The conquest of Mexico'
     */
    Sentence_case("01", "Sentence case"),

    /**
     * Initial capitals on first word and subsequently on all significant words (nouns, pronouns, adjectives, verbs,
     * adverbs, subordinate conjunctions) thereafter. Unless they appear as the first word, articles, prepositions and
     * coordinating conjunctions remain lower case, eg 'The Conquest of Mexico'
     */
    Title_case("02", "Title case"),

    /**
     * For example, 'THE CONQUEST OF MEXICO'. Use only when Sentence or Title case are not possible (for example because
     * of system limitations). Do NOT use simply because title is (correctly) in all caps (eg 'BBQ USA')
     */
    All_capitals("03", "All capitals");

    public final String code;
    public final String description;

    TextCaseFlags(String code, String description) {
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

    public static TextCaseFlags byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (TextCaseFlags e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
