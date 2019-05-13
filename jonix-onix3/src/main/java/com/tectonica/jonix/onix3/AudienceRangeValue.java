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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Audience range value (2)</h1><p>A value indicating the upper end of a range.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Variable length string, suggested maximum 10 characters, according to the
 * scheme specified in &lt;AudienceRangeQualifier&gt;. (This element was originally defined as a variable-length
 * integer, but its definition was extended in ONIX 2.1 to enable non-numeric values to be carried. For values that
 * BISAC has defined for US school grades and pre-school levels, see List 77)</td></tr><tr><td>Reference
 * name</td><td>&lt;AudienceRangeValue&gt;</td></tr><tr><td>Short tag</td><td>&lt;b076&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td>&lt;AudienceRangeValue&gt;11&lt;/AudienceRangeValue&gt;</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Variable length string, suggested maximum 10 characters, according to the scheme specified in
     * &lt;AudienceRangeQualifier&gt;. (This element was originally defined as a variable-length integer, but its
     * definition was extended in ONIX 2.1 to enable non-numeric values to be carried. For values that BISAC has defined
     * for US school grades and pre-school levels, see List 77)<p> (type: dt.NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public String _value() {
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
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsString(element);
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
