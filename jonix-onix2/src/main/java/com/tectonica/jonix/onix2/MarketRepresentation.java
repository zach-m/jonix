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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixAgentIdentifier;
import com.tectonica.jonix.struct.JonixMarketDate;
import com.tectonica.jonix.struct.JonixWebsite;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Market representation composite</h1><p>A group of data elements which together specify a territorial market and
 * the identity of a sales agent or local publisher responsible for marketing the product therein. Optional and
 * repeatable.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;MarketRepresentation&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;marketrepresentation&gt;</td></tr></table>
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

    public LanguageCodes language;

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
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
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
                case AgentRole.refname:
                case AgentRole.shortname:
                    agentRole = new AgentRole(e);
                    break;
                case MarketCountry.refname:
                case MarketCountry.shortname:
                    marketCountry = new MarketCountry(e);
                    break;
                case MarketTerritory.refname:
                case MarketTerritory.shortname:
                    marketTerritory = new MarketTerritory(e);
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
                case MarketDate.refname:
                case MarketDate.shortname:
                    marketDates = JPU.addToList(marketDates, new MarketDate(e));
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

    private ListOfOnixDataCompositeWithKey<AgentIdentifier, JonixAgentIdentifier, SupplierIdentifierTypes>
        agentIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<AgentIdentifier, JonixAgentIdentifier, SupplierIdentifierTypes> agentIdentifiers() {
        _initialize();
        return agentIdentifiers;
    }

    private AgentName agentName = AgentName.EMPTY;

    /**
     * (this field is optional)
     */
    public AgentName agentName() {
        _initialize();
        return agentName;
    }

    private ListOfOnixElement<TelephoneNumber, String> telephoneNumbers = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<TelephoneNumber, String> telephoneNumbers() {
        _initialize();
        return telephoneNumbers;
    }

    private ListOfOnixElement<FaxNumber, String> faxNumbers = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<FaxNumber, String> faxNumbers() {
        _initialize();
        return faxNumbers;
    }

    private ListOfOnixElement<EmailAddress, String> emailAddresss = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<EmailAddress, String> emailAddresss() {
        _initialize();
        return emailAddresss;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }

    private AgentRole agentRole = AgentRole.EMPTY;

    /**
     * (this field is optional)
     */
    public AgentRole agentRole() {
        _initialize();
        return agentRole;
    }

    private MarketCountry marketCountry = MarketCountry.EMPTY;

    /**
     * (this field is optional)
     */
    public MarketCountry marketCountry() {
        _initialize();
        return marketCountry;
    }

    private MarketTerritory marketTerritory = MarketTerritory.EMPTY;

    /**
     * (this field is required)
     */
    public MarketTerritory marketTerritory() {
        _initialize();
        return marketTerritory;
    }

    private MarketCountryExcluded marketCountryExcluded = MarketCountryExcluded.EMPTY;

    /**
     * (this field is optional)
     */
    public MarketCountryExcluded marketCountryExcluded() {
        _initialize();
        return marketCountryExcluded;
    }

    private MarketRestrictionDetail marketRestrictionDetail = MarketRestrictionDetail.EMPTY;

    /**
     * (this field is optional)
     */
    public MarketRestrictionDetail marketRestrictionDetail() {
        _initialize();
        return marketRestrictionDetail;
    }

    private MarketPublishingStatus marketPublishingStatus = MarketPublishingStatus.EMPTY;

    /**
     * (this field is optional)
     */
    public MarketPublishingStatus marketPublishingStatus() {
        _initialize();
        return marketPublishingStatus;
    }

    private ListOfOnixDataCompositeWithKey<MarketDate, JonixMarketDate, PublishingDateRoles> marketDates =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<MarketDate, JonixMarketDate, PublishingDateRoles> marketDates() {
        _initialize();
        return marketDates;
    }
}
