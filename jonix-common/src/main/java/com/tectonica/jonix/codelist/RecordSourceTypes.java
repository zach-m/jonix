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

package com.tectonica.jonix.codelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 3</b>
 * <p>
 * Description: Record source type code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum RecordSourceTypes
{
	Unspecified("00", "Unspecified"), //

	Publisher("01", "Publisher"), //

	/**
	 * Use to designate a distributor providing warehousing and fulfillment for a publisher or for a publisher&#8217;s
	 * sales agent, as distinct from a wholesaler
	 */
	Publisher_s_distributor("02", "Publisher’s distributor"), //

	Wholesaler("03", "Wholesaler"), //

	/**
	 * Bibliographic data aggregator
	 */
	Bibliographic_agency("04", "Bibliographic agency"), //

	/**
	 * Bookseller selling to libraries (including academic libraries)
	 */
	Library_bookseller("05", "Library bookseller"), //

	/**
	 * Use for a publisher&#8217;s sales agent responsible for marketing the publisher&#8217;s products within a
	 * territory, as opposed to a publisher&#8217;s distributor who fulfills orders but does not market
	 */
	Publisher_s_sales_agent("06", "Publisher’s sales agent"), //

	/**
	 * Downstream provider of e-publication format conversion service (who might also be a distributor or retailer of
	 * the converted e-publication), supplying metadata on behalf of the publisher. The assigned ISBN is taken from the
	 * publisher&#8217;s ISBN prefix
	 */
	Publisher_s_conversion_service_provider("07", "Publisher’s conversion service provider"), //

	/**
	 * Downstream provider of e-publication format conversion service (who might also be a distributor or retailer of
	 * the converted e-publication), supplying metadata on behalf of the publisher. The assigned ISBN is taken from the
	 * service provider&#8217;s prefix (whether or not the service provider dedicates that prefix to a particular
	 * publisher)
	 */
	Conversion_service_provider("08", "Conversion service provider"), //

	ISBN_Registration_Agency("09", "ISBN Registration Agency"), //

	ISTC_Registration_Agency("10", "ISTC Registration Agency"), //

	/**
	 * Bookseller selling primarily to consumers &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Retail_bookseller("11", "Retail bookseller"), //

	/**
	 * Bookseller selling primarily to educational institutions &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Education_bookseller("12", "Education bookseller");

	public final String value;
	public final String label;

	private RecordSourceTypes(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	private static Map<String, RecordSourceTypes> map;

	private static Map<String, RecordSourceTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (RecordSourceTypes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static RecordSourceTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
