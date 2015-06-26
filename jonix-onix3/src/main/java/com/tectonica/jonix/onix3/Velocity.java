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
import com.tectonica.jonix.codelist.Proximitys;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.Velocitys;
import com.tectonica.jonix.struct.JonixVelocity;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class Velocity implements OnixDataComposite, Serializable
{
	public static final String refname = "Velocity";
	public static final String shortname = "velocity";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public VelocityMetric velocityMetric; // Required
	public Rate rate; // Required
	public Proximity proximity; // Optional

	public Velocity()
	{}

	public Velocity(org.w3c.dom.Element element)
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
				if (name.equals(VelocityMetric.refname) || name.equals(VelocityMetric.shortname))
					velocityMetric = new VelocityMetric(element);
				else if (name.equals(Rate.refname) || name.equals(Rate.shortname))
					rate = new Rate(element);
				else if (name.equals(Proximity.refname) || name.equals(Proximity.shortname))
					proximity = new Proximity(element);
			}
		});
	}

	public Velocitys getVelocityMetricValue()
	{
		return (velocityMetric == null) ? null : velocityMetric.value;
	}

	public Integer getRateValue()
	{
		return (rate == null) ? null : rate.value;
	}

	public Proximitys getProximityValue()
	{
		return (proximity == null) ? null : proximity.value;
	}

	public JonixVelocity asJonixVelocity()
	{
		JonixVelocity x = new JonixVelocity();
		x.velocityMetric = getVelocityMetricValue();
		x.rate = getRateValue();
		x.proximity = getProximityValue();
		return x;
	}
}
