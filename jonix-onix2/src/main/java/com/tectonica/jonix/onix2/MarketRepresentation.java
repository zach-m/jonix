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

import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class MarketRepresentation
{
	public static final String refname = "MarketRepresentation";
	public static final String shortname = "marketrepresentation";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<AgentIdentifier> agentIdentifiers; // OneOrMore
	public AgentName agentName; // Optional
	public List<TelephoneNumber> telephoneNumbers; // ZeroOrMore
	public List<FaxNumber> faxNumbers; // ZeroOrMore
	public List<EmailAddress> emailAddresss; // ZeroOrMore
	public List<Website> websites; // ZeroOrMore
	public AgentRole agentRole; // Optional
	public MarketCountry marketCountry; // Optional
	public MarketTerritory marketTerritory; // Required
	public MarketCountryExcluded marketCountryExcluded; // Optional
	public MarketRestrictionDetail marketRestrictionDetail; // Optional
	public MarketPublishingStatus marketPublishingStatus; // Optional
	public List<MarketDate> marketDates; // ZeroOrMore

	public static MarketRepresentation fromDoc(org.w3c.dom.Element element)
	{
		final MarketRepresentation x = new MarketRepresentation();

		x.textformat = TextFormats.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(AgentIdentifier.refname) || name.equals(AgentIdentifier.shortname))
					x.agentIdentifiers = DU.addToList(x.agentIdentifiers, AgentIdentifier.fromDoc(element));
				else if (name.equals(AgentName.refname) || name.equals(AgentName.shortname))
					x.agentName = AgentName.fromDoc(element);
				else if (name.equals(TelephoneNumber.refname) || name.equals(TelephoneNumber.shortname))
					x.telephoneNumbers = DU.addToList(x.telephoneNumbers, TelephoneNumber.fromDoc(element));
				else if (name.equals(FaxNumber.refname) || name.equals(FaxNumber.shortname))
					x.faxNumbers = DU.addToList(x.faxNumbers, FaxNumber.fromDoc(element));
				else if (name.equals(EmailAddress.refname) || name.equals(EmailAddress.shortname))
					x.emailAddresss = DU.addToList(x.emailAddresss, EmailAddress.fromDoc(element));
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
				else if (name.equals(AgentRole.refname) || name.equals(AgentRole.shortname))
					x.agentRole = AgentRole.fromDoc(element);
				else if (name.equals(MarketCountry.refname) || name.equals(MarketCountry.shortname))
					x.marketCountry = MarketCountry.fromDoc(element);
				else if (name.equals(MarketTerritory.refname) || name.equals(MarketTerritory.shortname))
					x.marketTerritory = MarketTerritory.fromDoc(element);
				else if (name.equals(MarketCountryExcluded.refname) || name.equals(MarketCountryExcluded.shortname))
					x.marketCountryExcluded = MarketCountryExcluded.fromDoc(element);
				else if (name.equals(MarketRestrictionDetail.refname) || name.equals(MarketRestrictionDetail.shortname))
					x.marketRestrictionDetail = MarketRestrictionDetail.fromDoc(element);
				else if (name.equals(MarketPublishingStatus.refname) || name.equals(MarketPublishingStatus.shortname))
					x.marketPublishingStatus = MarketPublishingStatus.fromDoc(element);
				else if (name.equals(MarketDate.refname) || name.equals(MarketDate.shortname))
					x.marketDates = DU.addToList(x.marketDates, MarketDate.fromDoc(element));
			}
		});

		return x;
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
}
