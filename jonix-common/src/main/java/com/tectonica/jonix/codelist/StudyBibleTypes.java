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
 * marker interface to assist in IDE navigation to code-list 84 (Study Bible type)
 */
interface CodeList84
{}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 84</b>
 * <p>
 * Description: Study Bible type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist84">ONIX
 *      Codelist 84 in Reference Guide</a>
 */
public enum StudyBibleTypes implements OnixCodelist, CodeList84
{
	/**
	 * Contains the work of Howard Clark Kee including a summary of the development of the canon, introductions to the
	 * books, notes and cross references. Originally published in 1993, NRSV
	 */
	Cambridge_Annotated("CAM", "Cambridge Annotated"), //

	/**
	 * A project of Tyndale House Publishers and Zondervan intended to help readers apply the Bible to daily living.
	 * Living Bible, King James, New International, NASB
	 */
	Life_Application("LIF", "Life Application"), //

	/**
	 * A King James version study Bible with notes by James Macarthur first published in 1997
	 */
	Macarthur("MAC", "Macarthur"), //

	/**
	 * A study Bible originally published in the 1960s and based on the RSV / NRSV
	 */
	Oxford_Annotated("OXF", "Oxford Annotated"), //

	/**
	 * Norwegian study Bible, New Testament
	 */
	Studiebibel_Det_Nye_testamentet("NNT", "Studiebibel, Det Nye testamentet"), //

	/**
	 * Published in 1991 and based on the New Revised Standard version
	 */
	New_Oxford_Annotated("NOX", "New Oxford Annotated"), //

	/**
	 * Norwegian study Bible
	 */
	Norsk_studiebibel("NSB", "Norsk studiebibel"), //

	/**
	 * Based on the work of Charles C. Ryrie. King James, NI, NASB
	 */
	Ryrie("RYR", "Ryrie"), //

	/**
	 * A study Bible based on the early 20th century work of C.I. Scofield. Based on the King James version
	 */
	Scofield("SCO", "Scofield"), //

	/**
	 * A transdenominational study Bible for persons from the Pentecostal/Charismatic traditions
	 */
	Spirit_Filled("SPR", "Spirit Filled");

	public final String code;
	public final String description;

	private StudyBibleTypes(String code, String description)
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

	private static volatile Map<String, StudyBibleTypes> map;

	private static Map<String, StudyBibleTypes> map()
	{
		Map<String, StudyBibleTypes> result = map;
		if (result == null)
		{
			synchronized (StudyBibleTypes.class)
			{
				result = map;
				if (result == null)
				{
					result = new HashMap<>();
					for (StudyBibleTypes e : values())
						result.put(e.code, e);
					map = result;
				}
			}
		}
		return result;
	}

	public static StudyBibleTypes byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
