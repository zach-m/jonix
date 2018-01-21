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
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.CountryCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Prize or award country</h1><p>An ISO standard code identifying the country in which a prize or award is given.
 * Optional and non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length, two letters.
 * Note that ISO 3166-1 specifies that country codes shall be sent as upper case only</td></tr><tr><td>Codelist</td><td>ISO
 * 3166-1 two-letter country codes List 91</td></tr><tr><td>Reference name</td><td>&lt;PrizeCountry&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;g128&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td>&lt;g128&gt;US&lt;/g128&gt;</td></tr></table>
 */
public class PrizeCountry implements OnixElement<CountryCodes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PrizeCountry";
    public static final String shortname = "g128";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public CountryCodes value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public CountryCodes _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final PrizeCountry EMPTY = new PrizeCountry();

    public PrizeCountry() {
        exists = false;
    }

    public PrizeCountry(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = CountryCodes.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
