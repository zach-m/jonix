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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.AvailabilityStatuss;
import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Availability status code</h1><p>An ONIX code indicating the availability of a product. Each occurrence of the
 * &lt;SupplyDetail&gt; composite must carry either &lt;AvailabilityCode&gt; or &lt;ProductAvailability&gt;, or both,
 * but &lt;ProductAvailability&gt; is now strongly preferred. Non-repeating.</p><p>Some code values require other
 * accompanying data. Where the code lists state that one of the following is required or may optionally be sent, use
 * the element indicated below:</p><ul>
 * <li>Expected availability date – use &lt;ExpectedShipDate&gt;</li>
 * <li>Remainder date – &lt;ExpectedShipDate&gt; is again used</li>
 * <li>Estimated time to supply – &lt;OrderTime&gt;</li>
 * <li>Identifier of alternative or successor product – &lt;RelatedProduct&gt;, Group&nbsp;PR.23</li>
 * <li>New supplier – &lt;NewSupplier&gt;</li>
 * </ul><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length, two
 * letters</td></tr><tr><td>Codelist</td><td>List 54</td></tr><tr><td>Reference name</td><td>&lt;AvailabilityCode&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;j141&gt;</td></tr><tr><td>Example</td><td>&lt;AvailabilityCode&gt;OP&lt;/AvailabilityCode&gt; Out of
 * print</td></tr></table>
 */
public class AvailabilityCode implements OnixElement<AvailabilityStatuss>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "AvailabilityCode";
    public static final String shortname = "j141";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public AvailabilityStatuss value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public AvailabilityStatuss _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final AvailabilityCode EMPTY = new AvailabilityCode();

    public AvailabilityCode() {
        exists = false;
    }

    public AvailabilityCode(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = AvailabilityStatuss.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
