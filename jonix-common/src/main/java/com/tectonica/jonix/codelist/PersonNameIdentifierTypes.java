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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 101</b>
 * <p>
 * Description: Person name identifier type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum PersonNameIdentifierTypes
{
	Proprietary("01"), //

	/**
	 * Personennamendatei &#8211; person name authority file used by Deutsche Nationalbibliothek and in other
	 * German-speaking countries. See http://www.d-nb.de/standardisierung/normdateien/pnd.htm (German) or
	 * http://www.d-nb.de/eng/standardisierung/normdateien/pnd.htm (English). DEPRECATED in favour of the GND
	 */
	PND("02"), //

	/**
	 * Library of Congress control number assigned to a Library of Congress Name Authority record
	 */
	LCCN("04"), //

	/**
	 * International Standard Name Identifier. See http://www.isni.org/
	 */
	ISNI("16"), //

	/**
	 * Gemeinsame Normdatei &#8211; Joint Authority File in the German-speaking countries. See http://www.dnb.de/EN/gnd
	 * (English). Combines the PND, SWD and GKD into a single authority file, and should be used in preference
	 */
	GND("25");

	public final String value;

	private PersonNameIdentifierTypes(String value)
	{
		this.value = value;
	}

	public static PersonNameIdentifierTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (PersonNameIdentifierTypes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
