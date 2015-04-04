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
import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.codelist.ContentDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ResourceForms;
import com.tectonica.jonix.codelist.ResourceVersionFeatureTypes;
import com.tectonica.jonix.struct.JonixContentDate;
import com.tectonica.jonix.struct.JonixResourceVersionFeature;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class ResourceVersion implements JonixComposite, Serializable
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

	public ResourceVersion()
	{}

	public ResourceVersion(org.w3c.dom.Element element)
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
				if (name.equals(ResourceForm.refname) || name.equals(ResourceForm.shortname))
					resourceForm = new ResourceForm(element);
				else if (name.equals(ResourceVersionFeature.refname) || name.equals(ResourceVersionFeature.shortname))
					resourceVersionFeatures = JPU.addToList(resourceVersionFeatures, new ResourceVersionFeature(element));
				else if (name.equals(ResourceLink.refname) || name.equals(ResourceLink.shortname))
					resourceLinks = JPU.addToList(resourceLinks, new ResourceLink(element));
				else if (name.equals(ContentDate.refname) || name.equals(ContentDate.shortname))
					contentDates = JPU.addToList(contentDates, new ContentDate(element));
			}
		});
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

	public JonixResourceVersionFeature findResourceVersionFeature(ResourceVersionFeatureTypes resourceVersionFeatureType)
	{
		if (resourceVersionFeatures != null)
		{
			for (ResourceVersionFeature x : resourceVersionFeatures)
			{
				if (x.getResourceVersionFeatureTypeValue() == resourceVersionFeatureType)
					return x.asJonixResourceVersionFeature();
			}
		}
		return null;
	}

	public List<JonixResourceVersionFeature> findResourceVersionFeatures(
			java.util.Set<ResourceVersionFeatureTypes> resourceVersionFeatureTypes)
	{
		if (resourceVersionFeatures != null)
		{
			List<JonixResourceVersionFeature> matches = new ArrayList<>();
			for (ResourceVersionFeature x : resourceVersionFeatures)
			{
				if (resourceVersionFeatureTypes == null || resourceVersionFeatureTypes.contains(x.getResourceVersionFeatureTypeValue()))
					matches.add(x.asJonixResourceVersionFeature());
			}
			return matches;
		}
		return null;
	}

	public JonixContentDate findContentDate(ContentDateRoles contentDateRole)
	{
		if (contentDates != null)
		{
			for (ContentDate x : contentDates)
			{
				if (x.getContentDateRoleValue() == contentDateRole)
					return x.asJonixContentDate();
			}
		}
		return null;
	}

	public List<JonixContentDate> findContentDates(java.util.Set<ContentDateRoles> contentDateRoles)
	{
		if (contentDates != null)
		{
			List<JonixContentDate> matches = new ArrayList<>();
			for (ContentDate x : contentDates)
			{
				if (contentDateRoles == null || contentDateRoles.contains(x.getContentDateRoleValue()))
					matches.add(x.asJonixContentDate());
			}
			return matches;
		}
		return null;
	}
}
