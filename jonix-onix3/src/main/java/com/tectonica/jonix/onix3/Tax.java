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
import com.tectonica.jonix.struct.JonixTax;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Tax composite</h1><p>A repeatable group of data elements which together specify tax applicable to a price.
 * Optional. For items to which two different taxes or tax rates apply (<i>eg</i> mixed media products in the UK which
 * are partly taxed at standard rate and partly at zero rate), the composite is repeated for each separate tax or tax
 * rate. For UK VAT, it is recommended that all elements in the composite should be explicitly populated.</p><table
 * border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;Tax&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;tax&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class Tax implements OnixDataComposite<JonixTax>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Tax";
    public static final String shortname = "tax";

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
    public static final Tax EMPTY = new Tax();

    public Tax() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Tax(org.w3c.dom.Element element) {
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
            if (name.equals(TaxType.refname) || name.equals(TaxType.shortname)) {
                taxType = new TaxType(e);
            } else if (name.equals(TaxRateCode.refname) || name.equals(TaxRateCode.shortname)) {
                taxRateCode = new TaxRateCode(e);
            } else if (name.equals(TaxRatePercent.refname) || name.equals(TaxRatePercent.shortname)) {
                taxRatePercent = new TaxRatePercent(e);
            } else if (name.equals(TaxableAmount.refname) || name.equals(TaxableAmount.shortname)) {
                taxableAmount = new TaxableAmount(e);
            } else if (name.equals(TaxAmount.refname) || name.equals(TaxAmount.shortname)) {
                taxAmount = new TaxAmount(e);
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

    private TaxType taxType = TaxType.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxType taxType() {
        initialize();
        return taxType;
    }

    private TaxRateCode taxRateCode = TaxRateCode.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxRateCode taxRateCode() {
        initialize();
        return taxRateCode;
    }

    private TaxRatePercent taxRatePercent = TaxRatePercent.EMPTY;

    /**
     * (this field is required)
     */
    public TaxRatePercent taxRatePercent() {
        initialize();
        return taxRatePercent;
    }

    private TaxableAmount taxableAmount = TaxableAmount.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxableAmount taxableAmount() {
        initialize();
        return taxableAmount;
    }

    private TaxAmount taxAmount = TaxAmount.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxAmount taxAmount() {
        initialize();
        return taxAmount;
    }

    @Override
    public JonixTax asStruct() {
        initialize();
        JonixTax struct = new JonixTax();
        struct.taxType = taxType.value;
        struct.taxRateCode = taxRateCode.value;
        struct.taxRatePercent = taxRatePercent.value;
        struct.taxableAmount = taxableAmount.value;
        struct.taxAmount = taxAmount.value;
        return struct;
    }
}
