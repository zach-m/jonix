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
import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Other text type code</h1><p>An ONIX code which identifies the type of text which is sent in the &lt;Text&gt;
 * element, or referenced in the &lt;TextLink&gt; element. Mandatory in each occurrence of the &lt;OtherText&gt;
 * composite, and non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length, two
 * characters (initially allocated as 01, 02 etc)</td></tr><tr><td>Codelist</td><td>List 33</td></tr><tr><td>Reference
 * name</td><td>&lt;TextTypeCode&gt;</td></tr><tr><td>Short tag</td><td>&lt;d102&gt;</td></tr><tr><td>Example</td><td>&lt;d102&gt;33&lt;/d102&gt;&#160;&#160;&#160;&#160;Introduction
 * text</td></tr></table>
 */
public class TextTypeCode implements OnixElement<OtherTextTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TextTypeCode";
    public static final String shortname = "d102";

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

    public OtherTextTypes value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public OtherTextTypes _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final TextTypeCode EMPTY = new TextTypeCode();

    public TextTypeCode() {
        exists = false;
    }

    public TextTypeCode(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = OtherTextTypes.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
