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
 * <h1>Website description</h1>
 * <p>
 * Free text describing the nature of the website which is linked through the &lt;WebsiteLink&gt; element. Optional and
 * non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length text, suggested maximum length 300 characters (XHTML is enabled in this element - see ONIX for
 * Books - Product Information Message - XML Message Specification, Section 7)</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;WebsiteDescription&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b294&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Website}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link Conference} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link MarketRepresentation} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link RelatedProduct} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link Contributor} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link Publisher} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link RelatedProduct} ⯈ {@link Publisher} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link SubSeriesRecord} ⯈ {@link Publisher} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link MainSeriesRecord} ⯈ {@link Publisher} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * </ul>
 *
 * @since Onix-2.1
 */
public class WebsiteDescription implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "WebsiteDescription";
    public static final String shortname = "b294";

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
     * This is the raw content of WebsiteDescription. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable-length text, suggested maximum length 300 characters (XHTML is enabled in this element - see
     * ONIX for Books - Product Information Message - XML Message Specification, Section 7)
     * <p>
     * (type: XHTML)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final WebsiteDescription EMPTY = new WebsiteDescription();

    public WebsiteDescription() {
        exists = false;
    }

    public WebsiteDescription(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getChildXHTML(element, true);
    }

    /**
     * @return whether this tag (&lt;WebsiteDescription&gt; or &lt;b294&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<WebsiteDescription> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
