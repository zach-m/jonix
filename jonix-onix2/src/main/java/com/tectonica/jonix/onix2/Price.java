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
import com.tectonica.jonix.codelist.DiscountCodeTypes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixBatchBonus;
import com.tectonica.jonix.struct.JonixDiscountCoded;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Price composite</h1><p>A optional and repeatable group of data elements which together specify a unit price, used
 * here to indicate a price that will apply when the product is reissued. <strong>Please see above, within
 * Group&nbsp;PR.24, for details.</strong></p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;Price&gt;</td></tr><tr><td>Short tag</td><td>&lt;price&gt;</td></tr></table>
 */
public class Price implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Price";
    public static final String shortname = "price";

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
    public static final Price EMPTY = new Price();

    public Price() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Price(org.w3c.dom.Element element) {
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
            if (name.equals(PriceTypeCode.refname) || name.equals(PriceTypeCode.shortname)) {
                priceTypeCode = new PriceTypeCode(e);
            } else if (name.equals(PriceQualifier.refname) || name.equals(PriceQualifier.shortname)) {
                priceQualifier = new PriceQualifier(e);
            } else if (name.equals(PriceTypeDescription.refname) || name.equals(PriceTypeDescription.shortname)) {
                priceTypeDescription = new PriceTypeDescription(e);
            } else if (name.equals(PricePer.refname) || name.equals(PricePer.shortname)) {
                pricePer = new PricePer(e);
            } else if (name.equals(MinimumOrderQuantity.refname) || name.equals(MinimumOrderQuantity.shortname)) {
                minimumOrderQuantity = new MinimumOrderQuantity(e);
            } else if (name.equals(BatchBonus.refname) || name.equals(BatchBonus.shortname)) {
                batchBonuss = JPU.addToList(batchBonuss, new BatchBonus(e));
            } else if (name.equals(ClassOfTrade.refname) || name.equals(ClassOfTrade.shortname)) {
                classOfTrade = new ClassOfTrade(e);
            } else if (name.equals(BICDiscountGroupCode.refname) || name.equals(BICDiscountGroupCode.shortname)) {
                bicDiscountGroupCode = new BICDiscountGroupCode(e);
            } else if (name.equals(DiscountCoded.refname) || name.equals(DiscountCoded.shortname)) {
                discountCodeds = JPU.addToList(discountCodeds, new DiscountCoded(e));
            } else if (name.equals(DiscountPercent.refname) || name.equals(DiscountPercent.shortname)) {
                discountPercent = new DiscountPercent(e);
            } else if (name.equals(PriceStatus.refname) || name.equals(PriceStatus.shortname)) {
                priceStatus = new PriceStatus(e);
            } else if (name.equals(PriceAmount.refname) || name.equals(PriceAmount.shortname)) {
                priceAmount = new PriceAmount(e);
            } else if (name.equals(CurrencyCode.refname) || name.equals(CurrencyCode.shortname)) {
                currencyCode = new CurrencyCode(e);
            } else if (name.equals(CountryCode.refname) || name.equals(CountryCode.shortname)) {
                countryCodes = JPU.addToList(countryCodes, new CountryCode(e));
            } else if (name.equals(Territory.refname) || name.equals(Territory.shortname)) {
                territory = new Territory(e);
            } else if (name.equals(CountryExcluded.refname) || name.equals(CountryExcluded.shortname)) {
                countryExcluded = new CountryExcluded(e);
            } else if (name.equals(TerritoryExcluded.refname) || name.equals(TerritoryExcluded.shortname)) {
                territoryExcluded = new TerritoryExcluded(e);
            } else if (name.equals(TaxRateCode1.refname) || name.equals(TaxRateCode1.shortname)) {
                taxRateCode1 = new TaxRateCode1(e);
            } else if (name.equals(TaxRatePercent1.refname) || name.equals(TaxRatePercent1.shortname)) {
                taxRatePercent1 = new TaxRatePercent1(e);
            } else if (name.equals(TaxableAmount1.refname) || name.equals(TaxableAmount1.shortname)) {
                taxableAmount1 = new TaxableAmount1(e);
            } else if (name.equals(TaxAmount1.refname) || name.equals(TaxAmount1.shortname)) {
                taxAmount1 = new TaxAmount1(e);
            } else if (name.equals(TaxRateCode2.refname) || name.equals(TaxRateCode2.shortname)) {
                taxRateCode2 = new TaxRateCode2(e);
            } else if (name.equals(TaxRatePercent2.refname) || name.equals(TaxRatePercent2.shortname)) {
                taxRatePercent2 = new TaxRatePercent2(e);
            } else if (name.equals(TaxableAmount2.refname) || name.equals(TaxableAmount2.shortname)) {
                taxableAmount2 = new TaxableAmount2(e);
            } else if (name.equals(TaxAmount2.refname) || name.equals(TaxAmount2.shortname)) {
                taxAmount2 = new TaxAmount2(e);
            } else if (name.equals(PriceEffectiveFrom.refname) || name.equals(PriceEffectiveFrom.shortname)) {
                priceEffectiveFrom = new PriceEffectiveFrom(e);
            } else if (name.equals(PriceEffectiveUntil.refname) || name.equals(PriceEffectiveUntil.shortname)) {
                priceEffectiveUntil = new PriceEffectiveUntil(e);
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

    private PriceTypeCode priceTypeCode = PriceTypeCode.EMPTY;

    /**
     * (this field is optional)
     */
    public PriceTypeCode priceTypeCode() {
        initialize();
        return priceTypeCode;
    }

    private PriceQualifier priceQualifier = PriceQualifier.EMPTY;

    /**
     * (this field is optional)
     */
    public PriceQualifier priceQualifier() {
        initialize();
        return priceQualifier;
    }

    private PriceTypeDescription priceTypeDescription = PriceTypeDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public PriceTypeDescription priceTypeDescription() {
        initialize();
        return priceTypeDescription;
    }

    private PricePer pricePer = PricePer.EMPTY;

    /**
     * (this field is optional)
     */
    public PricePer pricePer() {
        initialize();
        return pricePer;
    }

    private MinimumOrderQuantity minimumOrderQuantity = MinimumOrderQuantity.EMPTY;

    /**
     * (this field is optional)
     */
    public MinimumOrderQuantity minimumOrderQuantity() {
        initialize();
        return minimumOrderQuantity;
    }

    private ListOfOnixDataComposite<BatchBonus, JonixBatchBonus> batchBonuss = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<BatchBonus, JonixBatchBonus> batchBonuss() {
        initialize();
        return batchBonuss;
    }

    private ClassOfTrade classOfTrade = ClassOfTrade.EMPTY;

    /**
     * (this field is optional)
     */
    public ClassOfTrade classOfTrade() {
        initialize();
        return classOfTrade;
    }

    private BICDiscountGroupCode bicDiscountGroupCode = BICDiscountGroupCode.EMPTY;

    /**
     * (this field is optional)
     */
    public BICDiscountGroupCode bicDiscountGroupCode() {
        initialize();
        return bicDiscountGroupCode;
    }

    private ListOfOnixDataCompositeWithKey<DiscountCoded, JonixDiscountCoded, DiscountCodeTypes> discountCodeds =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<DiscountCoded, JonixDiscountCoded, DiscountCodeTypes> discountCodeds() {
        initialize();
        return discountCodeds;
    }

    private DiscountPercent discountPercent = DiscountPercent.EMPTY;

    /**
     * (this field is optional)
     */
    public DiscountPercent discountPercent() {
        initialize();
        return discountPercent;
    }

    private PriceStatus priceStatus = PriceStatus.EMPTY;

    /**
     * (this field is optional)
     */
    public PriceStatus priceStatus() {
        initialize();
        return priceStatus;
    }

    private PriceAmount priceAmount = PriceAmount.EMPTY;

    /**
     * (this field is required)
     */
    public PriceAmount priceAmount() {
        initialize();
        return priceAmount;
    }

    private CurrencyCode currencyCode = CurrencyCode.EMPTY;

    /**
     * (this field is optional)
     */
    public CurrencyCode currencyCode() {
        initialize();
        return currencyCode;
    }

    private ListOfOnixElement<CountryCode, CountryCodes> countryCodes = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<CountryCode, CountryCodes> countryCodes() {
        initialize();
        return countryCodes;
    }

    private Territory territory = Territory.EMPTY;

    /**
     * (this field is optional)
     */
    public Territory territory() {
        initialize();
        return territory;
    }

    private CountryExcluded countryExcluded = CountryExcluded.EMPTY;

    /**
     * (this field is optional)
     */
    public CountryExcluded countryExcluded() {
        initialize();
        return countryExcluded;
    }

    private TerritoryExcluded territoryExcluded = TerritoryExcluded.EMPTY;

    /**
     * (this field is optional)
     */
    public TerritoryExcluded territoryExcluded() {
        initialize();
        return territoryExcluded;
    }

    private TaxRateCode1 taxRateCode1 = TaxRateCode1.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxRateCode1 taxRateCode1() {
        initialize();
        return taxRateCode1;
    }

    private TaxRatePercent1 taxRatePercent1 = TaxRatePercent1.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxRatePercent1 taxRatePercent1() {
        initialize();
        return taxRatePercent1;
    }

    private TaxableAmount1 taxableAmount1 = TaxableAmount1.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxableAmount1 taxableAmount1() {
        initialize();
        return taxableAmount1;
    }

    private TaxAmount1 taxAmount1 = TaxAmount1.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxAmount1 taxAmount1() {
        initialize();
        return taxAmount1;
    }

    private TaxRateCode2 taxRateCode2 = TaxRateCode2.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxRateCode2 taxRateCode2() {
        initialize();
        return taxRateCode2;
    }

    private TaxRatePercent2 taxRatePercent2 = TaxRatePercent2.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxRatePercent2 taxRatePercent2() {
        initialize();
        return taxRatePercent2;
    }

    private TaxableAmount2 taxableAmount2 = TaxableAmount2.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxableAmount2 taxableAmount2() {
        initialize();
        return taxableAmount2;
    }

    private TaxAmount2 taxAmount2 = TaxAmount2.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxAmount2 taxAmount2() {
        initialize();
        return taxAmount2;
    }

    private PriceEffectiveFrom priceEffectiveFrom = PriceEffectiveFrom.EMPTY;

    /**
     * (this field is optional)
     */
    public PriceEffectiveFrom priceEffectiveFrom() {
        initialize();
        return priceEffectiveFrom;
    }

    private PriceEffectiveUntil priceEffectiveUntil = PriceEffectiveUntil.EMPTY;

    /**
     * (this field is optional)
     */
    public PriceEffectiveUntil priceEffectiveUntil() {
        initialize();
        return priceEffectiveUntil;
    }
}
