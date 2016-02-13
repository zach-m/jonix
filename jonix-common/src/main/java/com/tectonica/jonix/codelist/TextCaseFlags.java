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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 14</b>
 * <p>
 * Description: Text case flag
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum TextCaseFlags
{
	/**
	 * Default
	 */
	Undefined("00", "Undefined"), //

	/**
	 * Initial capitals on first word and subsequently on proper names only, eg &#8216;The conquest of Mexico&#8217;
	 */
	Sentence_case("01", "Sentence case"), //

	/**
	 * Initial capitals on first word and subsequently on all significant words (nouns, pronouns, adjectives, verbs,
	 * adverbs, subordinate conjunctions) thereafter. Unless they appear as the first word, articles, prepositions and
	 * coordinating conjunctions remain lower case, eg &#8216;The Conquest of Mexico&#8217;
	 */
	Title_case("02", "Title case"), //

	/**
	 * For example, &#8216;THE CONQUEST OF MEXICO&#8217;
	 */
	All_capitals("03", "All capitals");

	public final String value;
	public final String label;

	private TextCaseFlags(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static TextCaseFlags byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (TextCaseFlags e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
