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
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Imprint identifier type</h1>
 * <p>
 * An ONIX code which identifies the scheme from which the value in the &lt;IDValue&gt; element is taken. Mandatory in
 * each occurrence of the &lt;ImprintIdentifier&gt; composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 44</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ImprintIDType&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x445&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x445&gt;01&lt;/x445&gt;</tt> (Proprietary)</td>
 * </tr>
 * <tr>
 * <td>Notes</td>
 * <td>'Proprietary' in this context indicates the code list from which &lt;IDValue&gt; is drawn is proprietary; it is
 * not an indicator of trademark or proprietary rights held over the brand or imprint name itself.</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ImprintIDType&gt; from the schema author:
 *
 * Type of identifier for the publisher's imprint or brand, often a proprietary type
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ImprintIdentifier}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link Imprint} ⯈ {@link ImprintIdentifier} ⯈
 * {@link ImprintIDType}</li>
 * </ul>
 */
public class ImprintIDType implements OnixElement<NameIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ImprintIDType";
    public static final String shortname = "x445";

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

    public NameIdentifierTypes value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public NameIdentifierTypes __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ImprintIDType EMPTY = new ImprintIDType();

    public ImprintIDType() {
        exists = false;
    }

    public ImprintIDType(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = NameIdentifierTypes.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;ImprintIDType&gt; or &lt;x445&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ImprintIDType> action) {
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
