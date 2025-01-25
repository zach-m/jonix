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
 * <h1>Product classification code</h1>
 * <p>
 * A classification code from the scheme specified in &lt;ProductClassificationType&gt;. Mandatory in each occurrence of
 * the &lt;ProductClassification&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>According to the identifier type specified in &lt;ProductClassificationType&gt;</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductClassificationCode&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b275&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;b275&gt;55101514&lt;/b275&gt;</tt> (Sheet music in UNSPSC classification scheme)</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ProductClassificationCode&gt; from the schema author:
 *
 * Code from the specified trade classification scheme
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ProductClassification}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ProductClassification} ⯈
 * {@link ProductClassificationCode}</li>
 * </ul>
 */
public class ProductClassificationCode implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductClassificationCode";
    public static final String shortname = "b275";

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

    /**
     * This is the raw content of ProductClassificationCode. Could be null if {@code exists() == false}. Use
     * {@link #value()} instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: According to the identifier type specified in &lt;ProductClassificationType&gt;
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
    public static final ProductClassificationCode EMPTY = new ProductClassificationCode();

    public ProductClassificationCode() {
        exists = false;
    }

    public ProductClassificationCode(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;ProductClassificationCode&gt; or &lt;b275&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ProductClassificationCode> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
