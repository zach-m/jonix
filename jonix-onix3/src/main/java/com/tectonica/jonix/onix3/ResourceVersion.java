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

import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ResourceForms;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class ResourceVersion
{
	public static final String refname = "ResourceVersion";
	public static final String shortname = "resourceversion";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public ResourceForm resourceForm; // Required
	public List<ResourceVersionFeature> resourceVersionFeatures; // ZeroOrMore
	public List<ResourceLink> resourceLinks; // OneOrMore
	public List<ContentDate> contentDates; // ZeroOrMore

	public static ResourceVersion fromDoc(org.w3c.dom.Element element)
	{
		final ResourceVersion x = new ResourceVersion();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ResourceForm.refname) || name.equals(ResourceForm.shortname))
					x.resourceForm = ResourceForm.fromDoc(element);
				else if (name.equals(ResourceVersionFeature.refname) || name.equals(ResourceVersionFeature.shortname))
					x.resourceVersionFeatures = DU.addToList(x.resourceVersionFeatures, ResourceVersionFeature.fromDoc(element));
				else if (name.equals(ResourceLink.refname) || name.equals(ResourceLink.shortname))
					x.resourceLinks = DU.addToList(x.resourceLinks, ResourceLink.fromDoc(element));
				else if (name.equals(ContentDate.refname) || name.equals(ContentDate.shortname))
					x.contentDates = DU.addToList(x.contentDates, ContentDate.fromDoc(element));
			}
		});

		return x;
	}

	public ResourceForms getResourceFormValue()
	{
		return (resourceForm == null) ? null : resourceForm.value;
	}

	public List<String> getResourceLinkValues()
	{
		if (resourceLinks != null)
		{
			List<String> list = new ArrayList<>();
			for (ResourceLink i : resourceLinks)
				list.add(i.value);
			return list;
		}
		return null;
	}
}
