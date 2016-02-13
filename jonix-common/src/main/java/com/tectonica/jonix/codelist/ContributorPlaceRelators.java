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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 151</b>
 * <p>
 * Description: Contributor place relator
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum ContributorPlaceRelators
{
	Born_in("01"), //

	Died_in("02"), //

	Formerly_resided_in("03"), //

	Currently_resides_in("04"), //

	Educated_in("05"), //

	Worked_in("06"), //

	Flourished_in("07"), //

	/**
	 * Or nationality. For use with country codes only
	 */
	Citizen_of("08");

	public final String value;

	private ContributorPlaceRelators(String value)
	{
		this.value = value;
	}

	private static Map<String, ContributorPlaceRelators> map;

	private static Map<String, ContributorPlaceRelators> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ContributorPlaceRelators e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ContributorPlaceRelators byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
