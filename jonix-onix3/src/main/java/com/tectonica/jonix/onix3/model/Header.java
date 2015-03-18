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

package com.tectonica.jonix.onix3.model;

import java.util.List;

import com.tectonica.jonix.onix3.DU;
import com.tectonica.jonix.onix3.codelist.List3;

public class Header
{
	public static final String refname = "Header";
	public static final String shortname = "header";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
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

	public static Header fromDoc(org.w3c.dom.Element element)
	{
		final Header x = new Header();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(Sender.refname) || name.equalsIgnoreCase(Sender.shortname))
					x.sender = Sender.fromDoc(element);
				else if (name.equalsIgnoreCase(Addressee.refname) || name.equalsIgnoreCase(Addressee.shortname))
					x.addressees = DU.addToList(x.addressees, Addressee.fromDoc(element));
				else if (name.equalsIgnoreCase(MessageNumber.refname) || name.equalsIgnoreCase(MessageNumber.shortname))
					x.messageNumber = MessageNumber.fromDoc(element);
				else if (name.equalsIgnoreCase(MessageRepeat.refname) || name.equalsIgnoreCase(MessageRepeat.shortname))
					x.messageRepeat = MessageRepeat.fromDoc(element);
				else if (name.equalsIgnoreCase(SentDateTime.refname) || name.equalsIgnoreCase(SentDateTime.shortname))
					x.sentDateTime = SentDateTime.fromDoc(element);
				else if (name.equalsIgnoreCase(MessageNote.refname) || name.equalsIgnoreCase(MessageNote.shortname))
					x.messageNotes = DU.addToList(x.messageNotes, MessageNote.fromDoc(element));
				else if (name.equalsIgnoreCase(DefaultLanguageOfText.refname) || name.equalsIgnoreCase(DefaultLanguageOfText.shortname))
					x.defaultLanguageOfText = DefaultLanguageOfText.fromDoc(element);
				else if (name.equalsIgnoreCase(DefaultPriceType.refname) || name.equalsIgnoreCase(DefaultPriceType.shortname))
					x.defaultPriceType = DefaultPriceType.fromDoc(element);
				else if (name.equalsIgnoreCase(DefaultCurrencyCode.refname) || name.equalsIgnoreCase(DefaultCurrencyCode.shortname))
					x.defaultCurrencyCode = DefaultCurrencyCode.fromDoc(element);
			}
		});

		return x;
	}
}
