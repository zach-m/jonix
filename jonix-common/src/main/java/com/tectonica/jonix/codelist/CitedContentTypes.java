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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 156</b>
 * <p>
 * Description: Cited content type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist156">ONIX
 *      Codelist 156 in Reference Guide</a>
 */
public enum CitedContentTypes
{
	/**
	 * The full text of a review in a third-party publication in any medium
	 */
	Review("01", "Review"), //

	Bestseller_list("02", "Bestseller list"), //

	/**
	 * Other than a review
	 */
	Media_mention("03", "Media mention"), //

	/**
	 * (North America) Inclusion in a program such as 'Chicago Reads', 'Seattle Reads'
	 */
	_One_locality_one_book_program("04", "‘One locality, one book’ program");

	public final String value;
	public final String label;

	private CitedContentTypes(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static CitedContentTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (CitedContentTypes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
