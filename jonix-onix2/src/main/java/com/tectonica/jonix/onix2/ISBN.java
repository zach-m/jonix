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

package com.tectonica.jonix.onix2;

import java.io.Serializable;
import java.util.function.Consumer;
import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>ISBN-10</h1>
 * <p>
 * The 10-character International Standard Book Number, the recognized standard identifier for books and certain other
 * non-serial publications up to 31 December 2006. Optional and non-repeating. <strong>The &lt;ProductIdentifier&gt;
 * composite on a later page provides a more general method of handling this and other product codes, and is to be
 * preferred. The &lt;ISBN&gt; element is on no account to be used to carry a 13-digit ISBN.</strong>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length, 10 characters, all numeric except last character, which may be letter X. The last character is a
 * check character calculated in accordance with rules given at http://www.isbn.spk-berlin.de/html/userman.htm</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ISBN&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b004&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;ISBN&gt;8474339790&lt;/ISBN&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * <li>&lt;{@link ContainedItem}&gt;</li>
 * <li>&lt;{@link NotForSale}&gt;</li>
 * <li>&lt;{@link RelatedProduct}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ISBN}</li>
 * <li>{@link Product} ⯈ {@link ContainedItem} ⯈ {@link ISBN}</li>
 * <li>{@link Product} ⯈ {@link NotForSale} ⯈ {@link ISBN}</li>
 * <li>{@link Product} ⯈ {@link RelatedProduct} ⯈ {@link ISBN}</li>
 * </ul>
 *
 * @deprecated
 */
@Deprecated
public class ISBN implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ISBN";
    public static final String shortname = "b004";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of ISBN. Could be null if {@code exists() == false}. Use {@link #value()} instead if you
     * want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Fixed-length, 10 characters, all numeric except last character, which may be letter X. The last
     * character is a check character calculated in accordance with rules given at
     * http://www.isbn.spk-berlin.de/html/userman.htm
     * <p>
     * (type: NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ISBN EMPTY = new ISBN();

    public ISBN() {
        exists = false;
    }

    public ISBN(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;ISBN&gt; or &lt;b004&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ISBN> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
