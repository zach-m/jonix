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
import com.tectonica.jonix.codelist.CountryCodes;
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.codelist.PublishingStatuss;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.struct.JonixPublishingDate;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>null</h1><h4 class="nobreak">Publishing detail composite</h4>
 * <p>
 * The publishing detail block covers data element Groups P.19 to P.21, carrying information on the publisher(s),
 * ‘global’ publishing status, and rights attaching to a product. The block as a whole is non-repeating. It is mandatory
 * in any &lt;Product&gt; record unless the &lt;NotificationType&gt; in Group&nbsp;P.1 indicates that the record is an
 * update notice which carries only those blocks in which changes have occurred.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;PublishingDetail&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;publishingdetail&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 */
public class PublishingDetail implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "PublishingDetail";
	public static final String shortname = "publishingdetail";

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
	public List<Imprint> imprints;

	/**
	 * (this list may be empty)
	 */
	public List<Publisher> publishers;

	/**
	 * (this list may be empty)
	 */
	public List<CityOfPublication> cityOfPublications;

	/**
	 * (this field is optional)
	 */
	public CountryOfPublication countryOfPublication;

	/**
	 * (this list may be empty)
	 */
	public List<ProductContact> productContacts;

	/**
	 * (this field is optional)
	 */
	public PublishingStatus publishingStatus;

	/**
	 * (this list may be empty)
	 */
	public List<PublishingStatusNote> publishingStatusNotes;

	/**
	 * (this list may be empty)
	 */
	public List<PublishingDate> publishingDates;

	/**
	 * (this field is optional)
	 */
	public LatestReprintNumber latestReprintNumber;

	/**
	 * (this list may be empty)
	 */
	public List<CopyrightStatement> copyrightStatements;

	/**
	 * (this list may be empty)
	 */
	public List<SalesRights> salesRightss;

	/**
	 * (this field is optional)
	 */
	public ROWSalesRightsType rowSalesRightsType;

	/**
	 * (this list may be empty)
	 */
	public List<SalesRestriction> salesRestrictions;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public PublishingDetail()
	{}

	public PublishingDetail(org.w3c.dom.Element element)
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

	/**
	 * Format: Variable-length text, suggested maximum length 50 characters
	 */
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

	public CountryCodes getCountryOfPublicationValue()
	{
		return (countryOfPublication == null) ? null : countryOfPublication.value;
	}

	public PublishingStatuss getPublishingStatusValue()
	{
		return (publishingStatus == null) ? null : publishingStatus.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum 300 characters. XHTML is enabled in this element - see Using
	 * XHTML, HTML or XML with ONIX text fields
	 */
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

	/**
	 * Format: Integer, suggested maximum three digits
	 */
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
