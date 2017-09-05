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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.CountryCodes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.PersonDateRoles;
import com.tectonica.jonix.codelist.PersonNameIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixPersonDate;
import com.tectonica.jonix.struct.JonixPersonNameIdentifier;
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
 * to a content item. Optional and repeatable. <strong>Please see Group&nbsp;PR.8 for details.</strong></p><table
 * border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;Contributor&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;contributor&gt;</td></tr></table>
 */
public class Contributor implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Contributor";
    public static final String shortname = "contributor";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public LanguageCodes language;

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
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
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
                case SequenceNumber.refname:
                case SequenceNumber.shortname:
                    sequenceNumber = new SequenceNumber(e);
                    break;
                case ContributorRole.refname:
                case ContributorRole.shortname:
                    contributorRoles = JPU.addToList(contributorRoles, new ContributorRole(e));
                    break;
                case LanguageCode.refname:
                case LanguageCode.shortname:
                    languageCodes = JPU.addToList(languageCodes, new LanguageCode(e));
                    break;
                case SequenceNumberWithinRole.refname:
                case SequenceNumberWithinRole.shortname:
                    sequenceNumberWithinRole = new SequenceNumberWithinRole(e);
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
                case Name.refname:
                case Name.shortname:
                    names = JPU.addToList(names, new Name(e));
                    break;
                case PersonNameIdentifier.refname:
                case PersonNameIdentifier.shortname:
                    personNameIdentifiers = JPU.addToList(personNameIdentifiers, new PersonNameIdentifier(e));
                    break;
                case PersonDate.refname:
                case PersonDate.shortname:
                    personDates = JPU.addToList(personDates, new PersonDate(e));
                    break;
                case ProfessionalAffiliation.refname:
                case ProfessionalAffiliation.shortname:
                    professionalAffiliations = JPU.addToList(professionalAffiliations, new ProfessionalAffiliation(e));
                    break;
                case CorporateName.refname:
                case CorporateName.shortname:
                    corporateName = new CorporateName(e);
                    break;
                case BiographicalNote.refname:
                case BiographicalNote.shortname:
                    biographicalNote = new BiographicalNote(e);
                    break;
                case Website.refname:
                case Website.shortname:
                    websites = JPU.addToList(websites, new Website(e));
                    break;
                case ProfessionalPosition.refname:
                case ProfessionalPosition.shortname:
                    professionalPosition = new ProfessionalPosition(e);
                    break;
                case Affiliation.refname:
                case Affiliation.shortname:
                    affiliation = new Affiliation(e);
                    break;
                case ContributorDescription.refname:
                case ContributorDescription.shortname:
                    contributorDescription = new ContributorDescription(e);
                    break;
                case UnnamedPersons.refname:
                case UnnamedPersons.shortname:
                    unnamedPersons = new UnnamedPersons(e);
                    break;
                case CountryCode.refname:
                case CountryCode.shortname:
                    countryCodes = JPU.addToList(countryCodes, new CountryCode(e));
                    break;
                case RegionCode.refname:
                case RegionCode.shortname:
                    regionCodes = JPU.addToList(regionCodes, new RegionCode(e));
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

    private ListOfOnixElement<LanguageCode, LanguageCodes> languageCodes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<LanguageCode, LanguageCodes> languageCodes() {
        _initialize();
        return languageCodes;
    }

    private SequenceNumberWithinRole sequenceNumberWithinRole = SequenceNumberWithinRole.EMPTY;

    /**
     * (this field is optional)
     */
    public SequenceNumberWithinRole sequenceNumberWithinRole() {
        _initialize();
        return sequenceNumberWithinRole;
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
     * (this field is optional)
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

    private List<Name> names = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Name> names() {
        _initialize();
        return names;
    }

    private ListOfOnixDataCompositeWithKey<PersonNameIdentifier, JonixPersonNameIdentifier, PersonNameIdentifierTypes>
        personNameIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<PersonNameIdentifier, JonixPersonNameIdentifier, PersonNameIdentifierTypes> personNameIdentifiers() {
        _initialize();
        return personNameIdentifiers;
    }

    private ListOfOnixDataCompositeWithKey<PersonDate, JonixPersonDate, PersonDateRoles> personDates =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<PersonDate, JonixPersonDate, PersonDateRoles> personDates() {
        _initialize();
        return personDates;
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

    private CorporateName corporateName = CorporateName.EMPTY;

    /**
     * (this field is optional)
     */
    public CorporateName corporateName() {
        _initialize();
        return corporateName;
    }

    private BiographicalNote biographicalNote = BiographicalNote.EMPTY;

    /**
     * (this field is optional)
     */
    public BiographicalNote biographicalNote() {
        _initialize();
        return biographicalNote;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }

    private ProfessionalPosition professionalPosition = ProfessionalPosition.EMPTY;

    /**
     * (this field is optional)
     */
    public ProfessionalPosition professionalPosition() {
        _initialize();
        return professionalPosition;
    }

    private Affiliation affiliation = Affiliation.EMPTY;

    /**
     * (this field is optional)
     */
    public Affiliation affiliation() {
        _initialize();
        return affiliation;
    }

    private ContributorDescription contributorDescription = ContributorDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public ContributorDescription contributorDescription() {
        _initialize();
        return contributorDescription;
    }

    private UnnamedPersons unnamedPersons = UnnamedPersons.EMPTY;

    /**
     * (this field is optional)
     */
    public UnnamedPersons unnamedPersons() {
        _initialize();
        return unnamedPersons;
    }

    private ListOfOnixElement<CountryCode, CountryCodes> countryCodes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<CountryCode, CountryCodes> countryCodes() {
        _initialize();
        return countryCodes;
    }

    private ListOfOnixElement<RegionCode, java.util.Set<String>> regionCodes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<RegionCode, java.util.Set<String>> regionCodes() {
        _initialize();
        return regionCodes;
    }
}
