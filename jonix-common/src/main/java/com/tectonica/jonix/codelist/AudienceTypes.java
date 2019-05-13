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

package com.tectonica.jonix.codelist;

import com.tectonica.jonix.OnixCodelist;

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
 * @see <a href="https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist28">ONIX
 * Codelist 28 in Reference Guide</a>
 */
public enum AudienceTypes implements OnixCodelist, CodeList28 {
    /**
     * For a non-specialist adult audience
     */
    General_trade("01", "General/trade"), //

    /**
     * For a juvenile audience, not specifically for any educational purpose
     */
    Children_juvenile("02", "Children/juvenile"), //

    /**
     * For a teenage audience, not specifically for any educational purpose
     */
    Young_adult("03", "Young adult"), //

    /**
     * Kindergarten, pre-school, primary/elementary or secondary/high school education
     */
    Primary_and_secondary_elementary_and_high_school("04", "Primary and secondary/elementary and high school"), //

    /**
     * For universities and colleges of further and higher education
     */
    College_higher_education("05", "College/higher education"), //

    /**
     * For an expert adult audience, including professional development and academic research
     */
    Professional_and_scholarly("06", "Professional and scholarly"), //

    /**
     * Intended for use in teaching English as a second language
     */
    ELT_ESL("07", "ELT/ESL"), //

    /**
     * For centres providing academic, vocational or recreational courses for adults
     */
    Adult_education("08", "Adult education"), //

    /**
     * Intended for use in teaching second languages, for example teaching German to Spanish speakers. Prefer code 07
     * for products specific to teaching English
     */
    Second_language_teaching("09", "Second language teaching");

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
