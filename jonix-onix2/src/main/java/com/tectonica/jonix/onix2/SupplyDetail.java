/*
 * Copyright (C) 2012-2020 Zach Melamed
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
import com.tectonica.jonix.common.codelist.Countrys;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.common.codelist.SupplytoRegions;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixSupplierIdentifier;
import com.tectonica.jonix.common.struct.JonixWebsite;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supplier and trade data composite</h1>
 * <p>
 * A repeatable group of data elements which together give details of a trade supply source and the product price and
 * availability from that source.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SupplyDetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;supplydetail&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SupplyDetail}</li>
 * </ul>
 */
public class SupplyDetail implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SupplyDetail";
    public static final String shortname = "supplydetail";

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
    public static final SupplyDetail EMPTY = new SupplyDetail();

    public SupplyDetail() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SupplyDetail(org.w3c.dom.Element element) {
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
                case SupplierEANLocationNumber.refname:
                case SupplierEANLocationNumber.shortname:
                    supplierEANLocationNumber = new SupplierEANLocationNumber(e);
                    break;
                case AvailabilityCode.refname:
                case AvailabilityCode.shortname:
                    availabilityCode = new AvailabilityCode(e);
                    break;
                case SupplyToCountry.refname:
                case SupplyToCountry.shortname:
                    supplyToCountrys = JPU.addToList(supplyToCountrys, new SupplyToCountry(e));
                    break;
                case SupplierSAN.refname:
                case SupplierSAN.shortname:
                    supplierSAN = new SupplierSAN(e);
                    break;
                case SupplierName.refname:
                case SupplierName.shortname:
                    supplierName = new SupplierName(e);
                    break;
                case SupplierRole.refname:
                case SupplierRole.shortname:
                    supplierRole = new SupplierRole(e);
                    break;
                case SupplyToTerritory.refname:
                case SupplyToTerritory.shortname:
                    supplyToTerritory = new SupplyToTerritory(e);
                    break;
                case SupplyRestrictionDetail.refname:
                case SupplyRestrictionDetail.shortname:
                    supplyRestrictionDetail = new SupplyRestrictionDetail(e);
                    break;
                case ReturnsCodeType.refname:
                case ReturnsCodeType.shortname:
                    returnsCodeType = new ReturnsCodeType(e);
                    break;
                case ReturnsCode.refname:
                case ReturnsCode.shortname:
                    returnsCode = new ReturnsCode(e);
                    break;
                case LastDateForReturns.refname:
                case LastDateForReturns.shortname:
                    lastDateForReturns = new LastDateForReturns(e);
                    break;
                case ProductAvailability.refname:
                case ProductAvailability.shortname:
                    productAvailability = new ProductAvailability(e);
                    break;
                case IntermediaryAvailabilityCode.refname:
                case IntermediaryAvailabilityCode.shortname:
                    intermediaryAvailabilityCode = new IntermediaryAvailabilityCode(e);
                    break;
                case NewSupplier.refname:
                case NewSupplier.shortname:
                    newSupplier = new NewSupplier(e);
                    break;
                case DateFormat.refname:
                case DateFormat.shortname:
                    dateFormat = new DateFormat(e);
                    break;
                case ExpectedShipDate.refname:
                case ExpectedShipDate.shortname:
                    expectedShipDate = new ExpectedShipDate(e);
                    break;
                case OnSaleDate.refname:
                case OnSaleDate.shortname:
                    onSaleDate = new OnSaleDate(e);
                    break;
                case OrderTime.refname:
                case OrderTime.shortname:
                    orderTime = new OrderTime(e);
                    break;
                case PackQuantity.refname:
                case PackQuantity.shortname:
                    packQuantity = new PackQuantity(e);
                    break;
                case AudienceRestrictionFlag.refname:
                case AudienceRestrictionFlag.shortname:
                    audienceRestrictionFlag = new AudienceRestrictionFlag(e);
                    break;
                case AudienceRestrictionNote.refname:
                case AudienceRestrictionNote.shortname:
                    audienceRestrictionNote = new AudienceRestrictionNote(e);
                    break;
                case PriceAmount.refname:
                case PriceAmount.shortname:
                    priceAmount = new PriceAmount(e);
                    break;
                case UnpricedItemType.refname:
                case UnpricedItemType.shortname:
                    unpricedItemType = new UnpricedItemType(e);
                    break;
                case Reissue.refname:
                case Reissue.shortname:
                    reissue = new Reissue(e);
                    break;
                case SupplierIdentifier.refname:
                case SupplierIdentifier.shortname:
                    supplierIdentifiers = JPU.addToList(supplierIdentifiers, new SupplierIdentifier(e));
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
                case SupplyToRegion.refname:
                case SupplyToRegion.shortname:
                    supplyToRegions = JPU.addToList(supplyToRegions, new SupplyToRegion(e));
                    break;
                case SupplyToCountryExcluded.refname:
                case SupplyToCountryExcluded.shortname:
                    supplyToCountryExcludeds = JPU.addToList(supplyToCountryExcludeds, new SupplyToCountryExcluded(e));
                    break;
                case Stock.refname:
                case Stock.shortname:
                    stocks = JPU.addToList(stocks, new Stock(e));
                    break;
                case Price.refname:
                case Price.shortname:
                    prices = JPU.addToList(prices, new Price(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SupplyDetail&gt; or &lt;supplydetail&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private SupplierEANLocationNumber supplierEANLocationNumber = SupplierEANLocationNumber.EMPTY;

    /**
     * <p>
     * An EAN-13 location number identifying a supply source from which the product may be ordered by a trade customer.
     * Now also known as an “EAN-UCC Global Location Number” or GLN. Optional, but each occurrence of the
     * &lt;SupplyDetail&gt; composite must carry either at least one supplier identifier, or a &lt;SupplierName&gt;.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SupplierEANLocationNumber supplierEANLocationNumber() {
        _initialize();
        return supplierEANLocationNumber;
    }

    private AvailabilityCode availabilityCode = AvailabilityCode.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the availability of a product. Each occurrence of the &lt;SupplyDetail&gt; composite must
     * carry either &lt;AvailabilityCode&gt; or &lt;ProductAvailability&gt;, or both, but &lt;ProductAvailability&gt; is
     * now strongly preferred. Non-repeating.
     * </p>
     * <p>
     * Some code values require other accompanying data. Where the code lists state that one of the following is
     * required or may optionally be sent, use the element indicated below:
     * </p>
     * <ul>
     * <li>Expected availability date – use &lt;ExpectedShipDate&gt;</li>
     * <li>Remainder date – &lt;ExpectedShipDate&gt; is again used</li>
     * <li>Estimated time to supply – &lt;OrderTime&gt;</li>
     * <li>Identifier of alternative or successor product – &lt;RelatedProduct&gt;, Group&nbsp;PR.23</li>
     * <li>New supplier – &lt;NewSupplier&gt;</li>
     * </ul>
     * Jonix-Comment: this field is required
     */
    public AvailabilityCode availabilityCode() {
        _initialize();
        return availabilityCode;
    }

    private ListOfOnixElement<SupplyToCountry, java.util.Set<Countrys>> supplyToCountrys = ListOfOnixElement.empty();

    /**
     * <p>
     * One or more ISO standard codes identifying a country for which the supplier holds distribution rights for the
     * product. Successive codes may be separated by spaces. Thus, a single occurrence of the element can carry an
     * unlimited number of country codes. For upwards compatibility, the element remains repeatable, so that multiple
     * countries can be listed as multiple occurrences of the whole element. Optional and repeatable.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<SupplyToCountry, java.util.Set<Countrys>> supplyToCountrys() {
        _initialize();
        return supplyToCountrys;
    }

    private SupplierSAN supplierSAN = SupplierSAN.EMPTY;

    /**
     * <p>
     * The book trade Standard Address Number that identifies the supplier with whom trade orders for the product should
     * be placed. Used in the US and UK. Optional, but each occurrence of the &lt;SupplyDetail&gt; composite must carry
     * either at least one supplier identifier, or a &lt;SupplierName&gt;.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SupplierSAN supplierSAN() {
        _initialize();
        return supplierSAN;
    }

    private SupplierName supplierName = SupplierName.EMPTY;

    /**
     * <p>
     * The name of a supply source from which the product may be ordered by a trade customer. Optional and
     * non-repeating; required if no supplier identifier is sent.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SupplierName supplierName() {
        _initialize();
        return supplierName;
    }

    private SupplierRole supplierRole = SupplierRole.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the role of a supplier in relation to the product, <em>eg</em> Publisher, Publisher’s
     * exclusive distributor, <em>etc</em>. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SupplierRole supplierRole() {
        _initialize();
        return supplierRole;
    }

    private SupplyToTerritory supplyToTerritory = SupplyToTerritory.EMPTY;

    /**
     * <p>
     * One or more ONIX codes identifying a territory which is not a country, but which is precisely defined in
     * geographical terms, <em>eg</em> World, Northern Ireland, Australian Capital Territory. Successive codes may be
     * separated by spaces. Thus the element can carry an unlimited number of territory codes, for territories for which
     * the supplier has distribution rights. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SupplyToTerritory supplyToTerritory() {
        _initialize();
        return supplyToTerritory;
    }

    private SupplyRestrictionDetail supplyRestrictionDetail = SupplyRestrictionDetail.EMPTY;

    /**
     * <p>
     * A free text field describing a non-geographical restriction of the market covered by a distributor or other
     * supplier. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SupplyRestrictionDetail supplyRestrictionDetail() {
        _initialize();
        return supplyRestrictionDetail;
    }

    private ReturnsCodeType returnsCodeType = ReturnsCodeType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the scheme from which the returns conditions code in &lt;ReturnsCode&gt; is taken.
     * Optional and non-repeating, but this field must be present if &lt;ReturnsCode&gt; is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ReturnsCodeType returnsCodeType() {
        _initialize();
        return returnsCodeType;
    }

    private ReturnsCode returnsCode = ReturnsCode.EMPTY;

    /**
     * <p>
     * A returns conditions code from the scheme specified in &lt;ReturnsCodeType&gt;. Optional and non-repeating, but
     * this field must be present if &lt;ReturnsCodeType&gt; is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ReturnsCode returnsCode() {
        _initialize();
        return returnsCode;
    }

    private LastDateForReturns lastDateForReturns = LastDateForReturns.EMPTY;

    /**
     * <p>
     * The last date for returns, when the supplier has placed a time limit on returns from retailers. Typically this
     * occurs when the publisher has made the product out-of-print. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public LastDateForReturns lastDateForReturns() {
        _initialize();
        return lastDateForReturns;
    }

    private ProductAvailability productAvailability = ProductAvailability.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the availability of a product from a supplier. This element has been added as a preferred
     * successor to the &lt;AvailabilityCode&gt; element, and is intended to be used both by publishers (who should also
     * include the new &lt;PublishingStatus&gt; element in PR.20) and by intermediary suppliers (who may also include
     * &lt;PublishingStatus&gt; if they are in a position to do so. Each occurrence of the &lt;SupplyDetail&gt;
     * composite must carry either &lt;AvailabilityCode&gt; or &lt;ProductAvailability&gt;, or both. The element is
     * non-repeating. Recommended practise is in future to use this new element, and, where possible and appropriate, to
     * include the &lt;PublishingStatus&gt; element in PR.20. It is likely that the &lt;AvailabilityCode&gt; element
     * will be “deprecated” in due course in a future release.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ProductAvailability productAvailability() {
        _initialize();
        return productAvailability;
    }

    private IntermediaryAvailabilityCode intermediaryAvailabilityCode = IntermediaryAvailabilityCode.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the availability of a product from an intermediary supplier. This element was added in
     * preparation for an expected revision of availability status coding, but in the event will not now be generally
     * used. The element is being used as an interim measure by the Australian ONIX group to carry local availability
     * status, but will be replaced on completion of the revised code lists. The element will be withdrawn from the ONIX
     * format in a future release.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public IntermediaryAvailabilityCode intermediaryAvailabilityCode() {
        _initialize();
        return intermediaryAvailabilityCode;
    }

    private NewSupplier newSupplier = NewSupplier.EMPTY;

    /**
     * <p>
     * A group of data elements which together specify a new supply source to which orders are referred. Use only when
     * the code in &lt;ProductAvailability&gt; or &lt;AvailabilityCode&gt; indicates “no longer available from us, refer
     * to new supplier”. Only one occurrence of the composite is permitted in this context.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NewSupplier newSupplier() {
        _initialize();
        return newSupplier;
    }

    private DateFormat dateFormat = DateFormat.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the format of the date in &lt;ExpectedShipDate&gt;. Optional an non-repeating. If
     * the field is omitted, the default format YYYYMMDD will be assumed.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DateFormat dateFormat() {
        _initialize();
        return dateFormat;
    }

    private ExpectedShipDate expectedShipDate = ExpectedShipDate.EMPTY;

    /**
     * <p>
     * If the product is not currently available, the date on which shipping from the supplier to retailers is expected
     * to begin or resume. Optional and non-repeating; required with certain code values in the &lt;AvailabilityCode&gt;
     * element. The format is as specified in the &lt;DateFormat&gt; field. The default format is YYYYMMDD, <em>ie</em>
     * an exact year-month-day.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ExpectedShipDate expectedShipDate() {
        _initialize();
        return expectedShipDate;
    }

    private OnSaleDate onSaleDate = OnSaleDate.EMPTY;

    /**
     * <p>
     * The date when a new product can be placed on sale by retailers in the market served by the supplier. Optional and
     * non-repeating. <strong>If the &lt;OnSaleDate&gt; element is used, it means that there is an embargo on sales to
     * consumers before the stated date. Otherwise, sales to consumers are permitted as soon as stocks reach
     * retailers.</strong> In the UK, publishers who are following the PA/BA Launch Dates Code of Practice should use
     * this element for the Launch Date.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public OnSaleDate onSaleDate() {
        _initialize();
        return onSaleDate;
    }

    private OrderTime orderTime = OrderTime.EMPTY;

    /**
     * <p>
     * The expected average number of days from receipt of order to despatch (for items “manufactured on demand” or
     * “only to order”). Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public OrderTime orderTime() {
        _initialize();
        return orderTime;
    }

    private PackQuantity packQuantity = PackQuantity.EMPTY;

    /**
     * <p>
     * The quantity in each carton or binder’s pack in stock currently held by the supplier. (This element is placed in
     * Group&nbsp;PR.24 since it cannot be assumed that pack quantities will be the same for stock held at different
     * suppliers.)
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PackQuantity packQuantity() {
        _initialize();
        return packQuantity;
    }

    private AudienceRestrictionFlag audienceRestrictionFlag = AudienceRestrictionFlag.EMPTY;

    /**
     * <p>
     * Used with &lt;AudienceRestrictionNote&gt; where within a particular market there is an additional restriction on
     * sale, imposed either by the publisher (<em>eg</em> an answer book to be sold only to bona fide teachers) or by
     * another agency (<em>eg</em> “indexing” in the German market). Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public AudienceRestrictionFlag audienceRestrictionFlag() {
        _initialize();
        return audienceRestrictionFlag;
    }

    private AudienceRestrictionNote audienceRestrictionNote = AudienceRestrictionNote.EMPTY;

    /**
     * <p>
     * Free text describing a non-territorial restriction on supply, only when &lt;AudienceRestrictionFlag&gt; is
     * present. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public AudienceRestrictionNote audienceRestrictionNote() {
        _initialize();
        return audienceRestrictionNote;
    }

    private PriceAmount priceAmount = PriceAmount.EMPTY;

    /**
     * <p>
     * The amount of a unit price. This price amount element, outside of the &lt;Price&gt; composite, may be used if and
     * only if a default price type and currency have been specified in the message header, and only one price is to be
     * given. <strong>The element is retained for purposes of upwards compatibility only, and all new implementations
     * should use the &lt;Price&gt; composite.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PriceAmount priceAmount() {
        _initialize();
        return priceAmount;
    }

    private UnpricedItemType unpricedItemType = UnpricedItemType.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies a reason why a price amount is not sent. <strong>If code value 02 is used to send
     * advance information without giving a price, the price must be confirmed as soon as possible.</strong> Optional
     * and non-repeating, but required if the &lt;SupplyDetail&gt; composite does not carry a price.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public UnpricedItemType unpricedItemType() {
        _initialize();
        return unpricedItemType;
    }

    private Reissue reissue = Reissue.EMPTY;

    /**
     * <p>
     * A group of data elements which together specify that a product is to be reissued within the market to which the
     * &lt;SupplyDetail&gt; composite applies. Optional and non-repeating. The &lt;Reissue&gt; composite is used only
     * when the publisher intends to re-launch the product under the same ISBN. There are two possible cases:
     * </p>
     * <ol style="list-style-type: lower-alpha">
     * <li>When the product is unavailable during the period immediately before reissue. In this case, the
     * &lt;AvailabilityCode&gt; should carry the value UR for “unavailable, awaiting reissue”, and the ONIX record can
     * be updated to describe the reissued product as soon as details can be made available</li>
     * <li>When the product is still available during the period up to the reissue date. In this case, the ONIX record
     * should continue to describe the existing product and the &lt;AvailabilityCode&gt; value should remain IP right up
     * to the reissue date. At that date, the record should be updated to describe the reissued product, with the
     * &lt;AvailabilityCode&gt; value remaining IP.</li>
     * </ol>
     * <p>
     * After reissue, it is recommended that the &lt;Reissue&gt; composite should be retained as a permanent element of
     * the ONIX record, carrying only the &lt;ReissueDate&gt; element, which will then indicate “date last reissued”.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Reissue reissue() {
        _initialize();
        return reissue;
    }

    private ListOfOnixDataCompositeWithKey<SupplierIdentifier, JonixSupplierIdentifier,
        SupplierIdentifierTypes> supplierIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * A repeatable group of data elements which together define the identifier of a supplier in accordance with a
     * specified scheme, and allowing different types of supplier identifier to be included without defining additional
     * data elements. Optional, but each occurrence of the &lt;SupplyDetail&gt; composite must carry either at least one
     * supplier identifier, or a &lt;SupplierName&gt;.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<SupplierIdentifier, JonixSupplierIdentifier, SupplierIdentifierTypes>
        supplierIdentifiers() {
        _initialize();
        return supplierIdentifiers;
    }

    private ListOfOnixElement<TelephoneNumber, String> telephoneNumbers = ListOfOnixElement.empty();

    /**
     * <p>
     * A telephone number of a supply source from which the product may be ordered by a trade customer. Optional and
     * repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<TelephoneNumber, String> telephoneNumbers() {
        _initialize();
        return telephoneNumbers;
    }

    private ListOfOnixElement<FaxNumber, String> faxNumbers = ListOfOnixElement.empty();

    /**
     * <p>
     * A fax number of a supply source from which the product may be ordered by a trade customer. Optional and
     * repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<FaxNumber, String> faxNumbers() {
        _initialize();
        return faxNumbers;
    }

    private ListOfOnixElement<EmailAddress, String> emailAddresss = ListOfOnixElement.empty();

    /**
     * <p>
     * An email address for a supply source from which the product may be ordered by a trade customer. Optional and
     * repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EmailAddress, String> emailAddresss() {
        _initialize();
        return emailAddresss;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * An optional and repeatable group of data elements which together identify and provide pointers to a website which
     * is related to the supplier identified in an occurrence of the &lt;SupplyDetail&gt; composite.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }

    private ListOfOnixElement<SupplyToRegion, SupplytoRegions> supplyToRegions = ListOfOnixElement.empty();

    /**
     * <p>
     * An ONIX code for a region to which the supplier is able to supply. A full code list is yet to be defined. A
     * provisional coding, for UK use only, is given for Open Market supply. <strong>This element will not be further
     * developed, and is superseded by &lt;SupplyToTerritory&gt; above. It is retained for purposes of upwards
     * compatibility only. Note that Open Market distribution rights should be specified, like any others, by listing
     * countries and territories.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<SupplyToRegion, SupplytoRegions> supplyToRegions() {
        _initialize();
        return supplyToRegions;
    }

    private ListOfOnixElement<SupplyToCountryExcluded, java.util.Set<Countrys>> supplyToCountryExcludeds =
        ListOfOnixElement.empty();

    /**
     * <p>
     * One or more ISO standard codes identifying a country which is excluded from a territory specified in
     * &lt;SupplyToTerritory&gt;. Successive codes may be separated by spaces. Thus, a single occurrence of the element
     * can carry an unlimited number of country codes. For upwards compatibility, the element remains repeatable, so
     * that multiple countries can be listed as multiple occurrences of the whole element. Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<SupplyToCountryExcluded, java.util.Set<Countrys>> supplyToCountryExcludeds() {
        _initialize();
        return supplyToCountryExcludeds;
    }

    private List<Stock> stocks = Collections.emptyList();

    /**
     * <p>
     * A repeatable group of data elements which together specify a quantity of stock and, where a supplier has more
     * than one warehouse, a supplier location. Optional.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<Stock> stocks() {
        _initialize();
        return stocks;
    }

    private List<Price> prices = Collections.emptyList();

    /**
     * <p>
     * A repeatable group of data elements which together specify a unit price.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<Price> prices() {
        _initialize();
        return prices;
    }
}
