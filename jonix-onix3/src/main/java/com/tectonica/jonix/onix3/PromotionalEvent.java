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

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

import com.tectonica.jonix.common.*;
import com.tectonica.jonix.common.OnixComposite.*;
import com.tectonica.jonix.common.codelist.*;
import com.tectonica.jonix.common.struct.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Promotional event composite</h1>
 * <p>
 * An group of data elements which together describe a promotional event or series of event occurrences such as an
 * author tour. Optional in any occurrence of the &lt;PromotionDetail&gt; composite, but it may be omitted only within a
 * partial or ‘block update’ (Notification or update type 04, see&nbsp;P.1.2) when the intention is to remove all
 * previously supplied promotional event detail. When used normally, it is repeatable to describe multiple events linked
 * to promotion of the product.
 * </p>
 * <p>
 * The promotional event composite must contain at least one &lt;EventOccurrence&gt;. It may optionally contain one or
 * more contributors to the event, listing those that are also contributors to the product using
 * &lt;ContributorReference&gt; and those that are <em>not</em> contributors to the product using &lt;Contributor&gt;.
 * If there are no contributors to the event of either type, an optional &lt;NoContributor/&gt; flag may be included
 * instead.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PromotionalEvent&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;promotionalevent&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;PromotionalEvent&gt; from the schema author:
 *
 * Details of an event held to promote the product &#9679; Added &lt;SupportingResource&gt; at revision 3.0.8 &#9679;
 * Added at revision 3.0.7
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PromotionDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent}</li>
 * </ul>
 *
 * @since Onix-3.07
 */
