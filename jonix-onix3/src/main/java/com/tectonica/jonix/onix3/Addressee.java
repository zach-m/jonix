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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Addressee composite</h1>
 * <p>
 * A group of data elements which together specify the addressee of an ONIX for Books message. Optional, and repeatable
 * if there are several addressees.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Addressee&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;addressee&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class Addressee implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Addressee";
	public static final String shortname = "addressee";

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
	 * (this list is required to contain at least one item)
	 */
	public List<AddresseeIdentifier> addresseeIdentifiers;

	/**
	 * (this field is optional)
	 */
	public AddresseeName addresseeName;

	/**
	 * (this field is optional)
	 */
	public ContactName contactName;

	/**
	 * (this field is optional)
	 */
	public EmailAddress emailAddress;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Addressee()
	{}

	public Addressee(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

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

	/**
	 * Raw Format: Variable-length text, suggested maximum 50 characters
	 */
	public String getAddresseeNameValue()
	{
		return (addresseeName == null) ? null : addresseeName.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 300 characters
	 */
	public String getContactNameValue()
	{
		return (contactName == null) ? null : contactName.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
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
