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

package com.tectonica.jonix.onix2.codelist;

import java.util.Map;
import java.util.HashMap;

/**
 * Record source type code
 */
public enum List3
{
	Unspecified("00"), //

	Publisher("01"), //

	/**
	 * Use to designate a distributor providing warehousing and fulfillment for a publisher or for a publisher’s sales agent, as distinct
	 * from a wholesaler.
	 */
	Publisher_s_distributor("02"), //

	Wholesaler("03"), //

	/**
	 * Bibliographic data aggregator.
	 */
	Bibliographic_agency("04"), //

	Library_bookseller("05"), //

	/**
	 * Use for a publisher’s sales agent responsible for marketing the publisher’s products within a territory, as opposed to a publisher’s
	 * distributor who fulfills orders but does not market.
	 */
	Publisher_s_sales_agent("06"), //

	/**
	 * Downstream provider of e-publication format conversion service (who might also be a distributor or retailer of the converted
	 * e-publication), supplying metadata on behalf of the publisher. The assigned ISBN is taken from the publisher’s ISBN prefix.
	 */
	Publisher_s_conversion_service_provider("07"), //

	/**
	 * Downstream provider of e-publication format conversion service (who might also be a distributor or retailer of the converted
	 * e-publication), supplying metadata on behalf of the publisher. The assigned ISBN is taken from the service provider’s prefix (whether
	 * or not the service provider dedicates that prefix to a particular publisher).
	 */
	Conversion_service_provider("08"), //

	ISBN_Registration_Agency("09"), //

	ISTC_Registration_Agency("10");

	public final String value;

	private List3(String value)
	{
		this.value = value;
	}

	private static Map<String, List3> map;

	private static Map<String, List3> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List3 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List3 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
