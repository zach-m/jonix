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

package com.tectonica.jonix.onix3;

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
 * <h1>Alternative name composite</h1>
 * <p>
 * A group of data elements which together represent an alternative name of a contributor, and specify its type. The
 * &lt;AlternativeName&gt; composite is optional, and is repeatable to give multiple alternative names for the
 * contributor. It may be used to send a pseudonym as well as a real name, where both names are on the product,
 * <i>eg</i> to handle such cases as ‘Ian Rankin writing as Jack Harvey’; or to send an authority-controlled form of a
 * name; or to identify the real name of the contributor where the book is written under a pseudonym (and the real
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
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;AlternativeName&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;alternativename&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;AlternativeName&gt; from the schema author:
 *
 * Details of an alternative name for a personal or corporate contributor, or for a subject &#9679; Added &lt;Gender&gt;
 * at revision 3.0.3 &#9679; Added &lt;CorporateNameInverted&gt; at revision 3.0 (2010)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Contributor}&gt;</li>
 * <li>&lt;{@link NameAsSubject}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link AlternativeName}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈
 * {@link AlternativeName}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈
 * {@link AlternativeName}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈
 * {@link AlternativeName}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link NameAsSubject} ⯈ {@link AlternativeName}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link NameAsSubject} ⯈
 * {@link AlternativeName}</li>
 * </ul>
 */
public class AlternativeName implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "AlternativeName";
    public static final String shortname = "alternativename";

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
    public static final AlternativeName EMPTY = new AlternativeName();

    public AlternativeName() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public AlternativeName(org.w3c.dom.Element element) {
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
                case NameType.refname:
                case NameType.shortname:
                    nameType = new NameType(e);
                    break;
                case PersonName.refname:
                case PersonName.shortname:
                    personName = new PersonName(e);
                    break;
                case KeyNames.refname:
                case KeyNames.shortname:
                    keyNames = new KeyNames(e);
                    break;
                case CorporateName.refname:
                case CorporateName.shortname:
                    corporateName = new CorporateName(e);
                    break;
                case NameIdentifier.refname:
                case NameIdentifier.shortname:
                    nameIdentifiers = JPU.addToList(nameIdentifiers, new NameIdentifier(e));
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
                case Gender.refname:
                case Gender.shortname:
                    gender = new Gender(e);
                    break;
                case CorporateNameInverted.refname:
                case CorporateNameInverted.shortname:
                    corporateNameInverted = new CorporateNameInverted(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;AlternativeName&gt; or &lt;alternativename&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<AlternativeName> action) {
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

    private NameType nameType = NameType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the type of the name sent in an occurrence of the &lt;AlternativeName&gt; composite.
     * Mandatory in each occurrence of the composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public NameType nameType() {
        _initialize();
        return nameType;
    }

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

    private CorporateName corporateName = CorporateName.EMPTY;

    /**
     * <p>
     * The name of a corporate body which contributed to the creation of the product, unstructured. Optional and
     * non-repeating: see Group&nbsp;P.7 introductory text for valid options.
     * </p>
     * JONIX adds: this field is required
     */
    public CorporateName corporateName() {
        _initialize();
        return corporateName;
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

    private Gender gender = Gender.EMPTY;

    /**
     * <p>
     * An optional ONIX code specifying the gender of a personal contributor. Not repeatable. Note that this indicates
     * the gender of the contributor’s public identity (which may be pseudonymous) based on designations used in ISO
     * 5218, rather than the gender identity, biological sex or sexuality of a natural person.
     * </p>
     * JONIX adds: this field is optional
     */
    public Gender gender() {
        _initialize();
        return gender;
    }

    private CorporateNameInverted corporateNameInverted = CorporateNameInverted.EMPTY;

    /**
     * <p>
     * The name of a corporate body which contributed to the creation of the product, presented in inverted order, with
     * the element used for alphabetical sorting placed first. Optional and non-repeating: see Group&nbsp;P.7
     * introductory text for valid options.
     * </p>
     * JONIX adds: this field is optional
     */
    public CorporateNameInverted corporateNameInverted() {
        _initialize();
        return corporateNameInverted;
    }
}
