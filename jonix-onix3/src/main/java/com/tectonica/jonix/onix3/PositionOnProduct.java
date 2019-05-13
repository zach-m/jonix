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
import com.tectonica.jonix.codelist.PositionOnProducts;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Position on product</h1><p>An ONIX code indicating a position on a product; in this case, the position in which a
 * price appears. Optional, but must be included if (and only if) the &lt;PrintedOnProduct&gt; element indicates that
 * the price appears on the product, even if the position is ‘unknown’. Non-repeating.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Fixed length, two digits</td></tr><tr><td>Codelist</td><td>List
 * 142</td></tr><tr><td>Reference name</td><td>&lt;PositionOnProduct&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;x313&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td>&lt;x313&gt;01&lt;/x313&gt;
 * (Cover 4 [the back cover of a book])</td></tr></table>
 */
public class PositionOnProduct implements OnixElement<PositionOnProducts>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PositionOnProduct";
    public static final String shortname = "x313";

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

    public PositionOnProducts value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public PositionOnProducts _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final PositionOnProduct EMPTY = new PositionOnProduct();

    public PositionOnProduct() {
        exists = false;
    }

    public PositionOnProduct(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = PositionOnProducts.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
