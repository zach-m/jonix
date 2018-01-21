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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixSenderIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sender composite</h1><p>A group of data elements which together specify the sender of an ONIX for Books message.
 * Mandatory in any ONIX for Books message, and non-repeating.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;Sender&gt;</td></tr><tr><td>Short tag</td><td>&lt;sender&gt;</td></tr><tr><td>Cardinality</td><td>1</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    public String sourcename;

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
                case EmailAddress.refname:
                case EmailAddress.shortname:
                    emailAddress = new EmailAddress(e);
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ListOfOnixDataCompositeWithKey<SenderIdentifier, JonixSenderIdentifier, NameCodeTypes> senderIdentifiers =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<SenderIdentifier, JonixSenderIdentifier, NameCodeTypes> senderIdentifiers() {
        _initialize();
        return senderIdentifiers;
    }

    private SenderName senderName = SenderName.EMPTY;

    /**
     * (this field is optional)
     */
    public SenderName senderName() {
        _initialize();
        return senderName;
    }

    private ContactName contactName = ContactName.EMPTY;

    /**
     * (this field is optional)
     */
    public ContactName contactName() {
        _initialize();
        return contactName;
    }

    private EmailAddress emailAddress = EmailAddress.EMPTY;

    /**
     * (this field is optional)
     */
    public EmailAddress emailAddress() {
        _initialize();
        return emailAddress;
    }
}
