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
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SupplyDateRoles;
import com.tectonica.jonix.struct.JonixSupplyDate;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supply date composite</h1><p>An optional and repeatable group of data elements which together specify a date
 * associated with the supply status of the product, <i>eg</i> expected ship date.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;SupplyDate&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;supplydate&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    public String sourcename;

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
            switch (name) {
                case SupplyDateRole.refname:
                case SupplyDateRole.shortname:
                    supplyDateRole = new SupplyDateRole(e);
                    break;
                case DateFormat.refname:
                case DateFormat.shortname:
                    dateFormat = new DateFormat(e);
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

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private SupplyDateRole supplyDateRole = SupplyDateRole.EMPTY;

    /**
     * (this field is required)
     */
    public SupplyDateRole supplyDateRole() {
        initialize();
        return supplyDateRole;
    }

    private DateFormat dateFormat = DateFormat.EMPTY;

    /**
     * (this field is optional)
     */
    public DateFormat dateFormat() {
        initialize();
        return dateFormat;
    }

    private Date date = Date.EMPTY;

    /**
     * (this field is required)
     */
    public Date date() {
        initialize();
        return date;
    }

    @Override
    public JonixSupplyDate asStruct() {
        initialize();
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
