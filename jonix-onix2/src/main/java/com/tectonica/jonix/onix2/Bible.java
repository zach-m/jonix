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
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.BibleContentss;
import com.tectonica.jonix.codelist.BiblePurposes;
import com.tectonica.jonix.codelist.BibleTextFeatures;
import com.tectonica.jonix.codelist.BibleVersions;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixBible;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Bible composite</h1><p>A group of data elements which together describe features of an edition of the Bible or of
 * a selected Biblical text. Mandatory in each occurrence of the &lt;ReligiousText&gt; composite that does not include a
 * &lt;ReligiousTextID&gt; element, and non-repeating.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;Bible&gt;</td></tr><tr><td>Short tag</td><td>&lt;bible&gt;</td></tr></table>
 */
public class Bible implements OnixDataComposite<JonixBible>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Bible";
    public static final String shortname = "bible";

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
    public static final Bible EMPTY = new Bible();

    public Bible() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Bible(org.w3c.dom.Element element) {
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
            if (name.equals(BibleContents.refname) || name.equals(BibleContents.shortname)) {
                bibleContentss = JPU.addToList(bibleContentss, new BibleContents(e));
            } else if (name.equals(BibleVersion.refname) || name.equals(BibleVersion.shortname)) {
                bibleVersions = JPU.addToList(bibleVersions, new BibleVersion(e));
            } else if (name.equals(StudyBibleType.refname) || name.equals(StudyBibleType.shortname)) {
                studyBibleType = new StudyBibleType(e);
            } else if (name.equals(BiblePurpose.refname) || name.equals(BiblePurpose.shortname)) {
                biblePurposes = JPU.addToList(biblePurposes, new BiblePurpose(e));
            } else if (name.equals(BibleTextOrganization.refname) || name.equals(BibleTextOrganization.shortname)) {
                bibleTextOrganization = new BibleTextOrganization(e);
            } else if (name.equals(BibleReferenceLocation.refname) || name.equals(BibleReferenceLocation.shortname)) {
                bibleReferenceLocation = new BibleReferenceLocation(e);
            } else if (name.equals(BibleTextFeature.refname) || name.equals(BibleTextFeature.shortname)) {
                bibleTextFeatures = JPU.addToList(bibleTextFeatures, new BibleTextFeature(e));
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

    private ListOfOnixElement<BibleContents, BibleContentss> bibleContentss = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<BibleContents, BibleContentss> bibleContentss() {
        initialize();
        return bibleContentss;
    }

    private ListOfOnixElement<BibleVersion, BibleVersions> bibleVersions = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<BibleVersion, BibleVersions> bibleVersions() {
        initialize();
        return bibleVersions;
    }

    private StudyBibleType studyBibleType = StudyBibleType.EMPTY;

    /**
     * (this field is optional)
     */
    public StudyBibleType studyBibleType() {
        initialize();
        return studyBibleType;
    }

    private ListOfOnixElement<BiblePurpose, BiblePurposes> biblePurposes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<BiblePurpose, BiblePurposes> biblePurposes() {
        initialize();
        return biblePurposes;
    }

    private BibleTextOrganization bibleTextOrganization = BibleTextOrganization.EMPTY;

    /**
     * (this field is optional)
     */
    public BibleTextOrganization bibleTextOrganization() {
        initialize();
        return bibleTextOrganization;
    }

    private BibleReferenceLocation bibleReferenceLocation = BibleReferenceLocation.EMPTY;

    /**
     * (this field is optional)
     */
    public BibleReferenceLocation bibleReferenceLocation() {
        initialize();
        return bibleReferenceLocation;
    }

    private ListOfOnixElement<BibleTextFeature, BibleTextFeatures> bibleTextFeatures = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<BibleTextFeature, BibleTextFeatures> bibleTextFeatures() {
        initialize();
        return bibleTextFeatures;
    }

    @Override
    public JonixBible asStruct() {
        initialize();
        JonixBible struct = new JonixBible();
        struct.bibleContentss = bibleContentss.values();
        struct.biblePurposes = biblePurposes.values();
        struct.bibleReferenceLocation = bibleReferenceLocation.value;
        struct.bibleTextFeatures = bibleTextFeatures.values();
        struct.bibleTextOrganization = bibleTextOrganization.value;
        struct.bibleVersions = bibleVersions.values();
        struct.studyBibleType = studyBibleType.value;
        return struct;
    }
}
