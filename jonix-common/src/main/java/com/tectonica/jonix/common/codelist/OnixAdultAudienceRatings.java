/*
 * Copyright (C) 2012-2026 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 203 (ONIX Adult Audience rating)
 */
interface CodeList203 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 203</b>
 * <p>
 * Description: ONIX Adult Audience rating
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_74.html#codelist203">ONIX
 *      Codelist 203 in Reference Guide</a>
 */
public enum OnixAdultAudienceRatings implements OnixCodelist, CodeList203 {
    Unrated("00", "Unrated"),

    /**
     * The publisher states that the product is suitable for any adult audience
     */
    Any_adult_audience("01", "Any adult audience"),

    /**
     * The publisher advises the content may offend or distress parts of the adult audience (for any reason)
     */
    Content_advice("02", "Content advice"),

    /**
     * The publisher advises the product includes content of an explicit sexual nature
     */
    Content_advice_sex("03", "Content advice (sex)"),

    /**
     * The publisher advises the product includes content of an extreme violent nature
     */
    Content_advice_violence("04", "Content advice (violence)"),

    /**
     * The publisher advises the product includes content involving severe misuse of drugs or alcohol
     */
    Content_advice_drugs("05", "Content advice (drugs)"),

    /**
     * The publisher advises the product includes extreme / offensive / explicit language
     */
    Content_advice_language("06", "Content advice (language)"),

    /**
     * The publisher advises the product includes content involving severe intolerance or abuse of particular groups (eg
     * religious, ethnic, racial, gendered and other social groups)
     */
    Content_advice_intolerance("07", "Content advice (intolerance)"),

    /**
     * The publisher advises the product includes content involving sexual or extreme domestic abuse (including both
     * mental and physical abuse)
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Content_advice_abuse("08", "Content advice (abuse)"),

    /**
     * The publisher advises the product includes content involving severe self-harm (including serious eating
     * disorders)
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Content_advice_self_harm("09", "Content advice (self-harm)"),

    /**
     * The publisher advises the product includes content involving extreme cruelty to animals
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Content_advice_animal_cruelty("10", "Content advice (animal cruelty)"),

    /**
     * The publisher advises the product includes content involving serious chronic or acute illness (mental or
     * physical)
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Content_advice_illness("11", "Content advice (illness)"),

    /**
     * The publisher advises the product includes content relating to severe emotional distress resulting from death and
     * grief
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Content_advice_death_and_grief("12", "Content advice (death and grief)"),

    /**
     * The publisher advises the product includes content relating to suicide
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Content_advice_suicide("13", "Content advice (suicide)");

    public final String code;
    public final String description;

    OnixAdultAudienceRatings(String code, String description) {
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

    private static volatile Map<String, OnixAdultAudienceRatings> map;

    private static Map<String, OnixAdultAudienceRatings> map() {
        Map<String, OnixAdultAudienceRatings> result = map;
        if (result == null) {
            synchronized (OnixAdultAudienceRatings.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (OnixAdultAudienceRatings e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static OnixAdultAudienceRatings byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<OnixAdultAudienceRatings> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
