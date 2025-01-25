/*
 * Copyright (C) 2012-2025 Zach Melamed
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
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Quantity on hand</h1>
 * <p>
 * The quantity of stock on hand and available to fulfill new orders. Either &lt;StockQuantityCoded&gt; or
 * &lt;OnHand&gt; is mandatory in each occurrence of the &lt;Stock&gt; composite, even if the quantity on hand is zero.
 * Non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Positive or negative integer or zero, suggested maximum length 7 digits. Negative numbers indicate order
 * commitments in excess of the copies on hand for which no further stock has been ordered</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;OnHand&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;j350&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;OnHand&gt;4259&lt;/OnHand&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;OnHand&gt; from the schema author:
 *
 * Quantity of physical copies on hand and available to fulfill new orders (free stock)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Stock}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Stock} ⯈ {@link OnHand}</li>
 * </ul>
 */
public class OnHand implements OnixElement<Integer>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "OnHand";
    public static final String shortname = "j350";

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

    /**
     * This is the raw content of OnHand. Could be null if {@code exists() == false}. Use {@link #value()} instead if
     * you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Positive or negative integer or zero, suggested maximum length 7 digits. Negative numbers indicate
     * order commitments in excess of the copies on hand for which no further stock has been ordered
     * <p>
     * (type: dt.Integer)
     */
    public Integer value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public Integer __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final OnHand EMPTY = new OnHand();

    public OnHand() {
        exists = false;
    }

    public OnHand(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsInteger(element);
    }

    /**
     * @return whether this tag (&lt;OnHand&gt; or &lt;j350&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<OnHand> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
