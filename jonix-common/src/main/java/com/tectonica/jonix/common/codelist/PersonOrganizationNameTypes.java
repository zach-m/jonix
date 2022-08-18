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
 * marker interface to assist in IDE navigation to code-list 18 (Person / organization name type)
 */
interface CodeList18 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 18</b>
 * <p>
 * Description: Person / organization name type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_58.html#codelist18">ONIX
 *      Codelist 18 in Reference Guide</a>
 */
public enum PersonOrganizationNameTypes implements OnixCodelist, CodeList18 {
    /**
     * Usually the name as it is presented on the book
     */
    Unspecified("00", "Unspecified"),

    /**
     * May be used to give a well-known pseudonym, where the primary name is a 'real' name
     */
    Pseudonym("01", "Pseudonym"),

    Authority_controlled_name("02", "Authority-controlled name"),

    /**
     * Use only within &lt;AlternativeName&gt;
     */
    Earlier_name("03", "Earlier name"),

    /**
     * May be used to identify a well-known real name, where the primary name is a pseudonym
     */
    _Real_name("04", "‘Real’ name"),

    /**
     * Use only within &lt;AlternativeName&gt;, when the primary name type is unspecified, for names in a different
     * script or language
     */
    Transliterated_translated_form_of_primary_name("05", "Transliterated / translated form of primary name"),

    /**
     * Use only within &lt;AlternativeName&gt;
     */
    Later_name("06", "Later name"),

    /**
     * Use only within &lt;NameAsSubject&gt;, to indicate the subject is fictional. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Fictional_character_name("07", "Fictional character name");

    public final String code;
    public final String description;

    PersonOrganizationNameTypes(String code, String description) {
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

    private static volatile Map<String, PersonOrganizationNameTypes> map;

    private static Map<String, PersonOrganizationNameTypes> map() {
        Map<String, PersonOrganizationNameTypes> result = map;
        if (result == null) {
            synchronized (PersonOrganizationNameTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (PersonOrganizationNameTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static PersonOrganizationNameTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
