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
 * marker interface to assist in IDE navigation to code-list 28 (Audience type)
 */
interface CodeList28 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 28</b>
 * <p>
 * Description: Audience type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_61.html#codelist28">ONIX
 *      Codelist 28 in Reference Guide</a>
 */
public enum AudienceTypes implements OnixCodelist, CodeList28 {
    /**
     * For a non-specialist adult audience. Consider also adding an ONIX Adult audience rating
     */
    General_adult("01", "General / adult"),

    /**
     * For a young audience typically up to about the age of 12, not specifically for any educational purpose. An
     * audience range should also be included
     */
    Children("02", "Children"),

    /**
     * For a teenage or 'young adult' audience typically from about the age of 12 to the late teens, not specifically
     * for any educational purpose. An audience range should also be included
     */
    Teenage("03", "Teenage"),

    /**
     * Kindergarten, pre-school, primary / elementary or secondary / high school education. Note 'secondary' includes
     * both level 2 and level 3 secondary education as defined in UNESCO's ISCED 2011 (see
     * http://uis.unesco.org/en/topic/international-standard-classification-education-isced). An audience range should
     * also be included
     */
    Primary_and_secondary_education("04", "Primary and secondary education"),

    /**
     * Equivalent to UNESCO's ISCED Level 0 - see
     * http://uis.unesco.org/en/topic/international-standard-classification-education-isced (note codes 11-14 are
     * specific subsets of the Primary and secondary education audience, code 04). Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Pre_primary_education("11", "Pre-primary education"),

    /**
     * Equivalent to ISCED Level 1. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Primary_education("12", "Primary education"),

    /**
     * Equivalent to ISCED Level 2 (general and vocational). Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Lower_secondary_education("13", "Lower secondary education"),

    /**
     * Equivalent to ISCED Level 3 (general and vocational). Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Upper_secondary_education("14", "Upper secondary education"),

    /**
     * For tertiary education typically in universities and colleges of higher education, equivalent to ISCED Levels 5-7
     */
    Tertiary_education("05", "Tertiary education"),

    /**
     * For an expert adult audience, including professional development and academic research
     */
    Professional_and_scholarly("06", "Professional and scholarly"),

    /**
     * For any adult audience in a formal or semi-formal learning setting, eg vocational training and apprenticeships
     * (collectively, equivalent to ISCED Level 4), or practical or recreational learning for adults
     */
    Adult_education("08", "Adult education"),

    /**
     * Intended for use in teaching and learning English as a second, non-native or additional language. Indication of
     * the language level (eg CEFR) should be included where possible. An audience range should also be included if the
     * product is (also) suitable for use in primary and secondary education
     */
    EFL_TEFL_TESOL("07", "EFL / TEFL / TESOL"),

    /**
     * Intended for use in teaching and learning second, non-native or additional languages (other than English), for
     * example teaching German to Spanish speakers. Indication of the language level (eg CEFR) should be included where
     * possible. An audience range should also be included if the product is (also) suitable for use in primary and
     * secondary education. Prefer code 07 for products specific to teaching English
     */
    Second_additional_language_teaching("09", "Second / additional language teaching");

    public final String code;
    public final String description;

    AudienceTypes(String code, String description) {
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

    private static volatile Map<String, AudienceTypes> map;

    private static Map<String, AudienceTypes> map() {
        Map<String, AudienceTypes> result = map;
        if (result == null) {
            synchronized (AudienceTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (AudienceTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static AudienceTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
