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
 * marker interface to assist in IDE navigation to code-list 197 (Collection sequence type)
 */
interface CodeList197 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 197</b>
 * <p>
 * Description: Collection sequence type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist197">ONIX
 * Codelist 197 in Reference Guide</a>
 */
public enum CollectionSequenceTypes implements OnixCodelist, CodeList197 {
    /**
     * A short explanatory label for the sequence should be provided in &lt;CollectionSequenceTypeName&gt;
     */
    Proprietary("01", "Proprietary"), //

    /**
     * Order as specified by the title, eg by volume or part number sequence, provided for confirmation
     */
    Title_order("02", "Title order"), //

    /**
     * Order of publication of products within the collection
     */
    Publication_order("03", "Publication order"), //

    /**
     * Order defined by a continuing narrative or temporal sequence within products in the collection. Applicable to
     * either fiction or to non-fiction (eg within a collection of history textbooks)
     */
    Temporal_narrative_order("04", "Temporal/narrative order"), //

    /**
     * Original publication order, for a republished collection or collected works originally published outside a
     * collection
     */
    Original_publication_order("05", "Original publication order"), //

    /**
     * Where it is different from the title order, publication order, narrative order etc &lt;p&gt;NOTE: Introduced in
     * Onix3
     */
    Suggested_reading_order("06", "Suggested reading order"), //

    /**
     * Where it is different from the title order, publication order, narrative order, reading order etc &lt;p&gt;NOTE:
     * Introduced in Onix3
     */
    Suggested_display_order("07", "Suggested display order");

    public final String code;
    public final String description;

    CollectionSequenceTypes(String code, String description) {
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

    public static CollectionSequenceTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (CollectionSequenceTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
