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

/**
 * <h1>Velocity composite</h1>
 * <p>
 * An optional group of data elements which together specify the rate of stock depletion – or equally, a rate of
 * accumulation of backorders. Repeatable if the rate of depletion is specified using more than one metric (<i>eg</i>
 * specifying both a minimum and maximum daily sale).
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Velocity&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;velocity&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class Velocity implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Velocity";
	public static final String shortname = "velocity";

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
	public VelocityMetric velocityMetric;

	/**
	 * (this field is required)
	 */
	public Rate rate;

	/**
	 * (this field is optional)
	 */
	public Proximity proximity;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Velocity()
	{}

	public Velocity(org.w3c.dom.Element element)
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

	/**
	 * Raw Format: Variable length integer, suggested maximum length 7 digits
	 */
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
