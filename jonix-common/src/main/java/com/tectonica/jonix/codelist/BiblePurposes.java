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

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 85 (Bible purpose)
 */
interface CodeList85
{}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 85</b>
 * <p>
 * Description: Bible purpose
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist85">ONIX
 *      Codelist 85 in Reference Guide</a>
 */
public enum BiblePurposes implements OnixCodelist, CodeList85
{
	/**
	 * A Bible (or selected Biblical text) designed for presentation from a religious organization
	 */
	Award("AW", "Award"), //

	/**
	 * A Bible (or selected Biblical text) designed to be a gift to commemorate a child's birth
	 */
	Baby("BB", "Baby"), //

	/**
	 * A special gift Bible (or selected Biblical text) designed for the bride on her wedding day. Usually white
	 */
	Bride("BR", "Bride"), //

	/**
	 * A Bible (or selected Biblical text) designed to be used in the confirmation reading or as a gift to a confirmand
	 */
	Confirmation("CF", "Confirmation"), //

	/**
	 * A text Bible (or selected Biblical text) designed in presentation and readability for a child
	 */
	Children_s("CH", "Children’s"), //

	/**
	 * A small Bible (or selected Biblical text) with a trim height of five inches or less
	 */
	Compact("CM", "Compact"), //

	/**
	 * A Bible (or selected Biblical text) which includes text conveying cross-references to related scripture passages
	 */
	Cross_reference("CR", "Cross-reference"), //

	/**
	 * A Bible (or selected Biblical text) laid out to provide readings for each day of the year
	 */
	Daily_readings("DR", "Daily readings"), //

	/**
	 * A Bible (or selected Biblical text) containing devotional content together with the scripture
	 */
	Devotional("DV", "Devotional"), //

	/**
	 * A Bible (or selected Biblical text) containing family record pages and/or additional study material for family
	 * devotion
	 */
	Family("FM", "Family"), //

	/**
	 * A standard Bible (or selected Biblical text) of any version with no distinguishing characteristics beyond the
	 * canonical text
	 */
	General_Text("GT", "General/Text"), //

	/**
	 * A Bible (or selected Biblical text) designed for gift or presentation, often including a presentation page
	 */
	Gift("GF", "Gift"), //

	/**
	 * A large Bible (or selected Biblical text) with large print designed for use in reading scriptures in public
	 * worship from either the pulpit or lectern
	 */
	Lectern_Pulpit("LP", "Lectern/Pulpit"), //

	/**
	 * A Bible (or selected Biblical text) especially designed with helps and study guides oriented to the adult male
	 */
	Men_s("MN", "Men’s"), //

	/**
	 * A Bible (or selected Biblical text) designed for use in primary school
	 */
	Primary_school("PS", "Primary school"), //

	/**
	 * Usually inexpensive but sturdy, a Bible (or selected Biblical text) designed for use in church pews
	 */
	Pew("PW", "Pew"), //

	/**
	 * A Bible (or selected Biblical text) including texts in Greek and/or Hebrew and designed for scholarly study
	 */
	Scholarly("SC", "Scholarly"), //

	Slimline("SL", "Slimline"), //

	/**
	 * A Bible (or selected Biblical text) with study articles and helps especially for use in the classroom
	 */
	Student("ST", "Student"), //

	/**
	 * A Bible (or selected Biblical text) with many extra features, e.g. book introductions, dictionary, concordance,
	 * references, maps, etc., to help readers better understand the scripture
	 */
	Study("SU", "Study"), //

	/**
	 * A special gift Bible (or selected Biblical text) designed as a gift to the couple on their wedding day
	 */
	Wedding_gift("WG", "Wedding gift"), //

	/**
	 * A devotional or study Bible (or selected Biblical text) with helps targeted at the adult woman
	 */
	Women_s("WM", "Women’s"), //

	/**
	 * A Bible (or selected Biblical text) containing special study and devotional helps designed specifically for the
	 * needs of teenagers
	 */
	Youth("YT", "Youth");

	public final String code;
	public final String description;

	private BiblePurposes(String code, String description)
	{
		this.code = code;
		this.description = description;
	}

	@Override
	public String getCode()
	{
		return code;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	private static volatile Map<String, BiblePurposes> map;

	private static Map<String, BiblePurposes> map()
	{
		Map<String, BiblePurposes> result = map;
		if (result == null)
		{
			synchronized (BiblePurposes.class)
			{
				result = map;
				if (result == null)
				{
					result = new HashMap<>();
					for (BiblePurposes e : values())
						result.put(e.code, e);
					map = result;
				}
			}
		}
		return result;
	}

	public static BiblePurposes byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
