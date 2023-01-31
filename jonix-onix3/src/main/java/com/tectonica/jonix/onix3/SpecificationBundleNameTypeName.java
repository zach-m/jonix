/*
 * Copyright (C) 2012-2023 Zach Melamed
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
 * <h1>Bundle name type name</h1>
 * <p>
 * A name which identifies a particular proprietary naming scheme. Must be included to indicate the proprietary naming
 * scheme from which the &lt;SpecificationBundleNameValue&gt; is taken. Mandatory and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text, suggested maximum length 50 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SpecificationBundleNameTypeName&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x558&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x558&gt;Ingram POD ProdType&lt;/x558&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SpecificationBundleName}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈
 * {@link SupplementManifest} ⯈ {@link CoverManifest} ⯈ {@link SpecificationBundleName} ⯈
 * {@link SpecificationBundleNameTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈
 * {@link CoverManifest} ⯈ {@link SpecificationBundleName} ⯈ {@link SpecificationBundleNameTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈
 * {@link SupplementManifest} ⯈ {@link BodyManifest} ⯈ {@link SpecificationBundleName} ⯈
 * {@link SpecificationBundleNameTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈
 * {@link BodyManifest} ⯈ {@link SpecificationBundleName} ⯈ {@link SpecificationBundleNameTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈
 * {@link SupplementManifest} ⯈ {@link InsertManifest} ⯈ {@link SpecificationBundleName} ⯈
 * {@link SpecificationBundleNameTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈
 * {@link InsertManifest} ⯈ {@link SpecificationBundleName} ⯈ {@link SpecificationBundleNameTypeName}</li>
 * </ul>
 *
 * @since Onix-3.08
 */
public class SpecificationBundleNameTypeName implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SpecificationBundleNameTypeName";
    public static final String shortname = "x558";

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
     * This is the raw content of SpecificationBundleNameTypeName. Could be null if {@code exists() == false}. Use
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
    public String _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final SpecificationBundleNameTypeName EMPTY = new SpecificationBundleNameTypeName();

    public SpecificationBundleNameTypeName() {
        exists = false;
    }

    public SpecificationBundleNameTypeName(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;SpecificationBundleNameTypeName&gt; or &lt;x558&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}