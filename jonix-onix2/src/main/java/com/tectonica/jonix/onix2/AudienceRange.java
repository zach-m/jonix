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
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.AudienceRangePrecisions;
import com.tectonica.jonix.codelist.AudienceRangeQualifiers;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixAudienceRange;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Audience range composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together describe an audience or readership range for which a
 * product is intended. The composite can carry a single value from, to, or exact, or a pair of values with an explicit
 * from and to. See examples below.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;AudienceRange&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;audiencerange&gt;</td>
 * </tr>
 * </table>
 */
public class AudienceRange implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "AudienceRange";
	public static final String shortname = "audiencerange";

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
	public AudienceRangeQualifier audienceRangeQualifier;

	/**
	 * (this list may be empty)
	 */
	public List<AudienceRangePrecision> audienceRangePrecisions;

	/**
	 * (this list may be empty)
	 */
	public List<AudienceRangeValue> audienceRangeValues;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public AudienceRange()
	{}

	public AudienceRange(org.w3c.dom.Element element)
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
				if (name.equals(AudienceRangeQualifier.refname) || name.equals(AudienceRangeQualifier.shortname))
					audienceRangeQualifier = new AudienceRangeQualifier(element);
				else if (name.equals(AudienceRangePrecision.refname) || name.equals(AudienceRangePrecision.shortname))
					audienceRangePrecisions = JPU.addToList(audienceRangePrecisions,
							new AudienceRangePrecision(element));
				else if (name.equals(AudienceRangeValue.refname) || name.equals(AudienceRangeValue.shortname))
					audienceRangeValues = JPU.addToList(audienceRangeValues, new AudienceRangeValue(element));
			}
		});
	}

	public AudienceRangeQualifiers getAudienceRangeQualifierValue()
	{
		return (audienceRangeQualifier == null) ? null : audienceRangeQualifier.value;
	}

	public List<AudienceRangePrecisions> getAudienceRangePrecisionValues()
	{
		if (audienceRangePrecisions != null)
		{
			List<AudienceRangePrecisions> list = new ArrayList<>();
			for (AudienceRangePrecision i : audienceRangePrecisions)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<String> getAudienceRangeValueValues()
	{
		if (audienceRangeValues != null)
		{
			List<String> list = new ArrayList<>();
			for (AudienceRangeValue i : audienceRangeValues)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public JonixAudienceRange asJonixAudienceRange()
	{
		JonixAudienceRange x = new JonixAudienceRange();
		x.audienceRangePrecisions = getAudienceRangePrecisionValues();
		x.audienceRangeQualifier = getAudienceRangeQualifierValue();
		x.audienceRangeValues = getAudienceRangeValueValues();
		return x;
	}
}
