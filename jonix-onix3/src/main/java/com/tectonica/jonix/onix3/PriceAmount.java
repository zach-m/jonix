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
 * <h1>Price amount</h1>
 * <p>
 * The amount of a price. Optional and non-repeating, but each occurrence of the &lt;Price&gt; composite must include
 * either a &lt;PriceAmount&gt; or a &lt;PriceCoded&gt; composite, with optional tax details, or an
 * &lt;UnpricedItemType&gt; element. Note that free-of-charge products must use &lt;UnpricedItemType&gt; rather than a
 * zero price.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Positive real number, with explicit decimal point when required, suggested maximum length 12 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PriceAmount&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;j151&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;j151&gt;18.99&lt;/j151&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;PriceAmount&gt; from the schema author:
 *
 * Amount of a particular price applied to the product &#9679; Do not use a Price amount of zero to mean free of charge,
 * use &lt;UnpricedItemType&gt; instead
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ComparisonProductPrice}&gt;</li>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link ComparisonProductPrice} ⯈
 * {@link PriceAmount}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link PriceAmount}</li>
 * </ul>
 */
public class PriceAmount implements OnixElement<Double>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PriceAmount";
    public static final String shortname = "j151";

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
     * This is the raw content of PriceAmount. Could be null if {@code exists() == false}. Use {@link #value()} instead
     * if you want to get this as an {@link java.util.Optional}.
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
    public static final PriceAmount EMPTY = new PriceAmount();

    public PriceAmount() {
        exists = false;
    }

    public PriceAmount(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsDouble(element);
    }

    /**
     * @return whether this tag (&lt;PriceAmount&gt; or &lt;j151&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PriceAmount> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
