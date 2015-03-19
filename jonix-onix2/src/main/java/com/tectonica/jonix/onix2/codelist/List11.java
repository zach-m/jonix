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

package com.tectonica.jonix.onix2.codelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Epublication format code
 */
public enum List11
{
	HTML("01"), //

	PDF("02"), //

	/**
	 * ‘.LIT’ file format used by Microsoft Reader software.
	 */
	Microsoft_Reader("03"), //

	RocketBook("04"), //

	Rich_text_format_RTF("05"), //

	Open_Ebook_Publication_Structure_OEBPS("06"), //

	XML("07"), //

	SGML("08"), //

	/**
	 * ‘.EXE’ file format used when an epublication is delivered as a self-executing package of software and content.
	 */
	EXE("09"), //

	/**
	 * ‘.TXT’ file format.
	 */
	ASCII("10"), //

	/**
	 * Proprietary file format used for the MobiPocket reader software.
	 */
	MobiPocket_format("11");

	public final String value;

	private List11(String value)
	{
		this.value = value;
	}

	private static Map<String, List11> map;

	private static Map<String, List11> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List11 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List11 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
