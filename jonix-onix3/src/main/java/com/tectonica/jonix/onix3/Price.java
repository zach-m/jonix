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
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.DiscountCodeTypes;
import com.tectonica.jonix.codelist.PriceDateRoles;
import com.tectonica.jonix.codelist.PriceIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixBatchBonus;
import com.tectonica.jonix.struct.JonixDiscount;
import com.tectonica.jonix.struct.JonixDiscountCoded;
import com.tectonica.jonix.struct.JonixPriceDate;
import com.tectonica.jonix.struct.JonixPriceIdentifier;
import com.tectonica.jonix.struct.JonixTax;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Price composite</h1><p>A optional and repeatable group of data elements which together specify a unit price, used
 * here to indicate a price that will apply when the product is reissued. Deprecated in this context.</p><table
 * border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;Price&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;price&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class Price implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Price";
    public static final String shortname = "price";

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

        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case PriceIdentifier.refname:
                case PriceIdentifier.shortname:
                    priceIdentifiers = JPU.addToList(priceIdentifiers, new PriceIdentifier(e));
                    break;
                case PriceType.refname:
                case PriceType.shortname:
                    priceType = new PriceType(e);
                    break;
                case PriceQualifier.refname:
                case PriceQualifier.shortname:
                    priceQualifier = new PriceQualifier(e);
                    break;
                case PriceTypeDescription.refname:
                case PriceTypeDescription.shortname:
                    priceTypeDescriptions = JPU.addToList(priceTypeDescriptions, new PriceTypeDescription(e));
                    break;
                case PricePer.refname:
                case PricePer.shortname:
                    pricePer = new PricePer(e);
                    break;
                case PriceCondition.refname:
                case PriceCondition.shortname:
                    priceConditions = JPU.addToList(priceConditions, new PriceCondition(e));
                    break;
                case MinimumOrderQuantity.refname:
                case MinimumOrderQuantity.shortname:
                    minimumOrderQuantity = new MinimumOrderQuantity(e);
                    break;
                case BatchBonus.refname:
                case BatchBonus.shortname:
                    batchBonuss = JPU.addToList(batchBonuss, new BatchBonus(e));
                    break;
                case DiscountCoded.refname:
                case DiscountCoded.shortname:
                    discountCodeds = JPU.addToList(discountCodeds, new DiscountCoded(e));
                    break;
                case Discount.refname:
                case Discount.shortname:
                    discounts = JPU.addToList(discounts, new Discount(e));
                    break;
                case PriceStatus.refname:
                case PriceStatus.shortname:
                    priceStatus = new PriceStatus(e);
                    break;
                case PriceAmount.refname:
                case PriceAmount.shortname:
                    priceAmount = new PriceAmount(e);
                    break;
                case PriceCoded.refname:
                case PriceCoded.shortname:
                    priceCoded = new PriceCoded(e);
                    break;
                case Tax.refname:
                case Tax.shortname:
                    taxs = JPU.addToList(taxs, new Tax(e));
                    break;
                case CurrencyCode.refname:
                case CurrencyCode.shortname:
                    currencyCode = new CurrencyCode(e);
                    break;
                case Territory.refname:
                case Territory.shortname:
                    territory = new Territory(e);
                    break;
                case CurrencyZone.refname:
                case CurrencyZone.shortname:
                    currencyZone = new CurrencyZone(e);
                    break;
                case ComparisonProductPrice.refname:
                case ComparisonProductPrice.shortname:
                    comparisonProductPrices = JPU.addToList(comparisonProductPrices, new ComparisonProductPrice(e));
                    break;
                case PriceDate.refname:
                case PriceDate.shortname:
                    priceDates = JPU.addToList(priceDates, new PriceDate(e));
                    break;
                case PrintedOnProduct.refname:
                case PrintedOnProduct.shortname:
                    printedOnProduct = new PrintedOnProduct(e);
                    break;
                case PositionOnProduct.refname:
                case PositionOnProduct.shortname:
                    positionOnProduct = new PositionOnProduct(e);
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

    private ListOfOnixDataCompositeWithKey<PriceIdentifier, JonixPriceIdentifier, PriceIdentifierTypes>
        priceIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<PriceIdentifier, JonixPriceIdentifier, PriceIdentifierTypes> priceIdentifiers() {
        initialize();
        return priceIdentifiers;
    }

    private PriceType priceType = PriceType.EMPTY;

    /**
     * (this field is optional)
     */
    public PriceType priceType() {
        initialize();
        return priceType;
    }

    private PriceQualifier priceQualifier = PriceQualifier.EMPTY;

    /**
     * (this field is optional)
     */
    public PriceQualifier priceQualifier() {
        initialize();
        return priceQualifier;
    }

    private ListOfOnixElement<PriceTypeDescription, String> priceTypeDescriptions = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<PriceTypeDescription, String> priceTypeDescriptions() {
        initialize();
        return priceTypeDescriptions;
    }

    private PricePer pricePer = PricePer.EMPTY;

    /**
     * (this field is optional)
     */
    public PricePer pricePer() {
        initialize();
        return pricePer;
    }

    private List<PriceCondition> priceConditions = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<PriceCondition> priceConditions() {
        initialize();
        return priceConditions;
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

    private ListOfOnixDataCompositeWithKey<DiscountCoded, JonixDiscountCoded, DiscountCodeTypes> discountCodeds =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<DiscountCoded, JonixDiscountCoded, DiscountCodeTypes> discountCodeds() {
        initialize();
        return discountCodeds;
    }

    private ListOfOnixDataComposite<Discount, JonixDiscount> discounts = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Discount, JonixDiscount> discounts() {
        initialize();
        return discounts;
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
     * (this field is optional)
     */
    public PriceAmount priceAmount() {
        initialize();
        return priceAmount;
    }

    private PriceCoded priceCoded = PriceCoded.EMPTY;

    /**
     * (this field is optional)
     */
    public PriceCoded priceCoded() {
        initialize();
        return priceCoded;
    }

    private ListOfOnixDataComposite<Tax, JonixTax> taxs = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Tax, JonixTax> taxs() {
        initialize();
        return taxs;
    }

    private CurrencyCode currencyCode = CurrencyCode.EMPTY;

    /**
     * (this field is optional)
     */
    public CurrencyCode currencyCode() {
        initialize();
        return currencyCode;
    }

    private Territory territory = Territory.EMPTY;

    /**
     * (this field is optional)
     */
    public Territory territory() {
        initialize();
        return territory;
    }

    private CurrencyZone currencyZone = CurrencyZone.EMPTY;

    /**
     * (this field is optional)
     */
    public CurrencyZone currencyZone() {
        initialize();
        return currencyZone;
    }

    private List<ComparisonProductPrice> comparisonProductPrices = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<ComparisonProductPrice> comparisonProductPrices() {
        initialize();
        return comparisonProductPrices;
    }

    private ListOfOnixDataCompositeWithKey<PriceDate, JonixPriceDate, PriceDateRoles> priceDates =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<PriceDate, JonixPriceDate, PriceDateRoles> priceDates() {
        initialize();
        return priceDates;
    }

    private PrintedOnProduct printedOnProduct = PrintedOnProduct.EMPTY;

    /**
     * (this field is optional)
     */
    public PrintedOnProduct printedOnProduct() {
        initialize();
        return printedOnProduct;
    }

    private PositionOnProduct positionOnProduct = PositionOnProduct.EMPTY;

    /**
     * (this field is optional)
     */
    public PositionOnProduct positionOnProduct() {
        initialize();
        return positionOnProduct;
    }
}
