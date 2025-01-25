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
 * <h1>Supplier composite</h1>
 * <p>
 * A group of data elements which together identify a specific supplier. Mandatory in each occurrence of the
 * &lt;SupplyDetail&gt; composite, and not repeatable.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Supplier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;supplier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Supplier&gt; from the schema author:
 *
 * Details of a supplier of the product, eg a distributor or wholesaler which supplies to retailers (or for digital
 * products, a retail platform)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Supplier}</li>
 * </ul>
 */
public class Supplier implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Supplier";
    public static final String shortname = "supplier";

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
    public static final Supplier EMPTY = new Supplier();

    public Supplier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Supplier(org.w3c.dom.Element element) {
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
                case SupplierRole.refname:
                case SupplierRole.shortname:
                    supplierRole = new SupplierRole(e);
                    break;
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
     * @return whether this tag (&lt;Supplier&gt; or &lt;supplier&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Supplier> action) {
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

    private SupplierRole supplierRole = SupplierRole.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the role of the supplier in relation to the product, <i>eg</i> Publisher, Publisher’s
     * exclusive distributor, <i>etc</i>. Mandatory in each occurrence of the &lt;Supplier&gt; composite, and
     * non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public SupplierRole supplierRole() {
        _initialize();
        return supplierRole;
    }

    private ListOfOnixDataCompositeWithKey<SupplierIdentifier, JonixSupplierIdentifier,
        SupplierIdentifierTypes> supplierIdentifiers =
            JPU.emptyListOfOnixDataCompositeWithKey(SupplierIdentifier.class);

    /**
     * <p>
     * A group of data elements which together specify an identifier of the supplier in accordance with a specified
     * scheme, and repeatable to allow different types of supplier identifier to be included without defining additional
     * data elements. Optional, but each occurrence of the &lt;Supplier&gt; composite must carry <em>either</em> at
     * least one supplier identifier, <em>or</em> a &lt;SupplierName&gt;, <em>or</em> both.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<SupplierIdentifier, JonixSupplierIdentifier, SupplierIdentifierTypes>
        supplierIdentifiers() {
        _initialize();
        return supplierIdentifiers;
    }

    private SupplierName supplierName = SupplierName.EMPTY;

    /**
     * <p>
     * The name of a supply source from which the product may be ordered by a trade customer. Optional and
     * non-repeating; required if no supplier identifier is sent.
     * </p>
     * JONIX adds: this field is optional
     */
    public SupplierName supplierName() {
        _initialize();
        return supplierName;
    }

    private ListOfOnixElement<TelephoneNumber, String> telephoneNumbers = ListOfOnixElement.empty();

    /**
     * <p>
     * A telephone number of a supply source from which the product may be ordered by a trade customer. Optional and
     * repeatable. Deprecated in this context, in favor of providing contact details in the &lt;SupplyContact&gt;
     * composite.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<TelephoneNumber, String> telephoneNumbers() {
        _initialize();
        return telephoneNumbers;
    }

    private ListOfOnixElement<FaxNumber, String> faxNumbers = ListOfOnixElement.empty();

    /**
     * <p>
     * A fax number of a supply source from which the product may be ordered by a trade customer. Optional and
     * repeatable. Deprecated in this context, in favor of providing contact details in the &lt;SupplyContact&gt;
     * composite.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<FaxNumber, String> faxNumbers() {
        _initialize();
        return faxNumbers;
    }

    private ListOfOnixElement<EmailAddress, String> emailAddresss = ListOfOnixElement.empty();

    /**
     * <p>
     * An e-mail address for a supply source from which the product may be ordered by a trade customer. Optional and
     * repeatable. Deprecated in this context, in favor of providing contact details in the &lt;SupplyContact&gt;
     * composite.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<EmailAddress, String> emailAddresss() {
        _initialize();
        return emailAddresss;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = JPU.emptyListOfOnixDataComposite(Website.class);

    /**
     * <p>
     * An optional group of data elements which together identify and provide a pointer to a website which is related to
     * the organization identified in an occurrence of the &lt;Supplier&gt; composite. Repeatable in order to provide
     * links to multiple websites.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }
}
