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
import com.tectonica.jonix.codelist.ReligiousTextFeatureTypes;
import com.tectonica.jonix.codelist.ReligiousTextFeatures;
import com.tectonica.jonix.struct.JonixReligiousTextFeature;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Religious text feature composite</h1>
 * <p>
 * A repeatable group of data elements which together specify and describe a feature of a religious text. Mandatory if
 * and only if &lt;ReligiousTextIdentifier&gt; is present.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ReligiousTextFeature&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;religioustextfeature&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class ReligiousTextFeature implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ReligiousTextFeature";
	public static final String shortname = "religioustextfeature";

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
	public ReligiousTextFeatureType religiousTextFeatureType;

	/**
	 * (this field is required)
	 */
	public ReligiousTextFeatureCode religiousTextFeatureCode;

	/**
	 * (this list may be empty)
	 */
	public List<ReligiousTextFeatureDescription> religiousTextFeatureDescriptions;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ReligiousTextFeature()
	{}

	public ReligiousTextFeature(org.w3c.dom.Element element)
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
				if (name.equals(ReligiousTextFeatureType.refname) || name.equals(ReligiousTextFeatureType.shortname))
					religiousTextFeatureType = new ReligiousTextFeatureType(element);
				else if (name.equals(ReligiousTextFeatureCode.refname)
						|| name.equals(ReligiousTextFeatureCode.shortname))
					religiousTextFeatureCode = new ReligiousTextFeatureCode(element);
				else if (name.equals(ReligiousTextFeatureDescription.refname)
						|| name.equals(ReligiousTextFeatureDescription.shortname))
					religiousTextFeatureDescriptions = JPU.addToList(religiousTextFeatureDescriptions,
							new ReligiousTextFeatureDescription(element));
			}
		});
	}

	public ReligiousTextFeatureTypes getReligiousTextFeatureTypeValue()
	{
		return (religiousTextFeatureType == null) ? null : religiousTextFeatureType.value;
	}

	public ReligiousTextFeatures getReligiousTextFeatureCodeValue()
	{
		return (religiousTextFeatureCode == null) ? null : religiousTextFeatureCode.value;
	}

	public List<String> getReligiousTextFeatureDescriptionValues()
	{
		if (religiousTextFeatureDescriptions != null)
		{
			List<String> list = new ArrayList<>();
			for (ReligiousTextFeatureDescription i : religiousTextFeatureDescriptions)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public JonixReligiousTextFeature asJonixReligiousTextFeature()
	{
		JonixReligiousTextFeature x = new JonixReligiousTextFeature();
		x.religiousTextFeatureType = getReligiousTextFeatureTypeValue();
		x.religiousTextFeatureCode = getReligiousTextFeatureCodeValue();
		x.religiousTextFeatureDescriptions = getReligiousTextFeatureDescriptionValues();
		return x;
	}
}
