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

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.Proximitys;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.Velocitys;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Velocity
{
	public static final String refname = "Velocity";
	public static final String shortname = "velocity";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public VelocityMetric velocityMetric; // Required
	public Rate rate; // Required
	public Proximity proximity; // Optional

	public static Velocity fromDoc(org.w3c.dom.Element element)
	{
		final Velocity x = new Velocity();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(VelocityMetric.refname) || name.equals(VelocityMetric.shortname))
					x.velocityMetric = VelocityMetric.fromDoc(element);
				else if (name.equals(Rate.refname) || name.equals(Rate.shortname))
					x.rate = Rate.fromDoc(element);
				else if (name.equals(Proximity.refname) || name.equals(Proximity.shortname))
					x.proximity = Proximity.fromDoc(element);
			}
		});

		return x;
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
}
