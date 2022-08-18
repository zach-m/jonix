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
import com.tectonica.jonix.common.codelist.ResourceVersionFeatureTypes;
import com.tectonica.jonix.common.struct.JonixResourceVersionFeature;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Resource version feature composite</h1>
 * <p>
 * A group of data elements which together describe a feature of a supporting resource which is specific to a particular
 * version in which the resource is offered. Formally optional, but it is unlikely that a supporting resource version
 * could be adequately described without specifying some of its features. Repeatable in order to specify multiple
 * features of the version of the resource.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ResourceVersionFeature&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;resourceversionfeature&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ResourceVersion}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource}
 * ⯈ {@link ResourceVersion} ⯈ {@link ResourceVersionFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link ResourceVersionFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈
 * {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈ {@link ResourceVersionFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈
 * {@link EventOccurrence} ⯈ {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈ {@link ResourceVersionFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈
 * {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈ {@link ResourceVersionFeature}</li>
 * </ul>
 */
public class ResourceVersionFeature
    implements OnixDataCompositeWithKey<JonixResourceVersionFeature, ResourceVersionFeatureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ResourceVersionFeature";
    public static final String shortname = "resourceversionfeature";

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
    public static final ResourceVersionFeature EMPTY = new ResourceVersionFeature();

    public ResourceVersionFeature() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ResourceVersionFeature(org.w3c.dom.Element element) {
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
                case ResourceVersionFeatureType.refname:
                case ResourceVersionFeatureType.shortname:
                    resourceVersionFeatureType = new ResourceVersionFeatureType(e);
                    break;
                case FeatureValue.refname:
                case FeatureValue.shortname:
                    featureValue = new FeatureValue(e);
                    break;
                case FeatureNote.refname:
                case FeatureNote.shortname:
                    featureNotes = JPU.addToList(featureNotes, new FeatureNote(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ResourceVersionFeature&gt; or &lt;resourceversionfeature&gt;) is explicitly
     *         provided in the ONIX XML
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

    private ResourceVersionFeatureType resourceVersionFeatureType = ResourceVersionFeatureType.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies a feature described by an instance of the &lt;ResourceVersionFeature&gt; composite.
     * Mandatory in each occurrence of the composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ResourceVersionFeatureType resourceVersionFeatureType() {
        _initialize();
        return resourceVersionFeatureType;
    }

    private FeatureValue featureValue = FeatureValue.EMPTY;

    /**
     * <p>
     * A controlled value that describes a resource version feature. Presence or absence of this element depends on the
     * &lt;ResourceVersionFeatureType&gt;, since some features may not require an accompanying value, while others may
     * require free text in &lt;FeatureNote&gt;, and others may have both a value and free text. Non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public FeatureValue featureValue() {
        _initialize();
        return featureValue;
    }

    private ListOfOnixElement<FeatureNote, String> featureNotes = ListOfOnixElement.empty();

    /**
     * <p>
     * If the &lt;ResourceVersionFeatureType&gt; requires free text rather than a code value, or if the code in
     * &lt;FeatureValue&gt; does not adequately describe the feature, a short text note may be added. Optional, and
     * repeatable when parallel notes are provided in multiple languages. The <i>language</i> attribute is optional for
     * a single instance of &lt;FeatureNote&gt;, but must be included in each instance if &lt;FeatureNote&gt; is
     * repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<FeatureNote, String> featureNotes() {
        _initialize();
        return featureNotes;
    }

    @Override
    public JonixResourceVersionFeature asStruct() {
        _initialize();
        JonixResourceVersionFeature struct = new JonixResourceVersionFeature();
        struct.resourceVersionFeatureType = resourceVersionFeatureType.value;
        struct.featureValue = featureValue.value;
        struct.featureNotes = featureNotes.values();
        return struct;
    }

    @Override
    public ResourceVersionFeatureTypes structKey() {
        return resourceVersionFeatureType().value;
    }
}
