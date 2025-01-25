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
 * <h1>Review rating units</h1>
 * <p>
 * The ‘units’ used by a rating, <i>eg</i> stars, tomatoes <i>etc</i>. Optional, and repeatable to provide the units in
 * multiple languages. The <i>language</i> attribute is optional for a single instance of &lt;RatingUnits&gt;, but must
 * be included in each instance if &lt;RatingUnits&gt; is repeated.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text, suggested maximum length 50 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;RatingUnits&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x527&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;RatingUnits&gt;stars&lt;/RatingUnits&gt;</tt> (4.5 out of 5 stars)</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;RatingUnits&gt; from the schema author:
 *
 * Name of the units used by a rating scheme, eg 'stars', points &#9679; Added at revision 3.0.3
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ReviewRating}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈ {@link ReviewRating} ⯈
 * {@link RatingUnits}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link ReviewRating} ⯈
 * {@link RatingUnits}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link CitedContent} ⯈ {@link ReviewRating} ⯈
 * {@link RatingUnits}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link CitedContent} ⯈ {@link ReviewRating} ⯈
 * {@link RatingUnits}</li>
 * </ul>
 *
 * @since Onix-3.03
 */
public class RatingUnits implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "RatingUnits";
    public static final String shortname = "x527";

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

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of RatingUnits. Could be null if {@code exists() == false}. Use {@link #value()} instead
     * if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable length text, suggested maximum length 50 characters
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
    public static final RatingUnits EMPTY = new RatingUnits();

    public RatingUnits() {
        exists = false;
    }

    public RatingUnits(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;RatingUnits&gt; or &lt;x527&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<RatingUnits> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
