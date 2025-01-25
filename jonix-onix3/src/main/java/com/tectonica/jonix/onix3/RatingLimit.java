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
 * <h1>Review rating limit</h1>
 * <p>
 * The maximum possible rating that may be awarded as part of a review of the publication. Optional, but where used, it
 * must be greater than or equal to the specified &lt;Rating&gt;.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Positive integer number, suggested maximum length 4 digits</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;RatingLimit&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x526&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;RatingLimit&gt;5&lt;/RatingLimit&gt;</tt> (4.5 out of 5 stars)</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;RatingLimit&gt; from the schema author:
 *
 * The upper limit of a 'star rating' scheme used as part of a review of the product &#9679; Added at revision 3.0.3
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ReviewRating}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈ {@link ReviewRating} ⯈
 * {@link RatingLimit}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link ReviewRating} ⯈
 * {@link RatingLimit}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link CitedContent} ⯈ {@link ReviewRating} ⯈
 * {@link RatingLimit}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link CitedContent} ⯈ {@link ReviewRating} ⯈
 * {@link RatingLimit}</li>
 * </ul>
 *
 * @since Onix-3.03
 */
public class RatingLimit implements OnixElement<Integer>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "RatingLimit";
    public static final String shortname = "x526";

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

    /**
     * This is the raw content of RatingLimit. Could be null if {@code exists() == false}. Use {@link #value()} instead
     * if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Positive integer number, suggested maximum length 4 digits
     * <p>
     * (type: dt.PositiveIntegerOrZero)
     */
    public Integer value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public Integer __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final RatingLimit EMPTY = new RatingLimit();

    public RatingLimit() {
        exists = false;
    }

    public RatingLimit(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsInteger(element);
    }

    /**
     * @return whether this tag (&lt;RatingLimit&gt; or &lt;x526&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<RatingLimit> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
