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
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Batch quantity</h1>
 * <p>
 * The number of copies which must be ordered to obtain the free copies specified in &lt;FreeQuantity&gt;. Mandatory in
 * each occurrence of the &lt;BatchBonus&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Positive integer, suggested maximum length 4 digits</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;BatchQuantity&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;j264&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;j264&gt;20&lt;/j264&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;BatchQuantity&gt; from the schema author:
 *
 * Number of copies in a single order required for a specified number of bonus copies
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link BatchBonus}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link BatchBonus} ⯈
 * {@link BatchQuantity}</li>
 * </ul>
 */
public class BatchQuantity implements OnixElement<Integer>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "BatchQuantity";
    public static final String shortname = "j264";

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
     * This is the raw content of BatchQuantity. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Positive integer, suggested maximum length 4 digits
     * <p>
     * (type: dt.PositiveInteger)
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
    public static final BatchQuantity EMPTY = new BatchQuantity();

    public BatchQuantity() {
        exists = false;
    }

    public BatchQuantity(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsInteger(element);
    }

    /**
     * @return whether this tag (&lt;BatchQuantity&gt; or &lt;j264&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<BatchQuantity> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
