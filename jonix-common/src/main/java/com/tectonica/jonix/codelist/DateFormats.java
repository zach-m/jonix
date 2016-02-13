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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 55</b>
 * <p>
 * Description: Date format
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum DateFormats
{
	/**
	 * Year month day (default)
	 */
	YYYYMMDD("00"), //

	/**
	 * Year and month
	 */
	YYYYMM("01"), //

	/**
	 * Year and week number
	 */
	YYYYWW("02"), //

	/**
	 * Year and quarter (Q = 1, 2, 3, 4, with 1 = Jan to Mar)
	 */
	YYYYQ("03"), //

	/**
	 * Year and season (S = 1, 2, 3, 4, with 1 = &#8216;Spring&#8217;)
	 */
	YYYYS("04"), //

	/**
	 * Year
	 */
	YYYY("05"), //

	/**
	 * Spread of exact dates
	 */
	YYYYMMDDYYYYMMDD("06"), //

	/**
	 * Spread of months
	 */
	YYYYMMYYYYMM("07"), //

	/**
	 * Spread of week numbers
	 */
	YYYYWWYYYYWW("08"), //

	/**
	 * Spread of quarters
	 */
	YYYYQYYYYQ("09"), //

	/**
	 * Spread of seasons
	 */
	YYYYSYYYYS("10"), //

	/**
	 * Spread of years
	 */
	YYYYYYYY("11"), //

	/**
	 * For complex, approximate or uncertain dates
	 */
	Text_string("12"), //

	/**
	 * Exact time. Use ONLY when exact times with hour/minute precision are relevant. By default, time is local.
	 * Alternatively, the time may be suffixed with an optional &#8216;Z&#8217; for UTC times, or with &#8216;+&#8217;
	 * or &#8216;-&#8217; and an hhmm timezone offset from UTC. Times without a timezone are &#8216;rolling&#8217; local
	 * times, times qualified with a timezone (using Z, + or -) specify a particular instant in time
	 */
	YYYYMMDDThhmm("13"), //

	/**
	 * Exact time. Use ONLY when exact times with second precision are relevant. By default, time is local.
	 * Alternatively, the time may be suffixed with an optional &#8216;Z&#8217; for UTC times, or with &#8216;+&#8217;
	 * or &#8216;-&#8217; and an hhmm timezone offset from UTC. Times without a timezone are &#8216;rolling&#8217; local
	 * times, times qualified with a timezone (using Z, + or -) specify a particular instant in time
	 */
	YYYYMMDDThhmmss("14"), //

	/**
	 * Year month day (Hijri calendar)
	 */
	YYYYMMDD_H("20"), //

	/**
	 * Year and month (Hijri calendar)
	 */
	YYYYMM_H("21"), //

	/**
	 * Year (Hijri calendar)
	 */
	YYYY_H("25"), //

	/**
	 * For complex, approximate or uncertain dates (Hijri calendar), text would usually be in Arabic script
	 */
	Text_string_H("32");

	public final String value;

	private DateFormats(String value)
	{
		this.value = value;
	}

	private static Map<String, DateFormats> map;

	private static Map<String, DateFormats> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (DateFormats e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static DateFormats byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
