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
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixProfessionalAffiliation;

import java.io.Serializable;
import java.util.Arrays;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Professional affiliation composite</h1>
 * <p>
 * A repeatable group of data elements which together identify a contributor’s professional position and/or affiliation,
 * allowing multiple positions and affiliations to be specified.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProfessionalAffiliation&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;professionalaffiliation&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Contributor}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Contributor} ⯈ {@link ProfessionalAffiliation}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation}</li>
 * <li>{@link ONIXMessage} ⯈ {@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link ProfessionalAffiliation}</li>
 * <li>{@link ONIXMessage} ⯈ {@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link ProfessionalAffiliation}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation}</li>
 * </ul>
 *
 * @since Onix-2.1
 */
public class ProfessionalAffiliation implements OnixDataComposite<JonixProfessionalAffiliation>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProfessionalAffiliation";
    public static final String shortname = "professionalaffiliation";

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
    public static final ProfessionalAffiliation EMPTY = new ProfessionalAffiliation();

    public ProfessionalAffiliation() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ProfessionalAffiliation(org.w3c.dom.Element element) {
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
                case ProfessionalPosition.refname:
                case ProfessionalPosition.shortname:
                    professionalPosition = new ProfessionalPosition(e);
                    break;
                case Affiliation.refname:
                case Affiliation.shortname:
                    affiliation = new Affiliation(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ProfessionalAffiliation&gt; or &lt;professionalaffiliation&gt;) is explicitly
     *         provided in the ONIX XML
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

    private ProfessionalPosition professionalPosition = ProfessionalPosition.EMPTY;

    /**
     * <p>
     * A professional position held by a contributor to the product at the time of its creation. Optional and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ProfessionalPosition professionalPosition() {
        _initialize();
        return professionalPosition;
    }

    private Affiliation affiliation = Affiliation.EMPTY;

    /**
     * <p>
     * An organisation to which a contributor to the product was affiliated at the time of its creation, and – if the
     * &lt;ProfessionalPosition&gt; element is also present – where s/he held that position. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Affiliation affiliation() {
        _initialize();
        return affiliation;
    }

    @Override
    public JonixProfessionalAffiliation asStruct() {
        _initialize();
        JonixProfessionalAffiliation struct = new JonixProfessionalAffiliation();
        struct.affiliation = affiliation.value;
        struct.professionalPositions = Arrays.asList(professionalPosition.value);
        return struct;
    }
}
