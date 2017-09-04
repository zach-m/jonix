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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.OnixHeader;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixAddresseeIdentifier;
import com.tectonica.jonix.struct.JonixSenderIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Header composite</h1><p>A group of data elements which together constitute a message header. The elements may
 * alternatively be sent without being grouped into a composite, but the composite approach is recommended since it
 * makes it easier to maintain a standard header “package” to drop into any new ONIX Product Information Message.
 * <strong>Note that the Sender and Addressee Identifier composites can only be used within the Header composite, and
 * future extensions to the Header will be defined only within the composite.</strong></p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;Header&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;header&gt;</td></tr></table>
 */
public class Header implements OnixHeader, OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Header";
    public static final String shortname = "header";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public LanguageCodes language;

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
    public static final Header EMPTY = new Header();

    public Header() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Header(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case FromEANNumber.refname:
                case FromEANNumber.shortname:
                    fromEANNumber = new FromEANNumber(e);
                    break;
                case FromSAN.refname:
                case FromSAN.shortname:
                    fromSAN = new FromSAN(e);
                    break;
                case SenderIdentifier.refname:
                case SenderIdentifier.shortname:
                    senderIdentifiers = JPU.addToList(senderIdentifiers, new SenderIdentifier(e));
                    break;
                case FromCompany.refname:
                case FromCompany.shortname:
                    fromCompany = new FromCompany(e);
                    break;
                case FromPerson.refname:
                case FromPerson.shortname:
                    fromPerson = new FromPerson(e);
                    break;
                case FromEmail.refname:
                case FromEmail.shortname:
                    fromEmail = new FromEmail(e);
                    break;
                case ToEANNumber.refname:
                case ToEANNumber.shortname:
                    toEANNumber = new ToEANNumber(e);
                    break;
                case ToSAN.refname:
                case ToSAN.shortname:
                    toSAN = new ToSAN(e);
                    break;
                case AddresseeIdentifier.refname:
                case AddresseeIdentifier.shortname:
                    addresseeIdentifiers = JPU.addToList(addresseeIdentifiers, new AddresseeIdentifier(e));
                    break;
                case ToCompany.refname:
                case ToCompany.shortname:
                    toCompany = new ToCompany(e);
                    break;
                case ToPerson.refname:
                case ToPerson.shortname:
                    toPerson = new ToPerson(e);
                    break;
                case MessageNumber.refname:
                case MessageNumber.shortname:
                    messageNumber = new MessageNumber(e);
                    break;
                case MessageRepeat.refname:
                case MessageRepeat.shortname:
                    messageRepeat = new MessageRepeat(e);
                    break;
                case SentDate.refname:
                case SentDate.shortname:
                    sentDate = new SentDate(e);
                    break;
                case MessageNote.refname:
                case MessageNote.shortname:
                    messageNote = new MessageNote(e);
                    break;
                case DefaultLanguageOfText.refname:
                case DefaultLanguageOfText.shortname:
                    defaultLanguageOfText = new DefaultLanguageOfText(e);
                    break;
                case DefaultPriceTypeCode.refname:
                case DefaultPriceTypeCode.shortname:
                    defaultPriceTypeCode = new DefaultPriceTypeCode(e);
                    break;
                case DefaultCurrencyCode.refname:
                case DefaultCurrencyCode.shortname:
                    defaultCurrencyCode = new DefaultCurrencyCode(e);
                    break;
                case DefaultLinearUnit.refname:
                case DefaultLinearUnit.shortname:
                    defaultLinearUnit = new DefaultLinearUnit(e);
                    break;
                case DefaultWeightUnit.refname:
                case DefaultWeightUnit.shortname:
                    defaultWeightUnit = new DefaultWeightUnit(e);
                    break;
                case DefaultClassOfTrade.refname:
                case DefaultClassOfTrade.shortname:
                    defaultClassOfTrade = new DefaultClassOfTrade(e);
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

    private FromEANNumber fromEANNumber = FromEANNumber.EMPTY;

    /**
     * (this field is required)
     */
    public FromEANNumber fromEANNumber() {
        initialize();
        return fromEANNumber;
    }

    private FromSAN fromSAN = FromSAN.EMPTY;

    /**
     * (this field is optional)
     */
    public FromSAN fromSAN() {
        initialize();
        return fromSAN;
    }

    private ListOfOnixDataCompositeWithKey<SenderIdentifier, JonixSenderIdentifier, NameCodeTypes> senderIdentifiers =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<SenderIdentifier, JonixSenderIdentifier, NameCodeTypes> senderIdentifiers() {
        initialize();
        return senderIdentifiers;
    }

    private FromCompany fromCompany = FromCompany.EMPTY;

    /**
     * (this field is optional)
     */
    public FromCompany fromCompany() {
        initialize();
        return fromCompany;
    }

    private FromPerson fromPerson = FromPerson.EMPTY;

    /**
     * (this field is optional)
     */
    public FromPerson fromPerson() {
        initialize();
        return fromPerson;
    }

    private FromEmail fromEmail = FromEmail.EMPTY;

    /**
     * (this field is optional)
     */
    public FromEmail fromEmail() {
        initialize();
        return fromEmail;
    }

    private ToEANNumber toEANNumber = ToEANNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public ToEANNumber toEANNumber() {
        initialize();
        return toEANNumber;
    }

    private ToSAN toSAN = ToSAN.EMPTY;

    /**
     * (this field is optional)
     */
    public ToSAN toSAN() {
        initialize();
        return toSAN;
    }

    private ListOfOnixDataCompositeWithKey<AddresseeIdentifier, JonixAddresseeIdentifier, NameCodeTypes>
        addresseeIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<AddresseeIdentifier, JonixAddresseeIdentifier, NameCodeTypes> addresseeIdentifiers() {
        initialize();
        return addresseeIdentifiers;
    }

    private ToCompany toCompany = ToCompany.EMPTY;

    /**
     * (this field is optional)
     */
    public ToCompany toCompany() {
        initialize();
        return toCompany;
    }

    private ToPerson toPerson = ToPerson.EMPTY;

    /**
     * (this field is optional)
     */
    public ToPerson toPerson() {
        initialize();
        return toPerson;
    }

    private MessageNumber messageNumber = MessageNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public MessageNumber messageNumber() {
        initialize();
        return messageNumber;
    }

    private MessageRepeat messageRepeat = MessageRepeat.EMPTY;

    /**
     * (this field is optional)
     */
    public MessageRepeat messageRepeat() {
        initialize();
        return messageRepeat;
    }

    private SentDate sentDate = SentDate.EMPTY;

    /**
     * (this field is required)
     */
    public SentDate sentDate() {
        initialize();
        return sentDate;
    }

    private MessageNote messageNote = MessageNote.EMPTY;

    /**
     * (this field is optional)
     */
    public MessageNote messageNote() {
        initialize();
        return messageNote;
    }

    private DefaultLanguageOfText defaultLanguageOfText = DefaultLanguageOfText.EMPTY;

    /**
     * (this field is optional)
     */
    public DefaultLanguageOfText defaultLanguageOfText() {
        initialize();
        return defaultLanguageOfText;
    }

    private DefaultPriceTypeCode defaultPriceTypeCode = DefaultPriceTypeCode.EMPTY;

    /**
     * (this field is optional)
     */
    public DefaultPriceTypeCode defaultPriceTypeCode() {
        initialize();
        return defaultPriceTypeCode;
    }

    private DefaultCurrencyCode defaultCurrencyCode = DefaultCurrencyCode.EMPTY;

    /**
     * (this field is optional)
     */
    public DefaultCurrencyCode defaultCurrencyCode() {
        initialize();
        return defaultCurrencyCode;
    }

    private DefaultLinearUnit defaultLinearUnit = DefaultLinearUnit.EMPTY;

    /**
     * (this field is optional)
     */
    public DefaultLinearUnit defaultLinearUnit() {
        initialize();
        return defaultLinearUnit;
    }

    private DefaultWeightUnit defaultWeightUnit = DefaultWeightUnit.EMPTY;

    /**
     * (this field is optional)
     */
    public DefaultWeightUnit defaultWeightUnit() {
        initialize();
        return defaultWeightUnit;
    }

    private DefaultClassOfTrade defaultClassOfTrade = DefaultClassOfTrade.EMPTY;

    /**
     * (this field is optional)
     */
    public DefaultClassOfTrade defaultClassOfTrade() {
        initialize();
        return defaultClassOfTrade;
    }
}
