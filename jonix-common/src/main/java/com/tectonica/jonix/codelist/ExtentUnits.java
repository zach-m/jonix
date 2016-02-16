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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 24</b>
 * <p>
 * Description: Extent unit code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist24">ONIX
 *      Codelist 24 in Reference Guide</a>
 */
public enum ExtentUnits
{
	/**
	 * Words of natural language text
	 */
	Words("02", "Words"), //

	Pages("03", "Pages"), //

	Hours_integer_and_decimals("04", "Hours (integer and decimals)"), //

	Minutes_integer_and_decimals("05", "Minutes (integer and decimals)"), //

	Seconds_integer_only("06", "Seconds (integer only)"), //

	/**
	 * Of an audiobook on CD (or a similarly divided selection of audio files). Conventionally, each track is 3-6
	 * minutes of running time, and track counts are misleading and inappropriate if the average track duration is
	 * significantly more or less than this. Note that track breaks are not necessarily aligned with structural breaks
	 * in the text (eg chapter breaks)
	 */
	Tracks("11", "Tracks"), //

	/**
	 * Fill with leading zeroes if any elements are missing
	 */
	Hours_HHH("14", "Hours HHH"), //

	/**
	 * Fill with leading zeroes if any elements are missing
	 */
	Hours_and_minutes_HHHMM("15", "Hours and minutes HHHMM"), //

	/**
	 * Fill with leading zeroes if any elements are missing
	 */
	Hours_minutes_seconds_HHHMMSS("16", "Hours minutes seconds HHHMMSS"), //

	Bytes("17", "Bytes"), //

	Kbytes("18", "Kbytes"), //

	Mbytes("19", "Mbytes");

	public final String value;
	public final String label;

	private ExtentUnits(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	private static Map<String, ExtentUnits> map;

	private static Map<String, ExtentUnits> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ExtentUnits e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ExtentUnits byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
