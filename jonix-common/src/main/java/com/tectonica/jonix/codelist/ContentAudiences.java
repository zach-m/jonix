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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 154</b>
 * <p>
 * Description: Content audience
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum ContentAudiences
{
	/**
	 * Any audience
	 */
	Unrestricted("00", "Unrestricted"), //

	/**
	 * Distribution by agreement between the parties to the ONIX exchange (this value is provided to cover applications
	 * where ONIX content includes material which is not for general distribution)
	 */
	Restricted("01", "Restricted"), //

	/**
	 * Distributors, bookstores, publisher&#8217;s own staff etc
	 */
	Booktrade("02", "Booktrade"), //

	End_customers("03", "End-customers"), //

	Librarians("04", "Librarians"), //

	Teachers("05", "Teachers"), //

	Students("06", "Students"), //

	/**
	 * Press or other media
	 */
	Press("07", "Press"), //

	/**
	 * Where a specially formatted description is required for this audience
	 */
	Shopping_comparison_service("08", "Shopping comparison service"), //

	/**
	 * Text not intended for display, but may be used (in addition to any less restricted text) for indexing and search
	 * &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Search_engine_index("09", "Search engine index");

	public final String value;
	public final String label;

	private ContentAudiences(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	private static Map<String, ContentAudiences> map;

	private static Map<String, ContentAudiences> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ContentAudiences e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ContentAudiences byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
