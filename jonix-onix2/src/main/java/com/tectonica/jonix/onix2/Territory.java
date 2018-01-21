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
import com.tectonica.jonix.codelist.Regions;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Territory</h1><p>One or more ONIX codes identifying a territory, other than a country, in which the price given
 * in &lt;PriceAmount&gt; applies. Successive codes may be separated by spaces. Thus the element can carry an unlimited
 * number of territory codes. Optional and non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>One
 * or more variable-length codes, each consisting of upper case letters with or without a hyphen, successive codes being
 * separated by spaces. Suggested maximum length 100 characters.</td></tr><tr><td>Codelist</td><td>List 49 Where
 * possible and appropriate, country subdivision codes are derived from the UN LOCODE scheme based on ISO
 * 3166.</td></tr><tr><td>Reference name</td><td>&lt;Territory&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;j303&gt;</td></tr><tr><td>Example</td><td>&lt;Territory&gt;ES-CN&lt;/Territory&gt;&#160;&#160;&#160;&#160;Canary
 * Islands</td></tr></table>
 */
public class Territory implements OnixElement<java.util.Set<Regions>>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Territory";
    public static final String shortname = "j303";

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

    public java.util.Set<Regions> value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public java.util.Set<Regions> _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final Territory EMPTY = new Territory();

    public Territory() {
        exists = false;
    }

    public Territory(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = new java.util.HashSet<>();
        for (String split : JPU.getContentAsString(element).trim().split(" +")) {
            value.add(Regions.byCode(split));
        }
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
