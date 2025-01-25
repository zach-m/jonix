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

package com.tectonica.jonix.onix3;

import java.io.Serializable;
import java.util.function.Consumer;
import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Audience range value (1)</h1>
 * <p>
 * A value indicating an exact position within a range, or the upper or lower end of a range.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length string, suggested maximum 10 characters, according to the scheme specified in
 * &lt;AudienceRangeQualifier&gt;. (This element was originally defined as a variable-length integer, but its definition
 * was extended in ONIX 2.1 to enable non-numeric values to be carried. For values that BISAC has defined for US school
 * grades and pre-school levels, see List 77)</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;AudienceRangeValue&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b076&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;AudienceRangeValue&gt;10&lt;/AudienceRangeValue&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;AudienceRangeValue&gt; from the schema author:
 *
 * The measurement used for an audience or readership range (eg Grade 7, 11 years of age)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link AudienceRange}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link AudienceRange} ⯈ {@link AudienceRangeValue}</li>
 * </ul>
 */
public class AudienceRangeValue implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "AudienceRangeValue";
    public static final String shortname = "b076";

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
     * This is the raw content of AudienceRangeValue. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable length string, suggested maximum 10 characters, according to the scheme specified in
     * &lt;AudienceRangeQualifier&gt;. (This element was originally defined as a variable-length integer, but its
     * definition was extended in ONIX 2.1 to enable non-numeric values to be carried. For values that BISAC has defined
     * for US school grades and pre-school levels, see List 77)
     * <p>
     * (type: dt.NonEmptyString)
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
    public static final AudienceRangeValue EMPTY = new AudienceRangeValue();

    public AudienceRangeValue() {
        exists = false;
    }

    public AudienceRangeValue(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;AudienceRangeValue&gt; or &lt;b076&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<AudienceRangeValue> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
