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
import com.tectonica.jonix.codelist.BibleTextOrganizations;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Bible text organization</h1><p>An ONIX code indicating the way in which the content of a Bible or selected
 * Biblical text is organized, for example ‘Chronological’, ‘Chain reference’. Optional and non-repeating.</p><table
 * border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length, three letters</td></tr><tr><td>Codelist</td><td>List
 * 86</td></tr><tr><td>Reference name</td><td>&lt;BibleTextOrganization&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;b355&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td>&lt;b355&gt;CHA&lt;/b355&gt;
 * (Chain reference)</td></tr></table>
 */
public class BibleTextOrganization implements OnixElement<BibleTextOrganizations>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "BibleTextOrganization";
    public static final String shortname = "b355";

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

    public BibleTextOrganizations value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public BibleTextOrganizations _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final BibleTextOrganization EMPTY = new BibleTextOrganization();

    public BibleTextOrganization() {
        exists = false;
    }

    public BibleTextOrganization(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = BibleTextOrganizations.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
