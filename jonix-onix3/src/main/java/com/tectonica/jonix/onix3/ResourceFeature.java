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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ResourceFeatureTypes;
import com.tectonica.jonix.struct.JonixResourceFeature;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Resource feature composite</h1><p>A repeatable group of data elements which together describe a feature of a
 * supporting resource which is common to all versions in which the resource is offered. Optional.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;ResourceFeature&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;resourcefeature&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class ResourceFeature
    implements OnixDataCompositeWithKey<JonixResourceFeature, ResourceFeatureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ResourceFeature";
    public static final String shortname = "resourcefeature";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final ResourceFeature EMPTY = new ResourceFeature();

    public ResourceFeature() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ResourceFeature(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            if (name.equals(ResourceFeatureType.refname) || name.equals(ResourceFeatureType.shortname)) {
                resourceFeatureType = new ResourceFeatureType(e);
            } else if (name.equals(FeatureValue.refname) || name.equals(FeatureValue.shortname)) {
                featureValue = new FeatureValue(e);
            } else if (name.equals(FeatureNote.refname) || name.equals(FeatureNote.shortname)) {
                featureNotes = JPU.addToList(featureNotes, new FeatureNote(e));
            }
        });
    }

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ResourceFeatureType resourceFeatureType = ResourceFeatureType.EMPTY;

    /**
     * (this field is required)
     */
    public ResourceFeatureType resourceFeatureType() {
        initialize();
        return resourceFeatureType;
    }

    private FeatureValue featureValue = FeatureValue.EMPTY;

    /**
     * (this field is optional)
     */
    public FeatureValue featureValue() {
        initialize();
        return featureValue;
    }

    private ListOfOnixElement<FeatureNote, String> featureNotes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<FeatureNote, String> featureNotes() {
        initialize();
        return featureNotes;
    }

    @Override
    public JonixResourceFeature asStruct() {
        initialize();
        JonixResourceFeature struct = new JonixResourceFeature();
        struct.resourceFeatureType = resourceFeatureType.value;
        struct.featureValue = featureValue.value;
        struct.featureNotes = featureNotes.values();
        return struct;
    }

    @Override
    public ResourceFeatureTypes structKey() {
        return resourceFeatureType().value;
    }
}
