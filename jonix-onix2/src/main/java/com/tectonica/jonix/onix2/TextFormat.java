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
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Other text format</h1><p>An ONIX code which identifies the format of text which is sent in the &lt;Text&gt;
 * element, or referenced in the &lt;TextLink&gt; element. Optional and non-repeating. <strong>It is now possible to use
 * a “textformat” attribute in the &lt;Text&gt; element for this purpose, and this is the recommended practise when the
 * text is sent in the ONIX record. The &lt;TextFormat&gt; element may still be used when the text is held outside the
 * ONIX record, and referenced by the &lt;TextLink&gt; element.</strong></p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Fixed-length, two numeric digits</td></tr><tr><td>Codelist</td><td>List
 * 34</td></tr><tr><td>Reference name</td><td>&lt;TextFormat&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;d103&gt;</td></tr><tr><td>Example</td><td>&lt;d103&gt;02&lt;/d103&gt;&#160;&#160;&#160;&#160;HTML</td></tr></table>
 */
public class TextFormat implements OnixElement<TextFormats>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TextFormat";
    public static final String shortname = "d103";

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

    public TextFormats value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public TextFormats _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final TextFormat EMPTY = new TextFormat();

    public TextFormat() {
        exists = false;
    }

    public TextFormat(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = TextFormats.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
