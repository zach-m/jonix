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
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Publisher name</h1><p>The name of the publisher of an equivalent product which is available in the territory
 * specified in the &lt;SalesRights&gt; composite, used only when &lt;SalesRightsType&gt; has a value indicating ‘not
 * for sale’. Optional and non-repeating. Except where they are essential to the recognized form of the name, it is
 * recommended that suffixes denoting incorporation (‘Co’, ‘Inc’, ‘Ltd’, ‘SA’, ‘GmbH’ <i>etc</i>) should be
 * omitted.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Variable length text, suggested maximum length
 * 100 characters</td></tr><tr><td>Reference name</td><td>&lt;PublisherName&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;b081&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Attributes</td><td>language</td></tr><tr><td>Example</td><td>&lt;b081&gt;Reed
 * International Books&lt;/b081&gt;</td></tr></table>
 */
public class PublisherName implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PublisherName";
    public static final String shortname = "b081";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    public LanguageCodes language;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Variable length text, suggested maximum length 100 characters<p> (type: dt.NonEmptyString)
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
    public static final PublisherName EMPTY = new PublisherName();

    public PublisherName() {
        exists = false;
    }

    public PublisherName(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));

        value = JPU.getContentAsString(element);
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
