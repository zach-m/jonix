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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Tax rate, coded
 */
public enum List62
{
	/**
	 * Specifies that tax is applied at a higher rate than standard.
	 */
	Higher_rate("H"), //

	/**
	 * Under Italian tax rules, VAT on books may be paid at source by the publisher, and subsequent transactions through the supply chain
	 * are tax-exempt.
	 */
	Tax_paid_at_source__Italy_("P"), //

	/**
	 * Specifies that tax is applied at a lower rate than standard.
	 */
	Lower_rate("R"), //

	Standard_rate("S"), //

	Zero_rated("Z");

	public final String value;

	private List62(String value)
	{
		this.value = value;
	}

	public static List62 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List62 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
