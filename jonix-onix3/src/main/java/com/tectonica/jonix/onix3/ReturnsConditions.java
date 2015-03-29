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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ReturnsConditionsCodeTypes;
import com.tectonica.jonix.struct.JonixReturnsConditions;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class ReturnsConditions implements Serializable
{
	public static final String refname = "ReturnsConditions";
	public static final String shortname = "returnsconditions";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public ReturnsCodeType returnsCodeType; // Required
	public ReturnsCodeTypeName returnsCodeTypeName; // Optional
	public ReturnsCode returnsCode; // Required

	public ReturnsConditions()
	{}

	public ReturnsConditions(org.w3c.dom.Element element)
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
				if (name.equals(ReturnsCodeType.refname) || name.equals(ReturnsCodeType.shortname))
					returnsCodeType = new ReturnsCodeType(element);
				else if (name.equals(ReturnsCodeTypeName.refname) || name.equals(ReturnsCodeTypeName.shortname))
					returnsCodeTypeName = new ReturnsCodeTypeName(element);
				else if (name.equals(ReturnsCode.refname) || name.equals(ReturnsCode.shortname))
					returnsCode = new ReturnsCode(element);
			}
		});
	}

	public ReturnsConditionsCodeTypes getReturnsCodeTypeValue()
	{
		return (returnsCodeType == null) ? null : returnsCodeType.value;
	}

	public String getReturnsCodeTypeNameValue()
	{
		return (returnsCodeTypeName == null) ? null : returnsCodeTypeName.value;
	}

	public String getReturnsCodeValue()
	{
		return (returnsCode == null) ? null : returnsCode.value;
	}

	public JonixReturnsConditions asJonixReturnsConditions()
	{
		JonixReturnsConditions x = new JonixReturnsConditions();
		x.returnsCodeTypeName = getReturnsCodeTypeNameValue();
		x.returnsCode = getReturnsCodeValue();
		return x;
	}
}
