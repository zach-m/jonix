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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixDataCompositeUncommon;
import com.tectonica.jonix.codelist.CountryCodes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.RightsRegions;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sales rights composite</h1><p>A repeatable group of data elements which together identify territorial sales
 * rights which a publisher chooses to exercise in a product. The &lt;SalesRights&gt; composite may occur once for each
 * value of &lt;b089&gt;. See examples at the end of Group&nbsp;PR.21.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;SalesRights&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;salesrights&gt;</td></tr></table>
 */
public class SalesRights implements OnixDataCompositeUncommon, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SalesRights";
    public static final String shortname = "salesrights";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public LanguageCodes language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final SalesRights EMPTY = new SalesRights();

    public SalesRights() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SalesRights(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
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
                case SalesRightsType.refname:
                case SalesRightsType.shortname:
                    salesRightsType = new SalesRightsType(e);
                    break;
                case RightsCountry.refname:
                case RightsCountry.shortname:
                    rightsCountrys = JPU.addToList(rightsCountrys, new RightsCountry(e));
                    break;
                case RightsTerritory.refname:
                case RightsTerritory.shortname:
                    rightsTerritory = new RightsTerritory(e);
                    break;
                case RightsRegion.refname:
                case RightsRegion.shortname:
                    rightsRegions = JPU.addToList(rightsRegions, new RightsRegion(e));
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

    private SalesRightsType salesRightsType = SalesRightsType.EMPTY;

    /**
     * (this field is required)
     */
    public SalesRightsType salesRightsType() {
        _initialize();
        return salesRightsType;
    }

    private ListOfOnixElement<RightsCountry, java.util.Set<CountryCodes>> rightsCountrys = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<RightsCountry, java.util.Set<CountryCodes>> rightsCountrys() {
        _initialize();
        return rightsCountrys;
    }

    private RightsTerritory rightsTerritory = RightsTerritory.EMPTY;

    /**
     * (this field is optional)
     */
    public RightsTerritory rightsTerritory() {
        _initialize();
        return rightsTerritory;
    }

    private ListOfOnixElement<RightsRegion, RightsRegions> rightsRegions = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<RightsRegion, RightsRegions> rightsRegions() {
        _initialize();
        return rightsRegions;
    }
}
