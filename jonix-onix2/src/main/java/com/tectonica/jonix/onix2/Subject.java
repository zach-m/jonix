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
import com.tectonica.jonix.common.struct.JonixSubject;

import java.io.Serializable;
import java.util.Arrays;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Additional subject composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together describe a subject classification or subject heading
 * which is additional to the BISAC, BIC or other main subject category.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Subject&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;subject&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Product&gt;</li>
 * <li>&lt;ContentItem&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ Subject</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Subject</li>
 * </ul>
 */
public class Subject implements OnixDataComposite<JonixSubject>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Subject";
    public static final String shortname = "subject";

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
                    subjectHeadingText = new SubjectHeadingText(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Subject&gt; or &lt;subject&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private SubjectSchemeIdentifier subjectSchemeIdentifier = SubjectSchemeIdentifier.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the subject scheme which is used in an occurrence of the &lt;Subject&gt; composite.
     * Mandatory in each occurrence of the composite, and non-repeating.
     * </p>
     * <p>
     * When the scheme listed in the code list display is annotated “Code”, use the associated &lt;SubjectCode&gt;
     * element to carry the value (if so required, the &lt;SubjectHeadingText&gt; element can be used simultaneously to
     * carry the text equivalent of the code). When the scheme is annotated “Text”, use the &lt;SubjectHeadingText&gt;
     * element to carry the text of the subject heading.
     * </p>
     * <p>
     * Scheme code 23 may be used for a publisher’s own subject category code, by agreement with trading partners to
     * whom product information is sent. Scheme code 24, with a name in the &lt;SubjectSchemeName&gt; element, may be
     * used to identify a proprietary scheme, <em>eg</em> one used by a bibliographic agency or wholesaler.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SubjectSchemeIdentifier subjectSchemeIdentifier() {
        _initialize();
        return subjectSchemeIdentifier;
    }

    private SubjectSchemeName subjectSchemeName = SubjectSchemeName.EMPTY;

    /**
     * <p>
     * A name identifying a proprietary subject scheme when &lt;SubjectSchemeIdentifier&gt; is coded “24”. Optional and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SubjectSchemeName subjectSchemeName() {
        _initialize();
        return subjectSchemeName;
    }

    private SubjectSchemeVersion subjectSchemeVersion = SubjectSchemeVersion.EMPTY;

    /**
     * <p>
     * A number which identifies a version or edition of the subject scheme specified in the associated
     * &lt;SubjectSchemeIdentifier&gt; element. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SubjectSchemeVersion subjectSchemeVersion() {
        _initialize();
        return subjectSchemeVersion;
    }

    private SubjectCode subjectCode = SubjectCode.EMPTY;

    /**
     * <p>
     * A subject class or category code from the scheme specified in the &lt;SubjectSchemeIdentifier&gt; element. Either
     * &lt;SubjectCode&gt; or &lt;SubjectHeadingText&gt; or both must be present in each occurrence of the
     * &lt;Subject&gt; composite. Non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SubjectCode subjectCode() {
        _initialize();
        return subjectCode;
    }

    private SubjectHeadingText subjectHeadingText = SubjectHeadingText.EMPTY;

    /**
     * <p>
     * The text of a subject heading taken from the scheme specified in the &lt;SubjectSchemeIdentifier&gt; element, or
     * of free language keywords if the scheme is specified as “keywords”; or the text equivalent to the
     * &lt;SubjectCode&gt; value, if both code and text are sent. Either &lt;SubjectCode&gt; or
     * &lt;SubjectHeadingText&gt; or both must be present in each occurrence of the &lt;Subject&gt; composite.
     * Non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SubjectHeadingText subjectHeadingText() {
        _initialize();
        return subjectHeadingText;
    }

    @Override
    public JonixSubject asStruct() {
        _initialize();
        JonixSubject struct = new JonixSubject();
        struct.subjectCode = subjectCode.value;
        struct.subjectHeadingTexts = Arrays.asList(subjectHeadingText.value);
        struct.subjectSchemeIdentifier = subjectSchemeIdentifier.value;
        struct.subjectSchemeName = subjectSchemeName.value;
        struct.subjectSchemeVersion = subjectSchemeVersion.value;
        return struct;
    }
}
