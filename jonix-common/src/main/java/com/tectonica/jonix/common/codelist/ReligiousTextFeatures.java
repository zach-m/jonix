/*
 * Copyright (C) 2012-2025 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 90 (Religious text feature)
 */
interface CodeList90 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 90</b>
 * <p>
 * Description: Religious text feature
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_69.html#codelist90">ONIX
 *      Codelist 90 in Reference Guide</a>
 */
public enum ReligiousTextFeatures implements OnixCodelist, CodeList90 {
    /**
     * Use with code 01 in &lt;ReligiousTextFeatureType&gt;
     */
    Academic_year("01", "Academic year"),

    /**
     * Use with code 01 in &lt;ReligiousTextFeatureType&gt;
     */
    Catechistic_year("02", "Catechistic year"),

    /**
     * Use with code 01 in &lt;ReligiousTextFeatureType&gt;
     */
    Liturgical_year("03", "Liturgical year"),

    /**
     * Use with code 01 in &lt;ReligiousTextFeatureType&gt;
     */
    Advent_and_Christmas("04", "Advent and Christmas"),

    /**
     * Use with code 01 in &lt;ReligiousTextFeatureType&gt;
     */
    Blessings("05", "Blessings"),

    /**
     * Use with code 01 in &lt;ReligiousTextFeatureType&gt;
     */
    Scholastic_cycles("06", "Scholastic cycles"),

    /**
     * Use with code 01 in &lt;ReligiousTextFeatureType&gt;
     */
    Confirmation_and_Holy_Communion("07", "Confirmation and Holy Communion"),

    /**
     * For example, summer camps and other youth recreational activities: use with code 01 in
     * &lt;ReligiousTextFeatureType&gt;
     */
    Summer_activites("08", "Summer activites"),

    /**
     * Use with code 01 in &lt;ReligiousTextFeatureType&gt;
     */
    Easter("09", "Easter"),

    /**
     * Use with code 01 in &lt;ReligiousTextFeatureType&gt;
     */
    Lent("10", "Lent"),

    /**
     * Use with code 01 in &lt;ReligiousTextFeatureType&gt;
     */
    Marian_themes("11", "Marian themes");

    public final String code;
    public final String description;

    ReligiousTextFeatures(String code, String description) {
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

    private static volatile Map<String, ReligiousTextFeatures> map;

    private static Map<String, ReligiousTextFeatures> map() {
        Map<String, ReligiousTextFeatures> result = map;
        if (result == null) {
            synchronized (ReligiousTextFeatures.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ReligiousTextFeatures e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ReligiousTextFeatures byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<ReligiousTextFeatures> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
