/*
 * Copyright (C) 2012-2022 Zach Melamed
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
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixPriceConstraintLimit;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Price constraint composite</h1>
 * <p>
 * An optional group of data elements which together describe a contractual term or constraint (or the absence of such a
 * constraint) that forms part of the commercial offer for a product. Repeatable in order to describe multiple
 * constraints on usage.
 * </p>
 * <p>
 * The Price constraint composite has the same structure as &lt;EpubUsageConstraint&gt;. Use &lt;EpubUsageConstraint&gt;
 * for constraints that limit the user experience of the product, whether or not they are enforced by technical
 * protection measures (DRM). Use &lt;PriceConstraint&gt; where a single product is available under multiple terms and
 * conditions (<i>ie</i> multiple commercial offers for the same product which differ in their Price constraints, and
 * whether or not they are enforced by DRM).
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PriceConstraint&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;priceconstraint&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈
 * {@link Price} ⯈ {@link PriceConstraint}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈
 * {@link PriceConstraint}</li>
 * </ul>
 *
 * @since Onix-3.03
 */
public class PriceConstraint implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PriceConstraint";
    public static final String shortname = "priceconstraint";

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
    public static final PriceConstraint EMPTY = new PriceConstraint();

    public PriceConstraint() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PriceConstraint(org.w3c.dom.Element element) {
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
                case PriceConstraintType.refname:
                case PriceConstraintType.shortname:
                    priceConstraintType = new PriceConstraintType(e);
                    break;
                case PriceConstraintStatus.refname:
                case PriceConstraintStatus.shortname:
                    priceConstraintStatus = new PriceConstraintStatus(e);
                    break;
                case PriceConstraintLimit.refname:
                case PriceConstraintLimit.shortname:
                    priceConstraintLimits = JPU.addToList(priceConstraintLimits, new PriceConstraintLimit(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PriceConstraint&gt; or &lt;priceconstraint&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private PriceConstraintType priceConstraintType = PriceConstraintType.EMPTY;

    /**
     * <p>
     * An ONIX code specifying a type of commercial term or constraint forming part of the commercial offer for a
     * digital product. Mandatory in each occurrence of the &lt;PriceConstraint&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public PriceConstraintType priceConstraintType() {
        _initialize();
        return priceConstraintType;
    }

    private PriceConstraintStatus priceConstraintStatus = PriceConstraintStatus.EMPTY;

    /**
     * <p>
     * An ONIX code specifying the status of a contractual term or constraint, <i>eg</i> permitted without limit,
     * permitted with limit, prohibited. Mandatory in each occurrence of the &lt;PriceConstraint&gt; composite, and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public PriceConstraintStatus priceConstraintStatus() {
        _initialize();
        return priceConstraintStatus;
    }

    private ListOfOnixDataComposite<PriceConstraintLimit, JonixPriceConstraintLimit> priceConstraintLimits =
        ListOfOnixDataComposite.empty();

    /**
     * <p>
     * An optional and repeatable group of data elements which together specify a quantitative limit on a particular
     * type of contractual term or constraint.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<PriceConstraintLimit, JonixPriceConstraintLimit> priceConstraintLimits() {
        _initialize();
        return priceConstraintLimits;
    }
}
