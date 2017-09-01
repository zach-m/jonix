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
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.LanguageCodes;
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
 * <h1>Person name identifier composite</h1><p>A repeatable group of data elements which together specify a party name
 * identifier, used here to carry an identifier for a name given in an occurrence of the &lt;Contributor&gt; composite.
 * Optional: see Group&nbsp;PR.8 introductory text for valid options.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;PersonNameIdentifier&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;personnameidentifier&gt;</td></tr></table>
 */
public class PersonNameIdentifier
    implements OnixDataCompositeWithKey<JonixPersonNameIdentifier, PersonNameIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PersonNameIdentifier";
    public static final String shortname = "personnameidentifier";

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
    public static final PersonNameIdentifier EMPTY = new PersonNameIdentifier();

    public PersonNameIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PersonNameIdentifier(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            if (name.equals(PersonNameIDType.refname) || name.equals(PersonNameIDType.shortname)) {
                personNameIDType = new PersonNameIDType(e);
            } else if (name.equals(IDTypeName.refname) || name.equals(IDTypeName.shortname)) {
                idTypeName = new IDTypeName(e);
            } else if (name.equals(IDValue.refname) || name.equals(IDValue.shortname)) {
                idValue = new IDValue(e);
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

    private PersonNameIDType personNameIDType = PersonNameIDType.EMPTY;

    /**
     * (this field is required)
     */
    public PersonNameIDType personNameIDType() {
        initialize();
        return personNameIDType;
    }

    private IDTypeName idTypeName = IDTypeName.EMPTY;

    /**
     * (this field is optional)
     */
    public IDTypeName idTypeName() {
        initialize();
        return idTypeName;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * (this field is required)
     */
    public IDValue idValue() {
        initialize();
        return idValue;
    }

    @Override
    public JonixPersonNameIdentifier asStruct() {
        initialize();
        JonixPersonNameIdentifier struct = new JonixPersonNameIdentifier();
        struct.personNameIDType = personNameIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public PersonNameIdentifierTypes structKey() {
        return personNameIDType().value;
    }
}
