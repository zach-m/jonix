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
import com.tectonica.jonix.codelist.ContentAudiences;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Target audience</h1><p>An ONIX code which identifies the audience for which the supporting resource is intended.
 * Mandatory in each occurrence of the &lt;SupportingResource&gt; composite, and repeatable.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Fixed-length, two digits</td></tr><tr><td>Codelist</td><td>List
 * 154</td></tr><tr><td>Reference name</td><td>&lt;ContentAudience&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;x427&gt;</td></tr><tr><td>Cardinality</td><td>1&#8230;n</td></tr><tr><td>Example</td><td>&lt;x427&gt;00&lt;/x427&gt;
 * (Unrestricted [any audience])</td></tr></table>
 */
public class ContentAudience implements OnixElement<ContentAudiences>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ContentAudience";
    public static final String shortname = "x427";

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

    public ContentAudiences value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public ContentAudiences _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ContentAudience EMPTY = new ContentAudience();

    public ContentAudience() {
        exists = false;
    }

    public ContentAudience(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = ContentAudiences.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
