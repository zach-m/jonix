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

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

import com.tectonica.jonix.common.*;
import com.tectonica.jonix.common.OnixComposite.*;
import com.tectonica.jonix.common.codelist.*;
import com.tectonica.jonix.common.struct.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Discount composite</h1>
 * <p>
 * An optional group of data elements which together define a discount either as a percentage or as an absolute amount.
 * Repeatable in order to specify a more complex arrangement such as a progressive or tiered discount. Used only when an
 * ONIX message is sent within the context of a specific trading relationship.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Discount&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;discount&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Discount&gt; from the schema author:
 *
 * Details of the business-to-business discount offered by the supplier, as a percentage of the price or an absolute
 * amount per copy &#9679; Added &lt;ToQuantity&gt; at revison 3.0.2
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link Discount}</li>
 * </ul>
 */
public class Discount implements OnixDataComposite<JonixDiscount>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Discount";
    public static final String shortname = "discount";

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
    public static final Discount EMPTY = new Discount();

    public Discount() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Discount(org.w3c.dom.Element element) {
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
                case DiscountPercent.refname:
                case DiscountPercent.shortname:
                    discountPercent = new DiscountPercent(e);
                    break;
                case DiscountType.refname:
                case DiscountType.shortname:
                    discountType = new DiscountType(e);
                    break;
                case Quantity.refname:
                case Quantity.shortname:
                    quantity = new Quantity(e);
                    break;
                case ToQuantity.refname:
                case ToQuantity.shortname:
                    toQuantity = new ToQuantity(e);
                    break;
                case DiscountAmount.refname:
                case DiscountAmount.shortname:
                    discountAmount = new DiscountAmount(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Discount&gt; or &lt;discount&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Discount> action) {
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

    private DiscountPercent discountPercent = DiscountPercent.EMPTY;

    /**
     * <p>
     * A discount percentage applicable to the price carried in an occurrence of the &lt;Price&gt; composite. Optional
     * and non-repeating; but either &lt;DiscountPercent&gt; or &lt;DiscountAmount&gt; or both must be present in each
     * occurrence of the &lt;Discount&gt; composite.
     * </p>
     * JONIX adds: this field is required
     */
    public DiscountPercent discountPercent() {
        _initialize();
        return discountPercent;
    }

    private DiscountType discountType = DiscountType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying a discount type or reason. Optional, and non-repeating. When omitted, the default is a
     * simple or rising discount (the discount is applied to all units in a qualifying order).
     * </p>
     * JONIX adds: this field is optional
     */
    public DiscountType discountType() {
        _initialize();
        return discountType;
    }

    private Quantity quantity = Quantity.EMPTY;

    /**
     * <p>
     * A minimum order quantity required to qualify for a specified discount. Optional, and non-repeating. Where
     * omitted, the discount applies regardless of the order quantity (<i>ie</i> the minimum qualifying order quantity
     * is 1).
     * </p>
     * JONIX adds: this field is optional
     */
    public Quantity quantity() {
        _initialize();
        return quantity;
    }

    private ToQuantity toQuantity = ToQuantity.EMPTY;

    /**
     * <p>
     * A maximum order quantity eligible for a specified discount, used only in the case of ‘progressive’ discounts.
     * Optional, but where used, must be preceded by a minimum qualifying order quantity (even if that minimum is 1).
     * For the special case where there is no maximum (<i>ie</i> in the repeat of the &lt;Discount&gt; composite that
     * specifies the highest progressive discount), use zero.
     * </p>
     * JONIX adds: this field is optional
     */
    public ToQuantity toQuantity() {
        _initialize();
        return toQuantity;
    }

    private DiscountAmount discountAmount = DiscountAmount.EMPTY;

    /**
     * <p>
     * A discount expressed as an absolute amount per copy. Optional and non-repeating; but either
     * &lt;DiscountPercent&gt; or &lt;DiscountAmount&gt; or both must be present in each occurrence of the
     * &lt;Discount&gt; composite. Note that when both are present, they represent two different expressions of the same
     * discount&nbsp;– the discounts are not cumulative.
     * </p>
     * JONIX adds: this field is optional
     */
    public DiscountAmount discountAmount() {
        _initialize();
        return discountAmount;
    }

    @Override
    public JonixDiscount asStruct() {
        _initialize();
        JonixDiscount struct = new JonixDiscount();
        struct.discountType = discountType.value;
        struct.quantity = quantity.value;
        struct.toQuantity = toQuantity.value;
        struct.discountPercent = discountPercent.value;
        struct.discountAmount = discountAmount.value;
        return struct;
    }
}
