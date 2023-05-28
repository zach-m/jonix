/*
 * Copyright (C) 2012-2023 Zach Melamed
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
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SupplyDateRoles;
import com.tectonica.jonix.common.struct.JonixSupplyDate;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supply date composite</h1>
 * <p>
 * An optional group of data elements which together specify a date associated with the supply status of the product,
 * <i>eg</i> expected ship date. Repeatable in order to specify multiple dates.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SupplyDate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;supplydate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link SupplyDate}</li>
 * </ul>
 */
public class SupplyDate implements OnixDataCompositeWithKey<JonixSupplyDate, SupplyDateRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SupplyDate";
    public static final String shortname = "supplydate";

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
    public static final SupplyDate EMPTY = new SupplyDate();

    public SupplyDate() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SupplyDate(org.w3c.dom.Element element) {
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
                case SupplyDateRole.refname:
                case SupplyDateRole.shortname:
                    supplyDateRole = new SupplyDateRole(e);
                    break;
                case Date.refname:
                case Date.shortname:
                    date = new Date(e);
                    break;
                case DateFormat.refname:
                case DateFormat.shortname:
                    dateFormat = new DateFormat(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SupplyDate&gt; or &lt;supplydate&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<SupplyDate> action) {
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

    private SupplyDateRole supplyDateRole = SupplyDateRole.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the significance of the date. Mandatory in each occurrence of the &lt;SupplyDate&gt;
     * composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SupplyDateRole supplyDateRole() {
        _initialize();
        return supplyDateRole;
    }

    private Date date = Date.EMPTY;

    /**
     * <p>
     * The date specified in the &lt;SupplyDateRole&gt; field. Mandatory in each occurrence of the &lt;SupplyDate&gt;
     * composite, and non-repeating. &lt;Date&gt; may carry a <i>dateformat</i> attribute: if the attribute is missing,
     * then &lt;DateFormat&gt; indicates the format of the date; if both <i>dateformat</i> attribute and
     * &lt;DateFormat&gt; element are missing, the default format is YYYYMMDD.
     * </p>
     * Jonix-Comment: this field is required
     */
    public Date date() {
        _initialize();
        return date;
    }

    private DateFormat dateFormat = DateFormat.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the format in which the date is given in &lt;Date&gt;. Optional in each occurrence of the
     * &lt;SupplyDate&gt; composite, and non-repeating. Deprecated – where possible, use the <i>dateformat</i> attribute
     * instead.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DateFormat dateFormat() {
        _initialize();
        return dateFormat;
    }

    @Override
    public JonixSupplyDate asStruct() {
        _initialize();
        JonixSupplyDate struct = new JonixSupplyDate();
        struct.supplyDateRole = supplyDateRole.value;
        struct.dateFormat = dateFormat.value;
        struct.date = date.value;
        return struct;
    }

    @Override
    public SupplyDateRoles structKey() {
        return supplyDateRole().value;
    }
}
