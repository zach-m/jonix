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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextFormats;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Website description</h1>
 * <p>
 * Free text describing the nature of the website which is linked through the &lt;WebsiteLink&gt; element. Optional, and
 * repeatable to provide parallel descriptive text in multiple languages. The <i>language</i> attribute is optional for
 * a single instance of &lt;WebsiteDescription&gt;, but must be included in each instance if &lt;WebsiteDescription&gt;
 * is repeated.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text, suggested maximum length 300 characters. XHTML is enabled in this element - see Using
 * XHTML, HTML or XML with ONIX text fields</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;WebsiteDescription&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b294&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language, textformat</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;b294&gt;Includes author bio, gallery of photos, interview, complete bibliography and links to download book covers as mobile phone wallpapers&lt;/b294&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;WebsiteDescription&gt; from the schema author:
 *
 * Textual description of the website &#9679; Added language attribute at revision 3.0.6
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Website}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Conference} ⯈ {@link Website} ⯈
 * {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Supplier} ⯈ {@link Website} ⯈
 * {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link Publisher} ⯈ {@link Website} ⯈
 * {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Event} ⯈ {@link Website} ⯈ {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈ {@link Website}
 * ⯈ {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Website} ⯈
 * {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link Website} ⯈
 * {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link Website} ⯈
 * {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈ {@link Website} ⯈
 * {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈ {@link Website} ⯈
 * {@link WebsiteDescription}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link MarketPublishingDetail} ⯈ {@link PublisherRepresentative} ⯈
 * {@link Website} ⯈ {@link WebsiteDescription}</li>
 * </ul>
 */
public class WebsiteDescription implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "WebsiteDescription";
    public static final String shortname = "b294";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

    public Languages language;

    public TextFormats textformat;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of WebsiteDescription. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable length text, suggested maximum length 300 characters. XHTML is enabled in this element - see
     * Using XHTML, HTML or XML with ONIX text fields
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
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));

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
