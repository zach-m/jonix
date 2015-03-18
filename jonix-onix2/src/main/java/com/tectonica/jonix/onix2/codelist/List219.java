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
 * Rights type code
 */
public enum List219
{
	/**
	 * Text or image copyright (normally indicated by the © symbol).
	 */
	Copyright("C"), //

	/**
	 * Phonogram copyright or neighbouring right (normally indicated by the ℗ symbol).
	 */
	Phonogram_right("P"), //

	/**
	 * Sui generis database right.
	 */
	Database_right("D");

	public final String value;

	private List219(String value)
	{
		this.value = value;
	}

	public static List219 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List219 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
