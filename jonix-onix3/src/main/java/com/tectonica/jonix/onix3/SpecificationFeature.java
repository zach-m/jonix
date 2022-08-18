/*
 * Copyright (C) 2012-2020 Zach Melamed
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
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SpecificationFeatureTypes;
import com.tectonica.jonix.common.struct.JonixSpecificationFeature;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Specification feature composite</h1>
 * <p>
 * An optional group of data elements which together specify an aspect of the body of the Product or Product part that
 * is too specific to be covered in the &lt;SpecificationDetail&gt; element. Repeatable in order to describe different
 * aspects of the product form.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SpecificationFeature&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;specificationfeature&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link CoverManifest}&gt;</li>
 * <li>&lt;{@link BodyManifest}&gt;</li>
 * <li>&lt;{@link InsertManifest}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈
 * {@link SupplementManifest} ⯈ {@link CoverManifest} ⯈ {@link SpecificationFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈
 * {@link CoverManifest} ⯈ {@link SpecificationFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈
 * {@link SupplementManifest} ⯈ {@link BodyManifest} ⯈ {@link SpecificationFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈
 * {@link BodyManifest} ⯈ {@link SpecificationFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈
 * {@link SupplementManifest} ⯈ {@link InsertManifest} ⯈ {@link SpecificationFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈
 * {@link InsertManifest} ⯈ {@link SpecificationFeature}</li>
 * </ul>
 *
 * @since Onix-3.08
 */
public class SpecificationFeature
    implements OnixDataCompositeWithKey<JonixSpecificationFeature, SpecificationFeatureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SpecificationFeature";
    public static final String shortname = "specificationfeature";

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
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final SpecificationFeature EMPTY = new SpecificationFeature();

    public SpecificationFeature() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SpecificationFeature(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
    }

    @Override
    public void _initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case SpecificationFeatureType.refname:
                case SpecificationFeatureType.shortname:
                    specificationFeatureType = new SpecificationFeatureType(e);
                    break;
                case SpecificationFeatureValue.refname:
                case SpecificationFeatureValue.shortname:
                    specificationFeatureValue = new SpecificationFeatureValue(e);
                    break;
                case SpecificationFeatureDescription.refname:
                case SpecificationFeatureDescription.shortname:
                    specificationFeatureDescriptions =
                        JPU.addToList(specificationFeatureDescriptions, new SpecificationFeatureDescription(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SpecificationFeature&gt; or &lt;specificationfeature&gt;) is explicitly provided in
     *         the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private SpecificationFeatureType specificationFeatureType = SpecificationFeatureType.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the feature described by an instance of the &lt;SpecificationFeature&gt; composite,
     * <i>eg</i> paper color for the body. Mandatory in each occurrence of the composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SpecificationFeatureType specificationFeatureType() {
        _initialize();
        return specificationFeatureType;
    }

    private SpecificationFeatureValue specificationFeatureValue = SpecificationFeatureValue.EMPTY;

    /**
     * <p>
     * A controlled value that specifies a feature of the body of the product. Presence or absence of this element
     * depends on the &lt;SpecificationFeatureType&gt;, since some feature types may not require an accompanying value,
     * while others may require free text in &lt;SpecificationFeatureDescription&gt; and some may have both controlled
     * value and free text. Non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SpecificationFeatureValue specificationFeatureValue() {
        _initialize();
        return specificationFeatureValue;
    }

    private ListOfOnixElement<SpecificationFeatureDescription, String> specificationFeatureDescriptions =
        ListOfOnixElement.empty();

    /**
     * <p>
     * If the &lt;SpecificationFeatureType&gt; requires free text rather than a controlled value, or if the code in
     * &lt;SpecificationFeatureValue&gt; does not adequately specify the feature of the body, a short text description
     * may be added. Optional, and repeatable to provide parallel descriptive text in multiple languages. The
     * <i>language</i> attribute is optional for a single instance of &lt;SpecificationFeatureDescription&gt;, but must
     * be included in each instance if &lt;SpecificationFeatureDescription&gt; is repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<SpecificationFeatureDescription, String> specificationFeatureDescriptions() {
        _initialize();
        return specificationFeatureDescriptions;
    }

    @Override
    public JonixSpecificationFeature asStruct() {
        _initialize();
        JonixSpecificationFeature struct = new JonixSpecificationFeature();
        struct.specificationFeatureType = specificationFeatureType.value;
        struct.specificationFeatureValue = specificationFeatureValue.value;
        struct.specificationFeatureDescriptions = specificationFeatureDescriptions.values();
        return struct;
    }

    @Override
    public SpecificationFeatureTypes structKey() {
        return specificationFeatureType().value;
    }
}
