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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 68</b>
 * <p>
 * Description: Market publishing status
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum MarketPublishingStatuss
{
	/**
	 * Status is not specified (as distinct from unknown): the default if the &lt;MarketPublishingStatus&gt; element is
	 * not sent
	 */
	Unspecified("00", "Unspecified"), //

	/**
	 * The product was announced for publication in this market, and subsequently abandoned
	 */
	Cancelled("01", "Cancelled"), //

	/**
	 * Not yet published in this market, should be accompanied by expected local publication date.
	 */
	Forthcoming("02", "Forthcoming"), //

	/**
	 * The product was announced for publication in this market, and subsequently postponed with no expected local
	 * publication date
	 */
	Postponed_indefinitely("03", "Postponed indefinitely"), //

	/**
	 * The product was published in this market, and is still active in the sense that the publisher will accept orders
	 * for it, though it may or may not be immediately available, for which see &lt;SupplyDetail&gt;
	 */
	Active("04", "Active"), //

	/**
	 * Responsibility for the product in this market has been transferred elsewhere
	 */
	No_longer_our_product("05", "No longer our product"), //

	/**
	 * The product was active, but is now inactive in the sense that (a) no further stock is expected to be made
	 * available in this market, though stock may still be available elsewhere in the supply chain, and (b) there are no
	 * current plans to bring it back into stock
	 */
	Out_of_stock_indefinitely("06", "Out of stock indefinitely"), //

	/**
	 * The product was active, but is now permanently inactive in the sense that (a) no further stock is expected to be
	 * made available in this market, though stock may still be available elsewhere in the supply chain, and (b) the
	 * product will not be made available again under the same ISBN
	 */
	Out_of_print("07", "Out of print"), //

	/**
	 * The product was active, but is now permanently or indefinitely inactive in the sense that no further stock is
	 * expected to be made available in this market, though stock may still be available elsewhere in the supply chain.
	 * Code 08 covers both of codes 06 and 07, and may be used where the distinction between those values is either
	 * unnecessary or meaningless
	 */
	Inactive("08", "Inactive"), //

	/**
	 * The sender of the ONIX record does not know the current publishing status in this market
	 */
	Unknown("09", "Unknown"), //

	/**
	 * The product is no longer available in this market from the local publisher, under the current ISBN, at the
	 * current price. It may be available to be traded through another channel, usually at a reduced price
	 */
	Remaindered("10", "Remaindered"), //

	/**
	 * Withdrawn from sale in this market, typically for legal reasons
	 */
	Withdrawn_from_sale("11", "Withdrawn from sale"), //

	/**
	 * Either no rights are held for the product in this market, or for other reasons the publisher has decided not to
	 * make it available in this market
	 */
	Not_available_in_this_market("12", "Not available in this market"), //

	/**
	 * The product is published in this market and active but, as a publishing decision, it is not sold separately
	 * &#8211; only in an assembly or as part of a package
	 */
	Active_but_not_sold_separately("13", "Active, but not sold separately"), //

	/**
	 * The product is published in this market and active, but is not available to all customer types, typically because
	 * the market is split between exclusive sales agents for different market segments. In ONIX 2.1, should be
	 * accompanied by a free-text statement in &lt;MarketRestrictionDetail&gt; describing the nature of the restriction.
	 * In ONIX 3.0, the &lt;SalesRestriction&gt; composite in Group P.24 should be used
	 */
	Active_with_market_restrictions("14", "Active, with market restrictions"), //

	/**
	 * Recalled in this market for reasons of consumer safety
	 */
	Recalled("15", "Recalled"), //

	/**
	 * Temporarily withdrawn from sale in this market, typically for quality or technical reasons. In ONIX 3.0, must be
	 * accompanied by expected availability date coded &#8216;22&#8217; within the &lt;MarketPublishingDate&gt;
	 * composite, except in exceptional circumstances where no date is known
	 */
	Temporarily_withdrawn_from_sale("16", "Temporarily withdrawn from sale");

	public final String value;
	public final String label;

	private MarketPublishingStatuss(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	private static Map<String, MarketPublishingStatuss> map;

	private static Map<String, MarketPublishingStatuss> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (MarketPublishingStatuss e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static MarketPublishingStatuss byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
