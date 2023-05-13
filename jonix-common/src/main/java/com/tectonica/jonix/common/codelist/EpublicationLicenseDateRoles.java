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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 260 (Epublication license date role)
 */
interface CodeList260 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 260</b>
 * <p>
 * Description: Epublication license date role
 * <p>
 * Jonix-Comment: Introduced in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_61.html#codelist260">ONIX
 *      Codelist 260 in Reference Guide</a>
 */
public enum EpublicationLicenseDateRoles implements OnixCodelist, CodeList260 {
    /**
     * Date on which a license becomes effective
     */
    Valid_from("14", "Valid from"),

    /**
     * Date on which a license ceases to be effective
     */
    Valid_until("15", "Valid until"),

    /**
     * Combines From date and Until date to define a period (both dates are inclusive). Use for example with dateformat
     * 06
     */
    From_until_date("24", "From… until date");

    public final String code;
    public final String description;

    EpublicationLicenseDateRoles(String code, String description) {
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

    public static EpublicationLicenseDateRoles byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (EpublicationLicenseDateRoles e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
