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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.PriceDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixPriceDate;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Price date composite</h1>
 * <p>
 * An optional group of data elements which together specify a date associated with a price, repeatable in order to
 * specify multiple associated dates.
 * </p>
 * <p>
 * Note that if no dates are specified, the price is effective at the time the ONIX message is sent.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PriceDate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;pricedate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;PriceDate&gt; from the schema author:
 *
 * Date of the specified role relating to the price &#9679; Removed &lt;DateFormat&gt; at release 3.1 &#9679; Modified
 * cardinality of &lt;DateFormat&gt; at revision 3.0 (2010)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link PriceDate}</li>
 * </ul>
 */
public class PriceDate implements OnixDataCompositeWithKey<JonixPriceDate, PriceDateRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PriceDate";
    public static final String shortname = "pricedate";

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
    public static final PriceDate EMPTY = new PriceDate();

    public PriceDate() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PriceDate(org.w3c.dom.Element element) {
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
                case PriceDateRole.refname:
                case PriceDateRole.shortname:
                    priceDateRole = new PriceDateRole(e);
                    break;
                case Date.refname:
                case Date.shortname:
                    date = new Date(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PriceDate&gt; or &lt;pricedate&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PriceDate> action) {
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

    private PriceDateRole priceDateRole = PriceDateRole.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the significance of the date. Mandatory in each occurrence of the &lt;PriceDate&gt;
     * composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public PriceDateRole priceDateRole() {
        _initialize();
        return priceDateRole;
    }

    private Date date = Date.EMPTY;

    /**
     * <p>
     * The date specified in the &lt;PriceDateRole&gt; field. Mandatory in each occurrence of the &lt;PriceDate&gt;
     * composite, and non-repeating. &lt;Date&gt; may carry a <i>dateformat</i> attribute: if the attribute is missing,
     * then the default format is YYYYMMDD.
     * </p>
     * JONIX adds: this field is required
     */
    public Date date() {
        _initialize();
        return date;
    }

    @Override
    public JonixPriceDate asStruct() {
        _initialize();
        JonixPriceDate struct = new JonixPriceDate();
        struct.priceDateRole = priceDateRole.value;
        struct.date = date.value;
        return struct;
    }

    @Override
    public PriceDateRoles structKey() {
        return priceDateRole().value;
    }
}
