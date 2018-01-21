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
import com.tectonica.jonix.codelist.TextFormats;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sales restriction note</h1><p>A free text field describing an ‘unspecified’ restriction, or giving more
 * explanation of a coded restriction type. Optional, and repeatable if parallel notes are provided in multiple
 * languages. The <i>language</i> attribute is optional for a single instance of &lt;SalesRestrictionNote&gt;, but must
 * be included in each instance if &lt;SalesRestrictionNote&gt; is repeated.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Variable-length text, suggested maximum length 300 characters. XHTML is
 * enabled in this element - see Using XHTML, HTML or XML with ONIX text fields</td></tr><tr><td>Reference
 * name</td><td>&lt;SalesRestrictionNote&gt;</td></tr><tr><td>Short tag</td><td>&lt;x453&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr><tr><td>Attributes</td><td>language,
 * textformat</td></tr><tr><td>Example</td><td>&#160;</td></tr></table>
 */
public class SalesRestrictionNote implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SalesRestrictionNote";
    public static final String shortname = "x453";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    public LanguageCodes language;

    public TextFormats textformat;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Variable-length text, suggested maximum length 300 characters. XHTML is enabled in this element - see
     * Using XHTML, HTML or XML with ONIX text fields<p> (type: XHTML)
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
    public static final SalesRestrictionNote EMPTY = new SalesRestrictionNote();

    public SalesRestrictionNote() {
        exists = false;
    }

    public SalesRestrictionNote(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));

        value = JPU.getChildXHTML(element, true);
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
