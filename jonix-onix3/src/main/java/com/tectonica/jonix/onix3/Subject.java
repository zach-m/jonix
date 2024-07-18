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
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixSubject;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Subject composite</h1>
 * <p>
 * An optional group of data elements which together specify a subject classification, category or subject heading.
 * Repeatable, both to express multiple subject categories or headings in a scheme, and to specify subjects using
 * multiple schemes.
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
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Subject&gt; from the schema author:
 *
 * Details of the subject or aboutness of the product - a subject classification code or heading &#9679; Modified
 * cardinality of &lt;SubjectHeadingText&gt; at revision 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Subject}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Subject}</li>
 * </ul>
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
                case SubjectSchemeIdentifier.refname:
                case SubjectSchemeIdentifier.shortname:
                    subjectSchemeIdentifier = new SubjectSchemeIdentifier(e);
                    break;
                case SubjectCode.refname:
                case SubjectCode.shortname:
                    subjectCode = new SubjectCode(e);
                    break;
                case MainSubject.refname:
                case MainSubject.shortname:
                    mainSubject = new MainSubject(e);
                    break;
                case SubjectSchemeName.refname:
                case SubjectSchemeName.shortname:
                    subjectSchemeName = new SubjectSchemeName(e);
                    break;
                case SubjectSchemeVersion.refname:
                case SubjectSchemeVersion.shortname:
                    subjectSchemeVersion = new SubjectSchemeVersion(e);
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

    /**
     * @return whether this tag (&lt;Subject&gt; or &lt;subject&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Subject> action) {
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

    private SubjectSchemeIdentifier subjectSchemeIdentifier = SubjectSchemeIdentifier.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the category or subject heading scheme which is used in an occurrence of the
     * &lt;Subject&gt; composite. Mandatory in each occurrence of the composite, and non-repeating.
     * </p>
     * <p>
     * For category schemes that use code values, use the associated &lt;SubjectCode&gt; element to carry the value (if
     * so required, the &lt;SubjectHeadingText&gt; element can be used simultaneously to carry the text equivalent of
     * the code). For schemes that use text headings, use the &lt;SubjectHeadingText&gt; element to carry the text of
     * the category heading.
     * </p>
     * JONIX adds: this field is required
     */
    public SubjectSchemeIdentifier subjectSchemeIdentifier() {
        _initialize();
        return subjectSchemeIdentifier;
    }

    private SubjectCode subjectCode = SubjectCode.EMPTY;

    /**
     * <p>
     * A single subject class or category code from the scheme specified in the &lt;SubjectSchemeIdentifier&gt; element.
     * Either &lt;SubjectCode&gt; or &lt;SubjectHeadingText&gt; or both must be present in each occurrence of the
     * &lt;Subject&gt; composite. Non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public SubjectCode subjectCode() {
        _initialize();
        return subjectCode;
    }

    private MainSubject mainSubject = MainSubject.EMPTY;

    /**
     * <p>
     * An empty element that identifies an instance of the &lt;Subject&gt; composite as representing the primary or main
     * subject category for the product. The main category may be expressed in more than one subject scheme, <i>ie</i>
     * there may be two or more instances of the &lt;Subject&gt; composite, using different schemes, each carrying the
     * &lt;MainSubject/&gt; flag, so long as there is only one main category <em>per scheme</em> (<i>ie</i> per value of
     * &lt;SubjectSchemeIdentifier&gt;). Optional, though for some subject schemes (<i>eg</i> <i>Thema</i>),
     * &lt;MainSubject/&gt; can be vital in order to prevent potential misinterpretation of a group of subject codes,
     * and for other schemes which by their nature only allow one code (<i>eg</i> Dewey), &lt;MainSubject&gt; is not
     * relevant. Non-repeating in each occurrence of the &lt;Subject&gt; composite.
     * </p>
     * JONIX adds: this field is optional
     */
    public MainSubject mainSubject() {
        _initialize();
        return mainSubject;
    }

    public boolean isMainSubject() {
        return (mainSubject().exists());
    }

    private SubjectSchemeName subjectSchemeName = SubjectSchemeName.EMPTY;

    /**
     * <p>
     * A name identifying a proprietary subject scheme (<i>ie</i> a scheme which is not a standard and for which there
     * is no individual identifier code) when &lt;SubjectSchemeIdentifier&gt; is coded ‘24’. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
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
     * JONIX adds: this field is optional
     */
    public SubjectSchemeVersion subjectSchemeVersion() {
        _initialize();
        return subjectSchemeVersion;
    }

    private ListOfOnixElement<SubjectHeadingText, String> subjectHeadingTexts = ListOfOnixElement.empty();

    /**
     * <p>
     * The text of a subject heading taken from the scheme specified in the &lt;SubjectSchemeIdentifier&gt; element, or
     * of free language keywords if the scheme is specified as ‘keywords’; or the text equivalent to the
     * &lt;SubjectCode&gt; value, if both code and text are sent. Either &lt;SubjectCode&gt; or
     * &lt;SubjectHeadingText&gt; or both must be present in each occurrence of the &lt;Subject&gt; composite.
     * </p>
     * <p>
     * Optional, and repeatable if the heading text is sent in multiple languages. The <i>language</i> attribute is
     * optional for a single instance of &lt;SubjectHeadingText&gt;, but must be included in each instance if
     * &lt;SubjectHeadingText&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
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
