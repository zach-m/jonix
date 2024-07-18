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
import com.tectonica.jonix.common.codelist.ResourceFileFeatureTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Resource file feature type</h1>
 * <p>
 * An ONIX code which specifies the feature of the resource file described by an instance of the
 * &lt;ResourceFileFeature&gt; composite, <i>eg</i> a checksum or hash for the resource file. Mandatory in each
 * occurrence of the composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 253</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ResourceFileFeatureType&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x568&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x568&gt;07&lt;/x568&gt;</tt> (exact download file size in bytes)</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ResourceFileFeatureType&gt; from the schema author:
 *
 * &#9679; Added at revision 3.0.8
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ResourceFileFeature}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link CoverManifest} ⯈ {@link CoverResource} ⯈ {@link ResourceFileFeature} ⯈ {@link ResourceFileFeatureType}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest} ⯈
 * {@link CoverResource} ⯈ {@link ResourceFileFeature} ⯈ {@link ResourceFileFeatureType}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link BodyManifest} ⯈ {@link BodyResource} ⯈ {@link ResourceFileFeature} ⯈ {@link ResourceFileFeatureType}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link BodyManifest} ⯈
 * {@link BodyResource} ⯈ {@link ResourceFileFeature} ⯈ {@link ResourceFileFeatureType}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link InsertManifest} ⯈ {@link InsertResource} ⯈ {@link ResourceFileFeature} ⯈ {@link ResourceFileFeatureType}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈
 * {@link InsertResource} ⯈ {@link ResourceFileFeature} ⯈ {@link ResourceFileFeatureType}</li>
 * </ul>
 *
 * @since Onix-3.08
 */
public class ResourceFileFeatureType implements OnixElement<ResourceFileFeatureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ResourceFileFeatureType";
    public static final String shortname = "x568";

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

    public ResourceFileFeatureTypes value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public ResourceFileFeatureTypes __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ResourceFileFeatureType EMPTY = new ResourceFileFeatureType();

    public ResourceFileFeatureType() {
        exists = false;
    }

    public ResourceFileFeatureType(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = ResourceFileFeatureTypes.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;ResourceFileFeatureType&gt; or &lt;x568&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ResourceFileFeatureType> action) {
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
