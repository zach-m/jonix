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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 179</b>
 * <p>
 * Description: Price code type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum PriceCodeTypes
{
	/**
	 * A publisher or retailer&#8217;s proprietary code list which identifies particular codes with particular price
	 * points, price tiers or bands.
	 */
	Proprietary("01"), //

	/**
	 * Price Code scheme for Finnish Pocket Books (Pokkareiden hintaryhm&#228;). Price codes expressed as letters
	 * A&#8211;J in &lt;PriceCode&gt;.
	 */
	Finnish_Pocket_Book_price_code("02"), //

	/**
	 * Price Code scheme for Finnish Miki Books (Miki-kirjojen hintaryhm&#228;). Price codes expressed as an integer
	 * 1&#8211;n in &lt;PriceCode&gt;.
	 */
	Finnish_Miki_Book_price_code("03");

	public final String value;

	private PriceCodeTypes(String value)
	{
		this.value = value;
	}

	public static PriceCodeTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (PriceCodeTypes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
