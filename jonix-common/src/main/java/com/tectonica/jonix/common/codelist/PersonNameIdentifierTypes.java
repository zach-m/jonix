/*
 * Copyright (C) 2012-2022 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 101 (Person name identifier type)
 */
interface CodeList101 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 101</b>
 * <p>
 * Description: Person name identifier type
 * <p>
 * Jonix-Comment: Deprecated in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_36.html#codelist101">ONIX
 *      Codelist 101 in Reference Guide</a>
 */
public enum PersonNameIdentifierTypes implements OnixCodelist, CodeList101 {
    /**
     * Note that &lt;IDTypeName&gt; is required with proprietary identifiers
     */
    Proprietary("01", "Proprietary"),

    /**
     * Personennamendatei - person name authority file used by Deutsche Nationalbibliothek and in other German-speaking
     * countries. See http://www.d-nb.de/standardisierung/normdateien/pnd.htm (German) or
     * http://www.d-nb.de/eng/standardisierung/normdateien/pnd.htm (English). DEPRECATED in favour of the GND
     */
    PND("02", "PND"),

    /**
     * Library of Congress control number assigned to a Library of Congress Name Authority record
     */
    LCCN("04", "LCCN"),

    /**
     * International Standard Name Identifier. See http://www.isni.org/
     */
    ISNI("16", "ISNI"),

    /**
     * Gemeinsame Normdatei - Joint Authority File in the German-speaking countries. See http://www.dnb.de/EN/gnd
     * (English). Combines the PND, SWD and GKD into a single authority file, and should be used in preference
     */
    GND("25", "GND");

    public final String code;
    public final String description;

    PersonNameIdentifierTypes(String code, String description) {
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

    public static PersonNameIdentifierTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (PersonNameIdentifierTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
