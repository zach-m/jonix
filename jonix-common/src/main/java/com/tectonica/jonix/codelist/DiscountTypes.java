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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList170
 * <p>
 * Discount type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists/">http://www.editeur.org/14/code-lists/</a>
 */
public enum DiscountTypes
{
	/**
	 * Discount applied to all units in a qualifying order.
	 */
	Rising_discount("01"), //

	/**
	 * Additional discount may be applied retrospectively, based on number of units ordered over a specific period.
	 */
	Rising_discount_cumulative("02"), //

	/**
	 * Discount applied to marginal units in a qualifying order.
	 */
	Progressive_discount("03"), //

	/**
	 * Previous orders within a specific time period are counted when calculating a progressive discount.
	 */
	Progressive_discount_cumulative("04");

	public final String value;

	private DiscountTypes(String value)
	{
		this.value = value;
	}

	public static DiscountTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (DiscountTypes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
