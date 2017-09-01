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
 * <h1>Interest age(s)</h1><p>A text element specifying a target interest age of range of ages. which should be entered
 * strictly according to the conventions defined below. Optional and non-repeating. <strong>The &lt;AudienceRange&gt;
 * composite on the next page provides a more general method of handling interest age and other ranges, and is to be
 * preferred.</strong></p><table border='1' cellpadding='3'><tr><td>Format</td><td>Variable length text, maximum 15
 * characters.</td></tr><tr><td></td><td>from n1 to n2&#160;&#160;&#160;&#160;Age range from n1 to n2 from
 * n&#160;&#160;&#160;&#160;From age n upwards to n&#160;&#160;&#160;&#160;Up to age n n&#160;&#160;&#160;&#160;Age n
 * only where n is an integer representing age in years</td></tr><tr><td>Reference
 * name</td><td>&lt;InterestAge&gt;</td></tr><tr><td>Short tag</td><td>&lt;b190&gt;</td></tr><tr><td>Example</td><td>&lt;InterestAge&gt;from
 * 9 to 12&lt;/InterestAge&gt;</td></tr></table>
 */
public class InterestAge implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "InterestAge";
    public static final String shortname = "b190";

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

    /**
     * Raw Format: Variable length text, maximum 15 characters.<p> (type: NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public String _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final InterestAge EMPTY = new InterestAge();

    public InterestAge() {
        exists = false;
    }

    public InterestAge(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsString(element);
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
