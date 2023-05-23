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
import com.tectonica.jonix.common.struct.JonixPriceConstraintLimit;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Price constraint limit composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together specify a quantitative limit on a particular type of
 * contractual term or constraint.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PriceConstraintLimit&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;priceconstraintlimit&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PriceConstraint}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link PriceConstraint} ⯈
 * {@link PriceConstraintLimit}</li>
 * </ul>
 *
 * @since Onix-3.03
 */
public class PriceConstraintLimit implements OnixDataComposite<JonixPriceConstraintLimit>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PriceConstraintLimit";
    public static final String shortname = "priceconstraintlimit";

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
    public static final PriceConstraintLimit EMPTY = new PriceConstraintLimit();

    public PriceConstraintLimit() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PriceConstraintLimit(org.w3c.dom.Element element) {
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
                case Quantity.refname:
                case Quantity.shortname:
                    quantity = new Quantity(e);
                    break;
                case PriceConstraintUnit.refname:
                case PriceConstraintUnit.shortname:
                    priceConstraintUnit = new PriceConstraintUnit(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PriceConstraintLimit&gt; or &lt;priceconstraintlimit&gt;) is explicitly provided in
     *         the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PriceConstraintLimit> action) {
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

    private Quantity quantity = Quantity.EMPTY;

    /**
     * <p>
     * A numeric value representing the maximum permitted quantity or limit of a particular type of constraint.
     * Mandatory in each occurrence of the &lt;PriceConstraintLimit&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public Quantity quantity() {
        _initialize();
        return quantity;
    }

    private PriceConstraintUnit priceConstraintUnit = PriceConstraintUnit.EMPTY;

    /**
     * <p>
     * An ONIX code for a unit in which a maximum permitted quantity or limit is stated. Mandatory in each occurrence of
     * the &lt;PriceConstraintLimit&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public PriceConstraintUnit priceConstraintUnit() {
        _initialize();
        return priceConstraintUnit;
    }

    @Override
    public JonixPriceConstraintLimit asStruct() {
        _initialize();
        JonixPriceConstraintLimit struct = new JonixPriceConstraintLimit();
        struct.quantity = quantity.value;
        struct.priceConstraintUnit = priceConstraintUnit.value;
        return struct;
    }
}
