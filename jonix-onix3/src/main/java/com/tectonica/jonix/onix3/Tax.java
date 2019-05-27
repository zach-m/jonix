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
 * <h1>Tax composite</h1>
 * <p>
 * A repeatable group of data elements which together specify tax included within a price amount. Optional, and used
 * only when &lt;PriceType&gt; indicates an inc-tax price. For items to which different taxes or tax rates apply
 * (<i>eg</i> mixed media products in the UK which are partly taxed at standard rate and partly at zero rate), the
 * composite is repeated for each separate tax or tax rate. Although only one of &lt;TaxRatePercent&gt; or
 * &lt;TaxAmount&gt; is mandatory within the composite, it is recommended that all tax elements in the composite should
 * be explicitly populated.
 * </p>
 * <p>
 * If the tax regime requires separate tax rates and amounts linked explicitly to particular product parts (<i>eg</i> in
 * Germany), the &lt;ProductIdentifier&gt; composite may be included in each &lt;Tax&gt; composite. Where tax is payable
 * on multiple product parts, each should have its own instance of the &lt;Tax&gt; composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Tax&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;tax&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Price&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ Tax</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ Tax</li>
 * </ul>
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

    /**
     * @return whether this tag (&lt;Tax&gt; or &lt;tax&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers = ListOfOnixDataCompositeWithKey
        .emptyKeyed();

    /**
     * <p>
     * Optional and repeatable group of data elements which together specify one or more identifiers of a product part
     * in accordance with a specified scheme, used here only when it is necessary to link a particular tax rate or
     * amount with a particular product part contained within a multiple-item product or a trade pack. All identifiers
     * included here must also be included in an instance of &lt;ProductPart&gt;, and where multiple identifiers are
     * provided in any one occurrence of the &lt;Tax&gt; composite, they must all identify the same product part.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private ListOfOnixElement<PricePartDescription, String> pricePartDescriptions = ListOfOnixElement.empty();

    /**
     * <p>
     * A name or description which identifies a part of the product price that is subject to the relevant tax, for
     * example a product part that may be taxed with a particular tax rate or amount (separately from other components),
     * or a levy added to a product price that is itself subject to tax. Optional, and repeatable to provide parallel
     * descriptive text in multiple languages. The <i>language</i> attribute is optional for a single instance of
     * &lt;PricePartDescription&gt;, but must be included in each instance if &lt;PricePartDescription&gt; is repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<PricePartDescription, String> pricePartDescriptions() {
        _initialize();
        return pricePartDescriptions;
    }

    private TaxType taxType = TaxType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying a tax type, <i>eg</i> VAT. Optional, and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TaxType taxType() {
        _initialize();
        return taxType;
    }

    private TaxRateCode taxRateCode = TaxRateCode.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies a tax rate. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TaxRateCode taxRateCode() {
        _initialize();
        return taxRateCode;
    }

    private TaxRatePercent taxRatePercent = TaxRatePercent.EMPTY;

    /**
     * <p>
     * A tax rate expressed numerically as a percentage. Optional and non-repeating; but either &lt;TaxRatePercent&gt;
     * or &lt;TaxAmount&gt; or both must be present in each occurrence of the &lt;Tax&gt; composite.
     * </p>
     * Jonix-Comment: this field is required
     */
    public TaxRatePercent taxRatePercent() {
        _initialize();
        return taxRatePercent;
    }

    private TaxableAmount taxableAmount = TaxableAmount.EMPTY;

    /**
     * <p>
     * The amount of the unit price of the product, excluding tax, which is taxable at the rate specified in an
     * occurrence of the &lt;Tax&gt; composite. Optional and non-repeating; but required if tax is charged on part of
     * the price. Omission of this element implies that tax is charged on the full amount of the price.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TaxableAmount taxableAmount() {
        _initialize();
        return taxableAmount;
    }

    private TaxAmount taxAmount = TaxAmount.EMPTY;

    /**
     * <p>
     * The amount of tax chargeable at the rate specified in an occurrence of the &lt;Tax&gt; composite. Optional and
     * non-repeating; but either &lt;TaxRatePercent&gt; or &lt;TaxAmount&gt; or both must be present in each occurrence
     * of the &lt;Tax&gt; composite.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TaxAmount taxAmount() {
        _initialize();
        return taxAmount;
    }
}
