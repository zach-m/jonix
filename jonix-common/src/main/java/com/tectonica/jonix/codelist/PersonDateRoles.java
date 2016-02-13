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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 75</b>
 * <p>
 * Description: Person date role
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist75">ONIX
 *      Codelist 75 in Reference Guide</a>
 */
public enum PersonDateRoles
{
	Date_of_birth("007", "Date of birth"), //

	Date_of_death("008", "Date of death");

	public final String value;
	public final String label;

	private PersonDateRoles(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static PersonDateRoles byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (PersonDateRoles e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
