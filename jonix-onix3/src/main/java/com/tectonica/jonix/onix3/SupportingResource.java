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
import com.tectonica.jonix.codelist.ContentAudiences;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ResourceContentTypes;
import com.tectonica.jonix.codelist.ResourceFeatureTypes;
import com.tectonica.jonix.codelist.ResourceModes;
import com.tectonica.jonix.struct.JonixResourceFeature;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Supporting resource composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together specify a supporting resource, used here to indicate
 * that there is a new cover or jacket image, or other supporting resource, for a forthcoming reissue. Deprecated in
 * this context.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;SupportingResource&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;supportingresource&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class SupportingResource implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "SupportingResource";
	public static final String shortname = "supportingresource";

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
	public ResourceContentType resourceContentType;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<ContentAudience> contentAudiences;

	/**
	 * (this field is required)
	 */
	public ResourceMode resourceMode;

	/**
	 * (this list may be empty)
	 */
	public List<ResourceFeature> resourceFeatures;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<ResourceVersion> resourceVersions;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public SupportingResource()
	{}

	public SupportingResource(org.w3c.dom.Element element)
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
					return x.asJonixResourceFeature();
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
					matches.add(x.asJonixResourceFeature());
			}
			return matches;
		}
		return null;
	}
}
