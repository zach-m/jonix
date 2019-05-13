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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sales restriction composite</h1><p>A group of data elements which together identify a non-territorial sales
 * restriction which applies within a geographical market. Optional, and repeatable if more than a single restriction
 * applies.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;SalesRestriction&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;salesrestriction&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class SalesRestriction implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SalesRestriction";
    public static final String shortname = "salesrestriction";

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
    public static final SalesRestriction EMPTY = new SalesRestriction();

    public SalesRestriction() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SalesRestriction(org.w3c.dom.Element element) {
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
                case SalesRestrictionType.refname:
                case SalesRestrictionType.shortname:
                    salesRestrictionType = new SalesRestrictionType(e);
                    break;
                case SalesOutlet.refname:
                case SalesOutlet.shortname:
                    salesOutlets = JPU.addToList(salesOutlets, new SalesOutlet(e));
                    break;
                case SalesRestrictionNote.refname:
                case SalesRestrictionNote.shortname:
                    salesRestrictionNotes = JPU.addToList(salesRestrictionNotes, new SalesRestrictionNote(e));
                    break;
                case StartDate.refname:
                case StartDate.shortname:
                    startDate = new StartDate(e);
                    break;
                case EndDate.refname:
                case EndDate.shortname:
                    endDate = new EndDate(e);
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

    private SalesRestrictionType salesRestrictionType = SalesRestrictionType.EMPTY;

    /**
     * (this field is required)
     */
    public SalesRestrictionType salesRestrictionType() {
        _initialize();
        return salesRestrictionType;
    }

    private List<SalesOutlet> salesOutlets = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<SalesOutlet> salesOutlets() {
        _initialize();
        return salesOutlets;
    }

    private ListOfOnixElement<SalesRestrictionNote, String> salesRestrictionNotes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<SalesRestrictionNote, String> salesRestrictionNotes() {
        _initialize();
        return salesRestrictionNotes;
    }

    private StartDate startDate = StartDate.EMPTY;

    /**
     * (this field is optional)
     */
    public StartDate startDate() {
        _initialize();
        return startDate;
    }

    private EndDate endDate = EndDate.EMPTY;

    /**
     * (this field is optional)
     */
    public EndDate endDate() {
        _initialize();
        return endDate;
    }
}
