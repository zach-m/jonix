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
import com.tectonica.jonix.codelist.ExtentTypeCodes;
import com.tectonica.jonix.codelist.ExtentUnitCodes;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Extent
{
	public static final String refname = "Extent";
	public static final String shortname = "extent";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public ExtentType extentType; // Required
	public ExtentValue extentValue; // Required
	public ExtentValueRoman extentValueRoman; // Optional
	public ExtentUnit extentUnit; // Required

	public static Extent fromDoc(org.w3c.dom.Element element)
	{
		final Extent x = new Extent();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ExtentType.refname) || name.equals(ExtentType.shortname))
					x.extentType = ExtentType.fromDoc(element);
				else if (name.equals(ExtentValue.refname) || name.equals(ExtentValue.shortname))
					x.extentValue = ExtentValue.fromDoc(element);
				else if (name.equals(ExtentValueRoman.refname) || name.equals(ExtentValueRoman.shortname))
					x.extentValueRoman = ExtentValueRoman.fromDoc(element);
				else if (name.equals(ExtentUnit.refname) || name.equals(ExtentUnit.shortname))
					x.extentUnit = ExtentUnit.fromDoc(element);
			}
		});

		return x;
	}

	public ExtentTypeCodes getExtentTypeValue()
	{
		return (extentType == null) ? null : extentType.value;
	}

	public Double getExtentValueValue()
	{
		return (extentValue == null) ? null : extentValue.value;
	}

	public String getExtentValueRomanValue()
	{
		return (extentValueRoman == null) ? null : extentValueRoman.value;
	}

	public ExtentUnitCodes getExtentUnitValue()
	{
		return (extentUnit == null) ? null : extentUnit.value;
	}
}
