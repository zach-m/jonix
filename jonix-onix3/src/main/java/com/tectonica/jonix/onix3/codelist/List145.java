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

package com.tectonica.jonix.onix3.codelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Usage type
 */
public enum List145
{
	/**
	 * Preview before purchase.
	 */
	Preview("01"), //

	/**
	 * Print paper copy of extract.
	 */
	Print("02"), //

	/**
	 * Make digital copy of extract.
	 */
	Copy___paste("03"), //

	/**
	 * Share product across multiple concurrent devices.
	 */
	Share("04"), //

	/**
	 * ‘Read aloud’ with text to speech functionality.
	 */
	Text_to_speech("05"), //

	/**
	 * Lendable to other device owner or account holder, eg ‘Lend-to-a-friend’, library lending. The ‘primary’ copy becomes unusable while
	 * the secondary copy is ‘on loan’ unless a number of concurrent borrowers is also specified).
	 */
	Lend("06"), //

	/**
	 * E-publication license is time limited. Use with 02 from List 146 and a number of days in <EpubUsageLimit>.
	 */
	Time_limited_license("07");

	public final String value;

	private List145(String value)
	{
		this.value = value;
	}

	public static List145 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List145 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
