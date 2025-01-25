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
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.EpublicationLicenseDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Digital product license date role code</h1>
 * <p>
 * An ONIX code indicating the significance of the date in relation to the license. Mandatory in each occurrence of the
 * &lt;EpubLicenseDate&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 260</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;EpubLicenseDateRole&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x585&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;EpubLicenseDateRole&gt;14&lt;/EpubLicenseDateRole&gt;</tt> (license becomes effective)</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;EpubLicenseDateRole&gt; from the schema author:
 *
 * Type or role of the specified date relating to some aspect of the license &#9679; Added at release 3.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link EpubLicenseDate}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate} ⯈
 * {@link EpubLicenseDateRole}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link EpubLicenseWithDateType} ⯈
 * {@link EpubLicenseDate} ⯈ {@link EpubLicenseDateRole}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈
 * {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate} ⯈ {@link EpubLicenseDateRole}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link EpubLicenseWithDateType} ⯈
 * {@link EpubLicenseDate} ⯈ {@link EpubLicenseDateRole}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate} ⯈
 * {@link EpubLicenseDateRole}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈
 * {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate} ⯈ {@link EpubLicenseDateRole}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate} ⯈
 * {@link EpubLicenseDateRole}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate} ⯈
 * {@link EpubLicenseDateRole}</li>
 * </ul>
 *
 * @since Onix-3.10
 */
public class EpubLicenseDateRole implements OnixElement<EpublicationLicenseDateRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EpubLicenseDateRole";
    public static final String shortname = "x585";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public EpublicationLicenseDateRoles value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public EpublicationLicenseDateRoles __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final EpubLicenseDateRole EMPTY = new EpubLicenseDateRole();

    public EpubLicenseDateRole() {
        exists = false;
    }

    public EpubLicenseDateRole(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = EpublicationLicenseDateRoles.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;EpubLicenseDateRole&gt; or &lt;x585&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<EpubLicenseDateRole> action) {
        if (exists) {
            action.accept(this);
        }
    }

    public String codeOrNull() {
        return value == null ? null : value.code;
    }

    public String descriptionOrNull() {
        return value == null ? null : value.description;
    }
}
