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
 * <h1>Discount code composite</h1>
 * <p>
 * An optional group of data elements which together define a discount code from a specified scheme, and repeatable to
 * allow different discount code schemes to be supported without defining additional data elements.
 * </p>
 * <p>
 * A discount code is generally used when the exact percentage discount (or commission, in an agency business model)
 * that a code represents may vary from reseller to reseller (or from agent to agent), or if terms must be kept
 * confidential. If the discount (or commission) is the same for all resellers (or agents) and need not be kept
 * confidential, use &lt;Discount&gt; and &lt;DiscountPercent&gt; instead.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;DiscountCoded&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;discountcoded&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;DiscountCoded&gt; from the schema author:
 *
 * Details of the trade discount offered by the supplier, in a coded manner
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈
 * {@link DiscountCoded}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link DiscountCoded}</li>
 * </ul>
 */
public class DiscountCoded implements OnixDataCompositeWithKey<JonixDiscountCoded, DiscountCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "DiscountCoded";
    public static final String shortname = "discountcoded";

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
    public static final DiscountCoded EMPTY = new DiscountCoded();

    public DiscountCoded() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public DiscountCoded(org.w3c.dom.Element element) {
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
                case DiscountCodeType.refname:
                case DiscountCodeType.shortname:
                    discountCodeType = new DiscountCodeType(e);
                    break;
                case DiscountCode.refname:
                case DiscountCode.shortname:
                    discountCode = new DiscountCode(e);
                    break;
                case DiscountCodeTypeName.refname:
                case DiscountCodeTypeName.shortname:
                    discountCodeTypeName = new DiscountCodeTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;DiscountCoded&gt; or &lt;discountcoded&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<DiscountCoded> action) {
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

    private DiscountCodeType discountCodeType = DiscountCodeType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the scheme from which the value in the &lt;DiscountCode&gt; element is taken. Mandatory
     * in each occurrence of the &lt;DiscountCoded&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public DiscountCodeType discountCodeType() {
        _initialize();
        return discountCodeType;
    }

    private DiscountCode discountCode = DiscountCode.EMPTY;

    /**
     * <p>
     * A discount code from the scheme specified in the &lt;DiscountCodeType&gt; element. Mandatory in each occurrence
     * of the &lt;DiscountCoded&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public DiscountCode discountCode() {
        _initialize();
        return discountCode;
    }

    private DiscountCodeTypeName discountCodeTypeName = DiscountCodeTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary discount code. Must be used when, and only when the code in the
     * &lt;DiscountCodeType&gt; element indicates a proprietary scheme, <i>eg</i> a wholesaler’s own code. Optional and
     * non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public DiscountCodeTypeName discountCodeTypeName() {
        _initialize();
        return discountCodeTypeName;
    }

    @Override
    public JonixDiscountCoded asStruct() {
        _initialize();
        JonixDiscountCoded struct = new JonixDiscountCoded();
        struct.discountCodeType = discountCodeType.value;
        struct.discountCode = discountCode.value;
        struct.discountCodeTypeName = discountCodeTypeName.value;
        return struct;
    }

    @Override
    public DiscountCodeTypes structKey() {
        return discountCodeType().value;
    }
}
