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

package com.tectonica.jonix.onix2.codelist;

/**
 * Supplier own code type
 */
public enum List165
{
	/**
	 * A rating applied by a supplier (typically a wholesaler) to indicate its assessment of the expected or actual sales performance of a
	 * product.
	 */
	Supplier_s_sales_classification("01"), //

	/**
	 * A supplier’s coding of the eligibility of a product for a bonus scheme on overall sales.
	 */
	Supplier_s_bonus_eligibility("02"), //

	/**
	 * A rating applied by the publisher to indicate a sales category (eg backlist/frontlist, core stock etc). Use only when the publisher
	 * is not the ‘supplier’.
	 */
	Publisher_s_sales_classification("03"), //

	/**
	 * A classification applied by a supplier to a product sold on Agency terms, to indicate that retail price restrictions are applicable.
	 */
	Supplier_s_pricing_restriction_classification("04");

	public final String value;

	private List165(String value)
	{
		this.value = value;
	}

	public static List165 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List165 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
