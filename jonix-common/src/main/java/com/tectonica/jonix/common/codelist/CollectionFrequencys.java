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
import java.util.Optional;

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 259 (Collection frequency code)
 */
interface CodeList259 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 259</b>
 * <p>
 * Description: Collection frequency code
 * <p>
 * JONIX adds: Not included in Onix2
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_68.html#codelist259">ONIX
 *      Codelist 259 in Reference Guide</a>
 */
public enum CollectionFrequencys implements OnixCodelist, CodeList259 {
    Unknown("u", "Unknown"),

    /**
     * No fixed publication schedule
     */
    Irregular("i", "Irregular"),

    /**
     * New products in the collection are regularly scheduled, but less frequently than once every two years
     */
    Regular("r", "Regular"),

    /**
     * Once every two years
     */
    Biennial("e", "Biennial"),

    /**
     * Yearly
     */
    Annual("a", "Annual"),

    /**
     * Twice a year, or once per academic semester
     */
    Biannual("b", "Biannual"),

    /**
     * Three times a year, or once per academic term
     */
    Triannual("t", "Triannual"),

    /**
     * Four times a year
     */
    Quarterly("q", "Quarterly"),

    /**
     * Six times per year
     */
    Bimonthly("s", "Bimonthly"),

    /**
     * Once every month, or approximately twelve times per year
     */
    Monthly("m", "Monthly"),

    /**
     * Once every two weeks, or approximately twenty five times per year
     */
    Fortnightly("f", "Fortnightly"),

    /**
     * Or approximately fifty times per year
     */
    Weekly("w", "Weekly"),

    /**
     * At least twice a week
     */
    Daily_or_more_frequently_than_weekly("d", "Daily, or more frequently than weekly"),

    /**
     * Positive indication that the product is the last to be published in the collection, or that no further
     * publications are planned
     */
    No_future_publications("x", "No future publications");

    public final String code;
    public final String description;

    CollectionFrequencys(String code, String description) {
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

    private static volatile Map<String, CollectionFrequencys> map;

    private static Map<String, CollectionFrequencys> map() {
        Map<String, CollectionFrequencys> result = map;
        if (result == null) {
            synchronized (CollectionFrequencys.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (CollectionFrequencys e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static CollectionFrequencys byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<CollectionFrequencys> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
