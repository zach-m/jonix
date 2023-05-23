/*
 * Copyright (C) 2012-2023 Zach Melamed
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
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SalesRightsTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Rest of World sales rights type code</h1>
 * <p>
 * An ONIX code describing the sales rights applicable in territories not specifically associated with a sales right
 * within an occurrence of the &lt;SalesRights&gt; composite. Must be preceded by at least one &lt;SalesRights&gt;
 * composite. Optional, but required in all cases where no sales rights type is associated with the region ‘WORLD’, and
 * in all cases where a sales rights type is associated with ‘WORLD’ but with exclusions that are not themselves
 * associated with a sales rights type. Not repeatable. Note the value ‘00’ should be used to indicate where sales
 * rights are genuinely unknown, or are unstated for any reason – in this case, data recipients must not assume anything
 * about the rights that are applicable.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 46</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ROWSalesRightsType&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x456&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x456&gt;00&lt;/x456&gt;</tt> (Unknown or unstated)</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PublishingDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link ROWSalesRightsType}</li>
 * </ul>
 */
public class ROWSalesRightsType implements OnixElement<SalesRightsTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ROWSalesRightsType";
    public static final String shortname = "x456";

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

    public SalesRightsTypes value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public SalesRightsTypes __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ROWSalesRightsType EMPTY = new ROWSalesRightsType();

    public ROWSalesRightsType() {
        exists = false;
    }

    public ROWSalesRightsType(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = SalesRightsTypes.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;ROWSalesRightsType&gt; or &lt;x456&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ROWSalesRightsType> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
