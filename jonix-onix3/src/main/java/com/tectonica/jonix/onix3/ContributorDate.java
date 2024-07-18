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
import com.tectonica.jonix.common.struct.JonixContributorDate;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Contributor date composite</h1>
 * <p>
 * A group of data elements which together specify a date associated with the person or organization identified in an
 * occurrence of the &lt;Contributor&gt; composite, <i>eg</i> birth or death. Optional, and repeatable to allow multiple
 * dates to be specified.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ContributorDate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;contributordate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ContributorDate&gt; from the schema author:
 *
 * Date of the specified role relating to some aspect of the contributor &#9679; Removed &lt;DateFormat&gt; at release
 * 3.1 &#9679; Modified cardinality of &lt;DateFormat&gt; at revision 3.0 (2010)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Contributor}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link ContributorDate}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈
 * {@link ContributorDate}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈
 * {@link ContributorDate}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈
 * {@link ContributorDate}</li>
 * </ul>
 */
public class ContributorDate
    implements OnixDataCompositeWithKey<JonixContributorDate, PersonOrganizationDateRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ContributorDate";
    public static final String shortname = "contributordate";

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
    public static final ContributorDate EMPTY = new ContributorDate();

    public ContributorDate() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ContributorDate(org.w3c.dom.Element element) {
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
                case ContributorDateRole.refname:
                case ContributorDateRole.shortname:
                    contributorDateRole = new ContributorDateRole(e);
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
     * @return whether this tag (&lt;ContributorDate&gt; or &lt;contributordate&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ContributorDate> action) {
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

    private ContributorDateRole contributorDateRole = ContributorDateRole.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the significance of the date in relation to the contributor name. Mandatory in each
     * occurrence of the &lt;ContributorDate&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public ContributorDateRole contributorDateRole() {
        _initialize();
        return contributorDateRole;
    }

    private Date date = Date.EMPTY;

    /**
     * <p>
     * The date specified in the &lt;ContributorDateRole&gt; field. Mandatory in each occurrence of the
     * &lt;ContributorDate&gt; composite, and non-repeating. &lt;Date&gt; may carry a <i>dateformat</i> attribute: if
     * the attribute is missing, then the default format is YYYYMMDD.
     * </p>
     * JONIX adds: this field is required
     */
    public Date date() {
        _initialize();
        return date;
    }

    @Override
    public JonixContributorDate asStruct() {
        _initialize();
        JonixContributorDate struct = new JonixContributorDate();
        struct.contributorDateRole = contributorDateRole.value;
        struct.date = date.value;
        return struct;
    }

    @Override
    public PersonOrganizationDateRoles structKey() {
        return contributorDateRole().value;
    }
}
