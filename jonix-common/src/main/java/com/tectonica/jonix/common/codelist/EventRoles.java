/*
 * Copyright (C) 2012-2024 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 20 (Event role)
 */
interface CodeList20 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 20</b>
 * <p>
 * Description: Event role
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_67.html#codelist20">ONIX
 *      Codelist 20 in Reference Guide</a>
 */
public enum EventRoles implements OnixCodelist, CodeList20 {
    /**
     * For example an academic, professional or political conference
     */
    Publication_linked_to_conference("01", "Publication linked to conference"),

    Complete_proceedings_of_conference("02", "Complete proceedings of conference"),

    Selected_papers_from_conference("03", "Selected papers from conference"),

    /**
     * For example a competitive match, fixture series or championship
     */
    Publication_linked_to_sporting_event("11", "Publication linked to sporting event"),

    Programme_or_guide_for_sporting_event("12", "Programme or guide for sporting event"),

    /**
     * For example a theatrical or musical event or performance, a season of events or performances, or an exhibition of
     * art
     */
    Publication_linked_to_artistic_event("21", "Publication linked to artistic event"),

    Programme_or_guide_for_artistic_event("22", "Programme or guide for artistic event"),

    /**
     * For example a commercial exposition
     */
    Publication_linked_to_exposition("31", "Publication linked to exposition"),

    Programme_or_guide_for_exposition("32", "Programme or guide for exposition");

    public final String code;
    public final String description;

    EventRoles(String code, String description) {
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

    private static volatile Map<String, EventRoles> map;

    private static Map<String, EventRoles> map() {
        Map<String, EventRoles> result = map;
        if (result == null) {
            synchronized (EventRoles.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (EventRoles e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static EventRoles byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<EventRoles> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
