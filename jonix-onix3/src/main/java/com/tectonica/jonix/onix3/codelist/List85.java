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

/**
 * Bible purpose
 */
public enum List85
{
	/**
	 * A Bible (or selected Biblical text) designed for presentation from a religious organization.
	 */
	Award("AW"), //

	/**
	 * A Bible (or selected Biblical text) designed to be a gift to commemorate a child’s birth.
	 */
	Baby("BB"), //

	/**
	 * A special gift Bible (or selected Biblical text) designed for the bride on her wedding day. Usually white.
	 */
	Bride("BR"), //

	/**
	 * A Bible (or selected Biblical text) designed to be used in the confirmation reading or as a gift to a confirmand.
	 */
	Confirmation("CF"), //

	/**
	 * A text Bible (or selected Biblical text) designed in presentation and readability for a child.
	 */
	Children_s("CH"), //

	/**
	 * A small Bible (or selected Biblical text) with a trim height of five inches or less.
	 */
	Compact("CM"), //

	/**
	 * A Bible (or selected Biblical text) which includes text conveying cross-references to related scripture passages.
	 */
	Cross_reference("CR"), //

	/**
	 * A Bible (or selected Biblical text) laid out to provide readings for each day of the year.
	 */
	Daily_readings("DR"), //

	/**
	 * A Bible (or selected Biblical text) containing devotional content together with the scripture.
	 */
	Devotional("DV"), //

	/**
	 * A Bible (or selected Biblical text) containing family record pages and/or additional study material for family devotion.
	 */
	Family("FM"), //

	/**
	 * A standard Bible (or selected Biblical text) of any version with no distinguishing characteristics beyond the canonical text.
	 */
	General_Text("GT"), //

	/**
	 * A Bible (or selected Biblical text) designed for gift or presentation, often including a presentation page.
	 */
	Gift("GF"), //

	/**
	 * A large Bible (or selected Biblical text) with large print designed for use in reading scriptures in public worship from either the
	 * pulpit or lectern.
	 */
	Lectern_Pulpit("LP"), //

	/**
	 * A Bible (or selected Biblical text) especially designed with helps and study guides oriented to the adult male.
	 */
	Men_s("MN"), //

	/**
	 * A Bible (or selected Biblical text) designed for use in primary school.
	 */
	Primary_school("PS"), //

	/**
	 * Usually inexpensive but sturdy, a Bible (or selected Biblical text) designed for use in church pews.
	 */
	Pew("PW"), //

	/**
	 * A Bible (or selected Biblical text) including texts in Greek and/or Hebrew and designed for scholarly study.
	 */
	Scholarly("SC"), //

	Slimline("SL"), //

	/**
	 * A Bible (or selected Biblical text) with study articles and helps especially for use in the classroom.
	 */
	Student("ST"), //

	/**
	 * A Bible (or selected Biblical text) with many extra features, e.g. book introductions, dictionary, concordance, references, maps,
	 * etc., to help readers better understand the scripture.
	 */
	Study("SU"), //

	/**
	 * A special gift Bible (or selected Biblical text) designed as a gift to the couple on their wedding day.
	 */
	Wedding_gift("WG"), //

	/**
	 * A devotional or study Bible (or selected Biblical text) with helps targeted at the adult woman.
	 */
	Women_s("WM"), //

	/**
	 * A Bible (or selected Biblical text) containing special study and devotional helps designed specifically for the needs of teenagers.
	 */
	Youth("YT");

	public final String value;

	private List85(String value)
	{
		this.value = value;
	}

	private static Map<String, List85> map;

	private static Map<String, List85> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List85 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List85 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
