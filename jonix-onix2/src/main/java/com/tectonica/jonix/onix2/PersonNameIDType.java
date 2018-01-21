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
import com.tectonica.jonix.codelist.PersonNameIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Person name identifier type</h1><p>An ONIX code which identifies the scheme from which the value in the
 * &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the &lt;PersonNameIdentifier&gt; composite, and
 * non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length, two numeric
 * digits.</td></tr><tr><td>Codelist</td><td>List 101</td></tr><tr><td>Reference name</td><td>&lt;PersonNameIDType&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;b390&gt;</td></tr><tr><td>Example</td><td>&lt;PersonNameIDType&gt;02&lt;/PersonNameIDType&gt;&#160;&#160;&#160;&#160;Personennamendatei</td></tr></table>
 */
public class PersonNameIDType implements OnixElement<PersonNameIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PersonNameIDType";
    public static final String shortname = "b390";

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

    public PersonNameIdentifierTypes value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public PersonNameIdentifierTypes _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final PersonNameIDType EMPTY = new PersonNameIDType();

    public PersonNameIDType() {
        exists = false;
    }

    public PersonNameIDType(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = PersonNameIdentifierTypes.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
