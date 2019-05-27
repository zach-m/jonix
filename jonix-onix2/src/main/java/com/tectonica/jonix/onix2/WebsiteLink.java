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
 * <h1>Link to website</h1>
 * <p>
 * The URL for the website. Mandatory in each occurrence of the &lt;Website&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length text, suggested maximum length 300 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;WebsiteLink&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b295&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;b295&gt;http://xyzbooks.com/ISTC123456789.htm&lt;/b295&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Website&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ Product ⯈ Conference ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ Product ⯈ SupplyDetail ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ Product ⯈ MarketRepresentation ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ Product ⯈ RelatedProduct ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ Product ⯈ Contributor ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Contributor ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ Contributor ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ Contributor ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ Contributor ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ Product ⯈ Publisher ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ Product ⯈ RelatedProduct ⯈ Publisher ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ Publisher ⯈ Website ⯈ WebsiteLink</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ Publisher ⯈ Website ⯈ WebsiteLink</li>
 * </ul>
 */
public class WebsiteLink implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "WebsiteLink";
    public static final String shortname = "b295";

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
     * Raw Format: Variable-length text, suggested maximum length 300 characters
     * <p>
     * (type: NonEmptyString)
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
    public static final WebsiteLink EMPTY = new WebsiteLink();

    public WebsiteLink() {
        exists = false;
    }

    public WebsiteLink(org.w3c.dom.Element element) {
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
     * @return whether this tag (&lt;WebsiteLink&gt; or &lt;b295&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
