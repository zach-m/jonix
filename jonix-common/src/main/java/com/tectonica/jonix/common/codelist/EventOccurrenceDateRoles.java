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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 247 (Event occurrence date role)
 */
interface CodeList247 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 247</b>
 * <p>
 * Description: Event occurrence date role
 * <p>
 * JONIX adds: Not included in Onix2
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_68.html#codelist247">ONIX
 *      Codelist 247 in Reference Guide</a>
 */
public enum EventOccurrenceDateRoles implements OnixCodelist, CodeList247 {
    /**
     * Date and (with the default dateformat) time the event occurrence begins
     */
    Date_of_occurrence("01", "Date of occurrence"),

    /**
     * Date and (with the default dateformat) time the event occurrence ends
     */
    Date_of_occurrence_end("02", "Date of occurrence end");

    public final String code;
    public final String description;

    EventOccurrenceDateRoles(String code, String description) {
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

    public static EventOccurrenceDateRoles byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (EventOccurrenceDateRoles e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<EventOccurrenceDateRoles> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
