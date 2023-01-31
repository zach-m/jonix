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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 2 (Product composition)
 */
interface CodeList2 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 2</b>
 * <p>
 * Description: Product composition
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_60.html#codelist2">ONIX
 *      Codelist 2 in Reference Guide</a>
 */
public enum ProductCompositions implements OnixCodelist, CodeList2 {
    Single_component_retail_product("00", "Single-component retail product"),

    /**
     * Used only when an ONIX record is required for a component-as-an-item, even though it is not currently available
     * as such
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Single_component_not_available_separately("01", "Single-component, not available separately"),

    /**
     * Multiple-component product retailed as a whole
     */
    Multiple_component_retail_product("10", "Multiple-component retail product"),

    /**
     * Used only when an ONIX record is required for a collection-as-a-whole, even though it is not currently retailed
     * as such
     */
    Multiple_item_collection_retailed_as_separate_parts("11", "Multiple-item collection, retailed as separate parts"),

    /**
     * Product available to the book trade, but not for retail sale, and not carrying retail items, eg empty dumpbin,
     * empty counterpack, promotional material
     */
    Trade_only_product("20", "Trade-only product"),

    /**
     * Product available to the book trade, but not for general retail sale as a whole. It carries multiple components
     * for retailing as separate items, eg shrink-wrapped trade pack, filled dumpbin, filled counterpack
     */
    Multiple_item_trade_only_pack("30", "Multiple-item trade-only pack"),

    /**
     * Carrying multiple components, primarily for retailing as separate items. The pack may be split and retailed as
     * separate items OR retailed as a single item. Use instead of Multiple-item trade-only pack (code 30) if the data
     * provider specifically wishes to make explicit that the pack may optionally be retailed as a whole
     */
    Multiple_item_pack("31", "Multiple-item pack");

    public final String code;
    public final String description;

    ProductCompositions(String code, String description) {
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

    public static ProductCompositions byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (ProductCompositions e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
