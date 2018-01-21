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

package com.tectonica.jonix.codelist;

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 19 (Unnamed person(s))
 */
interface CodeList19 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 19</b>
 * <p>
 * Description: Unnamed person(s)
 *
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist19">ONIX
 * Codelist 19 in Reference Guide</a>
 */
public enum UnnamedPersonss implements OnixCodelist, CodeList19 {
    Unknown("01", "Unknown"), //

    Anonymous("02", "Anonymous"), //

    /**
     * And others: additional contributors not listed
     */
    et_al("03", "et al"), //

    /**
     * When the product is a pack of books by different authors
     */
    Various_authors("04", "Various authors"), //

    /**
     * Use with Contributor role code E07 'read by', for audio books for the blind
     */
    Synthesized_voice_male("05", "Synthesized voice – male"), //

    /**
     * Use with Contributor role code E07 'read by', for audio books for the blind
     */
    Synthesized_voice_female("06", "Synthesized voice – female"), //

    /**
     * Use with Contributor role code E07 'read by', for audio books for the blind
     */
    Synthesized_voice_unspecified("07", "Synthesized voice – unspecified");

    public final String code;
    public final String description;

    private UnnamedPersonss(String code, String description) {
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

    public static UnnamedPersonss byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (UnnamedPersonss e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
