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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.ContributorRoles;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.PersonOrganizationDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixContributorDate;
import com.tectonica.jonix.common.struct.JonixContributorPlace;
import com.tectonica.jonix.common.struct.JonixNameIdentifier;
import com.tectonica.jonix.common.struct.JonixPrize;
import com.tectonica.jonix.common.struct.JonixProfessionalAffiliation;
import com.tectonica.jonix.common.struct.JonixWebsite;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Contributor composite</h1>
 * <p>
 * A group of data elements which together describe a personal or corporate contributor to a collection. Optional, and
 * repeatable to describe multiple contributors. <strong>The &lt;Contributor&gt; composite is included here for use only
 * by those ONIX communities whose national practice requires contributors to be identified at collection level. In many
 * countries, including the UK, USA, Canada and Spain, the required practice is to identify all contributors at product
 * level in Group&nbsp;P.7.</strong>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Contributor&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;contributor&gt;</tt></td>
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
 * <li>&lt;{@link ContentItem}&gt;</li>
 * <li>&lt;{@link Collection}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor}</li>
 * </ul>
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
                case Gender.refname:
                case Gender.shortname:
                    gender = new Gender(e);
                    break;
                case CorporateName.refname:
                case CorporateName.shortname:
                    corporateName = new CorporateName(e);
                    break;
                case CorporateNameInverted.refname:
                case CorporateNameInverted.shortname:
                    corporateNameInverted = new CorporateNameInverted(e);
                    break;
                case UnnamedPersons.refname:
                case UnnamedPersons.shortname:
                    unnamedPersons = new UnnamedPersons(e);
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
                case Prize.refname:
                case Prize.shortname:
                    prizes = JPU.addToList(prizes, new Prize(e));
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
                case ContributorPlace.refname:
                case ContributorPlace.shortname:
                    contributorPlaces = JPU.addToList(contributorPlaces, new ContributorPlace(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Contributor&gt; or &lt;contributor&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * <p>
     * A number which specifies a single overall sequence of contributor names. Optional and non-repeating. It is
     * strongly recommended that each occurrence of the &lt;Contributor&gt; composite should carry a
     * &lt;SequenceNumber&gt;.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SequenceNumber sequenceNumber() {
        _initialize();
        return sequenceNumber;
    }

    private ListOfOnixElement<ContributorRole, ContributorRoles> contributorRoles = ListOfOnixElement.empty();

    /**
     * <p>
     * An ONIX code indicating the role played by a person or corporate body in the creation of the product. Mandatory
     * in each occurrence of a &lt;Contributor&gt; composite, and may be repeated if the same person or corporate body
     * has more than one role in relation to the product.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<ContributorRole, ContributorRoles> contributorRoles() {
        _initialize();
        return contributorRoles;
    }

    private ListOfOnixElement<FromLanguage, Languages> fromLanguages = ListOfOnixElement.empty();

    /**
     * <p>
     * Used only when the &lt;ContributorRole&gt; code value is B06, B08 or B10 indicating a translator, to specify the
     * source language from which the translation was made. This element makes it possible to specify a translator’s
     * exact responsibility when a work involves translation from two or more languages. Optional, and repeatable in the
     * event that a single person has been responsible for translation from two or more languages.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<FromLanguage, Languages> fromLanguages() {
        _initialize();
        return fromLanguages;
    }

    private ListOfOnixElement<ToLanguage, Languages> toLanguages = ListOfOnixElement.empty();

    /**
     * <p>
     * Used only when the &lt;ContributorRole&gt; code value is B06, B08 or B10 indicating a translator, to specify the
     * target language into which the translation was made. This element makes it possible to specify a translator’s
     * exact responsibility when a work involves translation into two or more languages. Optional, and repeatable in the
     * event that a single person has been responsible for translation to two or more languages.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ToLanguage, Languages> toLanguages() {
        _initialize();
        return toLanguages;
    }

    private NameType nameType = NameType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the type of a primary name. Optional, and non-repeating. If omitted, the default is
     * ‘unspecified’.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NameType nameType() {
        _initialize();
        return nameType;
    }

    private ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameIdentifierTypes> nameIdentifiers =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * A group of data elements which together specify a name identifier, used here to carry an identifier for a person
     * or organization name given in an occurrence of the &lt;Contributor&gt; composite. Optional: see Group&nbsp;P.7
     * introductory text for valid options. Repeatable to specify name identifiers of different types for the same
     * person or organization name.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameIdentifierTypes> nameIdentifiers() {
        _initialize();
        return nameIdentifiers;
    }

    private PersonName personName = PersonName.EMPTY;

    /**
     * <p>
     * The name of a person who contributed to the creation of the product, unstructured, and presented in normal order.
     * Optional and non-repeating: see Group&nbsp;P.7 introductory text for valid options.
     * </p>
     * Jonix-Comment: this field is required
     */
    public PersonName personName() {
        _initialize();
        return personName;
    }

    private PersonNameInverted personNameInverted = PersonNameInverted.EMPTY;

    /**
     * <p>
     * The name of a person who contributed to the creation of the product, presented with the element used for
     * alphabetical sorting placed first (‘inverted order’). Optional and non-repeating: see Group&nbsp;P.7 introductory
     * text for valid options.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PersonNameInverted personNameInverted() {
        _initialize();
        return personNameInverted;
    }

    private TitlesBeforeNames titlesBeforeNames = TitlesBeforeNames.EMPTY;

    /**
     * <p>
     * The first part of a structured name of a person who contributed to the creation of the product: qualifications
     * and/or titles preceding a person’s names, <i>eg</i> ‘Professor’ or ‘HRH Prince’ or ‘Saint’. Optional and
     * non-repeating: see Group&nbsp;P.7 introductory text for valid options.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TitlesBeforeNames titlesBeforeNames() {
        _initialize();
        return titlesBeforeNames;
    }

    private NamesBeforeKey namesBeforeKey = NamesBeforeKey.EMPTY;

    /**
     * <p>
     * The second part of a structured name of a person who contributed to the creation of the product: name(s) and/or
     * initial(s) preceding a person’s key name(s), <i>eg</i> James J. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NamesBeforeKey namesBeforeKey() {
        _initialize();
        return namesBeforeKey;
    }

    private PrefixToKey prefixToKey = PrefixToKey.EMPTY;

    /**
     * <p>
     * The third part of a structured name of a person who contributed to the creation of the product: a prefix which
     * precedes the key name(s) but which is not to be treated as part of the key name, <i>eg</i> ‘van’ in Ludwig van
     * Beethoven. This element may also be used for titles that appear after given names and before key names, <i>eg</i>
     * ‘Lord’ in Alfred, Lord Tennyson. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PrefixToKey prefixToKey() {
        _initialize();
        return prefixToKey;
    }

    private KeyNames keyNames = KeyNames.EMPTY;

    /**
     * <p>
     * The fourth part of a structured name of a person who contributed to the creation of the product: key name(s),
     * <i>ie</i> the name elements normally used to open an entry in an alphabetical list, <i>eg</i> ‘Smith’ or ‘Garcia
     * Marquez’ or ‘Madonna’ or ‘Francis de Sales’ (in Saint Francis de Sales). Non-repeating. Required if name part
     * elements P.7.11 to P.7.18 are used.
     * </p>
     * Jonix-Comment: this field is required
     */
    public KeyNames keyNames() {
        _initialize();
        return keyNames;
    }

    private NamesAfterKey namesAfterKey = NamesAfterKey.EMPTY;

    /**
     * <p>
     * The fifth part of a structured name of a person who contributed to the creation of the product: name suffix, or
     * name(s) following a person’s key name(s), <i>eg</i> ‘Ibrahim’ (in Anwar Ibrahim). Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NamesAfterKey namesAfterKey() {
        _initialize();
        return namesAfterKey;
    }

    private SuffixToKey suffixToKey = SuffixToKey.EMPTY;

    /**
     * <p>
     * The sixth part of a structured name of a person who contributed to the creation of the product: a suffix
     * following a person’s key name(s), <i>eg</i> ‘Jr’ or ‘III’. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SuffixToKey suffixToKey() {
        _initialize();
        return suffixToKey;
    }

    private LettersAfterNames lettersAfterNames = LettersAfterNames.EMPTY;

    /**
     * <p>
     * The seventh part of a structured name of a person who contributed to the creation of the product: qualifications
     * and honors following a person’s names, <i>eg</i> ‘CBE FRS’. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public LettersAfterNames lettersAfterNames() {
        _initialize();
        return lettersAfterNames;
    }

    private TitlesAfterNames titlesAfterNames = TitlesAfterNames.EMPTY;

    /**
     * <p>
     * The eighth part of a structured name of a person who contributed to the creation of the product: titles following
     * a person’s names, <i>eg</i> ‘Duke of Edinburgh’. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TitlesAfterNames titlesAfterNames() {
        _initialize();
        return titlesAfterNames;
    }

    private Gender gender = Gender.EMPTY;

    /**
     * <p>
     * An optional ONIX code specifying the gender of a personal contributor. Not repeatable. Note that this indicates
     * the gender of the contributor’s public identity (which may be pseudonymous) based on designations used in ISO
     * 5218, rather than the gender identity, biological sex or sexuality of a natural person.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Gender gender() {
        _initialize();
        return gender;
    }

    private CorporateName corporateName = CorporateName.EMPTY;

    /**
     * <p>
     * The name of a corporate body which contributed to the creation of the product, unstructured. Optional and
     * non-repeating: see Group&nbsp;P.7 introductory text for valid options.
     * </p>
     * Jonix-Comment: this field is required
     */
    public CorporateName corporateName() {
        _initialize();
        return corporateName;
    }

    private CorporateNameInverted corporateNameInverted = CorporateNameInverted.EMPTY;

    /**
     * <p>
     * The name of a corporate body which contributed to the creation of the product, presented in inverted order, with
     * the element used for alphabetical sorting placed first. Optional and non-repeating: see Group&nbsp;P.7
     * introductory text for valid options.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CorporateNameInverted corporateNameInverted() {
        _initialize();
        return corporateNameInverted;
    }

    private UnnamedPersons unnamedPersons = UnnamedPersons.EMPTY;

    /**
     * <p>
     * An ONIX code allowing a positive indication to be given when authorship is unknown or anonymous, or when as a
     * matter of editorial policy only a limited number of contributors are named. Optional and non-repeating: see
     * Group&nbsp;P.7 introductory text for valid options. Use here in preference to P.7.47, where it is deprecated.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public UnnamedPersons unnamedPersons() {
        _initialize();
        return unnamedPersons;
    }

    private List<AlternativeName> alternativeNames = Collections.emptyList();

    /**
     * <p>
     * A group of data elements which together represent an alternative name of a contributor, and specify its type. The
     * &lt;AlternativeName&gt; composite is optional, and is repeatable to give multiple alternative names for the
     * contributor. It may be used to send a pseudonym as well as a real name, where both names are on the product,
     * <i>eg</i> to handle such cases as ‘Ian Rankin writing as Jack Harvey’; or to send an authority-controlled form of
     * a name; or to identify the real name of the contributor where the book is written under a pseudonym (and the real
     * identity need not be kept private) or is anonymous. Note that in all cases, the primary name is that used on the
     * product, and the alternative name merely provides additional information.
     * </p>
     * <p>
     * Each instance of the composite must contain the &lt;NameType&gt; element with <em>either</em>:
     * </p>
     * <ul>
     * <li>one or more of the forms of representation of a person name, with or without an occurrence of the
     * &lt;NameIdentifier&gt; composite; <em>or</em></li>
     * <li>one or both of the forms of representation of a corporate name, with or without an occurrence of the
     * &lt;NameIdentifier&gt; composite; <em>or</em></li>
     * <li>an occurrence of the &lt;NameIdentifier&gt; composite without any accompanying name element(s).</li>
     * </ul>
     * Jonix-Comment: this list may be empty
     */
    public List<AlternativeName> alternativeNames() {
        _initialize();
        return alternativeNames;
    }

    private ListOfOnixDataCompositeWithKey<ContributorDate, JonixContributorDate,
        PersonOrganizationDateRoles> contributorDates = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * A group of data elements which together specify a date associated with the person or organization identified in
     * an occurrence of the &lt;Contributor&gt; composite, <i>eg</i> birth or death. Optional, and repeatable to allow
     * multiple dates to be specified.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ContributorDate, JonixContributorDate, PersonOrganizationDateRoles>
        contributorDates() {
        _initialize();
        return contributorDates;
    }

    private ListOfOnixDataComposite<ProfessionalAffiliation, JonixProfessionalAffiliation> professionalAffiliations =
        ListOfOnixDataComposite.empty();

    /**
     * <p>
     * An optional group of data elements which together identify a contributor’s professional position and/or
     * affiliation, repeatable to allow multiple positions and affiliations to be specified.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<ProfessionalAffiliation, JonixProfessionalAffiliation> professionalAffiliations() {
        _initialize();
        return professionalAffiliations;
    }

    private ListOfOnixDataComposite<Prize, JonixPrize> prizes = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * An optional group of data elements which together describe a prize or award won by the contributor for a body of
     * work (rather than for this or other specific works or products). Repeatable to describe multiple prizes or
     * awards.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Prize, JonixPrize> prizes() {
        _initialize();
        return prizes;
    }

    private ListOfOnixElement<BiographicalNote, String> biographicalNotes = ListOfOnixElement.empty();

    /**
     * <p>
     * A biographical note about a contributor to the product. (See the &lt;TextContent&gt; composite in Group&nbsp;P.14
     * for a biographical note covering all contributors to a product in a single text.) Optional, and repeatable to
     * provide parallel biographical notes in multiple languages. The <i>language</i> attribute is optional for a single
     * instance of &lt;BiographicalNote&gt;, but must be included in each instance if &lt;BiographicalNote&gt; is
     * repeated. May occur with a person name or with a corporate name. A biographical note in ONIX should
     * <em>always</em> contain the name of the person or body concerned, and it should <em>always</em> be presented as a
     * piece of continuous text consisting of full sentences. Some recipients of ONIX data feeds will not accept text
     * which has embedded URLs. A contributor website link can be sent using the &lt;Website&gt; composite below.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<BiographicalNote, String> biographicalNotes() {
        _initialize();
        return biographicalNotes;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * An optional group of data elements which together identify and provide a pointer to a website which is related to
     * the person or organization identified in an occurrence of the &lt;Contributor&gt; composite. Repeatable to
     * provide links to multiple websites.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }

    private ListOfOnixElement<ContributorDescription, String> contributorDescriptions = ListOfOnixElement.empty();

    /**
     * <p>
     * Brief text describing a contributor to the product, at the publisher’s discretion. Optional, and repeatable to
     * provide parallel descriptions in multiple languages. The <i>language</i> attribute is optional for a single
     * instance of &lt;ContributorDescription&gt;, but must be included in each instance if
     * &lt;ContributorDescription&gt; is repeated. It may be used with either a person or corporate name, to draw
     * attention to any aspect of a contributor’s background which supports the promotion of the book.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ContributorDescription, String> contributorDescriptions() {
        _initialize();
        return contributorDescriptions;
    }

    private ListOfOnixDataComposite<ContributorPlace, JonixContributorPlace> contributorPlaces =
        ListOfOnixDataComposite.empty();

    /**
     * <p>
     * An optional group of data elements which together identify a geographical location with which a contributor is
     * associated, used to support ‘local interest’ promotions. Repeatable to identify multiple geographical locations,
     * each usually with a different relationship to the contributor.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<ContributorPlace, JonixContributorPlace> contributorPlaces() {
        _initialize();
        return contributorPlaces;
    }
}
