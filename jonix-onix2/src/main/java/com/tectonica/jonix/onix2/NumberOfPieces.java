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
 * <h1>Number of pieces</h1>
 * <p>
 * If the product is homogeneous (<em>ie</em> all items or pieces which constitute the product have the same form), the
 * number of items or pieces may be included here. If the product consists of a number of items or pieces of different
 * forms (<em>eg</em> books and audio cassettes), the &lt;ContainedItem&gt; composite should be used – see below. This
 * field is optional and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length integer, suggested maximum length 4 digits.</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;NumberOfPieces&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b210&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;NumberOfPieces&gt;3&lt;/NumberOfPieces&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * <li>&lt;{@link ContainedItem}&gt;</li>
 * <li>&lt;{@link RelatedProduct}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link NumberOfPieces}</li>
 * <li>{@link Product} ⯈ {@link ContainedItem} ⯈ {@link NumberOfPieces}</li>
 * <li>{@link Product} ⯈ {@link RelatedProduct} ⯈ {@link NumberOfPieces}</li>
 * </ul>
 */
public class NumberOfPieces implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "NumberOfPieces";
    public static final String shortname = "b210";

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
     * This is the raw content of NumberOfPieces. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable-length integer, suggested maximum length 4 digits.
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
    public static final NumberOfPieces EMPTY = new NumberOfPieces();

    public NumberOfPieces() {
        exists = false;
    }

    public NumberOfPieces(org.w3c.dom.Element element) {
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
     * @return whether this tag (&lt;NumberOfPieces&gt; or &lt;b210&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<NumberOfPieces> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
