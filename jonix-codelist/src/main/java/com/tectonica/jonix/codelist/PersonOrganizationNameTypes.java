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
 * Enum that corresponds to ONIX's CodeList18
 * <p>
 * Person / organization name type
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum PersonOrganizationNameTypes
{
	Unspecified("00"), //

	/**
	 * May be used to give a well-known pseudonym, where the primary name is a ‘real’ name.
	 */
	Pseudonym("01"), //

	Authority_controlled_name("02"), //

	Earlier_name("03"), //

	/**
	 * May be used to identify a well-known real name, where the primary name is a pseudonym.
	 */
	_Real_name("04"), //

	/**
	 * Use only within <AlternativeName>, when the primary name type is unspecified.
	 */
	Transliterated_form_of_primary_name("05");

	public final String value;

	private PersonOrganizationNameTypes(String value)
	{
		this.value = value;
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
