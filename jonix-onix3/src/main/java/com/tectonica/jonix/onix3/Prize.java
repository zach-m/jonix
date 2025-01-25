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
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

import com.tectonica.jonix.common.*;
import com.tectonica.jonix.common.OnixComposite.*;
import com.tectonica.jonix.common.codelist.*;
import com.tectonica.jonix.common.struct.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Prize composite</h1>
 * <p>
 * An optional group of data elements which together describe a prize or award won by the contributor for a body of work
 * (rather than for this or other specific works or products). Repeatable to describe multiple prizes or awards.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Prize&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;prize&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Prize&gt; from the schema author:
 *
 * Details of a literary or other prize associated with the product or work, or with a contributor &#9679; Added
 * &lt;PrizeRegion&gt; at revision 3.0.7 &#9679; Added &lt;PrizeStatement&gt; at revision 3.0.2 &#9679; Modified
 * cardinality of &lt;PrizeName&gt; at revision 3.0.2 &#9679; Modified cardinality of &lt;PrizeJury&gt; at revision
 * 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link CollateralDetail}&gt;</li>
 * <li>&lt;{@link Contributor}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link Prize}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link Prize}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link Prize}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈ {@link Prize}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈ {@link Prize}</li>
 * </ul>
 *
 * @since Onix-3.03
 */
public class Prize implements OnixDataComposite<JonixPrize>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Prize";
    public static final String shortname = "prize";

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
    public static final Prize EMPTY = new Prize();

    public Prize() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Prize(org.w3c.dom.Element element) {
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
                case PrizeName.refname:
                case PrizeName.shortname:
                    prizeNames = JPU.addToList(prizeNames, new PrizeName(e));
                    break;
                case PrizeYear.refname:
                case PrizeYear.shortname:
                    prizeYear = new PrizeYear(e);
                    break;
                case PrizeCountry.refname:
                case PrizeCountry.shortname:
                    prizeCountry = new PrizeCountry(e);
                    break;
                case PrizeRegion.refname:
                case PrizeRegion.shortname:
                    prizeRegion = new PrizeRegion(e);
                    break;
                case PrizeCode.refname:
                case PrizeCode.shortname:
                    prizeCode = new PrizeCode(e);
                    break;
                case PrizeStatement.refname:
                case PrizeStatement.shortname:
                    prizeStatements = JPU.addToList(prizeStatements, new PrizeStatement(e));
                    break;
                case PrizeJury.refname:
                case PrizeJury.shortname:
                    prizeJurys = JPU.addToList(prizeJurys, new PrizeJury(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Prize&gt; or &lt;prize&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Prize> action) {
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

    private ListOfOnixElement<PrizeName, String> prizeNames = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a prize or award which the product or work has received. Mandatory in each occurrence of the
     * &lt;Prize&gt; composite, and repeatable to provide a parallel award name in multiple languages. The
     * <i>language</i> attribute is optional for a single instance of &lt;PrizeName&gt;, but must be included in each
     * instance if &lt;PrizeName&gt; is repeated.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixElement<PrizeName, String> prizeNames() {
        _initialize();
        return prizeNames;
    }

    private PrizeYear prizeYear = PrizeYear.EMPTY;

    /**
     * <p>
     * The year in which a prize or award was given. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public PrizeYear prizeYear() {
        _initialize();
        return prizeYear;
    }

    private PrizeCountry prizeCountry = PrizeCountry.EMPTY;

    /**
     * <p>
     * An ISO standard code identifying the country in which a prize or award is given. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public PrizeCountry prizeCountry() {
        _initialize();
        return prizeCountry;
    }

    private PrizeRegion prizeRegion = PrizeRegion.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the region in which a prize or award is given. Optional and non-repeatable. A region is
     * an area which is not a country, but which is precisely defined in geographical terms, <i>eg</i> Newfoundland and
     * Labrador, Florida. If both country and region are specified, the region must be within the country. Note that US
     * States have region codes, while US overseas territories have distinct ISO Country Codes.
     * </p>
     * JONIX adds: this field is optional
     */
    public PrizeRegion prizeRegion() {
        _initialize();
        return prizeRegion;
    }

    private PrizeCode prizeCode = PrizeCode.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the achievement of the product in relation to a prize or award, <i>eg</i> winner,
     * runner-up, shortlisted. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public PrizeCode prizeCode() {
        _initialize();
        return prizeCode;
    }

    private ListOfOnixElement<PrizeStatement, String> prizeStatements = ListOfOnixElement.empty();

    /**
     * <p>
     * A short free-text description of the prize or award, intended primarily for display. Optional, and repeatable if
     * the text is provided in more than one language. The <i>language</i> attribute is optional for a single instance
     * of &lt;PrizeStatement&gt;, but must be included in each instance if &lt;PrizeStatement&gt; is repeated.
     * </p>
     * <p>
     * &lt;PrizeStatement&gt; is intended for display purposes only. When used, a &lt;PrizeStatement&gt; must be
     * complete in itself, <i>ie</i> it should not be treated as merely supplementary to other elements within the
     * &lt;Prize&gt; composite. Nor should &lt;PrizeStatement&gt; be supplied <em>instead</em> of those other elements –
     * at minimum, the &lt;PrizeCode&gt; element, and whenever appropriate the &lt;PrizeYear&gt; element should be
     * supplied.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<PrizeStatement, String> prizeStatements() {
        _initialize();
        return prizeStatements;
    }

    private ListOfOnixElement<PrizeJury, String> prizeJurys = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text listing members of the jury that awarded the prize. Optional, and repeatable if the text is provided in
     * more than one language. The <i>language</i> attribute is optional for a single instance of &lt;PrizeJury&gt;, but
     * must be included in each instance if &lt;PrizeJury&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<PrizeJury, String> prizeJurys() {
        _initialize();
        return prizeJurys;
    }

    @Override
    public JonixPrize asStruct() {
        _initialize();
        JonixPrize struct = new JonixPrize();
        struct.prizeCode = prizeCode.value;
        struct.prizeCountry = prizeCountry.value;
        struct.prizeJurys = prizeJurys.values();
        struct.prizeNames = prizeNames.values();
        struct.prizeYear = prizeYear.value;
        return struct;
    }
}
