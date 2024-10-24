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
 * marker interface to assist in IDE navigation to code-list 146 (Usage status)
 */
interface CodeList146 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 146</b>
 * <p>
 * Description: Usage status
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_67.html#codelist146">ONIX
 *      Codelist 146 in Reference Guide</a>
 */
public enum UsageStatuss implements OnixCodelist, CodeList146 {
    Permitted_unlimited("01", "Permitted unlimited"),

    /**
     * Limit should be specified in &lt;EpubUsageLimit&gt; or &lt;PriceConstraintLimit&gt;
     */
    Permitted_subject_to_limit("02", "Permitted subject to limit"),

    Prohibited("03", "Prohibited");

    public final String code;
    public final String description;

    UsageStatuss(String code, String description) {
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

    public static UsageStatuss byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (UsageStatuss e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<UsageStatuss> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
