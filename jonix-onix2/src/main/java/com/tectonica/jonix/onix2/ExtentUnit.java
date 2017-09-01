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
import com.tectonica.jonix.codelist.ExtentUnits;
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
 * <h1>Extent unit</h1><p>An ONIX code indicating the unit used for the &lt;ExtentValue&gt; and the format in which the
 * value is presented. Mandatory in each occurrence of the &lt;Extent&gt; composite, and non-repeating.</p><table
 * border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length, two numeric digits</td></tr><tr><td>Codelist</td><td>List
 * 24</td></tr><tr><td>Reference name</td><td>&lt;ExtentUnit&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;b220&gt;</td></tr><tr><td>Example</td><td>&lt;ExtentUnit&gt;04&lt;/ExtentUnit&gt;&#160;&#160;&#160;&#160;Hours
 * as integer and decimals</td></tr></table>
 */
public class ExtentUnit implements OnixElement<ExtentUnits>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ExtentUnit";
    public static final String shortname = "b220";

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

    public ExtentUnits value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public ExtentUnits _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ExtentUnit EMPTY = new ExtentUnit();

    public ExtentUnit() {
        exists = false;
    }

    public ExtentUnit(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = ExtentUnits.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
