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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ReturnsConditionsCodeTypes;
import com.tectonica.jonix.codelist.SupplierOwnCodeTypes;
import com.tectonica.jonix.codelist.SupplyDateRoles;
import com.tectonica.jonix.struct.JonixReturnsConditions;
import com.tectonica.jonix.struct.JonixSupplierOwnCoding;
import com.tectonica.jonix.struct.JonixSupplyDate;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supply detail composite</h1><p>A group of data elements which together give details of a supply source, and price
 * and availability from that source. Mandatory in each occurrence of the &lt;ProductSupply&gt; block and
 * repeatable.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;SupplyDetail&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;supplydetail&gt;</td></tr><tr><td>Cardinality</td><td>1&#8230;n</td></tr></table>
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
                case SupplierOwnCoding.refname:
                case SupplierOwnCoding.shortname:
                    supplierOwnCodings = JPU.addToList(supplierOwnCodings, new SupplierOwnCoding(e));
                    break;
                case ReturnsConditions.refname:
                case ReturnsConditions.shortname:
                    returnsConditionss = JPU.addToList(returnsConditionss, new ReturnsConditions(e));
                    break;
                case ProductAvailability.refname:
                case ProductAvailability.shortname:
                    productAvailability = new ProductAvailability(e);
                    break;
                case SupplyDate.refname:
                case SupplyDate.shortname:
                    supplyDates = JPU.addToList(supplyDates, new SupplyDate(e));
                    break;
                case OrderTime.refname:
                case OrderTime.shortname:
                    orderTime = new OrderTime(e);
                    break;
                case NewSupplier.refname:
                case NewSupplier.shortname:
                    newSupplier = new NewSupplier(e);
                    break;
                case Stock.refname:
                case Stock.shortname:
                    stocks = JPU.addToList(stocks, new Stock(e));
                    break;
                case PackQuantity.refname:
                case PackQuantity.shortname:
                    packQuantity = new PackQuantity(e);
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

    private Supplier supplier = Supplier.EMPTY;

    /**
     * (this field is required)
     */
    public Supplier supplier() {
        _initialize();
        return supplier;
    }

    private ListOfOnixDataCompositeWithKey<SupplierOwnCoding, JonixSupplierOwnCoding, SupplierOwnCodeTypes>
        supplierOwnCodings = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<SupplierOwnCoding, JonixSupplierOwnCoding, SupplierOwnCodeTypes> supplierOwnCodings() {
        _initialize();
        return supplierOwnCodings;
    }

    private ListOfOnixDataCompositeWithKey<ReturnsConditions, JonixReturnsConditions, ReturnsConditionsCodeTypes>
        returnsConditionss = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ReturnsConditions, JonixReturnsConditions, ReturnsConditionsCodeTypes> returnsConditionss() {
        _initialize();
        return returnsConditionss;
    }

    private ProductAvailability productAvailability = ProductAvailability.EMPTY;

    /**
     * (this field is required)
     */
    public ProductAvailability productAvailability() {
        _initialize();
        return productAvailability;
    }

    private ListOfOnixDataCompositeWithKey<SupplyDate, JonixSupplyDate, SupplyDateRoles> supplyDates =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<SupplyDate, JonixSupplyDate, SupplyDateRoles> supplyDates() {
        _initialize();
        return supplyDates;
    }

    private OrderTime orderTime = OrderTime.EMPTY;

    /**
     * (this field is optional)
     */
    public OrderTime orderTime() {
        _initialize();
        return orderTime;
    }

    private NewSupplier newSupplier = NewSupplier.EMPTY;

    /**
     * (this field is optional)
     */
    public NewSupplier newSupplier() {
        _initialize();
        return newSupplier;
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
