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
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixSubject;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Subject composite</h1><p>A group of data elements which together describe a subject of a content item. Optional
 * and repeatable.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;Subject&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;subject&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class Subject implements OnixDataComposite<JonixSubject>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Subject";
    public static final String shortname = "subject";

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
    public static final Subject EMPTY = new Subject();

    public Subject() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Subject(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
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
                case MainSubject.refname:
                case MainSubject.shortname:
                    mainSubject = new MainSubject(e);
                    break;
                case SubjectSchemeIdentifier.refname:
                case SubjectSchemeIdentifier.shortname:
                    subjectSchemeIdentifier = new SubjectSchemeIdentifier(e);
                    break;
                case SubjectSchemeName.refname:
                case SubjectSchemeName.shortname:
                    subjectSchemeName = new SubjectSchemeName(e);
                    break;
                case SubjectSchemeVersion.refname:
                case SubjectSchemeVersion.shortname:
                    subjectSchemeVersion = new SubjectSchemeVersion(e);
                    break;
                case SubjectCode.refname:
                case SubjectCode.shortname:
                    subjectCode = new SubjectCode(e);
                    break;
                case SubjectHeadingText.refname:
                case SubjectHeadingText.shortname:
                    subjectHeadingTexts = JPU.addToList(subjectHeadingTexts, new SubjectHeadingText(e));
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

    private MainSubject mainSubject = MainSubject.EMPTY;

    /**
     * (this field is optional)
     */
    public MainSubject mainSubject() {
        _initialize();
        return mainSubject;
    }

    public boolean isMainSubject() {
        return (mainSubject().exists());
    }

    private SubjectSchemeIdentifier subjectSchemeIdentifier = SubjectSchemeIdentifier.EMPTY;

    /**
     * (this field is required)
     */
    public SubjectSchemeIdentifier subjectSchemeIdentifier() {
        _initialize();
        return subjectSchemeIdentifier;
    }

    private SubjectSchemeName subjectSchemeName = SubjectSchemeName.EMPTY;

    /**
     * (this field is optional)
     */
    public SubjectSchemeName subjectSchemeName() {
        _initialize();
        return subjectSchemeName;
    }

    private SubjectSchemeVersion subjectSchemeVersion = SubjectSchemeVersion.EMPTY;

    /**
     * (this field is optional)
     */
    public SubjectSchemeVersion subjectSchemeVersion() {
        _initialize();
        return subjectSchemeVersion;
    }

    private SubjectCode subjectCode = SubjectCode.EMPTY;

    /**
     * (this field is required)
     */
    public SubjectCode subjectCode() {
        _initialize();
        return subjectCode;
    }

    private ListOfOnixElement<SubjectHeadingText, String> subjectHeadingTexts = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<SubjectHeadingText, String> subjectHeadingTexts() {
        _initialize();
        return subjectHeadingTexts;
    }

    @Override
    public JonixSubject asStruct() {
        _initialize();
        JonixSubject struct = new JonixSubject();
        struct.subjectCode = subjectCode.value;
        struct.subjectHeadingTexts = subjectHeadingTexts.values();
        struct.subjectSchemeIdentifier = subjectSchemeIdentifier.value;
        struct.subjectSchemeName = subjectSchemeName.value;
        struct.subjectSchemeVersion = subjectSchemeVersion.value;
        return struct;
    }
}
