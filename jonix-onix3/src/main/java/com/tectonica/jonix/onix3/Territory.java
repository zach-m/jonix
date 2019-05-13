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
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixTerritory;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Territory composite</h1><p>A group of data elements which together identify a territory within which the price
 * stated in an occurrence of the &lt;Price&gt; composite is applicable. Optional and
 * non-repeating.</p><p><strong>Additional guidance on the description of price territories in ONIX&nbsp;3.0 will be
 * found in a separate document <cite>ONIX for Books Product Information Message: How to Specify Markets and Suppliers
 * in ONIX 3</cite>.</strong></p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;Territory&gt;</td></tr><tr><td>Short tag</td><td>&lt;territory&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr></table>
 */
public class Territory implements OnixDataComposite<JonixTerritory>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Territory";
    public static final String shortname = "territory";

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
    public static final Territory EMPTY = new Territory();

    public Territory() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Territory(org.w3c.dom.Element element) {
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
                case CountriesIncluded.refname:
                case CountriesIncluded.shortname:
                    countriesIncluded = new CountriesIncluded(e);
                    break;
                case RegionsIncluded.refname:
                case RegionsIncluded.shortname:
                    regionsIncluded = new RegionsIncluded(e);
                    break;
                case RegionsExcluded.refname:
                case RegionsExcluded.shortname:
                    regionsExcluded = new RegionsExcluded(e);
                    break;
                case CountriesExcluded.refname:
                case CountriesExcluded.shortname:
                    countriesExcluded = new CountriesExcluded(e);
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

    private CountriesIncluded countriesIncluded = CountriesIncluded.EMPTY;

    /**
     * (this field is required)
     */
    public CountriesIncluded countriesIncluded() {
        _initialize();
        return countriesIncluded;
    }

    private RegionsIncluded regionsIncluded = RegionsIncluded.EMPTY;

    /**
     * (this field is optional)
     */
    public RegionsIncluded regionsIncluded() {
        _initialize();
        return regionsIncluded;
    }

    private RegionsExcluded regionsExcluded = RegionsExcluded.EMPTY;

    /**
     * (this field is optional)
     */
    public RegionsExcluded regionsExcluded() {
        _initialize();
        return regionsExcluded;
    }

    private CountriesExcluded countriesExcluded = CountriesExcluded.EMPTY;

    /**
     * (this field is optional)
     */
    public CountriesExcluded countriesExcluded() {
        _initialize();
        return countriesExcluded;
    }

    @Override
    public JonixTerritory asStruct() {
        _initialize();
        JonixTerritory struct = new JonixTerritory();
        struct.countriesIncluded = countriesIncluded.value;
        struct.regionsIncluded = regionsIncluded.value;
        struct.regionsExcluded = regionsExcluded.value;
        struct.countriesExcluded = countriesExcluded.value;
        return struct;
    }
}
