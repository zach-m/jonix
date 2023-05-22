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
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixSupplierIdentifier;
import com.tectonica.jonix.common.struct.JonixWebsite;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>New supplier composite</h1>
 * <p>
 * An optional group of data elements which together specify a new supply source to which orders are referred. Use only
 * when the code in &lt;ProductAvailability&gt; indicates ‘no longer available from us, refer to new supplier’. Only one
 * occurrence of the composite is permitted in this context.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;NewSupplier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;newsupplier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link NewSupplier}</li>
 * </ul>
 */
public class NewSupplier implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "NewSupplier";
    public static final String shortname = "newsupplier";

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
    public static final NewSupplier EMPTY = new NewSupplier();

    public NewSupplier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public NewSupplier(org.w3c.dom.Element element) {
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
                case SupplierIdentifier.refname:
                case SupplierIdentifier.shortname:
                    supplierIdentifiers = JPU.addToList(supplierIdentifiers, new SupplierIdentifier(e));
                    break;
                case SupplierName.refname:
                case SupplierName.shortname:
                    supplierName = new SupplierName(e);
                    break;
                case TelephoneNumber.refname:
                case TelephoneNumber.shortname:
                    telephoneNumbers = JPU.addToList(telephoneNumbers, new TelephoneNumber(e));
                    break;
                case FaxNumber.refname:
                case FaxNumber.shortname:
                    faxNumbers = JPU.addToList(faxNumbers, new FaxNumber(e));
                    break;
                case EmailAddress.refname:
                case EmailAddress.shortname:
                    emailAddresss = JPU.addToList(emailAddresss, new EmailAddress(e));
                    break;
                case Website.refname:
                case Website.shortname:
                    websites = JPU.addToList(websites, new Website(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;NewSupplier&gt; or &lt;newsupplier&gt;) is explicitly provided in the ONIX XML
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

    private ListOfOnixDataCompositeWithKey<SupplierIdentifier, JonixSupplierIdentifier,
        SupplierIdentifierTypes> supplierIdentifiers =
            JPU.emptyListOfOnixDataCompositeWithKey(SupplierIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define the identity of a supplier in accordance with a specified scheme,
     * and repeatable to allow different types of supplier identifier to be included without defining additional data
     * elements. Optional, but each occurrence of the &lt;NewSupplier&gt; composite must carry <em>either</em> at least
     * one supplier identifier, <em>or</em> a &lt;SupplierName&gt;, <em>or</em> both.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<SupplierIdentifier, JonixSupplierIdentifier, SupplierIdentifierTypes>
        supplierIdentifiers() {
        _initialize();
        return supplierIdentifiers;
    }

    private SupplierName supplierName = SupplierName.EMPTY;

    /**
     * <p>
     * The name of a new supplier. Optional and non-repeating; required if no supplier identifier is sent in an
     * occurrence of the &lt;NewSupplier&gt; composite.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SupplierName supplierName() {
        _initialize();
        return supplierName;
    }

    private ListOfOnixElement<TelephoneNumber, String> telephoneNumbers =
        JPU.emptyListOfOnixElement(TelephoneNumber.class);

    /**
     * <p>
     * A telephone number of a supply source from which the product may be ordered by a trade customer. Optional and
     * repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<TelephoneNumber, String> telephoneNumbers() {
        _initialize();
        return telephoneNumbers;
    }

    private ListOfOnixElement<FaxNumber, String> faxNumbers = JPU.emptyListOfOnixElement(FaxNumber.class);

    /**
     * <p>
     * A fax number of a supply source from which the product may be ordered by a trade customer. Optional and
     * repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<FaxNumber, String> faxNumbers() {
        _initialize();
        return faxNumbers;
    }

    private ListOfOnixElement<EmailAddress, String> emailAddresss = JPU.emptyListOfOnixElement(EmailAddress.class);

    /**
     * <p>
     * An e‑mail address for a supply source from which the product may be ordered by a trade customer. Optional and
     * repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EmailAddress, String> emailAddresss() {
        _initialize();
        return emailAddresss;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = JPU.emptyListOfOnixDataComposite(Website.class);

    /**
     * <p>
     * An optional group of data elements which together identify and provide a pointer to a website which is related to
     * the organization identified in an occurrence of the &lt;NewSupplier&gt; composite. Repeatable in order to provide
     * links to multiple websites.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }
}
