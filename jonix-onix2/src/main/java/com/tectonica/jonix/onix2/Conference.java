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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixComposite;
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixWebsite;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Conference composite</h1>
 * <p>
 * A group of data elements which together describe a conference to which the product is related. Repeatable if the
 * product contains material from two or more conferences.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Conference&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;conference&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link Conference}</li>
 * </ul>
 *
 * @since Onix-2.1
 */
public class Conference implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Conference";
    public static final String shortname = "conference";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

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
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
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
                case ConferenceName.refname:
                case ConferenceName.shortname:
                    conferenceName = new ConferenceName(e);
                    break;
                case ConferenceRole.refname:
                case ConferenceRole.shortname:
                    conferenceRole = new ConferenceRole(e);
                    break;
                case ConferenceAcronym.refname:
                case ConferenceAcronym.shortname:
                    conferenceAcronym = new ConferenceAcronym(e);
                    break;
                case ConferenceNumber.refname:
                case ConferenceNumber.shortname:
                    conferenceNumber = new ConferenceNumber(e);
                    break;
                case ConferenceTheme.refname:
                case ConferenceTheme.shortname:
                    conferenceTheme = new ConferenceTheme(e);
                    break;
                case ConferenceDate.refname:
                case ConferenceDate.shortname:
                    conferenceDate = new ConferenceDate(e);
                    break;
                case ConferencePlace.refname:
                case ConferencePlace.shortname:
                    conferencePlace = new ConferencePlace(e);
                    break;
                case ConferenceSponsor.refname:
                case ConferenceSponsor.shortname:
                    conferenceSponsors = JPU.addToList(conferenceSponsors, new ConferenceSponsor(e));
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
     * @return whether this tag (&lt;Conference&gt; or &lt;conference&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Conference> action) {
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

    private ConferenceName conferenceName = ConferenceName.EMPTY;

    /**
     * <p>
     * The name of a conference or conference series to which the product is related. This element is mandatory in each
     * occurrence of the &lt;Conference&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public ConferenceName conferenceName() {
        _initialize();
        return conferenceName;
    }

    private ConferenceRole conferenceRole = ConferenceRole.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the relationship between the product and a conference to which it is related,
     * <em>eg</em> Proceedings of / Selected papers from / Developed from. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ConferenceRole conferenceRole() {
        _initialize();
        return conferenceRole;
    }

    private ConferenceAcronym conferenceAcronym = ConferenceAcronym.EMPTY;

    /**
     * <p>
     * An acronym used as a short form of the name of a conference or conference series given in the
     * &lt;ConferenceName&gt; element. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ConferenceAcronym conferenceAcronym() {
        _initialize();
        return conferenceAcronym;
    }

    private ConferenceNumber conferenceNumber = ConferenceNumber.EMPTY;

    /**
     * <p>
     * The number of a conference to which the product is related, within a conference series. Optional and
     * non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ConferenceNumber conferenceNumber() {
        _initialize();
        return conferenceNumber;
    }

    private ConferenceTheme conferenceTheme = ConferenceTheme.EMPTY;

    /**
     * <p>
     * The thematic title of an individual conference in a series that has a series name in the &lt;ConferenceName&gt;
     * element. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ConferenceTheme conferenceTheme() {
        _initialize();
        return conferenceTheme;
    }

    private ConferenceDate conferenceDate = ConferenceDate.EMPTY;

    /**
     * <p>
     * The date of a conference to which the product is related. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ConferenceDate conferenceDate() {
        _initialize();
        return conferenceDate;
    }

    private ConferencePlace conferencePlace = ConferencePlace.EMPTY;

    /**
     * <p>
     * The place of a conference to which the product is related. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ConferencePlace conferencePlace() {
        _initialize();
        return conferencePlace;
    }

    private ListOfOnixComposite<ConferenceSponsor> conferenceSponsors =
        JPU.emptyListOfOnixComposite(ConferenceSponsor.class);

    /**
     * <p>
     * A repeatable group of data elements which together identify a sponsor of a conference.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<ConferenceSponsor> conferenceSponsors() {
        _initialize();
        return conferenceSponsors;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = JPU.emptyListOfOnixDataComposite(Website.class);

    /**
     * <p>
     * A repeatable group of data elements which together identify and provide pointers to a website which is related to
     * the conference identified in an occurrence of the &lt;Conference&gt; composite.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }
}
