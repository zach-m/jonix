/*
 * Copyright (C) 2012-2022 Zach Melamed
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
import com.tectonica.jonix.common.struct.JonixSenderIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sender composite</h1>
 * <p>
 * A group of data elements which together specify the sender of an ONIX for Books message. Mandatory in any ONIX for
 * Books message, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Sender&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;sender&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Header}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Header} ⯈ {@link Sender}</li>
 * </ul>
 */
public class Sender implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Sender";
    public static final String shortname = "sender";

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
    public static final Sender EMPTY = new Sender();

    public Sender() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Sender(org.w3c.dom.Element element) {
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
                case SenderIdentifier.refname:
                case SenderIdentifier.shortname:
                    senderIdentifiers = JPU.addToList(senderIdentifiers, new SenderIdentifier(e));
                    break;
                case SenderName.refname:
                case SenderName.shortname:
                    senderName = new SenderName(e);
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
     * @return whether this tag (&lt;Sender&gt; or &lt;sender&gt;) is explicitly provided in the ONIX XML
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

    private ListOfOnixDataCompositeWithKey<SenderIdentifier, JonixSenderIdentifier,
        NameIdentifierTypes> senderIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * A group of data elements which together define an identifier of the sender. The composite is optional, and
     * repeatable if more than one identifier of different types is sent; but <em>either</em> a &lt;SenderName&gt;
     * <em>or</em> a &lt;SenderIdentifier&gt; <em>must</em> be included.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<SenderIdentifier, JonixSenderIdentifier, NameIdentifierTypes>
        senderIdentifiers() {
        _initialize();
        return senderIdentifiers;
    }

    private SenderName senderName = SenderName.EMPTY;

    /**
     * <p>
     * The name of the sender organization, which should always be stated in a standard form agreed with the addressee.
     * Optional and non-repeating; but <em>either</em> a &lt;SenderName&gt; element <em>or</em> a
     * &lt;SenderIdentifier&gt; composite <em>must</em> be included.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SenderName senderName() {
        _initialize();
        return senderName;
    }

    private ContactName contactName = ContactName.EMPTY;

    /**
     * <p>
     * Free text giving the name, department, <i>etc</i> for a contact person in the sender organization who is
     * responsible for the content of the message. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ContactName contactName() {
        _initialize();
        return contactName;
    }

    private TelephoneNumber telephoneNumber = TelephoneNumber.EMPTY;

    /**
     * <p>
     * A telephone number of the contact person in the sender organization, wherever possible including the plus sign
     * and the international dialling code. Optional, and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TelephoneNumber telephoneNumber() {
        _initialize();
        return telephoneNumber;
    }

    private EmailAddress emailAddress = EmailAddress.EMPTY;

    /**
     * <p>
     * A text field giving the e-mail address for a contact person in the sender organization who is responsible for the
     * content of the message. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EmailAddress emailAddress() {
        _initialize();
        return emailAddress;
    }
}
