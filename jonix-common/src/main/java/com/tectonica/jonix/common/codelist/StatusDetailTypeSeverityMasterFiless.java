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
 * marker interface to assist in IDE navigation to code-list 261 (Status detail type severity (master files))
 */
interface CodeList261 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 261</b>
 * <p>
 * Description: Status detail type severity (master files)
 * <p>
 * JONIX adds: Not included in Onix2
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_70.html#codelist261">ONIX
 *      Codelist 261 in Reference Guide</a>
 */
public enum StatusDetailTypeSeverityMasterFiless implements OnixCodelist, CodeList261 {
    /**
     * Use ONLY if the error message severity cannot be determined (eg with a legacy system unable to provide detailed
     * error codes)
     */
    Unclassifiable("u", "Unclassifiable"),

    /**
     * For information only, provided to encourage the master file supplier to improve the quality of their files (eg to
     * make rendering of the product more reliable/interoperable, or to improve accessibility, etc)
     */
    Info("i", "Info"),

    /**
     * Request for clarification or further detail of the meaning of some part of the master file data provided
     */
    Query("q", "Query"),

    /**
     * The master files have been accepted as provided, but there may be issues in the way they were supplied
     */
    Warning("w", "Warning"),

    /**
     * Some data in the content or structure of a master file caused an error due to not meeting the requirements of the
     * relevant standard. The master file in question has been rejected, but processing of the remaining master files
     * comprising the product has continued
     */
    Error("e", "Error"),

    /**
     * Some data in the content or structure of a master file caused an unrecoverable error due to not meeting the
     * requirements of the relevant standard. The entire set of master files for the product has been rejected
     */
    Fatal_error("f", "Fatal error");

    public final String code;
    public final String description;

    StatusDetailTypeSeverityMasterFiless(String code, String description) {
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

    public static StatusDetailTypeSeverityMasterFiless byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (StatusDetailTypeSeverityMasterFiless e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<StatusDetailTypeSeverityMasterFiless> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
