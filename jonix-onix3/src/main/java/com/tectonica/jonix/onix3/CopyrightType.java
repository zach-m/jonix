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
import com.tectonica.jonix.codelist.RightsTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Copyright statement type</h1><p>An optional ONIX code indicating the type of right covered by the statement,
 * typically a copyright or neighbouring right. If omitted, the default is that the statement represents a
 * copyright.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length, one
 * letter</td></tr><tr><td>Codelist</td><td>List 219</td></tr><tr><td>Reference name</td><td>&lt;CopyrightType&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;x512&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td>&lt;CopyrightType&gt;P&lt;/CopyrightType&gt;
 * (&#8471; phonogram right)</td></tr></table>
 */
public class CopyrightType implements OnixElement<RightsTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CopyrightType";
    public static final String shortname = "x512";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public RightsTypes value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public RightsTypes _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final CopyrightType EMPTY = new CopyrightType();

    public CopyrightType() {
        exists = false;
    }

    public CopyrightType(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = RightsTypes.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
