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
 * <h1>Supply contact composite</h1>
 * <p>
 * An optional group of data elements which together specify an organization (which may or may not be the supplier)
 * responsible for dealing with enquiries related to the product. Repeatable in order to specify multiple contacts.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SupplyContact&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;supplycontact&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;SupplyContact&gt; from the schema author:
 *
 * Details of an organization (which may or may not be the supplier) responsible for dealing with supply enquiries
 * related to the product &#9679; Added &lt;TelephoneNumber&gt; at 3.0.8 &#9679; Added at revision 3.0.4
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link SupplyContact}</li>
 * </ul>
 *
 * @since Onix-3.04
 */
public class SupplyContact implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SupplyContact";
    public static final String shortname = "supplycontact";

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
    public static final SupplyContact EMPTY = new SupplyContact();

    public SupplyContact() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SupplyContact(org.w3c.dom.Element element) {
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
                case SupplyContactRole.refname:
                case SupplyContactRole.shortname:
                    supplyContactRole = new SupplyContactRole(e);
                    break;
                case SupplyContactIdentifier.refname:
                case SupplyContactIdentifier.shortname:
                    supplyContactIdentifiers = JPU.addToList(supplyContactIdentifiers, new SupplyContactIdentifier(e));
                    break;
                case SupplyContactName.refname:
                case SupplyContactName.shortname:
                    supplyContactName = new SupplyContactName(e);
                    break;
                case ContactName.refname:
                case ContactName.shortname:
                    contactName = new ContactName(e);
                    break;
                case EmailAddress.refname:
                case EmailAddress.shortname:
                    emailAddress = new EmailAddress(e);
                    break;
                case TelephoneNumber.refname:
                case TelephoneNumber.shortname:
                    telephoneNumbers = JPU.addToList(telephoneNumbers, new TelephoneNumber(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SupplyContact&gt; or &lt;supplycontact&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<SupplyContact> action) {
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

    private SupplyContactRole supplyContactRole = SupplyContactRole.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the role played by the supply contact in relation to the product – for example
     * answering enquiries related to orders or to returns.
     * </p>
     * JONIX adds: this field is required
     */
    public SupplyContactRole supplyContactRole() {
        _initialize();
        return supplyContactRole;
    }

    private ListOfOnixDataCompositeWithKey<SupplyContactIdentifier, JonixSupplyContactIdentifier,
        NameIdentifierTypes> supplyContactIdentifiers =
            JPU.emptyListOfOnixDataCompositeWithKey(SupplyContactIdentifier.class);

    /**
     * <p>
     * A group of data elements which together specify an identifier for the supply contact. The composite is optional,
     * and repeatable if more than one identifier of different types is sent; but either a &lt;SupplyContactName&gt; or
     * a &lt;SupplyContactIdentifier&gt; <em>must</em> be included.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<SupplyContactIdentifier, JonixSupplyContactIdentifier, NameIdentifierTypes>
        supplyContactIdentifiers() {
        _initialize();
        return supplyContactIdentifiers;
    }

    private SupplyContactName supplyContactName = SupplyContactName.EMPTY;

    /**
     * <p>
     * The name of the supply contact organization, which should always be stated in a standard form. Optional and
     * non-repeating; but either a &lt;SupplyContactName&gt; element or a &lt;SupplyContactIdentifier&gt; composite must
     * be included.
     * </p>
     * JONIX adds: this field is optional
     */
    public SupplyContactName supplyContactName() {
        _initialize();
        return supplyContactName;
    }

    private ContactName contactName = ContactName.EMPTY;

    /**
     * <p>
     * Free text giving the name, department, <i>etc</i> for a contact person in the supply contact organization who is
     * responsible for the product. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ContactName contactName() {
        _initialize();
        return contactName;
    }

    private EmailAddress emailAddress = EmailAddress.EMPTY;

    /**
     * <p>
     * A text field giving the e-mail address for a contact person in the supply contact organization who is responsible
     * for the product. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public EmailAddress emailAddress() {
        _initialize();
        return emailAddress;
    }

    private ListOfOnixElement<TelephoneNumber, String> telephoneNumbers = ListOfOnixElement.empty();

    /**
     * <p>
     * A telephone number of the contact person in the supply contact organization who is responsible for the product,
     * wherever possible including the plus sign and the international dialling code. Optional, and repeatable to
     * provide multiple numbers for the same contact.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<TelephoneNumber, String> telephoneNumbers() {
        _initialize();
        return telephoneNumbers;
    }
}
