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
import com.tectonica.jonix.codelist.ProductAvailabilitys;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product availability</h1><p>An ONIX code indicating the availability of a product from a supplier. Mandatory in
 * each occurrence of the &lt;SupplyDetail&gt; composite, and non-repeating.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Fixed-length, two digits</td></tr><tr><td>Codelist</td><td>List
 * 65</td></tr><tr><td>Reference name</td><td>&lt;ProductAvailability&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;j396&gt;</td></tr><tr><td>Cardinality</td><td>1</td></tr><tr><td>Example</td><td>&lt;j396
 * datestamp=&quot;20101029&quot;&gt;41&lt;/j396&gt; (Replaced by new product)</td></tr><tr><td>Notes</td><td>Note the
 * typical progression of product availability, from initial announcement to one of the forms of 'unavailable'. Not all
 * possible availability codes are shown, particularly within the 'Unavailable' group where there are many more possible
 * options: Temporarily unavailable (3x codes) Available (2x codes) Available (2x codes) Unavailable (4x, 5x codes) OTO
 * (22) POD (23) INS (21) AWS (11) [stock on order] [stock on order] [will not be stock item] ['published', no stock
 * yet] ['published', no stock yet] [publisher abandons] NYA (10) AB (01) [stock in warehouse] NYAD (12) ['publish']
 * ['publish'] RI (33) RP (32) OS (31) [publisher abandons] RPL (41) NLS (43) ALT (42) [POD product] ['Stock' product]
 * Transitions within and between the shaded groups are greatly simplified - for example, it would be unexpected if
 * 'Reprinting' or 'Reissuing' statuses (32 and 33 on List 65) would be followed by anything other than 'In stock' (21),
 * but on occasion where the publisher changes plans, 'Available via POD' (23), 'Only to order' (22), or an
 * 'Unavailable' (4x) code are all possible. Ideally, 'Abandoned' (01) and the 'Unavailable' (4x) codes indicate the end
 * of the product's life, but as with &lt;PublishingStatus&gt;, cancelled or out of print products are occasionally
 * re-activated or re-announced.</td></tr></table>
 */
public class ProductAvailability implements OnixElement<ProductAvailabilitys>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductAvailability";
    public static final String shortname = "j396";

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

    public ProductAvailabilitys value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public ProductAvailabilitys _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ProductAvailability EMPTY = new ProductAvailability();

    public ProductAvailability() {
        exists = false;
    }

    public ProductAvailability(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = ProductAvailabilitys.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
