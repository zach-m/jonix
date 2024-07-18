/*
 * Copyright (C) 2012-2024 Zach Melamed
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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.PersonOrganizationDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixNameIdentifier;
import com.tectonica.jonix.common.struct.JonixSubjectDate;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Name as subject composite</h1>
 * <p>
 * An optional group of data elements which together represent the name of a person or organization – real or fictional
 * – that is part of the subject of a product. Repeatable in order to name multiple persons or organizations.
 * </p>
 * <p>
 * Each instance of the composite must contain <em>either</em>:
 * </p>
 * <ul>
 * <li>one or more of the forms of representation of a person name, with or without an occurrence of the
 * &lt;NameIdentifier&gt; composite; <em>or</em></li>
 * <li>one or more of the forms of representation of a corporate name, with or without an occurrence of the
 * &lt;NameIdentifier&gt; composite; <em>or</em></li>
 * <li>an occurrence of the &lt;NameIdentifier&gt; composite without any accompanying name element(s).</li>
 * </ul>
 * <p>
 * The name of a person (not of a corporation) may optionally be followed by details of that person’s professional
 * affiliation.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;NameAsSubject&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;nameassubject&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;NameAsSubject&gt; from the schema author:
 *
 * Details of a person, persona or corporate identity that is the subject of the product &#9679; Removed &lt;Gender&gt;
 * at release 3.1 &#9679; Modified cardinality of corporate names at release 3.1 &#9679; Added &lt;AlternativeName&gt;,
 * &lt;SubjectDate&gt;, &lt;ProfessionalAffiliation&gt;, &lt;Gender&gt; at revision 3.0.3 &#9679; Added
 * &lt;CorporateNameInverted&gt; at revision 3.0 (2010) &#9679; Modified cardinality of &lt;NameType&gt; at revision 3.0
 * (2010)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link NameAsSubject}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link NameAsSubject}</li>
 * </ul>
 */
