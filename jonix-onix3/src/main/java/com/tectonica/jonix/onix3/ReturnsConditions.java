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
import com.tectonica.jonix.codelist.ReturnsConditionsCodeTypes;
import com.tectonica.jonix.struct.JonixReturnsConditions;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Returns conditions composite</h1><p>An optional and repeatable group of data elements which together allow
 * returns conditions to be specified in coded form.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;ReturnsConditions&gt;</td></tr><tr><td>Short tag</td><td>&lt;returnsconditions&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class ReturnsConditions
    implements OnixDataCompositeWithKey<JonixReturnsConditions, ReturnsConditionsCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ReturnsConditions";
    public static final String shortname = "returnsconditions";

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
    public static final ReturnsConditions EMPTY = new ReturnsConditions();

    public ReturnsConditions() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ReturnsConditions(org.w3c.dom.Element element) {
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
                case ReturnsCodeType.refname:
                case ReturnsCodeType.shortname:
                    returnsCodeType = new ReturnsCodeType(e);
                    break;
                case ReturnsCodeTypeName.refname:
                case ReturnsCodeTypeName.shortname:
                    returnsCodeTypeName = new ReturnsCodeTypeName(e);
                    break;
                case ReturnsCode.refname:
                case ReturnsCode.shortname:
                    returnsCode = new ReturnsCode(e);
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

    private ReturnsCodeType returnsCodeType = ReturnsCodeType.EMPTY;

    /**
     * (this field is required)
     */
    public ReturnsCodeType returnsCodeType() {
        _initialize();
        return returnsCodeType;
    }

    private ReturnsCodeTypeName returnsCodeTypeName = ReturnsCodeTypeName.EMPTY;

    /**
     * (this field is optional)
     */
    public ReturnsCodeTypeName returnsCodeTypeName() {
        _initialize();
        return returnsCodeTypeName;
    }

    private ReturnsCode returnsCode = ReturnsCode.EMPTY;

    /**
     * (this field is required)
     */
    public ReturnsCode returnsCode() {
        _initialize();
        return returnsCode;
    }

    @Override
    public JonixReturnsConditions asStruct() {
        _initialize();
        JonixReturnsConditions struct = new JonixReturnsConditions();
        struct.returnsCodeType = returnsCodeType.value;
        struct.returnsCodeTypeName = returnsCodeTypeName.value;
        struct.returnsCode = returnsCode.value;
        return struct;
    }

    @Override
    public ReturnsConditionsCodeTypes structKey() {
        return returnsCodeType().value;
    }
}
