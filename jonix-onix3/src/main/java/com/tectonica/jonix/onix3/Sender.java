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
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixSenderIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Sender implements Serializable
{
	public static final String refname = "Sender";
	public static final String shortname = "sender";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<SenderIdentifier> senderIdentifiers; // OneOrMore
	public SenderName senderName; // Optional
	public ContactName contactName; // Optional
	public EmailAddress emailAddress; // Optional

	public Sender()
	{}

	public Sender(org.w3c.dom.Element element)
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
				if (name.equals(SenderIdentifier.refname) || name.equals(SenderIdentifier.shortname))
					senderIdentifiers = JPU.addToList(senderIdentifiers, new SenderIdentifier(element));
				else if (name.equals(SenderName.refname) || name.equals(SenderName.shortname))
					senderName = new SenderName(element);
				else if (name.equals(ContactName.refname) || name.equals(ContactName.shortname))
					contactName = new ContactName(element);
				else if (name.equals(EmailAddress.refname) || name.equals(EmailAddress.shortname))
					emailAddress = new EmailAddress(element);
			}
		});
	}

	public String getSenderNameValue()
	{
		return (senderName == null) ? null : senderName.value;
	}

	public String getContactNameValue()
	{
		return (contactName == null) ? null : contactName.value;
	}

	public String getEmailAddressValue()
	{
		return (emailAddress == null) ? null : emailAddress.value;
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
}
