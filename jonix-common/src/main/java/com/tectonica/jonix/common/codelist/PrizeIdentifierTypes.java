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
 * marker interface to assist in IDE navigation to code-list 263 (Prize identifier type)
 */
interface CodeList263 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 263</b>
 * <p>
 * Description: Prize identifier type
 * <p>
 * JONIX adds: Not included in Onix2
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_71.html#codelist263">ONIX
 *      Codelist 263 in Reference Guide</a>
 */
public enum PrizeIdentifierTypes implements OnixCodelist, CodeList263 {
    /**
     * Note that a distinctive &lt;IDTypeName&gt; is required with proprietary prize identifiers
     */
    Proprietary_prize_ID_scheme("01", "Proprietary prize ID scheme"),

    /**
     * Gemeinsame Normdatei - Joint Authority File in the German-speaking countries. See
     * https://www.dnb.de/DE/Professionell/Standardisierung/GND/gnd_node.html (German) and
     * https://www.dnb.de/EN/Professionell/Standardisierung/GND/gnd_node.html (English)
     */
    GND("91", "GND"),

    /**
     * Faceted Application of Subject Terminology, OCLC subject scheme derived from LCSH. See
     * https://fast.oclc.org/fast/. Codes are up to 8 digits, for example 1430698 for the Booker Prize (see
     * https://id.worldcat.org/fast/1430698)
     */
    FAST("B6", "FAST");

    public final String code;
    public final String description;

    PrizeIdentifierTypes(String code, String description) {
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

    public static PrizeIdentifierTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (PrizeIdentifierTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<PrizeIdentifierTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
