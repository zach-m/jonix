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
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixContent;
import com.tectonica.jonix.codelist.CurrencyCodeIso4217s;
import com.tectonica.jonix.codelist.DefaultLinearUnits;
import com.tectonica.jonix.codelist.DefaultUnitOfWeights;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixAddresseeIdentifier;
import com.tectonica.jonix.struct.JonixSenderIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Header implements OnixContent, Serializable
{
	public static final String refname = "Header";
	public static final String shortname = "header";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public FromEANNumber fromEANNumber; // Required
	public FromSAN fromSAN; // Optional
	public List<SenderIdentifier> senderIdentifiers; // ZeroOrMore
	public FromCompany fromCompany; // Optional
	public FromPerson fromPerson; // Optional
	public FromEmail fromEmail; // Optional
	public ToEANNumber toEANNumber; // Optional
	public ToSAN toSAN; // Optional
	public List<AddresseeIdentifier> addresseeIdentifiers; // ZeroOrMore
	public ToCompany toCompany; // Optional
	public ToPerson toPerson; // Optional
	public MessageNumber messageNumber; // Optional
	public MessageRepeat messageRepeat; // Optional
	public SentDate sentDate; // Required
	public MessageNote messageNote; // Optional
	public DefaultLanguageOfText defaultLanguageOfText; // Optional
	public DefaultPriceTypeCode defaultPriceTypeCode; // Optional
	public DefaultCurrencyCode defaultCurrencyCode; // Optional
	public DefaultLinearUnit defaultLinearUnit; // Optional
	public DefaultWeightUnit defaultWeightUnit; // Optional
	public DefaultClassOfTrade defaultClassOfTrade; // Optional

	public Header()
	{}

	public Header(org.w3c.dom.Element element)
	{
		this.textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		this.textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		this.language = LanguageCodeIso6392Bs.byValue(JPU.getAttribute(element, "language"));
		this.transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(FromEANNumber.refname) || name.equals(FromEANNumber.shortname))
					fromEANNumber = new FromEANNumber(element);
				else if (name.equals(FromSAN.refname) || name.equals(FromSAN.shortname))
					fromSAN = new FromSAN(element);
				else if (name.equals(SenderIdentifier.refname) || name.equals(SenderIdentifier.shortname))
					senderIdentifiers = JPU.addToList(senderIdentifiers, new SenderIdentifier(element));
				else if (name.equals(FromCompany.refname) || name.equals(FromCompany.shortname))
					fromCompany = new FromCompany(element);
				else if (name.equals(FromPerson.refname) || name.equals(FromPerson.shortname))
					fromPerson = new FromPerson(element);
				else if (name.equals(FromEmail.refname) || name.equals(FromEmail.shortname))
					fromEmail = new FromEmail(element);
				else if (name.equals(ToEANNumber.refname) || name.equals(ToEANNumber.shortname))
					toEANNumber = new ToEANNumber(element);
				else if (name.equals(ToSAN.refname) || name.equals(ToSAN.shortname))
					toSAN = new ToSAN(element);
				else if (name.equals(AddresseeIdentifier.refname) || name.equals(AddresseeIdentifier.shortname))
					addresseeIdentifiers = JPU.addToList(addresseeIdentifiers, new AddresseeIdentifier(element));
				else if (name.equals(ToCompany.refname) || name.equals(ToCompany.shortname))
					toCompany = new ToCompany(element);
				else if (name.equals(ToPerson.refname) || name.equals(ToPerson.shortname))
					toPerson = new ToPerson(element);
				else if (name.equals(MessageNumber.refname) || name.equals(MessageNumber.shortname))
					messageNumber = new MessageNumber(element);
				else if (name.equals(MessageRepeat.refname) || name.equals(MessageRepeat.shortname))
					messageRepeat = new MessageRepeat(element);
				else if (name.equals(SentDate.refname) || name.equals(SentDate.shortname))
					sentDate = new SentDate(element);
				else if (name.equals(MessageNote.refname) || name.equals(MessageNote.shortname))
					messageNote = new MessageNote(element);
				else if (name.equals(DefaultLanguageOfText.refname) || name.equals(DefaultLanguageOfText.shortname))
					defaultLanguageOfText = new DefaultLanguageOfText(element);
				else if (name.equals(DefaultPriceTypeCode.refname) || name.equals(DefaultPriceTypeCode.shortname))
					defaultPriceTypeCode = new DefaultPriceTypeCode(element);
				else if (name.equals(DefaultCurrencyCode.refname) || name.equals(DefaultCurrencyCode.shortname))
					defaultCurrencyCode = new DefaultCurrencyCode(element);
				else if (name.equals(DefaultLinearUnit.refname) || name.equals(DefaultLinearUnit.shortname))
					defaultLinearUnit = new DefaultLinearUnit(element);
				else if (name.equals(DefaultWeightUnit.refname) || name.equals(DefaultWeightUnit.shortname))
					defaultWeightUnit = new DefaultWeightUnit(element);
				else if (name.equals(DefaultClassOfTrade.refname) || name.equals(DefaultClassOfTrade.shortname))
					defaultClassOfTrade = new DefaultClassOfTrade(element);
			}
		});
	}

	public String getFromEANNumberValue()
	{
		return (fromEANNumber == null) ? null : fromEANNumber.value;
	}

	public String getFromSANValue()
	{
		return (fromSAN == null) ? null : fromSAN.value;
	}

	public String getFromCompanyValue()
	{
		return (fromCompany == null) ? null : fromCompany.value;
	}

	public String getFromPersonValue()
	{
		return (fromPerson == null) ? null : fromPerson.value;
	}

	public String getFromEmailValue()
	{
		return (fromEmail == null) ? null : fromEmail.value;
	}

	public String getToEANNumberValue()
	{
		return (toEANNumber == null) ? null : toEANNumber.value;
	}

	public String getToSANValue()
	{
		return (toSAN == null) ? null : toSAN.value;
	}

	public String getToCompanyValue()
	{
		return (toCompany == null) ? null : toCompany.value;
	}

	public String getToPersonValue()
	{
		return (toPerson == null) ? null : toPerson.value;
	}

	public String getMessageNumberValue()
	{
		return (messageNumber == null) ? null : messageNumber.value;
	}

	public String getMessageRepeatValue()
	{
		return (messageRepeat == null) ? null : messageRepeat.value;
	}

	public String getSentDateValue()
	{
		return (sentDate == null) ? null : sentDate.value;
	}

	public String getMessageNoteValue()
	{
		return (messageNote == null) ? null : messageNote.value;
	}

	public LanguageCodeIso6392Bs getDefaultLanguageOfTextValue()
	{
		return (defaultLanguageOfText == null) ? null : defaultLanguageOfText.value;
	}

	public PriceTypes getDefaultPriceTypeCodeValue()
	{
		return (defaultPriceTypeCode == null) ? null : defaultPriceTypeCode.value;
	}

	public CurrencyCodeIso4217s getDefaultCurrencyCodeValue()
	{
		return (defaultCurrencyCode == null) ? null : defaultCurrencyCode.value;
	}

	public DefaultLinearUnits getDefaultLinearUnitValue()
	{
		return (defaultLinearUnit == null) ? null : defaultLinearUnit.value;
	}

	public DefaultUnitOfWeights getDefaultWeightUnitValue()
	{
		return (defaultWeightUnit == null) ? null : defaultWeightUnit.value;
	}

	public String getDefaultClassOfTradeValue()
	{
		return (defaultClassOfTrade == null) ? null : defaultClassOfTrade.value;
	}

	public JonixSenderIdentifier findSenderIdentifier(NameCodeTypes senderIDType)
	{
		if (senderIdentifiers != null)
		{
			for (SenderIdentifier x : senderIdentifiers)
			{
				if (x.getSenderIDTypeValue() == senderIDType)
					return x.asJonixSenderIdentifier();
			}
		}
		return null;
	}

	public List<JonixSenderIdentifier> findSenderIdentifiers(java.util.Set<NameCodeTypes> senderIDTypes)
	{
		if (senderIdentifiers != null)
		{
			List<JonixSenderIdentifier> matches = new ArrayList<>();
			for (SenderIdentifier x : senderIdentifiers)
			{
				if (senderIDTypes == null || senderIDTypes.contains(x.getSenderIDTypeValue()))
					matches.add(x.asJonixSenderIdentifier());
			}
			return matches;
		}
		return null;
	}

	public JonixAddresseeIdentifier findAddresseeIdentifier(NameCodeTypes addresseeIDType)
	{
		if (addresseeIdentifiers != null)
		{
			for (AddresseeIdentifier x : addresseeIdentifiers)
			{
				if (x.getAddresseeIDTypeValue() == addresseeIDType)
					return x.asJonixAddresseeIdentifier();
			}
		}
		return null;
	}

	public List<JonixAddresseeIdentifier> findAddresseeIdentifiers(java.util.Set<NameCodeTypes> addresseeIDTypes)
	{
		if (addresseeIdentifiers != null)
		{
			List<JonixAddresseeIdentifier> matches = new ArrayList<>();
			for (AddresseeIdentifier x : addresseeIdentifiers)
			{
				if (addresseeIDTypes == null || addresseeIDTypes.contains(x.getAddresseeIDTypeValue()))
					matches.add(x.asJonixAddresseeIdentifier());
			}
			return matches;
		}
		return null;
	}
}
