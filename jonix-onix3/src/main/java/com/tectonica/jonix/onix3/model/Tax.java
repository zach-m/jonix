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

package com.tectonica.jonix.onix3.model;

import com.tectonica.jonix.onix3.DU;
import com.tectonica.jonix.onix3.codelist.List3;

public class Tax
{
	public static final String refname = "Tax";
	public static final String shortname = "tax";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public TaxType taxType; // Optional
	public TaxRateCode taxRateCode; // Optional
	public TaxRatePercent taxRatePercent; // Required
	public TaxableAmount taxableAmount; // Optional
	public TaxAmount taxAmount; // Optional

	public static Tax fromDoc(org.w3c.dom.Element element)
	{
		final Tax x = new Tax();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(TaxType.refname) || name.equalsIgnoreCase(TaxType.shortname))
					x.taxType = TaxType.fromDoc(element);
				else if (name.equalsIgnoreCase(TaxRateCode.refname) || name.equalsIgnoreCase(TaxRateCode.shortname))
					x.taxRateCode = TaxRateCode.fromDoc(element);
				else if (name.equalsIgnoreCase(TaxRatePercent.refname) || name.equalsIgnoreCase(TaxRatePercent.shortname))
					x.taxRatePercent = TaxRatePercent.fromDoc(element);
				else if (name.equalsIgnoreCase(TaxableAmount.refname) || name.equalsIgnoreCase(TaxableAmount.shortname))
					x.taxableAmount = TaxableAmount.fromDoc(element);
				else if (name.equalsIgnoreCase(TaxAmount.refname) || name.equalsIgnoreCase(TaxAmount.shortname))
					x.taxAmount = TaxAmount.fromDoc(element);
			}
		});

		return x;
	}
}
