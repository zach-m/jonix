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
import com.tectonica.jonix.codelist.ComplexitySchemeIdentifiers;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Complexity scheme identifier</h1>
 * <p>
 * An ONIX code specifying the scheme from which the value in &lt;ComplexityCode&gt; is taken. Mandatory in each
 * occurrence of the &lt;Complexity&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 32</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ComplexitySchemeIdentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b077&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;b077&gt;06&lt;/b077&gt;</tt> (Lexile measure)</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Complexity&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Complexity ⯈ ComplexitySchemeIdentifier</li>
 * </ul>
 */
public class ComplexitySchemeIdentifier implements OnixElement<ComplexitySchemeIdentifiers>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ComplexitySchemeIdentifier";
    public static final String shortname = "b077";

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

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public ComplexitySchemeIdentifiers value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public ComplexitySchemeIdentifiers _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ComplexitySchemeIdentifier EMPTY = new ComplexitySchemeIdentifier();

    public ComplexitySchemeIdentifier() {
        exists = false;
    }

    public ComplexitySchemeIdentifier(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = ComplexitySchemeIdentifiers.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;ComplexitySchemeIdentifier&gt; or &lt;b077&gt;) is explicitly provided in the ONIX
     * XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
