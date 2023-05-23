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
 * marker interface to assist in IDE navigation to code-list 151 (Contributor place relator)
 */
interface CodeList151 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 151</b>
 * <p>
 * Description: Contributor place relator
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_61.html#codelist151">ONIX
 *      Codelist 151 in Reference Guide</a>
 */
public enum ContributorPlaceRelators implements OnixCodelist, CodeList151 {
    /**
     * To express unknown relationship types (for use when expressing legacy ONIX 2.1 data in ONIX 3.0)
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Associated_with("00", "Associated with"),

    Born_in("01", "Born in"),

    Died_in("02", "Died in"),

    Formerly_resided_in("03", "Formerly resided in"),

    Currently_resides_in("04", "Currently resides in"),

    Educated_in("05", "Educated in"),

    Worked_in("06", "Worked in"),

    /**
     * ('Floruit')
     */
    Flourished_in("07", "Flourished in"),

    /**
     * Or nationality. For use with country codes only
     */
    Citizen_of("08", "Citizen of"),

    /**
     * The place of legal registration of an organisation
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Registered_in("09", "Registered in"),

    /**
     * The place an organisation or part of an organisation is based or operates from
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Operating_from("10", "Operating from"),

    /**
     * Contributor is eligible for national, regional or local marketing support. Use with country code, region code or
     * country/region plus location, as appropriate
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Eligible_for_geographical_marketing_programs("11", "Eligible for geographical marketing programs");

    public final String code;
    public final String description;

    ContributorPlaceRelators(String code, String description) {
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

    private static volatile Map<String, ContributorPlaceRelators> map;

    private static Map<String, ContributorPlaceRelators> map() {
        Map<String, ContributorPlaceRelators> result = map;
        if (result == null) {
            synchronized (ContributorPlaceRelators.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ContributorPlaceRelators e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ContributorPlaceRelators byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<ContributorPlaceRelators> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
