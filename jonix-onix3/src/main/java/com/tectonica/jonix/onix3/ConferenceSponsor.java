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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixConferenceSponsorIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Conference sponsor composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together identify a sponsor of a conference. <em>Either</em>
 * an identifier, <em>or</em> one or other of &lt;PersonName&gt; or &lt;CorporateName&gt;, <em>or</em> both an
 * identifier and a name, must be present in each occurrence of the composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ConferenceSponsor&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;conferencesponsor&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ConferenceSponsor&gt; from the schema author:
 *
 * &#9679; Deprecated - use &lt;EventSponsor&gt; instead
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Conference}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Conference} ⯈ {@link ConferenceSponsor}</li>
 * </ul>
 *
 * @deprecated
 */
@Deprecated
public class ConferenceSponsor implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ConferenceSponsor";
    public static final String shortname = "conferencesponsor";

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
    public static final ConferenceSponsor EMPTY = new ConferenceSponsor();

    public ConferenceSponsor() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ConferenceSponsor(org.w3c.dom.Element element) {
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
                case ConferenceSponsorIdentifier.refname:
                case ConferenceSponsorIdentifier.shortname:
                    conferenceSponsorIdentifiers =
                        JPU.addToList(conferenceSponsorIdentifiers, new ConferenceSponsorIdentifier(e));
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
     * @return whether this tag (&lt;ConferenceSponsor&gt; or &lt;conferencesponsor&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ConferenceSponsor> action) {
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

    private ListOfOnixDataCompositeWithKey<ConferenceSponsorIdentifier, JonixConferenceSponsorIdentifier,
        NameIdentifierTypes> conferenceSponsorIdentifiers =
            JPU.emptyListOfOnixDataCompositeWithKey(ConferenceSponsorIdentifier.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together carry a coded identifier for a sponsor of a
     * conference.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<ConferenceSponsorIdentifier, JonixConferenceSponsorIdentifier,
        NameIdentifierTypes> conferenceSponsorIdentifiers() {
        _initialize();
        return conferenceSponsorIdentifiers;
    }

    private PersonName personName = PersonName.EMPTY;

    /**
     * <p>
     * The name of a person, used here for a personal sponsor of a conference. Optional and non-repeating. Only one of
     * &lt;PersonName&gt; and &lt;CorporateName&gt; can be sent in each occurrence of the &lt;ConferenceSponsor&gt;
     * composite.
     * </p>
     * JONIX adds: this field is optional
     */
    public PersonName personName() {
        _initialize();
        return personName;
    }

    private CorporateName corporateName = CorporateName.EMPTY;

    /**
     * <p>
     * The name of a corporate body, used here for a corporate sponsor of a conference. Optional and non-repeating. Only
     * one of &lt;PersonName&gt; and &lt;CorporateName&gt; can be sent in each occurrence of the
     * &lt;ConferenceSponsor&gt; composite.
     * </p>
     * JONIX adds: this field is optional
     */
    public CorporateName corporateName() {
        _initialize();
        return corporateName;
    }
}
