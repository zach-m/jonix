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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 102</b>
 * <p>
 * Description: Sales outlet identifier type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum SalesOutletIdentifierTypes
{
	/**
	 * Proprietary list of retail and other end-user sales outlet IDs
	 */
	Proprietary("01", "Proprietary"), //

	/**
	 * DEPRECATED &#8211; use code 03
	 */
	BIC_sales_outlet_ID_code("02", "BIC sales outlet ID code"), //

	/**
	 * Use with ONIX retail and other end-user sales outlet IDs from List 139
	 */
	ONIX_retail_sales_outlet_ID_code("03", "ONIX retail sales outlet ID code");

	public final String value;
	public final String label;

	private SalesOutletIdentifierTypes(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static SalesOutletIdentifierTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (SalesOutletIdentifierTypes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
