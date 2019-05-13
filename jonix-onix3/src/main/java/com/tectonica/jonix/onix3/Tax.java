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
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixProductIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Tax composite</h1><p>A repeatable group of data elements which together specify tax included within a price
 * amount. Optional, and used only when &lt;PriceType&gt; indicates an inc-tax price. For items to which different taxes
 * or tax rates apply (<i>eg</i> mixed media products in the UK which are partly taxed at standard rate and partly at
 * zero rate), the composite is repeated for each separate tax or tax rate. Although only one of &lt;TaxRatePercent&gt;
 * or &lt;TaxAmount&gt; is mandatory within the composite, it is recommended that all tax elements in the composite
 * should be explicitly populated.</p><p>If the tax regime requires separate tax rates and amounts linked explicitly to
 * particular product parts (<i>eg</i> in Germany), the &lt;ProductIdentifier&gt; composite may be included in each
 * &lt;Tax&gt; composite. Where tax is payable on multiple product parts, each should have its own instance of the
 * &lt;Tax&gt; composite.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;Tax&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;tax&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class Tax implements OnixSuperComposite, Serializable {
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
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case PricePartDescription.refname:
                case PricePartDescription.shortname:
                    pricePartDescriptions = JPU.addToList(pricePartDescriptions, new PricePartDescription(e));
                    break;
                case TaxType.refname:
                case TaxType.shortname:
                    taxType = new TaxType(e);
                    break;
                case TaxRateCode.refname:
                case TaxRateCode.shortname:
                    taxRateCode = new TaxRateCode(e);
                    break;
                case TaxRatePercent.refname:
                case TaxRatePercent.shortname:
                    taxRatePercent = new TaxRatePercent(e);
                    break;
                case TaxableAmount.refname:
                case TaxableAmount.shortname:
                    taxableAmount = new TaxableAmount(e);
                    break;
                case TaxAmount.refname:
                case TaxAmount.shortname:
                    taxAmount = new TaxAmount(e);
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

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private ListOfOnixElement<PricePartDescription, String> pricePartDescriptions = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<PricePartDescription, String> pricePartDescriptions() {
        _initialize();
        return pricePartDescriptions;
    }

    private TaxType taxType = TaxType.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxType taxType() {
        _initialize();
        return taxType;
    }

    private TaxRateCode taxRateCode = TaxRateCode.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxRateCode taxRateCode() {
        _initialize();
        return taxRateCode;
    }

    private TaxRatePercent taxRatePercent = TaxRatePercent.EMPTY;

    /**
     * (this field is required)
     */
    public TaxRatePercent taxRatePercent() {
        _initialize();
        return taxRatePercent;
    }

    private TaxableAmount taxableAmount = TaxableAmount.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxableAmount taxableAmount() {
        _initialize();
        return taxableAmount;
    }

    private TaxAmount taxAmount = TaxAmount.EMPTY;

    /**
     * (this field is optional)
     */
    public TaxAmount taxAmount() {
        _initialize();
        return taxAmount;
    }
}
