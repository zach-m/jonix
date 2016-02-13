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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 19</b>
 * <p>
 * Description: Unnamed person(s)
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist19">ONIX
 *      Codelist 19 in Reference Guide</a>
 */
public enum UnnamedPersonss
{
	Unknown("01", "Unknown"), //

	Anonymous("02", "Anonymous"), //

	/**
	 * And others: additional contributors not listed
	 */
	et_al("03", "et al"), //

	/**
	 * When the product is a pack of books by different authors
	 */
	Various_authors("04", "Various authors"), //

	/**
	 * Use with Contributor role code E07 &#8216;read by&#8217;, for audio books for the blind
	 */
	Synthesized_voice_male("05", "Synthesized voice – male"), //

	/**
	 * Use with Contributor role code E07 &#8216;read by&#8217;, for audio books for the blind
	 */
	Synthesized_voice_female("06", "Synthesized voice – female"), //

	/**
	 * Use with Contributor role code E07 &#8216;read by&#8217;, for audio books for the blind
	 */
	Synthesized_voice_unspecified("07", "Synthesized voice – unspecified");

	public final String value;
	public final String label;

	private UnnamedPersonss(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static UnnamedPersonss byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (UnnamedPersonss e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
