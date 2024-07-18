/*
 * Copyright (C) 2012-2024 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 224 (Status detail type severity)
 */
interface CodeList224 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 224</b>
 * <p>
 * Description: Status detail type severity
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_66.html#codelist224">ONIX
 *      Codelist 224 in Reference Guide</a>
 */
public enum StatusDetailTypeSeveritys implements OnixCodelist, CodeList224 {
    /**
     * Use ONLY if the message severity cannot be determined (eg with a legacy system unable to provide detailed error
     * codes)
     */
    Unclassifiable("U", "Unclassifiable"),

    /**
     * For information only, provided to encourage the ONIX data supplier to improve the quality of their data (eg
     * provision of a non-mandatory data element that is currently missing, better conformity with best practice, etc)
     */
    Info("I", "Info"),

    /**
     * Request for clarification or further detail of the meaning of the data provided
     */
    Query("Q", "Query"),

    /**
     * The ONIX data has been accepted as provided, but there may be issues in the way it is supplied
     */
    Warning("W", "Warning"),

    /**
     * Some data in an ONIX data element or message structure caused an error due to not meeting the requirements of the
     * standard. The data in question has been rejected, but processing of the remaining elements in the record (or the
     * remain records in the message, if used within &lt;MessageStatusDetail&gt;) has continued
     */
    Error("E", "Error"),

    /**
     * Some data in an ONIX data element or message structure caused an unrecoverable error due to not meeting the
     * requirements of the standard. The entire ONIX record has been rejected (or the entire message, if used within
     * &lt;MessageStatusDetail&gt;)
     */
    Fatal_error("F", "Fatal error");

    public final String code;
    public final String description;

    StatusDetailTypeSeveritys(String code, String description) {
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

    public static StatusDetailTypeSeveritys byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (StatusDetailTypeSeveritys e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<StatusDetailTypeSeveritys> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
