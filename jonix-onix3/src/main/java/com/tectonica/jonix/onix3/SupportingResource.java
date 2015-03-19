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
import com.tectonica.jonix.codelist.ContentAudiences;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ResourceContentTypes;
import com.tectonica.jonix.codelist.ResourceModes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class SupportingResource
{
	public static final String refname = "SupportingResource";
	public static final String shortname = "supportingresource";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public ResourceContentType resourceContentType; // Required
	public List<ContentAudience> contentAudiences; // OneOrMore
	public ResourceMode resourceMode; // Required
	public List<ResourceFeature> resourceFeatures; // ZeroOrMore
	public List<ResourceVersion> resourceVersions; // OneOrMore

	public static SupportingResource fromDoc(org.w3c.dom.Element element)
	{
		final SupportingResource x = new SupportingResource();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ResourceContentType.refname) || name.equals(ResourceContentType.shortname))
					x.resourceContentType = ResourceContentType.fromDoc(element);
				else if (name.equals(ContentAudience.refname) || name.equals(ContentAudience.shortname))
					x.contentAudiences = DU.addToList(x.contentAudiences, ContentAudience.fromDoc(element));
				else if (name.equals(ResourceMode.refname) || name.equals(ResourceMode.shortname))
					x.resourceMode = ResourceMode.fromDoc(element);
				else if (name.equals(ResourceFeature.refname) || name.equals(ResourceFeature.shortname))
					x.resourceFeatures = DU.addToList(x.resourceFeatures, ResourceFeature.fromDoc(element));
				else if (name.equals(ResourceVersion.refname) || name.equals(ResourceVersion.shortname))
					x.resourceVersions = DU.addToList(x.resourceVersions, ResourceVersion.fromDoc(element));
			}
		});

		return x;
	}

	public ResourceContentTypes getResourceContentTypeValue()
	{
		return (resourceContentType == null) ? null : resourceContentType.value;
	}

	public List<ContentAudiences> getContentAudienceValues()
	{
		if (contentAudiences != null)
		{
			List<ContentAudiences> list = new ArrayList<>();
			for (ContentAudience i : contentAudiences)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public ResourceModes getResourceModeValue()
	{
		return (resourceMode == null) ? null : resourceMode.value;
	}
}
