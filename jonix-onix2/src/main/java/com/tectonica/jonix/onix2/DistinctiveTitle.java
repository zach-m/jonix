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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Distinctive title of product</h1>
 * <p>
 * The full text of the distinctive title of the product, without abbreviation or abridgement, but excluding the
 * subtitle (if any). Where the title alone is not distinctive, elements may be taken from a set or series title and
 * part number <em>etc</em> to create a distinctive title. Where the product is an omnibus edition containing two or
 * more works by the same author, and there is no separate product title, a product title may be constructed by
 * concatenating the individual titles, with suitable punctuation, as in the second example below. (If, however, there
 * is a separate product title, or if more description of each individual work is required, the &lt;ContentItem&gt;
 * composite can be used for the individual works – see Group&nbsp;PR.18.) Optional and non-repeating. <strong>The
 * &lt;Title&gt; composite on a later page provides a more general method of handling all forms of title, and is to be
 * preferred.</strong>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length text, suggested maximum length 300 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;DistinctiveTitle&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b028&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;DistinctiveTitle&gt;A People's
 * Tragedy&lt;/DistinctiveTitle&gt;</tt></td>
 * </tr>
 * <tr>
 * <td></td>
 * <td><tt>&lt;b028&gt;Pride and prejudice / Sense and
 * sensibility / Northanger Abbey&lt;/b028&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DistinctiveTitle}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentItem} ⯈ {@link DistinctiveTitle}</li>
 * </ul>
 *
 * @deprecated
 */
@Deprecated
public class DistinctiveTitle implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "DistinctiveTitle";
    public static final String shortname = "b028";

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
     * Raw Format: Variable-length text, suggested maximum length 300 characters
     * <p>
     * (type: NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final DistinctiveTitle EMPTY = new DistinctiveTitle();

    public DistinctiveTitle() {
        exists = false;
    }

    public DistinctiveTitle(org.w3c.dom.Element element) {
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
     * @return whether this tag (&lt;DistinctiveTitle&gt; or &lt;b028&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
