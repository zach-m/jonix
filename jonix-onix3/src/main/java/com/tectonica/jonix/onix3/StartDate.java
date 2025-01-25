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
import com.tectonica.jonix.common.codelist.DateFormats;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Start date</h1>
 * <p>
 * The date from which a sales restriction is effective. Optional and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>As specified by the value in the dateformat attribute, or the default of YYYYMMDD if the attribute is
 * missing</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;StartDate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b324&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>dateformat</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;StartDate&gt;20090327&lt;/StartDate&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;StartDate&gt; from the schema author:
 *
 * The initial date of applicability of a sales restriction &#9679; Added dateformat attribute at revision 3.0 (2010)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SalesRestriction}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRestriction} ⯈ {@link StartDate}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link Market} ⯈ {@link SalesRestriction} ⯈ {@link StartDate}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights} ⯈ {@link SalesRestriction} ⯈
 * {@link StartDate}</li>
 * </ul>
 *
 * @since Onix-3.02
 */
public class StartDate implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "StartDate";
    public static final String shortname = "b324";

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

    public DateFormats dateformat;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of StartDate. Could be null if {@code exists() == false}. Use {@link #value()} instead if
     * you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: As specified by the value in the dateformat attribute, or the default of YYYYMMDD if the attribute is
     * missing
     * <p>
     * (type: dt.NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final StartDate EMPTY = new StartDate();

    public StartDate() {
        exists = false;
    }

    public StartDate(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        dateformat = DateFormats.byCode(JPU.getAttribute(element, "dateformat"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;StartDate&gt; or &lt;b324&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<StartDate> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
