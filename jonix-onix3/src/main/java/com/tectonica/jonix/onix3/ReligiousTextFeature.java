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
import com.tectonica.jonix.common.codelist.ReligiousTextFeatureTypes;
import com.tectonica.jonix.common.struct.JonixReligiousTextFeature;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Religious text feature composite</h1>
 * <p>
 * A repeatable group of data elements which together specify and describe a feature of a religious text. Mandatory if
 * and only if &lt;ReligiousTextIdentifier&gt; is present.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ReligiousTextFeature&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;religioustextfeature&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ReligiousText}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ReligiousText} ⯈
 * {@link ReligiousTextFeature}</li>
 * </ul>
 */
public class ReligiousTextFeature
    implements OnixDataCompositeWithKey<JonixReligiousTextFeature, ReligiousTextFeatureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ReligiousTextFeature";
    public static final String shortname = "religioustextfeature";

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
    public static final ReligiousTextFeature EMPTY = new ReligiousTextFeature();

    public ReligiousTextFeature() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ReligiousTextFeature(org.w3c.dom.Element element) {
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
                case ReligiousTextFeatureType.refname:
                case ReligiousTextFeatureType.shortname:
                    religiousTextFeatureType = new ReligiousTextFeatureType(e);
                    break;
                case ReligiousTextFeatureCode.refname:
                case ReligiousTextFeatureCode.shortname:
                    religiousTextFeatureCode = new ReligiousTextFeatureCode(e);
                    break;
                case ReligiousTextFeatureDescription.refname:
                case ReligiousTextFeatureDescription.shortname:
                    religiousTextFeatureDescriptions =
                        JPU.addToList(religiousTextFeatureDescriptions, new ReligiousTextFeatureDescription(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ReligiousTextFeature&gt; or &lt;religioustextfeature&gt;) is explicitly provided in
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

    private ReligiousTextFeatureType religiousTextFeatureType = ReligiousTextFeatureType.EMPTY;

    /**
     * <p>
     * An ONIX code specifying a feature described in the associated &lt;ReligiousTextFeatureCode&gt; element. Mandatory
     * in each occurrence of the &lt;ReligiousTextFeature&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ReligiousTextFeatureType religiousTextFeatureType() {
        _initialize();
        return religiousTextFeatureType;
    }

    private ReligiousTextFeatureCode religiousTextFeatureCode = ReligiousTextFeatureCode.EMPTY;

    /**
     * <p>
     * An ONIX code describing a feature specified in the associated &lt;ReligiousTextFeatureType&gt; element. Mandatory
     * in each occurrence of the &lt;ReligiousTextFeature&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ReligiousTextFeatureCode religiousTextFeatureCode() {
        _initialize();
        return religiousTextFeatureCode;
    }

    private ListOfOnixElement<ReligiousTextFeatureDescription, String> religiousTextFeatureDescriptions =
        ListOfOnixElement.empty();

    /**
     * <p>
     * Free text describing a feature that is not adequately defined by code values alone. Optional, and repeatable if
     * parallel descriptive text is provided in multiple languages. The <i>language</i> attribute is optional for a
     * single instance of &lt;ReligiousTextFeatureDescription&gt;, but must be included in each instance if
     * &lt;ReligiousTextFeatureDescription&gt; is repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ReligiousTextFeatureDescription, String> religiousTextFeatureDescriptions() {
        _initialize();
        return religiousTextFeatureDescriptions;
    }

    @Override
    public JonixReligiousTextFeature asStruct() {
        _initialize();
        JonixReligiousTextFeature struct = new JonixReligiousTextFeature();
        struct.religiousTextFeatureType = religiousTextFeatureType.value;
        struct.religiousTextFeatureCode = religiousTextFeatureCode.value;
        struct.religiousTextFeatureDescriptions = religiousTextFeatureDescriptions.values();
        return struct;
    }

    @Override
    public ReligiousTextFeatureTypes structKey() {
        return religiousTextFeatureType().value;
    }
}