public class NameAsSubject implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "NameAsSubject";
    public static final String shortname = "nameassubject";

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
    public static final NameAsSubject EMPTY = new NameAsSubject();

    public NameAsSubject() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public NameAsSubject(org.w3c.dom.Element element) {
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
                case PersonName.refname:
                case PersonName.shortname:
                    personName = new PersonName(e);
                    break;
                case KeyNames.refname:
                case KeyNames.shortname:
                    keyNames = new KeyNames(e);
                    break;
                case NameIdentifier.refname:
                case NameIdentifier.shortname:
                    nameIdentifiers = JPU.addToList(nameIdentifiers, new NameIdentifier(e));
                    break;
                case CorporateName.refname:
                case CorporateName.shortname:
                    corporateNames = JPU.addToList(corporateNames, new CorporateName(e));
                    break;
                case NameType.refname:
                case NameType.shortname:
                    nameType = new NameType(e);
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
                case CorporateNameInverted.refname:
                case CorporateNameInverted.shortname:
                    corporateNameInverteds = JPU.addToList(corporateNameInverteds, new CorporateNameInverted(e));
                    break;
                case AlternativeName.refname:
                case AlternativeName.shortname:
                    alternativeNames = JPU.addToList(alternativeNames, new AlternativeName(e));
                    break;
                case SubjectDate.refname:
                case SubjectDate.shortname:
                    subjectDates = JPU.addToList(subjectDates, new SubjectDate(e));
                    break;
                case ProfessionalAffiliation.refname:
                case ProfessionalAffiliation.shortname:
                    professionalAffiliations = JPU.addToList(professionalAffiliations, new ProfessionalAffiliation(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;NameAsSubject&gt; or &lt;nameassubject&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<NameAsSubject> action) {
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

    private PersonName personName = PersonName.EMPTY;

    /**
     * <p>
     * The name of a person who contributed to the creation of the product, unstructured, and presented in normal order.
     * Optional and non-repeating: see Group&nbsp;P.7 introductory text for valid options.
     * </p>
     * JONIX adds: this field is required
     */
    public PersonName personName() {
        _initialize();
        return personName;
    }

    private KeyNames keyNames = KeyNames.EMPTY;

    /**
     * <p>
     * The fourth part of a structured name of a person who contributed to the creation of the product: key name(s),
     * <i>ie</i> the name elements normally used to open an entry in an alphabetical list, <i>eg</i> ‘Smith’ or ‘Garcia
     * Marquez’ or ‘Madonna’ or ‘Francis de Sales’ (in Saint Francis de Sales). Non-repeating. Required if name part
     * elements P.7.11 to P.7.18 are used.
     * </p>
     * JONIX adds: this field is required
     */
    public KeyNames keyNames() {
        _initialize();
        return keyNames;
    }

    private ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameIdentifierTypes> nameIdentifiers =
        JPU.emptyListOfOnixDataCompositeWithKey(NameIdentifier.class);

    /**
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameIdentifierTypes> nameIdentifiers() {
        _initialize();
        return nameIdentifiers;
    }

    private ListOfOnixElement<CorporateName, String> corporateNames = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a corporate body which contributed to the creation of the product, unstructured, and presented in
     * normal order. Optional: see Group&nbsp;P.7 introductory text for valid options. Repeatable, to provide parallel
     * names for a single organization in multiple languages (<i>eg</i> ‘World Health Organization’ and
     * <span lang="fr">«&nbsp;Organisation mondiale de la santé&nbsp;»</span>).The <i>language</i> attribute is optional
     * for a single instance of &lt;CorporateName&gt;, but must be included in each instance if &lt;CorporateName&gt; is
     * repeated.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixElement<CorporateName, String> corporateNames() {
        _initialize();
        return corporateNames;
    }

    private NameType nameType = NameType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the type of a primary name. Optional, and non-repeating. If omitted, the default is
     * ‘unspecified’ (<i>ie</i> the name as it is presented on the book).
     * </p>
     * JONIX adds: this field is optional
     */
    public NameType nameType() {
        _initialize();
        return nameType;
    }

    private PersonNameInverted personNameInverted = PersonNameInverted.EMPTY;

    /**
     * <p>
     * The name of a person who contributed to the creation of the product, presented with the element used for
     * alphabetical sorting placed first (‘inverted order’). Optional and non-repeating: see Group&nbsp;P.7 introductory
     * text for valid options.
     * </p>
     * JONIX adds: this field is optional
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
     * JONIX adds: this field is optional
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
     * JONIX adds: this field is optional
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
     * JONIX adds: this field is optional
     */
    public PrefixToKey prefixToKey() {
        _initialize();
        return prefixToKey;
    }

    private NamesAfterKey namesAfterKey = NamesAfterKey.EMPTY;

    /**
     * <p>
     * The fifth part of a structured name of a person who contributed to the creation of the product: name suffix, or
     * name(s) following a person’s key name(s), <i>eg</i> ‘Ibrahim’ (in Anwar Ibrahim). Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
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
     * JONIX adds: this field is optional
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
     * JONIX adds: this field is optional
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
     * JONIX adds: this field is optional
     */
    public TitlesAfterNames titlesAfterNames() {
        _initialize();
        return titlesAfterNames;
    }

    private ListOfOnixElement<CorporateNameInverted, String> corporateNameInverteds = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a corporate body which contributed to the creation of the product, presented in inverted order, with
     * the element used for alphabetical sorting placed first. Optional: see Group&nbsp;P.7 introductory text for valid
     * options. Repeatable, to provide parallel names for a single organization in multiple languages (<i>eg</i> ‘Polar
     * Research Foundation, The’ and <span lang="de">‚Polarforschungsinstitut, Das‘</span>).The <i>language</i>
     * attribute is optional for a single instance of &lt;CorporateNameInverted&gt;, but must be included in each
     * instance if &lt;CorporateNameInverted&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<CorporateNameInverted, String> corporateNameInverteds() {
        _initialize();
        return corporateNameInverteds;
    }

    private ListOfOnixComposite<AlternativeName> alternativeNames = JPU.emptyListOfOnixComposite(AlternativeName.class);

    /**
     * <p>
     * A repeatable group of data elements which together represent an alternative name of a person or organization that
     * is part of the subject of a product, and specify its type. The &lt;AlternativeName&gt; composite is optional.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<AlternativeName> alternativeNames() {
        _initialize();
        return alternativeNames;
    }

    private ListOfOnixDataCompositeWithKey<SubjectDate, JonixSubjectDate, PersonOrganizationDateRoles> subjectDates =
        JPU.emptyListOfOnixDataCompositeWithKey(SubjectDate.class);

    /**
     * <p>
     * A group of data elements which together specify a date associated with the person or organization identified in
     * an occurrence of the &lt;NameAsSubject&gt; composite, <i>eg</i> birth or death. Optional, and repeatable to
     * provide multiple dates with their various roles.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<SubjectDate, JonixSubjectDate, PersonOrganizationDateRoles> subjectDates() {
        _initialize();
        return subjectDates;
    }

    private ListOfOnixComposite<ProfessionalAffiliation> professionalAffiliations =
        JPU.emptyListOfOnixComposite(ProfessionalAffiliation.class);

    /**
     * <p>
     * An optional group of data elements which together identify a subject’s professional position and/or affiliation,
     * repeatable to allow multiple positions and affiliations to be specified.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<ProfessionalAffiliation> professionalAffiliations() {
        _initialize();
        return professionalAffiliations;
    }
}
