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
                case SequenceNumber.refname:
                case SequenceNumber.shortname:
                    sequenceNumber = new SequenceNumber(e);
                    break;
                case ContributorRole.refname:
                case ContributorRole.shortname:
                    contributorRoles = JPU.addToList(contributorRoles, new ContributorRole(e));
                    break;
                case FromLanguage.refname:
                case FromLanguage.shortname:
                    fromLanguages = JPU.addToList(fromLanguages, new FromLanguage(e));
                    break;
                case ToLanguage.refname:
                case ToLanguage.shortname:
                    toLanguages = JPU.addToList(toLanguages, new ToLanguage(e));
                    break;
                case NameType.refname:
                case NameType.shortname:
                    nameType = new NameType(e);
                    break;
                case NameIdentifier.refname:
                case NameIdentifier.shortname:
                    nameIdentifiers = JPU.addToList(nameIdentifiers, new NameIdentifier(e));
                    break;
                case PersonName.refname:
                case PersonName.shortname:
                    personName = new PersonName(e);
                    break;
                case PersonNameInverted.refname:
                case PersonNameInverted.shortname:
                    personNameInverted = new PersonNameInverted(e);
                    break;
                case TitlesBeforeNames.refname:
                case TitlesBeforeNames.shortname:
                    titlesBeforeNames = new TitlesBeforeNames(e);
                    break;
                case NamesBeforeKey.refname:
                case NamesBeforeKey.shortname:
                    namesBeforeKey = new NamesBeforeKey(e);
                    break;
                case PrefixToKey.refname:
                case PrefixToKey.shortname:
                    prefixToKey = new PrefixToKey(e);
                    break;
                case KeyNames.refname:
                case KeyNames.shortname:
                    keyNames = new KeyNames(e);
                    break;
                case NamesAfterKey.refname:
                case NamesAfterKey.shortname:
                    namesAfterKey = new NamesAfterKey(e);
                    break;
                case SuffixToKey.refname:
                case SuffixToKey.shortname:
                    suffixToKey = new SuffixToKey(e);
                    break;
                case LettersAfterNames.refname:
                case LettersAfterNames.shortname:
                    lettersAfterNames = new LettersAfterNames(e);
                    break;
                case TitlesAfterNames.refname:
                case TitlesAfterNames.shortname:
                    titlesAfterNames = new TitlesAfterNames(e);
                    break;
                case CorporateName.refname:
                case CorporateName.shortname:
                    corporateName = new CorporateName(e);
                    break;
                case CorporateNameInverted.refname:
                case CorporateNameInverted.shortname:
                    corporateNameInverted = new CorporateNameInverted(e);
                    break;
                case AlternativeName.refname:
                case AlternativeName.shortname:
                    alternativeNames = JPU.addToList(alternativeNames, new AlternativeName(e));
                    break;
                case ContributorDate.refname:
                case ContributorDate.shortname:
                    contributorDates = JPU.addToList(contributorDates, new ContributorDate(e));
                    break;
                case ProfessionalAffiliation.refname:
                case ProfessionalAffiliation.shortname:
                    professionalAffiliations = JPU.addToList(professionalAffiliations, new ProfessionalAffiliation(e));
                    break;
                case BiographicalNote.refname:
                case BiographicalNote.shortname:
                    biographicalNotes = JPU.addToList(biographicalNotes, new BiographicalNote(e));
                    break;
                case Website.refname:
                case Website.shortname:
                    websites = JPU.addToList(websites, new Website(e));
                    break;
                case ContributorDescription.refname:
                case ContributorDescription.shortname:
                    contributorDescriptions = JPU.addToList(contributorDescriptions, new ContributorDescription(e));
                    break;
                case UnnamedPersons.refname:
                case UnnamedPersons.shortname:
                    unnamedPersons = new UnnamedPersons(e);
                    break;
                case ContributorPlace.refname:
                case ContributorPlace.shortname:
                    contributorPlaces = JPU.addToList(contributorPlaces, new ContributorPlace(e));
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

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public SequenceNumber sequenceNumber() {
        _initialize();
        return sequenceNumber;
    }

    private ListOfOnixElement<ContributorRole, ContributorRoles> contributorRoles = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<ContributorRole, ContributorRoles> contributorRoles() {
        _initialize();
        return contributorRoles;
    }

    private ListOfOnixElement<FromLanguage, LanguageCodes> fromLanguages = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<FromLanguage, LanguageCodes> fromLanguages() {
        _initialize();
        return fromLanguages;
    }

    private ListOfOnixElement<ToLanguage, LanguageCodes> toLanguages = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ToLanguage, LanguageCodes> toLanguages() {
        _initialize();
        return toLanguages;
    }

    private NameType nameType = NameType.EMPTY;

    /**
     * (this field is optional)
     */
    public NameType nameType() {
        _initialize();
        return nameType;
    }

    private ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameCodeTypes> nameIdentifiers =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameCodeTypes> nameIdentifiers() {
        _initialize();
        return nameIdentifiers;
    }

    private PersonName personName = PersonName.EMPTY;

    /**
     * (this field is required)
     */
    public PersonName personName() {
        _initialize();
        return personName;
    }

    private PersonNameInverted personNameInverted = PersonNameInverted.EMPTY;

    /**
     * (this field is optional)
     */
    public PersonNameInverted personNameInverted() {
        _initialize();
        return personNameInverted;
    }

    private TitlesBeforeNames titlesBeforeNames = TitlesBeforeNames.EMPTY;

    /**
     * (this field is optional)
     */
    public TitlesBeforeNames titlesBeforeNames() {
        _initialize();
        return titlesBeforeNames;
    }

    private NamesBeforeKey namesBeforeKey = NamesBeforeKey.EMPTY;

    /**
     * (this field is optional)
     */
    public NamesBeforeKey namesBeforeKey() {
        _initialize();
        return namesBeforeKey;
    }

    private PrefixToKey prefixToKey = PrefixToKey.EMPTY;

    /**
     * (this field is optional)
     */
    public PrefixToKey prefixToKey() {
        _initialize();
        return prefixToKey;
    }

    private KeyNames keyNames = KeyNames.EMPTY;

    /**
     * (this field is required)
     */
    public KeyNames keyNames() {
        _initialize();
        return keyNames;
    }

    private NamesAfterKey namesAfterKey = NamesAfterKey.EMPTY;

    /**
     * (this field is optional)
     */
    public NamesAfterKey namesAfterKey() {
        _initialize();
        return namesAfterKey;
    }

    private SuffixToKey suffixToKey = SuffixToKey.EMPTY;

    /**
     * (this field is optional)
     */
    public SuffixToKey suffixToKey() {
        _initialize();
        return suffixToKey;
    }

    private LettersAfterNames lettersAfterNames = LettersAfterNames.EMPTY;

    /**
     * (this field is optional)
     */
    public LettersAfterNames lettersAfterNames() {
        _initialize();
        return lettersAfterNames;
    }

    private TitlesAfterNames titlesAfterNames = TitlesAfterNames.EMPTY;

    /**
     * (this field is optional)
     */
    public TitlesAfterNames titlesAfterNames() {
        _initialize();
        return titlesAfterNames;
    }

    private CorporateName corporateName = CorporateName.EMPTY;

    /**
     * (this field is required)
     */
    public CorporateName corporateName() {
        _initialize();
        return corporateName;
    }

    private CorporateNameInverted corporateNameInverted = CorporateNameInverted.EMPTY;

    /**
     * (this field is optional)
     */
    public CorporateNameInverted corporateNameInverted() {
        _initialize();
        return corporateNameInverted;
    }

    private List<AlternativeName> alternativeNames = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<AlternativeName> alternativeNames() {
        _initialize();
        return alternativeNames;
    }

    private ListOfOnixDataCompositeWithKey<ContributorDate, JonixContributorDate, PersonOrganizationDateRoles>
        contributorDates = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ContributorDate, JonixContributorDate, PersonOrganizationDateRoles> contributorDates() {
        _initialize();
        return contributorDates;
    }

    private ListOfOnixDataComposite<ProfessionalAffiliation, JonixProfessionalAffiliation> professionalAffiliations =
        ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<ProfessionalAffiliation, JonixProfessionalAffiliation> professionalAffiliations() {
        _initialize();
        return professionalAffiliations;
    }

    private ListOfOnixElement<BiographicalNote, String> biographicalNotes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<BiographicalNote, String> biographicalNotes() {
        _initialize();
        return biographicalNotes;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }

    private ListOfOnixElement<ContributorDescription, String> contributorDescriptions = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ContributorDescription, String> contributorDescriptions() {
        _initialize();
        return contributorDescriptions;
    }

    private UnnamedPersons unnamedPersons = UnnamedPersons.EMPTY;

    /**
     * (this field is required)
     */
    public UnnamedPersons unnamedPersons() {
        _initialize();
        return unnamedPersons;
    }

    private ListOfOnixDataComposite<ContributorPlace, JonixContributorPlace> contributorPlaces =
        ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<ContributorPlace, JonixContributorPlace> contributorPlaces() {
        _initialize();
        return contributorPlaces;
    }
}
