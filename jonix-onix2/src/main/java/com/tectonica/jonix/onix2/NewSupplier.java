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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixSupplierIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>New supplier composite</h1>
 * <p>
 * A group of data elements which together specify a new supply source to which orders are referred. Use only when the
 * code in &lt;ProductAvailability&gt; or &lt;AvailabilityCode&gt; indicates “no longer available from us, refer to new
 * supplier”. Only one occurrence of the composite is permitted in this context.
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
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;SupplyDetail&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ SupplyDetail ⯈ NewSupplier</li>
 * </ul>
 */
public class NewSupplier implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "NewSupplier";
    public static final String shortname = "newsupplier";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
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
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
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
                case SupplierIdentifier.refname:
                case SupplierIdentifier.shortname:
                    supplierIdentifiers = JPU.addToList(supplierIdentifiers, new SupplierIdentifier(e));
                    break;
                case SupplierSAN.refname:
                case SupplierSAN.shortname:
                    supplierSAN = new SupplierSAN(e);
                    break;
                case SupplierEANLocationNumber.refname:
                case SupplierEANLocationNumber.shortname:
                    supplierEANLocationNumber = new SupplierEANLocationNumber(e);
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

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ListOfOnixDataCompositeWithKey<SupplierIdentifier, JonixSupplierIdentifier, SupplierIdentifierTypes>
        supplierIdentifiers = ListOfOnixDataCompositeWithKey
        .emptyKeyed();

    /**
     * <p>
     * A repeatable group of data elements which together define the identifier of a supplier in accordance with a
     * specified scheme, and allowing different types of supplier identifier to be included without defining additional
     * data elements. Optional, but each occurrence of the &lt;NewSupplier&gt; composite must carry either at least one
     * supplier identifier, or a &lt;SupplierName&gt;.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<SupplierIdentifier, JonixSupplierIdentifier, SupplierIdentifierTypes> supplierIdentifiers() {
        _initialize();
        return supplierIdentifiers;
    }

    private SupplierSAN supplierSAN = SupplierSAN.EMPTY;

    /**
     * <p>
     * A book trade Standard Address Number identifying a supplier. Used in the US and UK. Optional, but each occurrence
     * of the &lt;NewSupplier&gt; composite must carry either at least one supplier identifier, or a
     * &lt;SupplierName&gt;.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SupplierSAN supplierSAN() {
        _initialize();
        return supplierSAN;
    }

    private SupplierEANLocationNumber supplierEANLocationNumber = SupplierEANLocationNumber.EMPTY;

    /**
     * <p>
     * An EAN-13 location number identifying a supplier. Now also known as an “EAN-UCC Global Location Number” or GLN.
     * Optional and non-repeating, but each occurrence of the &lt;NewSupplier&gt; composite must carry either at least
     * one supplier identifier, or a &lt;SupplierName&gt;.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SupplierEANLocationNumber supplierEANLocationNumber() {
        _initialize();
        return supplierEANLocationNumber;
    }

    private SupplierName supplierName = SupplierName.EMPTY;

    /**
     * <p>
     * The name of a supplier. Optional and non-repeating; required if no supplier identifier is sent in an occurrence
     * of the &lt;NewSupplier&gt; composite.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SupplierName supplierName() {
        _initialize();
        return supplierName;
    }

    private ListOfOnixElement<TelephoneNumber, String> telephoneNumbers = ListOfOnixElement.empty();

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

    private ListOfOnixElement<FaxNumber, String> faxNumbers = ListOfOnixElement.empty();

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

    private ListOfOnixElement<EmailAddress, String> emailAddresss = ListOfOnixElement.empty();

    /**
     * <p>
     * An email address for a supply source from which the product may be ordered by a trade customer. Optional and
     * repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EmailAddress, String> emailAddresss() {
        _initialize();
        return emailAddresss;
    }
}
