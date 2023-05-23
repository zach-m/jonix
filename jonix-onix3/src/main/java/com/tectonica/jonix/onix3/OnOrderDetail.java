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
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixOnOrderDetail;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>On order detail composite</h1>
 * <p>
 * A repeatable group of data elements which together specify details of a stock shipment currently awaited, normally
 * from overseas. Optional and repeatable if more than a single shipment is outstanding.
 * </p>
 * <p>
 * Note that quantities in the &lt;OnOrderDetail&gt; composite must be included in any total quantity on order given in
 * P.26.37 &lt;OnOrder&gt;, and detail need not be given for all outstanding shipments (<i>ie</i> the P.26.37
 * &lt;OnOrder&gt; must be greater than or equal to the total of the &lt;OnOrder&gt; elements in repeats of the
 * composite).
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;OnOrderDetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;onorderdetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Stock}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Stock} ⯈ {@link OnOrderDetail}</li>
 * </ul>
 */
public class OnOrderDetail implements OnixDataComposite<JonixOnOrderDetail>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "OnOrderDetail";
    public static final String shortname = "onorderdetail";

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
    public static final OnOrderDetail EMPTY = new OnOrderDetail();

    public OnOrderDetail() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public OnOrderDetail(org.w3c.dom.Element element) {
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
                case OnOrder.refname:
                case OnOrder.shortname:
                    onOrder = new OnOrder(e);
                    break;
                case ExpectedDate.refname:
                case ExpectedDate.shortname:
                    expectedDate = new ExpectedDate(e);
                    break;
                case Proximity.refname:
                case Proximity.shortname:
                    proximity = new Proximity(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;OnOrderDetail&gt; or &lt;onorderdetail&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<OnOrderDetail> action) {
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

    private OnOrder onOrder = OnOrder.EMPTY;

    /**
     * <p>
     * The quantity of stock on order in a particular shipment. Mandatory in each occurrence of the
     * &lt;OnOrderDetail&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public OnOrder onOrder() {
        _initialize();
        return onOrder;
    }

    private ExpectedDate expectedDate = ExpectedDate.EMPTY;

    /**
     * <p>
     * The date on which a stock shipment is expected. Mandatory in each occurrence of the &lt;OnOrderDetail&gt;
     * composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ExpectedDate expectedDate() {
        _initialize();
        return expectedDate;
    }

    private Proximity proximity = Proximity.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the precision of the stock quantity in a shipment. Optional, and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Proximity proximity() {
        _initialize();
        return proximity;
    }

    @Override
    public JonixOnOrderDetail asStruct() {
        _initialize();
        JonixOnOrderDetail struct = new JonixOnOrderDetail();
        struct.expectedDate = expectedDate.value;
        struct.onOrder = onOrder.value;
        return struct;
    }
}
