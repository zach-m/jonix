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
import com.tectonica.jonix.codelist.IllustrationAndOtherContentTypes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixIllustrations;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Illustrations and other content composite</h1><p>A repeatable group of data elements which together specify the
 * number of illustrations or other content items of a stated type which the product carries. Use of the
 * &lt;Illustrations&gt; composite is optional.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;Illustrations&gt;</td></tr><tr><td>Short tag</td><td>&lt;illustrations&gt;</td></tr></table>
 */
public class Illustrations
    implements OnixDataCompositeWithKey<JonixIllustrations, IllustrationAndOtherContentTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Illustrations";
    public static final String shortname = "illustrations";

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
    public static final Illustrations EMPTY = new Illustrations();

    public Illustrations() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Illustrations(org.w3c.dom.Element element) {
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
            if (name.equals(IllustrationType.refname) || name.equals(IllustrationType.shortname)) {
                illustrationType = new IllustrationType(e);
            } else if (name.equals(IllustrationTypeDescription.refname) ||
                name.equals(IllustrationTypeDescription.shortname)) {
                illustrationTypeDescription = new IllustrationTypeDescription(e);
            } else if (name.equals(Number.refname) || name.equals(Number.shortname)) {
                number = new Number(e);
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

    private IllustrationType illustrationType = IllustrationType.EMPTY;

    /**
     * (this field is required)
     */
    public IllustrationType illustrationType() {
        initialize();
        return illustrationType;
    }

    private IllustrationTypeDescription illustrationTypeDescription = IllustrationTypeDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public IllustrationTypeDescription illustrationTypeDescription() {
        initialize();
        return illustrationTypeDescription;
    }

    private Number number = Number.EMPTY;

    /**
     * (this field is optional)
     */
    public Number number() {
        initialize();
        return number;
    }

    @Override
    public JonixIllustrations asStruct() {
        initialize();
        JonixIllustrations struct = new JonixIllustrations();
        struct.illustrationType = illustrationType.value;
        struct.illustrationTypeDescription = illustrationTypeDescription.value;
        struct.number = number.value;
        return struct;
    }

    @Override
    public IllustrationAndOtherContentTypes structKey() {
        return illustrationType().value;
    }
}
