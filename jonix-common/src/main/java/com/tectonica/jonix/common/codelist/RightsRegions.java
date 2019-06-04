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
 * marker interface to assist in IDE navigation to code-list 47 (Rights region)
 */
interface CodeList47 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 47</b>
 * <p>
 * Description: Rights region
 * <p>
 * Jonix-Comment: Deprecated in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_36.html#codelist47">ONIX
 * Codelist 47 in Reference Guide</a>
 */
public enum RightsRegions implements OnixCodelist, CodeList47 {
    World("000", "World"), //

    World_except_territories_specified_elsewhere_in_rights_statements("001",
        "World except territories specified elsewhere in rights statements"), //

    UK_airports("002", "UK airports"), //

    /**
     * Use when an open market edition is published under its own ISBN
     */
    UK_open_market_("003", "UK ‘open market’");

    public final String code;
    public final String description;

    RightsRegions(String code, String description) {
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

    public static RightsRegions byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (RightsRegions e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
