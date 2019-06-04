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
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SalesOutletIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixSalesOutletIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sales outlet composite</h1>
 * <p>
 * An optional group of data elements which together identify a sales outlet to which a restriction is linked. Each
 * occurrence of the composite must include a &lt;SalesOutletIdentifier&gt; composite or a &lt;SalesOutletName&gt; or
 * both. Repeatable in order to identify multiple sales outlets subject to the restriction.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SalesOutlet&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;salesoutlet&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;SalesRestriction&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ SalesRestriction ⯈ SalesOutlet</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ Market ⯈ SalesRestriction ⯈ SalesOutlet</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ SalesRights ⯈ SalesRestriction ⯈ SalesOutlet</li>
 * </ul>
 */
public class SalesOutlet implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SalesOutlet";
    public static final String shortname = "salesoutlet";

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
    public static final SalesOutlet EMPTY = new SalesOutlet();

    public SalesOutlet() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SalesOutlet(org.w3c.dom.Element element) {
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
                case SalesOutletIdentifier.refname:
                case SalesOutletIdentifier.shortname:
                    salesOutletIdentifiers = JPU.addToList(salesOutletIdentifiers, new SalesOutletIdentifier(e));
                    break;
                case SalesOutletName.refname:
                case SalesOutletName.shortname:
                    salesOutletName = new SalesOutletName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SalesOutlet&gt; or &lt;salesoutlet&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ListOfOnixDataCompositeWithKey<SalesOutletIdentifier, JonixSalesOutletIdentifier, SalesOutletIdentifierTypes>
        salesOutletIdentifiers = ListOfOnixDataCompositeWithKey
        .emptyKeyed();

    /**
     * <p>
     * An optional group of data elements which together represent a coded identification of an organization, used here
     * to identify a sales outlet. Repeatable in order to specify multiple identifiers for the same sales outlet.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<SalesOutletIdentifier, JonixSalesOutletIdentifier, SalesOutletIdentifierTypes> salesOutletIdentifiers() {
        _initialize();
        return salesOutletIdentifiers;
    }

    private SalesOutletName salesOutletName = SalesOutletName.EMPTY;

    /**
     * <p>
     * The name of a wholesale or retail sales outlet to which a sales restriction is linked. Non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SalesOutletName salesOutletName() {
        _initialize();
        return salesOutletName;
    }
}
