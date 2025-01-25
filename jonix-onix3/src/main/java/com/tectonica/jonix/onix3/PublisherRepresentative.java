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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixAgentIdentifier;
import com.tectonica.jonix.common.struct.JonixWebsite;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Publisher representative composite</h1>
 * <p>
 * A repeatable group of data elements which together identify a publisher representative in a specified market.
 * Optional, and repeated only if the publisher has two or more representatives.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PublisherRepresentative&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;publisherrepresentative&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;PublisherRepresentative&gt; from the schema author:
 *
 * Details of an organisation appointed by the publisher to act on its behalf in a specific market, eg a 'local
 * publisher', sales agent etc
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link MarketPublishingDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link MarketPublishingDetail} ⯈ {@link PublisherRepresentative}</li>
 * </ul>
 */
public class PublisherRepresentative implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PublisherRepresentative";
    public static final String shortname = "publisherrepresentative";

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
    public static final PublisherRepresentative EMPTY = new PublisherRepresentative();

    public PublisherRepresentative() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PublisherRepresentative(org.w3c.dom.Element element) {
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
                case AgentRole.refname:
                case AgentRole.shortname:
                    agentRole = new AgentRole(e);
                    break;
                case AgentIdentifier.refname:
                case AgentIdentifier.shortname:
                    agentIdentifiers = JPU.addToList(agentIdentifiers, new AgentIdentifier(e));
                    break;
                case AgentName.refname:
                case AgentName.shortname:
                    agentName = new AgentName(e);
                    break;
                case TelephoneNumber.refname:
                case TelephoneNumber.shortname:
                    telephoneNumbers = JPU.addToList(telephoneNumbers, new TelephoneNumber(e));
                    break;
                case FaxNumber.refname:
                case FaxNumber.shortname:
                    faxNumbers = JPU.addToList(faxNumbers, new FaxNumber(e));
                    break;
                case EmailAddress.refname:
                case EmailAddress.shortname:
                    emailAddresss = JPU.addToList(emailAddresss, new EmailAddress(e));
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
     * @return whether this tag (&lt;PublisherRepresentative&gt; or &lt;publisherrepresentative&gt;) is explicitly
     *         provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PublisherRepresentative> action) {
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

    private AgentRole agentRole = AgentRole.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the role of an agent in relation to the product in the specified market, <i>eg</i>
     * Exclusive sales agent, Local publisher, <i>etc</i>. Mandatory in each occurrence of the
     * &lt;PublisherRepresentative&gt; composite.
     * </p>
     * JONIX adds: this field is required
     */
    public AgentRole agentRole() {
        _initialize();
        return agentRole;
    }

    private ListOfOnixDataCompositeWithKey<AgentIdentifier, JonixAgentIdentifier,
        SupplierIdentifierTypes> agentIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(AgentIdentifier.class);

    /**
     * <p>
     * A group of data elements together defining the identifier of an agent or local publisher in accordance with a
     * specified scheme. Optional, but each occurrence of the &lt;PublisherRepresentative&gt; composite must carry
     * either at least one agent identifier, or an &lt;AgentName&gt;. Repeatable only if two or more identifiers are
     * sent using different schemes.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<AgentIdentifier, JonixAgentIdentifier, SupplierIdentifierTypes>
        agentIdentifiers() {
        _initialize();
        return agentIdentifiers;
    }

    private AgentName agentName = AgentName.EMPTY;

    /**
     * <p>
     * The name of an agent or local publisher. Optional and non-repeating; required if no agent identifier is sent in
     * an occurrence of the &lt;PublisherRepresentative&gt; composite.
     * </p>
     * JONIX adds: this field is optional
     */
    public AgentName agentName() {
        _initialize();
        return agentName;
    }

    private ListOfOnixElement<TelephoneNumber, String> telephoneNumbers = ListOfOnixElement.empty();

    /**
     * <p>
     * A telephone number of an agent or local publisher. Optional and repeatable. Deprecated in this context, in favor
     * of providing contact details in the &lt;ProductContact&gt; composite.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<TelephoneNumber, String> telephoneNumbers() {
        _initialize();
        return telephoneNumbers;
    }

    private ListOfOnixElement<FaxNumber, String> faxNumbers = ListOfOnixElement.empty();

    /**
     * <p>
     * A fax number of an agent or local publisher. Optional and repeatable. Deprecated in this context, in favor of
     * providing contact details in the &lt;ProductContact&gt; composite.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<FaxNumber, String> faxNumbers() {
        _initialize();
        return faxNumbers;
    }

    private ListOfOnixElement<EmailAddress, String> emailAddresss = ListOfOnixElement.empty();

    /**
     * <p>
     * An e-mail address for an agent or local publisher. Optional and repeatable. Deprecated in this context, in favor
     * of providing contact details in the &lt;ProductContact&gt; composite.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<EmailAddress, String> emailAddresss() {
        _initialize();
        return emailAddresss;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = JPU.emptyListOfOnixDataComposite(Website.class);

    /**
     * <p>
     * An optional group of data elements which together identify and provides pointer to a website which is related to
     * the agent or local publisher identified in an occurrence of the &lt;PublisherRepresentative&gt; composite.
     * Repeatable in order to provide links to multiple websites.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }
}
