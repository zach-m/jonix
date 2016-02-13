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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 166</b>
 * <p>
 * Description: Supply date role
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum SupplyDateRoles
{
	/**
	 * If there is an embargo on retail sales before a certain date, the date from which the embargo is lifted and
	 * retail sales are permitted
	 */
	Embargo_date("02", "Embargo date"), //

	/**
	 * The date on which physical stock is expected to be available to be shipped to retailers, or a digital product is
	 * expected to be released by the publisher or digital asset distributor to retailers or their retail platform
	 * providers
	 */
	Expected_availability_date("08", "Expected availability date"), //

	/**
	 * Last date when returns will be accepted, generally for a product which is being remaindered or put out of print
	 */
	Last_date_for_returns("18", "Last date for returns"), //

	/**
	 * Latest date on which an order may be placed for guaranteed delivery prior to the publication date. May or may not
	 * be linked to a special reservation or pre-publication price
	 */
	Reservation_order_deadline("25", "Reservation order deadline");

	public final String value;
	public final String label;

	private SupplyDateRoles(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static SupplyDateRoles byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (SupplyDateRoles e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
