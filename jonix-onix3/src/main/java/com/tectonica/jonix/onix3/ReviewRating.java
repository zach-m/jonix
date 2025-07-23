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
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixReviewRating;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Review rating composite</h1>
 * <p>
 * An optional group of data elements which together specify a ‘star rating’ awarded as part of a review of the
 * publication, used when &lt;TextType&gt; indicates the text is a review. Not repeatable.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ReviewRating&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;reviewrating&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ReviewRating&gt; from the schema author:
 *
 * Details of a 'star rating' awarded as part of a review of the product &#9679; Added at revision 3.0.3
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link TextContent}&gt;</li>
 * <li>&lt;{@link CitedContent}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈ {@link ReviewRating}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link ReviewRating}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link CitedContent} ⯈ {@link ReviewRating}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link CitedContent} ⯈ {@link ReviewRating}</li>
 * </ul>
 *
 * @since Onix-3.03
 */
public class ReviewRating implements OnixDataComposite<JonixReviewRating>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ReviewRating";
    public static final String shortname = "reviewrating";

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
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final ReviewRating EMPTY = new ReviewRating();

    public ReviewRating() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ReviewRating(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
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
                case Rating.refname:
                case Rating.shortname:
                    rating = new Rating(e);
                    break;
                case RatingLimit.refname:
                case RatingLimit.shortname:
                    ratingLimit = new RatingLimit(e);
                    break;
                case RatingUnits.refname:
                case RatingUnits.shortname:
                    ratingUnitss = JPU.addToList(ratingUnitss, new RatingUnits(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ReviewRating&gt; or &lt;reviewrating&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ReviewRating> action) {
        if (exists) {
            action.accept(this);
        }
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private Rating rating = Rating.EMPTY;

    /**
     * <p>
     * The ‘star rating’ awarded as part of a review of the publication. Mandatory within an occurrence of the
     * &lt;ReviewRating&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public Rating rating() {
        _initialize();
        return rating;
    }

    private RatingLimit ratingLimit = RatingLimit.EMPTY;

    /**
     * <p>
     * The maximum possible rating that may be awarded as part of a review of the publication. Optional, but where used,
     * it must be greater than or equal to the specified &lt;Rating&gt;.
     * </p>
     * JONIX adds: this field is optional
     */
    public RatingLimit ratingLimit() {
        _initialize();
        return ratingLimit;
    }

    private ListOfOnixElement<RatingUnits, String> ratingUnitss = ListOfOnixElement.empty();

    /**
     * <p>
     * The ‘units’ used by a rating, <i>eg</i>&nbsp;stars, tomatoes <i>etc</i>. Optional, and repeatable to provide the
     * units in multiple languages. The <i>language</i> attribute is optional for a single instance of
     * &lt;RatingUnits&gt;, but must be included in each instance if &lt;RatingUnits&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<RatingUnits, String> ratingUnitss() {
        _initialize();
        return ratingUnitss;
    }

    @Override
    public JonixReviewRating asStruct() {
        _initialize();
        JonixReviewRating struct = new JonixReviewRating();
        struct.rating = rating.value;
        struct.ratingLimit = ratingLimit.value;
        struct.ratingUnitss = ratingUnitss.values();
        return struct;
    }
}
