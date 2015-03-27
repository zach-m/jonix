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
import com.tectonica.jonix.codelist.ContentAudiences;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ResourceContentTypes;
import com.tectonica.jonix.codelist.ResourceFeatureTypes;
import com.tectonica.jonix.codelist.ResourceModes;
import com.tectonica.jonix.struct.JonixResourceFeature;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class SupportingResource implements Serializable
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

	public SupportingResource()
	{}

	public SupportingResource(org.w3c.dom.Element element)
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
				if (name.equals(ResourceContentType.refname) || name.equals(ResourceContentType.shortname))
					resourceContentType = new ResourceContentType(element);
				else if (name.equals(ContentAudience.refname) || name.equals(ContentAudience.shortname))
					contentAudiences = JPU.addToList(contentAudiences, new ContentAudience(element));
				else if (name.equals(ResourceMode.refname) || name.equals(ResourceMode.shortname))
					resourceMode = new ResourceMode(element);
				else if (name.equals(ResourceFeature.refname) || name.equals(ResourceFeature.shortname))
					resourceFeatures = JPU.addToList(resourceFeatures, new ResourceFeature(element));
				else if (name.equals(ResourceVersion.refname) || name.equals(ResourceVersion.shortname))
					resourceVersions = JPU.addToList(resourceVersions, new ResourceVersion(element));
			}
		});
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

	public JonixResourceFeature findResourceFeature(ResourceFeatureTypes resourceFeatureType)
	{
		if (resourceFeatures != null)
		{
			for (ResourceFeature x : resourceFeatures)
			{
				if (x.getResourceFeatureTypeValue() == resourceFeatureType)
					return x.asStruct();
			}
		}
		return null;
	}

	public List<JonixResourceFeature> findResourceFeatures(java.util.Set<ResourceFeatureTypes> resourceFeatureTypes)
	{
		if (resourceFeatures != null)
		{
			List<JonixResourceFeature> matches = new ArrayList<>();
			for (ResourceFeature x : resourceFeatures)
			{
				if (resourceFeatureTypes == null || resourceFeatureTypes.contains(x.getResourceFeatureTypeValue()))
					matches.add(x.asStruct());
			}
			return matches;
		}
		return null;
	}
}
