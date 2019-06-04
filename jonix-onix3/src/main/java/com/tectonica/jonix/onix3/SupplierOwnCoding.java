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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SupplierOwnCodeTypes;
import com.tectonica.jonix.common.struct.JonixSupplierOwnCoding;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supplier own coding composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together allow a supplier to send coded data of a specified
 * type, using its own coding schemes.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SupplierOwnCoding&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;supplierowncoding&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;SupplyDetail&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ SupplierOwnCoding</li>
 * </ul>
 */
public class SupplierOwnCoding
    implements OnixDataCompositeWithKey<JonixSupplierOwnCoding, SupplierOwnCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SupplierOwnCoding";
    public static final String shortname = "supplierowncoding";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final SupplierOwnCoding EMPTY = new SupplierOwnCoding();

    public SupplierOwnCoding() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SupplierOwnCoding(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
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
                case SupplierCodeType.refname:
                case SupplierCodeType.shortname:
                    supplierCodeType = new SupplierCodeType(e);
                    break;
                case SupplierCodeTypeName.refname:
                case SupplierCodeTypeName.shortname:
                    supplierCodeTypeName = new SupplierCodeTypeName(e);
                    break;
                case SupplierCodeValue.refname:
                case SupplierCodeValue.shortname:
                    supplierCodeValue = new SupplierCodeValue(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SupplierOwnCoding&gt; or &lt;supplierowncoding&gt;) is explicitly provided in the
     * ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private SupplierCodeType supplierCodeType = SupplierCodeType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the type of a supplier own code. Mandatory in each occurrence of the
     * &lt;SupplierOwnCoding&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SupplierCodeType supplierCodeType() {
        _initialize();
        return supplierCodeType;
    }

    private SupplierCodeTypeName supplierCodeTypeName = SupplierCodeTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies the proprietary coding scheme used. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SupplierCodeTypeName supplierCodeTypeName() {
        _initialize();
        return supplierCodeTypeName;
    }

    private SupplierCodeValue supplierCodeValue = SupplierCodeValue.EMPTY;

    /**
     * <p>
     * A supplier-defined code of the type specified in the &lt;SupplierCodeType&gt; element. Mandatory in each
     * occurrence of the &lt;SupplierOwnCoding&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SupplierCodeValue supplierCodeValue() {
        _initialize();
        return supplierCodeValue;
    }

    @Override
    public JonixSupplierOwnCoding asStruct() {
        _initialize();
        JonixSupplierOwnCoding struct = new JonixSupplierOwnCoding();
        struct.supplierCodeType = supplierCodeType.value;
        struct.supplierCodeTypeName = supplierCodeTypeName.value;
        struct.supplierCodeValue = supplierCodeValue.value;
        return struct;
    }

    @Override
    public SupplierOwnCodeTypes structKey() {
        return supplierCodeType().value;
    }
}
