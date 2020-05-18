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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product form description</h1>
 * <p>
 * If product form codes do not adequately describe the product, a short text description may be added to give a more
 * detailed specification of the product form. The field is optional, and repeatable to provide parallel descriptions in
 * multiple languages. The <i>language</i> attribute is optional for a single instance of
 * &lt;ProductFormDescription&gt;, but must be included in each instance if &lt;ProductFormDescription&gt; is repeated
 * to provide parallel descriptions in multiple languages.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text, suggested maximum length 200 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductFormDescription&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b014&gt;</tt></td>
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
 * <td><tt>&lt;ProductFormDescription
 * language=&quot;eng&quot;&gt;Hardback book die-cut into car shape, with wheels attached to front and back
 * covers&lt;/ProductFormDescription&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * <li>&lt;{@link ProductPart}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ProductFormDescription}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ProductPart} ⯈
 * {@link ProductFormDescription}</li>
 * </ul>
 */
public class ProductFormDescription implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductFormDescription";
    public static final String shortname = "b014";

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

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Variable length text, suggested maximum length 200 characters
     * <p>
     * (type: dt.NonEmptyString)
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
    public static final ProductFormDescription EMPTY = new ProductFormDescription();

    public ProductFormDescription() {
        exists = false;
    }

    public ProductFormDescription(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
        language = Languages.byCode(JPU.getAttribute(element, "language"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;ProductFormDescription&gt; or &lt;b014&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
