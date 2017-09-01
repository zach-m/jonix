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
import com.tectonica.jonix.codelist.PrintedOnProducts;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Price printed on product</h1><p>An ONIX code indicating whether the price in a &lt;Price&gt; composite is printed
 * on the product. Optional and non-repeating. Omission of this element must <em>not</em> be interpreted as indicating
 * that the price is not printed on the product.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length,
 * two digits</td></tr><tr><td>Codelist</td><td>List 174</td></tr><tr><td>Reference
 * name</td><td>&lt;PrintedOnProduct&gt;</td></tr><tr><td>Short tag</td><td>&lt;x301&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td>&lt;x301&gt;02&lt;/x301&gt;
 * (Price is printed on product)</td></tr></table>
 */
public class PrintedOnProduct implements OnixElement<PrintedOnProducts>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PrintedOnProduct";
    public static final String shortname = "x301";

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

    public PrintedOnProducts value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public PrintedOnProducts _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final PrintedOnProduct EMPTY = new PrintedOnProduct();

    public PrintedOnProduct() {
        exists = false;
    }

    public PrintedOnProduct(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = PrintedOnProducts.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
