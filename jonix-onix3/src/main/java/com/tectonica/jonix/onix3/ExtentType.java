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
import com.tectonica.jonix.codelist.ExtentTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Extent type code</h1><p>An ONIX code which identifies the type of extent carried in the composite, <i>eg</i>
 * running time for an audio or video product. Mandatory in each occurrence of the &lt;Extent&gt; composite, and
 * non-repeating. From Issue 9 of the code lists, an extended set of values for &lt;ExtentType&gt; has been defined to
 * allow more accurate description of pagination.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length,
 * two digits</td></tr><tr><td>Codelist</td><td>List 23</td></tr><tr><td>Reference
 * name</td><td>&lt;ExtentType&gt;</td></tr><tr><td>Short tag</td><td>&lt;b218&gt;</td></tr><tr><td>Cardinality</td><td>1</td></tr><tr><td>Example</td><td>&lt;ExtentType&gt;09&lt;/ExtentType&gt;
 * (Duration [running time])</td></tr></table>
 */
public class ExtentType implements OnixElement<ExtentTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ExtentType";
    public static final String shortname = "b218";

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

    public ExtentTypes value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public ExtentTypes _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ExtentType EMPTY = new ExtentType();

    public ExtentType() {
        exists = false;
    }

    public ExtentType(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = ExtentTypes.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
