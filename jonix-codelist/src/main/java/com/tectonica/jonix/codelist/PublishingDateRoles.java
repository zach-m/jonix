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

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList163
 * <p>
 * Publishing date role
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum PublishingDateRoles
{
	/**
	 * Nominal date of publication.
	 */
	Publication_date("01"), //

	/**
	 * If there is an embargo on retail sales in this market before a certain date, the date from which the embargo is lifted and retail
	 * sales are permitted.
	 */
	Embargo_date("02"), //

	/**
	 * Date when a new product may be announced to the general public.
	 */
	Public_announcement_date("09"), //

	/**
	 * Date when a new product may be announced for trade only.
	 */
	Trade_announcement_date("10"), //

	/**
	 * Date when the work incorporated in a product was first published.
	 */
	Date_of_first_publication("11"), //

	/**
	 * Date when a product was last reprinted.
	 */
	Last_reprint_date("12"), //

	/**
	 * Date when a product was (or will be) declared out-of-print or deleted.
	 */
	Out_of_print_deletion_date("13"), //

	/**
	 * Date when a product was last reissued.
	 */
	Last_reissue_date("16"), //

	/**
	 * Date of publication of a printed book which is the print counterpart to a digital edition.
	 */
	Publication_date_of_print_counterpart("19"), //

	/**
	 * Year when the original language version of work incorporated in a product was first published (note, use only when different from
	 * code 11).
	 */
	Date_of_first_publication_in_original_language("20"), //

	/**
	 * Date when a product will be reissued.
	 */
	Forthcoming_reissue_date("21"), //

	/**
	 * Date when a product that has been temporary withdrawn from sale or recalled for any reason is expected to become available again, eg
	 * after correction of quality or technical issues.
	 */
	Expected_availability_date_after_temporary_withdrawal("22"), //

	/**
	 * Date from which reviews of a product may be published eg in newspapers and magazines or online. Provided to the book trade for
	 * information only: newspapers and magazines are not expected to be recipients of ONIX metadata.
	 */
	Review_embargo_date("23"), //

	/**
	 * Latest date on which an order may be placed with the publisher for guaranteed delivery prior to the publication date. May or may not
	 * be linked to a special reservation or pre-publication price.
	 */
	Publisher_s_reservation_order_deadline("25"), //

	/**
	 * Date when a product will be reprinted.
	 */
	Forthcoming_reprint_date("26"), //

	/**
	 * Earliest date a retail ‘preorder’ can be placed (where this is distinct from the public announcement date). In the absence of a
	 * preorder embargo, advance orders can be placed as soon as metadata is available to the consumer (this would be the public
	 * announcement date, or in the absence of a public announcement date, the earliest date metadata is available to the retailer).
	 */
	Preorder_embargo_date("27"), //

	/**
	 * Date of acquisition of product by new publisher (use with publishing roles 09 and 13).
	 * <p>
	 * NOTE: Introduced in Onix3
	 */
	Transfer_date("28");

	public final String value;

	private PublishingDateRoles(String value)
	{
		this.value = value;
	}

	private static Map<String, PublishingDateRoles> map;

	private static Map<String, PublishingDateRoles> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (PublishingDateRoles e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static PublishingDateRoles byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
