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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 171</b>
 * <p>
 * Description: Tax type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum TaxTypes
{
	/**
	 * Value-added tax (TVA, IVA, MwSt etc)
	 */
	VAT("01"), //

	/**
	 * General sales tax
	 */
	GST("02"), //

	/**
	 * &#8216;Green&#8217; or eco-tax, levied to encourage responsible production or disposal, used only where this is
	 * identified separately from value-added or sales taxes (eg French &#233;co-participation tax) &lt;p&gt;NOTE:
	 * Introduced in Onix3
	 */
	ECO("03");

	public final String value;

	private TaxTypes(String value)
	{
		this.value = value;
	}

	public static TaxTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (TaxTypes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
