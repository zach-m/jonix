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
 * marker interface to assist in IDE navigation to code-list 76 (DVD region)
 */
interface CodeList76 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 76</b>
 * <p>
 * Description: DVD region
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_58.html#codelist76">ONIX
 *      Codelist 76 in Reference Guide</a>
 */
public enum DvdRegions implements OnixCodelist, CodeList76 {
    /**
     * DVD or Blu-Ray
     */
    All_regions("0", "All regions"),

    /**
     * US, US Territories, Canada
     */
    DVD_region_1("1", "DVD region 1"),

    /**
     * Japan, Europe, South Africa and Middle East (including Egypt)
     */
    DVD_region_2("2", "DVD region 2"),

    /**
     * Southeast Asia, Hong Kong, Macau, South Korea, and Taiwan
     */
    DVD_region_3("3", "DVD region 3"),

    /**
     * Australia, New Zealand, Pacific Islands, Central America, Mexico, South America and the Caribbean
     */
    DVD_region_4("4", "DVD region 4"),

    /**
     * Eastern Europe (former Soviet Union), Indian subcontinent, Africa, North Korea and Mongolia
     */
    DVD_region_5("5", "DVD region 5"),

    /**
     * People's Republic of China (except Macau and Hong Kong)
     */
    DVD_region_6("6", "DVD region 6"),

    /**
     * Reserved for future use
     */
    DVD_region_7("7", "DVD region 7"),

    /**
     * International venues: aircraft, cruise ships etc
     */
    DVD_region_8("8", "DVD region 8"),

    /**
     * North America, Central America, South America, Japan, Taiwan, North Korea, South Korea, Hong Kong, and Southeast
     * Asia
     */
    Blu_Ray_region_A("A", "Blu-Ray region A"),

    /**
     * Most of Europe, Greenland, French territories, Middle East, Africa, Australia, and New Zealand, plus all of
     * Oceania
     */
    Blu_Ray_region_B("B", "Blu-Ray region B"),

    /**
     * India, Bangladesh, Nepal, Mainland China, Pakistan, Russia, Ukraine, Belarus, Central, and South Asia
     */
    Blu_Ray_region_C("C", "Blu-Ray region C");

    public final String code;
    public final String description;

    DvdRegions(String code, String description) {
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

    private static volatile Map<String, DvdRegions> map;

    private static Map<String, DvdRegions> map() {
        Map<String, DvdRegions> result = map;
        if (result == null) {
            synchronized (DvdRegions.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (DvdRegions e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static DvdRegions byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
