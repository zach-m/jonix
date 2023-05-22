/*
 * Copyright (C) 2012-2023 Zach Melamed
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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Default currency</h1>
 * <p>
 * An ONIX code indicating the default currency which is assumed for prices of products listed in the message, unless
 * the Currency code is explicitly stated by sending a Currency code in each &lt;Price&gt; composite for each Product
 * record. Optional and non-repeating. To avoid any possible ambiguity, use of this default is deprecated, but any
 * default supplied will be assumed for all prices in Group&nbsp;P.26 which do not specify the Currency code explicitly.
 * It is strongly recommended that the Currency code should be specified in the &lt;Price&gt; composite for each
 * individual price.
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
 * <td><tt>&lt;DefaultCurrencyCode&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;m186&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;DefaultCurrencyCode&gt;USD&lt;/DefaultCurrencyCode&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Header}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Header} ⯈ {@link DefaultCurrencyCode}</li>
 * </ul>
 *
 * @deprecated
 */
@Deprecated
public class DefaultCurrencyCode implements OnixElement<CurrencyCodes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "DefaultCurrencyCode";
    public static final String shortname = "m186";

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
    public static final DefaultCurrencyCode EMPTY = new DefaultCurrencyCode();

    public DefaultCurrencyCode() {
        exists = false;
    }

    public DefaultCurrencyCode(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = CurrencyCodes.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;DefaultCurrencyCode&gt; or &lt;m186&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
