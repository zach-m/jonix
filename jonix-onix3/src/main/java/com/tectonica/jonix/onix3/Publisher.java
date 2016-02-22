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
import com.tectonica.jonix.codelist.PublishingRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixPublisherIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Publisher composite</h1>
 * <p>
 * A repeatable group of data elements which together identify an entity which is associated with the publishing of a
 * product. The composite allows additional publishing roles to be introduced without adding new fields. Each occurrence
 * of the composite must carry a publishing role code and either a name identifier code or a name or both.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Publisher&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;publisher&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class Publisher implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Publisher";
	public static final String shortname = "publisher";

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
	 * (this field is required)
	 */
	public PublishingRole publishingRole;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<PublisherIdentifier> publisherIdentifiers;

	/**
	 * (this field is optional)
	 */
	public PublisherName publisherName;

	/**
	 * (this list may be empty)
	 */
	public List<Website> websites;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Publisher()
	{}

	public Publisher(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(PublishingRole.refname) || name.equals(PublishingRole.shortname))
					publishingRole = new PublishingRole(element);
				else if (name.equals(PublisherIdentifier.refname) || name.equals(PublisherIdentifier.shortname))
					publisherIdentifiers = JPU.addToList(publisherIdentifiers, new PublisherIdentifier(element));
				else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname))
					publisherName = new PublisherName(element);
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					websites = JPU.addToList(websites, new Website(element));
			}
		});
	}

	public PublishingRoles getPublishingRoleValue()
	{
		return (publishingRole == null) ? null : publishingRole.value;
	}

	/**
	 * Raw Format: Variable length text, suggested maximum length 100 characters
	 */
	public String getPublisherNameValue()
	{
		return (publisherName == null) ? null : publisherName.value;
	}

	public JonixPublisherIdentifier findPublisherIdentifier(NameCodeTypes publisherIDType)
	{
		if (publisherIdentifiers != null)
		{
			for (PublisherIdentifier x : publisherIdentifiers)
			{
				if (x.getPublisherIDTypeValue() == publisherIDType)
					return x.asJonixPublisherIdentifier();
			}
		}
		return null;
	}

	public List<JonixPublisherIdentifier> findPublisherIdentifiers(java.util.Set<NameCodeTypes> publisherIDTypes)
	{
		if (publisherIdentifiers != null)
		{
			List<JonixPublisherIdentifier> matches = new ArrayList<>();
			for (PublisherIdentifier x : publisherIdentifiers)
			{
				if (publisherIDTypes == null || publisherIDTypes.contains(x.getPublisherIDTypeValue()))
					matches.add(x.asJonixPublisherIdentifier());
			}
			return matches;
		}
		return null;
	}
}
