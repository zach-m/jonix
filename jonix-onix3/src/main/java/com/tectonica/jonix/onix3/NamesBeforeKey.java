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
import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextScripts;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Person name part 2: names before key names</h1><p>The second part of a structured name of a person who
 * contributed to the creation of the product: name(s) and/or initial(s) preceding a person’s key name(s), <i>eg</i>
 * James J. Optional and non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Variable length
 * text, suggested maximum length 100 characters</td></tr><tr><td>Reference name</td><td><tt>&lt;NamesBeforeKey&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;b039&gt;</tt></td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Attributes</td><td>collationkey,
 * language, textscript</td></tr><tr><td>Example</td><td><tt>&lt;b039&gt;James J.&lt;/b039&gt;</tt></td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;AlternativeName&gt;</li>
 * <li>&lt;Contributor&gt;</li>
 * <li>&lt;NameAsSubject&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Contributor ⯈ AlternativeName ⯈ NamesBeforeKey</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ Contributor ⯈ AlternativeName ⯈ NamesBeforeKey</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Collection ⯈ Contributor ⯈ AlternativeName ⯈ NamesBeforeKey</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ NameAsSubject ⯈ AlternativeName ⯈ NamesBeforeKey</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ NameAsSubject ⯈ AlternativeName ⯈ NamesBeforeKey</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Contributor ⯈ NamesBeforeKey</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ Contributor ⯈ NamesBeforeKey</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Collection ⯈ Contributor ⯈ NamesBeforeKey</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ NameAsSubject ⯈ NamesBeforeKey</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ NameAsSubject ⯈ NamesBeforeKey</li>
 * </ul>
 */
public class NamesBeforeKey implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "NamesBeforeKey";
    public static final String shortname = "b039";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    /**
     * (type: dt.NonEmptyString)
     */
    public String collationkey;

    public TextScripts textscript;

    public Languages language;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Variable length text, suggested maximum length 100 characters<p> (type: dt.NonEmptyString)
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
    public static final NamesBeforeKey EMPTY = new NamesBeforeKey();

    public NamesBeforeKey() {
        exists = false;
    }

    public NamesBeforeKey(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
        collationkey = JPU.getAttribute(element, "collationkey");
        textscript = TextScripts.byCode(JPU.getAttribute(element, "textscript"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;NamesBeforeKey&gt; or &lt;b039&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
