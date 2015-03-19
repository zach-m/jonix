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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Language role code
 */
public enum LanguageRoles
{
	Language_of_text("01"), //

	/**
	 * Where the text in the original language is NOT part of the current product.
	 */
	Original_language_of_a_translated_text("02"), //

	/**
	 * Where different from language of text: used mainly for serials.
	 */
	Language_of_abstracts("03"), //

	/**
	 * Language to which specified rights apply.
	 */
	Rights_language("04"), //

	/**
	 * Language to which specified rights do not apply.
	 */
	Rights_excluded_language("05"), //

	/**
	 * Where the text in the original language is part of a bilingual or multilingual edition.
	 */
	Original_language_in_a_multilingual_edition("06"), //

	/**
	 * Where the text in a translated language is part of a bilingual or multilingual edition.
	 */
	Translated_language_in_a_multilingual_edition("07"), //

	/**
	 * For example, on a DVD.
	 */
	Language_of_audio_track("08"), //

	/**
	 * For example, on a DVD.
	 */
	Language_of_subtitles("09");

	public final String value;

	private LanguageRoles(String value)
	{
		this.value = value;
	}

	private static Map<String, LanguageRoles> map;

	private static Map<String, LanguageRoles> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (LanguageRoles e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static LanguageRoles byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
