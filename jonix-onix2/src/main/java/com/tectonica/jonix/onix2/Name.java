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
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.codelist.PersonNameIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixPersonNameIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Name composite</h1>
 * <p>
 * A repeatable group of data elements which together represent a personal name, and specify its type. The &lt;Name&gt;
 * composite may be used to send alternate names for the same person, <em>eg</em> to handle such cases as Ian Rankin
 * writing as Jack Harvey.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Name&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;name&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Contributor&gt;</li>
 * <li>&lt;PersonAsSubject&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ Contributor ⯈ Name</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Contributor ⯈ Name</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ Contributor ⯈ Name</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ Contributor ⯈ Name</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ Contributor ⯈ Name</li>
 * <li>ONIXMessage ⯈ Product ⯈ PersonAsSubject ⯈ Name</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ PersonAsSubject ⯈ Name</li>
 * </ul>
 */
public class Name implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Name";
    public static final String shortname = "name";

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
    public static final Name EMPTY = new Name();

    public Name() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Name(org.w3c.dom.Element element) {
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
                case PersonNameType.refname:
                case PersonNameType.shortname:
                    personNameType = new PersonNameType(e);
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
                case PersonNameIdentifier.refname:
                case PersonNameIdentifier.shortname:
                    personNameIdentifiers = JPU.addToList(personNameIdentifiers, new PersonNameIdentifier(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Name&gt; or &lt;name&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private PersonNameType personNameType = PersonNameType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the type of the person name sent in an occurrence of the &lt;Name&gt; composite.
     * Mandatory in each occurrence of the composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public PersonNameType personNameType() {
        _initialize();
        return personNameType;
    }

    private PersonName personName = PersonName.EMPTY;

    /**
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
}
