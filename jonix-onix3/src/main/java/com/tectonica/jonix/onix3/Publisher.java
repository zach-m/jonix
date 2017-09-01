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
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixPublisherIdentifier;
import com.tectonica.jonix.struct.JonixWebsite;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Publisher composite</h1><p>A repeatable group of data elements which together identify an entity which is
 * associated with the publishing of a product. The composite allows additional publishing roles to be introduced
 * without adding new fields. Each occurrence of the composite must carry a publishing role code and either a name
 * identifier code or a name or both.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;Publisher&gt;</td></tr><tr><td>Short tag</td><td>&lt;publisher&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class Publisher implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Publisher";
    public static final String shortname = "publisher";

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
    public static final Publisher EMPTY = new Publisher();

    public Publisher() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Publisher(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            if (name.equals(PublishingRole.refname) || name.equals(PublishingRole.shortname)) {
                publishingRole = new PublishingRole(e);
            } else if (name.equals(PublisherIdentifier.refname) || name.equals(PublisherIdentifier.shortname)) {
                publisherIdentifiers = JPU.addToList(publisherIdentifiers, new PublisherIdentifier(e));
            } else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname)) {
                publisherName = new PublisherName(e);
            } else if (name.equals(Website.refname) || name.equals(Website.shortname)) {
                websites = JPU.addToList(websites, new Website(e));
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

    private PublishingRole publishingRole = PublishingRole.EMPTY;

    /**
     * (this field is required)
     */
    public PublishingRole publishingRole() {
        initialize();
        return publishingRole;
    }

    private ListOfOnixDataCompositeWithKey<PublisherIdentifier, JonixPublisherIdentifier, NameCodeTypes>
        publisherIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<PublisherIdentifier, JonixPublisherIdentifier, NameCodeTypes> publisherIdentifiers() {
        initialize();
        return publisherIdentifiers;
    }

    private PublisherName publisherName = PublisherName.EMPTY;

    /**
     * (this field is optional)
     */
    public PublisherName publisherName() {
        initialize();
        return publisherName;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        initialize();
        return websites;
    }
}
