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
import com.tectonica.jonix.codelist.MeasureTypes;
import com.tectonica.jonix.codelist.MeasureUnits;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixMeasure;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Measure composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together identify a measurement and the units in which it is
 * expressed; used to specify the overall dimensions of a physical product including its packaging (if any).
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Measure&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;measure&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class Measure implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Measure";
	public static final String shortname = "measure";

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
	public MeasureType measureType;

	/**
	 * (this field is required)
	 */
	public Measurement measurement;

	/**
	 * (this field is required)
	 */
	public MeasureUnitCode measureUnitCode;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Measure()
	{}

	public Measure(org.w3c.dom.Element element)
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
				if (name.equals(MeasureType.refname) || name.equals(MeasureType.shortname))
					measureType = new MeasureType(element);
				else if (name.equals(Measurement.refname) || name.equals(Measurement.shortname))
					measurement = new Measurement(element);
				else if (name.equals(MeasureUnitCode.refname) || name.equals(MeasureUnitCode.shortname))
					measureUnitCode = new MeasureUnitCode(element);
			}
		});
	}

	public MeasureTypes getMeasureTypeValue()
	{
		return (measureType == null) ? null : measureType.value;
	}

	public Double getMeasurementValue()
	{
		return (measurement == null) ? null : measurement.value;
	}

	public MeasureUnits getMeasureUnitCodeValue()
	{
		return (measureUnitCode == null) ? null : measureUnitCode.value;
	}

	public JonixMeasure asJonixMeasure()
	{
		JonixMeasure x = new JonixMeasure();
		x.measureType = getMeasureTypeValue();
		x.measureUnitCode = getMeasureUnitCodeValue();
		x.measurement = getMeasurementValue();
		return x;
	}
}
