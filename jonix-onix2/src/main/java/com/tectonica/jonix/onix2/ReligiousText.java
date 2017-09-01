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
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ReligiousTextFeatureTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixReligiousTextFeature;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Religious text composite</h1><p>An optional, non-repeating, group of data elements which together describe
 * features of the content of an edition of a religious text, and intended to meet the special needs of religious
 * publishers and booksellers. The &lt;ReligiousText&gt; composite may carry either a &lt;Bible&gt; composite or a
 * &lt;ReligiousTextID&gt; element accompanied by multiple repeats of the &lt;ReligiousTextFeature&gt; composite. This
 * approach is adopted to enable other devotional texts to be included if need arises without requiring a new ONIX
 * release.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;ReligiousText&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;religioustext&gt;</td></tr></table>
 */
public class ReligiousText implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ReligiousText";
    public static final String shortname = "religioustext";

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
    public static final ReligiousText EMPTY = new ReligiousText();

    public ReligiousText() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ReligiousText(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case Bible.refname:
                case Bible.shortname:
                    bible = new Bible(e);
                    break;
                case ReligiousTextID.refname:
                case ReligiousTextID.shortname:
                    religiousTextID = new ReligiousTextID(e);
                    break;
                case ReligiousTextFeature.refname:
                case ReligiousTextFeature.shortname:
                    religiousTextFeatures = JPU.addToList(religiousTextFeatures, new ReligiousTextFeature(e));
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

    private Bible bible = Bible.EMPTY;

    /**
     * (this field is optional)
     */
    public Bible bible() {
        initialize();
        return bible;
    }

    private ReligiousTextID religiousTextID = ReligiousTextID.EMPTY;

    /**
     * (this field is required)
     */
    public ReligiousTextID religiousTextID() {
        initialize();
        return religiousTextID;
    }

    private ListOfOnixDataCompositeWithKey<ReligiousTextFeature, JonixReligiousTextFeature, ReligiousTextFeatureTypes>
        religiousTextFeatures = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<ReligiousTextFeature, JonixReligiousTextFeature, ReligiousTextFeatureTypes> religiousTextFeatures() {
        initialize();
        return religiousTextFeatures;
    }
}
