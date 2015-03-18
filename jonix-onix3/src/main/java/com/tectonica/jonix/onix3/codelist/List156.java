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

/**
 * Cited content type
 */
public enum List156
{
	/**
	 * The full text of a review in a third-party publication in any medium.
	 */
	Review("01"), //

	Bestseller_list("02"), //

	/**
	 * Other than a review.
	 */
	Media_mention("03"), //

	/**
	 * (North America) Inclusion in a program such as ‘Chicago Reads’, ‘Seattle Reads’.
	 */
	_One_locality__one_book__program("04");

	public final String value;

	private List156(String value)
	{
		this.value = value;
	}

	public static List156 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List156 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
