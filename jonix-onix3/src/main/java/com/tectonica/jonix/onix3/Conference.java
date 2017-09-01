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
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixWebsite;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Conference composite</h1><p>A group of data elements which together describe a conference to which the product is
 * related. Optional, and repeatable if the product contains material from two or more conferences.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;Conference&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;conference&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class Conference implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Conference";
    public static final String shortname = "conference";

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
    public static final Conference EMPTY = new Conference();

    public Conference() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Conference(org.w3c.dom.Element element) {
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
            if (name.equals(ConferenceRole.refname) || name.equals(ConferenceRole.shortname)) {
                conferenceRole = new ConferenceRole(e);
            } else if (name.equals(ConferenceName.refname) || name.equals(ConferenceName.shortname)) {
                conferenceName = new ConferenceName(e);
            } else if (name.equals(ConferenceAcronym.refname) || name.equals(ConferenceAcronym.shortname)) {
                conferenceAcronym = new ConferenceAcronym(e);
            } else if (name.equals(ConferenceNumber.refname) || name.equals(ConferenceNumber.shortname)) {
                conferenceNumber = new ConferenceNumber(e);
            } else if (name.equals(ConferenceTheme.refname) || name.equals(ConferenceTheme.shortname)) {
                conferenceTheme = new ConferenceTheme(e);
            } else if (name.equals(ConferenceDate.refname) || name.equals(ConferenceDate.shortname)) {
                conferenceDate = new ConferenceDate(e);
            } else if (name.equals(ConferencePlace.refname) || name.equals(ConferencePlace.shortname)) {
                conferencePlace = new ConferencePlace(e);
            } else if (name.equals(ConferenceSponsor.refname) || name.equals(ConferenceSponsor.shortname)) {
                conferenceSponsors = JPU.addToList(conferenceSponsors, new ConferenceSponsor(e));
            } else if (name.equals(Website.refname) || name.equals(Website.shortname)) {
                websites = JPU.addToList(websites, new Website(e));
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

    private ConferenceRole conferenceRole = ConferenceRole.EMPTY;

    /**
     * (this field is optional)
     */
    public ConferenceRole conferenceRole() {
        initialize();
        return conferenceRole;
    }

    private ConferenceName conferenceName = ConferenceName.EMPTY;

    /**
     * (this field is required)
     */
    public ConferenceName conferenceName() {
        initialize();
        return conferenceName;
    }

    private ConferenceAcronym conferenceAcronym = ConferenceAcronym.EMPTY;

    /**
     * (this field is optional)
     */
    public ConferenceAcronym conferenceAcronym() {
        initialize();
        return conferenceAcronym;
    }

    private ConferenceNumber conferenceNumber = ConferenceNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public ConferenceNumber conferenceNumber() {
        initialize();
        return conferenceNumber;
    }

    private ConferenceTheme conferenceTheme = ConferenceTheme.EMPTY;

    /**
     * (this field is optional)
     */
    public ConferenceTheme conferenceTheme() {
        initialize();
        return conferenceTheme;
    }

    private ConferenceDate conferenceDate = ConferenceDate.EMPTY;

    /**
     * (this field is optional)
     */
    public ConferenceDate conferenceDate() {
        initialize();
        return conferenceDate;
    }

    private ConferencePlace conferencePlace = ConferencePlace.EMPTY;

    /**
     * (this field is optional)
     */
    public ConferencePlace conferencePlace() {
        initialize();
        return conferencePlace;
    }

    private List<ConferenceSponsor> conferenceSponsors = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<ConferenceSponsor> conferenceSponsors() {
        initialize();
        return conferenceSponsors;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        initialize();
        return websites;
    }
}
