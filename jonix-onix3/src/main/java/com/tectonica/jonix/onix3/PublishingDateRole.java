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

import java.io.Serializable;
import java.util.function.Consumer;
import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Publishing date role code</h1>
 * <p>
 * An ONIX code indicating the significance of the date, <i>eg</i> publication date, announcement date, latest reprint
 * date. Mandatory in each occurrence of the &lt;PublishingDate&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 163</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PublishingDateRole&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x448&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x448&gt;01&lt;/x448&gt;</tt> (Publication date)</td>
 * </tr>
 * <tr>
 * <td>Notes</td>
 * <td>A date such as a publication date here should be interpreted as the 'global' publication date. There may be
 * market-specific 'publication dates' in Group P.25 which are later than the 'global' date.</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;PublishingDateRole&gt; from the schema author:
 *
 * Type or role of the specified date relating to some aspect of the product lifecycle
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PublishingDate}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link PublishingDate} ⯈ {@link PublishingDateRole}</li>
 * </ul>
 */
public class PublishingDateRole implements OnixElement<PublishingDateRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PublishingDateRole";
    public static final String shortname = "x448";

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

    public PublishingDateRoles value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public PublishingDateRoles __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final PublishingDateRole EMPTY = new PublishingDateRole();

    public PublishingDateRole() {
        exists = false;
    }

    public PublishingDateRole(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = PublishingDateRoles.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;PublishingDateRole&gt; or &lt;x448&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PublishingDateRole> action) {
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
