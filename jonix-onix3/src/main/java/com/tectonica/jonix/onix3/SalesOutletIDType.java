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
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SalesOutletIdentifierTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sales outlet identifier type</h1>
 * <p>
 * An ONIX code which identifies the scheme from which the value in the &lt;IDValue&gt; element is taken. Mandatory in
 * each occurrence of the &lt;SalesOutletIdentifier&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 102</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SalesOutletIDType&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b393&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;b393&gt;03&lt;/b393&gt;</tt> (ONIX sales outlet ID code)</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;SalesOutletIDType&gt; from the schema author:
 *
 * Type of identifier for a specific retail outlet, eg from the ONIX sales outlet identifier list
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SalesOutletIdentifier}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈ {@link SalesOutletIDType}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link CoverManifest} ⯈ {@link CoverResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈
 * {@link SalesOutletIDType}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest} ⯈
 * {@link CoverResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈ {@link SalesOutletIDType}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link Market} ⯈ {@link SalesRestriction} ⯈ {@link SalesOutlet} ⯈
 * {@link SalesOutletIdentifier} ⯈ {@link SalesOutletIDType}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights} ⯈ {@link SalesRestriction} ⯈ {@link SalesOutlet}
 * ⯈ {@link SalesOutletIdentifier} ⯈ {@link SalesOutletIDType}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link InsertManifest} ⯈ {@link InsertResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈
 * {@link SalesOutletIDType}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈
 * {@link InsertResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier} ⯈ {@link SalesOutletIDType}</li>
 * </ul>
 *
 * @since Onix-3.02
 */
public class SalesOutletIDType implements OnixElement<SalesOutletIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SalesOutletIDType";
    public static final String shortname = "b393";

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

    public SalesOutletIdentifierTypes value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public SalesOutletIdentifierTypes __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final SalesOutletIDType EMPTY = new SalesOutletIDType();

    public SalesOutletIDType() {
        exists = false;
    }

    public SalesOutletIDType(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = SalesOutletIdentifierTypes.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;SalesOutletIDType&gt; or &lt;b393&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<SalesOutletIDType> action) {
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
