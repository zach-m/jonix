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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextScriptCodes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Title prefix</h1><p>Text at the beginning of a title element which is to be ignored for alphabetical sorting.
 * Optional and non-repeating; can only be used when &lt;TitleText&gt; is omitted, and if the &lt;TitleWithoutPrefix&gt;
 * element is also present. These two elements may be used in combination in applications where it is necessary to
 * distinguish an initial word or character string which is to be ignored for filing purposes, <i>eg</i> in library
 * systems and in some bookshop databases.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Variable-length
 * text, suggested maximum 20 characters</td></tr><tr><td>Reference name</td><td>&lt;TitlePrefix&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;b030&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Attributes</td><td>collationkey,
 * language, textscript, textcase</td></tr><tr><td>Example</td><td>&lt;TitlePrefix
 * textcase=&quot;01&quot;&gt;The&lt;/TitlePrefix&gt;</td></tr></table>
 */
public class TitlePrefix implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TitlePrefix";
    public static final String shortname = "b030";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    public String collationkey;

    public LanguageCodes language;

    public TextScriptCodes textscript;

    public TextCaseFlags textcase;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Variable-length text, suggested maximum 20 characters<p> (type: dt.NonEmptyString)
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
    public static final TitlePrefix EMPTY = new TitlePrefix();

    public TitlePrefix() {
        exists = false;
    }

    public TitlePrefix(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
        collationkey = JPU.getAttribute(element, "collationkey");
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        textscript = TextScriptCodes.byCode(JPU.getAttribute(element, "textscript"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));

        value = JPU.getContentAsString(element);
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
