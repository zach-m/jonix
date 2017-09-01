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
import com.tectonica.jonix.struct.JonixPrize;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Prize or award composite</h1><p>An optional and repeatable group of data elements which together describe a prize
 * or award won by the product.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;Prize&gt;</td></tr><tr><td>Short tag</td><td>&lt;prize&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    public String sourcename;

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
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

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

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ListOfOnixElement<PrizeName, String> prizeNames = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<PrizeName, String> prizeNames() {
        initialize();
        return prizeNames;
    }

    private PrizeYear prizeYear = PrizeYear.EMPTY;

    /**
     * (this field is optional)
     */
    public PrizeYear prizeYear() {
        initialize();
        return prizeYear;
    }

    private PrizeCountry prizeCountry = PrizeCountry.EMPTY;

    /**
     * (this field is optional)
     */
    public PrizeCountry prizeCountry() {
        initialize();
        return prizeCountry;
    }

    private PrizeCode prizeCode = PrizeCode.EMPTY;

    /**
     * (this field is optional)
     */
    public PrizeCode prizeCode() {
        initialize();
        return prizeCode;
    }

    private ListOfOnixElement<PrizeStatement, String> prizeStatements = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<PrizeStatement, String> prizeStatements() {
        initialize();
        return prizeStatements;
    }

    private ListOfOnixElement<PrizeJury, String> prizeJurys = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<PrizeJury, String> prizeJurys() {
        initialize();
        return prizeJurys;
    }

    @Override
    public JonixPrize asStruct() {
        initialize();
        JonixPrize struct = new JonixPrize();
        struct.prizeCode = prizeCode.value;
        struct.prizeCountry = prizeCountry.value;
        struct.prizeJurys = prizeJurys.values();
        struct.prizeNames = prizeNames.values();
        struct.prizeYear = prizeYear.value;
        return struct;
    }
}
