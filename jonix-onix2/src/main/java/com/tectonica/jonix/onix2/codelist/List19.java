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

/**
 * Unnamed person(s)
 */
public enum List19
{
	Unknown("01"), //

	Anonymous("02"), //

	/**
	 * And others: additional contributors not listed.
	 */
	et_al("03"), //

	/**
	 * When the product is a pack of books by different authors.
	 */
	Various_authors("04"), //

	/**
	 * Use with Contributor role code E07 “read by”, for audio books for the blind.
	 */
	Synthesized_voice___male("05"), //

	/**
	 * Use with Contributor role code E07 “read by”, for audio books for the blind.
	 */
	Synthesized_voice___female("06"), //

	/**
	 * Use with Contributor role code E07 “read by”, for audio books for the blind.
	 */
	Synthesized_voice___unspecified("07");

	public final String value;

	private List19(String value)
	{
		this.value = value;
	}

	public static List19 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List19 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
