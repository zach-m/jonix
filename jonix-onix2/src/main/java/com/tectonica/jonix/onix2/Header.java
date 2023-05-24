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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixHeader;
import com.tectonica.jonix.common.OnixVersion;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixAddresseeIdentifier;
import com.tectonica.jonix.common.struct.JonixSenderIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Header composite</h1>
 * <p>
 * A group of data elements which together constitute a message header. The elements may alternatively be sent without
 * being grouped into a composite, but the composite approach is recommended since it makes it easier to maintain a
 * standard header “package” to drop into any new ONIX Product Information Message. <strong>Note that the Sender and
 * Addressee Identifier composites can only be used within the Header composite, and future extensions to the Header
 * will be defined only within the composite.</strong>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Header&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;header&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ONIXMessage}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Header}</li>
 * </ul>
 */
public class Header implements OnixHeader, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Header";
    public static final String shortname = "header";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    private final OnixVersion onixVersion;
    private final String onixRelease;

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

    /**
     * This constructor is for backward compatibility. For future proofing, it's recommended to use the other
     * constructor, passing onixRelease label.
     */
    public Header(org.w3c.dom.Element element) {
        this(element, null);
    }

    public Header(org.w3c.dom.Element element, String onixRelease) {
        exists = true;
        initialized = false;
        this.element = element;
        this.onixVersion = OnixVersion.ONIX2;
        this.onixRelease = onixRelease;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
    }

    @Override
    public OnixVersion onixVersion() {
        return onixVersion;
    }

    @Override
    public String onixRelease() {
        return onixRelease;
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
                case FromEANNumber.refname:
                case FromEANNumber.shortname:
                    fromEANNumber = new FromEANNumber(e);
                    break;
                case SentDate.refname:
                case SentDate.shortname:
                    sentDate = new SentDate(e);
                    break;
                case FromSAN.refname:
                case FromSAN.shortname:
                    fromSAN = new FromSAN(e);
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
                case SenderIdentifier.refname:
                case SenderIdentifier.shortname:
                    senderIdentifiers = JPU.addToList(senderIdentifiers, new SenderIdentifier(e));
                    break;
                case AddresseeIdentifier.refname:
                case AddresseeIdentifier.shortname:
                    addresseeIdentifiers = JPU.addToList(addresseeIdentifiers, new AddresseeIdentifier(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Header&gt; or &lt;header&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Header> action) {
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

    private FromEANNumber fromEANNumber = FromEANNumber.EMPTY;

    /**
     * <p>
     * An EAN location number which identifies the sender of an ONIX message. Optional and non-repeating; but either the
     * &lt;FromCompany&gt; element or a sender identifier using one or more elements from MH.1 to MH.5 must be included.
     * </p>
     * Jonix-Comment: this field is required
     */
    public FromEANNumber fromEANNumber() {
        _initialize();
        return fromEANNumber;
    }

    private SentDate sentDate = SentDate.EMPTY;

    /**
     * <p>
     * The date on which the message is sent. Optionally, the time may be added, using the 24-hour clock. Mandatory and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SentDate sentDate() {
        _initialize();
        return sentDate;
    }

    private FromSAN fromSAN = FromSAN.EMPTY;

    /**
     * <p>
     * A US book trade Standard Address Number which identifies the sender of an ONIX message. Optional and
     * non-repeating; but either the &lt;FromCompany&gt; element or a sender identifier using one or more elements from
     * MH.1 to MH.5 must be included.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public FromSAN fromSAN() {
        _initialize();
        return fromSAN;
    }

    private FromCompany fromCompany = FromCompany.EMPTY;

    /**
     * <p>
     * The name of the sender organization, which should always be stated in a standard form agreed with the addressee.
     * Optional and non-repeating; but either the &lt;FromCompany&gt; element or a sender identifier using one or more
     * elements from MH.1 to MH.5 must be included.
     * </p>
     * <p class="new214">
     * The text is not limited to ASCII characters.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public FromCompany fromCompany() {
        _initialize();
        return fromCompany;
    }

    private FromPerson fromPerson = FromPerson.EMPTY;

    /**
     * <p>
     * Free text giving the name, department, phone number, <em>etc</em> for a contact person in the sender organization
     * who is responsible for the content of the message. Optional and non-repeating.
     * </p>
     * <p class="new214">
     * The text is not limited to ASCII characters.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public FromPerson fromPerson() {
        _initialize();
        return fromPerson;
    }

    private FromEmail fromEmail = FromEmail.EMPTY;

    /**
     * <p>
     * A text field giving the email address for a contact person in the sender organization who is responsible for the
     * content of the message. Optional and non-repeating.
     * </p>
     * <p class="new214">
     * The text is not limited to ASCII characters.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public FromEmail fromEmail() {
        _initialize();
        return fromEmail;
    }

    private ToEANNumber toEANNumber = ToEANNumber.EMPTY;

    /**
     * <p>
     * An EAN location number which identifies the addressee of an ONIX message. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ToEANNumber toEANNumber() {
        _initialize();
        return toEANNumber;
    }

    private ToSAN toSAN = ToSAN.EMPTY;

    /**
     * <p>
     * A US book trade Standard Address Number which identifies the addressee of an ONIX message. Optional and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ToSAN toSAN() {
        _initialize();
        return toSAN;
    }

    private ToCompany toCompany = ToCompany.EMPTY;

    /**
     * <p>
     * The name of the addressee organization, which should always be stated in a standard form agreed with the
     * addressee. Optional and non-repeating.
     * </p>
     * <p class="new214">
     * The text is not limited to ASCII characters.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ToCompany toCompany() {
        _initialize();
        return toCompany;
    }

    private ToPerson toPerson = ToPerson.EMPTY;

    /**
     * <p>
     * Free text giving the name, department <em>etc</em> for a contact person in the addressee organization to whom the
     * message is to be directed. Optional and non-repeating.
     * </p>
     * <p class="new214">
     * The text is not limited to ASCII characters.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ToPerson toPerson() {
        _initialize();
        return toPerson;
    }

    private MessageNumber messageNumber = MessageNumber.EMPTY;

    /**
     * <p>
     * A sequence number of the messages in a series sent between trading partners, to enable the receiver to check
     * against gaps and duplicates. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public MessageNumber messageNumber() {
        _initialize();
        return messageNumber;
    }

    private MessageRepeat messageRepeat = MessageRepeat.EMPTY;

    /**
     * <p>
     * A number which distinguishes any repeat transmissions of a message. If this element is used, the original is
     * numbered 1 and repeats are numbered 2, 3 <em>etc</em>. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public MessageRepeat messageRepeat() {
        _initialize();
        return messageRepeat;
    }

    private MessageNote messageNote = MessageNote.EMPTY;

    /**
     * <p>
     * Free text giving additional information about the message. Optional and non-repeating.
     * </p>
     * <p class="new214">
     * The text is not limited to ASCII characters.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public MessageNote messageNote() {
        _initialize();
        return messageNote;
    }

    private DefaultLanguageOfText defaultLanguageOfText = DefaultLanguageOfText.EMPTY;

    /**
     * <p>
     * An ISO standard code indicating the default language which is assumed for the text of products listed in the
     * message, unless explicitly stated otherwise by sending a “language of text” element in the product record. This
     * default will be assumed for all product records which do not specify a language in Group PR.11. Optional and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DefaultLanguageOfText defaultLanguageOfText() {
        _initialize();
        return defaultLanguageOfText;
    }

    private DefaultPriceTypeCode defaultPriceTypeCode = DefaultPriceTypeCode.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the default price type which is assumed for prices listed in the message, unless
     * explicitly stated otherwise in a &lt;Price&gt; composite in the product record. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DefaultPriceTypeCode defaultPriceTypeCode() {
        _initialize();
        return defaultPriceTypeCode;
    }

    private DefaultCurrencyCode defaultCurrencyCode = DefaultCurrencyCode.EMPTY;

    /**
     * <p>
     * An ISO standard code indicating the currency which is assumed for prices listed in the message, unless explicitly
     * stated otherwise in a &lt;Price&gt; composite in the product record. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DefaultCurrencyCode defaultCurrencyCode() {
        _initialize();
        return defaultCurrencyCode;
    }

    private DefaultLinearUnit defaultLinearUnit = DefaultLinearUnit.EMPTY;

    /**
     * <p>
     * A code indicating the default unit which is assumed for linear measurements listed in the message, unless
     * otherwise specified in the product record. <strong>This element is deprecated<!-- provided for use at Level 1
     * -->. For most implementations, explicit coding of measure units with each occurrence of a measurement is to be
     * preferred.</strong> Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DefaultLinearUnit defaultLinearUnit() {
        _initialize();
        return defaultLinearUnit;
    }

    private DefaultWeightUnit defaultWeightUnit = DefaultWeightUnit.EMPTY;

    /**
     * <p>
     * A code indicating the default unit which is assumed for weights listed in the message, unless otherwise specified
     * in the product record. <strong>This element is deprecated<!-- provided for use at Level 1 -->. For most
     * implementations, explicit coding of units with each occurrence of a weight is to be preferred.</strong> Optional
     * and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DefaultWeightUnit defaultWeightUnit() {
        _initialize();
        return defaultWeightUnit;
    }

    private DefaultClassOfTrade defaultClassOfTrade = DefaultClassOfTrade.EMPTY;

    /**
     * <p>
     * Free text indicating the class of trade which is assumed for prices given in the message, unless explicitly
     * stated otherwise specified in &lt;j149&gt;. For example: Institutional, General trade, Wholesale distributor,
     * which may be represented by a suitable code or abbreviation agreed between trading partners. otherwise specified
     * in the product record. Optional and non-repeating.
     * </p>
     * <p class="new214">
     * The text is not limited to ASCII characters.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DefaultClassOfTrade defaultClassOfTrade() {
        _initialize();
        return defaultClassOfTrade;
    }

    private ListOfOnixDataCompositeWithKey<SenderIdentifier, JonixSenderIdentifier,
        NameIdentifierTypes> senderIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(SenderIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define the identifier of the sender within a specified namespace, used
     * here to allow different party identifiers to be included without defining additional data elements. In particular
     * the composite allows a proprietary identifier to be used by mutual agreement between parties to an exchange. The
     * composite is optional and repeatable; but either the &lt;FromCompany&gt; element or a sender identifier using one
     * or more elements from MH.1 to MH.5 must be included.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<SenderIdentifier, JonixSenderIdentifier, NameIdentifierTypes>
        senderIdentifiers() {
        _initialize();
        return senderIdentifiers;
    }

    private ListOfOnixDataCompositeWithKey<AddresseeIdentifier, JonixAddresseeIdentifier,
        NameIdentifierTypes> addresseeIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(AddresseeIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define the identifier of the addressee within a specified namespace, used
     * here to allow different party identifiers to be included without defining additional data elements. In particular
     * the composite allows a proprietary identifier to be used by mutual agreement between parties to an exchange. The
     * composite is optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<AddresseeIdentifier, JonixAddresseeIdentifier, NameIdentifierTypes>
        addresseeIdentifiers() {
        _initialize();
        return addresseeIdentifiers;
    }
}
