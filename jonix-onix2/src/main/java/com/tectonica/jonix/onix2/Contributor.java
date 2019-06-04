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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.ContributorRoles;
import com.tectonica.jonix.common.codelist.Countrys;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.PersonDateRoles;
import com.tectonica.jonix.common.codelist.PersonNameIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixPersonDate;
import com.tectonica.jonix.common.struct.JonixPersonNameIdentifier;
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
 * A repeatable group of data elements which together describe a personal or corporate contributor to the series. The
 * composite is optional in any occurrence of the &lt;Series&gt; composite. <strong>Please see Group&nbsp;PR.8 for
 * details.</strong>
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
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Product&gt;</li>
 * <li>&lt;ContentItem&gt;</li>
 * <li>&lt;SubSeriesRecord&gt;</li>
 * <li>&lt;MainSeriesRecord&gt;</li>
 * <li>&lt;Series&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ Contributor</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Contributor</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ Contributor</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ Contributor</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ Contributor</li>
 * </ul>
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
     * A number which specifies a single overall sequence of contributor names. Optional and non-repeating. There are
     * two ways of approaching the sequencing of contributor names: by defining a single sequence across all
     * contributors, which is the general ONIX practise; or by defining an individual sequence for each contributor
     * role, using the element &lt;SequenceNumberWithinRole&gt; on the next page. Some applications require this more
     * precise sequencing. Where it is not required, it is strongly recommended that each occurrence of the
     * &lt;Contributor&gt; composite should carry an overall &lt;SequenceNumber&gt;.
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
     * has more than one role in relation to the product. Note, however, that if the &lt;SequenceNumberWithinRole&gt;
     * element is used to establish individual sequences of contributor names by role, the &lt;ContributorRole&gt;
     * element must not be repeated. There must instead be separate occurrences of the &lt;Contributor&gt; composite if
     * the same person has two or more roles.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<ContributorRole, ContributorRoles> contributorRoles() {
        _initialize();
        return contributorRoles;
    }

    private ListOfOnixElement<LanguageCode, Languages> languageCodes = ListOfOnixElement.empty();

    /**
     * <p>
     * Used only when the &lt;ContributorRole&gt; code value is B06, B08 or B10 indicating a translator, to specify the
     * language from which the translation was made. This makes it possible to specify a translator’s exact
     * responsibility when a work involved translation from two or more languages. Optional and repeatable in the
     * unlikely event that a single person has been responsible for translation from two or more languages.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<LanguageCode, Languages> languageCodes() {
        _initialize();
        return languageCodes;
    }

    private SequenceNumberWithinRole sequenceNumberWithinRole = SequenceNumberWithinRole.EMPTY;

    /**
     * <p>
     * A number which specifies the sequence of contributor names within a specified role, for applications which
     * require this form of numbering. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SequenceNumberWithinRole sequenceNumberWithinRole() {
        _initialize();
        return sequenceNumberWithinRole;
    }

    private PersonName personName = PersonName.EMPTY;

    /**
     * <p>
     * The name of a person who contributed to the creation of the product, unstructured, and presented in normal order.
     * Optional and non-repeating: see Group&nbsp;PR.8 introductory text for valid options.
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
     * The name of a person who contributed to the creation of the product, presented in inverted order, with the
     * element used for alphabetical sorting placed first. Optional and non-repeating: see Group&nbsp;PR.8 introductory
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
     * and/or titles preceding a person’s names, <em>eg</em> Professor or HRH Prince or Saint. Optional and
     * non-repeating: see Group&nbsp;PR.8 introductory text for valid options.
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
     * initial(s) preceding a person’s key name(s), <em>eg</em> James J. Optional and non-repeating.
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
     * precedes the key name(s) but which is not to be treated as part of the key name, <em>eg</em> van in Ludwig van
     * Beethoven. Optional and non-repeating.
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
     * <em>ie</em> the name elements normally used to open an entry in an alphabetical list, <em>eg</em> Smith or
     * Garcia
     * Marquez or Madonna or Francis de Sales (in Saint Francis de Sales). Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public KeyNames keyNames() {
        _initialize();
        return keyNames;
    }

    private NamesAfterKey namesAfterKey = NamesAfterKey.EMPTY;

    /**
     * <p>
     * The fifth part of a structured name of a person who contributed to the creation of the product: name suffix, or
     * name(s) following a person’s key name(s), <em>eg</em> Ibrahim (in Anwar Ibrahim). Optional and non-repeating.
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
     * following a person’s key name(s), <em>eg</em> Jr or III. Optional and non-repeating.
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
     * and honors following a person’s names, <em>eg</em> CBE FRS. Optional and non-repeating.
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
     * a person’s names, <em>eg</em> Duke of Edinburgh. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TitlesAfterNames titlesAfterNames() {
        _initialize();
        return titlesAfterNames;
    }

    private List<Name> names = Collections.emptyList();

    /**
     * <p>
     * A repeatable group of data elements which together represent a personal name, and specify its type. The
     * &lt;Name&gt; composite may be used to send alternate names for the same person, <em>eg</em> to handle such cases
     * as Ian Rankin writing as Jack Harvey.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<Name> names() {
        _initialize();
        return names;
    }

    private ListOfOnixDataCompositeWithKey<PersonNameIdentifier, JonixPersonNameIdentifier, PersonNameIdentifierTypes>
        personNameIdentifiers = ListOfOnixDataCompositeWithKey
        .emptyKeyed();

    /**
     * <p>
     * A repeatable group of data elements which together specify a party name identifier, used here to carry an
     * identifier for a name given in an occurrence of the &lt;Contributor&gt; composite. Optional: see Group&nbsp;PR.8
     * introductory text for valid options.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<PersonNameIdentifier, JonixPersonNameIdentifier, PersonNameIdentifierTypes> personNameIdentifiers() {
        _initialize();
        return personNameIdentifiers;
    }

    private ListOfOnixDataCompositeWithKey<PersonDate, JonixPersonDate, PersonDateRoles> personDates =
        ListOfOnixDataCompositeWithKey
            .emptyKeyed();

    /**
     * <p>
     * A repeatable group of data elements which together specify a date associated with the person identified in an
     * occurrence of the &lt;Contributor&gt; composite, <em>eg</em> birth or death.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<PersonDate, JonixPersonDate, PersonDateRoles> personDates() {
        _initialize();
        return personDates;
    }

    private ListOfOnixDataComposite<ProfessionalAffiliation, JonixProfessionalAffiliation> professionalAffiliations =
        ListOfOnixDataComposite
            .empty();

    /**
     * <p>
     * A repeatable group of data elements which together identify a contributor’s professional position and/or
     * affiliation, allowing multiple positions and affiliations to be specified.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<ProfessionalAffiliation, JonixProfessionalAffiliation> professionalAffiliations() {
        _initialize();
        return professionalAffiliations;
    }

    private CorporateName corporateName = CorporateName.EMPTY;

    /**
     * <p>
     * The name of a corporate body which contributed to the creation of the product, unstructured. Optional and
     * non-repeating: see Group&nbsp;PR.8 introductory text for valid options.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CorporateName corporateName() {
        _initialize();
        return corporateName;
    }

    private BiographicalNote biographicalNote = BiographicalNote.EMPTY;

    /**
     * <p>
     * A biographical note about a contributor to the product. (See the &lt;OtherText&gt; composite in Group&nbsp;PR.15
     * for a biographical note covering all contributors to a product in a single text.) Optional and non-repeating. May
     * occur with a person name or with a corporate name. A biographical note in ONIX should always contain the name of
     * the person or body concerned, and it should always be presented as a piece of continuous text consisting of full
     * sentences. Some recipients of ONIX data feeds will not accept text which has embedded URLs. A contributor website
     * link can be sent using the &lt;Website&gt; composite on the next page.
     * </p>
     * <p>
     * The &lt;BiographicalNote&gt; element may carry any of the following ONIX attributes: <i>textformat, language,
     * transliteration, textcase</i>.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public BiographicalNote biographicalNote() {
        _initialize();
        return biographicalNote;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * A repeatable group of data elements which together identify and provide pointers to a website which is related to
     * the party identified in an occurrence of the &lt;Contributor&gt; composite.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }

    private ProfessionalPosition professionalPosition = ProfessionalPosition.EMPTY;

    /**
     * <p>
     * A professional position held by a contributor to the product at the time of its creation. Optional and
     * non-repeating. May only occur with a person name, not with a corporate name.
     * </p>
     * <p>
     * <strong>The &lt;ProfessionalAffiliation&gt; composite below provides a more general method of handling positions
     * and affiliations, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ProfessionalPosition professionalPosition() {
        _initialize();
        return professionalPosition;
    }

    private Affiliation affiliation = Affiliation.EMPTY;

    /**
     * <p>
     * An organisation to which a contributor to the product was affiliated at the time of its creation. Optional and
     * non-repeating. May only occur with a person name, not with a corporate name.
     * </p>
     * <p>
     * <strong>The &lt;ProfessionalAffiliation&gt; composite below provides a more general method of handling positions
     * and affiliations, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Affiliation affiliation() {
        _initialize();
        return affiliation;
    }

    private ContributorDescription contributorDescription = ContributorDescription.EMPTY;

    /**
     * <p>
     * Brief text describing a contributor to the product, at the publisher’s discretion. Optional and non-repeating. It
     * may be used with either a person or corporate name, to draw attention to any aspect of a contributor’s background
     * which supports the promotion of the book.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ContributorDescription contributorDescription() {
        _initialize();
        return contributorDescription;
    }

    private UnnamedPersons unnamedPersons = UnnamedPersons.EMPTY;

    /**
     * <p>
     * An ONIX code allowing a positive indication to be given when authorship is unknown or anonymous, or when as a
     * matter of editorial policy only a limited number of contributors are named. Optional and non-repeating: see
     * Group&nbsp;PR.8 introductory text for valid options.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public UnnamedPersons unnamedPersons() {
        _initialize();
        return unnamedPersons;
    }

    private ListOfOnixElement<CountryCode, Countrys> countryCodes = ListOfOnixElement.empty();

    /**
     * <p>
     * A code identifying a country with which a contributor is particularly associated, when this is significant for
     * the marketing of a product. Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<CountryCode, Countrys> countryCodes() {
        _initialize();
        return countryCodes;
    }

    private ListOfOnixElement<RegionCode, java.util.Set<String>> regionCodes = ListOfOnixElement.empty();

    /**
     * <p>
     * An ONIX code identifying a region with which a contributor is particularly associated, when this is significant
     * for the marketing of a product. Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<RegionCode, java.util.Set<String>> regionCodes() {
        _initialize();
        return regionCodes;
    }
}
