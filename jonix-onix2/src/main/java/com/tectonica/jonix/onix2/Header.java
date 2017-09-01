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

import java.io.Serializable;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixAddresseeIdentifier;
import com.tectonica.jonix.struct.JonixSenderIdentifier;

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
 * <td>&lt;Header&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;header&gt;</td>
 * </tr>
 * </table>
 */
public class Header implements OnixSuperComposite, Serializable
{
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

	public Header()
	{
		exists = false;
		element = null;
		initialized = true; // so that no further processing will be done on this intentionally-empty object
	}

	public Header(org.w3c.dom.Element element)
	{
		exists = true;
		initialized = false;
		this.element = element;
	}

	private void initialize()
	{
		if (initialized)
			return;
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
			if (name.equals(FromEANNumber.refname) || name.equals(FromEANNumber.shortname))
				fromEANNumber = new FromEANNumber(e);
			else if (name.equals(FromSAN.refname) || name.equals(FromSAN.shortname))
				fromSAN = new FromSAN(e);
			else if (name.equals(SenderIdentifier.refname) || name.equals(SenderIdentifier.shortname))
				senderIdentifiers = JPU.addToList(senderIdentifiers, new SenderIdentifier(e));
			else if (name.equals(FromCompany.refname) || name.equals(FromCompany.shortname))
				fromCompany = new FromCompany(e);
			else if (name.equals(FromPerson.refname) || name.equals(FromPerson.shortname))
				fromPerson = new FromPerson(e);
			else if (name.equals(FromEmail.refname) || name.equals(FromEmail.shortname))
				fromEmail = new FromEmail(e);
			else if (name.equals(ToEANNumber.refname) || name.equals(ToEANNumber.shortname))
				toEANNumber = new ToEANNumber(e);
			else if (name.equals(ToSAN.refname) || name.equals(ToSAN.shortname))
				toSAN = new ToSAN(e);
			else if (name.equals(AddresseeIdentifier.refname) || name.equals(AddresseeIdentifier.shortname))
				addresseeIdentifiers = JPU.addToList(addresseeIdentifiers, new AddresseeIdentifier(e));
			else if (name.equals(ToCompany.refname) || name.equals(ToCompany.shortname))
				toCompany = new ToCompany(e);
			else if (name.equals(ToPerson.refname) || name.equals(ToPerson.shortname))
				toPerson = new ToPerson(e);
			else if (name.equals(MessageNumber.refname) || name.equals(MessageNumber.shortname))
				messageNumber = new MessageNumber(e);
			else if (name.equals(MessageRepeat.refname) || name.equals(MessageRepeat.shortname))
				messageRepeat = new MessageRepeat(e);
			else if (name.equals(SentDate.refname) || name.equals(SentDate.shortname))
				sentDate = new SentDate(e);
			else if (name.equals(MessageNote.refname) || name.equals(MessageNote.shortname))
				messageNote = new MessageNote(e);
			else if (name.equals(DefaultLanguageOfText.refname) || name.equals(DefaultLanguageOfText.shortname))
				defaultLanguageOfText = new DefaultLanguageOfText(e);
			else if (name.equals(DefaultPriceTypeCode.refname) || name.equals(DefaultPriceTypeCode.shortname))
				defaultPriceTypeCode = new DefaultPriceTypeCode(e);
			else if (name.equals(DefaultCurrencyCode.refname) || name.equals(DefaultCurrencyCode.shortname))
				defaultCurrencyCode = new DefaultCurrencyCode(e);
			else if (name.equals(DefaultLinearUnit.refname) || name.equals(DefaultLinearUnit.shortname))
				defaultLinearUnit = new DefaultLinearUnit(e);
			else if (name.equals(DefaultWeightUnit.refname) || name.equals(DefaultWeightUnit.shortname))
				defaultWeightUnit = new DefaultWeightUnit(e);
			else if (name.equals(DefaultClassOfTrade.refname) || name.equals(DefaultClassOfTrade.shortname))
				defaultClassOfTrade = new DefaultClassOfTrade(e);
		});
	}

	@Override
	public boolean exists()
	{
		return exists;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	/////////////////////////////////////////////////////////////////////////////////

	private FromEANNumber fromEANNumber = FromEANNumber.EMPTY;

	/**
	 * (this field is required)
	 */
	public FromEANNumber fromEANNumber()
	{
		initialize();
		return fromEANNumber;
	}

	private FromSAN fromSAN = FromSAN.EMPTY;

	/**
	 * (this field is optional)
	 */
	public FromSAN fromSAN()
	{
		initialize();
		return fromSAN;
	}

	private ListOfOnixDataCompositeWithKey<SenderIdentifier, JonixSenderIdentifier, NameCodeTypes> senderIdentifiers = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<SenderIdentifier, JonixSenderIdentifier, NameCodeTypes> senderIdentifiers()
	{
		initialize();
		return senderIdentifiers;
	}

	private FromCompany fromCompany = FromCompany.EMPTY;

	/**
	 * (this field is optional)
	 */
	public FromCompany fromCompany()
	{
		initialize();
		return fromCompany;
	}

	private FromPerson fromPerson = FromPerson.EMPTY;

	/**
	 * (this field is optional)
	 */
	public FromPerson fromPerson()
	{
		initialize();
		return fromPerson;
	}

	private FromEmail fromEmail = FromEmail.EMPTY;

	/**
	 * (this field is optional)
	 */
	public FromEmail fromEmail()
	{
		initialize();
		return fromEmail;
	}

	private ToEANNumber toEANNumber = ToEANNumber.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ToEANNumber toEANNumber()
	{
		initialize();
		return toEANNumber;
	}

	private ToSAN toSAN = ToSAN.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ToSAN toSAN()
	{
		initialize();
		return toSAN;
	}

	private ListOfOnixDataCompositeWithKey<AddresseeIdentifier, JonixAddresseeIdentifier, NameCodeTypes> addresseeIdentifiers = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<AddresseeIdentifier, JonixAddresseeIdentifier, NameCodeTypes> addresseeIdentifiers()
	{
		initialize();
		return addresseeIdentifiers;
	}

	private ToCompany toCompany = ToCompany.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ToCompany toCompany()
	{
		initialize();
		return toCompany;
	}

	private ToPerson toPerson = ToPerson.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ToPerson toPerson()
	{
		initialize();
		return toPerson;
	}

	private MessageNumber messageNumber = MessageNumber.EMPTY;

	/**
	 * (this field is optional)
	 */
	public MessageNumber messageNumber()
	{
		initialize();
		return messageNumber;
	}

	private MessageRepeat messageRepeat = MessageRepeat.EMPTY;

	/**
	 * (this field is optional)
	 */
	public MessageRepeat messageRepeat()
	{
		initialize();
		return messageRepeat;
	}

	private SentDate sentDate = SentDate.EMPTY;

	/**
	 * (this field is required)
	 */
	public SentDate sentDate()
	{
		initialize();
		return sentDate;
	}

	private MessageNote messageNote = MessageNote.EMPTY;

	/**
	 * (this field is optional)
	 */
	public MessageNote messageNote()
	{
		initialize();
		return messageNote;
	}

	private DefaultLanguageOfText defaultLanguageOfText = DefaultLanguageOfText.EMPTY;

	/**
	 * (this field is optional)
	 */
	public DefaultLanguageOfText defaultLanguageOfText()
	{
		initialize();
		return defaultLanguageOfText;
	}

	private DefaultPriceTypeCode defaultPriceTypeCode = DefaultPriceTypeCode.EMPTY;

	/**
	 * (this field is optional)
	 */
	public DefaultPriceTypeCode defaultPriceTypeCode()
	{
		initialize();
		return defaultPriceTypeCode;
	}

	private DefaultCurrencyCode defaultCurrencyCode = DefaultCurrencyCode.EMPTY;

	/**
	 * (this field is optional)
	 */
	public DefaultCurrencyCode defaultCurrencyCode()
	{
		initialize();
		return defaultCurrencyCode;
	}

	private DefaultLinearUnit defaultLinearUnit = DefaultLinearUnit.EMPTY;

	/**
	 * (this field is optional)
	 */
	public DefaultLinearUnit defaultLinearUnit()
	{
		initialize();
		return defaultLinearUnit;
	}

	private DefaultWeightUnit defaultWeightUnit = DefaultWeightUnit.EMPTY;

	/**
	 * (this field is optional)
	 */
	public DefaultWeightUnit defaultWeightUnit()
	{
		initialize();
		return defaultWeightUnit;
	}

	private DefaultClassOfTrade defaultClassOfTrade = DefaultClassOfTrade.EMPTY;

	/**
	 * (this field is optional)
	 */
	public DefaultClassOfTrade defaultClassOfTrade()
	{
		initialize();
		return defaultClassOfTrade;
	}
}
