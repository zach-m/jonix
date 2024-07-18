/*
 * Copyright (C) 2012-2024 Zach Melamed
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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.ProductAvailabilitys;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product availability</h1>
 * <p>
 * An ONIX code indicating the availability of a product from a supplier. Mandatory in each occurrence of the
 * &lt;SupplyDetail&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 65</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductAvailability&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;j396&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;j396 datestamp=&quot;20101029&quot;&gt;41&lt;/j396&gt;</tt> (Replaced by new product)</td>
 * </tr>
 * <tr>
 * <td>Notes</td>
 * <td>Note the typical progression of product availability, from initial announcement to one of the forms of
 * 'unavailable'. Not all possible availability codes are shown, particularly within the 'Unavailable' group where there
 * are many more possible options: Temporarily unavailable (3x codes) Available (2x codes) Available (2x codes)
 * Unavailable (4x, 5x codes) OTO (22) POD (23) INS (21) AWS (11) [stock on order] [stock on order] [will not be stock
 * item] ['published', no stock yet] ['published', no stock yet] [publisher abandons] NYA (10) AB (01) [stock in
 * warehouse] NYAD (12) ['publish'] ['publish'] RI (33) RP (32) OS (31) [publisher abandons] RPL (41) NLS (43) ALT (42)
 * [POD product] ['Stock' product] Transitions within and between the shaded groups are greatly simplified - for
 * example, it would be unexpected if 'Reprinting' or 'Reissuing' statuses (32 and 33 on List 65) would be followed by
 * anything other than 'In stock' (21), but on occasion where the publisher changes plans, 'Available via POD' (23),
 * 'Only to order' (22), or an 'Unavailable' (4x) code are all possible. Ideally, 'Abandoned' (01) and the 'Unavailable'
 * (4x) codes indicate the end of the product's life, but as with &lt;PublishingStatus&gt;, cancelled or out of print
 * products are occasionally re-activated or re-announced.</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ProductAvailability&gt; from the schema author:
 *
 * The availability of the product from a particular supplier
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link ProductAvailability}</li>
 * </ul>
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

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public ProductAvailabilitys value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public ProductAvailabilitys __v() {
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
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = ProductAvailabilitys.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;ProductAvailability&gt; or &lt;j396&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ProductAvailability> action) {
        if (exists) {
            action.accept(this);
        }
    }

    public String codeOrNull() {
        return value == null ? null : value.code;
    }

    public String descriptionOrNull() {
        return value == null ? null : value.description;
    }
}
