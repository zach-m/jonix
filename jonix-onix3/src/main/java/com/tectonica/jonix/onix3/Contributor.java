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
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.PersonOrganizationDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixContributorDate;
import com.tectonica.jonix.struct.JonixContributorPlace;
import com.tectonica.jonix.struct.JonixNameIdentifier;
import com.tectonica.jonix.struct.JonixProfessionalAffiliation;
import com.tectonica.jonix.struct.JonixWebsite;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Contributor composite</h1><p>A group of data elements which together describe a personal or corporate contributor
 * to a content item. Optional and repeatable.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;Contributor&gt;</td></tr><tr><td>Short tag</td><td>&lt;contributor&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class Contributor implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Contributor";
    public static final String shortname = "contributor";

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
    public static final Contributor EMPTY = new Contributor();

    public Contributor() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Contributor(org.w3c.dom.Element element) {
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
            if (name.equals(SequenceNumber.refname) || name.equals(SequenceNumber.shortname)) {
                sequenceNumber = new SequenceNumber(e);
            } else if (name.equals(ContributorRole.refname) || name.equals(ContributorRole.shortname)) {
                contributorRoles = JPU.addToList(contributorRoles, new ContributorRole(e));
            } else if (name.equals(FromLanguage.refname) || name.equals(FromLanguage.shortname)) {
                fromLanguages = JPU.addToList(fromLanguages, new FromLanguage(e));
            } else if (name.equals(ToLanguage.refname) || name.equals(ToLanguage.shortname)) {
                toLanguages = JPU.addToList(toLanguages, new ToLanguage(e));
            } else if (name.equals(NameType.refname) || name.equals(NameType.shortname)) {
                nameType = new NameType(e);
            } else if (name.equals(NameIdentifier.refname) || name.equals(NameIdentifier.shortname)) {
                nameIdentifiers = JPU.addToList(nameIdentifiers, new NameIdentifier(e));
            } else if (name.equals(PersonName.refname) || name.equals(PersonName.shortname)) {
                personName = new PersonName(e);
            } else if (name.equals(PersonNameInverted.refname) || name.equals(PersonNameInverted.shortname)) {
                personNameInverted = new PersonNameInverted(e);
            } else if (name.equals(TitlesBeforeNames.refname) || name.equals(TitlesBeforeNames.shortname)) {
                titlesBeforeNames = new TitlesBeforeNames(e);
            } else if (name.equals(NamesBeforeKey.refname) || name.equals(NamesBeforeKey.shortname)) {
                namesBeforeKey = new NamesBeforeKey(e);
            } else if (name.equals(PrefixToKey.refname) || name.equals(PrefixToKey.shortname)) {
                prefixToKey = new PrefixToKey(e);
            } else if (name.equals(KeyNames.refname) || name.equals(KeyNames.shortname)) {
                keyNames = new KeyNames(e);
            } else if (name.equals(NamesAfterKey.refname) || name.equals(NamesAfterKey.shortname)) {
                namesAfterKey = new NamesAfterKey(e);
            } else if (name.equals(SuffixToKey.refname) || name.equals(SuffixToKey.shortname)) {
                suffixToKey = new SuffixToKey(e);
            } else if (name.equals(LettersAfterNames.refname) || name.equals(LettersAfterNames.shortname)) {
                lettersAfterNames = new LettersAfterNames(e);
            } else if (name.equals(TitlesAfterNames.refname) || name.equals(TitlesAfterNames.shortname)) {
                titlesAfterNames = new TitlesAfterNames(e);
            } else if (name.equals(CorporateName.refname) || name.equals(CorporateName.shortname)) {
                corporateName = new CorporateName(e);
            } else if (name.equals(CorporateNameInverted.refname) || name.equals(CorporateNameInverted.shortname)) {
                corporateNameInverted = new CorporateNameInverted(e);
            } else if (name.equals(AlternativeName.refname) || name.equals(AlternativeName.shortname)) {
                alternativeNames = JPU.addToList(alternativeNames, new AlternativeName(e));
            } else if (name.equals(ContributorDate.refname) || name.equals(ContributorDate.shortname)) {
                contributorDates = JPU.addToList(contributorDates, new ContributorDate(e));
            } else if (name.equals(ProfessionalAffiliation.refname) || name.equals(ProfessionalAffiliation.shortname)) {
                professionalAffiliations = JPU.addToList(professionalAffiliations, new ProfessionalAffiliation(e));
            } else if (name.equals(BiographicalNote.refname) || name.equals(BiographicalNote.shortname)) {
                biographicalNotes = JPU.addToList(biographicalNotes, new BiographicalNote(e));
            } else if (name.equals(Website.refname) || name.equals(Website.shortname)) {
                websites = JPU.addToList(websites, new Website(e));
            } else if (name.equals(ContributorDescription.refname) || name.equals(ContributorDescription.shortname)) {
                contributorDescriptions = JPU.addToList(contributorDescriptions, new ContributorDescription(e));
            } else if (name.equals(UnnamedPersons.refname) || name.equals(UnnamedPersons.shortname)) {
                unnamedPersons = new UnnamedPersons(e);
            } else if (name.equals(ContributorPlace.refname) || name.equals(ContributorPlace.shortname)) {
                contributorPlaces = JPU.addToList(contributorPlaces, new ContributorPlace(e));
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

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public SequenceNumber sequenceNumber() {
        initialize();
        return sequenceNumber;
    }

    private ListOfOnixElement<ContributorRole, ContributorRoles> contributorRoles = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<ContributorRole, ContributorRoles> contributorRoles() {
        initialize();
        return contributorRoles;
    }

    private ListOfOnixElement<FromLanguage, LanguageCodes> fromLanguages = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<FromLanguage, LanguageCodes> fromLanguages() {
        initialize();
        return fromLanguages;
    }

    private ListOfOnixElement<ToLanguage, LanguageCodes> toLanguages = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ToLanguage, LanguageCodes> toLanguages() {
        initialize();
        return toLanguages;
    }

    private NameType nameType = NameType.EMPTY;

    /**
     * (this field is optional)
     */
    public NameType nameType() {
        initialize();
        return nameType;
    }

    private ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameCodeTypes> nameIdentifiers =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameCodeTypes> nameIdentifiers() {
        initialize();
        return nameIdentifiers;
    }

    private PersonName personName = PersonName.EMPTY;

    /**
     * (this field is required)
     */
    public PersonName personName() {
        initialize();
        return personName;
    }

    private PersonNameInverted personNameInverted = PersonNameInverted.EMPTY;

    /**
     * (this field is optional)
     */
    public PersonNameInverted personNameInverted() {
        initialize();
        return personNameInverted;
    }

    private TitlesBeforeNames titlesBeforeNames = TitlesBeforeNames.EMPTY;

    /**
     * (this field is optional)
     */
    public TitlesBeforeNames titlesBeforeNames() {
        initialize();
        return titlesBeforeNames;
    }

    private NamesBeforeKey namesBeforeKey = NamesBeforeKey.EMPTY;

    /**
     * (this field is optional)
     */
    public NamesBeforeKey namesBeforeKey() {
        initialize();
        return namesBeforeKey;
    }

    private PrefixToKey prefixToKey = PrefixToKey.EMPTY;

    /**
     * (this field is optional)
     */
    public PrefixToKey prefixToKey() {
        initialize();
        return prefixToKey;
    }

    private KeyNames keyNames = KeyNames.EMPTY;

    /**
     * (this field is required)
     */
    public KeyNames keyNames() {
        initialize();
        return keyNames;
    }

    private NamesAfterKey namesAfterKey = NamesAfterKey.EMPTY;

    /**
     * (this field is optional)
     */
    public NamesAfterKey namesAfterKey() {
        initialize();
        return namesAfterKey;
    }

    private SuffixToKey suffixToKey = SuffixToKey.EMPTY;

    /**
     * (this field is optional)
     */
    public SuffixToKey suffixToKey() {
        initialize();
        return suffixToKey;
    }

    private LettersAfterNames lettersAfterNames = LettersAfterNames.EMPTY;

    /**
     * (this field is optional)
     */
    public LettersAfterNames lettersAfterNames() {
        initialize();
        return lettersAfterNames;
    }

    private TitlesAfterNames titlesAfterNames = TitlesAfterNames.EMPTY;

    /**
     * (this field is optional)
     */
    public TitlesAfterNames titlesAfterNames() {
        initialize();
        return titlesAfterNames;
    }

    private CorporateName corporateName = CorporateName.EMPTY;

    /**
     * (this field is required)
     */
    public CorporateName corporateName() {
        initialize();
        return corporateName;
    }

    private CorporateNameInverted corporateNameInverted = CorporateNameInverted.EMPTY;

    /**
     * (this field is optional)
     */
    public CorporateNameInverted corporateNameInverted() {
        initialize();
        return corporateNameInverted;
    }

    private List<AlternativeName> alternativeNames = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<AlternativeName> alternativeNames() {
        initialize();
        return alternativeNames;
    }

    private ListOfOnixDataCompositeWithKey<ContributorDate, JonixContributorDate, PersonOrganizationDateRoles>
        contributorDates = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ContributorDate, JonixContributorDate, PersonOrganizationDateRoles> contributorDates() {
        initialize();
        return contributorDates;
    }

    private ListOfOnixDataComposite<ProfessionalAffiliation, JonixProfessionalAffiliation> professionalAffiliations =
        ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<ProfessionalAffiliation, JonixProfessionalAffiliation> professionalAffiliations() {
        initialize();
        return professionalAffiliations;
    }

    private ListOfOnixElement<BiographicalNote, String> biographicalNotes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<BiographicalNote, String> biographicalNotes() {
        initialize();
        return biographicalNotes;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        initialize();
        return websites;
    }

    private ListOfOnixElement<ContributorDescription, String> contributorDescriptions = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ContributorDescription, String> contributorDescriptions() {
        initialize();
        return contributorDescriptions;
    }

    private UnnamedPersons unnamedPersons = UnnamedPersons.EMPTY;

    /**
     * (this field is required)
     */
    public UnnamedPersons unnamedPersons() {
        initialize();
        return unnamedPersons;
    }

    private ListOfOnixDataComposite<ContributorPlace, JonixContributorPlace> contributorPlaces =
        ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<ContributorPlace, JonixContributorPlace> contributorPlaces() {
        initialize();
        return contributorPlaces;
    }
}
