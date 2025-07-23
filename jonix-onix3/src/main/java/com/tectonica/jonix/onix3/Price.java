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
import com.tectonica.jonix.common.ListOfOnixCodelist;
import com.tectonica.jonix.common.ListOfOnixComposite;
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.DiscountCodeTypes;
import com.tectonica.jonix.common.codelist.EpublicationTechnicalProtections;
import com.tectonica.jonix.common.codelist.PriceDateRoles;
import com.tectonica.jonix.common.codelist.PriceIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixBatchBonus;
import com.tectonica.jonix.common.struct.JonixDiscount;
import com.tectonica.jonix.common.struct.JonixDiscountCoded;
import com.tectonica.jonix.common.struct.JonixPriceDate;
import com.tectonica.jonix.common.struct.JonixPriceIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Price composite</h1>
 * <p>
 * An optional group of data elements which together specify a unit price, repeatable in order to specify multiple
 * prices. Each &lt;SupplyDetail&gt; composite must include <em>either</em> one or more prices, <em>or</em> a single
 * &lt;UnpricedItemType&gt; element (see&nbsp;P.26.42).
 * </p>
 * <p>
 * Where multiple prices are specified for a product, each price option should specify a distinct combination of its
 * terms of trade and the group of end customers it is applicable to, any relevant price conditions, periods of time,
 * currency and territory <i>etc</i>, so that the data recipient can clearly select the correct pricing option. If,
 * under a particular combination, the product is free of charge or its price is not yet set, an
 * &lt;UnpricedItemType&gt; element (P.26.70b) must be used in place of a &lt;PriceAmount&gt;. Each pricing option may
 * optionally be given an identifier for use in subsequent revenue reporting or for other internal purposes.
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
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Price&gt; from the schema author:
 *
 * Details of a price applied to the product &#9679; Added &lt;TaxExempt&gt; at revision 3.0.5 &#9679; Added
 * &lt;EpubTechnicalProtection&gt; and &lt;EpubLicense&gt; at revision 3.0.4 &#9679; Added &lt;UnpricedItemType&gt;,
 * &lt;PriceConstraint&gt;, &lt; at revision 3.0.3 &#9679; Added &lt;PriceIdentifier&gt; at revision 3.0.2 &#9679;
 * Modified cardinality of &lt;PriceTypeDescription&gt; at revision 3.0.1 &#9679; Added &lt;PriceCoded&gt;,
 * &lt;ComparisonProductPrice&gt; at revision 3.0 (2010)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Reissue}&gt;</li>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price}</li>
 * </ul>
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
                case PriceType.refname:
                case PriceType.shortname:
                    priceType = new PriceType(e);
                    break;
                case PriceQualifier.refname:
                case PriceQualifier.shortname:
                    priceQualifier = new PriceQualifier(e);
                    break;
                case EpubLicense.refname:
                case EpubLicense.shortname:
                    epubLicense = new EpubLicense(e);
                    break;
                case PricePer.refname:
                case PricePer.shortname:
                    pricePer = new PricePer(e);
                    break;
                case MinimumOrderQuantity.refname:
                case MinimumOrderQuantity.shortname:
                    minimumOrderQuantity = new MinimumOrderQuantity(e);
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
                case TaxExempt.refname:
                case TaxExempt.shortname:
                    taxExempt = new TaxExempt(e);
                    break;
                case UnpricedItemType.refname:
                case UnpricedItemType.shortname:
                    unpricedItemType = new UnpricedItemType(e);
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
                case PrintedOnProduct.refname:
                case PrintedOnProduct.shortname:
                    printedOnProduct = new PrintedOnProduct(e);
                    break;
                case PositionOnProduct.refname:
                case PositionOnProduct.shortname:
                    positionOnProduct = new PositionOnProduct(e);
                    break;
                case PriceIdentifier.refname:
                case PriceIdentifier.shortname:
                    priceIdentifiers = JPU.addToList(priceIdentifiers, new PriceIdentifier(e));
                    break;
                case EpubTechnicalProtection.refname:
                case EpubTechnicalProtection.shortname:
                    epubTechnicalProtections = JPU.addToList(epubTechnicalProtections, new EpubTechnicalProtection(e));
                    break;
                case PriceConstraint.refname:
                case PriceConstraint.shortname:
                    priceConstraints = JPU.addToList(priceConstraints, new PriceConstraint(e));
                    break;
                case PriceTypeDescription.refname:
                case PriceTypeDescription.shortname:
                    priceTypeDescriptions = JPU.addToList(priceTypeDescriptions, new PriceTypeDescription(e));
                    break;
                case PriceCondition.refname:
                case PriceCondition.shortname:
                    priceConditions = JPU.addToList(priceConditions, new PriceCondition(e));
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
                case Tax.refname:
                case Tax.shortname:
                    taxs = JPU.addToList(taxs, new Tax(e));
                    break;
                case ComparisonProductPrice.refname:
                case ComparisonProductPrice.shortname:
                    comparisonProductPrices = JPU.addToList(comparisonProductPrices, new ComparisonProductPrice(e));
                    break;
                case PriceDate.refname:
                case PriceDate.shortname:
                    priceDates = JPU.addToList(priceDates, new PriceDate(e));
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

    public void ifExists(Consumer<Price> action) {
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

    private PriceType priceType = PriceType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the type of the price in the &lt;PriceAmount&gt; field within the &lt;Price&gt;
     * composite. Optional, provided that a &lt;DefaultPriceType&gt; has been specified in the message header, and
     * non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public PriceType priceType() {
        _initialize();
        return priceType;
    }

    private PriceQualifier priceQualifier = PriceQualifier.EMPTY;

    /**
     * <p>
     * An ONIX code which further specifies the type of price, <i>eg</i>&nbsp;member price, reduced price when purchased
     * as part of a set. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public PriceQualifier priceQualifier() {
        _initialize();
        return priceQualifier;
    }

    private EpubLicense epubLicense = EpubLicense.EMPTY;

    /**
     * <p>
     * An optional and non-repeatable composite carrying the name or title of the usage license forming part of the
     * commercial offer for the product, and a link to the license terms in eye-readable or machine-readable form.
     * </p>
     * JONIX adds: this field is optional
     */
    public EpubLicense epubLicense() {
        _initialize();
        return epubLicense;
    }

    private PricePer pricePer = PricePer.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the unit of product which is the basis for the price carried in an occurrence of the
     * &lt;Price&gt; composite. Optional and non-repeating. Where the price applies to a copy of the whole product, this
     * field is normally omitted.
     * </p>
     * JONIX adds: this field is optional
     */
    public PricePer pricePer() {
        _initialize();
        return pricePer;
    }

    private MinimumOrderQuantity minimumOrderQuantity = MinimumOrderQuantity.EMPTY;

    /**
     * <p>
     * The minimum number of copies which must be ordered to obtain the price carried in an occurrence of the
     * &lt;Price&gt; composite. Optional and non-repeating. If the field is present, the price is a quantity price (and
     * only whole multiples of the qualifying quantity may be ordered at that price). If the field is omitted, the price
     * applies to a single unit.
     * </p>
     * <p>
     * Note the similarity between &lt;MinimumOrderQuantity&gt; and &lt;OrderQuantityMinimum&gt; in P.26.41b: only
     * &lt;MinimumOrderQuantity&gt; has an effect on the specification of &lt;Price&gt;. Use of
     * &lt;MinimumOrderQuantity&gt; is close in effect to a multi-item trade pack (see &lt;ProductComposition&gt;).
     * </p>
     * JONIX adds: this field is optional
     */
    public MinimumOrderQuantity minimumOrderQuantity() {
        _initialize();
        return minimumOrderQuantity;
    }

    private PriceStatus priceStatus = PriceStatus.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the status of a price. Optional and non-repeating. If the field is omitted, the
     * default ‘unspecified’ will apply.
     * </p>
     * JONIX adds: this field is optional
     */
    public PriceStatus priceStatus() {
        _initialize();
        return priceStatus;
    }

    private PriceAmount priceAmount = PriceAmount.EMPTY;

    /**
     * <p>
     * The amount of a price, dependent on the &lt;PriceType&gt; and other elements present within the &lt;Price&gt;
     * composite. Optional and non-repeating, but each occurrence of the &lt;Price&gt; composite must include either a
     * &lt;PriceAmount&gt; or a &lt;PriceCoded&gt; composite, with optional tax details, or an &lt;UnpricedItemType&gt;
     * element. Note that free-of-charge products must use &lt;UnpricedItemType&gt; rather than a zero price.
     * </p>
     * JONIX adds: this field is optional
     */
    public PriceAmount priceAmount() {
        _initialize();
        return priceAmount;
    }

    private PriceCoded priceCoded = PriceCoded.EMPTY;

    /**
     * <p>
     * An optional group of data elements to carry a price that is expressed as one of a discrete set of price points,
     * tiers or bands, rather than actual currency amounts. Each occurrence of the &lt;Price&gt; composite must include
     * either a &lt;PriceAmount&gt; or a &lt;PriceCoded&gt; composite, with optional tax details, or an
     * &lt;UnpricedItemType&gt; element.
     * </p>
     * JONIX adds: this field is optional
     */
    public PriceCoded priceCoded() {
        _initialize();
        return priceCoded;
    }

    private TaxExempt taxExempt = TaxExempt.EMPTY;

    /**
     * <p>
     * An empty element that identifies a product price as being specifically exempted from tax. Optional, and used only
     * when &lt;PriceType&gt; indicates an exc-tax price.
     * </p>
     * <p>
     * Note that tax exempt status is rare: it applies in only a very few countries. Tax exempt is distinct from the
     * case where tax details are not specified (as is the case with most North American Prices) and also distinct from
     * the case where tax is levied at zero percent (as is the case for physical books in the UK, for example).
     * </p>
     * JONIX adds: this field is optional
     */
    public TaxExempt taxExempt() {
        _initialize();
        return taxExempt;
    }

    public boolean isTaxExempt() {
        return (taxExempt().exists());
    }

    private UnpricedItemType unpricedItemType = UnpricedItemType.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies that the product is free of charge, or a reason why a price amount or price code is
     * not sent. <em>If code value 02 is used to send advance information without giving a price, the price must be
     * confirmed as soon as possible.</em> Optional and non-repeating, but required if the &lt;Price&gt; composite does
     * not carry a price amount or price code.
     * </p>
     * <p>
     * Use here in preference to P.26.42 when the product is available under a variety of priced and unpriced terms from
     * the same supplier.
     * </p>
     * JONIX adds: this field is optional
     */
    public UnpricedItemType unpricedItemType() {
        _initialize();
        return unpricedItemType;
    }

    private CurrencyCode currencyCode = CurrencyCode.EMPTY;

    /**
     * <p>
     * An ISO standard code identifying the currency in which all monetary amounts in an occurrence of the &lt;Price&gt;
     * composite are stated. Optional and non-repeating, but required if the currency is not the default currency for
     * the message (which may be set in &lt;DefaultCurrencyCode&gt;). All ONIX messages must include an explicit
     * statement of the currency used for any prices. To avoid any possible ambiguity, it is strongly recommended that
     * the currency should be repeated here for each individual price.
     * </p>
     * JONIX adds: this field is optional
     */
    public CurrencyCode currencyCode() {
        _initialize();
        return currencyCode;
    }

    private Territory territory = Territory.EMPTY;

    /**
     * <p>
     * A group of data elements which together identify a territory within which the price stated in an occurrence of
     * the &lt;Price&gt; composite is applicable. Optional and non-repeating.
     * </p>
     * <p>
     * <strong>Additional guidance on the description of price territories in ONIX&nbsp;3.0 will be found in a separate
     * document <cite>ONIX for Books Product Information Message: How to Specify Markets and Suppliers in ONIX
     * 3</cite>.</strong>
     * </p>
     * JONIX adds: this field is optional
     */
    public Territory territory() {
        _initialize();
        return territory;
    }

    private CurrencyZone currencyZone = CurrencyZone.EMPTY;

    /**
     * <p>
     * An ONIX code identifying a currency zone in which the price stated in an occurrence of the &lt;Price&gt;
     * composite is applicable. Optional and non-repeating. Deprecated – use Country or Region codes instead.
     * </p>
     * JONIX adds: this field is optional
     */
    public CurrencyZone currencyZone() {
        _initialize();
        return currencyZone;
    }

    private PrintedOnProduct printedOnProduct = PrintedOnProduct.EMPTY;

    /**
     * <p>
     * An ONIX code indicating whether the price in a &lt;Price&gt; composite is printed on the product. Optional and
     * non-repeating. Omission of this element must <em>not</em> be interpreted as indicating that the price is not
     * printed on the product.
     * </p>
     * JONIX adds: this field is optional
     */
    public PrintedOnProduct printedOnProduct() {
        _initialize();
        return printedOnProduct;
    }

    private PositionOnProduct positionOnProduct = PositionOnProduct.EMPTY;

    /**
     * <p>
     * An ONIX code indicating a position on a product; in this case, the position in which a price appears. Optional,
     * but must be included if (and only if) the &lt;PrintedOnProduct&gt; element indicates that the price appears on
     * the product, even if the position is ‘unknown’. Non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public PositionOnProduct positionOnProduct() {
        _initialize();
        return positionOnProduct;
    }

    private ListOfOnixDataCompositeWithKey<PriceIdentifier, JonixPriceIdentifier,
        PriceIdentifierTypes> priceIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(PriceIdentifier.class);

    /**
     * <p>
     * An optional group of elements that provide an identifier for a particular price. For products that may be
     * available at potentially many different prices, to different groups of purchasers or under different terms and
     * conditions, this identifier may then be used in subsequent revenue reporting to specify which price the product
     * was traded at.
     * </p>
     * <p>
     * Note that the price identifier will always be proprietary and must be unique across multiple pricing options for
     * one product, but need not be unique across all products, nor need it be the same across all products offered at
     * the same price point or under the same terms.
     * </p>
     * <p>
     * The composite is repeatable in order to provide multiple identifiers for the same price.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<PriceIdentifier, JonixPriceIdentifier, PriceIdentifierTypes>
        priceIdentifiers() {
        _initialize();
        return priceIdentifiers;
    }

    private ListOfOnixCodelist<EpubTechnicalProtection, EpublicationTechnicalProtections> epubTechnicalProtections =
        ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code specifying whether a digital product has DRM or other technical protection features that form or
     * enforce part of the commercial offer for a product. Optional, and repeatable if a product has two or more kinds
     * of protection.
     * </p>
     * <p>
     * The Digital product technical protection element is also present in Group&nbsp;P.3. Use here where a single
     * product is available under multiple commercial offers with differing Price constraints, to indicate whether the
     * constraints are enforced via technical protection measures.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixCodelist<EpubTechnicalProtection, EpublicationTechnicalProtections> epubTechnicalProtections() {
        _initialize();
        return epubTechnicalProtections;
    }

    private ListOfOnixComposite<PriceConstraint> priceConstraints = JPU.emptyListOfOnixComposite(PriceConstraint.class);

    /**
     * <p>
     * An optional group of data elements which together describe a contractual term or constraint (or the absence of
     * such a constraint) that forms part of the commercial offer for a product. Repeatable in order to describe
     * multiple constraints on usage.
     * </p>
     * <p>
     * The Price constraint composite has the same structure as &lt;EpubUsageConstraint&gt;. Use
     * &lt;EpubUsageConstraint&gt; for constraints that limit the user experience of the product, whether or not they
     * are enforced by technical protection measures (DRM). Use &lt;PriceConstraint&gt; where a single product is
     * available under multiple terms and conditions (<i>ie</i>&nbsp;multiple commercial offers for the same product
     * which differ in their Price constraints, and whether or not they are enforced by DRM).
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<PriceConstraint> priceConstraints() {
        _initialize();
        return priceConstraints;
    }

    private ListOfOnixElement<PriceTypeDescription, String> priceTypeDescriptions = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text which further describes the price type, qualifier, constraints and other parameters of the price.
     * Optional, and repeatable if parallel descriptions are provided in multiple languages. The <i>language</i>
     * attribute is optional for a single instance of &lt;PriceTypeDescription&gt;, but must be included in each
     * instance if &lt;PriceTypeDescription&gt; is repeated in multiple languages. In the Netherlands and elsewhere,
     * when the &lt;PriceQualifier&gt; code identifies a ‘voucher price’, the &lt;PriceTypeDescription&gt; should give
     * the ‘EAN action number’ that identifies the offer.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<PriceTypeDescription, String> priceTypeDescriptions() {
        _initialize();
        return priceTypeDescriptions;
    }

    private ListOfOnixComposite<PriceCondition> priceConditions = JPU.emptyListOfOnixComposite(PriceCondition.class);

    /**
     * <p>
     * An optional group of data elements which together specify a condition relating to a price, repeatable in order to
     * specify multiple conditions.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<PriceCondition> priceConditions() {
        _initialize();
        return priceConditions;
    }

    private ListOfOnixDataComposite<BatchBonus, JonixBatchBonus> batchBonuss =
        JPU.emptyListOfOnixDataComposite(BatchBonus.class);

    /**
     * <p>
     * A repeatable group of data elements which together specify a batch bonus, <i>ie</i>&nbsp;a quantity of free
     * copies which are supplied (typically to a reseller) with a certain order quantity. The &lt;BatchBonus&gt;
     * composite is optional.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataComposite<BatchBonus, JonixBatchBonus> batchBonuss() {
        _initialize();
        return batchBonuss;
    }

    private ListOfOnixDataCompositeWithKey<DiscountCoded, JonixDiscountCoded, DiscountCodeTypes> discountCodeds =
        JPU.emptyListOfOnixDataCompositeWithKey(DiscountCoded.class);

    /**
     * <p>
     * An optional group of data elements which together define a discount code from a specified scheme, and repeatable
     * to allow different discount code schemes to be supported without defining additional data elements.
     * </p>
     * <p>
     * A discount code is generally used when the exact percentage discount (or commission, in an agency business model)
     * that a code represents may vary from reseller to reseller (or from agent to agent), or if terms must be kept
     * confidential. If the discount (or commission) is the same for all resellers (or agents) and need not be kept
     * confidential, use &lt;Discount&gt; and &lt;DiscountPercent&gt; instead.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<DiscountCoded, JonixDiscountCoded, DiscountCodeTypes> discountCodeds() {
        _initialize();
        return discountCodeds;
    }

    private ListOfOnixDataComposite<Discount, JonixDiscount> discounts =
        JPU.emptyListOfOnixDataComposite(Discount.class);

    /**
     * <p>
     * An optional group of data elements which together define a discount either as a percentage or as an absolute
     * amount. Repeatable in order to specify a more compex arrangement such as a progressive or tiered discount. Used
     * only when an ONIX message is sent within the context of a specific trading relationship.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataComposite<Discount, JonixDiscount> discounts() {
        _initialize();
        return discounts;
    }

    private ListOfOnixComposite<Tax> taxs = JPU.emptyListOfOnixComposite(Tax.class);

    /**
     * <p>
     * A repeatable group of data elements which together specify tax included within a price amount. Optional, and used
     * only when &lt;PriceType&gt; indicates an inc-tax price. For items to which different taxes or tax rates apply
     * (<i>eg</i>&nbsp;mixed media products in the UK which are partly taxed at standard rate and partly at zero rate),
     * the composite is repeated for each separate tax or tax rate. Although only one of &lt;TaxRatePercent&gt; or
     * &lt;TaxAmount&gt; is mandatory within the composite, it is recommended that all tax elements in the composite
     * should be explicitly populated.
     * </p>
     * <p>
     * If the tax regime requires separate tax rates and amounts linked explicitly to particular product parts
     * (<i>eg</i>&nbsp;in Germany), the &lt;ProductIdentifier&gt; composite may be included in each &lt;Tax&gt;
     * composite. Where tax is payable on multiple product parts, each should have its own instance of the &lt;Tax&gt;
     * composite.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<Tax> taxs() {
        _initialize();
        return taxs;
    }

    private ListOfOnixComposite<ComparisonProductPrice> comparisonProductPrices =
        JPU.emptyListOfOnixComposite(ComparisonProductPrice.class);

    /**
     * <p>
     * Optional group of data elements that together define a price for a directly comparable product, to facilitate
     * supply of price data to retailers who do not receive a full ONIX record for that comparable product. This is
     * primarily intended for use within a &lt;Product&gt; record for a digital product, to provide a price for a
     * comparable physical product. The composite is repeatable in order to define multiple comparison prices.
     * </p>
     * <p>
     * Those using this composite should be wary of the volatile nature of product prices: special note should be taken
     * of the risk of stale data being stored in data recipients’ systems when prices for the comparison product are
     * updated, as those updates to the comparison product may occur outside the context of the main product being
     * described in the &lt;Product&gt; record. Because of this, ONIX suppliers are cautioned of the risk of
     * contradictory data in separate data feeds. <em>This composite should not be supplied unless specifically
     * requested by a particular recipient.</em>
     * </p>
     * <p>
     * The inclusion of a comparison price in itself implies nothing about the availability or status of the comparable
     * product. However, there may be legal requirements in particular territories relating to the use of comparison
     * prices in promotion that users of this data must comply with.
     * </p>
     * <p>
     * Note that the comparison product price composite does not include all the features of the &lt;Price&gt;
     * composite: for example, &lt;PriceQualifier&gt; is not included. Thus data providers should ensure that any
     * conditions attached to the comparison product price are such that it is directly comparable to the price of the
     * main product being described.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<ComparisonProductPrice> comparisonProductPrices() {
        _initialize();
        return comparisonProductPrices;
    }

    private ListOfOnixDataCompositeWithKey<PriceDate, JonixPriceDate, PriceDateRoles> priceDates =
        JPU.emptyListOfOnixDataCompositeWithKey(PriceDate.class);

    /**
     * <p>
     * An optional group of data elements which together specify a date associated with a price, repeatable in order to
     * specify multiple associated dates.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<PriceDate, JonixPriceDate, PriceDateRoles> priceDates() {
        _initialize();
        return priceDates;
    }
}
