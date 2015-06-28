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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 65</b>
 * <p>
 * Description: Product availability
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum ProductAvailabilitys
{
	/**
	 * Cancelled: product was announced, and subsequently abandoned.
	 */
	Cancelled("01"), //

	/**
	 * Not yet available (requires &lt;ExpectedShipDate&gt;, except in exceptional circumstances where no date is
	 * known).
	 */
	Not_yet_available("10"), //

	/**
	 * Not yet available, but will be a stock item when available (requires &lt;ExpectedShipDate&gt;, except in
	 * exceptional circumstances where no date is known). Used particularly for imports which have been published in the
	 * country of origin but have not yet arrived in the importing country.
	 */
	Awaiting_stock("11"), //

	/**
	 * Not yet available, to be published as print-on-demand only. May apply either to a POD successor to an existing
	 * conventional edition, when the successor will be published under a different ISBN (normally because different
	 * trade terms apply); or to a title that is being published as a POD original.
	 */
	Not_yet_available_will_be_POD("12"), //

	/**
	 * Available from us (form of availability unspecified).
	 */
	Available("20"), //

	/**
	 * Available from us as a stock item.
	 */
	In_stock("21"), //

	/**
	 * Available from us as a non-stock item, by special order.
	 */
	To_order("22"), //

	/**
	 * Available from us by print-on-demand.
	 */
	POD("23"), //

	/**
	 * Temporarily unavailable: temporarily unavailable from us (reason unspecified) (requires expected date, either as
	 * &lt;ExpectedShipDate&gt; (ONIX 2.1) or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded &#8216;08&#8217;
	 * (ONIX 3.0), except in exceptional circumstances where no date is known).
	 */
	Temporarily_unavailable("30"), //

	/**
	 * Stock item, temporarily out of stock (requires expected date, either as &lt;ExpectedShipDate&gt; (ONIX 2.1) or as
	 * &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded &#8216;08&#8217; (ONIX 3.0), except in exceptional
	 * circumstances where no date is known).
	 */
	Out_of_stock("31"), //

	/**
	 * Temporarily unavailable, reprinting (requires expected date, either as &lt;ExpectedShipDate&gt; (ONIX 2.1) or as
	 * &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded &#8216;08&#8217; (ONIX 3.0), except in exceptional
	 * circumstances where no date is known).
	 */
	Reprinting("32"), //

	/**
	 * Temporarily unavailable, awaiting reissue (requires the &lt;Reissue&gt; composite, and expected date, either as
	 * &lt;ExpectedShipDate&gt; (ONIX 2.1) or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded &#8216;08&#8217;
	 * (ONIX 3.0), except in exceptional circumstances where no date is known).
	 */
	Awaiting_reissue("33"), //

	/**
	 * May be for quality or technical reasons. Requires expected availability date, either as &lt;ExpectedShipDate&gt;
	 * (ONIX 2.1) or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded &#8216;08&#8217; (ONIX 3.0), except in
	 * exceptional circumstances where no date is known.
	 */
	Temporarily_withdrawn_from_sale("34"), //

	/**
	 * Not available from us (for any reason).
	 */
	Not_available_reason_unspecified("40"), //

	/**
	 * This product is unavailable, but a successor product or edition is or will be available from us (identify
	 * successor in &lt;RelatedProduct&gt;).
	 */
	Not_available_replaced_by_new_product("41"), //

	/**
	 * This product is unavailable, but the same content is or will be available from us in an alternative format
	 * (identify other format product in &lt;RelatedProduct&gt;).
	 */
	Not_available_other_format_available("42"), //

	/**
	 * Identify new supplier in &lt;NewSupplier&gt; if possible.
	 */
	No_longer_supplied_by_us("43"), //

	/**
	 * Not available to trade, apply direct to publisher.
	 */
	Apply_direct("44"), //

	/**
	 * Must be bought as part of a set (identify set in &lt;RelatedProduct&gt;).
	 */
	Not_sold_separately("45"), //

	/**
	 * May be for legal reasons or to avoid giving offence.
	 */
	Withdrawn_from_sale("46"), //

	/**
	 * Remaindered.
	 */
	Remaindered("47"), //

	/**
	 * Out of print, but a print-on-demand edition is or will be available under a different ISBN. Use only when the POD
	 * successor has a different ISBN, normally because different trade terms apply.
	 */
	Not_available_replaced_by_POD("48"), //

	/**
	 * Recalled for reasons of consumer safety.
	 */
	Recalled("49"), //

	/**
	 * When a collection that is not sold as a set nevertheless has its own ONIX record.
	 */
	Not_sold_as_set("50"), //

	/**
	 * This product is unavailable, no successor product or alternative format is available or planned. Use this code
	 * only when the publisher has indicated the product is out of print.
	 */
	Not_available_publisher_indicates_OP("51"), //

	/**
	 * This product is unavailable in this market, no successor product or alternative format is available or planned.
	 * Use this code when a publisher has indicated the product is permanently unavailable (in this market) while
	 * remaining available elsewhere.
	 */
	Not_available_publisher_no_longer_sells_product_in_this_market("52"), //

	/**
	 * Sender has not received any recent update for this product from the publisher/supplier (for use when the sender
	 * is a data aggregator): the definition of &#8220;recent&#8221; must be specified by the aggregator, or by
	 * agreement between parties to an exchange.
	 */
	No_recent_update_received("97"), //

	/**
	 * Sender is no longer receiving any updates from the publisher/supplier of this product (for use when the sender is
	 * a data aggregator).
	 */
	No_longer_receiving_updates("98"), //

	/**
	 * Availability not known to sender.
	 */
	Contact_supplier("99");

	public final String value;

	private ProductAvailabilitys(String value)
	{
		this.value = value;
	}

	private static Map<String, ProductAvailabilitys> map;

	private static Map<String, ProductAvailabilitys> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ProductAvailabilitys e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ProductAvailabilitys byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
