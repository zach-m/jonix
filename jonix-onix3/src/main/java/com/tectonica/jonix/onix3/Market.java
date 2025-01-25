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
 * <h1>Market composite</h1>
 * <p>
 * A group of data elements which together give details of a geographical territory and any non-geographical sales
 * restrictions that apply within it. Optional in terms of the schema definitions, but required in most ONIX
 * applications. If omitted, the geographical extent of the market must be assumed to be the area defined by the sales
 * rights.
 * </p>
 * <p>
 * The &lt;Market&gt; composite is repeatable, but in almost all cases only a single instance is required. It may be
 * repeated if a non-geographical sales restriction applies only to a <em>part</em> of a geographically-defined market –
 * for example where a product is sold throughout the European Union, but exclusive to a single retailer in France.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Market&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;market&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Market&gt; from the schema author:
 *
 * Details of a 'market' or distribution territory, primarily its geographical extent but any sales restrictions
 * applicable within that area
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ProductSupply}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link Market}</li>
 * </ul>
 */
public class Market implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Market";
    public static final String shortname = "market";

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
    public static final Market EMPTY = new Market();

    public Market() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Market(org.w3c.dom.Element element) {
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
                case Territory.refname:
                case Territory.shortname:
                    territory = new Territory(e);
                    break;
                case SalesRestriction.refname:
                case SalesRestriction.shortname:
                    salesRestrictions = JPU.addToList(salesRestrictions, new SalesRestriction(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Market&gt; or &lt;market&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Market> action) {
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

    private Territory territory = Territory.EMPTY;

    /**
     * <p>
     * A group of data elements which together identify a territory forming part or all of a market for which supply
     * detail is given. Mandatory in each occurrence of the &lt;Market&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public Territory territory() {
        _initialize();
        return territory;
    }

    private ListOfOnixComposite<SalesRestriction> salesRestrictions =
        JPU.emptyListOfOnixComposite(SalesRestriction.class);

    /**
     * <p>
     * A group of data elements which together identify a non-territorial sales restriction which applies within a
     * geographical market. Optional, and repeatable if more than a single restriction applies.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<SalesRestriction> salesRestrictions() {
        _initialize();
        return salesRestrictions;
    }
}
