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
 * Technical notes about &lt;ProfessionalAffiliation&gt; from the schema author:
 *
 * Details of a professional position held by a contributor to the product at the time of its creation &#9679; Added
 * &lt;AffiliationIdentifier&gt; at release 3.1 &#9679; Modified cardinality of &lt;ProfessionalPosition&gt; at revision
 * 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Contributor}&gt;</li>
 * <li>&lt;{@link NameAsSubject}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link ProfessionalAffiliation}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈
 * {@link ProfessionalAffiliation}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link NameAsSubject} ⯈ {@link ProfessionalAffiliation}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link NameAsSubject} ⯈
 * {@link ProfessionalAffiliation}</li>
 * </ul>
 */
public class ProfessionalAffiliation implements OnixSuperComposite, Serializable {
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
                case AffiliationIdentifier.refname:
                case AffiliationIdentifier.shortname:
                    affiliationIdentifiers = JPU.addToList(affiliationIdentifiers, new AffiliationIdentifier(e));
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

    public void ifExists(Consumer<ProfessionalAffiliation> action) {
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

    private ListOfOnixElement<ProfessionalPosition, String> professionalPositions = ListOfOnixElement.empty();

    /**
     * <p>
     * A professional position held by a contributor to the product <em>at the time of its creation</em>. Optional, and
     * repeatable to provide parallel text in multiple languages. The <i>language</i> attribute is optional for a single
     * instance of &lt;ProfessionalPosition&gt;, but must be included in each instance if &lt;ProfessionalPosition&gt;
     * is repeated.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixElement<ProfessionalPosition, String> professionalPositions() {
        _initialize();
        return professionalPositions;
    }

    private Affiliation affiliation = Affiliation.EMPTY;

    /**
     * <p>
     * An organization to which a contributor to the product was affiliated <em>at the time of its creation</em>,
     * and&nbsp;– if the &lt;ProfessionalPosition&gt; element is also present&nbsp;– where the contributor held that
     * position. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public Affiliation affiliation() {
        _initialize();
        return affiliation;
    }

    private ListOfOnixDataCompositeWithKey<AffiliationIdentifier, JonixAffiliationIdentifier,
        NameIdentifierTypes> affiliationIdentifiers =
            JPU.emptyListOfOnixDataCompositeWithKey(AffiliationIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define an identifier for an organization to which the contributor to the
     * product was affiliated <em>at the time of its creation</em>, and&nbsp;– if the &lt;ProfessionalPosition&gt;
     * element is also present&nbsp;– where the contributor held that position. Optional, and repeatable to specify
     * organization identifiers of different types for the same organization.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<AffiliationIdentifier, JonixAffiliationIdentifier, NameIdentifierTypes>
        affiliationIdentifiers() {
        _initialize();
        return affiliationIdentifiers;
    }
}
