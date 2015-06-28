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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 15</b>
 * <p>
 * Description: Title type code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum TitleTypes
{
	Undefined("00"), //

	/**
	 * The full text of the distinctive title of the item, without abbreviation or abridgement. For books, where the
	 * title alone is not distinctive, elements may be taken from a set or series title and part number etc to create a
	 * distinctive title. Where the item is an omnibus edition containing two or more works by the same author, and
	 * there is no separate combined title, a distinctive title may be constructed by concatenating the individual
	 * titles, with suitable punctuation, as in &#8220;Pride and prejudice / Sense and sensibility / Northanger
	 * Abbey&#8221;.
	 */
	Distinctive_title_book("01"), //

	/**
	 * Serials only.
	 */
	ISSN_key_title_of_serial("02"), //

	/**
	 * Where the subject of the ONIX record is a translated item.
	 */
	Title_in_original_language("03"), //

	/**
	 * For serials: an acronym or initialism of Title Type 01, eg &#8220;JAMA&#8221;, &#8220;JACM&#8221;.
	 */
	Title_acronym_or_initialism("04"), //

	/**
	 * An abbreviated form of Title Type 01.
	 */
	Abbreviated_title("05"), //

	/**
	 * A translation of Title Type 01 into another language.
	 */
	Title_in_other_language("06"), //

	/**
	 * Serials only: when a journal issue is explicitly devoted to a specified topic.
	 */
	Thematic_title_of_journal_issue("07"), //

	/**
	 * Books or serials: when an item was previously published under another title.
	 */
	Former_title("08"), //

	/**
	 * For books: the title carried in a book distributor&#8217;s title file: frequently incomplete, and may include
	 * elements not properly part of the title.
	 */
	Distributor_s_title("10"), //

	/**
	 * An alternative title that appears on the cover of a book.
	 */
	Alternative_title_on_cover("11"), //

	/**
	 * An alternative title that appears on the back of a book.
	 */
	Alternative_title_on_back("12"), //

	/**
	 * An expanded form of the title, eg the title of a school text book with grade and type and other details added to
	 * make the title meaningful, where otherwise it would comprise only the curriculum subject. This title type is
	 * required for submissions to the Spanish ISBN Agency.
	 */
	Expanded_title("13"), //

	/**
	 * An alternative title that the book is widely known by, whether it appears on the book or not.
	 */
	Alternative_title("14");

	public final String value;

	private TitleTypes(String value)
	{
		this.value = value;
	}

	private static Map<String, TitleTypes> map;

	private static Map<String, TitleTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (TitleTypes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static TitleTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
