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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 13 (Collection identifier type)
 */
interface CodeList13 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 13</b>
 * <p>
 * Description: Collection identifier type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_68.html#codelist13">ONIX
 *      Codelist 13 in Reference Guide</a>
 */
public enum CollectionIdentifierTypes implements OnixCodelist, CodeList13 {
    /**
     * For example, publisher's own series ID. Note that &lt;IDTypeName&gt; is required with proprietary identifiers
     */
    Proprietary("01", "Proprietary"),

    /**
     * International Standard Serial Number, unhyphenated, 8 digits
     */
    ISSN("02", "ISSN"),

    /**
     * Maintained by the Deutsche Nationalbibliothek
     */
    German_National_Bibliography_series_ID("03", "German National Bibliography series ID"),

    /**
     * Maintained by VLB
     */
    German_Books_in_Print_series_ID("04", "German Books in Print series ID"),

    /**
     * Maintained by Electre Information, France
     */
    Electre_series_ID("05", "Electre series ID"),

    /**
     * Digital Object Identifier (variable length and character set, beginning '10.' and without https://doi.org/ or the
     * older http://dx.doi.org/)
     */
    DOI("06", "DOI"),

    /**
     * Use only where the collection (series or set) is available as a single product
     */
    ISBN_13("15", "ISBN-13"),

    /**
     * Uniform Resource Name using full URN syntax, eg urn:issn:1476-4687 - though where a specific code for the
     * identifier type is available, use of that code (ie code 02 for ISSN) is preferred
     */
    URN("22", "URN"),

    /**
     * Japanese magazine identifier, similar in scope to ISSN. Five digits to identify the periodical, without any
     * hyphen or two digit extension. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    JP_Magazine_ID("27", "JP Magazine ID"),

    /**
     * French National Bibliography series ID. Identifiant des publications en s&#233;rie maintenu par la
     * Biblioth&#232;que Nationale de France
     */
    BNF_Control_number("29", "BNF Control number"),

    /**
     * Archival Resource Key, as a URL (including the address of the ARK resolver provided by eg a national library)
     */
    ARK("35", "ARK"),

    /**
     * International Standard Serial Number 'linking ISSN', used when distinct from the serial ISSN. Unhyphenated, 8
     * digits. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    ISSN_L("38", "ISSN-L");

    public final String code;
    public final String description;

    CollectionIdentifierTypes(String code, String description) {
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

    private static volatile Map<String, CollectionIdentifierTypes> map;

    private static Map<String, CollectionIdentifierTypes> map() {
        Map<String, CollectionIdentifierTypes> result = map;
        if (result == null) {
            synchronized (CollectionIdentifierTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (CollectionIdentifierTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static CollectionIdentifierTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<CollectionIdentifierTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
