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
import com.tectonica.jonix.codelist.CurrencyCodeIso4217s;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Header implements Serializable
{
	public static final String refname = "Header";
	public static final String shortname = "header";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public Sender sender; // Required
	public List<Addressee> addressees; // ZeroOrMore
	public MessageNumber messageNumber; // Optional
	public MessageRepeat messageRepeat; // Optional
	public SentDateTime sentDateTime; // Required
	public List<MessageNote> messageNotes; // ZeroOrMore
	public DefaultLanguageOfText defaultLanguageOfText; // Optional
	public DefaultPriceType defaultPriceType; // Optional
	public DefaultCurrencyCode defaultCurrencyCode; // Optional

	public Header()
	{}

	public Header(org.w3c.dom.Element element)
	{
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

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

	public Integer getMessageNumberValue()
	{
		return (messageNumber == null) ? null : messageNumber.value;
	}

	public Integer getMessageRepeatValue()
	{
		return (messageRepeat == null) ? null : messageRepeat.value;
	}

	public String getSentDateTimeValue()
	{
		return (sentDateTime == null) ? null : sentDateTime.value;
	}

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

	public LanguageCodeIso6392Bs getDefaultLanguageOfTextValue()
	{
		return (defaultLanguageOfText == null) ? null : defaultLanguageOfText.value;
	}

	public PriceTypes getDefaultPriceTypeValue()
	{
		return (defaultPriceType == null) ? null : defaultPriceType.value;
	}

	public CurrencyCodeIso4217s getDefaultCurrencyCodeValue()
	{
		return (defaultCurrencyCode == null) ? null : defaultCurrencyCode.value;
	}
}
