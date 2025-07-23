/*
 * Copyright (C) 2012-2025 Zach Melamed
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
import com.tectonica.jonix.common.codelist.EpublicationLicenseDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixEpubLicenseDate;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Digital product license date</h1>
 * <p>
 * An optional group of date elements which together specify a date associated with the license in an occurrence of the
 * &lt;EpubLicense&gt; composite, <i>eg</i>&nbsp;a date when a license expires. Repeatable to specify different dates
 * with their various roles.
 * </p>
 * <p>
 * Note that if no dates are specified, the license is effective at the time the ONIX message is sent.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;EpubLicenseDate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;epublicensedate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;EpubLicenseDate&gt; from the schema author:
 *
 * Date of the specified role relating to the e-publication license (eg from when is a license applied) &#9679; Added at
 * release 3.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link EpubLicenseWithDateType}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link EpubLicenseWithDateType} ⯈
 * {@link EpubLicenseDate}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈
 * {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link EpubLicenseWithDateType} ⯈
 * {@link EpubLicenseDate}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈
 * {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate}</li>
 * </ul>
 *
 * @since Onix-3.10
 */
public class EpubLicenseDate
    implements OnixDataCompositeWithKey<JonixEpubLicenseDate, EpublicationLicenseDateRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EpubLicenseDate";
    public static final String shortname = "epublicensedate";

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
    public static final EpubLicenseDate EMPTY = new EpubLicenseDate();

    public EpubLicenseDate() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public EpubLicenseDate(org.w3c.dom.Element element) {
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
                case EpubLicenseDateRole.refname:
                case EpubLicenseDateRole.shortname:
                    epubLicenseDateRole = new EpubLicenseDateRole(e);
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
     * @return whether this tag (&lt;EpubLicenseDate&gt; or &lt;epublicensedate&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<EpubLicenseDate> action) {
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

    private EpubLicenseDateRole epubLicenseDateRole = EpubLicenseDateRole.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the significance of the date in relation to the license. Mandatory in each occurrence of
     * the &lt;EpubLicenseDate&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public EpubLicenseDateRole epubLicenseDateRole() {
        _initialize();
        return epubLicenseDateRole;
    }

    private Date date = Date.EMPTY;

    /**
     * <p>
     * The date specified in the &lt;EpubLicenseDateRole&gt; field. Mandatory in each occurrence of the
     * &lt;EpubLicenseDate&gt; composite, and non-repeating. &lt;Date&gt; may carry a <i>dateformat</i> attribute: if
     * the attribute is missing, then the default format is YYYYMMDD.
     * </p>
     * JONIX adds: this field is required
     */
    public Date date() {
        _initialize();
        return date;
    }

    @Override
    public JonixEpubLicenseDate asStruct() {
        _initialize();
        JonixEpubLicenseDate struct = new JonixEpubLicenseDate();
        struct.epubLicenseDateRole = epubLicenseDateRole.value;
        struct.date = date.value;
        return struct;
    }

    @Override
    public EpublicationLicenseDateRoles structKey() {
        return epubLicenseDateRole().value;
    }
}
