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
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixTerritory;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Territory composite</h1>
 * <p>
 * A group of data elements which together define a territory for which the text in the &lt;Text&gt; element is
 * specifically intended. Optional in each occurrence of the &lt;TextContent&gt; composite, and non-repeating. If
 * omitted, the text is intended for use wherever the product may be sold (see
 * <a href="#onixmessage_product_publishingdetail_p21">Group&nbsp;P.21</a>). If included, the text should be used by
 * recipients in the specified territory in preference to any text that lacks a specified territory.
 * </p>
 * <p>
 * Care should be taken to avoid ambiguities (for example two different ‘short descriptions’ – without <i>language</i>
 * attributes or with the same <i>language</i> attribute – marked for use in the same country or region), and to ensure
 * that appropriate descriptions and supporting text are supplied for all countries and regions where the product may be
 * sold. The simplest way to accomplish the latter is to ensure at least one version of the text does not have a
 * territory specified. Where multiple texts of the same type are provided, those without specific &lt;Territory&gt;
 * composites are intended for use only where no appropriate targeted text is present.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Territory&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;territory&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Territory&gt; from the schema author:
 *
 * Geographical area, for example an area within which a particular type of sales rights or restrictions apply
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupportingResource}&gt;</li>
 * <li>&lt;{@link TextContent}&gt;</li>
 * <li>&lt;{@link CitedContent}&gt;</li>
 * <li>&lt;{@link Market}&gt;</li>
 * <li>&lt;{@link Price}&gt;</li>
 * <li>&lt;{@link SalesRights}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈
 * {@link Territory}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link Territory}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link SupportingResource} ⯈
 * {@link Territory}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link SupportingResource} ⯈ {@link Territory}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈
 * {@link Territory}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈ {@link Territory}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link Territory}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link CitedContent} ⯈ {@link Territory}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link CitedContent} ⯈ {@link Territory}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link Market} ⯈ {@link Territory}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈
 * {@link Territory}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link Territory}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights} ⯈ {@link Territory}</li>
 * </ul>
 *
 * @since Onix-3.03
 */
public class Territory implements OnixDataComposite<JonixTerritory>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Territory";
    public static final String shortname = "territory";

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
    public static final Territory EMPTY = new Territory();

    public Territory() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Territory(org.w3c.dom.Element element) {
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
                case CountriesIncluded.refname:
                case CountriesIncluded.shortname:
                    countriesIncluded = new CountriesIncluded(e);
                    break;
                case RegionsIncluded.refname:
                case RegionsIncluded.shortname:
                    regionsIncluded = new RegionsIncluded(e);
                    break;
                case RegionsExcluded.refname:
                case RegionsExcluded.shortname:
                    regionsExcluded = new RegionsExcluded(e);
                    break;
                case CountriesExcluded.refname:
                case CountriesExcluded.shortname:
                    countriesExcluded = new CountriesExcluded(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Territory&gt; or &lt;territory&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Territory> action) {
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

    private CountriesIncluded countriesIncluded = CountriesIncluded.EMPTY;

    /**
     * <p>
     * One or more ISO standard codes identifying countries included in the territory. Successive codes must be
     * separated by spaces. Optional and non-repeating, but either &lt;CountriesIncluded&gt; or &lt;RegionsIncluded&gt;
     * is mandatory in each occurrence of the &lt;Territory&gt; composite.
     * </p>
     * JONIX adds: this field is required
     */
    public CountriesIncluded countriesIncluded() {
        _initialize();
        return countriesIncluded;
    }

    private RegionsIncluded regionsIncluded = RegionsIncluded.EMPTY;

    /**
     * <p>
     * One or more ONIX codes identifying regions included in the territory. A region is an area which is not a country,
     * but which is precisely defined in geographical terms, <i>eg</i> World, Northern Ireland, Australian Capital
     * Territory. Successive codes must be separated by spaces. Optional and non-repeating, but either
     * &lt;CountriesIncluded&gt; or &lt;RegionsIncluded&gt; is mandatory in each occurrence of the &lt;Territory&gt;
     * composite.
     * </p>
     * JONIX adds: this field is optional
     */
    public RegionsIncluded regionsIncluded() {
        _initialize();
        return regionsIncluded;
    }

    private RegionsExcluded regionsExcluded = RegionsExcluded.EMPTY;

    /**
     * <p>
     * One or more ONIX codes identifying regions excluded from the territory. Successive codes must be separated by
     * spaces. Optional and non-repeating, and can only occur if the &lt;CountriesIncluded&gt; element is also present
     * (and specifies countries of which the excluded regions are a part), or if &lt;RegionsIncluded&gt; is present and
     * includes a supra-national region code (such as ‘World’).
     * </p>
     * JONIX adds: this field is optional
     */
    public RegionsExcluded regionsExcluded() {
        _initialize();
        return regionsExcluded;
    }

    private CountriesExcluded countriesExcluded = CountriesExcluded.EMPTY;

    /**
     * <p>
     * One or more ISO standard codes identifying countries excluded from the territory. Successive codes must be
     * separated by spaces. Optional and non-repeating, and can only occur if the &lt;RegionsIncluded&gt; element is
     * also present and includes a supra-national region code (such as ‘World’).
     * </p>
     * JONIX adds: this field is optional
     */
    public CountriesExcluded countriesExcluded() {
        _initialize();
        return countriesExcluded;
    }

    @Override
    public JonixTerritory asStruct() {
        _initialize();
        JonixTerritory struct = new JonixTerritory();
        struct.countriesIncluded = countriesIncluded.value;
        struct.regionsIncluded = regionsIncluded.value;
        struct.regionsExcluded = regionsExcluded.value;
        struct.countriesExcluded = countriesExcluded.value;
        return struct;
    }
}
