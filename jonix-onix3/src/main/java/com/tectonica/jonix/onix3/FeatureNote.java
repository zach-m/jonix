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
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextFormats;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Resource feature note</h1>
 * <p>
 * If the &lt;ResourceFeatureType&gt; requires free text rather than a code value, or if the code in
 * &lt;FeatureValue&gt; does not adequately describe the feature, a short text note may be added. Optional, and
 * repeatable when parallel notes are provided in multiple languages. The <i>language</i> attribute is optional for a
 * single instance of &lt;FeatureNote&gt;, but must be included in each instance if &lt;FeatureNote&gt; is repeated.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text, suggested maximum length 300 characters. XHTML is enabled in this element - see Using
 * XHTML, HTML or XML with ONIX text fields</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;FeatureNote&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x440&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language, textformat</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;FeatureNote&gt;Photo by Jerry Bauer&lt;/FeatureNote&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;FeatureNote&gt; from the schema author:
 *
 * Description of a feature of a resource
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ResourceVersionFeature}&gt;</li>
 * <li>&lt;{@link ResourceFeature}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link ResourceVersionFeature} ⯈ {@link FeatureNote}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈
 * {@link ResourceVersionFeature} ⯈ {@link FeatureNote}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link ResourceVersionFeature} ⯈ {@link FeatureNote}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈ {@link ResourceVersionFeature} ⯈ {@link FeatureNote}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link ResourceVersionFeature} ⯈ {@link FeatureNote}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceFeature} ⯈ {@link FeatureNote}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link ResourceFeature} ⯈
 * {@link FeatureNote}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceFeature} ⯈ {@link FeatureNote}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link SupportingResource} ⯈ {@link ResourceFeature} ⯈ {@link FeatureNote}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceFeature} ⯈ {@link FeatureNote}</li>
 * </ul>
 */
public class FeatureNote implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "FeatureNote";
    public static final String shortname = "x440";

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

    public Languages language;

    public TextFormats textformat;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of FeatureNote. Could be null if {@code exists() == false}. Use {@link #value()} instead
     * if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable length text, suggested maximum length 300 characters. XHTML is enabled in this element - see
     * Using XHTML, HTML or XML with ONIX text fields
     * <p>
     * (type: XHTML)
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
    public static final FeatureNote EMPTY = new FeatureNote();

    public FeatureNote() {
        exists = false;
    }

    public FeatureNote(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));

        value = JPU.getChildXHTML(element, true);
    }

    /**
     * @return whether this tag (&lt;FeatureNote&gt; or &lt;x440&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<FeatureNote> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
