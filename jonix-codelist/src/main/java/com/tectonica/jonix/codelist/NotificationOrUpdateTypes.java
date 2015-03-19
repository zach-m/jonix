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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Notification or update type code
 */
public enum NotificationOrUpdateTypes
{
	/**
	 * Use for a complete record issued earlier than approximately six months before publication.
	 */
	Early_notification("01"), //

	/**
	 * Use for a complete record issued to confirm advance information approximately six months before publication; or for a complete record
	 * issued after that date and before information has been confirmed from the book-in-hand.
	 */
	Advance_notification_confirmed("02"), //

	/**
	 * Use for a complete record issued to confirm advance information at or just before actual publication date; or for a complete record
	 * issued at any later date.
	 */
	Notification_confirmed_on_publication("03"), //

	/**
	 * In ONIX 3.0 only, use when sending a ‘block update’ record. In previous ONIX releases, ONIX updating has generally been by complete
	 * record replacement using code 03, and code 04 is not used.
	 */
	Update_partial("04"), //

	/**
	 * Use when sending an instruction to delete a record which was previously issued. Note that a Delete instruction should NOT be used
	 * when a product is cancelled, put out of print, or otherwise withdrawn from sale: this should be handled as a change of Publishing
	 * status, leaving the receiver to decide whether to retain or delete the record. A Delete instruction is only used when there is a
	 * particular reason to withdraw a record completely, eg because it was issued in error.
	 */
	Delete("05"), //

	/**
	 * Notice of sale of a product, from one publisher to another: sent by the publisher disposing of the product.
	 */
	Notice_of_sale("08"), //

	/**
	 * Notice of acquisition of a product, by one publisher from another: sent by the acquiring publisher.
	 */
	Notice_of_acquisition("09"), //

	/**
	 * ONIX Books 2.1 supply update – <SupplyDetail> only (not used in ONIX 3.0).
	 */
	Update_SupplyDetail_only("12"), //

	/**
	 * ONIX Books 2.1 supply update – <MarketRepresentation> only (not used in ONIX 3.0).
	 */
	Update_MarketRepresentation_only("13"), //

	/**
	 * ONIX Books 2.1 supply update – both <SupplyDetail> and <MarketRepresentation> (not used in ONIX 3.0).
	 */
	Update_SupplyDetail_and_MarketRepresentation("14"), //

	/**
	 * ONIX 3.0 only. Record may be processed for test purposes, but data should be discarded. Sender must ensure the <RecordReference>
	 * matches a previously-sent Test record.
	 */
	Test_update_Partial("88"), //

	/**
	 * Record may be processed for test purposes, but data should be discarded. Sender must ensure the <RecordReference> does not match any
	 * previously-sent live product record.
	 */
	Test_record("89");

	public final String value;

	private NotificationOrUpdateTypes(String value)
	{
		this.value = value;
	}

	private static Map<String, NotificationOrUpdateTypes> map;

	private static Map<String, NotificationOrUpdateTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (NotificationOrUpdateTypes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static NotificationOrUpdateTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
