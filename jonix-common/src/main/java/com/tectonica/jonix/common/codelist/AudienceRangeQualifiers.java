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
import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 30 (Audience range qualifier)
 */
interface CodeList30 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 30</b>
 * <p>
 * Description: Audience range qualifier
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_63.html#codelist30">ONIX
 *      Codelist 30 in Reference Guide</a>
 */
public enum AudienceRangeQualifiers implements OnixCodelist, CodeList30 {
    /**
     * Values for &lt;AudienceRangeValue&gt; are specified in List 77
     */
    US_school_grade_range("11", "US school grade range"),

    /**
     * Values are to be defined by BIC for England and Wales, Scotland and N Ireland
     */
    UK_school_grade("12", "UK school grade"),

    /**
     * Values in &lt;AudienceRangeValue&gt; must be integers
     */
    Reading_speed_words_per_minute("15", "Reading speed, words per minute"),

    /**
     * For use up to 36 months only, or up to 42 months in Audience range value (2) only: values in
     * &lt;AudienceRangeValue&gt; must be integers. Should not be used when an Audience range with qualifier code 17 is
     * present
     */
    Interest_age_months("16", "Interest age, months"),

    /**
     * Values in &lt;AudienceRangeValue&gt; must be integers
     */
    Interest_age_years("17", "Interest age, years"),

    /**
     * Values in &lt;AudienceRangeValue&gt; must be integers
     */
    Reading_age_years("18", "Reading age, years"),

    /**
     * Spain: combined grade and region code, maintained by the Ministerio de Educaci&#243;n
     */
    Spanish_school_grade("19", "Spanish school grade"),

    /**
     * Norwegian educational level for primary and secondary education
     */
    Skoletrinn("20", "Skoletrinn"),

    /**
     * Swedish educational qualifier (code)
     */
    Niva("21", "Nivå"),

    Italian_school_grade("22", "Italian school grade"),

    /**
     * DEPRECATED - assigned in error: see List 29
     */
    Schulform("23", "Schulform"),

    /**
     * DEPRECATED - assigned in error: see List 29
     */
    Bundesland("24", "Bundesland"),

    /**
     * DEPRECATED - assigned in error: see List 29
     */
    Ausbildungsberuf("25", "Ausbildungsberuf"),

    /**
     * Values for &lt;AudienceRangeValue&gt; are specified in List 77
     */
    Canadian_school_grade_range("26", "Canadian school grade range"),

    Finnish_school_grade_range("27", "Finnish school grade range"),

    /**
     * Lukion kurssi
     */
    Finnish_Upper_secondary_school_course("28", "Finnish Upper secondary school course"),

    /**
     * Values are P, K, 1-17 (including college-level audiences), see List 227
     */
    Chinese_School_Grade_range("29", "Chinese School Grade range"),

    /**
     * Detailed French educational level classification. Values are defined by ScoLOMFR, see
     * http://data.education.fr/voc/scolomfr/scolomfr-voc-022 - Cycles de l'enseignement scolaire. See also code 34
     */
    French_school_cycles_classes("30", "French school cycles / classes"),

    /**
     * N&#237;vel de Educa&#231;&#227;o do Brasil, see List 238. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Brazil_Education_level("31", "Brazil Education level"),

    /**
     * Basic French educational level classification. Values are defined by ScoLOMFR. Only for use in ONIX 3.0 or later.
     * See http://data.education.fr/voc/scolomfr/scolomfr-voc-012
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    French_educational_levels("32", "French educational levels"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Finnish_Upper_secondary_school_course_2021_("33", "Finnish Upper secondary school course (2021+)"),

    /**
     * Detailed French educational level classification. Values are defined by ScoLOMFR. Only for use in ONIX 3.0 or
     * later. See http://data.education.fr/voc/scolomfr/scolomfr-voc-022 - Niveau &#233;ducatif d&#233;taill&#233;. See
     * also code 30
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Detailed_French_educational_levels("34", "Detailed French educational levels");

    public final String code;
    public final String description;

    AudienceRangeQualifiers(String code, String description) {
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

    private static volatile Map<String, AudienceRangeQualifiers> map;

    private static Map<String, AudienceRangeQualifiers> map() {
        Map<String, AudienceRangeQualifiers> result = map;
        if (result == null) {
            synchronized (AudienceRangeQualifiers.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (AudienceRangeQualifiers e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static AudienceRangeQualifiers byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<AudienceRangeQualifiers> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
