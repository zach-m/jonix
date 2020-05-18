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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.ReturnsConditionsCodeTypes;
import com.tectonica.jonix.common.codelist.SupplierOwnCodeTypes;
import com.tectonica.jonix.common.codelist.SupplyDateRoles;
import com.tectonica.jonix.common.struct.JonixReturnsConditions;
import com.tectonica.jonix.common.struct.JonixSupplierOwnCoding;
import com.tectonica.jonix.common.struct.JonixSupplyDate;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supply detail composite</h1>
 * <p>
 * A group of data elements which together give details of a supply source, and price and availability from that source.
 * Mandatory in each occurrence of the &lt;ProductSupply&gt; block and repeatable to give details of multiple supply
 * sources.
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
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ProductSupply}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail}</li>
 * </ul>
 */
public class SupplyDetail implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SupplyDetail";
    public static final String shortname = "supplydetail";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    /**
     * (type: dt.NonEmptyString)
     */
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
                case Supplier.refname:
                case Supplier.shortname:
                    supplier = new Supplier(e);
                    break;
                case ProductAvailability.refname:
                case ProductAvailability.shortname:
                    productAvailability = new ProductAvailability(e);
                    break;
                case OrderTime.refname:
                case OrderTime.shortname:
                    orderTime = new OrderTime(e);
                    break;
                case NewSupplier.refname:
                case NewSupplier.shortname:
                    newSupplier = new NewSupplier(e);
                    break;
                case PackQuantity.refname:
                case PackQuantity.shortname:
                    packQuantity = new PackQuantity(e);
                    break;
                case PalletQuantity.refname:
                case PalletQuantity.shortname:
                    palletQuantity = new PalletQuantity(e);
                    break;
                case OrderQuantityMultiple.refname:
                case OrderQuantityMultiple.shortname:
                    orderQuantityMultiple = new OrderQuantityMultiple(e);
                    break;
                case UnpricedItemType.refname:
                case UnpricedItemType.shortname:
                    unpricedItemType = new UnpricedItemType(e);
                    break;
                case Reissue.refname:
                case Reissue.shortname:
                    reissue = new Reissue(e);
                    break;
                case SupplyContact.refname:
                case SupplyContact.shortname:
                    supplyContacts = JPU.addToList(supplyContacts, new SupplyContact(e));
                    break;
                case SupplierOwnCoding.refname:
                case SupplierOwnCoding.shortname:
                    supplierOwnCodings = JPU.addToList(supplierOwnCodings, new SupplierOwnCoding(e));
                    break;
                case ReturnsConditions.refname:
                case ReturnsConditions.shortname:
                    returnsConditionss = JPU.addToList(returnsConditionss, new ReturnsConditions(e));
                    break;
                case SupplyDate.refname:
                case SupplyDate.shortname:
                    supplyDates = JPU.addToList(supplyDates, new SupplyDate(e));
                    break;
                case Stock.refname:
                case Stock.shortname:
                    stocks = JPU.addToList(stocks, new Stock(e));
                    break;
                case OrderQuantityMinimum.refname:
                case OrderQuantityMinimum.shortname:
                    orderQuantityMinimums = JPU.addToList(orderQuantityMinimums, new OrderQuantityMinimum(e));
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

    private Supplier supplier = Supplier.EMPTY;

    /**
     * <p>
     * A group of data elements which together identify a specific supplier. Mandatory in each occurrence of the
     * &lt;SupplyDetail&gt; composite, and not repeatable.
     * </p>
     * Jonix-Comment: this field is required
     */
    public Supplier supplier() {
        _initialize();
        return supplier;
    }

    private ProductAvailability productAvailability = ProductAvailability.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the availability of a product from a supplier. Mandatory in each occurrence of the
     * &lt;SupplyDetail&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ProductAvailability productAvailability() {
        _initialize();
        return productAvailability;
    }

    private OrderTime orderTime = OrderTime.EMPTY;

    /**
     * <p>
     * The expected average number of days from receipt of order to despatch (for items ‘manufactured on demand’ or
     * ‘only to order’). Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public OrderTime orderTime() {
        _initialize();
        return orderTime;
    }

    private NewSupplier newSupplier = NewSupplier.EMPTY;

    /**
     * <p>
     * An optional group of data elements which together specify a new supply source to which orders are referred. Use
     * only when the code in &lt;ProductAvailability&gt; indicates ‘no longer available from us, refer to new supplier’.
     * Only one occurrence of the composite is permitted in this context.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NewSupplier newSupplier() {
        _initialize();
        return newSupplier;
    }

    private PackQuantity packQuantity = PackQuantity.EMPTY;

    /**
     * <p>
     * The quantity in each carton or binder’s pack in stock currently held by the supplier. Optional and non-repeating.
     * </p>
     * <p>
     * Note that orders do not <em>have</em> to be aligned with multiples of the pack size, but such orders may be more
     * convenient to handle.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PackQuantity packQuantity() {
        _initialize();
        return packQuantity;
    }

    private PalletQuantity palletQuantity = PalletQuantity.EMPTY;

    /**
     * <p>
     * The quantity (number of copies) on each complete pallet in stock currently held by the supplier. Optional and
     * non-repeating. Of course, orders do not have to be aligned to the pallet quantity, but for bulk orders, it may be
     * useful to know how many pallets will be required for a delivery.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PalletQuantity palletQuantity() {
        _initialize();
        return palletQuantity;
    }

    private OrderQuantityMultiple orderQuantityMultiple = OrderQuantityMultiple.EMPTY;

    /**
     * <p>
     * The order quantity multiple that must be used in any order for the product placed with the supplier. Optional,
     * but where supplied, must be preceded by at least one &lt;OrderQuantityMinimum&gt; element. For example with a
     * minimum order quantity of 6 and a multiple of 4, orders for 6, 10 or 14 copies are acceptable, but orders for
     * fewer than 6, or for 7, 8, 9 or 11 copies are not. If omitted, the minimum or any larger quantity may be ordered.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public OrderQuantityMultiple orderQuantityMultiple() {
        _initialize();
        return orderQuantityMultiple;
    }

    private UnpricedItemType unpricedItemType = UnpricedItemType.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the product is free of charge, or a reason why a price is not sent. <em>If code
     * value 02 is used to send advance information without giving a price, the price must be confirmed as soon as
     * possible.</em> Optional and non-repeating, but required if the &lt;SupplyDetail&gt; composite does not carry a
     * price.
     * </p>
     * <p>
     * Use here in preference to P.26.70a when the product is available <em>only</em> under free of charge or unpriced
     * terms from the supplier.
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
     * An optional and non-repeating group of data elements which together specify that a product is to be reissued
     * within the market to which the &lt;SupplyDetail&gt; composite applies.
     * </p>
     * <p>
     * The entire &lt;Reissue&gt; composite is deprecated. Suppliers should supply information about planned reissues in
     * other parts of the Product record – the date of a planned reissue in &lt;PublishingDate&gt; and/or in
     * &lt;MarketDate&gt;, and new collateral material alongside old collateral in
     * <a href="#onixmessage_product_collateraldetail">Block&nbsp;2</a> where collateral items may be associated with
     * appropriate end and start dates using &lt;ContentDate&gt;.
     * </p>
     * <p>
     * The &lt;Reissue&gt; composite was (prior to deprecation) used only when the publisher intended to re-launch the
     * product under the same ISBN. There are two possible cases:
     * </p>
     * <ol>
     * <li>When the product is unavailable during the period immediately before reissue. In this case,
     * &lt;ProductAvailability&gt; should carry the value 33 for ‘unavailable, awaiting reissue’, and the ONIX record
     * can be updated to describe the reissued product as soon as details can be made available;</li>
     * <li>When the product is still available during the period up to the reissue date. In this case, the ONIX record
     * should continue to describe the existing product and the &lt;ProductAvailability&gt; value should continue to
     * record the product as ‘available’ (<i>eg</i> code 21) right up to the reissue date. At that date, the record
     * should be updated to describe the reissued product, with the &lt;ProductAvailability&gt; value usually remaining
     * unchanged.</li>
     * </ol>
     * <p>
     * After reissue, the &lt;Reissue&gt; composite can be retained as a permanent element of the ONIX record, carrying
     * only the &lt;ReissueDate&gt; element, which will then indicate ‘date last reissued’.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Reissue reissue() {
        _initialize();
        return reissue;
    }

    private List<SupplyContact> supplyContacts = Collections.emptyList();

    /**
     * <p>
     * An optional group of data elements which together specify an organization (which may or may not be the supplier)
     * responsible for dealing with enquiries related to the product. Repeatable in order to specify multiple contacts.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<SupplyContact> supplyContacts() {
        _initialize();
        return supplyContacts;
    }

    private ListOfOnixDataCompositeWithKey<SupplierOwnCoding, JonixSupplierOwnCoding,
        SupplierOwnCodeTypes> supplierOwnCodings = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * An optional and repeatable group of data elements which together allow a supplier to send coded data of a
     * specified type, using its own coding schemes.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<SupplierOwnCoding, JonixSupplierOwnCoding, SupplierOwnCodeTypes>
        supplierOwnCodings() {
        _initialize();
        return supplierOwnCodings;
    }

    private ListOfOnixDataCompositeWithKey<ReturnsConditions, JonixReturnsConditions,
        ReturnsConditionsCodeTypes> returnsConditionss = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * An optional and repeatable group of data elements which together allow the supplier’s returns conditions to be
     * specified in coded form.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ReturnsConditions, JonixReturnsConditions, ReturnsConditionsCodeTypes>
        returnsConditionss() {
        _initialize();
        return returnsConditionss;
    }

    private ListOfOnixDataCompositeWithKey<SupplyDate, JonixSupplyDate, SupplyDateRoles> supplyDates =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * An optional group of data elements which together specify a date associated with the supply status of the
     * product, <i>eg</i> expected ship date. Repeatable in order to specify multiple dates.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<SupplyDate, JonixSupplyDate, SupplyDateRoles> supplyDates() {
        _initialize();
        return supplyDates;
    }

    private List<Stock> stocks = Collections.emptyList();

    /**
     * <p>
     * An optional group of data elements which together specify a quantity of stock, repeatable where a supplier has
     * more than one warehouse or supplier location.
     * </p>
     * <p>
     * Within a single instance of the &lt;Stock&gt; composite, the location name and identifier are both optional. If
     * &lt;Stock&gt; is repeated, at least one identifier or a location name must be included in each instance.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<Stock> stocks() {
        _initialize();
        return stocks;
    }

    private ListOfOnixElement<OrderQuantityMinimum, Integer> orderQuantityMinimums = ListOfOnixElement.empty();

    /**
     * <p>
     * The minimum quantity of the product that may be ordered in a single order placed with the supplier. Optional. If
     * omitted, any number may be ordered.
     * </p>
     * <p>
     * If supplied without a succeeding Minimum initial order quantity, the Minimum order quantity applies to all orders
     * for the product. If followed by a Minimum initial order quantity, the Minimum order quantity applies to the
     * second and subsequent orders for the product.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<OrderQuantityMinimum, Integer> orderQuantityMinimums() {
        _initialize();
        return orderQuantityMinimums;
    }

    private List<Price> prices = Collections.emptyList();

    /**
     * <p>
     * An optional group of data elements which together specify a unit price, repeatable in order to specify multiple
     * prices. Each &lt;SupplyDetail&gt; composite must include <em>either</em> one or more prices, <em>or</em> a single
     * &lt;UnpricedItemType&gt; element (see&nbsp;P.26.42).
     * </p>
     * <p>
     * Where multiple prices are specified for a product, each price option should specify a distinct combination of its
     * terms of trade and the group of end customers it is applicable to, any relevant price conditions, periods of
     * time, currency and territory <i>etc</i>, so that the data recipient can clearly select the correct pricing
     * option. If, under a particular combination, the product is free of charge or its price is not yet set, an
     * &lt;UnpricedItemType&gt; element (P.26.70a) must be used in place of a &lt;PriceAmount&gt;. Each pricing option
     * may optionally be given an identifier for use in subsequent revenue reporting or for other internal purposes.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<Price> prices() {
        _initialize();
        return prices;
    }
}
