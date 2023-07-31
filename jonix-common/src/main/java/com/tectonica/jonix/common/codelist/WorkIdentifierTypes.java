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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 16 (Work identifier type)
 */
interface CodeList16 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 16</b>
 * <p>
 * Description: Work identifier type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_62.html#codelist16">ONIX
 *      Codelist 16 in Reference Guide</a>
 */
public enum WorkIdentifierTypes implements OnixCodelist, CodeList16 {
    /**
     * Note that &lt;IDTypeName&gt; is required with proprietary identifiers
     */
    Proprietary("01", "Proprietary"),

    /**
     * 10-character ISBN of manifestation of work, when this is the only work identifier available - now DEPRECATED in
     * ONIX for Books, except where providing historical information for compatibility with legacy systems. It should
     * only be used in relation to products published before 2007 - when ISBN-13 superseded it - and should never be
     * used as the ONLY identifier (it should always be accompanied by the correct GTIN-13 / ISBN-13 of the
     * manifestation of the work)
     */
    ISBN_10("02", "ISBN-10"),

    /**
     * Digital Object Identifier (variable length and character set)
     */
    DOI("06", "DOI"),

    /**
     * International Standard Text Code (16 characters: numerals and letters A-F, unhyphenated)
     */
    ISTC("11", "ISTC"),

    /**
     * 13-character ISBN of a manifestation of work, when this is the only work identifier available (13 digits, without
     * spaces or hyphens)
     */
    ISBN_13("15", "ISBN-13"),

    /**
     * International Standard Recording Code
     */
    ISRC("18", "ISRC"),

    /**
     * Global Library Manifestation Identifier, OCLC's 'manifestation cluster' ID
     */
    GLIMIR("32", "GLIMIR"),

    /**
     * OCLC Work Identifier
     */
    OWI("33", "OWI"),

    /**
     * International Standard Content Code, a 'similarity hash' identifier derived algorithmically from the content
     * itself (see https://iscc.codes). &lt;IDValue&gt; is the 27-character case-sensitive string (including one hyphen)
     * comprising the Meta-ID and Content-ID components of a full ISCC generated from a digital manifestation of the
     * work. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    ISCC("39", "ISCC");

    public final String code;
    public final String description;

    WorkIdentifierTypes(String code, String description) {
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

    private static volatile Map<String, WorkIdentifierTypes> map;

    private static Map<String, WorkIdentifierTypes> map() {
        Map<String, WorkIdentifierTypes> result = map;
        if (result == null) {
            synchronized (WorkIdentifierTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (WorkIdentifierTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static WorkIdentifierTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<WorkIdentifierTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
