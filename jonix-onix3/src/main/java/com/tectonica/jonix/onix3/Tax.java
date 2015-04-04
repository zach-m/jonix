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
import com.tectonica.jonix.OnixComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TaxRateCodeds;
import com.tectonica.jonix.codelist.TaxTypes;
import com.tectonica.jonix.struct.JonixTax;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Tax implements OnixComposite, Serializable
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

	public Tax()
	{}

	public Tax(org.w3c.dom.Element element)
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
				if (name.equals(TaxType.refname) || name.equals(TaxType.shortname))
					taxType = new TaxType(element);
				else if (name.equals(TaxRateCode.refname) || name.equals(TaxRateCode.shortname))
					taxRateCode = new TaxRateCode(element);
				else if (name.equals(TaxRatePercent.refname) || name.equals(TaxRatePercent.shortname))
					taxRatePercent = new TaxRatePercent(element);
				else if (name.equals(TaxableAmount.refname) || name.equals(TaxableAmount.shortname))
					taxableAmount = new TaxableAmount(element);
				else if (name.equals(TaxAmount.refname) || name.equals(TaxAmount.shortname))
					taxAmount = new TaxAmount(element);
			}
		});
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

	public JonixTax asJonixTax()
	{
		JonixTax x = new JonixTax();
		x.taxType = getTaxTypeValue();
		x.taxRateCode = getTaxRateCodeValue();
		x.taxRatePercent = getTaxRatePercentValue();
		x.taxableAmount = getTaxableAmountValue();
		x.taxAmount = getTaxAmountValue();
		return x;
	}
}
