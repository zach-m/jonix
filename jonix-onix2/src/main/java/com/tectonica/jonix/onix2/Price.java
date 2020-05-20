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
import com.tectonica.jonix.common.codelist.DiscountCodeTypes;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixBatchBonus;
import com.tectonica.jonix.common.struct.JonixDiscountCoded;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Price composite</h1>
 * <p>
 * A repeatable group of data elements which together specify a unit price.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Price&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;price&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * <li>&lt;{@link Reissue}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Price}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price}</li>
 * </ul>
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
                case PriceAmount.refname:
                case PriceAmount.shortname:
                    priceAmount = new PriceAmount(e);
                    break;
                case CountryCode.refname:
                case CountryCode.shortname:
                    countryCodes = JPU.addToList(countryCodes, new CountryCode(e));
                    break;
                case PriceTypeCode.refname:
                case PriceTypeCode.shortname:
                    priceTypeCode = new PriceTypeCode(e);
                    break;
                case PriceQualifier.refname:
                case PriceQualifier.shortname:
                    priceQualifier = new PriceQualifier(e);
                    break;
                case PriceTypeDescription.refname:
                case PriceTypeDescription.shortname:
                    priceTypeDescription = new PriceTypeDescription(e);
                    break;
                case PricePer.refname:
                case PricePer.shortname:
                    pricePer = new PricePer(e);
                    break;
                case MinimumOrderQuantity.refname:
                case MinimumOrderQuantity.shortname:
                    minimumOrderQuantity = new MinimumOrderQuantity(e);
                    break;
                case ClassOfTrade.refname:
                case ClassOfTrade.shortname:
                    classOfTrade = new ClassOfTrade(e);
                    break;
                case BICDiscountGroupCode.refname:
                case BICDiscountGroupCode.shortname:
                    bicDiscountGroupCode = new BICDiscountGroupCode(e);
                    break;
                case DiscountPercent.refname:
                case DiscountPercent.shortname:
                    discountPercent = new DiscountPercent(e);
                    break;
                case PriceStatus.refname:
                case PriceStatus.shortname:
                    priceStatus = new PriceStatus(e);
                    break;
                case CurrencyCode.refname:
                case CurrencyCode.shortname:
                    currencyCode = new CurrencyCode(e);
                    break;
                case Territory.refname:
                case Territory.shortname:
                    territory = new Territory(e);
                    break;
                case CountryExcluded.refname:
                case CountryExcluded.shortname:
                    countryExcluded = new CountryExcluded(e);
                    break;
                case TerritoryExcluded.refname:
                case TerritoryExcluded.shortname:
                    territoryExcluded = new TerritoryExcluded(e);
                    break;
                case TaxRateCode1.refname:
                case TaxRateCode1.shortname:
                    taxRateCode1 = new TaxRateCode1(e);
                    break;
                case TaxRatePercent1.refname:
                case TaxRatePercent1.shortname:
                    taxRatePercent1 = new TaxRatePercent1(e);
                    break;
                case TaxableAmount1.refname:
                case TaxableAmount1.shortname:
                    taxableAmount1 = new TaxableAmount1(e);
                    break;
                case TaxAmount1.refname:
                case TaxAmount1.shortname:
                    taxAmount1 = new TaxAmount1(e);
                    break;
                case TaxRateCode2.refname:
                case TaxRateCode2.shortname:
                    taxRateCode2 = new TaxRateCode2(e);
                    break;
                case TaxRatePercent2.refname:
                case TaxRatePercent2.shortname:
                    taxRatePercent2 = new TaxRatePercent2(e);
                    break;
                case TaxableAmount2.refname:
                case TaxableAmount2.shortname:
                    taxableAmount2 = new TaxableAmount2(e);
                    break;
                case TaxAmount2.refname:
                case TaxAmount2.shortname:
                    taxAmount2 = new TaxAmount2(e);
                    break;
                case PriceEffectiveFrom.refname:
                case PriceEffectiveFrom.shortname:
                    priceEffectiveFrom = new PriceEffectiveFrom(e);
                    break;
                case PriceEffectiveUntil.refname:
                case PriceEffectiveUntil.shortname:
                    priceEffectiveUntil = new PriceEffectiveUntil(e);
                    break;
                case BatchBonus.refname:
                case BatchBonus.shortname:
                    batchBonuss = JPU.addToList(batchBonuss, new BatchBonus(e));
                    break;
                case DiscountCoded.refname:
                case DiscountCoded.shortname:
                    discountCodeds = JPU.addToList(discountCodeds, new DiscountCoded(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Price&gt; or &lt;price&gt;) is explicitly provided in the ONIX XML
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

    private PriceAmount priceAmount = PriceAmount.EMPTY;

    /**
     * <p>
     * The amount of a price. Mandatory in each occurrence of the &lt;Price&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public PriceAmount priceAmount() {
        _initialize();
        return priceAmount;
    }

    private ListOfOnixElement<CountryCode, Countrys> countryCodes = ListOfOnixElement.empty();

    /**
     * <p>
     * A code identifying a country in which the price given in &lt;PriceAmount&gt; applies. This allows a supplier to
     * list different prices for specific countries by repeating the &lt;Price&gt; composite rather than having to
     * repeat the whole of the &lt;SupplyDetail&gt; composite. Optional, and repeatable if a single price applies to
     * multiple countries.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<CountryCode, Countrys> countryCodes() {
        _initialize();
        return countryCodes;
    }

    private PriceTypeCode priceTypeCode = PriceTypeCode.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the type of the price in the &lt;PriceAmount&gt; field within the &lt;Price&gt;
     * composite. Optional, provided that a &lt;DefaultPriceTypeCode&gt; has been specified in the message header, and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PriceTypeCode priceTypeCode() {
        _initialize();
        return priceTypeCode;
    }

    private PriceQualifier priceQualifier = PriceQualifier.EMPTY;

    /**
     * <p>
     * An ONIX code which further specifies the type of price, <em>eg</em> member price, reduced price when purchased as
     * part of a set. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PriceQualifier priceQualifier() {
        _initialize();
        return priceQualifier;
    }

    private PriceTypeDescription priceTypeDescription = PriceTypeDescription.EMPTY;

    /**
     * <p>
     * Free text which further describes the price type. Optional and non-repeating. In the Netherlands, when the
     * &lt;PriceQualifier&gt; code identifies a “voucher price”, the &lt;PriceTypeDescription&gt; should give the “EAN
     * action number” that identifies the offer.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PriceTypeDescription priceTypeDescription() {
        _initialize();
        return priceTypeDescription;
    }

    private PricePer pricePer = PricePer.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the unit of product which is the basis for the price carried in an occurrence of the
     * &lt;Price&gt; composite. Optional and non-repeating. Where the price applies to a copy of the whole product, this
     * field is normally omitted.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PricePer pricePer() {
        _initialize();
        return pricePer;
    }

    private MinimumOrderQuantity minimumOrderQuantity = MinimumOrderQuantity.EMPTY;

    /**
     * <p>
     * The minimum number of copies which must be ordered to obtain the price carried in an occurrence of the
     * &lt;Price&gt; composite. Optional and non-repeating. If the field is present, the price is a quantity price. If
     * the field is omitted, the price applies to a single unit.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public MinimumOrderQuantity minimumOrderQuantity() {
        _initialize();
        return minimumOrderQuantity;
    }

    private ClassOfTrade classOfTrade = ClassOfTrade.EMPTY;

    /**
     * <p>
     * Text indicating the class of trade to which the price carried in an occurrence of the &lt;Price&gt; composite is
     * applicable, <em>eg</em> Institutional, General trade, Wholesale distributor, which may be represented by a
     * suitable code or abbreviation agreed between trading partners. This element should be used only in the absence of
     * a “Default class of trade” &lt;m193&gt; in the message header, or when the class of trade is other than the
     * default.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ClassOfTrade classOfTrade() {
        _initialize();
        return classOfTrade;
    }

    private BICDiscountGroupCode bicDiscountGroupCode = BICDiscountGroupCode.EMPTY;

    /**
     * <p>
     * A BIC code indicating the supplier’s discount group to which the price carried in an occurrence of the
     * &lt;Price&gt; composite belongs. This code does not identify an absolute rate of discount, but it allows a
     * bookseller to derive the actual discount by reference to a look-up table provided separately by the supplier.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public BICDiscountGroupCode bicDiscountGroupCode() {
        _initialize();
        return bicDiscountGroupCode;
    }

    private DiscountPercent discountPercent = DiscountPercent.EMPTY;

    /**
     * <p>
     * The supplier’s discount percentage applicable to the price carried in an occurrence of the &lt;Price&gt;
     * composite. Optional and non-repeating. Use only when an ONIX message is sent within the context of a specific
     * trading relationship.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DiscountPercent discountPercent() {
        _initialize();
        return discountPercent;
    }

    private PriceStatus priceStatus = PriceStatus.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the status of a price. Optional and non-repeating. If the field is omitted, the
     * default “unspecified” will apply.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PriceStatus priceStatus() {
        _initialize();
        return priceStatus;
    }

    private CurrencyCode currencyCode = CurrencyCode.EMPTY;

    /**
     * <p>
     * An ISO standard code identifying the currency in which a price is given in &lt;PriceAmount&gt;, unless it is the
     * default currency for the exchange. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CurrencyCode currencyCode() {
        _initialize();
        return currencyCode;
    }

    private Territory territory = Territory.EMPTY;

    /**
     * <p>
     * One or more ONIX codes identifying a territory, other than a country, in which the price given in
     * &lt;PriceAmount&gt; applies. Successive codes may be separated by spaces. Thus the element can carry an unlimited
     * number of territory codes. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Territory territory() {
        _initialize();
        return territory;
    }

    private CountryExcluded countryExcluded = CountryExcluded.EMPTY;

    /**
     * <p>
     * One or more ISO standard codes identifying a country which is excluded from a territory specified in
     * &lt;Territory&gt;. Successive codes may be separated by spaces. Thus, a single occurrence of the element can
     * carry an unlimited number of country codes. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CountryExcluded countryExcluded() {
        _initialize();
        return countryExcluded;
    }

    private TerritoryExcluded territoryExcluded = TerritoryExcluded.EMPTY;

    /**
     * <p>
     * One or more ONIX codes identifying a territory, which is excluded from a country specified in &lt;CountryCode&gt;
     * or from a territory specified in &lt;Territory&gt;. Successive codes may be separated by spaces. Thus the element
     * can carry an unlimited number of territory codes. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TerritoryExcluded territoryExcluded() {
        _initialize();
        return territoryExcluded;
    }

    private TaxRateCode1 taxRateCode1 = TaxRateCode1.EMPTY;

    /**
     * <p>
     * A code which specifies a value added tax rate applying to the whole of the price, or to the amount of the price
     * which is specified in &lt;TaxableAmount1&gt; if present. Optional and non-repeating.
     * </p>
     * <p>
     * If the product is taxable at a single rate, or is wholly exempt or zero-rated, &lt;TaxRateCode1&gt; may be sent
     * on its own, or with any combination of &lt;TaxRatePercent1&gt;, &lt;TaxableAmount1&gt; and &lt;TaxAmount1&gt;,
     * although it is best practise to send all these three elements.
     * </p>
     * <p>
     * If the product carries mixed tax rates, the minimum requirement is to send &lt;TaxRateCode1&gt;,
     * &lt;TaxRateCode2&gt;, &lt;TaxableAmount1&gt; and &lt;TaxableAmount2&gt;, though again best practise would be to
     * send all eight tax elements so that the tax calculation is made entirely explicit.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TaxRateCode1 taxRateCode1() {
        _initialize();
        return taxRateCode1;
    }

    private TaxRatePercent1 taxRatePercent1 = TaxRatePercent1.EMPTY;

    /**
     * <p>
     * A tax rate expressed numerically as a percentage. See notes on &lt;TaxRateCode1&gt;.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TaxRatePercent1 taxRatePercent1() {
        _initialize();
        return taxRatePercent1;
    }

    private TaxableAmount1 taxableAmount1 = TaxableAmount1.EMPTY;

    /**
     * <p>
     * The amount of the unit price of the product, excluding tax, which is taxable at the rate specified by
     * &lt;TaxRateCode1&gt; and/or &lt;TaxRatePercent1&gt;. This may be the whole of the unit price before tax, if the
     * item carries tax at the same rate on the whole price; or part of the unit price in the case of a mixed tax rate
     * product. See notes on &lt;TaxRateCode1&gt;.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TaxableAmount1 taxableAmount1() {
        _initialize();
        return taxableAmount1;
    }

    private TaxAmount1 taxAmount1 = TaxAmount1.EMPTY;

    /**
     * <p>
     * The amount of tax chargeable at the rate specified by &lt;TaxRateCode1&gt; and/or &lt;TaxRatePercent1&gt;. See
     * notes on &lt;TaxRateCode1&gt;.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TaxAmount1 taxAmount1() {
        _initialize();
        return taxAmount1;
    }

    private TaxRateCode2 taxRateCode2 = TaxRateCode2.EMPTY;

    /**
     * <p>
     * A code which specifies a value added tax rate applying to the amount of the price which is specified in
     * &lt;TaxableAmount2&gt;. See notes on &lt;TaxRateCode1&gt;.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TaxRateCode2 taxRateCode2() {
        _initialize();
        return taxRateCode2;
    }

    private TaxRatePercent2 taxRatePercent2 = TaxRatePercent2.EMPTY;

    /**
     * <p>
     * A tax rate expressed numerically as a percentage. See notes on &lt;TaxRateCode1&gt;.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TaxRatePercent2 taxRatePercent2() {
        _initialize();
        return taxRatePercent2;
    }

    private TaxableAmount2 taxableAmount2 = TaxableAmount2.EMPTY;

    /**
     * <p>
     * The amount of the unit price of the product, excluding tax, which is taxable at the rate specified by
     * &lt;TaxRateCode2&gt; and/or &lt;TaxRatePercent2&gt;. This may be the whole of the unit price before tax, if the
     * item carries tax at the same rate on the whole price; or part of the unit price in the case of a mixed tax rate
     * product. See notes on &lt;TaxRateCode1&gt;.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TaxableAmount2 taxableAmount2() {
        _initialize();
        return taxableAmount2;
    }

    private TaxAmount2 taxAmount2 = TaxAmount2.EMPTY;

    /**
     * <p>
     * The amount of tax chargeable at the rate specified by &lt;TaxRateCode2&gt; and/or &lt;TaxRatePercent2&gt;. See
     * notes on &lt;TaxRateCode1&gt;.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TaxAmount2 taxAmount2() {
        _initialize();
        return taxAmount2;
    }

    private PriceEffectiveFrom priceEffectiveFrom = PriceEffectiveFrom.EMPTY;

    /**
     * <p>
     * The date from which a price becomes effective. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PriceEffectiveFrom priceEffectiveFrom() {
        _initialize();
        return priceEffectiveFrom;
    }

    private PriceEffectiveUntil priceEffectiveUntil = PriceEffectiveUntil.EMPTY;

    /**
     * <p>
     * The date until which a price remains effective. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PriceEffectiveUntil priceEffectiveUntil() {
        _initialize();
        return priceEffectiveUntil;
    }

    private ListOfOnixDataComposite<BatchBonus, JonixBatchBonus> batchBonuss = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * A repeatable group of data elements which together specify a batch bonus, <em>ie</em> a quantity of free copies
     * which are supplied with a certain order quantity. The &lt;BatchBonus&gt; composite is optional.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<BatchBonus, JonixBatchBonus> batchBonuss() {
        _initialize();
        return batchBonuss;
    }

    private ListOfOnixDataCompositeWithKey<DiscountCoded, JonixDiscountCoded, DiscountCodeTypes> discountCodeds =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * A repeatable group of data elements which together define a discount code from a specified scheme, and allowing
     * different discount code schemes to be supported without defining additional data elements. Optional.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<DiscountCoded, JonixDiscountCoded, DiscountCodeTypes> discountCodeds() {
        _initialize();
        return discountCodeds;
    }
}
