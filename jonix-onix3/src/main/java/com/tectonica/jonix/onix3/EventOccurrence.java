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
import com.tectonica.jonix.common.ListOfOnixComposite;
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.EventIdentifierTypes;
import com.tectonica.jonix.common.codelist.EventOccurrenceDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixEventIdentifier;
import com.tectonica.jonix.common.struct.JonixOccurrenceDate;
import com.tectonica.jonix.common.struct.JonixWebsite;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Event occurrence composite</h1>
 * <p>
 * A group of data elements which together describe a single occurrence of the promotional event. At least one
 * occurrence is mandatory within the &lt;PromotionalEvent&gt; composite, and &lt;EventOccurrence&gt; is repeatable in
 * order to list a group of more or less similar occurrences such as a series of book signings.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;EventOccurrence&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;eventoccurrence&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;EventOccurrence&gt; from the schema author:
 *
 * Details for a particular occurrence of an event promoting the product &#9679; Added &lt;PostalCode&gt; at revision
 * 3.1.2 &#9679; Added &lt;SupportingResource&gt; at revision 3.0.8 &#9679; Added at revision 3.0.7
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PromotionalEvent}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence}</li>
 * </ul>
 *
 * @since Onix-3.07
 */
public class EventOccurrence implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EventOccurrence";
    public static final String shortname = "eventoccurrence";

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
    public static final EventOccurrence EMPTY = new EventOccurrence();

    public EventOccurrence() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public EventOccurrence(org.w3c.dom.Element element) {
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
                case EventStatus.refname:
                case EventStatus.shortname:
                    eventStatus = new EventStatus(e);
                    break;
                case CountryCode.refname:
                case CountryCode.shortname:
                    countryCode = new CountryCode(e);
                    break;
                case OccurrenceDate.refname:
                case OccurrenceDate.shortname:
                    occurrenceDates = JPU.addToList(occurrenceDates, new OccurrenceDate(e));
                    break;
                case RegionCode.refname:
                case RegionCode.shortname:
                    regionCode = new RegionCode(e);
                    break;
                case VenueName.refname:
                case VenueName.shortname:
                    venueName = new VenueName(e);
                    break;
                case StreetAddress.refname:
                case StreetAddress.shortname:
                    streetAddress = new StreetAddress(e);
                    break;
                case PostalCode.refname:
                case PostalCode.shortname:
                    postalCode = new PostalCode(e);
                    break;
                case EventIdentifier.refname:
                case EventIdentifier.shortname:
                    eventIdentifiers = JPU.addToList(eventIdentifiers, new EventIdentifier(e));
                    break;
                case LocationName.refname:
                case LocationName.shortname:
                    locationNames = JPU.addToList(locationNames, new LocationName(e));
                    break;
                case VenueNote.refname:
                case VenueNote.shortname:
                    venueNotes = JPU.addToList(venueNotes, new VenueNote(e));
                    break;
                case EventDescription.refname:
                case EventDescription.shortname:
                    eventDescriptions = JPU.addToList(eventDescriptions, new EventDescription(e));
                    break;
                case SupportingResource.refname:
                case SupportingResource.shortname:
                    supportingResources = JPU.addToList(supportingResources, new SupportingResource(e));
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
     * @return whether this tag (&lt;EventOccurrence&gt; or &lt;eventoccurrence&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<EventOccurrence> action) {
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

    private EventStatus eventStatus = EventStatus.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the status of a particular occurrence of a promotional event occurrence. Mandatory
     * within each instance of the &lt;EventOccurrence&gt; composite, and non-repeatable.
     * </p>
     * JONIX adds: this field is required
     */
    public EventStatus eventStatus() {
        _initialize();
        return eventStatus;
    }

    private CountryCode countryCode = CountryCode.EMPTY;

    /**
     * <p>
     * An ONIX code identifying a country within which an event occurrence takes place. Optional and non-repeatable. For
     * a physical event, at least one of the &lt;CountryCode&gt; or &lt;RegionCode&gt; elements is required in each
     * instance of &lt;EventOccurrence&gt;. For purely digital events, both must be omitted.
     * </p>
     * JONIX adds: this field is required
     */
    public CountryCode countryCode() {
        _initialize();
        return countryCode;
    }

    private ListOfOnixDataCompositeWithKey<OccurrenceDate, JonixOccurrenceDate,
        EventOccurrenceDateRoles> occurrenceDates = JPU.emptyListOfOnixDataCompositeWithKey(OccurrenceDate.class);

    /**
     * <p>
     * A group of data elements which together specify a date associated with the event occurrence. At least the date
     * (and typically also the time) the event occurrence begins must be specified, and other dates related to the event
     * occurrence can be sent in further repeats of the composite.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<OccurrenceDate, JonixOccurrenceDate, EventOccurrenceDateRoles>
        occurrenceDates() {
        _initialize();
        return occurrenceDates;
    }

    private RegionCode regionCode = RegionCode.EMPTY;

    /**
     * <p>
     * An ONIX code identifying a region within which an event occurrence takes place. Optional and non-repeatable. For
     * a physical event, at least one of the &lt;CountryCode&gt; or &lt;RegionCode&gt; elements is required in each
     * instance of &lt;EventOccurrence&gt;. For purely digital events, both must be omitted.
     * </p>
     * JONIX adds: this field is optional
     */
    public RegionCode regionCode() {
        _initialize();
        return regionCode;
    }

    private VenueName venueName = VenueName.EMPTY;

    /**
     * <p>
     * The name of the venue at which the event occurrence takes place, for example the name of the bookstore. Optional,
     * but required for a physical event and omitted for a purely digital event.
     * </p>
     * JONIX adds: this field is optional
     */
    public VenueName venueName() {
        _initialize();
        return venueName;
    }

    private StreetAddress streetAddress = StreetAddress.EMPTY;

    /**
     * <p>
     * The street address of the named venue. Optional, but typically required for physical events and omitted for a
     * purely digital event. Care should be taken that if the Street address is provided, then the Venue name, Street
     * address, Location name, any Postal code or Region code, and the Country code can be combined into a complete
     * postal address, without repetition.
     * </p>
     * JONIX adds: this field is optional
     */
    public StreetAddress streetAddress() {
        _initialize();
        return streetAddress;
    }

    private PostalCode postalCode = PostalCode.EMPTY;

    /**
     * <p>
     * The postal code (postcode, zip code <i>etc</i>), forming part of the postal address of the venue. Optional and
     * non-repeatable if a Street address is present, but otherwise omitted.
     * </p>
     * JONIX adds: this field is optional
     */
    public PostalCode postalCode() {
        _initialize();
        return postalCode;
    }

    private ListOfOnixDataCompositeWithKey<EventIdentifier, JonixEventIdentifier,
        EventIdentifierTypes> eventIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(EventIdentifier.class);

    /**
     * <p>
     * An optional group of data elements which together define an identifier for an event occurrence. The composite is
     * repeatable in order to specify multiple identifiers for the same occurrence.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<EventIdentifier, JonixEventIdentifier, EventIdentifierTypes>
        eventIdentifiers() {
        _initialize();
        return eventIdentifiers;
    }

    private ListOfOnixElement<LocationName, String> locationNames = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a city or town location within the specified country or region at which an event occurrence takes
     * place. Optional, but required for a physical event and omitted for a purely digital event, and repeatable to
     * provide parallel names for a single location in multiple languages (<i>eg</i>&nbsp;Baile Átha Cliath and Dublin,
     * or Bruxelles and Brussel). It may if necessary include a postal code (<i>eg</i>&nbsp;10680 Αθήνα, or 20090
     * Assago). The <i>language</i> attribute is optional for a single instance of &lt;LocationName&gt;, but must be
     * included in each instance if &lt;LocationName&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<LocationName, String> locationNames() {
        _initialize();
        return locationNames;
    }

    private ListOfOnixElement<VenueNote, String> venueNotes = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text of a short note related to the venue. Optional, and repeatable to provide parallel notes in multiple
     * languages. The <i>language</i> attribute is optional for a single instance of &lt;VenueNote&gt;, but must be
     * included in each instance if &lt;VenueNote&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<VenueNote, String> venueNotes() {
        _initialize();
        return venueNotes;
    }

    private ListOfOnixElement<EventDescription, String> eventDescriptions = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text describing the promotional event occurrence. Optional, and repeatable to provide parallel text in
     * multiple languages. The <i>language</i> attribute is optional for a single instance of &lt;EventDescription&gt;,
     * but must be included in each instance if &lt;EventDescription&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<EventDescription, String> eventDescriptions() {
        _initialize();
        return eventDescriptions;
    }

    private ListOfOnixComposite<SupportingResource> supportingResources =
        JPU.emptyListOfOnixComposite(SupportingResource.class);

    /**
     * <p>
     * An optional group of data elements which together describe a supporting resource related to an occurrence of a
     * promotional event. The composite is repeatable to describe and link to multiple resources. Note that different
     * forms of the same resource (for example a cover image in separate low and high resolution versions) should be
     * specified in a single instance of the composite.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<SupportingResource> supportingResources() {
        _initialize();
        return supportingResources;
    }

    private ListOfOnixComposite<EventSponsor> eventSponsors = JPU.emptyListOfOnixComposite(EventSponsor.class);

    /**
     * <p>
     * An optional group of data elements which together identify an organizer or sponsor of an event occurrence. Either
     * an &lt;EventSponsorIdentifier&gt;, or one or other of &lt;PersonName&gt; or &lt;CorporateName&gt;, or both an
     * identifier and a name, must be present in each occurrence of the composite. The composite is repeatable in order
     * to specify multiple organizers and sponsors.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<EventSponsor> eventSponsors() {
        _initialize();
        return eventSponsors;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = JPU.emptyListOfOnixDataComposite(Website.class);

    /**
     * <p>
     * An optional group of data elements which together identify and provide pointers to a website which is related to
     * the event occurrence&nbsp;– for example a website providing a ticketing service. Repeatable to provide links to
     * multiple websites.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }
}
