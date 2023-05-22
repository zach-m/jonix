/*
 * Copyright (C) 2012-2023 Zach Melamed
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
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.StockQuantityCodeTypes;
import com.tectonica.jonix.common.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixLocationIdentifier;
import com.tectonica.jonix.common.struct.JonixOnOrderDetail;
import com.tectonica.jonix.common.struct.JonixStockQuantityCoded;
import com.tectonica.jonix.common.struct.JonixVelocity;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Stock quantity composite</h1>
 * <p>
 * An optional group of data elements which together specify a quantity of stock, repeatable where a supplier has more
 * than one warehouse or supplier location.
 * </p>
 * <p>
 * Within a single instance of the &lt;Stock&gt; composite, the location name and identifier are both optional. If
 * &lt;Stock&gt; is repeated, at least one identifier or a location name must be included in each instance.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Stock&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;stock&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Stock}</li>
 * </ul>
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

    /**
     * @return whether this tag (&lt;Stock&gt; or &lt;stock&gt;) is explicitly provided in the ONIX XML
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

    private OnHand onHand = OnHand.EMPTY;

    /**
     * <p>
     * The quantity of stock on hand and available to fulfill new orders. Either &lt;StockQuantityCoded&gt; or
     * &lt;OnHand&gt; is mandatory in each occurrence of the &lt;Stock&gt; composite, even if the quantity on hand is
     * zero. Non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public OnHand onHand() {
        _initialize();
        return onHand;
    }

    private Proximity proximity = Proximity.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the precision of the stock quantity on hand. Optional, non-repeating and may only be
     * used if an &lt;OnHand&gt; value is specified.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Proximity proximity() {
        _initialize();
        return proximity;
    }

    private Reserved reserved = Reserved.EMPTY;

    /**
     * <p>
     * The quantity of stock on hand but unavailable to fulfil new orders for any reason – for example because the stock
     * is reserved to fulfill existing orders or frozen to prevent dispatch. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Reserved reserved() {
        _initialize();
        return reserved;
    }

    private OnOrder onOrder = OnOrder.EMPTY;

    /**
     * <p>
     * The quantity of stock on order. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public OnOrder onOrder() {
        _initialize();
        return onOrder;
    }

    private CBO cbo = CBO.EMPTY;

    /**
     * <p>
     * The quantity of stock on order which is already committed to meet backorders. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CBO cbo() {
        _initialize();
        return cbo;
    }

    private ListOfOnixDataCompositeWithKey<LocationIdentifier, JonixLocationIdentifier,
        SupplierIdentifierTypes> locationIdentifiers =
            JPU.emptyListOfOnixDataCompositeWithKey(LocationIdentifier.class);

    /**
     * <p>
     * An optional group of data elements which together define the identifier of a stock location in accordance with a
     * specified scheme, and repeatable to allow different types of location identifier to be supported without defining
     * additional data elements.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<LocationIdentifier, JonixLocationIdentifier, SupplierIdentifierTypes>
        locationIdentifiers() {
        _initialize();
        return locationIdentifiers;
    }

    private ListOfOnixElement<LocationName, String> locationNames = JPU.emptyListOfOnixElement(LocationName.class);

    /**
     * <p>
     * The name of a stock location. Optional, and repeatable to provide parallel names for a single location in
     * multiple languages (<i>eg</i> <span lang="ga">Baile Átha Cliath</span> and Dublin, or
     * <span lang="fr">Bruxelles</span> and <span lang="nl">Brussel</span>). It may if necessary include a postal code
     * (<i>eg</i> <span lang="el">10680 Αθήνα</span>, or <span lang="it">20090 Assago</span>). The <i>language</i>
     * attribute is optional for a single instance of &lt;LocationName&gt;, but must be included in each instance if
     * &lt;LocationName&gt; is repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<LocationName, String> locationNames() {
        _initialize();
        return locationNames;
    }

    private ListOfOnixDataCompositeWithKey<StockQuantityCoded, JonixStockQuantityCoded,
        StockQuantityCodeTypes> stockQuantityCodeds = JPU.emptyListOfOnixDataCompositeWithKey(StockQuantityCoded.class);

    /**
     * <p>
     * A group of data elements which together specify a stock level in a coded way without stating the exact quantity
     * of stock. Either &lt;StockQuantityCoded&gt; or &lt;OnHand&gt; is mandatory in each occurrence of the
     * &lt;Stock&gt; composite, even if the quantity on hand is zero. Repeatable, so that it is possible to provide
     * coded quantities on hand, quantities on order <i>etc</i> separately.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<StockQuantityCoded, JonixStockQuantityCoded, StockQuantityCodeTypes>
        stockQuantityCodeds() {
        _initialize();
        return stockQuantityCodeds;
    }

    private ListOfOnixDataComposite<OnOrderDetail, JonixOnOrderDetail> onOrderDetails =
        JPU.emptyListOfOnixDataComposite(OnOrderDetail.class);

    /**
     * <p>
     * A repeatable group of data elements which together specify details of a stock shipment currently awaited,
     * normally from overseas. Optional and repeatable if more than a single shipment is outstanding.
     * </p>
     * <p>
     * Note that quantities in the &lt;OnOrderDetail&gt; composite must be included in any total quantity on order given
     * in P.26.37 &lt;OnOrder&gt;, and detail need not be given for all outstanding shipments (<i>ie</i> the P.26.37
     * &lt;OnOrder&gt; must be greater than or equal to the total of the &lt;OnOrder&gt; elements in repeats of the
     * composite).
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<OnOrderDetail, JonixOnOrderDetail> onOrderDetails() {
        _initialize();
        return onOrderDetails;
    }

    private ListOfOnixDataComposite<Velocity, JonixVelocity> velocitys =
        JPU.emptyListOfOnixDataComposite(Velocity.class);

    /**
     * <p>
     * An optional group of data elements which together specify the rate of stock depletion – or equally, a rate of
     * accumulation of backorders. Repeatable if the rate of depletion is specified using more than one metric
     * (<i>eg</i> specifying both a minimum and maximum daily sale).
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Velocity, JonixVelocity> velocitys() {
        _initialize();
        return velocitys;
    }
}
