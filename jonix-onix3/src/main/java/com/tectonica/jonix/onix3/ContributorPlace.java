/*
 * Copyright (C) 2012-2023 Zach Melamed
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
import com.tectonica.jonix.common.struct.JonixContributorPlace;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Contributor place composite</h1>
 * <p>
 * An optional group of data elements which together identify a geographical location with which a contributor is
 * associated, used to support ‘local interest’ promotions. Repeatable to identify multiple geographical locations, each
 * usually with a different relationship to the contributor.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ContributorPlace&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;contributorplace&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Contributor}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈
 * {@link ContributorPlace}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈
 * {@link ContributorPlace}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor}
 * ⯈ {@link ContributorPlace}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈
 * {@link ContributorPlace}</li>
 * </ul>
 */
public class ContributorPlace implements OnixDataComposite<JonixContributorPlace>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ContributorPlace";
    public static final String shortname = "contributorplace";

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
    public static final ContributorPlace EMPTY = new ContributorPlace();

    public ContributorPlace() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ContributorPlace(org.w3c.dom.Element element) {
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
                case ContributorPlaceRelator.refname:
                case ContributorPlaceRelator.shortname:
                    contributorPlaceRelator = new ContributorPlaceRelator(e);
                    break;
                case CountryCode.refname:
                case CountryCode.shortname:
                    countryCode = new CountryCode(e);
                    break;
                case RegionCode.refname:
                case RegionCode.shortname:
                    regionCode = new RegionCode(e);
                    break;
                case LocationName.refname:
                case LocationName.shortname:
                    locationNames = JPU.addToList(locationNames, new LocationName(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ContributorPlace&gt; or &lt;contributorplace&gt;) is explicitly provided in the
     *         ONIX XML
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

    private ContributorPlaceRelator contributorPlaceRelator = ContributorPlaceRelator.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the relationship between a contributor and a geographical location. Mandatory in each
     * occurrence of &lt;ContributorPlace&gt; and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ContributorPlaceRelator contributorPlaceRelator() {
        _initialize();
        return contributorPlaceRelator;
    }

    private CountryCode countryCode = CountryCode.EMPTY;

    /**
     * <p>
     * An ONIX code identifying a country with which a contributor is particularly associated. Optional and
     * non-repeatable. There must be an occurrence of either the &lt;CountryCode&gt; or the &lt;RegionCode&gt; elements
     * in each occurrence of &lt;ContributorPlace&gt;.
     * </p>
     * Jonix-Comment: this field is required
     */
    public CountryCode countryCode() {
        _initialize();
        return countryCode;
    }

    private RegionCode regionCode = RegionCode.EMPTY;

    /**
     * <p>
     * An ONIX code identifying a region with which a contributor is particularly associated. Optional and
     * non-repeatable. There must be an occurrence of either the &lt;CountryCode&gt; or the &lt;RegionCode&gt; elements
     * in each occurrence of &lt;ContributorPlace&gt;. A region is an area which is not a country, but which is
     * precisely defined in geographical terms, <i>eg</i> Northern Ireland, Australian Capital Territory. If both
     * country and region are specified, the region must be within the country. Note that US States have region codes,
     * while US overseas territories have distinct ISO Country Codes.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public RegionCode regionCode() {
        _initialize();
        return regionCode;
    }

    private ListOfOnixElement<LocationName, String> locationNames = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a city or town location within the specified country or region with which a contributor is
     * particularly associated. Optional, and repeatable to provide parallel names for a single location in multiple
     * languages (<i>eg</i> Baile Átha Cliath and Dublin, or Bruxelles and Brussel). The <i>language</i> attribute is
     * optional for a single instance of &lt;LocationName&gt;, but must be included in each instance if
     * &lt;LocationName&gt; is repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<LocationName, String> locationNames() {
        _initialize();
        return locationNames;
    }

    @Override
    public JonixContributorPlace asStruct() {
        _initialize();
        JonixContributorPlace struct = new JonixContributorPlace();
        struct.contributorPlaceRelator = contributorPlaceRelator.value;
        struct.countryCode = countryCode.value;
        struct.regionCode = regionCode.value;
        struct.locationNames = locationNames.values();
        return struct;
    }
}
