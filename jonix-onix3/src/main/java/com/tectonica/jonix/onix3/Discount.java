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
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixDiscount;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Discount composite</h1><p>A repeatable group of data elements which together define a discount either as a
 * percentage or as an absolute amount. Optional. Used only when an ONIX message is sent within the context of a
 * specific trading relationship.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;Discount&gt;</td></tr><tr><td>Short tag</td><td>&lt;discount&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    public String sourcename;

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
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
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
                case DiscountPercent.refname:
                case DiscountPercent.shortname:
                    discountPercent = new DiscountPercent(e);
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

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private DiscountType discountType = DiscountType.EMPTY;

    /**
     * (this field is optional)
     */
    public DiscountType discountType() {
        initialize();
        return discountType;
    }

    private Quantity quantity = Quantity.EMPTY;

    /**
     * (this field is optional)
     */
    public Quantity quantity() {
        initialize();
        return quantity;
    }

    private ToQuantity toQuantity = ToQuantity.EMPTY;

    /**
     * (this field is optional)
     */
    public ToQuantity toQuantity() {
        initialize();
        return toQuantity;
    }

    private DiscountPercent discountPercent = DiscountPercent.EMPTY;

    /**
     * (this field is required)
     */
    public DiscountPercent discountPercent() {
        initialize();
        return discountPercent;
    }

    private DiscountAmount discountAmount = DiscountAmount.EMPTY;

    /**
     * (this field is optional)
     */
    public DiscountAmount discountAmount() {
        initialize();
        return discountAmount;
    }

    @Override
    public JonixDiscount asStruct() {
        initialize();
        JonixDiscount struct = new JonixDiscount();
        struct.discountType = discountType.value;
        struct.quantity = quantity.value;
        struct.toQuantity = toQuantity.value;
        struct.discountPercent = discountPercent.value;
        struct.discountAmount = discountAmount.value;
        return struct;
    }
}
