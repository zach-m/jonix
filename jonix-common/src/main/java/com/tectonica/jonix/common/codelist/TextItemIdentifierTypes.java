/*
 * Copyright (C) 2012-2020 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 43 (Text item identifier type)
 */
interface CodeList43 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 43</b>
 * <p>
 * Description: Text item identifier type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_58.html#codelist43">ONIX
 *      Codelist 43 in Reference Guide</a>
 */
public enum TextItemIdentifierTypes implements OnixCodelist, CodeList43 {
    /**
     * For example, a publisher's own identifier. Note that &lt;IDTypeName&gt; is required with proprietary identifiers
     */
    Proprietary("01", "Proprietary"),

    /**
     * Formerly known as the EAN-13 (unhyphenated)
     */
    GTIN_13("03", "GTIN-13"),

    DOI("06", "DOI"),

    /**
     * Publisher item identifier
     */
    PII("09", "PII"),

    /**
     * For serial items only
     */
    SICI("10", "SICI"),

    ISTC("11", "ISTC"),

    /**
     * (Unhyphenated)
     */
    ISBN_13("15", "ISBN-13"),

    /**
     * International Standard Content Code, a 'similarity hash' identifier derived algorithmically from the content
     * itself (see https://iscc.codes). &lt;IDValue&gt; is the 27-character case-sensitive string (including one hyphen)
     * comprising the Meta-ID and Content-ID components of a full ISCC generated from a digital manifestation of the
     * work. Use only with ONIX 3.0
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    ISCC("39", "ISCC");

    public final String code;
    public final String description;

    TextItemIdentifierTypes(String code, String description) {
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

    private static volatile Map<String, TextItemIdentifierTypes> map;

    private static Map<String, TextItemIdentifierTypes> map() {
        Map<String, TextItemIdentifierTypes> result = map;
        if (result == null) {
            synchronized (TextItemIdentifierTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (TextItemIdentifierTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static TextItemIdentifierTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
