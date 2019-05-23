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
 * <h1>Price amount</h1><p>The amount of a price. Optional and non-repeating, but each occurrence of the &lt;Price&gt;
 * composite must include either a &lt;PriceAmount&gt; or a &lt;PriceCoded&gt; composite, with optional tax details, or
 * an &lt;UnpricedItemType&gt; element. Note that free-of-charge products must use &lt;UnpricedItemType&gt; rather than
 * a zero price.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Positive real number, with explicit decimal
 * point when required, suggested maximum length 12 characters</td></tr><tr><td>Reference
 * name</td><td><tt>&lt;PriceAmount&gt;</tt></td></tr><tr><td>Short tag</td><td><tt>&lt;j151&gt;</tt></td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td><tt>&lt;j151&gt;18.99&lt;/j151&gt;</tt></td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;ComparisonProductPrice&gt;</li>
 * <li>&lt;Price&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ ComparisonProductPrice ⯈
 * PriceAmount</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ ComparisonProductPrice ⯈ PriceAmount</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ PriceAmount</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ PriceAmount</li>
 * </ul>
 */
public class PriceAmount implements OnixElement<Double>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PriceAmount";
    public static final String shortname = "j151";

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
     * Raw Format: Positive real number, with explicit decimal point when required, suggested maximum length 12
     * characters<p> (type: dt.StrictPositiveDecimal)
     */
    public Double value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public Double _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final PriceAmount EMPTY = new PriceAmount();

    public PriceAmount() {
        exists = false;
    }

    public PriceAmount(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsDouble(element);
    }

    /**
     * @return whether this tag (&lt;PriceAmount&gt; or &lt;j151&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
