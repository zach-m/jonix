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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixProductIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Comparison product price composite</h1><p>Optional group of data elements that together define a price for a
 * directly comparable product, to facilitate supply of price data to retailers who do not receive a full ONIX record
 * for that comparable product. This is primarily intended for use within a &lt;Product&gt; record for a digital
 * product, to provide a price for a comparable physical product. The composite is repeatable in order to define
 * multiple comparison prices.</p><p>Those using this composite should be wary of the volatile nature of product prices:
 * special note should be taken of the risk of stale data being stored in data recipients’ systems when prices for the
 * comparison product are updated, as those updates to the comparison product may occur outside the context of the main
 * product being described in the &lt;Product&gt; record. Because of this, ONIX suppliers are cautioned of the risk of
 * contradictory data in separate data feeds. <em>This composite should not be supplied unless specifically requested by
 * a particular recipient.</em></p><p>The inclusion of a comparison price in itself implies nothing about the
 * availability or status of the comparable product. However, there may be legal requirements in particular territories
 * relating to the use of comparison prices in promotion that users of this data must comply with.</p><p>Note that the
 * comparison product price composite does not include all the features of the &lt;Price&gt; composite: for example,
 * &lt;PriceQualifier&gt; is not included. Thus data providers should ensure that any conditions attached to the
 * comparison product price are such that it is directly comparable to the price of the main product being
 * described.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;ComparisonProductPrice&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;comparisonproductprice&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class ComparisonProductPrice implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ComparisonProductPrice";
    public static final String shortname = "comparisonproductprice";

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
    public static final ComparisonProductPrice EMPTY = new ComparisonProductPrice();

    public ComparisonProductPrice() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ComparisonProductPrice(org.w3c.dom.Element element) {
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
                case PriceType.refname:
                case PriceType.shortname:
                    priceType = new PriceType(e);
                    break;
                case PriceAmount.refname:
                case PriceAmount.shortname:
                    priceAmount = new PriceAmount(e);
                    break;
                case CurrencyCode.refname:
                case CurrencyCode.shortname:
                    currencyCode = new CurrencyCode(e);
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
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private PriceType priceType = PriceType.EMPTY;

    /**
     * (this field is optional)
     */
    public PriceType priceType() {
        _initialize();
        return priceType;
    }

    private PriceAmount priceAmount = PriceAmount.EMPTY;

    /**
     * (this field is required)
     */
    public PriceAmount priceAmount() {
        _initialize();
        return priceAmount;
    }

    private CurrencyCode currencyCode = CurrencyCode.EMPTY;

    /**
     * (this field is optional)
     */
    public CurrencyCode currencyCode() {
        _initialize();
        return currencyCode;
    }
}
