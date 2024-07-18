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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Religious text identifier</h1>
 * <p>
 * An ONIX code indicating a religious text other than the Bible. Mandatory in each occurrence of the
 * &lt;ReligiousText&gt; composite that does <em>not</em> include a &lt;Bible&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 88</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ReligiousTextIdentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b376&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ReligiousTextIdentifier&gt; from the schema author:
 *
 * Indication of a religious text other than the Christian Bible
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ReligiousText}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ReligiousText} ⯈ {@link ReligiousTextIdentifier}</li>
 * </ul>
 */
public class ReligiousTextIdentifier implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ReligiousTextIdentifier";
    public static final String shortname = "b376";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of ReligiousTextIdentifier. Could be null if {@code exists() == false}. Use
     * {@link #value()} instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Fixed length, two digits
     * <p>
     * (type: List88)
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
    public static final ReligiousTextIdentifier EMPTY = new ReligiousTextIdentifier();

    public ReligiousTextIdentifier() {
        exists = false;
    }

    public ReligiousTextIdentifier(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;ReligiousTextIdentifier&gt; or &lt;b376&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ReligiousTextIdentifier> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
