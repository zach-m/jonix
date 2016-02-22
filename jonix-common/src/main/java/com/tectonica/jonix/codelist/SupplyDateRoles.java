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

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 166</b>
 * <p>
 * Description: Supply date role
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist166">ONIX
 *      Codelist 166 in Reference Guide</a>
 */
public enum SupplyDateRoles implements OnixCodelist
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

	public final String code;
	public final String description;

	private SupplyDateRoles(String code, String description)
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

	public static SupplyDateRoles byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		for (SupplyDateRoles e : values())
			if (e.code.equals(code))
				return e;
		return null;
	}
}
