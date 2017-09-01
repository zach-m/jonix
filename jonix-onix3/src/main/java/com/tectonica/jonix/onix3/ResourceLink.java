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
 * <h1>Resource link</h1><p>A URI which provides a link to a supporting resource. Mandatory in each occurrence of the
 * &lt;ResourceVersion&gt; composite, and repeatable if the resource can be linked in more than one way, <i>eg</i> by
 * URL or DOI.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Uniform Resource Identifier, expressed in
 * full URI syntax in accordance with W3C standards</td></tr><tr><td>Reference name</td><td>&lt;ResourceLink&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;x435&gt;</td></tr><tr><td>Cardinality</td><td>1&#8230;n</td></tr><tr><td>Example</td><td>&lt;x435&gt;http://www.zzzzzzzz.com/resource.jpg&lt;/x435&gt;</td></tr></table>
 */
public class ResourceLink implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ResourceLink";
    public static final String shortname = "x435";

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

    /**
     * Raw Format: Uniform Resource Identifier, expressed in full URI syntax in accordance with W3C standards<p> (type:
     * dt.NonEmptyURI)
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
    public static final ResourceLink EMPTY = new ResourceLink();

    public ResourceLink() {
        exists = false;
    }

    public ResourceLink(org.w3c.dom.Element element) {
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
