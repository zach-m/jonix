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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixWebsite;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Event composite</h1>
 * <p>
 * A group of data elements which together describe an event to which the product is related. Optional, and repeatable
 * if the product contains material from or is related to two or more events.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Event&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;event&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Event}</li>
 * </ul>
 *
 * @since Onix-3.03
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
                case EventNumber.refname:
                case EventNumber.shortname:
                    eventNumber = new EventNumber(e);
                    break;
                case EventDate.refname:
                case EventDate.shortname:
                    eventDate = new EventDate(e);
                    break;
                case EventAcronym.refname:
                case EventAcronym.shortname:
                    eventAcronyms = JPU.addToList(eventAcronyms, new EventAcronym(e));
                    break;
                case EventTheme.refname:
                case EventTheme.shortname:
                    eventThemes = JPU.addToList(eventThemes, new EventTheme(e));
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

    /**
     * @return whether this tag (&lt;Event&gt; or &lt;event&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private EventRole eventRole = EventRole.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the relationship between the product and an event to which it is related, <i>eg</i>
     * Proceedings of conference / Selected papers from conference / Programme for sporting event / Guide for art
     * exhibition. Mandatory and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public EventRole eventRole() {
        _initialize();
        return eventRole;
    }

    private ListOfOnixElement<EventName, String> eventNames = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of an event or series of events to which the product is related. This element is mandatory in each
     * occurrence of the &lt;Event&gt; composite, and repeatable to provide parallel names for a single event in
     * multiple languages (<i>eg</i> ‘United Nations Climate Change Conference’ and «&nbsp;Conférences des Nations unies
     * sur les changements climatiques&nbsp;»). The <i>language</i> attribute is optional for a single instance of
     * &lt;EventName&gt;, but must be included in each instance if &lt;EventName&gt; is repeated.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<EventName, String> eventNames() {
        _initialize();
        return eventNames;
    }

    private EventNumber eventNumber = EventNumber.EMPTY;

    /**
     * <p>
     * The number of an event to which the product is related, within a series of events. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EventNumber eventNumber() {
        _initialize();
        return eventNumber;
    }

    private EventDate eventDate = EventDate.EMPTY;

    /**
     * <p>
     * The date of an event to which the product is related. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EventDate eventDate() {
        _initialize();
        return eventDate;
    }

    private ListOfOnixElement<EventAcronym, String> eventAcronyms = ListOfOnixElement.empty();

    /**
     * <p>
     * An acronym used as a short form of the name of an event or series of events given in the &lt;EventName&gt;
     * element. Optional, and repeatable to provide parallel acronyms for a single event in multiple languages. The
     * <i>language</i> attribute is optional for a single instance of &lt;EventAcronym&gt;, but must be included in each
     * instance if &lt;EventAcronym&gt; is repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EventAcronym, String> eventAcronyms() {
        _initialize();
        return eventAcronyms;
    }

    private ListOfOnixElement<EventTheme, String> eventThemes = ListOfOnixElement.empty();

    /**
     * <p>
     * The thematic title of an individual event in a series that has an event series name in the &lt;EventName&gt;
     * element. Optional, and repeatable to provide parallel thematic titles for a single event in multiple languages.
     * The <i>language</i> attribute is optional for a single instance of &lt;EventTheme&gt;, but must be included in
     * each instance if &lt;EventTheme&gt; is repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EventTheme, String> eventThemes() {
        _initialize();
        return eventThemes;
    }

    private ListOfOnixElement<EventPlace, String> eventPlaces = ListOfOnixElement.empty();

    /**
     * <p>
     * The place of an event to which the product is related. Optional, and repeatable to provide parallel placenames
     * for a single location in multiple languages. The <i>language</i> attribute is optional for a single instance of
     * &lt;EventPlace&gt;, but must be included in each instance if &lt;EventPlace&gt; is repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EventPlace, String> eventPlaces() {
        _initialize();
        return eventPlaces;
    }

    private List<EventSponsor> eventSponsors = Collections.emptyList();

    /**
     * <p>
     * An optional group of data elements which together identify an organizer or sponsor of an event. <em>Either</em>
     * an identifier, <em>or</em> one or other of &lt;PersonName&gt; or &lt;CorporateName&gt;, <em>or</em> both an
     * identifier and a name, must be present in each occurrence of the composite. The composite is repeatable in order
     * to specify multiple organizers and sponsors.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<EventSponsor> eventSponsors() {
        _initialize();
        return eventSponsors;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * An optional group of data elements which together identify and provide a pointer to a website which is related to
     * the event identified in an occurrence of the &lt;Event&gt; composite. Repeatable in order to provide links to
     * multiple websites.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }
}
