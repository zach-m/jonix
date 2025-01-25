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
import com.tectonica.jonix.common.struct.JonixCopyrightOwnerIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Copyright owner composite</h1>
 * <p>
 * A repeatable group of data elements which together name a copyright owner. Optional, but may be omitted only if
 * &lt;CopyrightYear&gt; is present. Each occurrence of the &lt;CopyrightOwner&gt; composite must carry a single name
 * (personal or corporate), or an identifier, or both.
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
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;CopyrightOwner&gt; from the schema author:
 *
 * Name of and/or identifier for a copyright or neighbouring rightsholder
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link CopyrightStatement}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link CopyrightStatement} ⯈
 * {@link CopyrightOwner}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link CopyrightStatement} ⯈ {@link CopyrightOwner}</li>
 * </ul>
 */
public class CopyrightOwner implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CopyrightOwner";
    public static final String shortname = "copyrightowner";

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
                case CopyrightOwnerIdentifier.refname:
                case CopyrightOwnerIdentifier.shortname:
                    copyrightOwnerIdentifiers =
                        JPU.addToList(copyrightOwnerIdentifiers, new CopyrightOwnerIdentifier(e));
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

    public void ifExists(Consumer<CopyrightOwner> action) {
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

    private ListOfOnixDataCompositeWithKey<CopyrightOwnerIdentifier, JonixCopyrightOwnerIdentifier,
        NameIdentifierTypes> copyrightOwnerIdentifiers =
            JPU.emptyListOfOnixDataCompositeWithKey(CopyrightOwnerIdentifier.class);

    /**
     * <p>
     * A group of data elements which together represent a coded identification of a copyright owner. Optional, and
     * repeatable if sending more than one identifier of different types. May be sent either instead of or as well as a
     * name.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<CopyrightOwnerIdentifier, JonixCopyrightOwnerIdentifier, NameIdentifierTypes>
        copyrightOwnerIdentifiers() {
        _initialize();
        return copyrightOwnerIdentifiers;
    }

    private PersonName personName = PersonName.EMPTY;

    /**
     * <p>
     * The name of a person, used here for a personal copyright owner. Optional and non-repeating. Each occurrence of
     * the &lt;CopyrightOwner&gt; composite may carry a single name (personal or corporate), or an identifier, or both a
     * name and an identifier.
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
     * The name of a corporate body, used here for a corporate copyright owner. Optional and non- repeating. Each
     * occurrence of the &lt;CopyrightOwner&gt; composite may carry a single name (personal or corporate), or an
     * identifier, or both a name and an identifier.
     * </p>
     * JONIX adds: this field is optional
     */
    public CorporateName corporateName() {
        _initialize();
        return corporateName;
    }
}
