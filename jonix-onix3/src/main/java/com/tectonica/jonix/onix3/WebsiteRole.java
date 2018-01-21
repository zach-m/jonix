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
import com.tectonica.jonix.codelist.WebsiteRoles;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Website purpose</h1><p>An ONIX code which identifies the role or purpose of the website which is linked through
 * the &lt;WebsiteLink&gt; element. Optional and non-repeating.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Fixed-length, two digits</td></tr><tr><td>Codelist</td><td>List
 * 73</td></tr><tr><td>Reference name</td><td>&lt;WebsiteRole&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;b367&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td>&lt;b367&gt;34&lt;/b367&gt;
 * (Supplier's B2B website)</td></tr></table>
 */
public class WebsiteRole implements OnixElement<WebsiteRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "WebsiteRole";
    public static final String shortname = "b367";

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

    public WebsiteRoles value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public WebsiteRoles _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final WebsiteRole EMPTY = new WebsiteRole();

    public WebsiteRole() {
        exists = false;
    }

    public WebsiteRole(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = WebsiteRoles.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
