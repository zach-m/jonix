/*
 * Copyright (C) 2012-2025 Zach Melamed
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
import com.tectonica.jonix.common.codelist.Countrys;
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
 * <h1>Country code</h1>
 * <p>
 * A code identifying a country with which a contributor is particularly associated, when this is significant for the
 * marketing of a product. Optional and repeatable.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length, two letters. [Note that ISO 3166-1 specifies that country codes shall be sent as upper case
 * only.]</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>ISO 3166-1 two-letter country codes List 91</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;CountryCode&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b251&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;CountryCode&gt;US&lt;/CountryCode&gt;</tt> USA</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Price}&gt;</li>
 * <li>&lt;{@link Contributor}&gt;</li>
 * <li>&lt;{@link Language}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link CountryCode}</li>
 * <li>{@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈ {@link CountryCode}</li>
 * <li>{@link Product} ⯈ {@link Contributor} ⯈ {@link CountryCode}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link CountryCode}</li>
 * <li>{@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link CountryCode}</li>
 * <li>{@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link CountryCode}</li>
 * <li>{@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈ {@link CountryCode}</li>
 * <li>{@link Product} ⯈ {@link Language} ⯈ {@link CountryCode}</li>
 * </ul>
 *
 * @since Onix-2.12
 */
public class CountryCode implements OnixElement<Countrys>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CountryCode";
    public static final String shortname = "b251";

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

    public Countrys value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public Countrys __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final CountryCode EMPTY = new CountryCode();

    public CountryCode() {
        exists = false;
    }

    public CountryCode(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = Countrys.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;CountryCode&gt; or &lt;b251&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<CountryCode> action) {
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
