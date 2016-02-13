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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 41</b>
 * <p>
 * Description: Prize or award achievement code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum PrizeOrAwardAchievements
{
	Winner("01"), //

	/**
	 * Named as being in second place
	 */
	Runner_up("02"), //

	/**
	 * Cited as being worthy of special attention at the final stage of the judging process, but not named specifically
	 * as winner or runner-up. Possible terminology used by a particular prize includes &#8216;specially
	 * commended&#8217; or &#8216;honored&#8217;
	 */
	Commended("03"), //

	/**
	 * Title named by the judging process to be one of the final list of candidates, such as a &#8216;short-list&#8217;
	 * from which the winner is selected, or a title named as &#8216;finalist&#8217;
	 */
	Short_listed("04"), //

	/**
	 * Title named by the judging process to be one of the preliminary list of candidates, such as a
	 * &#8216;long-list&#8217; from which first a shorter list or set of finalists is selected, and then the winner is
	 * announced
	 */
	Long_listed("05"), //

	/**
	 * Or co-winner
	 */
	Joint_winner("06"), //

	/**
	 * Selected by judging panel or an official nominating process for final consideration for a prize, award or honor
	 * for which no &#8216;short-list&#8217; or &#8216;long list&#8217; exists
	 */
	Nominated("07");

	public final String value;

	private PrizeOrAwardAchievements(String value)
	{
		this.value = value;
	}

	public static PrizeOrAwardAchievements byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (PrizeOrAwardAchievements e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
