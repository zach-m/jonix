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
import com.tectonica.jonix.OnixComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ResourceVersionFeatureTypes;
import com.tectonica.jonix.struct.JonixResourceVersionFeature;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class ResourceVersionFeature implements OnixComposite, Serializable
{
	public static final String refname = "ResourceVersionFeature";
	public static final String shortname = "resourceversionfeature";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public ResourceVersionFeatureType resourceVersionFeatureType; // Required
	public FeatureValue featureValue; // Optional
	public List<FeatureNote> featureNotes; // ZeroOrMore

	public ResourceVersionFeature()
	{}

	public ResourceVersionFeature(org.w3c.dom.Element element)
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
				if (name.equals(ResourceVersionFeatureType.refname) || name.equals(ResourceVersionFeatureType.shortname))
					resourceVersionFeatureType = new ResourceVersionFeatureType(element);
				else if (name.equals(FeatureValue.refname) || name.equals(FeatureValue.shortname))
					featureValue = new FeatureValue(element);
				else if (name.equals(FeatureNote.refname) || name.equals(FeatureNote.shortname))
					featureNotes = JPU.addToList(featureNotes, new FeatureNote(element));
			}
		});
	}

	public ResourceVersionFeatureTypes getResourceVersionFeatureTypeValue()
	{
		return (resourceVersionFeatureType == null) ? null : resourceVersionFeatureType.value;
	}

	public String getFeatureValueValue()
	{
		return (featureValue == null) ? null : featureValue.value;
	}

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

	public JonixResourceVersionFeature asJonixResourceVersionFeature()
	{
		JonixResourceVersionFeature x = new JonixResourceVersionFeature();
		x.resourceVersionFeatureType = getResourceVersionFeatureTypeValue();
		x.featureValue = getFeatureValueValue();
		x.featureNotes = getFeatureNoteValues();
		return x;
	}
}
