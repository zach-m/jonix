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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SalesOutletIdentifierTypes;
import com.tectonica.jonix.struct.JonixSalesOutletIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sales outlet composite</h1><p>An optional and repeatable group of data elements which together identify a sales
 * outlet to which a restriction is linked. Each occurrence of the composite must include a
 * &lt;SalesOutletIdentifier&gt; composite of a &lt;SalesOutletName&gt; or both.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;SalesOutlet&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;salesoutlet&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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
            if (name.equals(SalesOutletIdentifier.refname) || name.equals(SalesOutletIdentifier.shortname)) {
                salesOutletIdentifiers = JPU.addToList(salesOutletIdentifiers, new SalesOutletIdentifier(e));
            } else if (name.equals(SalesOutletName.refname) || name.equals(SalesOutletName.shortname)) {
                salesOutletName = new SalesOutletName(e);
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

    private ListOfOnixDataCompositeWithKey<SalesOutletIdentifier, JonixSalesOutletIdentifier, SalesOutletIdentifierTypes>
        salesOutletIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<SalesOutletIdentifier, JonixSalesOutletIdentifier, SalesOutletIdentifierTypes> salesOutletIdentifiers() {
        initialize();
        return salesOutletIdentifiers;
    }

    private SalesOutletName salesOutletName = SalesOutletName.EMPTY;

    /**
     * (this field is optional)
     */
    public SalesOutletName salesOutletName() {
        initialize();
        return salesOutletName;
    }
}
