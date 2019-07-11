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

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 13 (Series identifier type)
 */
interface CodeList13 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 13</b>
 * <p>
 * Description: Series identifier type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist13">ONIX
 *      Codelist 13 in Reference Guide</a>
 */
public enum SeriesIdentifierTypes implements OnixCodelist, CodeList13 {
    /**
     * For example, publisher's own series ID. Note that &lt;IDTypeName&gt; is required with proprietary identifiers
     */
    Proprietary("01", "Proprietary"), //

    /**
     * International Standard Serial Number, unhyphenated, 8 digits
     */
    ISSN("02", "ISSN"), //

    /**
     * Maintained by the Deutsche Nationalbibliothek
     */
    German_National_Bibliography_series_ID("03", "German National Bibliography series ID"), //

    /**
     * Maintained by VLB
     */
    German_Books_in_Print_series_ID("04", "German Books in Print series ID"), //

    /**
     * Maintained by Electre Information, France
     */
    Electre_series_ID("05", "Electre series ID"), //

    /**
     * Digital Object Identifier (variable length and character set)
     */
    DOI("06", "DOI"), //

    /**
     * Use only where the collection (series or set) is available as a single product
     */
    ISBN_13("15", "ISBN-13"), //

    /**
     * Uniform Resource Name
     */
    URN("22", "URN"), //

    /**
     * French National Bibliography series ID. Identifiant des publications en s&#233;rie maintenu par la
     * Biblioth&#232;que Nationale de France
     */
    BNF_Control_number("29", "BNF Control number"), //

    /**
     * Archival Resource Key, as a URL (including the address of the ARK resolver provided by eg a national library)
     */
    ARK("35", "ARK"), //

    /**
     * International Standard Serial Number 'linking ISSN', used when distinct from the serial ISSN. Unhyphenated, 8
     * digits. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    ISSN_L("38", "ISSN-L");

    public final String code;
    public final String description;

    SeriesIdentifierTypes(String code, String description) {
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

    private static volatile Map<String, SeriesIdentifierTypes> map;

    private static Map<String, SeriesIdentifierTypes> map() {
        Map<String, SeriesIdentifierTypes> result = map;
        if (result == null) {
            synchronized (SeriesIdentifierTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (SeriesIdentifierTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static SeriesIdentifierTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
