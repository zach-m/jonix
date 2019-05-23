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

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sender contact name</h1><p>Free text giving the name, department, phone number, <i>etc</i> for a contact person
 * in the sender organization who is responsible for the content of the message. Optional and non-repeating.</p><table
 * border='1' cellpadding='3'><tr><td>Format</td><td>Variable length text, suggested maximum 300
 * characters</td></tr><tr><td>Reference name</td><td><tt>&lt;ContactName&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;x299&gt;</tt></td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td><tt>&lt;x299&gt;Jackie
 * Brown, tel. +44 20 7946 0921&lt;/x299&gt;</tt></td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;SupplyContact&gt;</li>
 * <li>&lt;Sender&gt;</li>
 * <li>&lt;ProductContact&gt;</li>
 * <li>&lt;Addressee&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ SupplyContact ⯈ ContactName</li>
 * <li>ONIXMessage ⯈ Header ⯈ Sender ⯈ ContactName</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ ProductContact ⯈ ContactName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ MarketPublishingDetail ⯈ ProductContact ⯈ ContactName</li>
 * <li>ONIXMessage ⯈ Header ⯈ Addressee ⯈ ContactName</li>
 * </ul>
 */
public class ContactName implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ContactName";
    public static final String shortname = "x299";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Variable length text, suggested maximum 300 characters<p> (type: dt.NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ContactName EMPTY = new ContactName();

    public ContactName() {
        exists = false;
    }

    public ContactName(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;ContactName&gt; or &lt;x299&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
