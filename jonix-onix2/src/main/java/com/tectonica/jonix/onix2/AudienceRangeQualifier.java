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
import com.tectonica.jonix.codelist.AudienceRangeQualifiers;
import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Audience range qualifier</h1><p>An ONIX code specifying the attribute (age, school grade <em>etc</em>) which is
 * measured by the value in the &lt;AudienceRangeValue&gt; element. Mandatory in each occurrence of the
 * &lt;AudienceRange&gt; composite, and non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length,
 * two numeric digits.</td></tr><tr><td>Codelist</td><td>List 30</td></tr><tr><td>Reference
 * name</td><td>&lt;AudienceRangeQualifier&gt;</td></tr><tr><td>Short tag</td><td>&lt;b074&gt;</td></tr><tr><td>Example</td><td>&lt;b074&gt;11&lt;/b074&gt;
 * US School Grade range</td></tr></table>
 */
public class AudienceRangeQualifier implements OnixElement<AudienceRangeQualifiers>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "AudienceRangeQualifier";
    public static final String shortname = "b074";

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

    public AudienceRangeQualifiers value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public AudienceRangeQualifiers _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final AudienceRangeQualifier EMPTY = new AudienceRangeQualifier();

    public AudienceRangeQualifier() {
        exists = false;
    }

    public AudienceRangeQualifier(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = AudienceRangeQualifiers.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
