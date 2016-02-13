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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 71</b>
 * <p>
 * Description: Sales restriction type code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum SalesRestrictionTypes
{
	/**
	 * Restriction must be described in &lt;SalesRestrictionDetail&gt; (ONIX 2.1) or &lt;SalesRestrictionNote&gt; (ONIX
	 * 3.0)
	 */
	Unspecified_see_text("00"), //

	/**
	 * For sale only through designated retailer. Retailer must be identified or named in an instance of the
	 * &lt;SalesOutlet&gt; composite. Use only when it is not possible to assign the more explicit code 04 or 05
	 */
	Retailer_exclusive_own_brand("01"), //

	/**
	 * For editions sold only though office supplies wholesalers. Retailer(s) and/or distributor(s) may be identified or
	 * named in an instance of the &lt;SalesOutlet&gt; composite
	 */
	Office_supplies_edition("02"), //

	/**
	 * For an ISBN that is assigned for a publisher&#8217;s internal purposes
	 */
	Internal_publisher_use_only_do_not_list("03"), //

	/**
	 * For sale only through designated retailer, though not under retailer&#8217;s own brand/imprint. Retailer must be
	 * identified or named in an instance of the &lt;SalesOutlet&gt; composite
	 */
	Retailer_exclusive("04"), //

	/**
	 * For sale only through designated retailer under retailer&#8217;s own brand/imprint. Retailer must be identified
	 * or named in an instance of the &lt;SalesOutlet&gt; composite
	 */
	Retailer_own_brand("05"), //

	/**
	 * For sale to libraries only; not for sale through retail trade
	 */
	Library_edition("06"), //

	/**
	 * For sale directly to schools only; not for sale through retail trade
	 */
	Schools_only_edition("07"), //

	/**
	 * Indexed for the German market &#8211; in Deutschland indiziert
	 */
	Indiziert("08"), //

	/**
	 * Expected to apply in particular to digital products for consumer sale where the publisher does not permit the
	 * product to be supplied to libraries who provide an ebook loan service
	 */
	Not_for_sale_to_libraries("09"), //

	/**
	 * For editions sold only through newsstands/newsagents
	 */
	News_outlet_edition("10"), //

	/**
	 * Not for sale through designated retailer. Retailer must be identified or named in an instance of the
	 * &lt;SalesOutlet&gt; composite
	 */
	Retailer_exception("11"), //

	/**
	 * Not for sale to organisations or services offering consumers subscription access to a library of books
	 * &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Not_for_sale_to_subscription_services("12"), //

	/**
	 * Restricted to organisations or services offering consumers subscription access to a library of books
	 * &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Subscription_services_only("13");

	public final String value;

	private SalesRestrictionTypes(String value)
	{
		this.value = value;
	}

	private static Map<String, SalesRestrictionTypes> map;

	private static Map<String, SalesRestrictionTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (SalesRestrictionTypes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static SalesRestrictionTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
