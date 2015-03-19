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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TaxRateCodeds;
import com.tectonica.jonix.codelist.TaxTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Tax
{
	public static final String refname = "Tax";
	public static final String shortname = "tax";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
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
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(TaxType.refname) || name.equals(TaxType.shortname))
					x.taxType = TaxType.fromDoc(element);
				else if (name.equals(TaxRateCode.refname) || name.equals(TaxRateCode.shortname))
					x.taxRateCode = TaxRateCode.fromDoc(element);
				else if (name.equals(TaxRatePercent.refname) || name.equals(TaxRatePercent.shortname))
					x.taxRatePercent = TaxRatePercent.fromDoc(element);
				else if (name.equals(TaxableAmount.refname) || name.equals(TaxableAmount.shortname))
					x.taxableAmount = TaxableAmount.fromDoc(element);
				else if (name.equals(TaxAmount.refname) || name.equals(TaxAmount.shortname))
					x.taxAmount = TaxAmount.fromDoc(element);
			}
		});

		return x;
	}

	public TaxTypes getTaxTypeValue()
	{
		return (taxType == null) ? null : taxType.value;
	}

	public TaxRateCodeds getTaxRateCodeValue()
	{
		return (taxRateCode == null) ? null : taxRateCode.value;
	}

	public Double getTaxRatePercentValue()
	{
		return (taxRatePercent == null) ? null : taxRatePercent.value;
	}

	public Double getTaxableAmountValue()
	{
		return (taxableAmount == null) ? null : taxableAmount.value;
	}

	public Double getTaxAmountValue()
	{
		return (taxAmount == null) ? null : taxAmount.value;
	}
}
