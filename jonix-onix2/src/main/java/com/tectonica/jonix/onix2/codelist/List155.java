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

import java.util.Map;
import java.util.HashMap;

/**
 * Content date role
 */
public enum List155
{
	/**
	 * Nominal date of publication.
	 */
	Publication_date("01"), //

	/**
	 * Date when a TV or radio program was / will be broadcast.
	 */
	Broadcast_date("04"), //

	/**
	 * Date from which a content item or supporting resource may be referenced or used.
	 */
	From_date("14"), //

	/**
	 * Date until which a content item or supporting resource may be referenced or used.
	 */
	Until_date("15"), //

	/**
	 * Date when a resource was last changed or updated.
	 */
	Last_updated("17"), //

	/**
	 * Combines From date and Until date to define a period (both dates are inclusive). Use with for example dateformat 06.
	 */
	From__until_date("24"), //

	/**
	 * Date from which a supporting resource is available for download. Note that this date also implies that it can be immediately
	 * displayed to the intended audience, unless a From date (code 14) is also supplied and is later than the Available from date.
	 */
	Available_from("27"), //

	/**
	 * Date until which a supporting resource is available for download. Note that this date does not imply it must be removed from display
	 * to the intended audience on this date – for this, use Until date (code 15).
	 */
	Available_until("28");

	public final String value;

	private List155(String value)
	{
		this.value = value;
	}

	private static Map<String, List155> map;

	private static Map<String, List155> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List155 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List155 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
