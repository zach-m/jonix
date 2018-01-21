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
import com.tectonica.jonix.struct.JonixPublishingDate;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>null</h1><h4 class="nobreak">Publishing detail composite</h4><p>The publishing detail block covers data element
 * Groups P.19 to P.21, carrying information on the publisher(s), ‘global’ publishing status, and rights attaching to a
 * product. The block as a whole is non-repeating. It is mandatory in any &lt;Product&gt; record unless the
 * &lt;NotificationType&gt; in Group&nbsp;P.1 indicates that the record is an update notice which carries only those
 * blocks in which changes have occurred.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;PublishingDetail&gt;</td></tr><tr><td>Short tag</td><td>&lt;publishingdetail&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr></table>
 */
public class PublishingDetail implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PublishingDetail";
    public static final String shortname = "publishingdetail";

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
    public static final PublishingDetail EMPTY = new PublishingDetail();

    public PublishingDetail() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PublishingDetail(org.w3c.dom.Element element) {
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
                case Imprint.refname:
                case Imprint.shortname:
                    imprints = JPU.addToList(imprints, new Imprint(e));
                    break;
                case Publisher.refname:
                case Publisher.shortname:
                    publishers = JPU.addToList(publishers, new Publisher(e));
                    break;
                case CityOfPublication.refname:
                case CityOfPublication.shortname:
                    cityOfPublications = JPU.addToList(cityOfPublications, new CityOfPublication(e));
                    break;
                case CountryOfPublication.refname:
                case CountryOfPublication.shortname:
                    countryOfPublication = new CountryOfPublication(e);
                    break;
                case ProductContact.refname:
                case ProductContact.shortname:
                    productContacts = JPU.addToList(productContacts, new ProductContact(e));
                    break;
                case PublishingStatus.refname:
                case PublishingStatus.shortname:
                    publishingStatus = new PublishingStatus(e);
                    break;
                case PublishingStatusNote.refname:
                case PublishingStatusNote.shortname:
                    publishingStatusNotes = JPU.addToList(publishingStatusNotes, new PublishingStatusNote(e));
                    break;
                case PublishingDate.refname:
                case PublishingDate.shortname:
                    publishingDates = JPU.addToList(publishingDates, new PublishingDate(e));
                    break;
                case LatestReprintNumber.refname:
                case LatestReprintNumber.shortname:
                    latestReprintNumber = new LatestReprintNumber(e);
                    break;
                case CopyrightStatement.refname:
                case CopyrightStatement.shortname:
                    copyrightStatements = JPU.addToList(copyrightStatements, new CopyrightStatement(e));
                    break;
                case SalesRights.refname:
                case SalesRights.shortname:
                    salesRightss = JPU.addToList(salesRightss, new SalesRights(e));
                    break;
                case ROWSalesRightsType.refname:
                case ROWSalesRightsType.shortname:
                    rowSalesRightsType = new ROWSalesRightsType(e);
                    break;
                case SalesRestriction.refname:
                case SalesRestriction.shortname:
                    salesRestrictions = JPU.addToList(salesRestrictions, new SalesRestriction(e));
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

    private List<Imprint> imprints = Collections.emptyList();

    /**
     * (this list is required to contain at least one item)
     */
    public List<Imprint> imprints() {
        _initialize();
        return imprints;
    }

    private List<Publisher> publishers = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Publisher> publishers() {
        _initialize();
        return publishers;
    }

    private ListOfOnixElement<CityOfPublication, String> cityOfPublications = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<CityOfPublication, String> cityOfPublications() {
        _initialize();
        return cityOfPublications;
    }

    private CountryOfPublication countryOfPublication = CountryOfPublication.EMPTY;

    /**
     * (this field is optional)
     */
    public CountryOfPublication countryOfPublication() {
        _initialize();
        return countryOfPublication;
    }

    private List<ProductContact> productContacts = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<ProductContact> productContacts() {
        _initialize();
        return productContacts;
    }

    private PublishingStatus publishingStatus = PublishingStatus.EMPTY;

    /**
     * (this field is optional)
     */
    public PublishingStatus publishingStatus() {
        _initialize();
        return publishingStatus;
    }

    private ListOfOnixElement<PublishingStatusNote, String> publishingStatusNotes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<PublishingStatusNote, String> publishingStatusNotes() {
        _initialize();
        return publishingStatusNotes;
    }

    private ListOfOnixDataCompositeWithKey<PublishingDate, JonixPublishingDate, PublishingDateRoles> publishingDates =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<PublishingDate, JonixPublishingDate, PublishingDateRoles> publishingDates() {
        _initialize();
        return publishingDates;
    }

    private LatestReprintNumber latestReprintNumber = LatestReprintNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public LatestReprintNumber latestReprintNumber() {
        _initialize();
        return latestReprintNumber;
    }

    private List<CopyrightStatement> copyrightStatements = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<CopyrightStatement> copyrightStatements() {
        _initialize();
        return copyrightStatements;
    }

    private List<SalesRights> salesRightss = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<SalesRights> salesRightss() {
        _initialize();
        return salesRightss;
    }

    private ROWSalesRightsType rowSalesRightsType = ROWSalesRightsType.EMPTY;

    /**
     * (this field is optional)
     */
    public ROWSalesRightsType rowSalesRightsType() {
        _initialize();
        return rowSalesRightsType;
    }

    private List<SalesRestriction> salesRestrictions = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<SalesRestriction> salesRestrictions() {
        _initialize();
        return salesRestrictions;
    }
}
