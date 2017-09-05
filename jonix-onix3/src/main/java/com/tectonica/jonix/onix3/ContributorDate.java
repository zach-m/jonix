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
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.PersonOrganizationDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixContributorDate;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Contributor date composite</h1><p>A repeatable group of data elements which together specify a date associated
 * with the person or organization identified in an occurrence of the &lt;Contributor&gt; composite, <i>eg</i> birth or
 * death. Optional.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;ContributorDate&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;contributordate&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class ContributorDate
    implements OnixDataCompositeWithKey<JonixContributorDate, PersonOrganizationDateRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ContributorDate";
    public static final String shortname = "contributordate";

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
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final ContributorDate EMPTY = new ContributorDate();

    public ContributorDate() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ContributorDate(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
    }

    @Override
    public void _initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case ContributorDateRole.refname:
                case ContributorDateRole.shortname:
                    contributorDateRole = new ContributorDateRole(e);
                    break;
                case DateFormat.refname:
                case DateFormat.shortname:
                    dateFormat = new DateFormat(e);
                    break;
                case Date.refname:
                case Date.shortname:
                    date = new Date(e);
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ContributorDateRole contributorDateRole = ContributorDateRole.EMPTY;

    /**
     * (this field is required)
     */
    public ContributorDateRole contributorDateRole() {
        _initialize();
        return contributorDateRole;
    }

    private DateFormat dateFormat = DateFormat.EMPTY;

    /**
     * (this field is optional)
     */
    public DateFormat dateFormat() {
        _initialize();
        return dateFormat;
    }

    private Date date = Date.EMPTY;

    /**
     * (this field is required)
     */
    public Date date() {
        _initialize();
        return date;
    }

    @Override
    public JonixContributorDate asStruct() {
        _initialize();
        JonixContributorDate struct = new JonixContributorDate();
        struct.contributorDateRole = contributorDateRole.value;
        struct.dateFormat = dateFormat.value;
        struct.date = date.value;
        return struct;
    }

    @Override
    public PersonOrganizationDateRoles structKey() {
        return contributorDateRole().value;
    }
}
