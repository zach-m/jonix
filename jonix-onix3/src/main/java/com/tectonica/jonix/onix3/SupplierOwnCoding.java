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
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SupplierOwnCodeTypes;
import com.tectonica.jonix.struct.JonixSupplierOwnCoding;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supplier own coding composite</h1><p>An optional and repeatable group of data elements which together allow a
 * supplier to send coded data of a specified type, using its own coding schemes.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;SupplierOwnCoding&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;supplierowncoding&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private SupplierCodeType supplierCodeType = SupplierCodeType.EMPTY;

    /**
     * (this field is required)
     */
    public SupplierCodeType supplierCodeType() {
        initialize();
        return supplierCodeType;
    }

    private SupplierCodeTypeName supplierCodeTypeName = SupplierCodeTypeName.EMPTY;

    /**
     * (this field is optional)
     */
    public SupplierCodeTypeName supplierCodeTypeName() {
        initialize();
        return supplierCodeTypeName;
    }

    private SupplierCodeValue supplierCodeValue = SupplierCodeValue.EMPTY;

    /**
     * (this field is required)
     */
    public SupplierCodeValue supplierCodeValue() {
        initialize();
        return supplierCodeValue;
    }

    @Override
    public JonixSupplierOwnCoding asStruct() {
        initialize();
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
