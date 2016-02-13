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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 18</b>
 * <p>
 * Description: Person / organization name type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum PersonOrganizationNameTypes
{
	Unspecified("00", "Unspecified"), //

	/**
	 * May be used to give a well-known pseudonym, where the primary name is a &#8216;real&#8217; name
	 */
	Pseudonym("01", "Pseudonym"), //

	Authority_controlled_name("02", "Authority-controlled name"), //

	Earlier_name("03", "Earlier name"), //

	/**
	 * May be used to identify a well-known real name, where the primary name is a pseudonym
	 */
	_Real_name("04", "‘Real’ name"), //

	/**
	 * Use only within &lt;AlternativeName&gt;, when the primary name type is unspecified
	 */
	Transliterated_form_of_primary_name("05", "Transliterated form of primary name");

	public final String value;
	public final String label;

	private PersonOrganizationNameTypes(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static PersonOrganizationNameTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (PersonOrganizationNameTypes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
