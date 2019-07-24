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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.AudienceCodeTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixAudience;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Audience composite</h1>
 * <p>
 * An optional group of data elements which together describe an audience to which the product is directed. Repeatable
 * to specify multiple distinct audiences.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Audience&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;audience&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Audience}</li>
 * </ul>
 */
public class Audience implements OnixDataCompositeWithKey<JonixAudience, AudienceCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Audience";
    public static final String shortname = "audience";

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
    public static final Audience EMPTY = new Audience();

    public Audience() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Audience(org.w3c.dom.Element element) {
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
                case AudienceCodeType.refname:
                case AudienceCodeType.shortname:
                    audienceCodeType = new AudienceCodeType(e);
                    break;
                case AudienceCodeValue.refname:
                case AudienceCodeValue.shortname:
                    audienceCodeValue = new AudienceCodeValue(e);
                    break;
                case AudienceCodeTypeName.refname:
                case AudienceCodeTypeName.shortname:
                    audienceCodeTypeName = new AudienceCodeTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Audience&gt; or &lt;audience&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private AudienceCodeType audienceCodeType = AudienceCodeType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the scheme from which the code in &lt;AudienceCodeValue&gt; is taken. Mandatory in
     * each occurrence of the &lt;Audience&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public AudienceCodeType audienceCodeType() {
        _initialize();
        return audienceCodeType;
    }

    private AudienceCodeValue audienceCodeValue = AudienceCodeValue.EMPTY;

    /**
     * <p>
     * A code value taken from the scheme specified in &lt;AudienceCodeType&gt;. Mandatory in each occurrence of the
     * &lt;Audience&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public AudienceCodeValue audienceCodeValue() {
        _initialize();
        return audienceCodeValue;
    }

    private AudienceCodeTypeName audienceCodeTypeName = AudienceCodeTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary audience code when the code in &lt;AudienceCodeType&gt; indicates a
     * proprietary scheme, <i>eg</i> a vendor’s own code. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public AudienceCodeTypeName audienceCodeTypeName() {
        _initialize();
        return audienceCodeTypeName;
    }

    @Override
    public JonixAudience asStruct() {
        _initialize();
        JonixAudience struct = new JonixAudience();
        struct.audienceCodeType = audienceCodeType.value;
        struct.audienceCodeTypeName = audienceCodeTypeName.value;
        struct.audienceCodeValue = audienceCodeValue.value;
        return struct;
    }

    @Override
    public AudienceCodeTypes structKey() {
        return audienceCodeType().value;
    }
}
