/*
 * Copyright (C) 2012-2023 Zach Melamed
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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.PersonNameIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixPersonNameIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Person name identifier composite</h1>
 * <p>
 * A repeatable group of data elements which together specify a party name identifier, used here to carry an identifier
 * for a name given in an occurrence of the &lt;Contributor&gt; composite. Optional: see Group&nbsp;PR.8 introductory
 * text for valid options.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PersonNameIdentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;personnameidentifier&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Name}&gt;</li>
 * <li>&lt;{@link Contributor}&gt;</li>
 * <li>&lt;{@link PersonAsSubject}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link PersonNameIdentifier}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link PersonNameIdentifier}</li>
 * <li>{@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link PersonNameIdentifier}</li>
 * <li>{@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link PersonNameIdentifier}</li>
 * <li>{@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link PersonNameIdentifier}</li>
 * <li>{@link Product} ⯈ {@link PersonAsSubject} ⯈ {@link Name} ⯈ {@link PersonNameIdentifier}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link PersonAsSubject} ⯈ {@link Name} ⯈
 * {@link PersonNameIdentifier}</li>
 * <li>{@link Product} ⯈ {@link Contributor} ⯈ {@link PersonNameIdentifier}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link PersonNameIdentifier}</li>
 * <li>{@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link PersonNameIdentifier}</li>
 * <li>{@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link PersonNameIdentifier}</li>
 * <li>{@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈ {@link PersonNameIdentifier}</li>
 * <li>{@link Product} ⯈ {@link PersonAsSubject} ⯈ {@link PersonNameIdentifier}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link PersonAsSubject} ⯈ {@link PersonNameIdentifier}</li>
 * </ul>
 *
 * @since Onix-2.1
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
                case PersonNameIDType.refname:
                case PersonNameIDType.shortname:
                    personNameIDType = new PersonNameIDType(e);
                    break;
                case IDValue.refname:
                case IDValue.shortname:
                    idValue = new IDValue(e);
                    break;
                case IDTypeName.refname:
                case IDTypeName.shortname:
                    idTypeName = new IDTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PersonNameIdentifier&gt; or &lt;personnameidentifier&gt;) is explicitly provided in
     *         the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PersonNameIdentifier> action) {
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

    private PersonNameIDType personNameIDType = PersonNameIDType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the scheme from which the value in the &lt;IDValue&gt; element is taken. Mandatory
     * in each occurrence of the &lt;PersonNameIdentifier&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public PersonNameIDType personNameIDType() {
        _initialize();
        return personNameIDType;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * <p>
     * A code value taken from the scheme specified in the &lt;PersonNameIDType&gt; element. Mandatory in each
     * occurrence of the composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public IDValue idValue() {
        _initialize();
        return idValue;
    }

    private IDTypeName idTypeName = IDTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary identifier scheme when, and only when, the code in the
     * &lt;PersonNameIDType&gt; element indicates a proprietary scheme. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public IDTypeName idTypeName() {
        _initialize();
        return idTypeName;
    }

    @Override
    public JonixPersonNameIdentifier asStruct() {
        _initialize();
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
