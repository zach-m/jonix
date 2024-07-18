/*
 * Copyright (C) 2012-2024 Zach Melamed
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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.AudienceRangeQualifiers;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Audience range qualifier</h1>
 * <p>
 * An ONIX code specifying the attribute (age, school grade <em>etc</em>) which is measured by the value in the
 * &lt;AudienceRangeValue&gt; element. Mandatory in each occurrence of the &lt;AudienceRange&gt; composite, and
 * non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length, two numeric digits.</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 30</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;AudienceRangeQualifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b074&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;b074&gt;11&lt;/b074&gt;</tt> US School Grade range</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link AudienceRange}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link AudienceRange} ⯈ {@link AudienceRangeQualifier}</li>
 * </ul>
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
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public AudienceRangeQualifiers __v() {
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

    /**
     * @return whether this tag (&lt;AudienceRangeQualifier&gt; or &lt;b074&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<AudienceRangeQualifier> action) {
        if (exists) {
            action.accept(this);
        }
    }

    public String codeOrNull() {
        return value == null ? null : value.code;
    }

    public String descriptionOrNull() {
        return value == null ? null : value.description;
    }
}
