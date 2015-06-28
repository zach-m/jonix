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
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixAgentIdentifier;
import com.tectonica.jonix.struct.JonixMarketDate;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class MarketRepresentation implements OnixSuperComposite, Serializable
{
	public static final String refname = "MarketRepresentation";
	public static final String shortname = "marketrepresentation";

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

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<AgentIdentifier> agentIdentifiers;

	/**
	 * (this field is optional)
	 */
	public AgentName agentName;

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

	/**
	 * (this list may be empty)
	 */
	public List<Website> websites;

	/**
	 * (this field is optional)
	 */
	public AgentRole agentRole;

	/**
	 * (this field is optional)
	 */
	public MarketCountry marketCountry;

	/**
	 * (this field is required)
	 */
	public MarketTerritory marketTerritory;

	/**
	 * (this field is optional)
	 */
	public MarketCountryExcluded marketCountryExcluded;

	/**
	 * (this field is optional)
	 */
	public MarketRestrictionDetail marketRestrictionDetail;

	/**
	 * (this field is optional)
	 */
	public MarketPublishingStatus marketPublishingStatus;

	/**
	 * (this list may be empty)
	 */
	public List<MarketDate> marketDates;

	public MarketRepresentation()
	{}

	public MarketRepresentation(org.w3c.dom.Element element)
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
				if (name.equals(AgentIdentifier.refname) || name.equals(AgentIdentifier.shortname))
					agentIdentifiers = JPU.addToList(agentIdentifiers, new AgentIdentifier(element));
				else if (name.equals(AgentName.refname) || name.equals(AgentName.shortname))
					agentName = new AgentName(element);
				else if (name.equals(TelephoneNumber.refname) || name.equals(TelephoneNumber.shortname))
					telephoneNumbers = JPU.addToList(telephoneNumbers, new TelephoneNumber(element));
				else if (name.equals(FaxNumber.refname) || name.equals(FaxNumber.shortname))
					faxNumbers = JPU.addToList(faxNumbers, new FaxNumber(element));
				else if (name.equals(EmailAddress.refname) || name.equals(EmailAddress.shortname))
					emailAddresss = JPU.addToList(emailAddresss, new EmailAddress(element));
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					websites = JPU.addToList(websites, new Website(element));
				else if (name.equals(AgentRole.refname) || name.equals(AgentRole.shortname))
					agentRole = new AgentRole(element);
				else if (name.equals(MarketCountry.refname) || name.equals(MarketCountry.shortname))
					marketCountry = new MarketCountry(element);
				else if (name.equals(MarketTerritory.refname) || name.equals(MarketTerritory.shortname))
					marketTerritory = new MarketTerritory(element);
				else if (name.equals(MarketCountryExcluded.refname) || name.equals(MarketCountryExcluded.shortname))
					marketCountryExcluded = new MarketCountryExcluded(element);
				else if (name.equals(MarketRestrictionDetail.refname) || name.equals(MarketRestrictionDetail.shortname))
					marketRestrictionDetail = new MarketRestrictionDetail(element);
				else if (name.equals(MarketPublishingStatus.refname) || name.equals(MarketPublishingStatus.shortname))
					marketPublishingStatus = new MarketPublishingStatus(element);
				else if (name.equals(MarketDate.refname) || name.equals(MarketDate.shortname))
					marketDates = JPU.addToList(marketDates, new MarketDate(element));
			}
		});
	}

	public String getAgentNameValue()
	{
		return (agentName == null) ? null : agentName.value;
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

	public String getAgentRoleValue()
	{
		return (agentRole == null) ? null : agentRole.value;
	}

	public java.util.Set<String> getMarketCountrySet()
	{
		return (marketCountry == null) ? null : marketCountry.value;
	}

	public java.util.Set<String> getMarketTerritorySet()
	{
		return (marketTerritory == null) ? null : marketTerritory.value;
	}

	public java.util.Set<String> getMarketCountryExcludedSet()
	{
		return (marketCountryExcluded == null) ? null : marketCountryExcluded.value;
	}

	public String getMarketRestrictionDetailValue()
	{
		return (marketRestrictionDetail == null) ? null : marketRestrictionDetail.value;
	}

	public String getMarketPublishingStatusValue()
	{
		return (marketPublishingStatus == null) ? null : marketPublishingStatus.value;
	}

	public JonixAgentIdentifier findAgentIdentifier(SupplierIdentifierTypes agentIDType)
	{
		if (agentIdentifiers != null)
		{
			for (AgentIdentifier x : agentIdentifiers)
			{
				if (x.getAgentIDTypeValue() == agentIDType)
					return x.asJonixAgentIdentifier();
			}
		}
		return null;
	}

	public List<JonixAgentIdentifier> findAgentIdentifiers(java.util.Set<SupplierIdentifierTypes> agentIDTypes)
	{
		if (agentIdentifiers != null)
		{
			List<JonixAgentIdentifier> matches = new ArrayList<>();
			for (AgentIdentifier x : agentIdentifiers)
			{
				if (agentIDTypes == null || agentIDTypes.contains(x.getAgentIDTypeValue()))
					matches.add(x.asJonixAgentIdentifier());
			}
			return matches;
		}
		return null;
	}

	public JonixMarketDate findMarketDate(PublishingDateRoles marketDateRole)
	{
		if (marketDates != null)
		{
			for (MarketDate x : marketDates)
			{
				if (x.getMarketDateRoleValue() == marketDateRole)
					return x.asJonixMarketDate();
			}
		}
		return null;
	}

	public List<JonixMarketDate> findMarketDates(java.util.Set<PublishingDateRoles> marketDateRoles)
	{
		if (marketDates != null)
		{
			List<JonixMarketDate> matches = new ArrayList<>();
			for (MarketDate x : marketDates)
			{
				if (marketDateRoles == null || marketDateRoles.contains(x.getMarketDateRoleValue()))
					matches.add(x.asJonixMarketDate());
			}
			return matches;
		}
		return null;
	}
}
