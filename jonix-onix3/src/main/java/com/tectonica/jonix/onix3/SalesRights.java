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
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sales rights composite</h1><p>An optional and repeatable group of data elements which together identify
 * territorial sales rights which a publisher chooses to exercise in a product. When specifying a territory in which the
 * product is not for sale, the publisher and product ID for an edition which is available in the specified territory
 * can optionally be included. (In previous releases, this functionality was provided in a &lt;NotForSale&gt; composite,
 * which is now redundant and has been deleted.) See examples at the end of the sales rights composite.</p><table
 * border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;SalesRights&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;salesrights&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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
            if (name.equals(SalesRightsType.refname) || name.equals(SalesRightsType.shortname)) {
                salesRightsType = new SalesRightsType(e);
            } else if (name.equals(Territory.refname) || name.equals(Territory.shortname)) {
                territory = new Territory(e);
            } else if (name.equals(SalesRestriction.refname) || name.equals(SalesRestriction.shortname)) {
                salesRestrictions = JPU.addToList(salesRestrictions, new SalesRestriction(e));
            } else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname)) {
                productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
            } else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname)) {
                publisherName = new PublisherName(e);
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

    private SalesRightsType salesRightsType = SalesRightsType.EMPTY;

    /**
     * (this field is required)
     */
    public SalesRightsType salesRightsType() {
        initialize();
        return salesRightsType;
    }

    private Territory territory = Territory.EMPTY;

    /**
     * (this field is required)
     */
    public Territory territory() {
        initialize();
        return territory;
    }

    private List<SalesRestriction> salesRestrictions = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<SalesRestriction> salesRestrictions() {
        initialize();
        return salesRestrictions;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers() {
        initialize();
        return productIdentifiers;
    }

    private PublisherName publisherName = PublisherName.EMPTY;

    /**
     * (this field is optional)
     */
    public PublisherName publisherName() {
        initialize();
        return publisherName;
    }
}
