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
 * <h1>Text source link</h1>
 * <p>
 * A URL which provides a link to a full text accessible in digital form, from which the supporting text in &lt;Text&gt;
 * is an extract. Use, for example, to link to an original review. Optional, and repeatable if the resource can be
 * linked in more than one way, <i>eg</i> by URL or DOI, or where a linked full text is available in multiple parallel
 * languages. Where multiple languages are used, all repeats must carry the <i>language</i> attribute.
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
 * <td><tt>&lt;TextSourceLink&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x581&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x581&gt;https://www.nytimes.com/archives/2012-08-04/Berni%e8res.htm&lt;/x581&gt;</tt> (note URL-encoding
 * of &#232;)</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;TextSourceLink&gt; from the schema author:
 *
 * URL which provides access to full text content used for marketing and promotional purposes (eg a link to the full
 * text of a review) &#9679; Added at release 3.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link TextContent}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈ {@link TextSourceLink}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link TextSourceLink}</li>
 * </ul>
 *
 * @since Onix-3.10
 */
public class TextSourceLink implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TextSourceLink";
    public static final String shortname = "x581";

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
     * This is the raw content of TextSourceLink. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
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
    public static final TextSourceLink EMPTY = new TextSourceLink();

    public TextSourceLink() {
        exists = false;
    }

    public TextSourceLink(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;TextSourceLink&gt; or &lt;x581&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<TextSourceLink> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
