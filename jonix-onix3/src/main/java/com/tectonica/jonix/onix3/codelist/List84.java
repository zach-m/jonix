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

package com.tectonica.jonix.onix3.codelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Study Bible type
 */
public enum List84
{
	/**
	 * Contains the work of Howard Clark Kee including a summary of the development of the canon, introductions to the books, notes and
	 * cross references. Originally published in 1993, NRSV.
	 */
	Cambridge_Annotated("CAM"), //

	/**
	 * A project of Tyndale House Publishers and Zondervan intended to help readers apply the Bible to daily living. Living Bible, King
	 * James, New International, NASB.
	 */
	Life_Application("LIF"), //

	/**
	 * A King James version study Bible with notes by James Macarthur first published in 1997.
	 */
	Macarthur("MAC"), //

	/**
	 * A study Bible originally published in the 1960s and based on the RSV / NRSV.
	 */
	Oxford_Annotated("OXF"), //

	/**
	 * Norwegian study Bible, New Testament.
	 */
	Studiebibel_Det_Nye_testamentet("NNT"), //

	/**
	 * Published in 1991 and based on the New Revised Standard version.
	 */
	New_Oxford_Annotated("NOX"), //

	/**
	 * Norwegian study Bible.
	 */
	Norsk_studiebibel("NSB"), //

	/**
	 * Based on the work of Charles C. Ryrie. King James, NI, NASB.
	 */
	Ryrie("RYR"), //

	/**
	 * A study Bible based on the early 20th century work of C.I. Scofield. Based on the King James version.
	 */
	Scofield("SCO"), //

	/**
	 * A transdenominational study Bible for persons from the Pentecostal/Charismatic traditions.
	 */
	Spirit_Filled("SPR");

	public final String value;

	private List84(String value)
	{
		this.value = value;
	}

	private static Map<String, List84> map;

	private static Map<String, List84> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List84 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List84 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
