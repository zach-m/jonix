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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 173 (Price date role)
 */
interface CodeList173 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 173</b>
 * <p>
 * Description: Price date role
 *
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist173">ONIX
 * Codelist 173 in Reference Guide</a>
 */
public enum PriceDateRoles implements OnixCodelist, CodeList173 {
    /**
     * Date on which a price becomes effective
     */
    From_date("14", "From date"), //

    /**
     * Date on which a price ceases to be effective
     */
    Until_date("15", "Until date"), //

    /**
     * Combines From date and Until date to define a period (both dates are inclusive). Use with for example dateformat
     * 06
     */
    From_until_date("24", "From… until date");

    public final String code;
    public final String description;

    private PriceDateRoles(String code, String description) {
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

    public static PriceDateRoles byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (PriceDateRoles e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
