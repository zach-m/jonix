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
import com.tectonica.jonix.codelist.StockQuantityCodeTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class StockQuantityCoded
{
	public static final String refname = "StockQuantityCoded";
	public static final String shortname = "stockquantitycoded";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public StockQuantityCodeType stockQuantityCodeType; // Required
	public StockQuantityCodeTypeName stockQuantityCodeTypeName; // Optional
	public StockQuantityCode stockQuantityCode; // Required

	public static StockQuantityCoded fromDoc(org.w3c.dom.Element element)
	{
		final StockQuantityCoded x = new StockQuantityCoded();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(StockQuantityCodeType.refname) || name.equals(StockQuantityCodeType.shortname))
					x.stockQuantityCodeType = StockQuantityCodeType.fromDoc(element);
				else if (name.equals(StockQuantityCodeTypeName.refname) || name.equals(StockQuantityCodeTypeName.shortname))
					x.stockQuantityCodeTypeName = StockQuantityCodeTypeName.fromDoc(element);
				else if (name.equals(StockQuantityCode.refname) || name.equals(StockQuantityCode.shortname))
					x.stockQuantityCode = StockQuantityCode.fromDoc(element);
			}
		});

		return x;
	}

	public StockQuantityCodeTypes getStockQuantityCodeTypeValue()
	{
		return (stockQuantityCodeType == null) ? null : stockQuantityCodeType.value;
	}

	public String getStockQuantityCodeTypeNameValue()
	{
		return (stockQuantityCodeTypeName == null) ? null : stockQuantityCodeTypeName.value;
	}

	public String getStockQuantityCodeValue()
	{
		return (stockQuantityCode == null) ? null : stockQuantityCode.value;
	}
}
