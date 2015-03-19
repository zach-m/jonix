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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.PublishingRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Publisher
{
	public static final String refname = "Publisher";
	public static final String shortname = "publisher";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public PublishingRole publishingRole; // Required
	public List<PublisherIdentifier> publisherIdentifiers; // OneOrMore
	public PublisherName publisherName; // Optional
	public List<Website> websites; // ZeroOrMore

	public static Publisher fromDoc(org.w3c.dom.Element element)
	{
		final Publisher x = new Publisher();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(PublishingRole.refname) || name.equals(PublishingRole.shortname))
					x.publishingRole = PublishingRole.fromDoc(element);
				else if (name.equals(PublisherIdentifier.refname) || name.equals(PublisherIdentifier.shortname))
					x.publisherIdentifiers = DU.addToList(x.publisherIdentifiers, PublisherIdentifier.fromDoc(element));
				else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname))
					x.publisherName = PublisherName.fromDoc(element);
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
			}
		});

		return x;
	}

	public PublishingRoles getPublishingRoleValue()
	{
		return (publishingRole == null) ? null : publishingRole.value;
	}

	public String getPublisherNameValue()
	{
		return (publisherName == null) ? null : publisherName.value;
	}
}
