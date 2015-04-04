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
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixAddresseeIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Addressee implements OnixSuperComposite, Serializable
{
	public static final String refname = "Addressee";
	public static final String shortname = "addressee";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<AddresseeIdentifier> addresseeIdentifiers; // OneOrMore
	public AddresseeName addresseeName; // Optional
	public ContactName contactName; // Optional
	public EmailAddress emailAddress; // Optional

	public Addressee()
	{}

	public Addressee(org.w3c.dom.Element element)
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
				if (name.equals(AddresseeIdentifier.refname) || name.equals(AddresseeIdentifier.shortname))
					addresseeIdentifiers = JPU.addToList(addresseeIdentifiers, new AddresseeIdentifier(element));
				else if (name.equals(AddresseeName.refname) || name.equals(AddresseeName.shortname))
					addresseeName = new AddresseeName(element);
				else if (name.equals(ContactName.refname) || name.equals(ContactName.shortname))
					contactName = new ContactName(element);
				else if (name.equals(EmailAddress.refname) || name.equals(EmailAddress.shortname))
					emailAddress = new EmailAddress(element);
			}
		});
	}

	public String getAddresseeNameValue()
	{
		return (addresseeName == null) ? null : addresseeName.value;
	}

	public String getContactNameValue()
	{
		return (contactName == null) ? null : contactName.value;
	}

	public String getEmailAddressValue()
	{
		return (emailAddress == null) ? null : emailAddress.value;
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
