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
import com.tectonica.jonix.codelist.ProductContactRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixProductContactIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class ProductContact implements Serializable
{
	public static final String refname = "ProductContact";
	public static final String shortname = "productcontact";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public ProductContactRole productContactRole; // Required
	public List<ProductContactIdentifier> productContactIdentifiers; // OneOrMore
	public ProductContactName productContactName; // Optional
	public ContactName contactName; // Optional
	public EmailAddress emailAddress; // Optional

	public ProductContact()
	{}

	public ProductContact(org.w3c.dom.Element element)
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
				if (name.equals(ProductContactRole.refname) || name.equals(ProductContactRole.shortname))
					productContactRole = new ProductContactRole(element);
				else if (name.equals(ProductContactIdentifier.refname) || name.equals(ProductContactIdentifier.shortname))
					productContactIdentifiers = JPU.addToList(productContactIdentifiers, new ProductContactIdentifier(element));
				else if (name.equals(ProductContactName.refname) || name.equals(ProductContactName.shortname))
					productContactName = new ProductContactName(element);
				else if (name.equals(ContactName.refname) || name.equals(ContactName.shortname))
					contactName = new ContactName(element);
				else if (name.equals(EmailAddress.refname) || name.equals(EmailAddress.shortname))
					emailAddress = new EmailAddress(element);
			}
		});
	}

	public ProductContactRoles getProductContactRoleValue()
	{
		return (productContactRole == null) ? null : productContactRole.value;
	}

	public String getProductContactNameValue()
	{
		return (productContactName == null) ? null : productContactName.value;
	}

	public String getContactNameValue()
	{
		return (contactName == null) ? null : contactName.value;
	}

	public String getEmailAddressValue()
	{
		return (emailAddress == null) ? null : emailAddress.value;
	}

	public JonixProductContactIdentifier findProductContactIdentifier(NameCodeTypes productContactIDType)
	{
		if (productContactIdentifiers != null)
		{
			for (ProductContactIdentifier x : productContactIdentifiers)
			{
				if (x.getProductContactIDTypeValue() == productContactIDType)
					return x.asStruct();
			}
		}
		return null;
	}

	public List<JonixProductContactIdentifier> findProductContactIdentifiers(java.util.Set<NameCodeTypes> productContactIDTypes)
	{
		if (productContactIdentifiers != null)
		{
			List<JonixProductContactIdentifier> matches = new ArrayList<>();
			for (ProductContactIdentifier x : productContactIdentifiers)
			{
				if (productContactIDTypes == null || productContactIDTypes.contains(x.getProductContactIDTypeValue()))
					matches.add(x.asStruct());
			}
			return matches;
		}
		return null;
	}
}
