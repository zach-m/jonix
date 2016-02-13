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
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist65">ONIX
 *      Codelist 65 in Reference Guide</a>
 */
public enum ProductAvailabilitys
{
	/**
	 * Cancelled: product was announced, and subsequently abandoned
	 */
	Cancelled("01", "Cancelled"), //

	/**
	 * Not yet available (requires expected date, either as &lt;ExpectedShipDate&gt; (ONIX 2.1) or as &lt;SupplyDate&gt;
	 * with &lt;SupplyDateRole&gt; coded &#8216;08&#8217; (ONIX 3.0), except in exceptional circumstances where no date
	 * is known)
	 */
	Not_yet_available("10", "Not yet available"), //

	/**
	 * Not yet available, but will be a stock item when available (requires expected date, either as
	 * &lt;ExpectedShipDate&gt; (ONIX 2.1) or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded &#8216;08&#8217;
	 * (ONIX 3.0), except in exceptional circumstances where no date is known). Used particularly for imports which have
	 * been published in the country of origin but have not yet arrived in the importing country
	 */
	Awaiting_stock("11", "Awaiting stock"), //

	/**
	 * Not yet available, to be published as print-on-demand only (requires expected date, either as
	 * &lt;ExpectedShipDate&gt; (ONIX 2.1) or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded &#8216;08&#8217;
	 * (ONIX 3.0), except in exceptional circumstances where no date is known). May apply either to a POD successor to
	 * an existing conventional edition, when the successor will be published under a different ISBN (normally because
	 * different trade terms apply); or to a title that is being published as a POD original
	 */
	Not_yet_available_will_be_POD("12", "Not yet available, will be POD"), //

	/**
	 * Available from us (form of availability unspecified)
	 */
	Available("20", "Available"), //

	/**
	 * Available from us as a stock item
	 */
	In_stock("21", "In stock"), //

	/**
	 * Available from us as a non-stock item, by special order
	 */
	To_order("22", "To order"), //

	/**
	 * Available from us by print-on-demand
	 */
	POD("23", "POD"), //

	/**
	 * Temporarily unavailable: temporarily unavailable from us (reason unspecified) (requires expected date, either as
	 * &lt;ExpectedShipDate&gt; (ONIX 2.1) or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded &#8216;08&#8217;
	 * (ONIX 3.0), except in exceptional circumstances where no date is known)
	 */
	Temporarily_unavailable("30", "Temporarily unavailable"), //

	/**
	 * Stock item, temporarily out of stock (requires expected date, either as &lt;ExpectedShipDate&gt; (ONIX 2.1) or as
	 * &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded &#8216;08&#8217; (ONIX 3.0), except in exceptional
	 * circumstances where no date is known)
	 */
	Out_of_stock("31", "Out of stock"), //

	/**
	 * Temporarily unavailable, reprinting (requires expected date, either as &lt;ExpectedShipDate&gt; (ONIX 2.1) or as
	 * &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded &#8216;08&#8217; (ONIX 3.0), except in exceptional
	 * circumstances where no date is known)
	 */
	Reprinting("32", "Reprinting"), //

	/**
	 * Temporarily unavailable, awaiting reissue (requires expected date, either as &lt;ExpectedShipDate&gt; (ONIX 2.1)
	 * or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded &#8216;08&#8217; (ONIX 3.0), except in exceptional
	 * circumstances where no date is known)
	 */
	Awaiting_reissue("33", "Awaiting reissue"), //

	/**
	 * May be for quality or technical reasons. Requires expected availability date, either as &lt;ExpectedShipDate&gt;
	 * (ONIX 2.1) or as &lt;SupplyDate&gt; with &lt;SupplyDateRole&gt; coded &#8216;08&#8217; (ONIX 3.0), except in
	 * exceptional circumstances where no date is known
	 */
	Temporarily_withdrawn_from_sale("34", "Temporarily withdrawn from sale"), //

	/**
	 * Not available from us (for any reason)
	 */
	Not_available_reason_unspecified("40", "Not available (reason unspecified)"), //

	/**
	 * This product is unavailable, but a successor product or edition is or will be available from us (identify
	 * successor in &lt;RelatedProduct&gt;)
	 */
	Not_available_replaced_by_new_product("41", "Not available, replaced by new product"), //

	/**
	 * This product is unavailable, but the same content is or will be available from us in an alternative format
	 * (identify other format product in &lt;RelatedProduct&gt;)
	 */
	Not_available_other_format_available("42", "Not available, other format available"), //

	/**
	 * Identify new supplier in &lt;NewSupplier&gt; if possible
	 */
	No_longer_supplied_by_us("43", "No longer supplied by us"), //

	/**
	 * Not available to trade, apply direct to publisher
	 */
	Apply_direct("44", "Apply direct"), //

	/**
	 * Must be bought as part of a set (identify set in &lt;RelatedProduct&gt;)
	 */
	Not_sold_separately("45", "Not sold separately"), //

	/**
	 * May be for legal reasons or to avoid giving offence
	 */
	Withdrawn_from_sale("46", "Withdrawn from sale"), //

	/**
	 * Remaindered
	 */
	Remaindered("47", "Remaindered"), //

	/**
	 * Out of print, but a print-on-demand edition is or will be available under a different ISBN. Use only when the POD
	 * successor has a different ISBN, normally because different trade terms apply
	 */
	Not_available_replaced_by_POD("48", "Not available, replaced by POD"), //

	/**
	 * Recalled for reasons of consumer safety
	 */
	Recalled("49", "Recalled"), //

	/**
	 * When a collection that is not sold as a set nevertheless has its own ONIX record
	 */
	Not_sold_as_set("50", "Not sold as set"), //

	/**
	 * This product is unavailable, no successor product or alternative format is available or planned. Use this code
	 * only when the publisher has indicated the product is out of print
	 */
	Not_available_publisher_indicates_OP("51", "Not available, publisher indicates OP"), //

	/**
	 * This product is unavailable in this market, no successor product or alternative format is available or planned.
	 * Use this code when a publisher has indicated the product is permanently unavailable (in this market) while
	 * remaining available elsewhere
	 */
	Not_available_publisher_no_longer_sells_product_in_this_market("52",
			"Not available, publisher no longer sells product in this market"), //

	/**
	 * Sender has not received any recent update for this product from the publisher/supplier (for use when the sender
	 * is a data aggregator): the definition of &#8216;recent&#8217; must be specified by the aggregator, or by
	 * agreement between parties to an exchange
	 */
	No_recent_update_received("97", "No recent update received"), //

	/**
	 * Sender is no longer receiving any updates from the publisher/supplier of this product (for use when the sender is
	 * a data aggregator)
	 */
	No_longer_receiving_updates("98", "No longer receiving updates"), //

	/**
	 * Availability not known to sender
	 */
	Contact_supplier("99", "Contact supplier");

	public final String value;
	public final String label;

	private ProductAvailabilitys(String value, String label)
	{
		this.value = value;
		this.label = label;
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
