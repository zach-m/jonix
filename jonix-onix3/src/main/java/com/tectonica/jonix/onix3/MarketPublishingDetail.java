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
import com.tectonica.jonix.common.ListOfOnixComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.PublishingDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixMarketDate;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Market publishing detail composite</h1>
 * <p>
 * A group of data elements which together give details of the publishing status of a product within a specified market.
 * Optional and non-repeating within an occurrence of the &lt;ProductSupply&gt; block.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;MarketPublishingDetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;marketpublishingdetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;MarketPublishingDetail&gt; from the schema author:
 *
 * Details of the market-specific publishing status, associated dates and publisher representation for the product
 * within a 'market', particular where they differ from the relevant details in Block 4 &#9679; Modified cardinality of
 * &lt;PromotionCampaign&gt;, &lt;InitialPrintRun&gt;, &lt;CopiesSold&gt;, &lt;BookClubAdoption&gt; at revision 3.0.2
 * &#9679; Modified cardinality of &lt;MarketPublishingStatusNote&gt; at revision 3.0.1 &#9679; Modified cardinality of
 * &lt;MarketDate&gt; at revision 3.0 (2010)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ProductSupply}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link MarketPublishingDetail}</li>
 * </ul>
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
                case MarketPublishingStatus.refname:
                case MarketPublishingStatus.shortname:
                    marketPublishingStatus = new MarketPublishingStatus(e);
                    break;
                case PromotionContact.refname:
                case PromotionContact.shortname:
                    promotionContact = new PromotionContact(e);
                    break;
                case PublisherRepresentative.refname:
                case PublisherRepresentative.shortname:
                    publisherRepresentatives = JPU.addToList(publisherRepresentatives, new PublisherRepresentative(e));
                    break;
                case ProductContact.refname:
                case ProductContact.shortname:
                    productContacts = JPU.addToList(productContacts, new ProductContact(e));
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

    /**
     * @return whether this tag (&lt;MarketPublishingDetail&gt; or &lt;marketpublishingdetail&gt;) is explicitly
     *         provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<MarketPublishingDetail> action) {
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

    private MarketPublishingStatus marketPublishingStatus = MarketPublishingStatus.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the status of a published product in a specified market. Mandatory in each
     * occurrence of the &lt;MarketPublishingDetail&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public MarketPublishingStatus marketPublishingStatus() {
        _initialize();
        return marketPublishingStatus;
    }

    private PromotionContact promotionContact = PromotionContact.EMPTY;

    /**
     * <p>
     * Free text giving the name, department, phone number, e-mail address etc for a promotional contact person for the
     * product. Optional and non-repeating. Deprecated, in favor of providing this information via the
     * &lt;ProductContact&gt; composite.
     * </p>
     * JONIX adds: this field is optional
     */
    public PromotionContact promotionContact() {
        _initialize();
        return promotionContact;
    }

    private ListOfOnixComposite<PublisherRepresentative> publisherRepresentatives =
        JPU.emptyListOfOnixComposite(PublisherRepresentative.class);

    /**
     * <p>
     * A repeatable group of data elements which together identify a publisher representative in a specified market.
     * Optional, and repeated only if the publisher has two or more representatives.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<PublisherRepresentative> publisherRepresentatives() {
        _initialize();
        return publisherRepresentatives;
    }

    private ListOfOnixComposite<ProductContact> productContacts = JPU.emptyListOfOnixComposite(ProductContact.class);

    /**
     * <p>
     * A group of data elements which together specify an organization (which may or may not be the publisher’s
     * representative) responsible for dealing with enquiries related to the product in the market. Optional, and
     * repeatable in order to specify multiple contacts.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<ProductContact> productContacts() {
        _initialize();
        return productContacts;
    }

    private ListOfOnixElement<MarketPublishingStatusNote, String> marketPublishingStatusNotes =
        ListOfOnixElement.empty();

    /**
     * <p>
     * Free text that describes the status of a product in a specified market, when the code in
     * &lt;MarketPublishingStatus&gt; is insufficient. Optional, but when used, must be accompanied by the
     * &lt;MarketPublishingStatus&gt; element. Repeatable if parallel text is provided in multiple languages. The
     * <i>language</i> attribute is optional for a single instance of &lt;MarketPublishingStatusNote&gt;, but must be
     * included in each instance if &lt;MarketPublishingStatusNote&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<MarketPublishingStatusNote, String> marketPublishingStatusNotes() {
        _initialize();
        return marketPublishingStatusNotes;
    }

    private ListOfOnixDataCompositeWithKey<MarketDate, JonixMarketDate, PublishingDateRoles> marketDates =
        JPU.emptyListOfOnixDataCompositeWithKey(MarketDate.class);

    /**
     * <p>
     * A group of data elements which together specify a date associated with the publishing status of the product in a
     * specified market, <i>eg</i>&nbsp;‘local publication date’. Optional, but if known, a date of publication
     * <em>must</em> be specified either here as a ‘local pubdate’ or in P.20. Other dates relating to the publication
     * of the product in the specific market may be sent in further repeats of the composite.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<MarketDate, JonixMarketDate, PublishingDateRoles> marketDates() {
        _initialize();
        return marketDates;
    }

    private ListOfOnixElement<PromotionCampaign, String> promotionCampaigns = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text describing the promotion and adverting campaign for the product. Optional, and repeatable if parallel
     * text is provided in multiple languages. The <i>language</i> attribute is optional for a single instance of
     * &lt;PromotionCampaign&gt;, but must be included in each instance if &lt;PromotionCampaign&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<PromotionCampaign, String> promotionCampaigns() {
        _initialize();
        return promotionCampaigns;
    }

    private ListOfOnixElement<InitialPrintRun, String> initialPrintRuns = ListOfOnixElement.empty();

    /**
     * <p>
     * In advance information about a new book, free text detailing the number of copies which will be printed and any
     * related aspects of the initial publishing effort. Optional, and repeatable if parallel text is provided in
     * multiple languages. The <i>language</i> attribute is optional for a single instance of &lt;InitialPrintRun&gt;,
     * but must be included in each instance if &lt;InitialPrintRun&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<InitialPrintRun, String> initialPrintRuns() {
        _initialize();
        return initialPrintRuns;
    }

    private ListOfOnixElement<ReprintDetail, String> reprintDetails = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text used to give details of the reprint history as part of the promotion of a book. Optional, and
     * repeatable if parallel text is provided in multiple languages. The <i>language</i> attribute is optional for a
     * single instance of &lt;ReprintDetail&gt;, but must be included in each instance if &lt;ReprintDetail&gt; is
     * repeated.
     * </p>
     * <p>
     * (For compatibility purposes, &lt;ReprintDetail&gt; is also repeatable – without the <i>language</i> attribute, or
     * with the same <i>language</i> attribute – to give information about successive reprintings, but this is
     * deprecated in favor of a single &lt;ReprintDetail&gt; instance [or a single instance per language] and use of the
     * XHTML &lt;dl&gt; list structure.)
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<ReprintDetail, String> reprintDetails() {
        _initialize();
        return reprintDetails;
    }

    private ListOfOnixElement<CopiesSold, String> copiesSolds = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text detailing the number of copies already sold, <i>eg</i>&nbsp;for a new paperback, the copies sold in
     * hardback. Optional, and repeatable if parallel text is provided in multiple languages. The <i>language</i>
     * attribute is optional for a single instance of &lt;CopiesSold&gt;, but must be included in each instance if
     * &lt;CopiesSold&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<CopiesSold, String> copiesSolds() {
        _initialize();
        return copiesSolds;
    }

    private ListOfOnixElement<BookClubAdoption, String> bookClubAdoptions = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text describing the adoption of the product as a book club selection. Optional, and repeatable if parallel
     * text is provided in multiple languages. The <i>language</i> attribute is optional for a single instance of
     * &lt;BookClubAdoption&gt;, but must be included in each instance if &lt;BookClubAdoption&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<BookClubAdoption, String> bookClubAdoptions() {
        _initialize();
        return bookClubAdoptions;
    }
}
