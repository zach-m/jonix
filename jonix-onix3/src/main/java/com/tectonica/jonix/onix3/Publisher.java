/*
 * Copyright (C) 2012-2025 Zach Melamed
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

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

import com.tectonica.jonix.common.*;
import com.tectonica.jonix.common.OnixComposite.*;
import com.tectonica.jonix.common.codelist.*;
import com.tectonica.jonix.common.struct.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Publisher composite</h1>
 * <p>
 * An optional group of data elements which together identify an entity which is associated with the publishing of a
 * product. The composite allows additional publishing roles to be introduced without adding new fields. Each occurrence
 * of the composite must carry a publishing role code and either a name identifier or a name or both, and the composite
 * is repeatable in order to identify multiple entities.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Publisher&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;publisher&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Publisher&gt; from the schema author:
 *
 * Details of an organisation responsible for publishing the product &#9679; Added &lt;Funding&gt; at revision 3.0.3
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PublishingDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link Publisher}</li>
 * </ul>
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

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

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
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
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
                case PublishingRole.refname:
                case PublishingRole.shortname:
                    publishingRole = new PublishingRole(e);
                    break;
                case PublisherIdentifier.refname:
                case PublisherIdentifier.shortname:
                    publisherIdentifiers = JPU.addToList(publisherIdentifiers, new PublisherIdentifier(e));
                    break;
                case PublisherName.refname:
                case PublisherName.shortname:
                    publisherName = new PublisherName(e);
                    break;
                case Funding.refname:
                case Funding.shortname:
                    fundings = JPU.addToList(fundings, new Funding(e));
                    break;
                case Website.refname:
                case Website.shortname:
                    websites = JPU.addToList(websites, new Website(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Publisher&gt; or &lt;publisher&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Publisher> action) {
        if (exists) {
            action.accept(this);
        }
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private PublishingRole publishingRole = PublishingRole.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies a role played by an entity in the publishing of a product. Mandatory in each
     * occurrence of the &lt;Publisher&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public PublishingRole publishingRole() {
        _initialize();
        return publishingRole;
    }

    private ListOfOnixDataCompositeWithKey<PublisherIdentifier, JonixPublisherIdentifier,
        NameIdentifierTypes> publisherIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(PublisherIdentifier.class);

    /**
     * <p>
     * An optional group of data elements which together define the identifier of a publisher name. Optional, but
     * mandatory if the &lt;Publisher&gt; composite does not carry a &lt;PublisherName&gt;. The composite is repeatable
     * in order to specify multiple identifiers for the same publisher.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<PublisherIdentifier, JonixPublisherIdentifier, NameIdentifierTypes>
        publisherIdentifiers() {
        _initialize();
        return publisherIdentifiers;
    }

    private PublisherName publisherName = PublisherName.EMPTY;

    /**
     * <p>
     * The name of an entity associated with the publishing of a product. Mandatory if there is no publisher identifier
     * in an occurrence of the &lt;Publisher&gt; composite, and optional if a publisher identifier is included.
     * Non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public PublisherName publisherName() {
        _initialize();
        return publisherName;
    }

    private ListOfOnixComposite<Funding> fundings = JPU.emptyListOfOnixComposite(Funding.class);

    /**
     * <p>
     * An optional group of data elements which together identify a grant or award provided by the entity specified as a
     * funder in an occurence of the &lt;Publisher&gt; composite, to subsidise research or publication. Repeatable when
     * the funder provides multiple grants or awards. Used only when &lt;PublishingRole&gt; indicates the role of a
     * funder.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<Funding> fundings() {
        _initialize();
        return fundings;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = JPU.emptyListOfOnixDataComposite(Website.class);

    /**
     * <p>
     * An optional group of data elements which together identify and provide a pointer to a website which is related to
     * the publisher identified in an occurrence of the &lt;Publisher&gt; composite. Repeatable in order to provide
     * links to multiple websites.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }
}
