/*
 * Copyright (C) 2012-2020 Zach Melamed
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
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixProfessionalAffiliation;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Professional affiliation composite</h1>
 * <p>
 * An optional group of data elements which together identify a contributor’s professional position and/or affiliation,
 * repeatable to allow multiple positions and affiliations to be specified.
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
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Contributor}&gt;</li>
 * <li>&lt;{@link NameAsSubject}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor}
 * ⯈ {@link ProfessionalAffiliation}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link NameAsSubject} ⯈
 * {@link ProfessionalAffiliation}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link NameAsSubject} ⯈
 * {@link ProfessionalAffiliation}</li>
 * </ul>
 */
public class ProfessionalAffiliation implements OnixDataComposite<JonixProfessionalAffiliation>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProfessionalAffiliation";
    public static final String shortname = "professionalaffiliation";

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
                case ProfessionalPosition.refname:
                case ProfessionalPosition.shortname:
                    professionalPositions = JPU.addToList(professionalPositions, new ProfessionalPosition(e));
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

    private ListOfOnixElement<ProfessionalPosition, String> professionalPositions = ListOfOnixElement.empty();

    /**
     * <p>
     * A professional position held by a contributor to the product <em>at the time of its creation</em>. Optional, and
     * repeatable to provide parallel text in multiple languages. The <i>language</i> attribute is optional for a single
     * instance of &lt;ProfessionalPosition&gt;, but must be included in each instance if &lt;ProfessionalPosition&gt;
     * is repeated.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<ProfessionalPosition, String> professionalPositions() {
        _initialize();
        return professionalPositions;
    }

    private Affiliation affiliation = Affiliation.EMPTY;

    /**
     * <p>
     * An organization to which a contributor to the product was affiliated <em>at the time of its creation</em>, and –
     * if the &lt;ProfessionalPosition&gt; element is also present – where s/he held that position. Optional and
     * non-repeating.
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
        struct.professionalPositions = professionalPositions.values();
        return struct;
    }
}