public class PromotionalEvent implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PromotionalEvent";
    public static final String shortname = "promotionalevent";

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
    public static final PromotionalEvent EMPTY = new PromotionalEvent();

    public PromotionalEvent() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PromotionalEvent(org.w3c.dom.Element element) {
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
                case EventType.refname:
                case EventType.shortname:
                    eventTypes = JPU.addToList(eventTypes, new EventType(e));
                    break;
                case ContentAudience.refname:
                case ContentAudience.shortname:
                    contentAudiences = JPU.addToList(contentAudiences, new ContentAudience(e));
                    break;
                case EventName.refname:
                case EventName.shortname:
                    eventNames = JPU.addToList(eventNames, new EventName(e));
                    break;
                case ContributorReference.refname:
                case ContributorReference.shortname:
                    contributorReferences = JPU.addToList(contributorReferences, new ContributorReference(e));
                    break;
                case EventOccurrence.refname:
                case EventOccurrence.shortname:
                    eventOccurrences = JPU.addToList(eventOccurrences, new EventOccurrence(e));
                    break;
                case EventStatus.refname:
                case EventStatus.shortname:
                    eventStatus = new EventStatus(e);
                    break;
                case NoContributor.refname:
                case NoContributor.shortname:
                    noContributor = new NoContributor(e);
                    break;
                case EventIdentifier.refname:
                case EventIdentifier.shortname:
                    eventIdentifiers = JPU.addToList(eventIdentifiers, new EventIdentifier(e));
                    break;
                case Contributor.refname:
                case Contributor.shortname:
                    contributors = JPU.addToList(contributors, new Contributor(e));
                    break;
                case ContributorStatement.refname:
                case ContributorStatement.shortname:
                    contributorStatements = JPU.addToList(contributorStatements, new ContributorStatement(e));
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
     * @return whether this tag (&lt;PromotionalEvent&gt; or &lt;promotionalevent&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PromotionalEvent> action) {
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

    private ListOfOnixCodelist<EventType, EventTypes> eventTypes = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * A mandatory ONIX code which specifies the type of promotional event. Repeatable for promotional events which
     * combine different event types.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixCodelist<EventType, EventTypes> eventTypes() {
        _initialize();
        return eventTypes;
    }

    private ListOfOnixCodelist<ContentAudience, ContentAudiences> contentAudiences = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code which identifies the audience for which a promotional event is intended. Mandatory within in each
     * instance of the &lt;PromotionalEvent&gt; composite, and repeatable.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixCodelist<ContentAudience, ContentAudiences> contentAudiences() {
        _initialize();
        return contentAudiences;
    }

    private ListOfOnixElement<EventName, String> eventNames = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of or headline for a promotional event or series of events which relate to the product. This element is
     * mandatory within each instance of the &lt;PromotionalEvent&gt; composite, and repeatable to provide parallel
     * names for a single event in multiple languages. The <i>language</i> attribute is optional for a single instance
     * of &lt;EventName&gt;, but must be included in each instance if &lt;EventName&gt; is repeated.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixElement<EventName, String> eventNames() {
        _initialize();
        return eventNames;
    }

    private ListOfOnixComposite<ContributorReference> contributorReferences =
        JPU.emptyListOfOnixComposite(ContributorReference.class);

    /**
     * <p>
     * Optional composite that identifies a contributor – a person or corporate body – participating in the promotional
     * event <em>who is also a contributor to the product, or who is its subject</em> (<i>ie</i> who is fully described
     * in an instance of the &lt;Contributor&gt; composite within Groups&nbsp;P.5, P.7 or&nbsp;P.18, or in an instance
     * of &lt;NameAsSubject&gt; within Groups&nbsp;P.12 or&nbsp;P.18, in the same Product record). Repeatable to refer
     * to multiple contributors.
     * </p>
     * <p>
     * Note that an instance of &lt;PromotionalEvent&gt; may also contain one or more &lt;Contributor&gt; composites –
     * the latter listing participants to the event <em>who are not contributors to the product</em>.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixComposite<ContributorReference> contributorReferences() {
        _initialize();
        return contributorReferences;
    }

    private ListOfOnixComposite<EventOccurrence> eventOccurrences = JPU.emptyListOfOnixComposite(EventOccurrence.class);

    /**
     * <p>
     * A group of data elements which together describe a single occurrence of the promotional event. At least one
     * occurence is mandatory within the &lt;PromotionalEvent&gt; composite, and &lt;EventOccurrence&gt; is repeatable
     * in order to list a group of more or less similar occurrences such as a series of book signings.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixComposite<EventOccurrence> eventOccurrences() {
        _initialize();
        return eventOccurrences;
    }

    private EventStatus eventStatus = EventStatus.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the status of a promotional event. Optional within each instance of the
     * &lt;PromotionalEvent&gt; composite, and non-repeatable.
     * </p>
     * JONIX adds: this field is optional
     */
    public EventStatus eventStatus() {
        _initialize();
        return eventStatus;
    }

    private NoContributor noContributor = NoContributor.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication that a promotional event has no named participants. Optional
     * and non-repeating. Must only be sent in a &lt;PromotionalEvent&gt; composite that has neither
     * &lt;ContributorReference&gt; nor &lt;Contributor&gt; composites.
     * </p>
     * JONIX adds: this field is optional
     */
    public NoContributor noContributor() {
        _initialize();
        return noContributor;
    }

    public boolean isNoContributor() {
        return (noContributor().exists());
    }

    private ListOfOnixDataCompositeWithKey<EventIdentifier, JonixEventIdentifier,
        EventIdentifierTypes> eventIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(EventIdentifier.class);

    /**
     * <p>
     * An optional group of data elements which together define an identifier for an event. The composite is repeatable
     * in order to specify multiple identifiers for the same event.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<EventIdentifier, JonixEventIdentifier, EventIdentifierTypes>
        eventIdentifiers() {
        _initialize();
        return eventIdentifiers;
    }

    private ListOfOnixComposite<Contributor> contributors = JPU.emptyListOfOnixComposite(Contributor.class);

    /**
     * <p>
     * Optional composite that describes a contributor – a person or corporate body – participating in the promotional
     * event <em>who is neither a contributor to the product, nor its subject</em> (<i>ie</i> is <em>not</em> described
     * in an instance of the &lt;Contributor&gt; composite within Groups&nbsp;P.5, P.7 or&nbsp;P.18, or in an instance
     * of &lt;NameAsSubject&gt; within Groups&nbsp;P.12 or P.18, in the same Product record). Repeatable to identify
     * multiple contributors.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<Contributor> contributors() {
        _initialize();
        return contributors;
    }

    private ListOfOnixElement<ContributorStatement, String> contributorStatements = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text showing how the participants at a promotional event should be described in an online display, when a
     * standard concatenation of individual Contributor reference and Contributor elements would not give a satisfactory
     * presentation. Optional, and repeatable if parallel text is provided in multiple languages. The <i>language</i>
     * attribute is optional for a single instance of &lt;ContributorStatement&gt;, but must be included in each
     * instance if &lt;ContributorStatement&gt; is repeated. When the &lt;ContributorStatement&gt; field is sent, the
     * receiver should use it to replace all name detail (though not the biographical, date or place details) sent in
     * the &lt;Contributor&gt; composites <em>for display purposes only</em> for the promotional event. The individual
     * name detail must also be sent in the &lt;ContributorReference&gt; and &lt;Contributor&gt; composites for indexing
     * and retrieval.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<ContributorStatement, String> contributorStatements() {
        _initialize();
        return contributorStatements;
    }

    private ListOfOnixElement<EventDescription, String> eventDescriptions = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text describing the promotional event as a whole. Optional, and repeatable if parallel text is provided in
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
     * An optional group of data elements which together describe a supporting resource related to a promotional event.
     * The composite is repeatable to describe and link to multiple resources. Note that different forms of the same
     * resource (for example a cover image in separate low and high resolution versions) should be specified in a single
     * instance of the composite.
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
     * An optional group of data elements which together identify an organizer or sponsor of an event or series of event
     * occurrences. Either an &lt;EventSponsorIdentifier&gt;, or one or other of &lt;PersonName&gt; or
     * &lt;CorporateName&gt;, or both an identifier and a name, must be present in each occurrence of the composite. The
     * composite is repeatable in order to specify multiple organizers and sponsors.
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
     * the event in an instance of the &lt;PromotionalEvent&gt; composite. Repeatable to provide links to multiple
     * websites.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }
}
