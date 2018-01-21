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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TaxRateCodeds;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Tax rate 1, coded</h1><p>A code which specifies a value added tax rate applying to the whole of the price, or to
 * the amount of the price which is specified in &lt;TaxableAmount1&gt; if present. Optional and non-repeating.</p><p>If
 * the product is taxable at a single rate, or is wholly exempt or zero-rated, &lt;TaxRateCode1&gt; may be sent on its
 * own, or with any combination of &lt;TaxRatePercent1&gt;, &lt;TaxableAmount1&gt; and &lt;TaxAmount1&gt;, although it
 * is best practise to send all these three elements.</p><p>If the product carries mixed tax rates, the minimum
 * requirement is to send &lt;TaxRateCode1&gt;, &lt;TaxRateCode2&gt;, &lt;TaxableAmount1&gt; and &lt;TaxableAmount2&gt;,
 * though again best practise would be to send all eight tax elements so that the tax calculation is made entirely
 * explicit.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length, one
 * letter.</td></tr><tr><td>Codelist</td><td>List 62</td></tr><tr><td>Reference name</td><td>&lt;TaxRateCode1&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;j153&gt;</td></tr><tr><td>Example</td><td>&lt;TaxRateCode1&gt;Z&lt;/TaxRateCode1&gt;&#160;&#160;&#160;&#160;Zero-rated</td></tr></table>
 */
public class TaxRateCode1 implements OnixElement<TaxRateCodeds>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TaxRateCode1";
    public static final String shortname = "j153";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public LanguageCodes language;

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

    public TaxRateCodeds value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public TaxRateCodeds _value() {
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
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = TaxRateCodeds.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
