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
 * marker interface to assist in IDE navigation to code-list 86 (Bible text organization)
 */
interface CodeList86 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 86</b>
 * <p>
 * Description: Bible text organization
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_49.html#codelist86">ONIX
 *      Codelist 86 in Reference Guide</a>
 */
public enum BibleTextOrganizations implements OnixCodelist, CodeList86 {
    /**
     * A Bible with the text organized in the order in which events are believed to have happened
     */
    Chronological("CHR", "Chronological"),

    /**
     * A Bible which explores keywords or themes by referring text to preceding or following text
     */
    Chain_reference("CHA", "Chain reference"),

    /**
     * A Bible or other text in which different versions are printed one line above the other, so that the variations
     * can easily be detected
     */
    Interlinear("INT", "Interlinear"),

    /**
     * A Bible with two or more versions printed side by side
     */
    Parallel("PAR", "Parallel"),

    /**
     * A Bible in which the text is presented in the traditional order
     */
    Standard("STN", "Standard");

    public final String code;
    public final String description;

    BibleTextOrganizations(String code, String description) {
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

    public static BibleTextOrganizations byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (BibleTextOrganizations e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
