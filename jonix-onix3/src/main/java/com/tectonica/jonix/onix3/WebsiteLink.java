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

package com.tectonica.jonix.onix3;

import java.io.Serializable;
import java.util.function.Consumer;
import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Link to website</h1>
 * <p>
 * The URL for the website. Mandatory in each occurrence of the &lt;Website&gt; composite, and repeatable to provide
 * multiple URLs where the website content is available in multiple languages. The <i>language</i> attribute is optional
 * for a single instance of &lt;WebsiteLink&gt;, but must be included in each instance if &lt;WebsiteLink&gt; is
 * repeated.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Uniform Resource Locator, expressed in full URI syntax in accordance with W3C standards, suggested maximum length
 * 300 characters. Note that non-ASCII characters, spaces and a handful of other special characters should be
 * 'URL-encoded'. Any ampersand used to separate parameters in the URL must be expressed as &amp;amp;</td>
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
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;b295&gt;https://xyzbooks.com/joe_bloggs.htm&lt;/b295&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;WebsiteLink&gt; from the schema author:
 *
 * URL of the website
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Website}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link NewSupplier} ⯈ {@link Website} ⯈
 * {@link WebsiteLink}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Supplier} ⯈ {@link Website} ⯈
 * {@link WebsiteLink}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Publisher} ⯈ {@link Website} ⯈
 * {@link WebsiteLink}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link Publisher} ⯈ {@link Website} ⯈ {@link WebsiteLink}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Event} ⯈ {@link Website} ⯈ {@link WebsiteLink}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈ {@link Website}
 * ⯈ {@link WebsiteLink}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Website} ⯈ {@link WebsiteLink}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link Website} ⯈ {@link WebsiteLink}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link Website} ⯈
 * {@link WebsiteLink}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈ {@link Website} ⯈
 * {@link WebsiteLink}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈ {@link Website} ⯈
 * {@link WebsiteLink}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link MarketPublishingDetail} ⯈ {@link PublisherRepresentative} ⯈
 * {@link Website} ⯈ {@link WebsiteLink}</li>
 * </ul>
 */
public class WebsiteLink implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "WebsiteLink";
    public static final String shortname = "b295";

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

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of WebsiteLink. Could be null if {@code exists() == false}. Use {@link #value()} instead
     * if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Uniform Resource Locator, expressed in full URI syntax in accordance with W3C standards, suggested
     * maximum length 300 characters. Note that non-ASCII characters, spaces and a handful of other special characters
     * should be 'URL-encoded'. Any ampersand used to separate parameters in the URL must be expressed as &amp;amp;
     * <p>
     * (type: dt.NonEmptyURI)
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
    public static final WebsiteLink EMPTY = new WebsiteLink();

    public WebsiteLink() {
        exists = false;
    }

    public WebsiteLink(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;WebsiteLink&gt; or &lt;b295&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<WebsiteLink> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
