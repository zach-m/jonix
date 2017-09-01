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
import com.tectonica.jonix.codelist.ContentAudiences;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ResourceFeatureTypes;
import com.tectonica.jonix.struct.JonixResourceFeature;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
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
	public static final SupportingResource EMPTY = new SupportingResource();

	public SupportingResource()
	{
		exists = false;
		element = null;
		initialized = true; // so that no further processing will be done on this intentionally-empty object
	}

	public SupportingResource(org.w3c.dom.Element element)
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
			if (name.equals(ResourceContentType.refname) || name.equals(ResourceContentType.shortname))
				resourceContentType = new ResourceContentType(e);
			else if (name.equals(ContentAudience.refname) || name.equals(ContentAudience.shortname))
				contentAudiences = JPU.addToList(contentAudiences, new ContentAudience(e));
			else if (name.equals(ResourceMode.refname) || name.equals(ResourceMode.shortname))
				resourceMode = new ResourceMode(e);
			else if (name.equals(ResourceFeature.refname) || name.equals(ResourceFeature.shortname))
				resourceFeatures = JPU.addToList(resourceFeatures, new ResourceFeature(e));
			else if (name.equals(ResourceVersion.refname) || name.equals(ResourceVersion.shortname))
				resourceVersions = JPU.addToList(resourceVersions, new ResourceVersion(e));
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

	private ResourceContentType resourceContentType = ResourceContentType.EMPTY;

	/**
	 * (this field is required)
	 */
	public ResourceContentType resourceContentType()
	{
		initialize();
		return resourceContentType;
	}

	private ListOfOnixElement<ContentAudience, ContentAudiences> contentAudiences = ListOfOnixElement.empty();

	/**
	 * (this list is required to contain at least one item)
	 */
	public ListOfOnixElement<ContentAudience, ContentAudiences> contentAudiences()
	{
		initialize();
		return contentAudiences;
	}

	private ResourceMode resourceMode = ResourceMode.EMPTY;

	/**
	 * (this field is required)
	 */
	public ResourceMode resourceMode()
	{
		initialize();
		return resourceMode;
	}

	private ListOfOnixDataCompositeWithKey<ResourceFeature, JonixResourceFeature, ResourceFeatureTypes> resourceFeatures = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<ResourceFeature, JonixResourceFeature, ResourceFeatureTypes> resourceFeatures()
	{
		initialize();
		return resourceFeatures;
	}

	private List<ResourceVersion> resourceVersions = Collections.emptyList();

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<ResourceVersion> resourceVersions()
	{
		initialize();
		return resourceVersions;
	}
}
