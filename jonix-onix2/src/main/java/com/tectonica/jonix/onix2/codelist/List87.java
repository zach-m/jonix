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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Bible reference location
 */
public enum List87
{
	/**
	 * References are printed in a narrow column in the center of the page between two columns of text.
	 */
	Center_column("CCL"), //

	/**
	 * References are printed at the foot of the page.
	 */
	Page_end("PGE"), //

	/**
	 * References are printed in a column to the side of the scripture.
	 */
	Side_column("SID"), //

	/**
	 * References are printed at the end of the applicable verse.
	 */
	Verse_end("VER"), //

	/**
	 * The person creating the ONIX record does not know where the references are located.
	 */
	Unknown("UNK"), //

	/**
	 * Other locations not otherwise identified.
	 */
	Other("ZZZ");

	public final String value;

	private List87(String value)
	{
		this.value = value;
	}

	public static List87 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List87 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
