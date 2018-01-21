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
import com.tectonica.jonix.codelist.BarcodeIndicators;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Barcode indicator</h1><p>An ONIX code indicating whether a product is bar-coded. Optional, and repeatable if the
 * product carries two or more barcodes from different schemes. The absence of this field does NOT mean that a product
 * is not bar-coded.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length, 2 numeric
 * digits</td></tr><tr><td>Codelist</td><td>List 6</td></tr><tr><td>Reference name</td><td>&lt;Barcode&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;b246&gt;</td></tr><tr><td>Example</td><td>&lt;Barcode&gt;01&lt;/Barcode&gt;&#160;&#160;&#160;&#160;Barcoded,
 * scheme unspecified</td></tr></table>
 */
public class Barcode implements OnixElement<BarcodeIndicators>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Barcode";
    public static final String shortname = "b246";

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

    public BarcodeIndicators value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public BarcodeIndicators _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final Barcode EMPTY = new Barcode();

    public Barcode() {
        exists = false;
    }

    public Barcode(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = BarcodeIndicators.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
