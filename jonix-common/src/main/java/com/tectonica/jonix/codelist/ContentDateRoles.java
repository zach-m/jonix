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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 155</b>
 * <p>
 * Description: Content date role
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist155">ONIX
 *      Codelist 155 in Reference Guide</a>
 */
public enum ContentDateRoles
{
	/**
	 * Nominal date of publication (of the content item or supporting resource)
	 */
	Publication_date("01", "Publication date"), //

	/**
	 * Date when a TV or radio program was / will be broadcast
	 */
	Broadcast_date("04", "Broadcast date"), //

	/**
	 * Date from which a content item or supporting resource may be referenced or used. The content is embargoed until
	 * this date
	 */
	From_date("14", "From date"), //

	/**
	 * Date until which a content item or supporting resource may be referenced or used
	 */
	Until_date("15", "Until date"), //

	/**
	 * Date when a resource was last changed or updated
	 */
	Last_updated("17", "Last updated"), //

	/**
	 * Combines From date and Until date to define a period (both dates are inclusive). Use with for example dateformat
	 * 06
	 */
	From_until_date("24", "From… until date"), //

	/**
	 * Date from which a supporting resource is available for download. Note that this date also implies that it can be
	 * immediately displayed to the intended audience, unless a From date (code 14) is also supplied and is later than
	 * the Available from date
	 */
	Available_from("27", "Available from"), //

	/**
	 * Date until which a supporting resource is available for download. Note that this date does not imply it must be
	 * removed from display to the intended audience on this date - for this, use Until date (code 15)
	 */
	Available_until("28", "Available until");

	public final String value;
	public final String label;

	private ContentDateRoles(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	private static Map<String, ContentDateRoles> map;

	private static Map<String, ContentDateRoles> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ContentDateRoles e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ContentDateRoles byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
