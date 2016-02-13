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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixSupplierIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class NewSupplier implements OnixSuperComposite, Serializable
{
	public static final String refname = "NewSupplier";
	public static final String shortname = "newsupplier";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

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

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this list may be empty)
	 */
	public List<SupplierIdentifier> supplierIdentifiers;

	/**
	 * (this field is optional)
	 */
	public SupplierSAN supplierSAN;

	/**
	 * (this field is required)
	 */
	public SupplierEANLocationNumber supplierEANLocationNumber;

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
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
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
				else if (name.equals(SupplierSAN.refname) || name.equals(SupplierSAN.shortname))
					supplierSAN = new SupplierSAN(element);
				else if (name.equals(SupplierEANLocationNumber.refname)
						|| name.equals(SupplierEANLocationNumber.shortname))
					supplierEANLocationNumber = new SupplierEANLocationNumber(element);
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

	public String getSupplierSANValue()
	{
		return (supplierSAN == null) ? null : supplierSAN.value;
	}

	public String getSupplierEANLocationNumberValue()
	{
		return (supplierEANLocationNumber == null) ? null : supplierEANLocationNumber.value;
	}

	public String getSupplierNameValue()
	{
		return (supplierName == null) ? null : supplierName.value;
	}

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
