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

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 59</b>
 * <p>
 * Description: Price type qualifier
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist59">ONIX
 *      Codelist 59 in Reference Guide</a>
 */
public enum PriceTypeQualifiers implements OnixCodelist
{
	/**
	 * Price applies to all customers that do not fall within any other group with a specified group-specific qualified
	 * price
	 */
	Unqualified_price("00", "Unqualified price"), //

	/**
	 * Price applies to a designated group membership
	 */
	Member_subscriber_price("01", "Member/subscriber price"), //

	/**
	 * Price applies to sales outside the territory in which the supplier is located
	 */
	Export_price("02", "Export price"), //

	/**
	 * Use in cases where there is no combined price, but a lower price is offered for each part if the whole set /
	 * series / collection is purchased (either at one time, as part of a continuing commitment, or in a single
	 * purchase)
	 */
	Reduced_price_applicable_when_the_item_is_purchased_as_part_of_a_set_or_series_or_collection("03",
			"Reduced price applicable when the item is purchased as part of a set (or series, or collection)"), //

	/**
	 * In the Netherlands (or any other market where similar arrangements exist): a reduced fixed price available for a
	 * limited time on presentation of a voucher or coupon published in a specified medium, eg a newspaper. Should be
	 * accompanied by Price Type code 13 and additional detail in &lt;PriceTypeDescription&gt;, and by validity dates in
	 * &lt;PriceEffectiveFrom&gt; and &lt;PriceEffectiveUntil&gt; (ONIX 2.1) or in the &lt;PriceDate&gt; composite (ONIX
	 * 3.0)
	 */
	Voucher_price("04", "Voucher price"), //

	/**
	 * Price for individual consumer sale only
	 */
	Consumer_price("05", "Consumer price"), //

	/**
	 * Price for sale to libraries or other corporate or institutional customers
	 */
	Corporate_Library_Education_price("06", "Corporate / Library / Education price"), //

	/**
	 * Price valid for a specified period prior to publication. Orders placed prior to the end of the period are
	 * guaranteed to be delivered to the retailer before the nominal publication date. The price may or may not be
	 * different from the 'normal' price, which carries no such delivery guarantee. Must be accompanied by a
	 * &lt;PriceEffectiveUntil&gt; date (or equivalent &lt;PriceDate&gt; composite in ONIX 3), and should also be
	 * accompanied by a 'normal' price
	 */
	Reservation_order_price("07", "Reservation order price"), //

	/**
	 * Temporary 'Special offer' price. Must be accompanied by &lt;PriceEffectiveFrom&gt; and
	 * &lt;PriceEffectiveUntil&gt; dates (or equivalent &lt;PriceDate&gt; composites in ONIX 3), and may also be
	 * accompanied by a 'normal' price
	 */
	Promotional_offer_price("08", "Promotional offer price"), //

	/**
	 * Price requires purchase with, or proof of ownership of another product. Further details of purchase or ownership
	 * requirements must be given in &lt;PriceTypeDescription&gt;
	 */
	Linked_price("09", "Linked price"), //

	/**
	 * Price for sale only to libraries (including public, school and academic libraries) &lt;p&gt;NOTE: Introduced in
	 * Onix3
	 */
	Library_price("10", "Library price"), //

	/**
	 * Price for sale only to educational institutions (including school and academic libraries), educational buying
	 * consortia, government and local government bodies purchasing for use in education &lt;p&gt;NOTE: Introduced in
	 * Onix3
	 */
	Education_price("11", "Education price"), //

	/**
	 * Price for sale to corporate customers only &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Corporate_price("12", "Corporate price"), //

	/**
	 * Price for sale to organisations or services offering consumers subscription access to a library of books
	 * &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Subscription_service_price("13", "Subscription service price"), //

	/**
	 * Price for primary and secondary education &lt;p&gt;NOTE: Introduced in Onix3
	 */
	School_library_price("14", "School library price"), //

	/**
	 * Price for higher education and scholarly institutions &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Academic_library_price("15", "Academic library price"), //

	/**
	 * null &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Public_library_price("16", "Public library price");

	public final String code;
	public final String description;

	private PriceTypeQualifiers(String code, String description)
	{
		this.code = code;
		this.description = description;
	}

	@Override
	public String getCode()
	{
		return code;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	private static Map<String, PriceTypeQualifiers> map;

	private static Map<String, PriceTypeQualifiers> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (PriceTypeQualifiers e : values())
				map.put(e.code, e);
		}
		return map;
	}

	public static PriceTypeQualifiers byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
