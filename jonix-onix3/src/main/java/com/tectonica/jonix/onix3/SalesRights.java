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
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sales rights composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together identify territorial sales rights which a publisher
 * chooses to exercise in a product. When specifying a territory in which the product is not for sale, the publisher and
 * product ID for an edition which is available in the specified territory can optionally be included. (In previous
 * releases, this functionality was provided in a &lt;NotForSale&gt; composite, which is now redundant and has been
 * deleted.) See examples at the end of the sales rights composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SalesRights&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;salesrights&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PublishingDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights}</li>
 * </ul>
 */
public class SalesRights implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SalesRights";
    public static final String shortname = "salesrights";

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
    public static final SalesRights EMPTY = new SalesRights();

    public SalesRights() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SalesRights(org.w3c.dom.Element element) {
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
                case SalesRightsType.refname:
                case SalesRightsType.shortname:
                    salesRightsType = new SalesRightsType(e);
                    break;
                case Territory.refname:
                case Territory.shortname:
                    territory = new Territory(e);
                    break;
                case PublisherName.refname:
                case PublisherName.shortname:
                    publisherName = new PublisherName(e);
                    break;
                case SalesRestriction.refname:
                case SalesRestriction.shortname:
                    salesRestrictions = JPU.addToList(salesRestrictions, new SalesRestriction(e));
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
     * @return whether this tag (&lt;SalesRights&gt; or &lt;salesrights&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private SalesRightsType salesRightsType = SalesRightsType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the type of sales right or exclusion which applies in the territories which are
     * associated with it. Mandatory in each occurrence of the &lt;SalesRights&gt; composite, and non-repeating. Values
     * include: for sale with exclusive rights, for sale with non-exclusive rights, not for sale.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SalesRightsType salesRightsType() {
        _initialize();
        return salesRightsType;
    }

    private Territory territory = Territory.EMPTY;

    /**
     * <p>
     * A group of data elements which together identify a territory in which the rights specified in
     * &lt;SalesRightsType&gt; are applicable. Mandatory in each occurrence of the &lt;SalesRights&gt; composite, and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public Territory territory() {
        _initialize();
        return territory;
    }

    private PublisherName publisherName = PublisherName.EMPTY;

    /**
     * <p>
     * The name of the publisher of an equivalent product which is available in the territory specified in the
     * &lt;SalesRights&gt; composite, used only when &lt;SalesRightsType&gt; has a value indicating ‘not for sale’.
     * Optional and non-repeating. Except where they are essential to the recognized form of the name, it is recommended
     * that suffixes denoting incorporation (‘Co’, ‘Inc’, ‘Ltd’, ‘SA’, ‘GmbH’ <i>etc</i>) should be omitted.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PublisherName publisherName() {
        _initialize();
        return publisherName;
    }

    private List<SalesRestriction> salesRestrictions = Collections.emptyList();

    /**
     * <p>
     * A group of data elements which together identify a non-territorial sales restriction which a publisher applies to
     * a product within a particular territory. Optional, and repeatable if more than a single restriction applies.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<SalesRestriction> salesRestrictions() {
        _initialize();
        return salesRestrictions;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier,
        ProductIdentifierTypes> productIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * An optional group of data elements which together define the identifier of a product in accordance with a
     * specified scheme. Used here only if &lt;SalesRightsType&gt; has a value indicating ‘not for sale’, in order to
     * specify an equivalent product which <em>is</em> available to be sold in the territory in question. Repeatable
     * with different identifiers for the same product.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }
}
