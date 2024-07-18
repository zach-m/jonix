/*
 * Copyright (C) 2012-2024 Zach Melamed
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
import com.tectonica.jonix.common.ListOfOnixCodelist;
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.BibleContentss;
import com.tectonica.jonix.common.codelist.BiblePurposes;
import com.tectonica.jonix.common.codelist.BibleTextFeatures;
import com.tectonica.jonix.common.codelist.BibleVersions;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixBible;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Bible composite</h1>
 * <p>
 * A group of data elements which together describe features of an edition of the Bible or of a selected Biblical text.
 * Mandatory in each occurrence of the &lt;ReligiousText&gt; composite that does <em>not</em> include a
 * &lt;ReligiousTextIdentifier&gt; element, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Bible&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;bible&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ReligiousText}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ReligiousText} ⯈ {@link Bible}</li>
 * </ul>
 */
public class Bible implements OnixDataComposite<JonixBible>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Bible";
    public static final String shortname = "bible";

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
                case BibleContents.refname:
                case BibleContents.shortname:
                    bibleContentss = JPU.addToList(bibleContentss, new BibleContents(e));
                    break;
                case BibleVersion.refname:
                case BibleVersion.shortname:
                    bibleVersions = JPU.addToList(bibleVersions, new BibleVersion(e));
                    break;
                case StudyBibleType.refname:
                case StudyBibleType.shortname:
                    studyBibleType = new StudyBibleType(e);
                    break;
                case BibleTextOrganization.refname:
                case BibleTextOrganization.shortname:
                    bibleTextOrganization = new BibleTextOrganization(e);
                    break;
                case BibleReferenceLocation.refname:
                case BibleReferenceLocation.shortname:
                    bibleReferenceLocation = new BibleReferenceLocation(e);
                    break;
                case BiblePurpose.refname:
                case BiblePurpose.shortname:
                    biblePurposes = JPU.addToList(biblePurposes, new BiblePurpose(e));
                    break;
                case BibleTextFeature.refname:
                case BibleTextFeature.shortname:
                    bibleTextFeatures = JPU.addToList(bibleTextFeatures, new BibleTextFeature(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Bible&gt; or &lt;bible&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Bible> action) {
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

    private ListOfOnixCodelist<BibleContents, BibleContentss> bibleContentss = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code indicating the content of an edition of the Bible or selected Biblical text, for example ‘New
     * Testament’, ‘Apocrypha’, ‘Pentateuch’. Mandatory in each occurrence of the &lt;Bible&gt; composite, and
     * repeatable so that a list such as ‘Old Testament and Apocrypha’ can be expressed.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixCodelist<BibleContents, BibleContentss> bibleContentss() {
        _initialize();
        return bibleContentss;
    }

    private ListOfOnixCodelist<BibleVersion, BibleVersions> bibleVersions = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code indicating the version of a Bible or selected Biblical text, for example ‘King James’, ‘Jerusalem’,
     * ‘New American Standard’, ‘Reina Valera’. Mandatory in each occurrence of the &lt;Bible&gt; composite, and
     * repeatable if a work includes text in two or more versions.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixCodelist<BibleVersion, BibleVersions> bibleVersions() {
        _initialize();
        return bibleVersions;
    }

    private StudyBibleType studyBibleType = StudyBibleType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying a particular study version of a Bible or selected Biblical text, for example ‘Life
     * Application’. Optional and non-repeating. Some study Bibles are available in different editions based on
     * different text versions.
     * </p>
     * JONIX adds: this field is optional
     */
    public StudyBibleType studyBibleType() {
        _initialize();
        return studyBibleType;
    }

    private BibleTextOrganization bibleTextOrganization = BibleTextOrganization.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the way in which the content of a Bible or selected Biblical text is organized, for
     * example ‘Chronological’, ‘Chain reference’. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public BibleTextOrganization bibleTextOrganization() {
        _initialize();
        return bibleTextOrganization;
    }

    private BibleReferenceLocation bibleReferenceLocation = BibleReferenceLocation.EMPTY;

    /**
     * <p>
     * An ONIX code indicating where references are located as part of the content of a Bible or selected Biblical text,
     * for example ‘Center column’. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public BibleReferenceLocation bibleReferenceLocation() {
        _initialize();
        return bibleReferenceLocation;
    }

    private ListOfOnixCodelist<BiblePurpose, BiblePurposes> biblePurposes = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code indicating the purpose for which a Bible or selected Biblical text is intended, for example
     * ‘Family’, ‘Lectern/pulpit’. Optional, and repeatable to list multiple purposes.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixCodelist<BiblePurpose, BiblePurposes> biblePurposes() {
        _initialize();
        return biblePurposes;
    }

    private ListOfOnixCodelist<BibleTextFeature, BibleTextFeatures> bibleTextFeatures = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code specifying a feature of a Bible text not covered elsewhere, <i>eg</i> red letter. Optional, and
     * repeatable to specify multiple features.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixCodelist<BibleTextFeature, BibleTextFeatures> bibleTextFeatures() {
        _initialize();
        return bibleTextFeatures;
    }

    @Override
    public JonixBible asStruct() {
        _initialize();
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
