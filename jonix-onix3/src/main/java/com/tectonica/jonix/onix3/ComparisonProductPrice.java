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
 * <h1>Comparison product price composite</h1>
 * <p>
 * Optional group of data elements that together define a price for a directly comparable product, to facilitate supply
 * of price data to retailers who do not receive a full ONIX record for that comparable product. This is primarily
 * intended for use within a &lt;Product&gt; record for a digital product, to provide a price for a comparable physical
 * product. The composite is repeatable in order to define multiple comparison prices.
 * </p>
 * <p>
 * Those using this composite should be wary of the volatile nature of product prices: special note should be taken of
 * the risk of stale data being stored in data recipients’ systems when prices for the comparison product are updated,
 * as those updates to the comparison product may occur outside the context of the main product being described in the
 * &lt;Product&gt; record. Because of this, ONIX suppliers are cautioned of the risk of contradictory data in separate
 * data feeds. <em>This composite should not be supplied unless specifically requested by a particular recipient.</em>
 * </p>
 * <p>
 * The inclusion of a comparison price in itself implies nothing about the availability or status of the comparable
 * product. However, there may be legal requirements in particular territories relating to the use of comparison prices
 * in promotion that users of this data must comply with.
 * </p>
 * <p>
 * Note that the comparison product price composite does not include all the features of the &lt;Price&gt; composite:
 * for example, &lt;PriceQualifier&gt; is not included. Thus data providers should ensure that any conditions attached
 * to the comparison product price are such that it is directly comparable to the price of the main product being
 * described.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ComparisonProductPrice&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;comparisonproductprice&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ComparisonProductPrice&gt; from the schema author:
 *
 * &#9679; Added at revision 3.0 (2010)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈
 * {@link ComparisonProductPrice}</li>
 * </ul>
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
                case PriceAmount.refname:
                case PriceAmount.shortname:
                    priceAmount = new PriceAmount(e);
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case PriceType.refname:
                case PriceType.shortname:
                    priceType = new PriceType(e);
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

    /**
     * @return whether this tag (&lt;ComparisonProductPrice&gt; or &lt;comparisonproductprice&gt;) is explicitly
     *         provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ComparisonProductPrice> action) {
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

    private PriceAmount priceAmount = PriceAmount.EMPTY;

    /**
     * <p>
     * The amount of the comparison product price. Mandatory and non-repeating within any occurrence of the
     * &lt;ComparisonProductPrice&gt; composite.
     * </p>
     * JONIX adds: this field is required
     */
    public PriceAmount priceAmount() {
        _initialize();
        return priceAmount;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier,
        ProductIdentifierTypes> productIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(ProductIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define an identifier for a comparison product in accordance with a
     * specified scheme. At least one &lt;ProductIdentifier&gt; composite is mandatory within an occurrence of
     * &lt;ComparisonProductPrice&gt;, to identify the product to which the comparison price applies. Repeatable with
     * different identifiers for the same product.
     * </p>
     * <p>
     * It is strongly advised that the relationship between the comparison product and the product described in the
     * &lt;Product&gt; record is defined in a &lt;RelatedProduct&gt; composite in P.23&nbsp;– typically this might be
     * &lt;ProductRelationCode&gt; 06 (related product is alternative format with same content as product) and may in
     * many circumstances also be 13 (product is e-publication based on related product).
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private PriceType priceType = PriceType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the type of the comparison price in the &lt;PriceAmount&gt; element within the
     * &lt;ComparisonProductPrice&gt; composite. Mandatory, unless a &lt;DefaultPriceType&gt; has been specified in the
     * message header although use of such a default is deprecated. Non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public PriceType priceType() {
        _initialize();
        return priceType;
    }

    private CurrencyCode currencyCode = CurrencyCode.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the currency in which the &lt;PriceAmount&gt; in an occurrence of the
     * &lt;ComparisonProductPrice&gt; composite is stated. Optional and non-repeating, but required if the currency is
     * not the default currency for the ONIX message. To avoid any possible ambiguity, it is strongly recommended that
     * the currency should be stated here.
     * </p>
     * JONIX adds: this field is optional
     */
    public CurrencyCode currencyCode() {
        _initialize();
        return currencyCode;
    }
}
