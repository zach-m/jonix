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
 * <h1>Discount percentage</h1><p>A discount percentage applicable to the price carried in an occurrence of the
 * &lt;Price&gt; composite. Optional and non-repeating; but either &lt;DiscountPercent&gt; or &lt;DiscountAmount&gt; or
 * both must be present in each occurrence of the &lt;Discount&gt; composite.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Variable-length numeric, including decimal point if required, suggested
 * maximum length 6 characters</td></tr><tr><td>Reference name</td><td>&lt;DiscountPercent&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;j267&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td>&lt;DiscountPercent&gt;37.5&lt;/DiscountPercent&gt;</td></tr></table>
 */
public class DiscountPercent implements OnixElement<Double>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "DiscountPercent";
    public static final String shortname = "j267";

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

    /**
     * Raw Format: Variable-length numeric, including decimal point if required, suggested maximum length 6
     * characters<p> (type: dt.PercentDecimal)
     */
    public Double value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public Double _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final DiscountPercent EMPTY = new DiscountPercent();

    public DiscountPercent() {
        exists = false;
    }

    public DiscountPercent(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsDouble(element);
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
