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
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.ResourceFileFeatureTypes;
import com.tectonica.jonix.common.struct.JonixResourceFileFeature;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Resource file feature composite</h1>
 * <p>
 * An optional group of data elements which together describe an aspect of a resource file specified in
 * &lt;ResourceFileLink&gt; that is too specific to be covered in the &lt;ResourceFileDetail&gt; element. It may only be
 * used when &lt;ResourceFileLink&gt; is present, and is repeatable in order to describe different aspects of the
 * resource file.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ResourceFileFeature&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;resourcefilefeature&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ResourceFileFeature&gt; from the schema author:
 *
 * &#9679; Added at revision 3.0.8
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link CoverResource}&gt;</li>
 * <li>&lt;{@link BodyResource}&gt;</li>
 * <li>&lt;{@link InsertResource}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link CoverManifest} ⯈ {@link CoverResource} ⯈ {@link ResourceFileFeature}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest} ⯈
 * {@link CoverResource} ⯈ {@link ResourceFileFeature}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link BodyManifest} ⯈ {@link BodyResource} ⯈ {@link ResourceFileFeature}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link BodyManifest} ⯈
 * {@link BodyResource} ⯈ {@link ResourceFileFeature}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link InsertManifest} ⯈ {@link InsertResource} ⯈ {@link ResourceFileFeature}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈
 * {@link InsertResource} ⯈ {@link ResourceFileFeature}</li>
 * </ul>
 *
 * @since Onix-3.08
 */
public class ResourceFileFeature
    implements OnixDataCompositeWithKey<JonixResourceFileFeature, ResourceFileFeatureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ResourceFileFeature";
    public static final String shortname = "resourcefilefeature";

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
    public static final ResourceFileFeature EMPTY = new ResourceFileFeature();

    public ResourceFileFeature() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ResourceFileFeature(org.w3c.dom.Element element) {
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
                case ResourceFileFeatureType.refname:
                case ResourceFileFeatureType.shortname:
                    resourceFileFeatureType = new ResourceFileFeatureType(e);
                    break;
                case ResourceFileFeatureValue.refname:
                case ResourceFileFeatureValue.shortname:
                    resourceFileFeatureValue = new ResourceFileFeatureValue(e);
                    break;
                case ResourceFileFeatureDescription.refname:
                case ResourceFileFeatureDescription.shortname:
                    resourceFileFeatureDescriptions =
                        JPU.addToList(resourceFileFeatureDescriptions, new ResourceFileFeatureDescription(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ResourceFileFeature&gt; or &lt;resourcefilefeature&gt;) is explicitly provided in
     *         the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ResourceFileFeature> action) {
        if (exists) {
            action.accept(this);
        }
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ResourceFileFeatureType resourceFileFeatureType = ResourceFileFeatureType.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the feature of the resource file described by an instance of the
     * &lt;ResourceFileFeature&gt; composite, <i>eg</i> a checksum or hash for the resource file. Mandatory in each
     * occurrence of the composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public ResourceFileFeatureType resourceFileFeatureType() {
        _initialize();
        return resourceFileFeatureType;
    }

    private ResourceFileFeatureValue resourceFileFeatureValue = ResourceFileFeatureValue.EMPTY;

    /**
     * <p>
     * A controlled value that specifies a feature of the resource file. Presence or absence of this element depends on
     * the &lt;ResourceFileFeatureType&gt;, since some feature types may not require an accompanying value, while others
     * may require free text in &lt;ResourceFileFeatureDescription&gt; and some may have both code and free text.
     * Non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ResourceFileFeatureValue resourceFileFeatureValue() {
        _initialize();
        return resourceFileFeatureValue;
    }

    private ListOfOnixElement<ResourceFileFeatureDescription, String> resourceFileFeatureDescriptions =
        ListOfOnixElement.empty();

    /**
     * <p>
     * If the &lt;ResourceFileFeatureType&gt; requires free text rather than a code value, or if the code in
     * &lt;ResourceFileFeatureValue&gt; does not adequately specify the feature of the insert, a short text description
     * may be added. Optional, and repeatable to provide parallel descriptive text in multiple languages. The
     * <i>language</i> attribute is optional for a single instance of &lt;ResourceFileFeatureDescription&gt;, but must
     * be included in each instance if &lt;ResourceFileFeatureDescription&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<ResourceFileFeatureDescription, String> resourceFileFeatureDescriptions() {
        _initialize();
        return resourceFileFeatureDescriptions;
    }

    @Override
    public JonixResourceFileFeature asStruct() {
        _initialize();
        JonixResourceFileFeature struct = new JonixResourceFileFeature();
        struct.resourceFileFeatureType = resourceFileFeatureType.value;
        struct.resourceFileFeatureValue = resourceFileFeatureValue.value;
        struct.resourceFileFeatureDescriptions = resourceFileFeatureDescriptions.values();
        return struct;
    }

    @Override
    public ResourceFileFeatureTypes structKey() {
        return resourceFileFeatureType().value;
    }
}
