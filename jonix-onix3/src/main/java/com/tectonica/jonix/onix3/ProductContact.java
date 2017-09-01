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
import com.tectonica.jonix.struct.JonixProductContactIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product contact composite</h1><p>A group of data elements which together specify an organization (which may or
 * may not be the publisher’s representative) responsible for dealing with enquiries related to the product in the
 * market.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;ProductContact&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;productcontact&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class ProductContact implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductContact";
    public static final String shortname = "productcontact";

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
    public static final ProductContact EMPTY = new ProductContact();

    public ProductContact() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ProductContact(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case ProductContactRole.refname:
                case ProductContactRole.shortname:
                    productContactRole = new ProductContactRole(e);
                    break;
                case ProductContactIdentifier.refname:
                case ProductContactIdentifier.shortname:
                    productContactIdentifiers =
                        JPU.addToList(productContactIdentifiers, new ProductContactIdentifier(e));
                    break;
                case ProductContactName.refname:
                case ProductContactName.shortname:
                    productContactName = new ProductContactName(e);
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

    private ProductContactRole productContactRole = ProductContactRole.EMPTY;

    /**
     * (this field is required)
     */
    public ProductContactRole productContactRole() {
        initialize();
        return productContactRole;
    }

    private ListOfOnixDataCompositeWithKey<ProductContactIdentifier, JonixProductContactIdentifier, NameCodeTypes>
        productContactIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<ProductContactIdentifier, JonixProductContactIdentifier, NameCodeTypes> productContactIdentifiers() {
        initialize();
        return productContactIdentifiers;
    }

    private ProductContactName productContactName = ProductContactName.EMPTY;

    /**
     * (this field is optional)
     */
    public ProductContactName productContactName() {
        initialize();
        return productContactName;
    }

    private ContactName contactName = ContactName.EMPTY;

    /**
     * (this field is optional)
     */
    public ContactName contactName() {
        initialize();
        return contactName;
    }

    private EmailAddress emailAddress = EmailAddress.EMPTY;

    /**
     * (this field is optional)
     */
    public EmailAddress emailAddress() {
        initialize();
        return emailAddress;
    }
}
