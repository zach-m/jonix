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
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixOnOrderDetail;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Stock quantity composite</h1>
 * <p>
 * A repeatable group of data elements which together specify a quantity of stock and, where a supplier has more than
 * one warehouse, a supplier location. Optional.
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
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Stock}</li>
 * </ul>
 *
 * @since Onix-2.1
 */
public class Stock implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Stock";
    public static final String shortname = "stock";

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
                case StockQuantityCoded.refname:
                case StockQuantityCoded.shortname:
                    stockQuantityCoded = new StockQuantityCoded(e);
                    break;
                case LocationIdentifier.refname:
                case LocationIdentifier.shortname:
                    locationIdentifier = new LocationIdentifier(e);
                    break;
                case LocationName.refname:
                case LocationName.shortname:
                    locationName = new LocationName(e);
                    break;
                case OnHand.refname:
                case OnHand.shortname:
                    onHand = new OnHand(e);
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

    private StockQuantityCoded stockQuantityCoded = StockQuantityCoded.EMPTY;

    /**
     * <p>
     * A group of data elements which together specify coded stock level without stating the exact quantity of stock.
     * Either &lt;StockQuantityCoded&gt; or &lt;OnHand&gt; is mandatory in each occurrence of the &lt;Stock&gt;
     * composite, even if the onhand quantity is zero. Non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public StockQuantityCoded stockQuantityCoded() {
        _initialize();
        return stockQuantityCoded;
    }

    private LocationIdentifier locationIdentifier = LocationIdentifier.EMPTY;

    /**
     * <p>
     * A group of data elements which together define the identifier of a stock location in accordance with a specified
     * scheme, and allowing different types of location identifier to be supported without defining additional data
     * elements. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public LocationIdentifier locationIdentifier() {
        _initialize();
        return locationIdentifier;
    }

    private LocationName locationName = LocationName.EMPTY;

    /**
     * <p>
     * The name of a stock location. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public LocationName locationName() {
        _initialize();
        return locationName;
    }

    private OnHand onHand = OnHand.EMPTY;

    /**
     * <p>
     * The quantity of stock on hand. Either &lt;StockQuantityCoded&gt; or &lt;OnHand&gt; is mandatory in each
     * occurrence of the &lt;Stock&gt; composite, even if the onhand quantity is zero. Non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public OnHand onHand() {
        _initialize();
        return onHand;
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

    private ListOfOnixDataComposite<OnOrderDetail, JonixOnOrderDetail> onOrderDetails = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * A repeatable group of data elements which together specify details of a stock shipment currently awaited,
     * normally from overseas. Optional.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<OnOrderDetail, JonixOnOrderDetail> onOrderDetails() {
        _initialize();
        return onOrderDetails;
    }
}
