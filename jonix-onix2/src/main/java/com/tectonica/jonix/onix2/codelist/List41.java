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
 * Prize or award achievement code
 */
public enum List41
{
	Winner("01"), //

	/**
	 * Named as being in second place.
	 */
	Runner_up("02"), //

	/**
	 * Cited as being worthy of special attention at the final stage of the judging process, but not named specifically as winner or
	 * runner-up. Possible terminology used by a particular prize includes ‘specially commended’ or ‘honored’.
	 */
	Commended("03"), //

	/**
	 * Title named by the judging process to be one of the final list of candidates, such as a ‘short-list’ from which the winner is
	 * selected, or a title named as ‘finalist’.
	 */
	Short_listed("04"), //

	/**
	 * Title named by the judging process to be one of the preliminary list of candidates, such as a ‘long-list’ from which first a shorter
	 * list or set of finalists is selected, and then the winner is announced.
	 */
	Long_listed("05"), //

	/**
	 * Or co-winner.
	 */
	Joint_winner("06"), //

	/**
	 * Selected by judging panel or an official nominating process for final consideration for a prize, award or honour for which no
	 * “short-list” or “long list” exists.
	 */
	Nominated("07");

	public final String value;

	private List41(String value)
	{
		this.value = value;
	}

	public static List41 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List41 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
