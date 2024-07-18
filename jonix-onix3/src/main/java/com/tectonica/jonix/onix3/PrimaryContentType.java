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
import com.tectonica.jonix.common.codelist.ProductContentTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Primary content type code</h1>
 * <p>
 * An ONIX code which indicates the primary or only content type included in a product. The element is intended to be
 * used in particular for digital products, when the sender wishes to make it clear that one of a number of content
 * types (<i>eg</i> text, audio, video) is the primary type for the product. Other content types may be specified in the
 * &lt;ProductContentType&gt;. Optional and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 81</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PrimaryContentType&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x416&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x416&gt;10&lt;/x416&gt;</tt> (Eye-readable text)</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;PrimaryContentType&gt; from the schema author:
 *
 * The primary type of content (eg text, audio, musical notation) included in the product
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link PrimaryContentType}</li>
 * </ul>
 */
public class PrimaryContentType implements OnixElement<ProductContentTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PrimaryContentType";
    public static final String shortname = "x416";

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

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public ProductContentTypes value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public ProductContentTypes __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final PrimaryContentType EMPTY = new PrimaryContentType();

    public PrimaryContentType() {
        exists = false;
    }

    public PrimaryContentType(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = ProductContentTypes.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;PrimaryContentType&gt; or &lt;x416&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PrimaryContentType> action) {
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
