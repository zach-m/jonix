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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Resource feature value</h1>
 * <p>
 * A controlled value that describes a resource feature. Presence or absence of this element depends on the
 * &lt;ResourceFeatureType&gt;, since some features may not require an accompanying value, while others may require free
 * text in &lt;FeatureNote&gt;; and others may have both code and free text. Non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Dependent on the scheme specified in &lt;ResourceFeatureType&gt;</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>Dependent on the scheme specified in &lt;ResourceFeatureType&gt;</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;FeatureValue&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x439&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;FeatureValue&gt;4&lt;/FeatureValue&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;FeatureValue&gt; from the schema author:
 *
 * Coded or numerical description of a feature of a resource
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ResourceVersionFeature}&gt;</li>
 * <li>&lt;{@link ResourceFeature}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link ResourceVersionFeature} ⯈ {@link FeatureValue}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈
 * {@link ResourceVersionFeature} ⯈ {@link FeatureValue}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈ {@link ResourceVersionFeature} ⯈ {@link FeatureValue}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link ResourceVersionFeature} ⯈ {@link FeatureValue}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceFeature} ⯈ {@link FeatureValue}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link ResourceFeature} ⯈
 * {@link FeatureValue}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link SupportingResource} ⯈ {@link ResourceFeature} ⯈ {@link FeatureValue}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceFeature} ⯈ {@link FeatureValue}</li>
 * </ul>
 */
public class FeatureValue implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "FeatureValue";
    public static final String shortname = "x439";

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
     * This is the raw content of FeatureValue. Could be null if {@code exists() == false}. Use {@link #value()} instead
     * if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Dependent on the scheme specified in &lt;ResourceFeatureType&gt;
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
    public static final FeatureValue EMPTY = new FeatureValue();

    public FeatureValue() {
        exists = false;
    }

    public FeatureValue(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;FeatureValue&gt; or &lt;x439&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<FeatureValue> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
