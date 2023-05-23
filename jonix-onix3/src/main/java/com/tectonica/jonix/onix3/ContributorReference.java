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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixCodelist;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.ContributorRoles;
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixNameIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Contributor by reference composite</h1>
 * <p>
 * Optional composite that identifies a contributor – a person or corporate body – participating in the promotional
 * event <em>who is also a contributor to the product, or who is its subject</em> (<i>ie</i> who is fully described in
 * an instance of the &lt;Contributor&gt; composite within Groups&nbsp;P.5, P.7 or&nbsp;P.18, or in an instance of
 * &lt;NameAsSubject&gt; within Groups&nbsp;P.12 or&nbsp;P.18, in the same Product record). Repeatable to refer to
 * multiple contributors.
 * </p>
 * <p>
 * Note that an instance of &lt;PromotionalEvent&gt; may also contain one or more &lt;Contributor&gt; composites – the
 * latter listing participants to the event <em>who are not contributors to the product</em>.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ContributorReference&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;contributorreference&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PromotionalEvent}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link ContributorReference}</li>
 * </ul>
 *
 * @since Onix-3.07
 */
public class ContributorReference implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ContributorReference";
    public static final String shortname = "contributorreference";

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
    public static final ContributorReference EMPTY = new ContributorReference();

    public ContributorReference() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ContributorReference(org.w3c.dom.Element element) {
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
                case ContributorRole.refname:
                case ContributorRole.shortname:
                    contributorRoles = JPU.addToList(contributorRoles, new ContributorRole(e));
                    break;
                case NameIdentifier.refname:
                case NameIdentifier.shortname:
                    nameIdentifiers = JPU.addToList(nameIdentifiers, new NameIdentifier(e));
                    break;
                case SequenceNumber.refname:
                case SequenceNumber.shortname:
                    sequenceNumber = new SequenceNumber(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ContributorReference&gt; or &lt;contributorreference&gt;) is explicitly provided in
     *         the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ContributorReference> action) {
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

    private ListOfOnixCodelist<ContributorRole, ContributorRoles> contributorRoles = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code indicating the role played by a person or corporate body participating in a promotional event, which
     * need not be the same role as specified for the contributor referenced in Groups&nbsp;P.5, P.7 or&nbsp;P.18.
     * Mandatory in each instance of the &lt;ContributorReference&gt; composite, and may be repeated if the same person
     * or corporate body has more than one role in relation to the event.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixCodelist<ContributorRole, ContributorRoles> contributorRoles() {
        _initialize();
        return contributorRoles;
    }

    private ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameIdentifierTypes> nameIdentifiers =
        JPU.emptyListOfOnixDataCompositeWithKey(NameIdentifier.class);

    /**
     * <p>
     * A group of data elements which together specify a name identifier, used here to carry an identifier for a
     * personal or organizational name which <em>must</em> match a name identifier in an instance of the
     * &lt;Contributor&gt; composite within Groups&nbsp;P.5, P.7 or P.18, or in an instance of &lt;NameAsSubject&gt;
     * within Groups&nbsp;P.12 or&nbsp;P.18, in the same Product record. The &lt;NameIdentifier&gt; composite is
     * mandatory within each instance of the &lt;ContributorReference&gt; composite, and is repeatable to specify name
     * identifiers of different types for the same person or organization name.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameIdentifierTypes> nameIdentifiers() {
        _initialize();
        return nameIdentifiers;
    }

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * <p>
     * A number which specifies a single overall sequence of event participant names. Optional and non-repeating. It is
     * strongly recommended that each occurrence of the &lt;ContributorReference&gt; and &lt;Contributor&gt; composites
     * within &lt;PromotionalEvent&gt; should carry a &lt;SequenceNumber&gt;. The sequence is independent of the
     * sequence of contributors to the product specified in Groups&nbsp;P.5, P.7 or&nbsp;P.18.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SequenceNumber sequenceNumber() {
        _initialize();
        return sequenceNumber;
    }
}
