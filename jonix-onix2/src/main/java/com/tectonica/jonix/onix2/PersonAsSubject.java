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
 * <h1>Person as subject composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together represent the name of a person who is part of the
 * subject of a product.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PersonAsSubject&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;personassubject&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PersonAsSubject}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link PersonAsSubject}</li>
 * </ul>
 */
public class PersonAsSubject implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PersonAsSubject";
    public static final String shortname = "personassubject";

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
    public static final PersonAsSubject EMPTY = new PersonAsSubject();

    public PersonAsSubject() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PersonAsSubject(org.w3c.dom.Element element) {
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
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PersonAsSubject&gt; or &lt;personassubject&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PersonAsSubject> action) {
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

    private PersonNameInverted personNameInverted = PersonNameInverted.EMPTY;

    /**
     * <p>
     * The name of a person who contributed to the creation of the product, presented in inverted order, with the
     * element used for alphabetical sorting placed first. Optional and non-repeating: see Group&nbsp;PR.8 introductory
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
     * and/or titles preceding a person’s names, <em>eg</em> Professor or HRH Prince or Saint. Optional and
     * non-repeating: see Group&nbsp;PR.8 introductory text for valid options.
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
     * initial(s) preceding a person’s key name(s), <em>eg</em> James J. Optional and non-repeating.
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
     * precedes the key name(s) but which is not to be treated as part of the key name, <em>eg</em> van in Ludwig van
     * Beethoven. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public PrefixToKey prefixToKey() {
        _initialize();
        return prefixToKey;
    }

    private KeyNames keyNames = KeyNames.EMPTY;

    /**
     * <p>
     * The fourth part of a structured name of a person who contributed to the creation of the product: key name(s),
     * <em>ie</em> the name elements normally used to open an entry in an alphabetical list, <em>eg</em> Smith or Garcia
     * Marquez or Madonna or Francis de Sales (in Saint Francis de Sales). Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
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
     * following a person’s key name(s), <em>eg</em> Jr or III. Optional and non-repeating.
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
     * and honors following a person’s names, <em>eg</em> CBE FRS. Optional and non-repeating.
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
     * a person’s names, <em>eg</em> Duke of Edinburgh. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public TitlesAfterNames titlesAfterNames() {
        _initialize();
        return titlesAfterNames;
    }

    private ListOfOnixComposite<Name> names = JPU.emptyListOfOnixComposite(Name.class);

    /**
     * <p>
     * A repeatable group of data elements which together represent a personal name, and specify its type. The
     * &lt;Name&gt; composite may be used to send alternate names for the same person, <em>eg</em> to handle such cases
     * as Ian Rankin writing as Jack Harvey.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<Name> names() {
        _initialize();
        return names;
    }

    private ListOfOnixDataCompositeWithKey<PersonNameIdentifier, JonixPersonNameIdentifier,
        PersonNameIdentifierTypes> personNameIdentifiers =
            JPU.emptyListOfOnixDataCompositeWithKey(PersonNameIdentifier.class);

    /**
     * <p>
     * A repeatable group of data elements which together specify a party name identifier, used here to carry an
     * identifier for a name given in an occurrence of the &lt;Contributor&gt; composite. Optional: see Group&nbsp;PR.8
     * introductory text for valid options.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<PersonNameIdentifier, JonixPersonNameIdentifier, PersonNameIdentifierTypes>
        personNameIdentifiers() {
        _initialize();
        return personNameIdentifiers;
    }
}
