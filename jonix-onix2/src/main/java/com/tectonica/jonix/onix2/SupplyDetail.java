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
import com.tectonica.jonix.codelist.CountryCodes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.codelist.SupplytoRegions;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixSupplierIdentifier;
import com.tectonica.jonix.struct.JonixWebsite;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supplier and trade data composite</h1><p>A repeatable group of data elements which together give details of a
 * trade supply source and the product price and availability from that source.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;SupplyDetail&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;supplydetail&gt;</td></tr></table>
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
                case SupplierIdentifier.refname:
                case SupplierIdentifier.shortname:
                    supplierIdentifiers = JPU.addToList(supplierIdentifiers, new SupplierIdentifier(e));
                    break;
                case SupplierSAN.refname:
                case SupplierSAN.shortname:
                    supplierSAN = new SupplierSAN(e);
                    break;
                case SupplierEANLocationNumber.refname:
                case SupplierEANLocationNumber.shortname:
                    supplierEANLocationNumber = new SupplierEANLocationNumber(e);
                    break;
                case SupplierName.refname:
                case SupplierName.shortname:
                    supplierName = new SupplierName(e);
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
                case SupplierRole.refname:
                case SupplierRole.shortname:
                    supplierRole = new SupplierRole(e);
                    break;
                case SupplyToCountry.refname:
                case SupplyToCountry.shortname:
                    supplyToCountrys = JPU.addToList(supplyToCountrys, new SupplyToCountry(e));
                    break;
                case SupplyToTerritory.refname:
                case SupplyToTerritory.shortname:
                    supplyToTerritory = new SupplyToTerritory(e);
                    break;
                case SupplyToRegion.refname:
                case SupplyToRegion.shortname:
                    supplyToRegions = JPU.addToList(supplyToRegions, new SupplyToRegion(e));
                    break;
                case SupplyToCountryExcluded.refname:
                case SupplyToCountryExcluded.shortname:
                    supplyToCountryExcludeds = JPU.addToList(supplyToCountryExcludeds, new SupplyToCountryExcluded(e));
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
                case AvailabilityCode.refname:
                case AvailabilityCode.shortname:
                    availabilityCode = new AvailabilityCode(e);
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
                case Stock.refname:
                case Stock.shortname:
                    stocks = JPU.addToList(stocks, new Stock(e));
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
                case Price.refname:
                case Price.shortname:
                    prices = JPU.addToList(prices, new Price(e));
                    break;
                case Reissue.refname:
                case Reissue.shortname:
                    reissue = new Reissue(e);
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

    private ListOfOnixDataCompositeWithKey<SupplierIdentifier, JonixSupplierIdentifier, SupplierIdentifierTypes>
        supplierIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<SupplierIdentifier, JonixSupplierIdentifier, SupplierIdentifierTypes> supplierIdentifiers() {
        _initialize();
        return supplierIdentifiers;
    }

    private SupplierSAN supplierSAN = SupplierSAN.EMPTY;

    /**
     * (this field is optional)
     */
    public SupplierSAN supplierSAN() {
        _initialize();
        return supplierSAN;
    }

    private SupplierEANLocationNumber supplierEANLocationNumber = SupplierEANLocationNumber.EMPTY;

    /**
     * (this field is required)
     */
    public SupplierEANLocationNumber supplierEANLocationNumber() {
        _initialize();
        return supplierEANLocationNumber;
    }

    private SupplierName supplierName = SupplierName.EMPTY;

    /**
     * (this field is optional)
     */
    public SupplierName supplierName() {
        _initialize();
        return supplierName;
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

    private SupplierRole supplierRole = SupplierRole.EMPTY;

    /**
     * (this field is optional)
     */
    public SupplierRole supplierRole() {
        _initialize();
        return supplierRole;
    }

    private ListOfOnixElement<SupplyToCountry, java.util.Set<CountryCodes>> supplyToCountrys =
        ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<SupplyToCountry, java.util.Set<CountryCodes>> supplyToCountrys() {
        _initialize();
        return supplyToCountrys;
    }

    private SupplyToTerritory supplyToTerritory = SupplyToTerritory.EMPTY;

    /**
     * (this field is optional)
     */
    public SupplyToTerritory supplyToTerritory() {
        _initialize();
        return supplyToTerritory;
    }

    private ListOfOnixElement<SupplyToRegion, SupplytoRegions> supplyToRegions = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<SupplyToRegion, SupplytoRegions> supplyToRegions() {
        _initialize();
        return supplyToRegions;
    }

    private ListOfOnixElement<SupplyToCountryExcluded, java.util.Set<CountryCodes>> supplyToCountryExcludeds =
        ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<SupplyToCountryExcluded, java.util.Set<CountryCodes>> supplyToCountryExcludeds() {
        _initialize();
        return supplyToCountryExcludeds;
    }

    private SupplyRestrictionDetail supplyRestrictionDetail = SupplyRestrictionDetail.EMPTY;

    /**
     * (this field is optional)
     */
    public SupplyRestrictionDetail supplyRestrictionDetail() {
        _initialize();
        return supplyRestrictionDetail;
    }

    private ReturnsCodeType returnsCodeType = ReturnsCodeType.EMPTY;

    /**
     * (this field is optional)
     */
    public ReturnsCodeType returnsCodeType() {
        _initialize();
        return returnsCodeType;
    }

    private ReturnsCode returnsCode = ReturnsCode.EMPTY;

    /**
     * (this field is optional)
     */
    public ReturnsCode returnsCode() {
        _initialize();
        return returnsCode;
    }

    private LastDateForReturns lastDateForReturns = LastDateForReturns.EMPTY;

    /**
     * (this field is optional)
     */
    public LastDateForReturns lastDateForReturns() {
        _initialize();
        return lastDateForReturns;
    }

    private AvailabilityCode availabilityCode = AvailabilityCode.EMPTY;

    /**
     * (this field is required)
     */
    public AvailabilityCode availabilityCode() {
        _initialize();
        return availabilityCode;
    }

    private ProductAvailability productAvailability = ProductAvailability.EMPTY;

    /**
     * (this field is optional)
     */
    public ProductAvailability productAvailability() {
        _initialize();
        return productAvailability;
    }

    private IntermediaryAvailabilityCode intermediaryAvailabilityCode = IntermediaryAvailabilityCode.EMPTY;

    /**
     * (this field is optional)
     */
    public IntermediaryAvailabilityCode intermediaryAvailabilityCode() {
        _initialize();
        return intermediaryAvailabilityCode;
    }

    private NewSupplier newSupplier = NewSupplier.EMPTY;

    /**
     * (this field is optional)
     */
    public NewSupplier newSupplier() {
        _initialize();
        return newSupplier;
    }

    private DateFormat dateFormat = DateFormat.EMPTY;

    /**
     * (this field is optional)
     */
    public DateFormat dateFormat() {
        _initialize();
        return dateFormat;
    }

    private ExpectedShipDate expectedShipDate = ExpectedShipDate.EMPTY;

    /**
     * (this field is optional)
     */
    public ExpectedShipDate expectedShipDate() {
        _initialize();
        return expectedShipDate;
    }

    private OnSaleDate onSaleDate = OnSaleDate.EMPTY;

    /**
     * (this field is optional)
     */
    public OnSaleDate onSaleDate() {
        _initialize();
        return onSaleDate;
    }

    private OrderTime orderTime = OrderTime.EMPTY;

    /**
     * (this field is optional)
     */
    public OrderTime orderTime() {
        _initialize();
        return orderTime;
    }

    private List<Stock> stocks = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Stock> stocks() {
        _initialize();
        return stocks;
    }

    private PackQuantity packQuantity = PackQuantity.EMPTY;

    /**
     * (this field is optional)
     */
    public PackQuantity packQuantity() {
        _initialize();
        return packQuantity;
    }

    private AudienceRestrictionFlag audienceRestrictionFlag = AudienceRestrictionFlag.EMPTY;

    /**
     * (this field is optional)
     */
    public AudienceRestrictionFlag audienceRestrictionFlag() {
        _initialize();
        return audienceRestrictionFlag;
    }

    private AudienceRestrictionNote audienceRestrictionNote = AudienceRestrictionNote.EMPTY;

    /**
     * (this field is optional)
     */
    public AudienceRestrictionNote audienceRestrictionNote() {
        _initialize();
        return audienceRestrictionNote;
    }

    private PriceAmount priceAmount = PriceAmount.EMPTY;

    /**
     * (this field is optional)
     */
    public PriceAmount priceAmount() {
        _initialize();
        return priceAmount;
    }

    private UnpricedItemType unpricedItemType = UnpricedItemType.EMPTY;

    /**
     * (this field is optional)
     */
    public UnpricedItemType unpricedItemType() {
        _initialize();
        return unpricedItemType;
    }

    private List<Price> prices = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Price> prices() {
        _initialize();
        return prices;
    }

    private Reissue reissue = Reissue.EMPTY;

    /**
     * (this field is optional)
     */
    public Reissue reissue() {
        _initialize();
        return reissue;
    }
}
