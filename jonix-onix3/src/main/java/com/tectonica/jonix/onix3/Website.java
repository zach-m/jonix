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
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixWebsite;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Website composite</h1><p>An optional group of data elements which together identify and provide a pointer to a
 * website which is related to the organization identified in an occurrence of the &lt;Supplier&gt; composite.
 * Repeatable in order to provide links to multiple websites.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;Website&gt;</td></tr><tr><td>Short tag</td><td>&lt;website&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class Website implements OnixDataComposite<JonixWebsite>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Website";
    public static final String shortname = "website";

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
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final Website EMPTY = new Website();

    public Website() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Website(org.w3c.dom.Element element) {
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
                case WebsiteRole.refname:
                case WebsiteRole.shortname:
                    websiteRole = new WebsiteRole(e);
                    break;
                case WebsiteDescription.refname:
                case WebsiteDescription.shortname:
                    websiteDescriptions = JPU.addToList(websiteDescriptions, new WebsiteDescription(e));
                    break;
                case WebsiteLink.refname:
                case WebsiteLink.shortname:
                    websiteLinks = JPU.addToList(websiteLinks, new WebsiteLink(e));
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

    private WebsiteRole websiteRole = WebsiteRole.EMPTY;

    /**
     * (this field is optional)
     */
    public WebsiteRole websiteRole() {
        _initialize();
        return websiteRole;
    }

    private ListOfOnixElement<WebsiteDescription, String> websiteDescriptions = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<WebsiteDescription, String> websiteDescriptions() {
        _initialize();
        return websiteDescriptions;
    }

    private ListOfOnixElement<WebsiteLink, String> websiteLinks = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<WebsiteLink, String> websiteLinks() {
        _initialize();
        return websiteLinks;
    }

    @Override
    public JonixWebsite asStruct() {
        _initialize();
        JonixWebsite struct = new JonixWebsite();
        struct.websiteDescriptions = websiteDescriptions.values();
        struct.websiteLinks = websiteLinks.values();
        struct.websiteRole = websiteRole.value;
        return struct;
    }
}
