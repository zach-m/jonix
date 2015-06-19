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

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList92
 * <p>
 * Supplier identifier type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists/">http://www.editeur.org/14/code-lists/</a>
 */
public enum SupplierIdentifierTypes
{
	Proprietary("01"), //

	/**
	 * DEPRECATED – use 01.
	 */
	Proprietary_("02"), //

	B_rsenverein_Verkehrsnummer("04"), //

	German_ISBN_Agency_publisher_identifier("05"), //

	/**
	 * GS1 global location number (formerly EAN location number).
	 */
	GLN("06"), //

	/**
	 * Book trade Standard Address Number – US, UK etc.
	 */
	SAN("07"), //

	/**
	 * Flemish supplier code.
	 */
	Distributeurscode_Boekenbank("12"), //

	/**
	 * Flemish publisher code.
	 */
	Fondscode_Boekenbank("13"), //

	/**
	 * Identifier for a business organization for VAT purposes, eg within the EU’s VIES system. See
	 * http://ec.europa.eu/taxation_customs/vies/faqvies.do for EU VAT ID formats, which vary from country to country. Generally these
	 * consist of a two-letter country code followed by the 8–12 digits of the national VAT ID. Some countries include one or two letters
	 * within their VAT ID. See http://en.wikipedia.org/wiki/VAT_identification_number for non-EU countries that maintain similar
	 * identifiers. Spaces, dashes etc should be omitted.
	 */
	VAT_Identity_Number("23");

	public final String value;

	private SupplierIdentifierTypes(String value)
	{
		this.value = value;
	}

	private static Map<String, SupplierIdentifierTypes> map;

	private static Map<String, SupplierIdentifierTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (SupplierIdentifierTypes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static SupplierIdentifierTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
