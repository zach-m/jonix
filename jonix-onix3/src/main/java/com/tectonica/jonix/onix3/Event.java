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
import com.tectonica.jonix.ListOfOnixElement;
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
 * <h1>Event composite</h1><p>A group of data elements which together describe an event to which the product is related.
 * Optional, and repeatable if the product contains material from or is related to two or more events.</p><table
 * border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;Event&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;event&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class Event implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Event";
    public static final String shortname = "event";

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
    public static final Event EMPTY = new Event();

    public Event() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Event(org.w3c.dom.Element element) {
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
                case EventRole.refname:
                case EventRole.shortname:
                    eventRole = new EventRole(e);
                    break;
                case EventName.refname:
                case EventName.shortname:
                    eventNames = JPU.addToList(eventNames, new EventName(e));
                    break;
                case EventAcronym.refname:
                case EventAcronym.shortname:
                    eventAcronyms = JPU.addToList(eventAcronyms, new EventAcronym(e));
                    break;
                case EventNumber.refname:
                case EventNumber.shortname:
                    eventNumber = new EventNumber(e);
                    break;
                case EventTheme.refname:
                case EventTheme.shortname:
                    eventThemes = JPU.addToList(eventThemes, new EventTheme(e));
                    break;
                case EventDate.refname:
                case EventDate.shortname:
                    eventDate = new EventDate(e);
                    break;
                case EventPlace.refname:
                case EventPlace.shortname:
                    eventPlaces = JPU.addToList(eventPlaces, new EventPlace(e));
                    break;
                case EventSponsor.refname:
                case EventSponsor.shortname:
                    eventSponsors = JPU.addToList(eventSponsors, new EventSponsor(e));
                    break;
                case Website.refname:
                case Website.shortname:
                    websites = JPU.addToList(websites, new Website(e));
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

    private EventRole eventRole = EventRole.EMPTY;

    /**
     * (this field is required)
     */
    public EventRole eventRole() {
        _initialize();
        return eventRole;
    }

    private ListOfOnixElement<EventName, String> eventNames = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<EventName, String> eventNames() {
        _initialize();
        return eventNames;
    }

    private ListOfOnixElement<EventAcronym, String> eventAcronyms = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<EventAcronym, String> eventAcronyms() {
        _initialize();
        return eventAcronyms;
    }

    private EventNumber eventNumber = EventNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public EventNumber eventNumber() {
        _initialize();
        return eventNumber;
    }

    private ListOfOnixElement<EventTheme, String> eventThemes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<EventTheme, String> eventThemes() {
        _initialize();
        return eventThemes;
    }

    private EventDate eventDate = EventDate.EMPTY;

    /**
     * (this field is optional)
     */
    public EventDate eventDate() {
        _initialize();
        return eventDate;
    }

    private ListOfOnixElement<EventPlace, String> eventPlaces = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<EventPlace, String> eventPlaces() {
        _initialize();
        return eventPlaces;
    }

    private List<EventSponsor> eventSponsors = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<EventSponsor> eventSponsors() {
        _initialize();
        return eventSponsors;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }
}
