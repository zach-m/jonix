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
 * marker interface to assist in IDE navigation to code-list 89 (Religious text feature type)
 */
interface CodeList89 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 89</b>
 * <p>
 * Description: Religious text feature type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_69.html#codelist89">ONIX
 *      Codelist 89 in Reference Guide</a>
 */
public enum ReligiousTextFeatureTypes implements OnixCodelist, CodeList89 {
    /**
     * A church season or activity for which a religious text is intended. Religious text feature code must be taken
     * from List 90
     */
    Church_season_or_activity("01", "Church season or activity");

    public final String code;
    public final String description;

    ReligiousTextFeatureTypes(String code, String description) {
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

    public static ReligiousTextFeatureTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (ReligiousTextFeatureTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<ReligiousTextFeatureTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
