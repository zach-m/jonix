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

import java.io.Serializable;
import java.util.function.Consumer;
import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Returns conditions code</h1>
 * <p>
 * A returns conditions code from the scheme specified in &lt;ReturnsCodeType&gt;. Mandatory in each occurrence of the
 * &lt;ReturnsConditions&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>According to the scheme specified in &lt;ReturnsCodeType&gt;</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>for values defined by BISAC for US use, see List 66. For other uses see List 204</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ReturnsCode&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;j269&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;j269&gt;S&lt;/j269&gt;</tt> (Stripped cover returnable)</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ReturnsConditions}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link ReturnsConditions} ⯈
 * {@link ReturnsCode}</li>
 * </ul>
 */
public class ReturnsCode implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ReturnsCode";
    public static final String shortname = "j269";

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
     * This is the raw content of ReturnsCode. Could be null if {@code exists() == false}. Use {@link #value()} instead
     * if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: According to the scheme specified in &lt;ReturnsCodeType&gt;
     * <p>
     * (type: dt.NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ReturnsCode EMPTY = new ReturnsCode();

    public ReturnsCode() {
        exists = false;
    }

    public ReturnsCode(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;ReturnsCode&gt; or &lt;j269&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ReturnsCode> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
