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
 * marker interface to assist in IDE navigation to code-list 149 (Title element level)
 */
interface CodeList149 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 149</b>
 * <p>
 * Description: Title element level
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_65.html#codelist149">ONIX
 *      Codelist 149 in Reference Guide</a>
 */
public enum TitleElementLevels implements OnixCodelist, CodeList149 {
    /**
     * The title element refers to an individual product
     */
    Product("01", "Product"),

    /**
     * The title element refers to the top level of a bibliographic collection
     */
    Collection_level("02", "Collection level"),

    /**
     * The title element refers to an intermediate level of a bibliographic collection that comprises two or more
     * 'sub-collections'
     */
    Subcollection("03", "Subcollection"),

    /**
     * The title element refers to a content item within a product, eg a work included in a combined or 'omnibus'
     * edition, or a chapter in a book. Generally used only for titles within &lt;ContentItem&gt; (Block 3)
     */
    Content_item("04", "Content item"),

    /**
     * The title element names a multimedia franchise, licensed property or master brand where the use of the brand
     * spans multiple collections and product forms, and possibly multiple imprints and publishers. It need not have a
     * hierarchical relationship with title elements at other levels, or with other master brands. Used only for branded
     * media properties carrying, for example, a children's character brand or film franchise branding
     */
    Master_brand("05", "Master brand"),

    /**
     * The title element refers to an intermediate level of a bibliographic collection that is a subdivision of a
     * sub-collection (a third level of collective identity)
     */
    Sub_subcollection("06", "Sub-subcollection"),

    /**
     * The title element names a 'universe', where parallel or intersecting narratives spanning multiple works and
     * multiple characters occur in the same consistent fictional setting. It need not have a hierarchical relationship
     * with title elements at other levels, in particular with master brands. Used primarily for comic books, but
     * applicable to other fiction where appropriate
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Universe("07", "Universe");

    public final String code;
    public final String description;

    TitleElementLevels(String code, String description) {
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

    public static TitleElementLevels byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (TitleElementLevels e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<TitleElementLevels> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
