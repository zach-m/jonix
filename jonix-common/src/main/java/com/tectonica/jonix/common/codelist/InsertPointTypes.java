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
 * marker interface to assist in IDE navigation to code-list 255 (Insert point type)
 */
interface CodeList255 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 255</b>
 * <p>
 * Description: Insert point type
 * <p>
 * JONIX adds: Not included in Onix2
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_67.html#codelist255">ONIX
 *      Codelist 255 in Reference Guide</a>
 */
public enum InsertPointTypes implements OnixCodelist, CodeList255 {
    /**
     * Insert appears after an even numbered or before an odd numbered logical page. &lt;InsertPointValue&gt; is an
     * integer page number
     */
    Adjacent_to_logical_page("ALP", "Adjacent to logical page"),

    /**
     * Insert appears after an even numbered or before an odd numbered printed page number. &lt;InsertPointValue&gt; is
     * an integer page number
     */
    Adjacent_to_physical_page("APP", "Adjacent to physical page"),

    /**
     * Insert appears in the body at a specific timecode (hours, minutes, seconds, counted from the beginning of the
     * product before any inserts are added). &lt;InsertPointValue&gt; is in the format HHHMMSS. Fill with leading
     * zeroes if any elements are missing. If centisecond precision is required, use HHHMMSScc
     */
    At_timecode("ATC", "At timecode"),

    /**
     * Insert appears before the block-level HTML element - &amp;lt;InsertPointValue&gt; is the value of the id or name
     * attribute of the block-level element (which must be unique within the body of the product)
     */
    Adjacent_to_HTML_label("AHL", "Adjacent to HTML label");

    public final String code;
    public final String description;

    InsertPointTypes(String code, String description) {
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

    public static InsertPointTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (InsertPointTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<InsertPointTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
