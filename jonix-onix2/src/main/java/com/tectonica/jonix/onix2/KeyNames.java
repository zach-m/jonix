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
 * <h1>Person name part 4: key name(s)</h1><p>The fourth part of a structured name of a person who contributed to the
 * creation of the product: key name(s), <em>ie</em> the name elements normally used to open an entry in an alphabetical
 * list, <em>eg</em> Smith or Garcia Marquez or Madonna or Francis de Sales (in Saint Francis de Sales). Optional and
 * non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Variable-length text, suggested maximum
 * length 100 characters</td></tr><tr><td>Reference name</td><td><tt>&lt;KeyNames&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;b040&gt;</tt></td></tr><tr><td>Example</td><td><tt>&lt;KeyNames&gt;Beethoven&lt;/KeyNames&gt;</tt></td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Name&gt;</li>
 * <li>&lt;Contributor&gt;</li>
 * <li>&lt;PersonAsSubject&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ Contributor ⯈ Name ⯈ KeyNames</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Contributor ⯈ Name ⯈ KeyNames</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ Contributor ⯈ Name ⯈ KeyNames</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ Contributor ⯈ Name ⯈ KeyNames</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ Contributor ⯈ Name ⯈ KeyNames</li>
 * <li>ONIXMessage ⯈ Product ⯈ PersonAsSubject ⯈ Name ⯈ KeyNames</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ PersonAsSubject ⯈ Name ⯈ KeyNames</li>
 * <li>ONIXMessage ⯈ Product ⯈ Contributor ⯈ KeyNames</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Contributor ⯈ KeyNames</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ Contributor ⯈ KeyNames</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ Contributor ⯈ KeyNames</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ Contributor ⯈ KeyNames</li>
 * <li>ONIXMessage ⯈ Product ⯈ PersonAsSubject ⯈ KeyNames</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ PersonAsSubject ⯈ KeyNames</li>
 * </ul>
 */
public class KeyNames implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "KeyNames";
    public static final String shortname = "b040";

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

    /**
     * Raw Format: Variable-length text, suggested maximum length 100 characters<p> (type: NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final KeyNames EMPTY = new KeyNames();

    public KeyNames() {
        exists = false;
    }

    public KeyNames(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;KeyNames&gt; or &lt;b040&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
