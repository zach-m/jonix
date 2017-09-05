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
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixMarketDate;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Market publishing detail composite</h1><p>A group of data elements which together give details of the publishing
 * status of a product within a specified market. Optional and non-repeating within an occurrence of the
 * &lt;ProductSupply&gt; block.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;MarketPublishingDetail&gt;</td></tr><tr><td>Short tag</td><td>&lt;marketpublishingdetail&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr></table>
 */
public class MarketPublishingDetail implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "MarketPublishingDetail";
    public static final String shortname = "marketpublishingdetail";

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
    public static final MarketPublishingDetail EMPTY = new MarketPublishingDetail();

    public MarketPublishingDetail() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public MarketPublishingDetail(org.w3c.dom.Element element) {
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
                case PublisherRepresentative.refname:
                case PublisherRepresentative.shortname:
                    publisherRepresentatives = JPU.addToList(publisherRepresentatives, new PublisherRepresentative(e));
                    break;
                case ProductContact.refname:
                case ProductContact.shortname:
                    productContacts = JPU.addToList(productContacts, new ProductContact(e));
                    break;
                case MarketPublishingStatus.refname:
                case MarketPublishingStatus.shortname:
                    marketPublishingStatus = new MarketPublishingStatus(e);
                    break;
                case MarketPublishingStatusNote.refname:
                case MarketPublishingStatusNote.shortname:
                    marketPublishingStatusNotes =
                        JPU.addToList(marketPublishingStatusNotes, new MarketPublishingStatusNote(e));
                    break;
                case MarketDate.refname:
                case MarketDate.shortname:
                    marketDates = JPU.addToList(marketDates, new MarketDate(e));
                    break;
                case PromotionCampaign.refname:
                case PromotionCampaign.shortname:
                    promotionCampaigns = JPU.addToList(promotionCampaigns, new PromotionCampaign(e));
                    break;
                case PromotionContact.refname:
                case PromotionContact.shortname:
                    promotionContact = new PromotionContact(e);
                    break;
                case InitialPrintRun.refname:
                case InitialPrintRun.shortname:
                    initialPrintRuns = JPU.addToList(initialPrintRuns, new InitialPrintRun(e));
                    break;
                case ReprintDetail.refname:
                case ReprintDetail.shortname:
                    reprintDetails = JPU.addToList(reprintDetails, new ReprintDetail(e));
                    break;
                case CopiesSold.refname:
                case CopiesSold.shortname:
                    copiesSolds = JPU.addToList(copiesSolds, new CopiesSold(e));
                    break;
                case BookClubAdoption.refname:
                case BookClubAdoption.shortname:
                    bookClubAdoptions = JPU.addToList(bookClubAdoptions, new BookClubAdoption(e));
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

    private List<PublisherRepresentative> publisherRepresentatives = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<PublisherRepresentative> publisherRepresentatives() {
        _initialize();
        return publisherRepresentatives;
    }

    private List<ProductContact> productContacts = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<ProductContact> productContacts() {
        _initialize();
        return productContacts;
    }

    private MarketPublishingStatus marketPublishingStatus = MarketPublishingStatus.EMPTY;

    /**
     * (this field is required)
     */
    public MarketPublishingStatus marketPublishingStatus() {
        _initialize();
        return marketPublishingStatus;
    }

    private ListOfOnixElement<MarketPublishingStatusNote, String> marketPublishingStatusNotes =
        ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<MarketPublishingStatusNote, String> marketPublishingStatusNotes() {
        _initialize();
        return marketPublishingStatusNotes;
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

    private ListOfOnixElement<PromotionCampaign, String> promotionCampaigns = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<PromotionCampaign, String> promotionCampaigns() {
        _initialize();
        return promotionCampaigns;
    }

    private PromotionContact promotionContact = PromotionContact.EMPTY;

    /**
     * (this field is optional)
     */
    public PromotionContact promotionContact() {
        _initialize();
        return promotionContact;
    }

    private ListOfOnixElement<InitialPrintRun, String> initialPrintRuns = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<InitialPrintRun, String> initialPrintRuns() {
        _initialize();
        return initialPrintRuns;
    }

    private ListOfOnixElement<ReprintDetail, String> reprintDetails = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ReprintDetail, String> reprintDetails() {
        _initialize();
        return reprintDetails;
    }

    private ListOfOnixElement<CopiesSold, String> copiesSolds = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<CopiesSold, String> copiesSolds() {
        _initialize();
        return copiesSolds;
    }

    private ListOfOnixElement<BookClubAdoption, String> bookClubAdoptions = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<BookClubAdoption, String> bookClubAdoptions() {
        _initialize();
        return bookClubAdoptions;
    }
}
