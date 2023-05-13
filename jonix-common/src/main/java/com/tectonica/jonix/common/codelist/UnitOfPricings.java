/*
 * Copyright (C) 2012-2023 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 60 (Unit of pricing)
 */
interface CodeList60 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 60</b>
 * <p>
 * Description: Unit of pricing
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_61.html#codelist60">ONIX
 *      Codelist 60 in Reference Guide</a>
 */
public enum UnitOfPricings implements OnixCodelist, CodeList60 {
    /**
     * Default. Note where the product is a pack of multiple copies, the price is per multi-item product, not per
     * individual copy within the pack
     */
    Per_copy_of_whole_product("00", "Per copy of whole product"),

    Per_page_for_printed_loose_leaf_content_only("01", "Per page for printed loose-leaf content only");

    public final String code;
    public final String description;

    UnitOfPricings(String code, String description) {
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

    public static UnitOfPricings byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (UnitOfPricings e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
