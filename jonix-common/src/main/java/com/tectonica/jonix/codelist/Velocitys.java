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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 216</b>
 * <p>
 * Description: Velocity
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum Velocitys
{
	/**
	 * Typically measured over most recent 1 month period
	 */
	Mean_daily_sale("01"), //

	/**
	 * Typically measured over most recent 1 month period
	 */
	Maximum_daily_sale("02"), //

	/**
	 * Typically measured over most recent 1 month period
	 */
	Minimum_daily_sale("03"), //

	/**
	 * Typically measured over most recent rolling 12 week period
	 */
	Mean_weekly_sale("04"), //

	/**
	 * Typically measured over most recent rolling 12 week period
	 */
	Maximum_weekly_sale("05"), //

	/**
	 * Typically measured over most recent rolling 12 week period
	 */
	Minimum_weekly_sale("06"), //

	/**
	 * Typically measured over most recent rolling 6 month period
	 */
	Mean_monthly_sale("07"), //

	/**
	 * Typically measured over the most recent rolling 6 month period
	 */
	Maximum_monthly_sale("08"), //

	/**
	 * Typically measured over the most recent rolling 6 month period
	 */
	Minimum_monthly_sale("09");

	public final String value;

	private Velocitys(String value)
	{
		this.value = value;
	}

	private static Map<String, Velocitys> map;

	private static Map<String, Velocitys> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (Velocitys e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static Velocitys byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
