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
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.PersonOrganizationDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixSubjectDate;

import java.io.Serializable;

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
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;NameAsSubject&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ NameAsSubject ⯈ SubjectDate</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ NameAsSubject ⯈ SubjectDate</li>
 * </ul>
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

    public RecordSourceTypes sourcetype;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

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
                case SubjectDateRole.refname:
                case SubjectDateRole.shortname:
                    subjectDateRole = new SubjectDateRole(e);
                    break;
                case DateFormat.refname:
                case DateFormat.shortname:
                    dateFormat = new DateFormat(e);
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

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private SubjectDateRole subjectDateRole = SubjectDateRole.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the significance of the date in relation to the subject name. Mandatory in each
     * occurrence of the &lt;SubjectDate&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SubjectDateRole subjectDateRole() {
        _initialize();
        return subjectDateRole;
    }

    private DateFormat dateFormat = DateFormat.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the format in which the date is given in &lt;Date&gt;. Optional and not repeatable.
     * Deprecated – where possible, use the <i>dateformat</i> attribute instead.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DateFormat dateFormat() {
        _initialize();
        return dateFormat;
    }

    private Date date = Date.EMPTY;

    /**
     * <p>
     * The date specified in the &lt;SubjectDateRole&gt; field. Mandatory in each occurrence of the &lt;SubjectDate&gt;
     * composite, and non-repeating. &lt;Date&gt; may carry a <i>dateformat</i> attribute: if the attribute is missing,
     * then &lt;DateFormat&gt; indicates the format of the date; if both dateformat attribute and &lt;DateFormat&gt;
     * element are missing, the default format is YYYYMMDD.
     * </p>
     * Jonix-Comment: this field is required
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
        struct.dateFormat = dateFormat.value;
        struct.date = date.value;
        return struct;
    }

    @Override
    public PersonOrganizationDateRoles structKey() {
        return subjectDateRole().value;
    }
}
