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

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 154 (Content audience)
 */
interface CodeList154 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 154</b>
 * <p>
 * Description: Content audience
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_60.html#codelist154">ONIX
 *      Codelist 154 in Reference Guide</a>
 */
public enum ContentAudiences implements OnixCodelist, CodeList154 {
    /**
     * Any audience
     */
    Unrestricted("00", "Unrestricted"),

    /**
     * Distribution by agreement between the parties to the ONIX exchange (this value is provided to cover applications
     * where ONIX content includes material which is not for general distribution)
     */
    Restricted("01", "Restricted"),

    /**
     * Distributors, bookstores, publisher's own staff etc
     */
    Booktrade("02", "Booktrade"),

    End_customers("03", "End-customers"),

    Librarians("04", "Librarians"),

    Teachers("05", "Teachers"),

    Students("06", "Students"),

    /**
     * Press or other media
     */
    Press("07", "Press"),

    /**
     * Where a specially formatted description is required for this audience
     */
    Shopping_comparison_service("08", "Shopping comparison service"),

    /**
     * Text not intended for display, but may be used (in addition to any less restricted text) for indexing and search
     */
    Search_engine_index("09", "Search engine index"),

    /**
     * (Including vloggers, influencers etc) Where this is distinct from end customers or the Press
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Bloggers("10", "Bloggers");

    public final String code;
    public final String description;

    ContentAudiences(String code, String description) {
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

    private static volatile Map<String, ContentAudiences> map;

    private static Map<String, ContentAudiences> map() {
        Map<String, ContentAudiences> result = map;
        if (result == null) {
            synchronized (ContentAudiences.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ContentAudiences e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ContentAudiences byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
