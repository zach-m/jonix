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

package com.tectonica.jonix.onix3.codelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Availability status code
 */
public enum List54
{
	/**
	 * Publication abandoned after having been announced.
	 */
	Cancelled("AB"), //

	/**
	 * Apply direct to publisher, item not available to trade.
	 */
	Available_direct_from_publisher_only("AD"), //

	/**
	 * Check with customer service.
	 */
	Availability_uncertain("CS"), //

	/**
	 * Wholesaler or vendor only.
	 */
	No_longer_stocked_by_us("EX"), //

	/**
	 * In-print and in stock.
	 */
	Available("IP"), //

	/**
	 * May be accompanied by an estimated average time to supply.
	 */
	Manufactured_on_demand("MD"), //

	/**
	 * MUST be accompanied by an expected availability date.
	 */
	Not_yet_published("NP"), //

	/**
	 * Wholesaler or vendor only: MUST be accompanied by expected availability date.
	 */
	Newly_catalogued_not_yet_in_stock("NY"), //

	/**
	 * This format is out of print, but another format is available: should be accompanied by an identifier for the alternative product.
	 */
	Other_format_available("OF"), //

	/**
	 * No current plan to reprint.
	 */
	Out_of_stock_indefinitely("OI"), //

	/**
	 * Discontinued, deleted from catalogue.
	 */
	Out_of_print("OP"), //

	/**
	 * This edition is out of print, but a new edition has been or will soon be published: should be accompanied by an identifier for the
	 * new edition.
	 */
	Replaced_by_new_edition("OR"), //

	/**
	 * Publication has been announced, and subsequently postponed with no new date.
	 */
	Publication_postponed_indefinitely("PP"), //

	/**
	 * Supply of this item has been transferred to another publisher or distributor: should be accompanied by an identifier for the new
	 * supplier.
	 */
	Refer_to_another_supplier("RF"), //

	Remaindered("RM"), //

	/**
	 * MUST be accompanied by an expected availability date.
	 */
	Reprinting("RP"), //

	/**
	 * Use instead of RP as a last resort, only if it is really impossible to give an expected availability date.
	 */
	Reprinting_undated("RU"), //

	/**
	 * This item is not stocked but has to be specially ordered from a supplier (eg import item not stocked locally): may be accompanied by
	 * an estimated average time to supply.
	 */
	Special_order("TO"), //

	/**
	 * Wholesaler or vendor only.
	 */
	Temporarily_out_of_stock_because_publisher_cannot_supply("TP"), //

	/**
	 * MUST be accompanied by an expected availability date.
	 */
	Temporarily_unavailable("TU"), //

	/**
	 * The item is out of stock but will be reissued under the same ISBN: MUST be accompanied by an expected availability date and by the
	 * reissue date in the <Reissue> composite. See notes on the <Reissue> composite for details on treatment of availability status during
	 * reissue.
	 */
	Unavailable_awaiting_reissue("UR"), //

	/**
	 * MUST be accompanied by the remainder date.
	 */
	Will_be_remaindered_as_of_date("WR"), //

	/**
	 * Typically, withdrawn indefinitely for legal reasons.
	 */
	Withdrawn_from_sale("WS");

	public final String value;

	private List54(String value)
	{
		this.value = value;
	}

	private static Map<String, List54> map;

	private static Map<String, List54> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List54 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List54 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
