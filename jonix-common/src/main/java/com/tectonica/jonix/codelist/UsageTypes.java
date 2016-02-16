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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 145</b>
 * <p>
 * Description: Usage type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist145">ONIX
 *      Codelist 145 in Reference Guide</a>
 */
public enum UsageTypes
{
	/**
	 * Preview before purchase
	 */
	Preview("01", "Preview"), //

	/**
	 * Print paper copy of extract
	 */
	Print("02", "Print"), //

	/**
	 * Make digital copy of extract
	 */
	Copy_paste("03", "Copy / paste"), //

	/**
	 * Share product across multiple concurrent devices
	 */
	Share("04", "Share"), //

	/**
	 * 'Read aloud' with text to speech functionality
	 */
	Text_to_speech("05", "Text to speech"), //

	/**
	 * Lendable to other device owner or account holder, eg 'Lend-to-a-friend', library lending. The 'primary' copy
	 * becomes unusable while the secondary copy is 'on loan' unless a number of concurrent borrowers is also specified)
	 */
	Lend("06", "Lend"), //

	/**
	 * E-publication license is time limited. Use with 02 from List 146 and a number of days in &lt;EpubUsageLimit&gt;
	 */
	Time_limited_license("07", "Time-limited license"), //

	/**
	 * Maximum number of consecutive loans (eg from a library) to a single device owner or account holder. Note that a
	 * limit of 1 indicates that a loan cannot be renewed
	 */
	Loan_renewal("08", "Loan renewal");

	public final String value;
	public final String label;

	private UsageTypes(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	private static Map<String, UsageTypes> map;

	private static Map<String, UsageTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (UsageTypes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static UsageTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
