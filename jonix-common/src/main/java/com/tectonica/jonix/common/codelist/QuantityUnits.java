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

import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 169 (Quantity unit)
 */
interface CodeList169 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 169</b>
 * <p>
 * Description: Quantity unit
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_62.html#codelist169">ONIX
 *      Codelist 169 in Reference Guide</a>
 */
public enum QuantityUnits implements OnixCodelist, CodeList169 {
    /**
     * The quantity refers to a unit implied by the quantity type
     */
    Units("00", "Units"),

    Days("07", "Days"),

    Weeks("08", "Weeks"),

    Months("09", "Months"),

    Years("10", "Years"),

    /**
     * Multiple copies or units suitable for a class. A 'class' is a group of learners attending a specific course or
     * lesson and generally taught as a group
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Classes("20", "Classes");

    public final String code;
    public final String description;

    QuantityUnits(String code, String description) {
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

    public static QuantityUnits byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (QuantityUnits e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<QuantityUnits> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
