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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 47</b>
 * <p>
 * Description: Rights region
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum RightsRegions
{
	World("000", "World"), //

	World_except_territories_specified_elsewhere_in_rights_statements("001",
			"World except territories specified elsewhere in rights statements"), //

	UK_airports("002", "UK airports"), //

	/**
	 * Use when an open market edition is published under its own ISBN
	 */
	UK_open_market_("003", "UK ‘open market’");

	public final String value;
	public final String label;

	private RightsRegions(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static RightsRegions byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (RightsRegions e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
