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

package com.tectonica.jonix.onix2;

import java.io.Serializable;
import java.util.function.Consumer;
import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Tax rate 1, coded</h1>
 * <p>
 * A code which specifies a value added tax rate applying to the whole of the price, or to the amount of the price which
 * is specified in &lt;TaxableAmount1&gt; if present. Optional and non-repeating.
 * </p>
 * <p>
 * If the product is taxable at a single rate, or is wholly exempt or zero-rated, &lt;TaxRateCode1&gt; may be sent on
 * its own, or with any combination of &lt;TaxRatePercent1&gt;, &lt;TaxableAmount1&gt; and &lt;TaxAmount1&gt;, although
 * it is best practise to send all these three elements.
 * </p>
 * <p>
 * If the product carries mixed tax rates, the minimum requirement is to send &lt;TaxRateCode1&gt;,
 * &lt;TaxRateCode2&gt;, &lt;TaxableAmount1&gt; and &lt;TaxableAmount2&gt;, though again best practise would be to send
 * all eight tax elements so that the tax calculation is made entirely explicit.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length, one letter.</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 62</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;TaxRateCode1&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;j153&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;TaxRateCode1&gt;Z&lt;/TaxRateCode1&gt;</tt> Zero-rated</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link TaxRateCode1}</li>
 * <li>{@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈ {@link TaxRateCode1}</li>
 * </ul>
 */
public class TaxRateCode1 implements OnixElement<TaxRateTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TaxRateCode1";
    public static final String shortname = "j153";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public TaxRateTypes value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public TaxRateTypes __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final TaxRateCode1 EMPTY = new TaxRateCode1();

    public TaxRateCode1() {
        exists = false;
    }

    public TaxRateCode1(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = TaxRateTypes.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;TaxRateCode1&gt; or &lt;j153&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<TaxRateCode1> action) {
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
