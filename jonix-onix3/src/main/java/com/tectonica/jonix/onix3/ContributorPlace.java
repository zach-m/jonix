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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixContributorPlace;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Contributor place composite</h1><p>An optional group of data elements which together identify a geographical
 * location with which a contributor is associated, used to support ‘local interest’ promotions. Repeatable to identify
 * multiple geographical locations, each usually with a different relationship to the contributor.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;ContributorPlace&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;contributorplace&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ContributorPlaceRelator contributorPlaceRelator = ContributorPlaceRelator.EMPTY;

    /**
     * (this field is required)
     */
    public ContributorPlaceRelator contributorPlaceRelator() {
        _initialize();
        return contributorPlaceRelator;
    }

    private CountryCode countryCode = CountryCode.EMPTY;

    /**
     * (this field is required)
     */
    public CountryCode countryCode() {
        _initialize();
        return countryCode;
    }

    private RegionCode regionCode = RegionCode.EMPTY;

    /**
     * (this field is optional)
     */
    public RegionCode regionCode() {
        _initialize();
        return regionCode;
    }

    private ListOfOnixElement<LocationName, String> locationNames = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
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
