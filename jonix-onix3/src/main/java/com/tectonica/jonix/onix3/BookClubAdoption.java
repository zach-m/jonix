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
import com.tectonica.jonix.codelist.TextFormats;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Book club adoption</h1><p>Free text describing the adoption of the product as a book club selection. Optional,
 * and repeatable if parallel text is provided in multiple languages. The <i>language</i> attribute is optional for a
 * single instance of &lt;BookClubAdoption&gt;, but must be included in each instance if &lt;BookClubAdoption&gt; is
 * repeated.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Variable length text, suggested maximum length
 * 200 characters. XHTML is enabled in this element - see Using XHTML, HTML or XML with ONIX text
 * fields</td></tr><tr><td>Reference name</td><td><tt>&lt;BookClubAdoption&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;k169&gt;</tt></td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr><tr><td>Attributes</td><td>language,
 * textformat</td></tr><tr><td>Example</td><td><tt>&lt;k169&gt;Book-Of-The-Month Club selection for May
 * 2000&lt;/k169&gt;</tt></td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;MarketPublishingDetail&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ MarketPublishingDetail ⯈ BookClubAdoption</li>
 * </ul>
 */
public class BookClubAdoption implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "BookClubAdoption";
    public static final String shortname = "k169";

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

    public Languages language;

    public TextFormats textformat;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Variable length text, suggested maximum length 200 characters. XHTML is enabled in this element - see
     * Using XHTML, HTML or XML with ONIX text fields<p> (type: XHTML)
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
    public static final BookClubAdoption EMPTY = new BookClubAdoption();

    public BookClubAdoption() {
        exists = false;
    }

    public BookClubAdoption(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));

        value = JPU.getChildXHTML(element, true);
    }

    /**
     * @return whether this tag (&lt;BookClubAdoption&gt; or &lt;k169&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
