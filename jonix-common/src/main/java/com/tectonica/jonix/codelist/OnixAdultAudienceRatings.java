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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 203</b>
 * <p>
 * Description: ONIX Adult Audience rating
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist203">ONIX
 *      Codelist 203 in Reference Guide</a>
 */
public enum OnixAdultAudienceRatings
{
	Unrated("00", "Unrated"), //

	/**
	 * The publisher states that the product is suitable for any adult audience
	 */
	Any_adult_audience("01", "Any adult audience"), //

	/**
	 * The publisher warns the content may offend parts of the adult audience (for any reason)
	 */
	Content_warning("02", "Content warning"), //

	/**
	 * The publisher warns the product includes content of an explicit sexual nature
	 */
	Content_warning_sex("03", "Content warning (sex)"), //

	/**
	 * The publisher warns the product includes content of an extreme violent nature
	 */
	Content_warning_violence("04", "Content warning (violence)"), //

	/**
	 * The publisher warns the product includes content involving severe misuse of drugs
	 */
	Content_warning_drug_taking("05", "Content warning (drug-taking)"), //

	/**
	 * The publisher warns the product includes extreme / offensive / explicit language
	 */
	Content_warning_language("06", "Content warning (language)"), //

	/**
	 * The publisher warns the product includes content involving intolerance of particular groups (eg religious,
	 * ethnic, racial, social)
	 */
	Content_warning_intolerance("07", "Content warning (intolerance)");

	public final String value;
	public final String label;

	private OnixAdultAudienceRatings(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	private static Map<String, OnixAdultAudienceRatings> map;

	private static Map<String, OnixAdultAudienceRatings> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (OnixAdultAudienceRatings e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static OnixAdultAudienceRatings byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
