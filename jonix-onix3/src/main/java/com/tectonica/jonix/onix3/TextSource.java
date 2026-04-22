/*
 * Copyright (C) 2012-2026 Zach Melamed
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
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixNameIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Text source name composite</h1>
 * <p>
 * Group of elements providing a personal or corporate name for the authorship of the supporting text, typically where
 * the text is a review of the product. Optional, and repeatable to provide multiple names, but may only be used if
 * &lt;TextAuthor&gt;, &lt;TextSourceCorporate&gt; and &lt;TextSourceDescription&gt; (at P.14.5a) are omitted.
 * </p>
 * <p>
 * The structure of this composite is a subset of the structure of &lt;Contributor&gt; composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;TextSource&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;textsource&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;TextSource&gt; from the schema author:
 *
 * Name of author or corporate source of supporting text &#9679; Added at revision 3.1.3
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link TextContent}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈ {@link TextSource}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link TextSource}</li>
 * </ul>
 *
 * @since Onix-3.13
 */
public class TextSource implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TextSource";
    public static final String shortname = "textsource";

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
    public static final TextSource EMPTY = new TextSource();

    public TextSource() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public TextSource(org.w3c.dom.Element element) {
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
                case SequenceNumber.refname:
                case SequenceNumber.shortname:
                    sequenceNumber = new SequenceNumber(e);
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
                case UnnamedPersons.refname:
                case UnnamedPersons.shortname:
                    unnamedPersons = new UnnamedPersons(e);
                    break;
                case CorporateNameInverted.refname:
                case CorporateNameInverted.shortname:
                    corporateNameInverteds = JPU.addToList(corporateNameInverteds, new CorporateNameInverted(e));
                    break;
                case ProfessionalAffiliation.refname:
                case ProfessionalAffiliation.shortname:
                    professionalAffiliations = JPU.addToList(professionalAffiliations, new ProfessionalAffiliation(e));
                    break;
                case TextSourceDescription.refname:
                case TextSourceDescription.shortname:
                    textSourceDescriptions = JPU.addToList(textSourceDescriptions, new TextSourceDescription(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;TextSource&gt; or &lt;textsource&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<TextSource> action) {
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
     * <i>ie</i>&nbsp;the name elements normally used to open an entry in an alphabetical list, <i>eg</i>&nbsp;‘Smith’
     * or ‘Garcia Marquez’ or ‘Madonna’ or ‘Francis de Sales’ (in Saint Francis de Sales). Non-repeating. Required if
     * name part elements P.7.11 to P.7.18 are used.
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
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixElement<CorporateName, String> corporateNames() {
        _initialize();
        return corporateNames;
    }

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * <p>
     * An ordinal number which specifies a single overall sequence of text source names, which is the preferred order
     * for display of the various text sources. Optional and non-repeating. It is strongly recommended that where there
     * are two or more instances of &lt;TextSource&gt; within &lt;TextContent&gt;, each occurrence of the
     * &lt;TextSource&gt; composite should carry a unique and sequential &lt;SequenceNumber&gt;.
     * </p>
     * JONIX adds: this field is optional
     */
    public SequenceNumber sequenceNumber() {
        _initialize();
        return sequenceNumber;
    }

    private NameType nameType = NameType.EMPTY;

    /**
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
     * and/or titles preceding a person’s names, <i>eg</i>&nbsp;‘Professor’ or ‘HRH Prince’ or ‘Saint’. Optional and
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
     * initial(s) preceding a person’s key name(s), <i>eg</i>&nbsp;James J. Optional and non-repeating.
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
     * precedes the key name(s) but which is not to be treated as part of the key name, <i>eg</i>&nbsp;‘van’ in Ludwig
     * van Beethoven. This element may also be used for titles that appear after given names and before key names,
     * <i>eg</i>&nbsp;‘Lord’ in Alfred, Lord Tennyson. Optional and non-repeating.
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
     * name(s) following a person’s key name(s), <i>eg</i>&nbsp;‘Ibrahim’ (in Anwar Ibrahim). Optional and
     * non-repeating.
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
     * following a person’s key name(s), <i>eg</i>&nbsp;‘Jr’ or ‘III’. Optional and non-repeating.
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
     * and honors following a person’s names, <i>eg</i>&nbsp;‘CBE FRS’. Optional and non-repeating.
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
     * a person’s names, <i>eg</i>&nbsp;‘Duke of Edinburgh’. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public TitlesAfterNames titlesAfterNames() {
        _initialize();
        return titlesAfterNames;
    }

    private UnnamedPersons unnamedPersons = UnnamedPersons.EMPTY;

    /**
     * <p>
     * An ONIX code allowing a positive indication to be given when authorship is unknown or anonymous, or when as a
     * matter of editorial policy only a limited number of contributors are named, or when the contributor is
     * artificial. Optional and non-repeating: see Group&nbsp;P.7 introductory text for valid options.
     * </p>
     * JONIX adds: this field is optional
     */
    public UnnamedPersons unnamedPersons() {
        _initialize();
        return unnamedPersons;
    }

    private ListOfOnixElement<CorporateNameInverted, String> corporateNameInverteds = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a corporate body which contributed to the creation of the product, presented in inverted order, with
     * the element used for alphabetical sorting placed first. Optional: see Group&nbsp;P.7 introductory text for valid
     * options. Repeatable, to provide parallel names for a single organization in multiple languages
     * (<i>eg</i>&nbsp;‘Polar Research Foundation, The’ and <span lang="de">‚Polarforschungsinstitut, Das‘</span>) or
     * scripts. The <i>language</i> attribute is optional for a single instance of &lt;CorporateNameInverted&gt;, but
     * must be included in each instance if &lt;CorporateNameInverted&gt; is repeated. If any two or more repeats are in
     * the same language but different scripts, each instance of <em>every</em> language must also carry the
     * <i>textscript</i> attribute..
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<CorporateNameInverted, String> corporateNameInverteds() {
        _initialize();
        return corporateNameInverteds;
    }

    private ListOfOnixComposite<ProfessionalAffiliation> professionalAffiliations =
        JPU.emptyListOfOnixComposite(ProfessionalAffiliation.class);

    /**
     * <p>
     * An optional group of data elements which together identify a professional position and/or affiliation of the text
     * source, repeatable to allow multiple positions and affiliations to be specified.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<ProfessionalAffiliation> professionalAffiliations() {
        _initialize();
        return professionalAffiliations;
    }

    private ListOfOnixElement<TextSourceDescription, String> textSourceDescriptions = ListOfOnixElement.empty();

    /**
     * <p>
     * Brief text describing or providing context for the text source name, at the publisher’s discretion, and intended
     * to be used in addition to the source’s personal or corporate name. Optional, and repeatable to provide parallel
     * descriptions in multiple languages. The <i>language</i> attribute is optional for a single instance of
     * &lt;TextSourceDescription&gt;, but must be included in each instance if &lt;TextSourceDescription&gt; is
     * repeated. The description may be used with either a person or corporate name, to draw attention to any aspect of
     * the text source’s background which provides context for the text in &lt;Text&gt;.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<TextSourceDescription, String> textSourceDescriptions() {
        _initialize();
        return textSourceDescriptions;
    }
}
