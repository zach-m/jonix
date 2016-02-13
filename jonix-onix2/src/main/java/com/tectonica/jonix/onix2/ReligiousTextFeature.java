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

package com.tectonica.jonix.onix2;

import java.io.Serializable;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ReligiousTextFeatureTypes;
import com.tectonica.jonix.codelist.ReligiousTextFeatures;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixReligiousTextFeature;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class ReligiousTextFeature implements OnixDataComposite, Serializable
{
	public static final String refname = "ReligiousTextFeature";
	public static final String shortname = "religioustextfeature";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	public TextFormats textformat;

	public TextCaseFlags textcase;

	public LanguageCodes language;

	public TransliterationSchemes transliteration;

	/**
	 * (type: DateOrDateTime)
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
	 * (this field is optional)
	 */
	public ReligiousTextFeatureDescription religiousTextFeatureDescription;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ReligiousTextFeature()
	{}

	public ReligiousTextFeature(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
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
					religiousTextFeatureDescription = new ReligiousTextFeatureDescription(element);
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

	public String getReligiousTextFeatureDescriptionValue()
	{
		return (religiousTextFeatureDescription == null) ? null : religiousTextFeatureDescription.value;
	}

	public JonixReligiousTextFeature asJonixReligiousTextFeature()
	{
		JonixReligiousTextFeature x = new JonixReligiousTextFeature();
		x.religiousTextFeatureType = getReligiousTextFeatureTypeValue();
		x.religiousTextFeatureCode = getReligiousTextFeatureCodeValue();
		x.religiousTextFeatureDescriptions = java.util.Arrays.asList(getReligiousTextFeatureDescriptionValue());
		return x;
	}
}
