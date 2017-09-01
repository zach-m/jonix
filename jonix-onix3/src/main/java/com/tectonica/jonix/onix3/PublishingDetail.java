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
import java.util.Collections;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixPublishingDate;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>null</h1>
 * <h4 class="nobreak">Publishing detail composite</h4>
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

	/////////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	/////////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	/////////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTION
	/////////////////////////////////////////////////////////////////////////////////

	private boolean initialized;
	private final boolean exists;
	private final org.w3c.dom.Element element;
	public static final PublishingDetail EMPTY = new PublishingDetail();

	public PublishingDetail()
	{
		exists = false;
		element = null;
		initialized = true; // so that no further processing will be done on this intentionally-empty object
	}

	public PublishingDetail(org.w3c.dom.Element element)
	{
		exists = true;
		initialized = false;
		this.element = element;
	}

	private void initialize()
	{
		if (initialized)
			return;
		initialized = true;

		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, e -> {
			final String name = e.getNodeName();
			if (name.equals(Imprint.refname) || name.equals(Imprint.shortname))
				imprints = JPU.addToList(imprints, new Imprint(e));
			else if (name.equals(Publisher.refname) || name.equals(Publisher.shortname))
				publishers = JPU.addToList(publishers, new Publisher(e));
			else if (name.equals(CityOfPublication.refname) || name.equals(CityOfPublication.shortname))
				cityOfPublications = JPU.addToList(cityOfPublications, new CityOfPublication(e));
			else if (name.equals(CountryOfPublication.refname) || name.equals(CountryOfPublication.shortname))
				countryOfPublication = new CountryOfPublication(e);
			else if (name.equals(ProductContact.refname) || name.equals(ProductContact.shortname))
				productContacts = JPU.addToList(productContacts, new ProductContact(e));
			else if (name.equals(PublishingStatus.refname) || name.equals(PublishingStatus.shortname))
				publishingStatus = new PublishingStatus(e);
			else if (name.equals(PublishingStatusNote.refname) || name.equals(PublishingStatusNote.shortname))
				publishingStatusNotes = JPU.addToList(publishingStatusNotes, new PublishingStatusNote(e));
			else if (name.equals(PublishingDate.refname) || name.equals(PublishingDate.shortname))
				publishingDates = JPU.addToList(publishingDates, new PublishingDate(e));
			else if (name.equals(LatestReprintNumber.refname) || name.equals(LatestReprintNumber.shortname))
				latestReprintNumber = new LatestReprintNumber(e);
			else if (name.equals(CopyrightStatement.refname) || name.equals(CopyrightStatement.shortname))
				copyrightStatements = JPU.addToList(copyrightStatements, new CopyrightStatement(e));
			else if (name.equals(SalesRights.refname) || name.equals(SalesRights.shortname))
				salesRightss = JPU.addToList(salesRightss, new SalesRights(e));
			else if (name.equals(ROWSalesRightsType.refname) || name.equals(ROWSalesRightsType.shortname))
				rowSalesRightsType = new ROWSalesRightsType(e);
			else if (name.equals(SalesRestriction.refname) || name.equals(SalesRestriction.shortname))
				salesRestrictions = JPU.addToList(salesRestrictions, new SalesRestriction(e));
		});
	}

	@Override
	public boolean exists()
	{
		return exists;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	/////////////////////////////////////////////////////////////////////////////////

	private List<Imprint> imprints = Collections.emptyList();

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<Imprint> imprints()
	{
		initialize();
		return imprints;
	}

	private List<Publisher> publishers = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<Publisher> publishers()
	{
		initialize();
		return publishers;
	}

	private ListOfOnixElement<CityOfPublication, String> cityOfPublications = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<CityOfPublication, String> cityOfPublications()
	{
		initialize();
		return cityOfPublications;
	}

	private CountryOfPublication countryOfPublication = CountryOfPublication.EMPTY;

	/**
	 * (this field is optional)
	 */
	public CountryOfPublication countryOfPublication()
	{
		initialize();
		return countryOfPublication;
	}

	private List<ProductContact> productContacts = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<ProductContact> productContacts()
	{
		initialize();
		return productContacts;
	}

	private PublishingStatus publishingStatus = PublishingStatus.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PublishingStatus publishingStatus()
	{
		initialize();
		return publishingStatus;
	}

	private ListOfOnixElement<PublishingStatusNote, String> publishingStatusNotes = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<PublishingStatusNote, String> publishingStatusNotes()
	{
		initialize();
		return publishingStatusNotes;
	}

	private ListOfOnixDataCompositeWithKey<PublishingDate, JonixPublishingDate, PublishingDateRoles> publishingDates = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<PublishingDate, JonixPublishingDate, PublishingDateRoles> publishingDates()
	{
		initialize();
		return publishingDates;
	}

	private LatestReprintNumber latestReprintNumber = LatestReprintNumber.EMPTY;

	/**
	 * (this field is optional)
	 */
	public LatestReprintNumber latestReprintNumber()
	{
		initialize();
		return latestReprintNumber;
	}

	private List<CopyrightStatement> copyrightStatements = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<CopyrightStatement> copyrightStatements()
	{
		initialize();
		return copyrightStatements;
	}

	private List<SalesRights> salesRightss = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<SalesRights> salesRightss()
	{
		initialize();
		return salesRightss;
	}

	private ROWSalesRightsType rowSalesRightsType = ROWSalesRightsType.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ROWSalesRightsType rowSalesRightsType()
	{
		initialize();
		return rowSalesRightsType;
	}

	private List<SalesRestriction> salesRestrictions = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<SalesRestriction> salesRestrictions()
	{
		initialize();
		return salesRestrictions;
	}
}
