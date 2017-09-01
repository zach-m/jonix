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
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixNameIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Name as subject composite</h1><p>A group of data elements which together identify a person or organization as a
 * subject of a content item. Optional and repeatable.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;NameAsSubject&gt;</td></tr><tr><td>Short tag</td><td>&lt;nameassubject&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    public String sourcename;

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
            switch (name) {
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
}
