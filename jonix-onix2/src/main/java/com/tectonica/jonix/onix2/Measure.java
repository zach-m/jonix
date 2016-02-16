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
import com.tectonica.jonix.codelist.MeasureTypes;
import com.tectonica.jonix.codelist.MeasureUnits;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixMeasure;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Measure composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together identify a measurement and the units in which it is
 * expressed.
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
	public MeasureTypeCode measureTypeCode;

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
				if (name.equals(MeasureTypeCode.refname) || name.equals(MeasureTypeCode.shortname))
					measureTypeCode = new MeasureTypeCode(element);
				else if (name.equals(Measurement.refname) || name.equals(Measurement.shortname))
					measurement = new Measurement(element);
				else if (name.equals(MeasureUnitCode.refname) || name.equals(MeasureUnitCode.shortname))
					measureUnitCode = new MeasureUnitCode(element);
			}
		});
	}

	public MeasureTypes getMeasureTypeCodeValue()
	{
		return (measureTypeCode == null) ? null : measureTypeCode.value;
	}

	public String getMeasurementValue()
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
		x.measureType = getMeasureTypeCodeValue();
		x.measureUnitCode = getMeasureUnitCodeValue();
		x.measurement = JPU.convertStringToDouble(getMeasurementValue());
		return x;
	}
}
