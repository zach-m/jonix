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
import com.tectonica.jonix.common.codelist.CurrencyCodes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Currency code</h1>
 * <p>
 * An ONIX code identifying the currency in which all monetary amounts in an occurrence of the &lt;Price&gt; composite
 * are stated. Optional and non-repeating, but required if the currency is not the default currency for the message
 * (this default may be set in &lt;DefaultCurrencyCode&gt;&nbsp;– but doing so is deprecated). All ONIX messages must
 * include an explicit statement of the currency used for any prices. To avoid any possible ambiguity, it is strongly
 * recommended that the currency should be stated here for each individual price.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, three letters, based on ISO 4217. Note that ISO 4217 specifies that currency codes shall be sent as
 * upper case only</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 96</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;CurrencyCode&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;j152&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;j152&gt;ZAR&lt;/j152&gt;</tt> (South African Rand)</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;CurrencyCode&gt; from the schema author:
 *
 * The currency in which a price is denominated
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ComparisonProductPrice}&gt;</li>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link ComparisonProductPrice} ⯈
 * {@link CurrencyCode}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link CurrencyCode}</li>
 * </ul>
 */
public class CurrencyCode implements OnixElement<CurrencyCodes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CurrencyCode";
    public static final String shortname = "j152";

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

    public CurrencyCodes value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public CurrencyCodes __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final CurrencyCode EMPTY = new CurrencyCode();

    public CurrencyCode() {
        exists = false;
    }

    public CurrencyCode(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = CurrencyCodes.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;CurrencyCode&gt; or &lt;j152&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<CurrencyCode> action) {
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
