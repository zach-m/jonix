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
import com.tectonica.jonix.codelist.PriceCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixPriceCoded;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class PriceCoded implements OnixComposite, Serializable
{
	public static final String refname = "PriceCoded";
	public static final String shortname = "pricecoded";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public PriceCodeType priceCodeType; // Required
	public PriceCodeTypeName priceCodeTypeName; // Optional
	public PriceCode priceCode; // Required

	public PriceCoded()
	{}

	public PriceCoded(org.w3c.dom.Element element)
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
				if (name.equals(PriceCodeType.refname) || name.equals(PriceCodeType.shortname))
					priceCodeType = new PriceCodeType(element);
				else if (name.equals(PriceCodeTypeName.refname) || name.equals(PriceCodeTypeName.shortname))
					priceCodeTypeName = new PriceCodeTypeName(element);
				else if (name.equals(PriceCode.refname) || name.equals(PriceCode.shortname))
					priceCode = new PriceCode(element);
			}
		});
	}

	public PriceCodeTypes getPriceCodeTypeValue()
	{
		return (priceCodeType == null) ? null : priceCodeType.value;
	}

	public String getPriceCodeTypeNameValue()
	{
		return (priceCodeTypeName == null) ? null : priceCodeTypeName.value;
	}

	public String getPriceCodeValue()
	{
		return (priceCode == null) ? null : priceCode.value;
	}

	public JonixPriceCoded asJonixPriceCoded()
	{
		JonixPriceCoded x = new JonixPriceCoded();
		x.priceCodeTypeName = getPriceCodeTypeNameValue();
		x.priceCode = getPriceCodeValue();
		return x;
	}
}
