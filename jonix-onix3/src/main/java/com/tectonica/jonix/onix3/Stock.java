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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.StockQuantityCodeTypes;
import com.tectonica.jonix.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.struct.JonixLocationIdentifier;
import com.tectonica.jonix.struct.JonixOnOrderDetail;
import com.tectonica.jonix.struct.JonixStockQuantityCoded;
import com.tectonica.jonix.struct.JonixVelocity;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Stock quantity composite</h1><p>An optional group of data elements which together specify a quantity of stock,
 * repeatable where a supplier has more than one warehouse or supplier location.</p><p>Within a single instance of the
 * &lt;Stock&gt; composite, the location name and identifier are both optional. If &lt;Stock&gt; is repeated, at least
 * one identifier or a location name must be included in each instance.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;Stock&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;stock&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class Stock implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Stock";
    public static final String shortname = "stock";

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
    public static final Stock EMPTY = new Stock();

    public Stock() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Stock(org.w3c.dom.Element element) {
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
                case LocationIdentifier.refname:
                case LocationIdentifier.shortname:
                    locationIdentifiers = JPU.addToList(locationIdentifiers, new LocationIdentifier(e));
                    break;
                case LocationName.refname:
                case LocationName.shortname:
                    locationNames = JPU.addToList(locationNames, new LocationName(e));
                    break;
                case StockQuantityCoded.refname:
                case StockQuantityCoded.shortname:
                    stockQuantityCodeds = JPU.addToList(stockQuantityCodeds, new StockQuantityCoded(e));
                    break;
                case OnHand.refname:
                case OnHand.shortname:
                    onHand = new OnHand(e);
                    break;
                case Proximity.refname:
                case Proximity.shortname:
                    proximity = new Proximity(e);
                    break;
                case Reserved.refname:
                case Reserved.shortname:
                    reserved = new Reserved(e);
                    break;
                case OnOrder.refname:
                case OnOrder.shortname:
                    onOrder = new OnOrder(e);
                    break;
                case CBO.refname:
                case CBO.shortname:
                    cbo = new CBO(e);
                    break;
                case OnOrderDetail.refname:
                case OnOrderDetail.shortname:
                    onOrderDetails = JPU.addToList(onOrderDetails, new OnOrderDetail(e));
                    break;
                case Velocity.refname:
                case Velocity.shortname:
                    velocitys = JPU.addToList(velocitys, new Velocity(e));
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

    private ListOfOnixDataCompositeWithKey<LocationIdentifier, JonixLocationIdentifier, SupplierIdentifierTypes>
        locationIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<LocationIdentifier, JonixLocationIdentifier, SupplierIdentifierTypes> locationIdentifiers() {
        _initialize();
        return locationIdentifiers;
    }

    private ListOfOnixElement<LocationName, String> locationNames = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<LocationName, String> locationNames() {
        _initialize();
        return locationNames;
    }

    private ListOfOnixDataCompositeWithKey<StockQuantityCoded, JonixStockQuantityCoded, StockQuantityCodeTypes>
        stockQuantityCodeds = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<StockQuantityCoded, JonixStockQuantityCoded, StockQuantityCodeTypes> stockQuantityCodeds() {
        _initialize();
        return stockQuantityCodeds;
    }

    private OnHand onHand = OnHand.EMPTY;

    /**
     * (this field is required)
     */
    public OnHand onHand() {
        _initialize();
        return onHand;
    }

    private Proximity proximity = Proximity.EMPTY;

    /**
     * (this field is optional)
     */
    public Proximity proximity() {
        _initialize();
        return proximity;
    }

    private Reserved reserved = Reserved.EMPTY;

    /**
     * (this field is optional)
     */
    public Reserved reserved() {
        _initialize();
        return reserved;
    }

    private OnOrder onOrder = OnOrder.EMPTY;

    /**
     * (this field is optional)
     */
    public OnOrder onOrder() {
        _initialize();
        return onOrder;
    }

    private CBO cbo = CBO.EMPTY;

    /**
     * (this field is optional)
     */
    public CBO cbo() {
        _initialize();
        return cbo;
    }

    private ListOfOnixDataComposite<OnOrderDetail, JonixOnOrderDetail> onOrderDetails = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<OnOrderDetail, JonixOnOrderDetail> onOrderDetails() {
        _initialize();
        return onOrderDetails;
    }

    private ListOfOnixDataComposite<Velocity, JonixVelocity> velocitys = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Velocity, JonixVelocity> velocitys() {
        _initialize();
        return velocitys;
    }
}
