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
 * Extent unit code
 */
public enum ExtentUnitCodes
{
	/**
	 * Words of natural language text.
	 */
	Words("02"), //

	Pages("03"), //

	Hours_integer_and_decimals("04"), //

	Minutes_integer_and_decimals("05"), //

	Seconds_integer_only("06"), //

	/**
	 * Of an audiobook on CD (or a similarly divided selection of audio files). Conventionally, each track is 3–6 minutes of running time,
	 * and track counts are misleading and inappropriate if the average track duration is significantly more or less than this. Note that
	 * track breaks are not necessarily aligned with structural breaks in the text (eg chapter breaks).
	 */
	Tracks("11"), //

	/**
	 * Fill with leading zeroes if any elements are missing.
	 */
	Hours_HHH("14"), //

	/**
	 * Fill with leading zeroes if any elements are missing.
	 */
	Hours_and_minutes_HHHMM("15"), //

	/**
	 * Fill with leading zeroes if any elements are missing.
	 */
	Hours_minutes_seconds_HHHMMSS("16"), //

	Bytes("17"), //

	Kbytes("18"), //

	Mbytes("19");

	public final String value;

	private ExtentUnitCodes(String value)
	{
		this.value = value;
	}

	private static Map<String, ExtentUnitCodes> map;

	private static Map<String, ExtentUnitCodes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ExtentUnitCodes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ExtentUnitCodes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
