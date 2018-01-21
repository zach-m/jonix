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
 * marker interface to assist in IDE navigation to code-list 56 (Audience restriction flag)
 */
interface CodeList56 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 56</b>
 * <p>
 * Description: Audience restriction flag
 *
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist56">ONIX
 * Codelist 56 in Reference Guide</a>
 */
public enum AudienceRestrictionFlags implements OnixCodelist, CodeList56 {
    Restrictions_apply_see_note("R", "Restrictions apply, see note"), //

    /**
     * Indexed for the German market - in Deutschland indiziert
     */
    Indiziert("X", "Indiziert");

    public final String code;
    public final String description;

    private AudienceRestrictionFlags(String code, String description) {
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

    public static AudienceRestrictionFlags byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (AudienceRestrictionFlags e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
