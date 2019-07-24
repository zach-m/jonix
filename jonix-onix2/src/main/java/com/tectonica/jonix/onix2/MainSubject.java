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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixMainSubject;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Main subject composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together describe a main subject classification or subject
 * heading which is taken from a recognized scheme other than BISAC or BIC.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;MainSubject&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;mainsubject&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link MainSubject}</li>
 * </ul>
 */
public class MainSubject implements OnixDataComposite<JonixMainSubject>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "MainSubject";
    public static final String shortname = "mainsubject";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

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
    public static final MainSubject EMPTY = new MainSubject();

    public MainSubject() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public MainSubject(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
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
                case MainSubjectSchemeIdentifier.refname:
                case MainSubjectSchemeIdentifier.shortname:
                    mainSubjectSchemeIdentifier = new MainSubjectSchemeIdentifier(e);
                    break;
                case SubjectCode.refname:
                case SubjectCode.shortname:
                    subjectCode = new SubjectCode(e);
                    break;
                case SubjectSchemeVersion.refname:
                case SubjectSchemeVersion.shortname:
                    subjectSchemeVersion = new SubjectSchemeVersion(e);
                    break;
                case SubjectHeadingText.refname:
                case SubjectHeadingText.shortname:
                    subjectHeadingText = new SubjectHeadingText(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;MainSubject&gt; or &lt;mainsubject&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private MainSubjectSchemeIdentifier mainSubjectSchemeIdentifier = MainSubjectSchemeIdentifier.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies a subject scheme which is designated for use in a &lt;MainSubject&gt; composite.
     * Mandatory in each occurrence of the composite, and non-repeating.
     * </p>
     * <p>
     * When the scheme listed in the code list display is annotated “Code”, use the associated &lt;SubjectCode&gt;
     * element to carry the value (if so required, the &lt;SubjectHeadingText&gt; element can be used simultaneously to
     * carry the text equivalent of the code). When the scheme is annotated “Text”, use the &lt;SubjectHeadingText&gt;
     * element to carry the text of the subject heading.
     * </p>
     * Jonix-Comment: this field is required
     */
    public MainSubjectSchemeIdentifier mainSubjectSchemeIdentifier() {
        _initialize();
        return mainSubjectSchemeIdentifier;
    }

    private SubjectCode subjectCode = SubjectCode.EMPTY;

    /**
     * <p>
     * A subject class or category code from the scheme specified in the &lt;MainSubjectSchemeIdentifier&gt; element.
     * Either &lt;SubjectCode&gt; or &lt;SubjectHeadingText&gt; or both must be present in each occurrence of the
     * &lt;MainSubject&gt; composite. Non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SubjectCode subjectCode() {
        _initialize();
        return subjectCode;
    }

    private SubjectSchemeVersion subjectSchemeVersion = SubjectSchemeVersion.EMPTY;

    /**
     * <p>
     * A number which identifies a version or edition of the subject scheme specified in the associated
     * &lt;MainSubjectSchemeIdentifier&gt; element. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SubjectSchemeVersion subjectSchemeVersion() {
        _initialize();
        return subjectSchemeVersion;
    }

    private SubjectHeadingText subjectHeadingText = SubjectHeadingText.EMPTY;

    /**
     * <p>
     * The text of a heading taken from the scheme specified in the &lt;MainSubjectSchemeIdentifier&gt; element; or the
     * text equivalent to the &lt;SubjectCode&gt; value, if both code and text are sent. Either &lt;SubjectCode&gt; or
     * &lt;SubjectHeadingText&gt; or both must be present in each occurrence of the &lt;MainSubject&gt; composite.
     * Non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SubjectHeadingText subjectHeadingText() {
        _initialize();
        return subjectHeadingText;
    }

    @Override
    public JonixMainSubject asStruct() {
        _initialize();
        JonixMainSubject struct = new JonixMainSubject();
        struct.mainSubjectSchemeIdentifier = mainSubjectSchemeIdentifier.value;
        struct.subjectSchemeVersion = subjectSchemeVersion.value;
        struct.subjectCode = subjectCode.value;
        struct.subjectHeadingText = subjectHeadingText.value;
        return struct;
    }
}
