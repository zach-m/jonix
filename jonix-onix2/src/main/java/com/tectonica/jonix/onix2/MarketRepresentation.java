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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.PublishingDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixAgentIdentifier;
import com.tectonica.jonix.common.struct.JonixMarketDate;
import com.tectonica.jonix.common.struct.JonixWebsite;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Market representation composite</h1>
 * <p>
 * A group of data elements which together specify a territorial market and the identity of a sales agent or local
 * publisher responsible for marketing the product therein. Optional and repeatable.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;MarketRepresentation&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;marketrepresentation&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link MarketRepresentation}</li>
 * </ul>
 *
 * @since Onix-2.12
 */
public class MarketRepresentation implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "MarketRepresentation";
    public static final String shortname = "marketrepresentation";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
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
    public static final MarketRepresentation EMPTY = new MarketRepresentation();

    public MarketRepresentation() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public MarketRepresentation(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
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
                case MarketTerritory.refname:
                case MarketTerritory.shortname:
                    marketTerritory = new MarketTerritory(e);
                    break;
                case AgentIdentifier.refname:
                case AgentIdentifier.shortname:
                    agentIdentifiers = JPU.addToList(agentIdentifiers, new AgentIdentifier(e));
                    break;
                case AgentName.refname:
                case AgentName.shortname:
                    agentName = new AgentName(e);
                    break;
                case AgentRole.refname:
                case AgentRole.shortname:
                    agentRole = new AgentRole(e);
                    break;
                case MarketCountry.refname:
                case MarketCountry.shortname:
                    marketCountry = new MarketCountry(e);
                    break;
                case MarketCountryExcluded.refname:
                case MarketCountryExcluded.shortname:
                    marketCountryExcluded = new MarketCountryExcluded(e);
                    break;
                case MarketRestrictionDetail.refname:
                case MarketRestrictionDetail.shortname:
                    marketRestrictionDetail = new MarketRestrictionDetail(e);
                    break;
                case MarketPublishingStatus.refname:
                case MarketPublishingStatus.shortname:
                    marketPublishingStatus = new MarketPublishingStatus(e);
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
                case MarketDate.refname:
                case MarketDate.shortname:
                    marketDates = JPU.addToList(marketDates, new MarketDate(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;MarketRepresentation&gt; or &lt;marketrepresentation&gt;) is explicitly provided in
     *         the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<MarketRepresentation> action) {
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

    private MarketTerritory marketTerritory = MarketTerritory.EMPTY;

    /**
     * <p>
     * One or more ONIX codes identifying a territory which is not a country, but which is precisely defined in
     * geographical terms, <em>eg</em> World, Northern Ireland, Australian Capital Territory. Successive codes are
     * separated by spaces. Thus the element can carry an unlimited number of territory codes. Optional, but each
     * occurrence of the &lt;MarketRepresentation&gt; composite must carry either an occurrence of &lt;MarketCountry&gt;
     * or an occurrence of &lt;MarketTerritory&gt;, to specify the market concerned. Non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public MarketTerritory marketTerritory() {
        _initialize();
        return marketTerritory;
    }

    private ListOfOnixDataCompositeWithKey<AgentIdentifier, JonixAgentIdentifier,
        SupplierIdentifierTypes> agentIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(AgentIdentifier.class);

    /**
     * <p>
     * A group of data elements together defining the identifier of an agent or local publisher in accordance with a
     * specified scheme. Optional, but each occurrence of the &lt;MarketRepresentation&gt; composite must carry either
     * at least one agent identifier, or an &lt;AgentName&gt;. Repeatable only if two or more identifiers are sent using
     * different schemes.
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
     * an occurrence of the &lt;MarketRepresentation&gt; composite.
     * </p>
     * JONIX adds: this field is optional
     */
    public AgentName agentName() {
        _initialize();
        return agentName;
    }

    private AgentRole agentRole = AgentRole.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the role of an agent in relation to the product in the specified market, <em>eg</em>
     * Exclusive sales agent, Local publisher, <em>etc</em>. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public AgentRole agentRole() {
        _initialize();
        return agentRole;
    }

    private MarketCountry marketCountry = MarketCountry.EMPTY;

    /**
     * <p>
     * One or more ISO standard codes identifying a country in which the agent or local publisher markets the product.
     * Successive codes are separated by spaces. Thus, a single occurrence of the element can carry an unlimited number
     * of country codes. Optional, but each occurrence of the &lt;MarketRepresentation&gt; composite must carry either
     * an occurrence of &lt;MarketCountry&gt; or an occurrence of &lt;MarketTerritory&gt;, to specify the market
     * concerned. Non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public MarketCountry marketCountry() {
        _initialize();
        return marketCountry;
    }

    private MarketCountryExcluded marketCountryExcluded = MarketCountryExcluded.EMPTY;

    /**
     * <p>
     * One or more ISO standard codes identifying a country which is excluded from a territory specified in
     * &lt;MarketTerritory&gt;. Successive codes are separated by spaces. Thus, a single occurrence of the element can
     * carry an unlimited number of country codes. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public MarketCountryExcluded marketCountryExcluded() {
        _initialize();
        return marketCountryExcluded;
    }

    private MarketRestrictionDetail marketRestrictionDetail = MarketRestrictionDetail.EMPTY;

    /**
     * <p>
     * A free text field describing a non-geographical restriction of the market covered by a sales agent or local
     * publisher. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public MarketRestrictionDetail marketRestrictionDetail() {
        _initialize();
        return marketRestrictionDetail;
    }

    private MarketPublishingStatus marketPublishingStatus = MarketPublishingStatus.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the status of a published product in the market defined in an occurrence of the
     * &lt;MarketRepresentation&gt; composite. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public MarketPublishingStatus marketPublishingStatus() {
        _initialize();
        return marketPublishingStatus;
    }

    private ListOfOnixElement<TelephoneNumber, String> telephoneNumbers = ListOfOnixElement.empty();

    /**
     * <p>
     * A telephone number of an agent or local publisher. Optional and repeatable.
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
     * A fax number of an agent or local publisher. Optional and repeatable.
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
     * An email address for an agent or local publisher. Optional and repeatable.
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
     * An optional and repeatable group of data elements which together identify and provide pointers to a website which
     * is related to the agent or local publisher identified in an occurrence of the &lt;MarketRepresentation&gt;
     * composite.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }

    private ListOfOnixDataCompositeWithKey<MarketDate, JonixMarketDate, PublishingDateRoles> marketDates =
        JPU.emptyListOfOnixDataCompositeWithKey(MarketDate.class);

    /**
     * <p>
     * A repeatable group of data elements which together specify a date associated with the publishing status of the
     * product in the market identified in an occurrence of the &lt;MarketRepresentation&gt; composite, <em>eg</em>
     * local publication date.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<MarketDate, JonixMarketDate, PublishingDateRoles> marketDates() {
        _initialize();
        return marketDates;
    }
}
