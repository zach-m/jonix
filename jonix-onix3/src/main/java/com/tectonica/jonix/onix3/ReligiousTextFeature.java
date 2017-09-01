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
import com.tectonica.jonix.codelist.ReligiousTextFeatureTypes;
import com.tectonica.jonix.struct.JonixReligiousTextFeature;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Religious text feature composite</h1><p>A repeatable group of data elements which together specify and describe a
 * feature of a religious text. Mandatory if and only if &lt;ReligiousTextIdentifier&gt; is present.</p><table
 * border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;ReligiousTextFeature&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;religioustextfeature&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    public String sourcename;

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
            if (name.equals(ReligiousTextFeatureType.refname) || name.equals(ReligiousTextFeatureType.shortname)) {
                religiousTextFeatureType = new ReligiousTextFeatureType(e);
            } else if (name.equals(ReligiousTextFeatureCode.refname) ||
                name.equals(ReligiousTextFeatureCode.shortname)) {
                religiousTextFeatureCode = new ReligiousTextFeatureCode(e);
            } else if (name.equals(ReligiousTextFeatureDescription.refname) ||
                name.equals(ReligiousTextFeatureDescription.shortname)) {
                religiousTextFeatureDescriptions =
                    JPU.addToList(religiousTextFeatureDescriptions, new ReligiousTextFeatureDescription(e));
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

    private ReligiousTextFeatureType religiousTextFeatureType = ReligiousTextFeatureType.EMPTY;

    /**
     * (this field is required)
     */
    public ReligiousTextFeatureType religiousTextFeatureType() {
        initialize();
        return religiousTextFeatureType;
    }

    private ReligiousTextFeatureCode religiousTextFeatureCode = ReligiousTextFeatureCode.EMPTY;

    /**
     * (this field is required)
     */
    public ReligiousTextFeatureCode religiousTextFeatureCode() {
        initialize();
        return religiousTextFeatureCode;
    }

    private ListOfOnixElement<ReligiousTextFeatureDescription, String> religiousTextFeatureDescriptions =
        ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ReligiousTextFeatureDescription, String> religiousTextFeatureDescriptions() {
        initialize();
        return religiousTextFeatureDescriptions;
    }

    @Override
    public JonixReligiousTextFeature asStruct() {
        initialize();
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
