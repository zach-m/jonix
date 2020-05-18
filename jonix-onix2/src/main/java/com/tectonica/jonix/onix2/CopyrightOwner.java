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
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Copyright owner composite</h1>
 * <p>
 * A repeatable group of data elements which together name a copyright owner. At least one occurrence is mandatory in
 * each occurrence of the &lt;CopyrightStatement&gt; composite. Each occurrence of the &lt;CopyrightOwner&gt; composite
 * must carry a single name (personal or corporate), or an identifier, or both.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;CopyrightOwner&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;copyrightowner&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link CopyrightStatement}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link CopyrightStatement} ⯈ {@link CopyrightOwner}</li>
 * </ul>
 *
 * @since Onix-2.1
 */
public class CopyrightOwner implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CopyrightOwner";
    public static final String shortname = "copyrightowner";

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
    public static final CopyrightOwner EMPTY = new CopyrightOwner();

    public CopyrightOwner() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public CopyrightOwner(org.w3c.dom.Element element) {
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
                case CopyrightOwnerIdentifier.refname:
                case CopyrightOwnerIdentifier.shortname:
                    copyrightOwnerIdentifier = new CopyrightOwnerIdentifier(e);
                    break;
                case PersonName.refname:
                case PersonName.shortname:
                    personName = new PersonName(e);
                    break;
                case CorporateName.refname:
                case CorporateName.shortname:
                    corporateName = new CorporateName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;CopyrightOwner&gt; or &lt;copyrightowner&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private CopyrightOwnerIdentifier copyrightOwnerIdentifier = CopyrightOwnerIdentifier.EMPTY;

    /**
     * <p>
     * A group of data elements which together represent a coded identification of a copyright owner. Optional, and
     * non-repeating. May be sent either instead of or as well as a name.
     * </p>
     * Jonix-Comment: this field is required
     */
    public CopyrightOwnerIdentifier copyrightOwnerIdentifier() {
        _initialize();
        return copyrightOwnerIdentifier;
    }

    private PersonName personName = PersonName.EMPTY;

    /**
     * <p>
     * The name of a person, used here for a personal copyright owner. Optional and non-repeating. Each occurrence of
     * the &lt;CopyrightOwner&gt; composite may carry a single name (personal or corporate), or an identifier, or both a
     * name and an identifier.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PersonName personName() {
        _initialize();
        return personName;
    }

    private CorporateName corporateName = CorporateName.EMPTY;

    /**
     * <p>
     * The name of a corporate body, used here for a corporate copyright owner. Optional and non-repeating. Each
     * occurrence of the &lt;CopyrightOwner&gt; composite may carry a single name (personal or corporate), or an
     * identifier, or both a name and an identifier.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CorporateName corporateName() {
        _initialize();
        return corporateName;
    }
}
