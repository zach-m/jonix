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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.PersonOrganizationDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixSubjectDate;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Subject date composite</h1>
 * <p>
 * A group of data elements which together specify a date associated with the person or organization identified in an
 * occurrence of the &lt;NameAsSubject&gt; composite, <i>eg</i> birth or death. Optional, and repeatable to provide
 * multiple dates with their various roles.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SubjectDate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;subjectdate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;SubjectDate&gt; from the schema author:
 *
 * Date of the specified role relating to some aspect of the named subject &#9679; Removed &lt;DateFormat&gt; at release
 * 3.1 &#9679; Added at revision 3.0.3
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link NameAsSubject}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link NameAsSubject} ⯈ {@link SubjectDate}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link NameAsSubject} ⯈ {@link SubjectDate}</li>
 * </ul>
 *
 * @since Onix-3.03
 */
public class SubjectDate
    implements OnixDataCompositeWithKey<JonixSubjectDate, PersonOrganizationDateRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SubjectDate";
    public static final String shortname = "subjectdate";

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
    public static final SubjectDate EMPTY = new SubjectDate();

    public SubjectDate() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SubjectDate(org.w3c.dom.Element element) {
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
                case SubjectDateRole.refname:
                case SubjectDateRole.shortname:
                    subjectDateRole = new SubjectDateRole(e);
                    break;
                case Date.refname:
                case Date.shortname:
                    date = new Date(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SubjectDate&gt; or &lt;subjectdate&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<SubjectDate> action) {
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

    private SubjectDateRole subjectDateRole = SubjectDateRole.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the significance of the date in relation to the subject name. Mandatory in each
     * occurrence of the &lt;SubjectDate&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public SubjectDateRole subjectDateRole() {
        _initialize();
        return subjectDateRole;
    }

    private Date date = Date.EMPTY;

    /**
     * <p>
     * The date specified in the &lt;SubjectDateRole&gt; field. Mandatory in each occurrence of the &lt;SubjectDate&gt;
     * composite, and non-repeating. &lt;Date&gt; may carry a <i>dateformat</i> attribute: if the attribute is missing,
     * then the default format is YYYYMMDD.
     * </p>
     * JONIX adds: this field is required
     */
    public Date date() {
        _initialize();
        return date;
    }

    @Override
    public JonixSubjectDate asStruct() {
        _initialize();
        JonixSubjectDate struct = new JonixSubjectDate();
        struct.subjectDateRole = subjectDateRole.value;
        struct.date = date.value;
        return struct;
    }

    @Override
    public PersonOrganizationDateRoles structKey() {
        return subjectDateRole().value;
    }
}
