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
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ResourceFeatureTypes;
import com.tectonica.jonix.struct.JonixResourceFeature;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Resource feature composite</h1>
 * <p>
 * A repeatable group of data elements which together describe a feature of a supporting resource which is common to all
 * versions in which the resource is offered. Optional.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ResourceFeature&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;resourcefeature&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class ResourceFeature implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ResourceFeature";
	public static final String shortname = "resourcefeature";

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
	public ResourceFeatureType resourceFeatureType;

	/**
	 * (this field is optional)
	 */
	public FeatureValue featureValue;

	/**
	 * (this list may be empty)
	 */
	public List<FeatureNote> featureNotes;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ResourceFeature()
	{}

	public ResourceFeature(org.w3c.dom.Element element)
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
				if (name.equals(ResourceFeatureType.refname) || name.equals(ResourceFeatureType.shortname))
					resourceFeatureType = new ResourceFeatureType(element);
				else if (name.equals(FeatureValue.refname) || name.equals(FeatureValue.shortname))
					featureValue = new FeatureValue(element);
				else if (name.equals(FeatureNote.refname) || name.equals(FeatureNote.shortname))
					featureNotes = JPU.addToList(featureNotes, new FeatureNote(element));
			}
		});
	}

	public ResourceFeatureTypes getResourceFeatureTypeValue()
	{
		return (resourceFeatureType == null) ? null : resourceFeatureType.value;
	}

	/**
	 * Raw Format: Dependent on the feature specified in &lt;ResourceVersionFeatureType&gt;; the feature value may or
	 * may not be taken from a code list
	 */
	public String getFeatureValueValue()
	{
		return (featureValue == null) ? null : featureValue.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 300 characters. XHTML is enabled in this element - see
	 * Using XHTML, HTML or XML with ONIX text fields
	 */
	public List<String> getFeatureNoteValues()
	{
		if (featureNotes != null)
		{
			List<String> list = new ArrayList<>();
			for (FeatureNote i : featureNotes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public JonixResourceFeature asJonixResourceFeature()
	{
		JonixResourceFeature x = new JonixResourceFeature();
		x.resourceFeatureType = getResourceFeatureTypeValue();
		x.featureValue = getFeatureValueValue();
		x.featureNotes = getFeatureNoteValues();
		return x;
	}
}
