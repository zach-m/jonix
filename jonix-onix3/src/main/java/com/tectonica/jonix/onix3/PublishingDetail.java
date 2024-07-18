/*
 * Copyright (C) 2012-2024 Zach Melamed
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
import com.tectonica.jonix.common.struct.JonixPublishingDate;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Publishing detail composite</h1>
 * <p>
 * The publishing detail block covers data Groups P.19 to P.21, carrying information on the publisher(s), ‘global’
 * publishing status, and rights attaching to a product. The block as a whole is non-repeating. It is mandatory in any
 * &lt;Product&gt; record unless the &lt;NotificationType&gt; in Group&nbsp;P.1 indicates that the record is an update
 * notice which carries only those blocks in which changes have occurred.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PublishingDetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;publishingdetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;PublishingDetail&gt; from the schema author:
 *
 * Block 4, container for information about describing branding, publishing and rights attached to the product &#9679;
 * Added &lt;ProductContact&gt; at revision 3.0.1 &#9679; Modified cardinality of &lt;PublishingStatusNote&gt; at
 * revision 3.0.1 &#9679; Added &lt;ROWSalesRightsType&gt; at revision 3.0 (2010)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PublishingDetail}</li>
 * </ul>
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
                case Imprint.refname:
                case Imprint.shortname:
                    imprints = JPU.addToList(imprints, new Imprint(e));
                    break;
                case CountryOfPublication.refname:
                case CountryOfPublication.shortname:
                    countryOfPublication = new CountryOfPublication(e);
                    break;
                case PublishingStatus.refname:
                case PublishingStatus.shortname:
                    publishingStatus = new PublishingStatus(e);
                    break;
                case LatestReprintNumber.refname:
                case LatestReprintNumber.shortname:
                    latestReprintNumber = new LatestReprintNumber(e);
                    break;
                case ROWSalesRightsType.refname:
                case ROWSalesRightsType.shortname:
                    rowSalesRightsType = new ROWSalesRightsType(e);
                    break;
                case Publisher.refname:
                case Publisher.shortname:
                    publishers = JPU.addToList(publishers, new Publisher(e));
                    break;
                case CityOfPublication.refname:
                case CityOfPublication.shortname:
                    cityOfPublications = JPU.addToList(cityOfPublications, new CityOfPublication(e));
                    break;
                case ProductContact.refname:
                case ProductContact.shortname:
                    productContacts = JPU.addToList(productContacts, new ProductContact(e));
                    break;
                case PublishingStatusNote.refname:
                case PublishingStatusNote.shortname:
                    publishingStatusNotes = JPU.addToList(publishingStatusNotes, new PublishingStatusNote(e));
                    break;
                case PublishingDate.refname:
                case PublishingDate.shortname:
                    publishingDates = JPU.addToList(publishingDates, new PublishingDate(e));
                    break;
                case CopyrightStatement.refname:
                case CopyrightStatement.shortname:
                    copyrightStatements = JPU.addToList(copyrightStatements, new CopyrightStatement(e));
                    break;
                case CopyrightStatementText.refname:
                case CopyrightStatementText.shortname:
                    copyrightStatementTexts = JPU.addToList(copyrightStatementTexts, new CopyrightStatementText(e));
                    break;
                case SalesRights.refname:
                case SalesRights.shortname:
                    salesRightss = JPU.addToList(salesRightss, new SalesRights(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PublishingDetail&gt; or &lt;publishingdetail&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PublishingDetail> action) {
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

    private ListOfOnixComposite<Imprint> imprints = JPU.emptyListOfOnixComposite(Imprint.class);

    /**
     * <p>
     * An optional group of data elements which together identify an imprint or brand under which the product is
     * marketed. The composite must carry either a name identifier or a name or both, and is repeatable to specify
     * multiple imprints or brands.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixComposite<Imprint> imprints() {
        _initialize();
        return imprints;
    }

    private CountryOfPublication countryOfPublication = CountryOfPublication.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the country where the product is published (<i>ie</i> where the publisher is based).
     * Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public CountryOfPublication countryOfPublication() {
        _initialize();
        return countryOfPublication;
    }

    private PublishingStatus publishingStatus = PublishingStatus.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the status of a published product. Optional and non-repeating, but required if
     * publishing status is <em>not</em> identified at market level in &lt;MarketPublishingDetail&gt; (P.25).
     * </p>
     * <p>
     * Where the element is sent by a sender who is not the publisher, based on information that has been previously
     * supplied by the publisher, it is strongly recommended that it should carry a <i>datestamp</i> attribute to
     * indicate its likely reliability. See <a href="#message_attributes">Section 1</a> for further details of the
     * <i>datestamp</i> attribute.
     * </p>
     * JONIX adds: this field is optional
     */
    public PublishingStatus publishingStatus() {
        _initialize();
        return publishingStatus;
    }

    private LatestReprintNumber latestReprintNumber = LatestReprintNumber.EMPTY;

    /**
     * <p>
     * The number of the most recent reprint (or current ‘impression number’) of the product. Optional and
     * non-repeating. This element is used only in certain countries where there is a legal requirement to record
     * reprints.
     * </p>
     * JONIX adds: this field is optional
     */
    public LatestReprintNumber latestReprintNumber() {
        _initialize();
        return latestReprintNumber;
    }

    private ROWSalesRightsType rowSalesRightsType = ROWSalesRightsType.EMPTY;

    /**
     * <p>
     * An ONIX code describing the sales rights applicable in territories not specifically associated with a sales right
     * within an occurrence of the &lt;SalesRights&gt; composite. Must be preceded by at least one &lt;SalesRights&gt;
     * composite. Optional, but required in all cases where no sales rights type is associated with the region ‘WORLD’,
     * and in all cases where a sales rights type is associated with ‘WORLD’ but with exclusions that are not themselves
     * associated with a sales rights type. Not repeatable. Note the value ‘00’ should be used to indicate where sales
     * rights are genuinely unknown, or are unstated for any reason – in this case, data recipients must not assume
     * anything about the rights that are applicable.
     * </p>
     * JONIX adds: this field is optional
     */
    public ROWSalesRightsType rowSalesRightsType() {
        _initialize();
        return rowSalesRightsType;
    }

    private ListOfOnixComposite<Publisher> publishers = JPU.emptyListOfOnixComposite(Publisher.class);

    /**
     * <p>
     * An optional group of data elements which together identify an entity which is associated with the publishing of a
     * product. The composite allows additional publishing roles to be introduced without adding new fields. Each
     * occurrence of the composite must carry a publishing role code and either a name identifier or a name or both, and
     * the composite is repeatable in order to identify multiple entities.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<Publisher> publishers() {
        _initialize();
        return publishers;
    }

    private ListOfOnixElement<CityOfPublication, String> cityOfPublications = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a city or town associated with the imprint or publisher. Optional, and repeatable if parallel names
     * for a single location appear on the title page in multiple languages, or if the imprint carries two or more
     * cities of publication.
     * </p>
     * <p>
     * Where necessary to avoid ambiguity, a state, province or region may be included – for example
     * ‘Springfield,&nbsp;IL’.
     * </p>
     * <p>
     * A place of publication is normally given in the form in which it appears on the title page. If the place name
     * appears in more than one language, &lt;CityOfPublication&gt; may be repeated. The <i>language</i> attribute is
     * optional with a single instance of &lt;CityOfPublication&gt;, but must be included in each instance if
     * &lt;CityOfPublication&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<CityOfPublication, String> cityOfPublications() {
        _initialize();
        return cityOfPublications;
    }

    private ListOfOnixComposite<ProductContact> productContacts = JPU.emptyListOfOnixComposite(ProductContact.class);

    /**
     * <p>
     * An optional group of data elements which together specify an organization (which may or may not be the publisher)
     * responsible for dealing with enquiries related to the product. Repeatable in order to specify multiple
     * responsible organizations.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<ProductContact> productContacts() {
        _initialize();
        return productContacts;
    }

    private ListOfOnixElement<PublishingStatusNote, String> publishingStatusNotes = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text that describes the status of a published product, when the code in &lt;PublishingStatus&gt; is
     * insufficient. Optional, but when used, must be accompanied by the &lt;PublishingStatus&gt; element. Repeatable if
     * parallel notes are provide in multiple languages. The <i>language</i> attribute is optional for a single instance
     * of &lt;PublishingStatusNote&gt;, but must be included in each instance if &lt;PublishingStatusNote&gt; is
     * repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<PublishingStatusNote, String> publishingStatusNotes() {
        _initialize();
        return publishingStatusNotes;
    }

    private ListOfOnixDataCompositeWithKey<PublishingDate, JonixPublishingDate, PublishingDateRoles> publishingDates =
        JPU.emptyListOfOnixDataCompositeWithKey(PublishingDate.class);

    /**
     * <p>
     * A group of data elements which together specify a date associated with the publishing of the product. Optional,
     * but where known, at least a date of publication <em>must</em> be specified <em>either</em> here (as a ‘global’
     * pub date) <em>or</em> in &lt;MarketPublishingDetail&gt; (P.25). Other dates related to the publishing of a
     * product can be sent in further repeats of the composite.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<PublishingDate, JonixPublishingDate, PublishingDateRoles> publishingDates() {
        _initialize();
        return publishingDates;
    }

    private ListOfOnixComposite<CopyrightStatement> copyrightStatements =
        JPU.emptyListOfOnixComposite(CopyrightStatement.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together represent a summary copyright or neighboring
     * right statement for the product. At least one &lt;CopyrightYear&gt; or one instance of the &lt;CopyrightOwner&gt;
     * composite must be sent within an instance of the composite, but it is recommended that all elements in the
     * composite are explicitly populated. The Copyright statement may be repeated to provide a full structured rights
     * statement listing year(s) and rights holder(s).
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<CopyrightStatement> copyrightStatements() {
        _initialize();
        return copyrightStatements;
    }

    private ListOfOnixElement<CopyrightStatementText, String> copyrightStatementTexts = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text showing how the copyright should be described, when a standard concatenation of individual copyright
     * statements would not give a satisfactory presentation. Optional but must only be used if one or more instances of
     * &lt;CopyrightStatement&gt; are present, and repeatable if parallel text is provided in multiple languages. The
     * <i>language</i> attribute is optional for a single instance of &lt;CopyrightStatementText&gt;, but must be
     * included in each instance if &lt;CopyrightStatementText&gt; is repeated. When the &lt;CopyrightStatementText&gt;
     * field is sent, the receiver should use it to replace all detail sent in the &lt;CopyrightStatement&gt; composite
     * <em>for display purposes only</em>. It does not replace the &lt;CopyrightStatement&gt; element. The individual
     * name detail <em>must</em> also be sent in one or more &lt;CopyrightStatement&gt; composites for indexing and
     * retrieval purposes.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<CopyrightStatementText, String> copyrightStatementTexts() {
        _initialize();
        return copyrightStatementTexts;
    }

    private ListOfOnixComposite<SalesRights> salesRightss = JPU.emptyListOfOnixComposite(SalesRights.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together identify territorial sales rights which a
     * publisher chooses to exercise in a product. When specifying a territory in which the product is not for sale, the
     * publisher and product ID for an edition which is available in the specified territory can optionally be included.
     * (In releases prior to 3.0, this functionality was provided in a &lt;NotForSale&gt; composite, which is now
     * redundant and has been deleted.) See examples at the end of the sales rights composite.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<SalesRights> salesRightss() {
        _initialize();
        return salesRightss;
    }
}
