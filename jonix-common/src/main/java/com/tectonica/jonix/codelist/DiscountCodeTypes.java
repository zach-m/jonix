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
 * Enum that corresponds to ONIX's CodeList100
 * <p>
 * Discount code type
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum DiscountCodeTypes
{
	/**
	 * UK publisher’s or distributor’s discount group code in a format specified by BIC to ensure uniqueness.
	 */
	BIC_discount_group_code("01"), //

	/**
	 * A publisher’s or supplier’s own code which identifies a trade discount category, the actual discount being set by trading partner
	 * agreement (applies to goods supplied on standard trade discounting terms).
	 */
	Proprietary_discount_code("02"), //

	/**
	 * Terms code used in the Netherlands book trade.
	 */
	Boeksoort("03"), //

	/**
	 * Terms code used in German ONIX applications.
	 */
	German_terms_code("04"), //

	/**
	 * A publisher’s or supplier’s own code which identifies a commission rate category, the actual commission rate being set by trading
	 * partner agreement (applies to goods supplied on agency terms).
	 */
	Proprietary_commission_code("05"), //

	/**
	 * UK publisher’s or distributor’s commission group code in format specified by BIC to ensure uniqueness. Format is identical to BIC
	 * discount group code, but indicates a commission rather than a discount (applies to goods supplied on agency terms).
	 */
	BIC_commission_group_code("06");

	public final String value;

	private DiscountCodeTypes(String value)
	{
		this.value = value;
	}

	public static DiscountCodeTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (DiscountCodeTypes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
