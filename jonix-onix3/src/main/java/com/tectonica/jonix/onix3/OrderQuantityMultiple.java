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
 * <h1>Order quantity multiple</h1><p>The order quantity multiple that must be used in any order for the product placed
 * with the supplier. Optional, but where supplied, must be preceded by at least one &lt;OrderQuantityMinimum&gt;
 * element. For example with a minimum order quantity of 6 and a multiple of 4, orders for 6, 10 or 14 copies are
 * acceptable, but orders for fewer than 6, or for 7, 8, 9 or 11 copies are not. If omitted, the minimum or any larger
 * quantity may be ordered.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Positive integer, suggested
 * maximum length 4 digits</td></tr><tr><td>Reference name</td><td>&lt;OrderQuantityMultiple&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;x533&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td>&lt;OrderQuantityMultiple&gt;4&lt;/OrderQuantityMultiple&gt;</td></tr></table>
 */
public class OrderQuantityMultiple implements OnixElement<Integer>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "OrderQuantityMultiple";
    public static final String shortname = "x533";

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
     * Raw Format: Positive integer, suggested maximum length 4 digits<p> (type: dt.StrictPositiveInteger)
     */
    public Integer value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public Integer _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final OrderQuantityMultiple EMPTY = new OrderQuantityMultiple();

    public OrderQuantityMultiple() {
        exists = false;
    }

    public OrderQuantityMultiple(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsInteger(element);
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
