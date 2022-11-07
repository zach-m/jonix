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
 * marker interface to assist in IDE navigation to code-list 250 (Resource identifier type)
 */
interface CodeList250 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 250</b>
 * <p>
 * Description: Resource identifier type
 * <p>
 * Jonix-Comment: Introduced in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_59.html#codelist250">ONIX
 *      Codelist 250 in Reference Guide</a>
 */
public enum ResourceIdentifierTypes implements OnixCodelist, CodeList250 {
    /**
     * For example, a publisher's internal digital asset ID. Note that &lt;IDTypeName&gt; is required with proprietary
     * identifiers
     */
    Proprietary("01", "Proprietary"),

    /**
     * International Standard Content Code, a 'similarity hash' derived algorithmically from the resource content itself
     * (see https://iscc.codes). &lt;IDValue&gt; is the 55-character case-sensitive string (including three hyphens)
     * forming the ISCC of the resource file
     */
    ISCC("09", "ISCC");

    public final String code;
    public final String description;

    ResourceIdentifierTypes(String code, String description) {
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

    public static ResourceIdentifierTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (ResourceIdentifierTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
