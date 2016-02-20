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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.struct.JonixSupplierIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>New supplier composite</h1>
 * <p>
 * A group of data elements which together specify a new supply source to which orders are referred. Use only when the
 * code in &lt;ProductAvailability&gt; indicates ‘no longer available from us, refer to new supplier’. Only one
 * occurrence of the composite is permitted in this context.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;NewSupplier&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;newsupplier&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 */
public class NewSupplier implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "NewSupplier";
	public static final String shortname = "newsupplier";

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
	public List<SupplierIdentifier> supplierIdentifiers;

	/**
	 * (this field is optional)
	 */
	public SupplierName supplierName;

	/**
	 * (this list may be empty)
	 */
	public List<TelephoneNumber> telephoneNumbers;

	/**
	 * (this list may be empty)
	 */
	public List<FaxNumber> faxNumbers;

	/**
	 * (this list may be empty)
	 */
	public List<EmailAddress> emailAddresss;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public NewSupplier()
	{}

	public NewSupplier(org.w3c.dom.Element element)
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
				if (name.equals(SupplierIdentifier.refname) || name.equals(SupplierIdentifier.shortname))
					supplierIdentifiers = JPU.addToList(supplierIdentifiers, new SupplierIdentifier(element));
				else if (name.equals(SupplierName.refname) || name.equals(SupplierName.shortname))
					supplierName = new SupplierName(element);
				else if (name.equals(TelephoneNumber.refname) || name.equals(TelephoneNumber.shortname))
					telephoneNumbers = JPU.addToList(telephoneNumbers, new TelephoneNumber(element));
				else if (name.equals(FaxNumber.refname) || name.equals(FaxNumber.shortname))
					faxNumbers = JPU.addToList(faxNumbers, new FaxNumber(element));
				else if (name.equals(EmailAddress.refname) || name.equals(EmailAddress.shortname))
					emailAddresss = JPU.addToList(emailAddresss, new EmailAddress(element));
			}
		});
	}

	/**
	 * Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getSupplierNameValue()
	{
		return (supplierName == null) ? null : supplierName.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum length 20 characters
	 */
	public List<String> getTelephoneNumberValues()
	{
		if (telephoneNumbers != null)
		{
			List<String> list = new ArrayList<>();
			for (TelephoneNumber i : telephoneNumbers)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Format: Variable-length text, suggested maximum length 20 characters
	 */
	public List<String> getFaxNumberValues()
	{
		if (faxNumbers != null)
		{
			List<String> list = new ArrayList<>();
			for (FaxNumber i : faxNumbers)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Format: Variable-length text, suggested maximum length 100 characters
	 */
	public List<String> getEmailAddressValues()
	{
		if (emailAddresss != null)
		{
			List<String> list = new ArrayList<>();
			for (EmailAddress i : emailAddresss)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public JonixSupplierIdentifier findSupplierIdentifier(SupplierIdentifierTypes supplierIDType)
	{
		if (supplierIdentifiers != null)
		{
			for (SupplierIdentifier x : supplierIdentifiers)
			{
				if (x.getSupplierIDTypeValue() == supplierIDType)
					return x.asJonixSupplierIdentifier();
			}
		}
		return null;
	}

	public List<JonixSupplierIdentifier> findSupplierIdentifiers(java.util.Set<SupplierIdentifierTypes> supplierIDTypes)
	{
		if (supplierIdentifiers != null)
		{
			List<JonixSupplierIdentifier> matches = new ArrayList<>();
			for (SupplierIdentifier x : supplierIdentifiers)
			{
				if (supplierIDTypes == null || supplierIDTypes.contains(x.getSupplierIDTypeValue()))
					matches.add(x.asJonixSupplierIdentifier());
			}
			return matches;
		}
		return null;
	}
}
