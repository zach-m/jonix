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
 * Enum that corresponds to ONIX's CodeList43
 * <p>
 * Text item identifier type code
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum TextItemIdentifierTypes
{
	/**
	 * For example, a publisher’s own identifier.
	 */
	Proprietary("01"), //

	/**
	 * Formerly known as the EAN-13 (unhyphenated).
	 */
	GTIN_13("03"), //

	DOI("06"), //

	/**
	 * Publisher item identifier.
	 */
	PII("09"), //

	/**
	 * For serial items only.
	 */
	SICI("10"), //

	ISTC("11"), //

	/**
	 * (Unhyphenated).
	 */
	ISBN_13("15");

	public final String value;

	private TextItemIdentifierTypes(String value)
	{
		this.value = value;
	}

	public static TextItemIdentifierTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (TextItemIdentifierTypes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
