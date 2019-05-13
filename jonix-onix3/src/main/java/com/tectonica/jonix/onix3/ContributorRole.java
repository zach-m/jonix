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
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Contributor role</h1><p>An ONIX code indicating the role played by a person or corporate body in the creation of
 * the product. Mandatory in each occurrence of a &lt;Contributor&gt; composite, and may be repeated if the same person
 * or corporate body has more than one role in relation to the product.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Fixed length, one letter and two digits</td></tr><tr><td>Codelist</td><td>List
 * 17</td></tr><tr><td>Reference name</td><td>&lt;ContributorRole&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;b035&gt;</td></tr><tr><td>Cardinality</td><td>1&#8230;n</td></tr><tr><td>Example</td><td>&lt;b035&gt;A01&lt;/b035&gt;
 * (Written by)</td></tr></table>
 */
public class ContributorRole implements OnixElement<ContributorRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ContributorRole";
    public static final String shortname = "b035";

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

    public ContributorRoles value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public ContributorRoles _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ContributorRole EMPTY = new ContributorRole();

    public ContributorRole() {
        exists = false;
    }

    public ContributorRole(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = ContributorRoles.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
