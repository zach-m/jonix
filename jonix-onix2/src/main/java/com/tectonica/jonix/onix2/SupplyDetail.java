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
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            if (name.equals(SupplierIdentifier.refname) || name.equals(SupplierIdentifier.shortname)) {
                supplierIdentifiers = JPU.addToList(supplierIdentifiers, new SupplierIdentifier(e));
            } else if (name.equals(SupplierSAN.refname) || name.equals(SupplierSAN.shortname)) {
                supplierSAN = new SupplierSAN(e);
            } else if (name.equals(SupplierEANLocationNumber.refname) ||
                name.equals(SupplierEANLocationNumber.shortname)) {
                supplierEANLocationNumber = new SupplierEANLocationNumber(e);
            } else if (name.equals(SupplierName.refname) || name.equals(SupplierName.shortname)) {
                supplierName = new SupplierName(e);
            } else if (name.equals(TelephoneNumber.refname) || name.equals(TelephoneNumber.shortname)) {
                telephoneNumbers = JPU.addToList(telephoneNumbers, new TelephoneNumber(e));
            } else if (name.equals(FaxNumber.refname) || name.equals(FaxNumber.shortname)) {
                faxNumbers = JPU.addToList(faxNumbers, new FaxNumber(e));
            } else if (name.equals(EmailAddress.refname) || name.equals(EmailAddress.shortname)) {
                emailAddresss = JPU.addToList(emailAddresss, new EmailAddress(e));
            } else if (name.equals(Website.refname) || name.equals(Website.shortname)) {
                websites = JPU.addToList(websites, new Website(e));
            } else if (name.equals(SupplierRole.refname) || name.equals(SupplierRole.shortname)) {
                supplierRole = new SupplierRole(e);
            } else if (name.equals(SupplyToCountry.refname) || name.equals(SupplyToCountry.shortname)) {
                supplyToCountrys = JPU.addToList(supplyToCountrys, new SupplyToCountry(e));
            } else if (name.equals(SupplyToTerritory.refname) || name.equals(SupplyToTerritory.shortname)) {
                supplyToTerritory = new SupplyToTerritory(e);
            } else if (name.equals(SupplyToRegion.refname) || name.equals(SupplyToRegion.shortname)) {
                supplyToRegions = JPU.addToList(supplyToRegions, new SupplyToRegion(e));
            } else if (name.equals(SupplyToCountryExcluded.refname) || name.equals(SupplyToCountryExcluded.shortname)) {
                supplyToCountryExcludeds = JPU.addToList(supplyToCountryExcludeds, new SupplyToCountryExcluded(e));
            } else if (name.equals(SupplyRestrictionDetail.refname) || name.equals(SupplyRestrictionDetail.shortname)) {
                supplyRestrictionDetail = new SupplyRestrictionDetail(e);
            } else if (name.equals(ReturnsCodeType.refname) || name.equals(ReturnsCodeType.shortname)) {
                returnsCodeType = new ReturnsCodeType(e);
            } else if (name.equals(ReturnsCode.refname) || name.equals(ReturnsCode.shortname)) {
                returnsCode = new ReturnsCode(e);
            } else if (name.equals(LastDateForReturns.refname) || name.equals(LastDateForReturns.shortname)) {
                lastDateForReturns = new LastDateForReturns(e);
            } else if (name.equals(AvailabilityCode.refname) || name.equals(AvailabilityCode.shortname)) {
                availabilityCode = new AvailabilityCode(e);
            } else if (name.equals(ProductAvailability.refname) || name.equals(ProductAvailability.shortname)) {
                productAvailability = new ProductAvailability(e);
            } else if (name.equals(IntermediaryAvailabilityCode.refname) ||
                name.equals(IntermediaryAvailabilityCode.shortname)) {
                intermediaryAvailabilityCode = new IntermediaryAvailabilityCode(e);
            } else if (name.equals(NewSupplier.refname) || name.equals(NewSupplier.shortname)) {
                newSupplier = new NewSupplier(e);
            } else if (name.equals(DateFormat.refname) || name.equals(DateFormat.shortname)) {
                dateFormat = new DateFormat(e);
            } else if (name.equals(ExpectedShipDate.refname) || name.equals(ExpectedShipDate.shortname)) {
                expectedShipDate = new ExpectedShipDate(e);
            } else if (name.equals(OnSaleDate.refname) || name.equals(OnSaleDate.shortname)) {
                onSaleDate = new OnSaleDate(e);
            } else if (name.equals(OrderTime.refname) || name.equals(OrderTime.shortname)) {
                orderTime = new OrderTime(e);
            } else if (name.equals(Stock.refname) || name.equals(Stock.shortname)) {
                stocks = JPU.addToList(stocks, new Stock(e));
            } else if (name.equals(PackQuantity.refname) || name.equals(PackQuantity.shortname)) {
                packQuantity = new PackQuantity(e);
            } else if (name.equals(AudienceRestrictionFlag.refname) || name.equals(AudienceRestrictionFlag.shortname)) {
                audienceRestrictionFlag = new AudienceRestrictionFlag(e);
            } else if (name.equals(AudienceRestrictionNote.refname) || name.equals(AudienceRestrictionNote.shortname)) {
                audienceRestrictionNote = new AudienceRestrictionNote(e);
            } else if (name.equals(PriceAmount.refname) || name.equals(PriceAmount.shortname)) {
                priceAmount = new PriceAmount(e);
            } else if (name.equals(UnpricedItemType.refname) || name.equals(UnpricedItemType.shortname)) {
                unpricedItemType = new UnpricedItemType(e);
            } else if (name.equals(Price.refname) || name.equals(Price.shortname)) {
                prices = JPU.addToList(prices, new Price(e));
            } else if (name.equals(Reissue.refname) || name.equals(Reissue.shortname)) {
                reissue = new Reissue(e);
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
        initialize();
        return supplierIdentifiers;
    }

    private SupplierSAN supplierSAN = SupplierSAN.EMPTY;

    /**
     * (this field is optional)
     */
    public SupplierSAN supplierSAN() {
        initialize();
        return supplierSAN;
    }

    private SupplierEANLocationNumber supplierEANLocationNumber = SupplierEANLocationNumber.EMPTY;

    /**
     * (this field is required)
     */
    public SupplierEANLocationNumber supplierEANLocationNumber() {
        initialize();
        return supplierEANLocationNumber;
    }

    private SupplierName supplierName = SupplierName.EMPTY;

    /**
     * (this field is optional)
     */
    public SupplierName supplierName() {
        initialize();
        return supplierName;
    }

    private ListOfOnixElement<TelephoneNumber, String> telephoneNumbers = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<TelephoneNumber, String> telephoneNumbers() {
        initialize();
        return telephoneNumbers;
    }

    private ListOfOnixElement<FaxNumber, String> faxNumbers = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<FaxNumber, String> faxNumbers() {
        initialize();
        return faxNumbers;
    }

    private ListOfOnixElement<EmailAddress, String> emailAddresss = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<EmailAddress, String> emailAddresss() {
        initialize();
        return emailAddresss;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        initialize();
        return websites;
    }

    private SupplierRole supplierRole = SupplierRole.EMPTY;

    /**
     * (this field is optional)
     */
    public SupplierRole supplierRole() {
        initialize();
        return supplierRole;
    }

    private ListOfOnixElement<SupplyToCountry, java.util.Set<CountryCodes>> supplyToCountrys =
        ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<SupplyToCountry, java.util.Set<CountryCodes>> supplyToCountrys() {
        initialize();
        return supplyToCountrys;
    }

    private SupplyToTerritory supplyToTerritory = SupplyToTerritory.EMPTY;

    /**
     * (this field is optional)
     */
    public SupplyToTerritory supplyToTerritory() {
        initialize();
        return supplyToTerritory;
    }

    private ListOfOnixElement<SupplyToRegion, SupplytoRegions> supplyToRegions = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<SupplyToRegion, SupplytoRegions> supplyToRegions() {
        initialize();
        return supplyToRegions;
    }

    private ListOfOnixElement<SupplyToCountryExcluded, java.util.Set<CountryCodes>> supplyToCountryExcludeds =
        ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<SupplyToCountryExcluded, java.util.Set<CountryCodes>> supplyToCountryExcludeds() {
        initialize();
        return supplyToCountryExcludeds;
    }

    private SupplyRestrictionDetail supplyRestrictionDetail = SupplyRestrictionDetail.EMPTY;

    /**
     * (this field is optional)
     */
    public SupplyRestrictionDetail supplyRestrictionDetail() {
        initialize();
        return supplyRestrictionDetail;
    }

    private ReturnsCodeType returnsCodeType = ReturnsCodeType.EMPTY;

    /**
     * (this field is optional)
     */
    public ReturnsCodeType returnsCodeType() {
        initialize();
        return returnsCodeType;
    }

    private ReturnsCode returnsCode = ReturnsCode.EMPTY;

    /**
     * (this field is optional)
     */
    public ReturnsCode returnsCode() {
        initialize();
        return returnsCode;
    }

    private LastDateForReturns lastDateForReturns = LastDateForReturns.EMPTY;

    /**
     * (this field is optional)
     */
    public LastDateForReturns lastDateForReturns() {
        initialize();
        return lastDateForReturns;
    }

    private AvailabilityCode availabilityCode = AvailabilityCode.EMPTY;

    /**
     * (this field is required)
     */
    public AvailabilityCode availabilityCode() {
        initialize();
        return availabilityCode;
    }

    private ProductAvailability productAvailability = ProductAvailability.EMPTY;

    /**
     * (this field is optional)
     */
    public ProductAvailability productAvailability() {
        initialize();
        return productAvailability;
    }

    private IntermediaryAvailabilityCode intermediaryAvailabilityCode = IntermediaryAvailabilityCode.EMPTY;

    /**
     * (this field is optional)
     */
    public IntermediaryAvailabilityCode intermediaryAvailabilityCode() {
        initialize();
        return intermediaryAvailabilityCode;
    }

    private NewSupplier newSupplier = NewSupplier.EMPTY;

    /**
     * (this field is optional)
     */
    public NewSupplier newSupplier() {
        initialize();
        return newSupplier;
    }

    private DateFormat dateFormat = DateFormat.EMPTY;

    /**
     * (this field is optional)
     */
    public DateFormat dateFormat() {
        initialize();
        return dateFormat;
    }

    private ExpectedShipDate expectedShipDate = ExpectedShipDate.EMPTY;

    /**
     * (this field is optional)
     */
    public ExpectedShipDate expectedShipDate() {
        initialize();
        return expectedShipDate;
    }

    private OnSaleDate onSaleDate = OnSaleDate.EMPTY;

    /**
     * (this field is optional)
     */
    public OnSaleDate onSaleDate() {
        initialize();
        return onSaleDate;
    }

    private OrderTime orderTime = OrderTime.EMPTY;

    /**
     * (this field is optional)
     */
    public OrderTime orderTime() {
        initialize();
        return orderTime;
    }

    private List<Stock> stocks = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Stock> stocks() {
        initialize();
        return stocks;
    }

    private PackQuantity packQuantity = PackQuantity.EMPTY;

    /**
     * (this field is optional)
     */
    public PackQuantity packQuantity() {
        initialize();
        return packQuantity;
    }

    private AudienceRestrictionFlag audienceRestrictionFlag = AudienceRestrictionFlag.EMPTY;

    /**
     * (this field is optional)
     */
    public AudienceRestrictionFlag audienceRestrictionFlag() {
        initialize();
        return audienceRestrictionFlag;
    }

    private AudienceRestrictionNote audienceRestrictionNote = AudienceRestrictionNote.EMPTY;

    /**
     * (this field is optional)
     */
    public AudienceRestrictionNote audienceRestrictionNote() {
        initialize();
        return audienceRestrictionNote;
    }

    private PriceAmount priceAmount = PriceAmount.EMPTY;

    /**
     * (this field is optional)
     */
    public PriceAmount priceAmount() {
        initialize();
        return priceAmount;
    }

    private UnpricedItemType unpricedItemType = UnpricedItemType.EMPTY;

    /**
     * (this field is optional)
     */
    public UnpricedItemType unpricedItemType() {
        initialize();
        return unpricedItemType;
    }

    private List<Price> prices = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Price> prices() {
        initialize();
        return prices;
    }

    private Reissue reissue = Reissue.EMPTY;

    /**
     * (this field is optional)
     */
    public Reissue reissue() {
        initialize();
        return reissue;
    }
}
