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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ReligiousTextFeatureTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixReligiousTextFeature;

import java.io.Serializable;
import java.util.Arrays;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Religious text feature composite</h1><p>A repeatable group of data elements which together specify and describe a
 * feature of a religious text.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;ReligiousTextFeature&gt;</td></tr><tr><td>Short tag</td><td>&lt;religioustextfeature&gt;</td></tr></table>
 */
public class ReligiousTextFeature
    implements OnixDataCompositeWithKey<JonixReligiousTextFeature, ReligiousTextFeatureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ReligiousTextFeature";
    public static final String shortname = "religioustextfeature";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public LanguageCodes language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
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
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
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
                    religiousTextFeatureDescription = new ReligiousTextFeatureDescription(e);
                    break;
                default:
                    break;
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
        _initialize();
        return religiousTextFeatureType;
    }

    private ReligiousTextFeatureCode religiousTextFeatureCode = ReligiousTextFeatureCode.EMPTY;

    /**
     * (this field is required)
     */
    public ReligiousTextFeatureCode religiousTextFeatureCode() {
        _initialize();
        return religiousTextFeatureCode;
    }

    private ReligiousTextFeatureDescription religiousTextFeatureDescription = ReligiousTextFeatureDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public ReligiousTextFeatureDescription religiousTextFeatureDescription() {
        _initialize();
        return religiousTextFeatureDescription;
    }

    @Override
    public JonixReligiousTextFeature asStruct() {
        _initialize();
        JonixReligiousTextFeature struct = new JonixReligiousTextFeature();
        struct.religiousTextFeatureType = religiousTextFeatureType.value;
        struct.religiousTextFeatureCode = religiousTextFeatureCode.value;
        struct.religiousTextFeatureDescriptions = Arrays.asList(religiousTextFeatureDescription.value);
        return struct;
    }

    @Override
    public ReligiousTextFeatureTypes structKey() {
        return religiousTextFeatureType().value;
    }
}
