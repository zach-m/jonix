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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class PublishingDetail
{
	public static final String refname = "PublishingDetail";
	public static final String shortname = "publishingdetail";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
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

	public static PublishingDetail fromDoc(org.w3c.dom.Element element)
	{
		final PublishingDetail x = new PublishingDetail();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(Imprint.refname) || name.equals(Imprint.shortname))
					x.imprints = DU.addToList(x.imprints, Imprint.fromDoc(element));
				else if (name.equals(Publisher.refname) || name.equals(Publisher.shortname))
					x.publishers = DU.addToList(x.publishers, Publisher.fromDoc(element));
				else if (name.equals(CityOfPublication.refname) || name.equals(CityOfPublication.shortname))
					x.cityOfPublications = DU.addToList(x.cityOfPublications, CityOfPublication.fromDoc(element));
				else if (name.equals(CountryOfPublication.refname) || name.equals(CountryOfPublication.shortname))
					x.countryOfPublication = CountryOfPublication.fromDoc(element);
				else if (name.equals(ProductContact.refname) || name.equals(ProductContact.shortname))
					x.productContacts = DU.addToList(x.productContacts, ProductContact.fromDoc(element));
				else if (name.equals(PublishingStatus.refname) || name.equals(PublishingStatus.shortname))
					x.publishingStatus = PublishingStatus.fromDoc(element);
				else if (name.equals(PublishingStatusNote.refname) || name.equals(PublishingStatusNote.shortname))
					x.publishingStatusNotes = DU.addToList(x.publishingStatusNotes, PublishingStatusNote.fromDoc(element));
				else if (name.equals(PublishingDate.refname) || name.equals(PublishingDate.shortname))
					x.publishingDates = DU.addToList(x.publishingDates, PublishingDate.fromDoc(element));
				else if (name.equals(LatestReprintNumber.refname) || name.equals(LatestReprintNumber.shortname))
					x.latestReprintNumber = LatestReprintNumber.fromDoc(element);
				else if (name.equals(CopyrightStatement.refname) || name.equals(CopyrightStatement.shortname))
					x.copyrightStatements = DU.addToList(x.copyrightStatements, CopyrightStatement.fromDoc(element));
				else if (name.equals(SalesRights.refname) || name.equals(SalesRights.shortname))
					x.salesRightss = DU.addToList(x.salesRightss, SalesRights.fromDoc(element));
				else if (name.equals(ROWSalesRightsType.refname) || name.equals(ROWSalesRightsType.shortname))
					x.rowSalesRightsType = ROWSalesRightsType.fromDoc(element);
				else if (name.equals(SalesRestriction.refname) || name.equals(SalesRestriction.shortname))
					x.salesRestrictions = DU.addToList(x.salesRestrictions, SalesRestriction.fromDoc(element));
			}
		});

		return x;
	}
}
