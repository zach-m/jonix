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
 * <h1>Product contact composite</h1>
 * <p>
 * An optional group of data elements which together specify an organization (which may or may not be the publisher)
 * responsible for dealing with enquiries related to the product. Repeatable in order to specify multiple responsible
 * organizations.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductContact&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;productcontact&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ProductContact&gt; from the schema author:
 *
 * Details of a organization responsible for answering enquiries about the product &#9679; Added &lt;StreetAddress&gt;,
 * &lt;LocationName&gt;, &lt;PostalCode&gt;, &lt;RegionCode&gt; and &lt;CountryCode&gt; at revision 3.1.2 &#9679; Added
 * &lt;FaxNumber&gt;, changed cardinality of &lt;EmailAddress&gt; at release 3.1 &#9679; Added &lt;TelephoneNumber&gt;
 * at revision 3.0.8 &#9679; Added at revision 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PublishingDetail}&gt;</li>
 * <li>&lt;{@link MarketPublishingDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link ProductContact}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link MarketPublishingDetail} ⯈ {@link ProductContact}</li>
 * </ul>
 *
 * @since Onix-3.01
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
                case StreetAddress.refname:
                case StreetAddress.shortname:
                    streetAddress = new StreetAddress(e);
                    break;
                case LocationName.refname:
                case LocationName.shortname:
                    locationName = new LocationName(e);
                    break;
                case PostalCode.refname:
                case PostalCode.shortname:
                    postalCode = new PostalCode(e);
                    break;
                case RegionCode.refname:
                case RegionCode.shortname:
                    regionCode = new RegionCode(e);
                    break;
                case CountryCode.refname:
                case CountryCode.shortname:
                    countryCode = new CountryCode(e);
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
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ProductContact&gt; or &lt;productcontact&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ProductContact> action) {
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

    private ProductContactRole productContactRole = ProductContactRole.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the role played by the product contact in relation to the product&nbsp;– for
     * example answering enquiries related to sales or to promotion.
     * </p>
     * JONIX adds: this field is required
     */
    public ProductContactRole productContactRole() {
        _initialize();
        return productContactRole;
    }

    private ListOfOnixDataCompositeWithKey<ProductContactIdentifier, JonixProductContactIdentifier,
        NameIdentifierTypes> productContactIdentifiers =
            JPU.emptyListOfOnixDataCompositeWithKey(ProductContactIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define an identifier of the product contact. The composite is optional,
     * and repeatable if more than one identifier of different types is sent; but <em>either</em> a
     * &lt;ProductContactName&gt; <em>or</em> a &lt;ProductContactIdentifier&gt; <em>must</em> be included.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<ProductContactIdentifier, JonixProductContactIdentifier, NameIdentifierTypes>
        productContactIdentifiers() {
        _initialize();
        return productContactIdentifiers;
    }

    private ProductContactName productContactName = ProductContactName.EMPTY;

    /**
     * <p>
     * The name of the product contact organization, which should always be stated in a standard form. Optional and
     * non-repeating; but <em>either</em> a &lt;ProductContactName&gt; element <em>or</em> a
     * &lt;ProductContactIdentifier&gt; composite <em>must</em> be included.
     * </p>
     * JONIX adds: this field is optional
     */
    public ProductContactName productContactName() {
        _initialize();
        return productContactName;
    }

    private ContactName contactName = ContactName.EMPTY;

    /**
     * <p>
     * Free text giving the name, department, <i>etc</i> for a contact person in the product contact organization who is
     * responsible for the product. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ContactName contactName() {
        _initialize();
        return contactName;
    }

    private StreetAddress streetAddress = StreetAddress.EMPTY;

    /**
     * <p>
     * A text field giving a street address and forming the first part of the postal address of the product contact
     * organization. Optional and non-repeatable. Care should be taken that the Product contact name (plus optionally
     * the Contact name), Street address, Location name, any Postal code or Region code, and the Country code can be
     * combined into a complete postal address, without repetition.
     * </p>
     * JONIX adds: this field is optional
     */
    public StreetAddress streetAddress() {
        _initialize();
        return streetAddress;
    }

    private LocationName locationName = LocationName.EMPTY;

    /**
     * <p>
     * The name of a city or town location, forming part of the postal address of the product contact organization.
     * Mandatory and non-repeatable if a Street address is present, but otherwise omitted.
     * </p>
     * JONIX adds: this field is optional
     */
    public LocationName locationName() {
        _initialize();
        return locationName;
    }

    private PostalCode postalCode = PostalCode.EMPTY;

    /**
     * <p>
     * The postal code (postcode, zip code <i>etc</i>), forming part of the postal address of the product contact
     * organization. Optional and non-repeatable if a Street address is present, but otherwise omitted.
     * </p>
     * JONIX adds: this field is optional
     */
    public PostalCode postalCode() {
        _initialize();
        return postalCode;
    }

    private RegionCode regionCode = RegionCode.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the region within which the product contact organization is located. Optional and
     * non-repeatable if a Street address is present, but otherwise omitted.
     * </p>
     * <p>
     * For some addresses, a Region code is useful in addition to the Postal code and Country code. In other addresses,
     * a region is unnecessary because it is clearly encoded within the Postal code.
     * </p>
     * JONIX adds: this field is optional
     */
    public RegionCode regionCode() {
        _initialize();
        return regionCode;
    }

    private CountryCode countryCode = CountryCode.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the country within which the product contact organization is located. Mandatory and
     * non-repeatable if a Street address is present, but otherwise omitted.
     * </p>
     * JONIX adds: this field is optional
     */
    public CountryCode countryCode() {
        _initialize();
        return countryCode;
    }

    private ListOfOnixElement<TelephoneNumber, String> telephoneNumbers = ListOfOnixElement.empty();

    /**
     * <p>
     * A telephone number of the contact person in the product contact organization who is responsible for the product,
     * wherever possible including the plus sign and the international dialing code. Optional, and repeatable to provide
     * multiple numbers for the same contact.
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
     * A fax number for the contact person in the product contact organization who is responsible for the product,
     * wherever possible including the plus sign and the international dialing code. Optional, and repeatable to provide
     * multiple numbers for the same contact.
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
     * A text field giving the e‑mail address for a contact person in the product contact organization who is
     * responsible for the product. Optional, and repeatable to provide multiple e‑mail addresses for the same contact.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<EmailAddress, String> emailAddresss() {
        _initialize();
        return emailAddresss;
    }
}
