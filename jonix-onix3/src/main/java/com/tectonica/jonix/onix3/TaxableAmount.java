/*
 * Copyright (C) 2012-2024 Zach Melamed
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
 * <h1>Amount of price taxable</h1>
 * <p>
 * The amount of the unit price of the product, excluding tax, which is taxable at the rate specified in an occurrence
 * of the &lt;Tax&gt; composite. Optional and non-repeating; but required if tax is charged on part of the price.
 * Omission of this element implies that tax is charged on the full amount of the price.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Positive real number, with explicit decimal point when required, suggested maximum length 12 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;TaxableAmount&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x473&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x473&gt;10.64&lt;/x473&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;TaxableAmount&gt; from the schema author:
 *
 * Amount of the price on which tax is levied -&#160;in effect, the price before tax
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Tax}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link Tax} ⯈
 * {@link TaxableAmount}</li>
 * </ul>
 */
public class TaxableAmount implements OnixElement<Double>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TaxableAmount";
    public static final String shortname = "x473";

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
     * This is the raw content of TaxableAmount. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Positive real number, with explicit decimal point when required, suggested maximum length 12
     * characters
     * <p>
     * (type: dt.PositiveDecimal)
     */
    public Double value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public Double __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final TaxableAmount EMPTY = new TaxableAmount();

    public TaxableAmount() {
        exists = false;
    }

    public TaxableAmount(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsDouble(element);
    }

    /**
     * @return whether this tag (&lt;TaxableAmount&gt; or &lt;x473&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<TaxableAmount> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
