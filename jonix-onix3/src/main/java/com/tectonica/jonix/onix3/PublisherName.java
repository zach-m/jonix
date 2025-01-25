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
 * <h1>Publisher name</h1>
 * <p>
 * The name of an entity associated with the publishing of a product. Mandatory if there is no publisher identifier in
 * an occurrence of the &lt;Publisher&gt; composite, and optional if a publisher identifier is included. Repeatable if
 * the entity is officially known by names in multiple languages. The <i>language</i> attribute is optional for a single
 * instance of &lt;PublisherName&gt;, but must be included in each instance if &lt;PublisherName&gt; is repeated.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text, suggested maximum length 100 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PublisherName&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b081&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>collationkey, language, textscript</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;PublisherName&gt;Reed International Books&lt;/PublisherName&gt;</tt></td>
 * </tr>
 * <tr>
 * <td></td>
 * <td><tt>&lt;b081 language=&quot;eng&quot;&gt;World Health Organization&lt;/b081&gt;</tt> &lt;b081
 * language=&quot;fre&quot;&gt;Organisation mondiale de la sant&#233;&lt;/b081&gt;</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;PublisherName&gt; from the schema author:
 *
 * Name of the organization responsible for publishing the product &#9679; Added textscript attribute at release 3.1
 * &#9679; Added collationkey attribute at revision 3.0.7
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Publisher}&gt;</li>
 * <li>&lt;{@link SalesRights}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Publisher} ⯈ {@link PublisherName}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link Publisher} ⯈ {@link PublisherName}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights} ⯈ {@link PublisherName}</li>
 * </ul>
 */
public class PublisherName implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PublisherName";
    public static final String shortname = "b081";

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

    /**
     * (type: dt.NonEmptyString)
     */
    public String collationkey;

    public Languages language;

    public TextScripts textscript;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of PublisherName. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable length text, suggested maximum length 100 characters
     * <p>
     * (type: dt.NonEmptyString)
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
    public static final PublisherName EMPTY = new PublisherName();

    public PublisherName() {
        exists = false;
    }

    public PublisherName(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        collationkey = JPU.getAttribute(element, "collationkey");
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        textscript = TextScripts.byCode(JPU.getAttribute(element, "textscript"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;PublisherName&gt; or &lt;b081&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PublisherName> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
