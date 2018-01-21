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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SalesRightsTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Rest of World sales rights type code</h1><p>An ONIX code describing the sales rights applicable in territories
 * not specifically associated with a sales right within an occurrence of the &lt;SalesRights&gt; composite. Optional,
 * but required in all cases where no sales rights type is associated with the region ‘WORLD’, and in all cases where a
 * sales rights type is associated with ‘WORLD’ but with exclusions that are not themselves associated with a sales
 * rights type. Not repeatable. Note the value ‘00’ should be used to indicate where sales rights are genuinely unknown,
 * or are unstated for any reason – in this case, data recipients must not assume anything about the rights that are
 * applicable.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length, two
 * digits</td></tr><tr><td>Codelist</td><td>List 46</td></tr><tr><td>Reference name</td><td>&lt;ROWSalesRightsType&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;x456&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td>&lt;x456&gt;00&lt;/x456&gt;
 * (Unknown or unstated)</td></tr></table>
 */
public class ROWSalesRightsType implements OnixElement<SalesRightsTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ROWSalesRightsType";
    public static final String shortname = "x456";

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

    public SalesRightsTypes value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public SalesRightsTypes _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ROWSalesRightsType EMPTY = new ROWSalesRightsType();

    public ROWSalesRightsType() {
        exists = false;
    }

    public ROWSalesRightsType(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = SalesRightsTypes.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
