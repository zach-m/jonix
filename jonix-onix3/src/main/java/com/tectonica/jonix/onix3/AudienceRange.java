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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.AudienceRangePrecisions;
import com.tectonica.jonix.codelist.AudienceRangeQualifiers;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixAudienceRange;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class AudienceRange implements OnixDataComposite, Serializable
{
	public static final String refname = "AudienceRange";
	public static final String shortname = "audiencerange";

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	/**
	 * (this field is required)
	 */
	public AudienceRangeQualifier audienceRangeQualifier;

	/**
	 * (this field is optional)
	 */
	public AudienceRangePrecision audienceRangePrecision;

	/**
	 * (this field is optional)
	 */
	public AudienceRangeValue audienceRangeValue;

	public AudienceRange()
	{}

	public AudienceRange(org.w3c.dom.Element element)
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
				if (name.equals(AudienceRangeQualifier.refname) || name.equals(AudienceRangeQualifier.shortname))
					audienceRangeQualifier = new AudienceRangeQualifier(element);
				else if (name.equals(AudienceRangePrecision.refname) || name.equals(AudienceRangePrecision.shortname))
					audienceRangePrecision = new AudienceRangePrecision(element);
				else if (name.equals(AudienceRangeValue.refname) || name.equals(AudienceRangeValue.shortname))
					audienceRangeValue = new AudienceRangeValue(element);
			}
		});
	}

	public AudienceRangeQualifiers getAudienceRangeQualifierValue()
	{
		return (audienceRangeQualifier == null) ? null : audienceRangeQualifier.value;
	}

	public AudienceRangePrecisions getAudienceRangePrecisionValue()
	{
		return (audienceRangePrecision == null) ? null : audienceRangePrecision.value;
	}

	public String getAudienceRangeValueValue()
	{
		return (audienceRangeValue == null) ? null : audienceRangeValue.value;
	}

	public JonixAudienceRange asJonixAudienceRange()
	{
		JonixAudienceRange x = new JonixAudienceRange();
		x.audienceRangePrecision = getAudienceRangePrecisionValue();
		x.audienceRangeQualifier = getAudienceRangeQualifierValue();
		x.audienceRangeValue = getAudienceRangeValueValue();
		return x;
	}
}
