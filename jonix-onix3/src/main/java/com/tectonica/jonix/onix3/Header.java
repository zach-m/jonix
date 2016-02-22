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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.CurrencyCodes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

public class Header implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Header";
	public static final String shortname = "header";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this field is required)
	 */
	public Sender sender;

	/**
	 * (this list may be empty)
	 */
	public List<Addressee> addressees;

	/**
	 * (this field is optional)
	 */
	public MessageNumber messageNumber;

	/**
	 * (this field is optional)
	 */
	public MessageRepeat messageRepeat;

	/**
	 * (this field is required)
	 */
	public SentDateTime sentDateTime;

	/**
	 * (this list may be empty)
	 */
	public List<MessageNote> messageNotes;

	/**
	 * (this field is optional)
	 */
	public DefaultLanguageOfText defaultLanguageOfText;

	/**
	 * (this field is optional)
	 */
	public DefaultPriceType defaultPriceType;

	/**
	 * (this field is optional)
	 */
	public DefaultCurrencyCode defaultCurrencyCode;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Header()
	{}

	public Header(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(Sender.refname) || name.equals(Sender.shortname))
					sender = new Sender(element);
				else if (name.equals(Addressee.refname) || name.equals(Addressee.shortname))
					addressees = JPU.addToList(addressees, new Addressee(element));
				else if (name.equals(MessageNumber.refname) || name.equals(MessageNumber.shortname))
					messageNumber = new MessageNumber(element);
				else if (name.equals(MessageRepeat.refname) || name.equals(MessageRepeat.shortname))
					messageRepeat = new MessageRepeat(element);
				else if (name.equals(SentDateTime.refname) || name.equals(SentDateTime.shortname))
					sentDateTime = new SentDateTime(element);
				else if (name.equals(MessageNote.refname) || name.equals(MessageNote.shortname))
					messageNotes = JPU.addToList(messageNotes, new MessageNote(element));
				else if (name.equals(DefaultLanguageOfText.refname) || name.equals(DefaultLanguageOfText.shortname))
					defaultLanguageOfText = new DefaultLanguageOfText(element);
				else if (name.equals(DefaultPriceType.refname) || name.equals(DefaultPriceType.shortname))
					defaultPriceType = new DefaultPriceType(element);
				else if (name.equals(DefaultCurrencyCode.refname) || name.equals(DefaultCurrencyCode.shortname))
					defaultCurrencyCode = new DefaultCurrencyCode(element);
			}
		});
	}

	/**
	 * Raw Format: Variable length integer
	 */
	public Integer getMessageNumberValue()
	{
		return (messageNumber == null) ? null : messageNumber.value;
	}

	/**
	 * Raw Format: Variable length integer
	 */
	public Integer getMessageRepeatValue()
	{
		return (messageRepeat == null) ? null : messageRepeat.value;
	}

	/**
	 * Raw Format: Permitted formats, where 'T' and 'Z' represent themselves (ie the letters T and Z), and where the
	 * symbol '&#177;' represents either '+' or '-' to indicate a timezone offset from UTC. YYYYMMDD Date only
	 * YYYYMMDDThhmm Date and time (local time of sender) YYYYMMDDThhmmZ Universal time (UTC) &#8224;
	 * YYYYMMDDThhmm&#177;hhmm With time zone offset from UTC &#8224; YYYYMMDDThhmmss Date and time (with seconds)
	 * YYYYMMDDThhmmssZ Universal time (with seconds) YYYYMMDDThhmmss&#177;hhmm With time zone offset from UTC (with
	 * seconds) &#8224; indicates the preferred formats
	 */
	public String getSentDateTimeValue()
	{
		return (sentDateTime == null) ? null : sentDateTime.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 500 characters
	 */
	public List<String> getMessageNoteValues()
	{
		if (messageNotes != null)
		{
			List<String> list = new ArrayList<>();
			for (MessageNote i : messageNotes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public LanguageCodes getDefaultLanguageOfTextValue()
	{
		return (defaultLanguageOfText == null) ? null : defaultLanguageOfText.value;
	}

	public PriceTypes getDefaultPriceTypeValue()
	{
		return (defaultPriceType == null) ? null : defaultPriceType.value;
	}

	public CurrencyCodes getDefaultCurrencyCodeValue()
	{
		return (defaultCurrencyCode == null) ? null : defaultCurrencyCode.value;
	}
}
