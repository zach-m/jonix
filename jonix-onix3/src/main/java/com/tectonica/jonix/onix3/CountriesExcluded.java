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
 * <h1>Countries excluded</h1><p>One or more ISO standard codes identifying countries excluded from the territory.
 * Successive codes must be separated by spaces. Optional and non-repeating, and can only occur if the
 * &lt;RegionsIncluded&gt; element is also present.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>One or
 * more fixed-length codes, each with two upper case letters, successive codes being separated by spaces. Suggested
 * maximum length 600 characters. Note that ISO 3166-1 specifies that country codes shall be sent as upper case
 * only</td></tr><tr><td>Codelist</td><td>ISO 3166-1 two-letter country codes List 91</td></tr><tr><td>Reference
 * name</td><td>&lt;CountriesExcluded&gt;</td></tr><tr><td>Short tag</td><td>&lt;x451&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td>&lt;CountriesExcluded&gt;US
 * CA&lt;/CountriesExcluded&gt; (Excludes USA and Canada)</td></tr></table>
 */
public class CountriesExcluded implements OnixElement<java.util.Set<CountryCodes>>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CountriesExcluded";
    public static final String shortname = "x451";

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

    public java.util.Set<CountryCodes> value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public java.util.Set<CountryCodes> _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final CountriesExcluded EMPTY = new CountriesExcluded();

    public CountriesExcluded() {
        exists = false;
    }

    public CountriesExcluded(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = new java.util.HashSet<>();
        for (String split : JPU.getContentAsString(element).trim().split(" +")) {
            value.add(CountryCodes.byCode(split));
        }
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
