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
import com.tectonica.jonix.codelist.AvItemTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>AV item type code</h1><p>An ONIX code which identifies the nature of an audio or audiovisual content item.
 * Mandatory in each occurrence of the &lt;AVItem&gt; composite, and non-repeatable.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Fixed length, two digits</td></tr><tr><td>Codelist</td><td>List
 * 240</td></tr><tr><td>Reference name</td><td>&lt;AVItemType&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;x540&gt;</td></tr><tr><td>Cardinality</td><td>1</td></tr><tr><td>Example</td><td>&lt;x540&gt;03&lt;/x540&gt;
 * (Body matter)</td></tr></table>
 */
public class AVItemType implements OnixElement<AvItemTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "AVItemType";
    public static final String shortname = "x540";

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

    public AvItemTypes value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public AvItemTypes _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final AVItemType EMPTY = new AVItemType();

    public AVItemType() {
        exists = false;
    }

    public AVItemType(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = AvItemTypes.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}