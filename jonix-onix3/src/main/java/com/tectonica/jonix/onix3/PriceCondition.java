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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.PriceConditionQuantityTypes;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixPriceConditionQuantity;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Price condition composite</h1>
 * <p>
 * An optional group of data elements which together specify a condition relating to a price, repeatable in order to
 * specify multiple conditions.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PriceCondition&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;pricecondition&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈
 * {@link Price} ⯈ {@link PriceCondition}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈
 * {@link PriceCondition}</li>
 * </ul>
 */
public class PriceCondition implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PriceCondition";
    public static final String shortname = "pricecondition";

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
    public static final PriceCondition EMPTY = new PriceCondition();

    public PriceCondition() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PriceCondition(org.w3c.dom.Element element) {
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
                case PriceConditionType.refname:
                case PriceConditionType.shortname:
                    priceConditionType = new PriceConditionType(e);
                    break;
                case PriceConditionQuantity.refname:
                case PriceConditionQuantity.shortname:
                    priceConditionQuantitys = JPU.addToList(priceConditionQuantitys, new PriceConditionQuantity(e));
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PriceCondition&gt; or &lt;pricecondition&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private PriceConditionType priceConditionType = PriceConditionType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying a type of price condition. Mandatory in each occurrence of the &lt;PriceCondition&gt;
     * composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public PriceConditionType priceConditionType() {
        _initialize();
        return priceConditionType;
    }

    private ListOfOnixDataCompositeWithKey<PriceConditionQuantity, JonixPriceConditionQuantity,
        PriceConditionQuantityTypes> priceConditionQuantitys = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * An optional and repeatable group of data elements which together specify a price condition quantity, for example
     * a minimum number of copies, or a period of time for which updates are supplied or must be purchased.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public
        ListOfOnixDataCompositeWithKey<PriceConditionQuantity, JonixPriceConditionQuantity, PriceConditionQuantityTypes>
        priceConditionQuantitys() {
        _initialize();
        return priceConditionQuantitys;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier,
        ProductIdentifierTypes> productIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * A group of data elements which together define an identifier of a product in accordance with a specified scheme.
     * Optional, and used here if and only if &lt;PriceConditionType&gt; has a value that requires specification of a
     * linked product upon which the price is dependent. Repeatable with different identifiers for the same product.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }
}
