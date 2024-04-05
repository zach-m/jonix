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

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>License expression type name</h1>
 * <p>
 * A short free-text name for a license expression type, when the code in &lt;EpubLicenseExpressionType&gt; provides
 * insufficient detail – for example when a machine-readable license is expressed using a particular proprietary
 * encoding scheme. Optional and non-repeating, and must be included when (and only when) the
 * &lt;EpubLicenseExpressionType&gt; element indicates the expression is encoded in a proprietary way.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text, suggested maximum length 50 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;EpubLicenseExpressionTypeName&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x509&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x509&gt;ABC-XML&lt;/x509&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;EpubLicenseExpressionTypeName&gt; from the schema author:
 * 
 * <pre>
 * &#9679; Added at revision 3.0.2
 * </pre>
 * 
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link EpubLicenseExpression}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link EpubLicenseType} ⯈
 * {@link EpubLicenseExpression} ⯈ {@link EpubLicenseExpressionTypeName}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseExpression} ⯈
 * {@link EpubLicenseExpressionTypeName}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link EpubLicenseWithDateType} ⯈
 * {@link EpubLicenseExpression} ⯈ {@link EpubLicenseExpressionTypeName}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈
 * {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseExpression} ⯈ {@link EpubLicenseExpressionTypeName}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link EpubLicenseWithDateType} ⯈
 * {@link EpubLicenseExpression} ⯈ {@link EpubLicenseExpressionTypeName}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseExpression} ⯈
 * {@link EpubLicenseExpressionTypeName}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈
 * {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseExpression} ⯈ {@link EpubLicenseExpressionTypeName}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType} ⯈
 * {@link EpubLicenseExpression} ⯈ {@link EpubLicenseExpressionTypeName}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseExpression} ⯈
 * {@link EpubLicenseExpressionTypeName}</li>
 * </ul>
 *
 * @since Onix-3.02
 */
public class EpubLicenseExpressionTypeName implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EpubLicenseExpressionTypeName";
    public static final String shortname = "x509";

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
     * This is the raw content of EpubLicenseExpressionTypeName. Could be null if {@code exists() == false}. Use
     * {@link #value()} instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable length text, suggested maximum length 50 characters
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
    public static final EpubLicenseExpressionTypeName EMPTY = new EpubLicenseExpressionTypeName();

    public EpubLicenseExpressionTypeName() {
        exists = false;
    }

    public EpubLicenseExpressionTypeName(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;EpubLicenseExpressionTypeName&gt; or &lt;x509&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<EpubLicenseExpressionTypeName> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
