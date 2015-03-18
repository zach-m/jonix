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

public class ResourceVersion
{
	public static final String refname = "ResourceVersion";
	public static final String shortname = "resourceversion";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public ResourceForm resourceForm; // Required
	public List<ResourceVersionFeature> resourceVersionFeatures; // ZeroOrMore
	public List<ResourceLink> resourceLinks; // OneOrMore
	public List<ContentDate> contentDates; // ZeroOrMore

	public static ResourceVersion fromDoc(org.w3c.dom.Element element)
	{
		final ResourceVersion x = new ResourceVersion();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(ResourceForm.refname) || name.equalsIgnoreCase(ResourceForm.shortname))
					x.resourceForm = ResourceForm.fromDoc(element);
				else if (name.equalsIgnoreCase(ResourceVersionFeature.refname) || name.equalsIgnoreCase(ResourceVersionFeature.shortname))
					x.resourceVersionFeatures = DU.addToList(x.resourceVersionFeatures, ResourceVersionFeature.fromDoc(element));
				else if (name.equalsIgnoreCase(ResourceLink.refname) || name.equalsIgnoreCase(ResourceLink.shortname))
					x.resourceLinks = DU.addToList(x.resourceLinks, ResourceLink.fromDoc(element));
				else if (name.equalsIgnoreCase(ContentDate.refname) || name.equalsIgnoreCase(ContentDate.shortname))
					x.contentDates = DU.addToList(x.contentDates, ContentDate.fromDoc(element));
			}
		});

		return x;
	}
}
