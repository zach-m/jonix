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
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Minimum order quantity</h1>
 * <p>
 * The minimum quantity of the product that may be ordered in a single order placed with the supplier. Optional. If
 * omitted, any number may be ordered.
 * </p>
 * <p>
 * If supplied without a succeeding Minimum initial order quantity, the Minimum order quantity applies to all orders for
 * the product. If followed by a Minimum initial order quantity, the Minimum order quantity applies to the second and
 * subsequent orders for the product.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Positive integer, suggested maximum length 4 digits</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;OrderQuantityMinimum&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x532&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x532&gt;6&lt;/x532&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;OrderQuantityMinimum&gt; from the schema author:
 *
 * &#9679; Added at revision 3.0.3
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link OrderQuantityMinimum}</li>
 * </ul>
 *
 * @since Onix-3.03
 */
public class OrderQuantityMinimum implements OnixElement<Integer>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "OrderQuantityMinimum";
    public static final String shortname = "x532";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of OrderQuantityMinimum. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Positive integer, suggested maximum length 4 digits
     * <p>
     * (type: dt.PositiveInteger)
     */
    public Integer value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public Integer __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final OrderQuantityMinimum EMPTY = new OrderQuantityMinimum();

    public OrderQuantityMinimum() {
        exists = false;
    }

    public OrderQuantityMinimum(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsInteger(element);
    }

    /**
     * @return whether this tag (&lt;OrderQuantityMinimum&gt; or &lt;x532&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<OrderQuantityMinimum> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
