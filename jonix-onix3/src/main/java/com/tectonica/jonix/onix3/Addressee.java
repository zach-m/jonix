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
import com.tectonica.jonix.common.struct.JonixAddresseeIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Addressee composite</h1>
 * <p>
 * A group of data elements which together specify the addressee of an ONIX for Books message. Optional, and repeatable
 * if there are several addressees.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Addressee&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;addressee&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Addressee&gt; from the schema author:
 *
 * Details of the intended recipient organization(s) for the ONIX message &#9679; Added &lt;TelephoneNumber&gt; at 3.0.8
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Header}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Header} ⯈ {@link Addressee}</li>
 * </ul>
 */
public class Addressee implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Addressee";
    public static final String shortname = "addressee";

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
    public static final Addressee EMPTY = new Addressee();

    public Addressee() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Addressee(org.w3c.dom.Element element) {
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
                case AddresseeIdentifier.refname:
                case AddresseeIdentifier.shortname:
                    addresseeIdentifiers = JPU.addToList(addresseeIdentifiers, new AddresseeIdentifier(e));
                    break;
                case AddresseeName.refname:
                case AddresseeName.shortname:
                    addresseeName = new AddresseeName(e);
                    break;
                case ContactName.refname:
                case ContactName.shortname:
                    contactName = new ContactName(e);
                    break;
                case TelephoneNumber.refname:
                case TelephoneNumber.shortname:
                    telephoneNumber = new TelephoneNumber(e);
                    break;
                case EmailAddress.refname:
                case EmailAddress.shortname:
                    emailAddress = new EmailAddress(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Addressee&gt; or &lt;addressee&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Addressee> action) {
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

    private ListOfOnixDataCompositeWithKey<AddresseeIdentifier, JonixAddresseeIdentifier,
        NameIdentifierTypes> addresseeIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(AddresseeIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define an identifier of the addressee. The composite is optional, and
     * repeatable if more than one identifier of different types for the same addressee is sent; but <em>either</em> an
     * &lt;AddresseeName&gt; <em>or</em> an &lt;AddresseeIdentifier&gt; <em>must</em> be included.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<AddresseeIdentifier, JonixAddresseeIdentifier, NameIdentifierTypes>
        addresseeIdentifiers() {
        _initialize();
        return addresseeIdentifiers;
    }

    private AddresseeName addresseeName = AddresseeName.EMPTY;

    /**
     * <p>
     * The name of the addressee organization, which should always be stated in a standard form agreed with the
     * addressee. Optional and non-repeating; but <em>either</em> a &lt;AddresseeName&gt; element <em>or</em> a
     * &lt;AddresseeIdentifier&gt; composite <em>must</em> be included.
     * </p>
     * JONIX adds: this field is optional
     */
    public AddresseeName addresseeName() {
        _initialize();
        return addresseeName;
    }

    private ContactName contactName = ContactName.EMPTY;

    /**
     * <p>
     * Free text giving the name, department, <i>etc</i> for a contact person in the addressee organization to whom the
     * message is to be directed. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ContactName contactName() {
        _initialize();
        return contactName;
    }

    private TelephoneNumber telephoneNumber = TelephoneNumber.EMPTY;

    /**
     * <p>
     * A telephone number of the contact person in the addressee organization, wherever possible including the plus sign
     * and the international dialling code. Optional, and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public TelephoneNumber telephoneNumber() {
        _initialize();
        return telephoneNumber;
    }

    private EmailAddress emailAddress = EmailAddress.EMPTY;

    /**
     * <p>
     * A text field giving the e-mail address for a contact person in the addressee organization. Optional and
     * non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public EmailAddress emailAddress() {
        _initialize();
        return emailAddress;
    }
}
