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
import com.tectonica.jonix.codelist.UnitOfUsages;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class EpubUsageLimit implements Serializable
{
	public static final String refname = "EpubUsageLimit";
	public static final String shortname = "epubusagelimit";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public Quantity quantity; // Required
	public EpubUsageUnit epubUsageUnit; // Required

	public EpubUsageLimit()
	{}

	public EpubUsageLimit(org.w3c.dom.Element element)
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
				if (name.equals(Quantity.refname) || name.equals(Quantity.shortname))
					quantity = new Quantity(element);
				else if (name.equals(EpubUsageUnit.refname) || name.equals(EpubUsageUnit.shortname))
					epubUsageUnit = new EpubUsageUnit(element);
			}
		});
	}

	public Double getQuantityValue()
	{
		return (quantity == null) ? null : quantity.value;
	}

	public UnitOfUsages getEpubUsageUnitValue()
	{
		return (epubUsageUnit == null) ? null : epubUsageUnit.value;
	}
}
