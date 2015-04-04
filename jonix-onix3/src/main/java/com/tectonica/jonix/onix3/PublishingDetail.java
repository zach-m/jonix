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
import com.tectonica.jonix.OnixComposite;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.codelist.PublishingStatuss;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.struct.JonixPublishingDate;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class PublishingDetail implements OnixComposite, Serializable
{
	public static final String refname = "PublishingDetail";
	public static final String shortname = "publishingdetail";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<Imprint> imprints; // OneOrMore
	public List<Publisher> publishers; // ZeroOrMore
	public List<CityOfPublication> cityOfPublications; // ZeroOrMore
	public CountryOfPublication countryOfPublication; // Optional
	public List<ProductContact> productContacts; // ZeroOrMore
	public PublishingStatus publishingStatus; // Optional
	public List<PublishingStatusNote> publishingStatusNotes; // ZeroOrMore
	public List<PublishingDate> publishingDates; // ZeroOrMore
	public LatestReprintNumber latestReprintNumber; // Optional
	public List<CopyrightStatement> copyrightStatements; // ZeroOrMore
	public List<SalesRights> salesRightss; // ZeroOrMore
	public ROWSalesRightsType rowSalesRightsType; // Optional
	public List<SalesRestriction> salesRestrictions; // ZeroOrMore

	public PublishingDetail()
	{}

	public PublishingDetail(org.w3c.dom.Element element)
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
				if (name.equals(Imprint.refname) || name.equals(Imprint.shortname))
					imprints = JPU.addToList(imprints, new Imprint(element));
				else if (name.equals(Publisher.refname) || name.equals(Publisher.shortname))
					publishers = JPU.addToList(publishers, new Publisher(element));
				else if (name.equals(CityOfPublication.refname) || name.equals(CityOfPublication.shortname))
					cityOfPublications = JPU.addToList(cityOfPublications, new CityOfPublication(element));
				else if (name.equals(CountryOfPublication.refname) || name.equals(CountryOfPublication.shortname))
					countryOfPublication = new CountryOfPublication(element);
				else if (name.equals(ProductContact.refname) || name.equals(ProductContact.shortname))
					productContacts = JPU.addToList(productContacts, new ProductContact(element));
				else if (name.equals(PublishingStatus.refname) || name.equals(PublishingStatus.shortname))
					publishingStatus = new PublishingStatus(element);
				else if (name.equals(PublishingStatusNote.refname) || name.equals(PublishingStatusNote.shortname))
					publishingStatusNotes = JPU.addToList(publishingStatusNotes, new PublishingStatusNote(element));
				else if (name.equals(PublishingDate.refname) || name.equals(PublishingDate.shortname))
					publishingDates = JPU.addToList(publishingDates, new PublishingDate(element));
				else if (name.equals(LatestReprintNumber.refname) || name.equals(LatestReprintNumber.shortname))
					latestReprintNumber = new LatestReprintNumber(element);
				else if (name.equals(CopyrightStatement.refname) || name.equals(CopyrightStatement.shortname))
					copyrightStatements = JPU.addToList(copyrightStatements, new CopyrightStatement(element));
				else if (name.equals(SalesRights.refname) || name.equals(SalesRights.shortname))
					salesRightss = JPU.addToList(salesRightss, new SalesRights(element));
				else if (name.equals(ROWSalesRightsType.refname) || name.equals(ROWSalesRightsType.shortname))
					rowSalesRightsType = new ROWSalesRightsType(element);
				else if (name.equals(SalesRestriction.refname) || name.equals(SalesRestriction.shortname))
					salesRestrictions = JPU.addToList(salesRestrictions, new SalesRestriction(element));
			}
		});
	}

	public List<String> getCityOfPublicationValues()
	{
		if (cityOfPublications != null)
		{
			List<String> list = new ArrayList<>();
			for (CityOfPublication i : cityOfPublications)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public CountryCodeIso31661s getCountryOfPublicationValue()
	{
		return (countryOfPublication == null) ? null : countryOfPublication.value;
	}

	public PublishingStatuss getPublishingStatusValue()
	{
		return (publishingStatus == null) ? null : publishingStatus.value;
	}

	public List<String> getPublishingStatusNoteValues()
	{
		if (publishingStatusNotes != null)
		{
			List<String> list = new ArrayList<>();
			for (PublishingStatusNote i : publishingStatusNotes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public Integer getLatestReprintNumberValue()
	{
		return (latestReprintNumber == null) ? null : latestReprintNumber.value;
	}

	public SalesRightsTypes getROWSalesRightsTypeValue()
	{
		return (rowSalesRightsType == null) ? null : rowSalesRightsType.value;
	}

	public JonixPublishingDate findPublishingDate(PublishingDateRoles publishingDateRole)
	{
		if (publishingDates != null)
		{
			for (PublishingDate x : publishingDates)
			{
				if (x.getPublishingDateRoleValue() == publishingDateRole)
					return x.asJonixPublishingDate();
			}
		}
		return null;
	}

	public List<JonixPublishingDate> findPublishingDates(java.util.Set<PublishingDateRoles> publishingDateRoles)
	{
		if (publishingDates != null)
		{
			List<JonixPublishingDate> matches = new ArrayList<>();
			for (PublishingDate x : publishingDates)
			{
				if (publishingDateRoles == null || publishingDateRoles.contains(x.getPublishingDateRoleValue()))
					matches.add(x.asJonixPublishingDate());
			}
			return matches;
		}
		return null;
	}
}
