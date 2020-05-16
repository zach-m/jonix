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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 241 (AV Item Identifier type)
 */
interface CodeList241 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 241</b>
 * <p>
 * Description: AV Item Identifier type
 * <p>
 * Jonix-Comment: Introduced in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist241">ONIX
 *      Codelist 241 in Reference Guide</a>
 */
public enum AvItemIdentifierTypes implements OnixCodelist, CodeList241 {
    /**
     * For example, a publisher's own identifier. Note that &lt;IDTypeName&gt; is required with proprietary identifiers
     */
    Proprietary("01", "Proprietary"),

    /**
     * Formerly known as the EAN-13 (unhyphenated)
     */
    GTIN_13("03", "GTIN-13"),

    /**
     * Digital Object Identifier (variable length and character set beginning '10.', and without https://doi.org/ or the
     * older http://dx.doi.org/)
     */
    DOI("06", "DOI"),

    /**
     * Motion picture work identifier from the International Movie Database
     */
    IMDB("12", "IMDB"),

    /**
     * International Standard Recording Code, 5 alphanumeric characters plus 7 digits
     */
    ISRC("18", "ISRC"),

    /**
     * International Standard Audiovisual Number, 16 or 26 hex digits, with optional alphanumeric check character(s),
     * unhyphenated
     */
    ISAN("19", "ISAN"),

    /**
     * Entertainment Identifier Registry DOI
     */
    EIDR_DOI("31", "EIDR DOI");

    public final String code;
    public final String description;

    AvItemIdentifierTypes(String code, String description) {
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

    public static AvItemIdentifierTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (AvItemIdentifierTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
