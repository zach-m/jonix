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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 69</b>
 * <p>
 * Description: Agent role
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist69">ONIX
 *      Codelist 69 in Reference Guide</a>
 */
public enum AgentRoles
{
	/**
	 * Publisher's exclusive sales agent in a specified territory
	 */
	Exclusive_sales_agent("05", "Exclusive sales agent"), //

	/**
	 * Publisher's non-exclusive sales agent in a specified territory
	 */
	Non_exclusive_sales_agent("06", "Non-exclusive sales agent"), //

	/**
	 * Publisher for a specified territory
	 */
	Local_publisher("07", "Local publisher"), //

	/**
	 * Publisher's sales agent in a specific territory. Use only where exclusive / non-exclusive status is not known.
	 * Prefer 05 or 06 as appropriate, where possible
	 */
	Sales_agent("08", "Sales agent");

	public final String value;
	public final String label;

	private AgentRoles(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static AgentRoles byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (AgentRoles e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
