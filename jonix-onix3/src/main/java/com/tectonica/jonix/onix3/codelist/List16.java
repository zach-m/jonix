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
 * Work identifier type code
 */
public enum List16
{
	Proprietary("01"), //

	/**
	 * 10-character ISBN of manifestation of work, when this is the only work identifier available – now DEPRECATED in ONIX for Books,
	 * except where providing historical information for compatibility with legacy systems. It should only be used in relation to products
	 * published before 2007 – when ISBN-13 superseded it – and should never be used as the ONLY identifier (it should always be accompanied
	 * by the correct GTIN-13 / ISBN-13 of the manifestation of the work).
	 */
	ISBN_10("02"), //

	/**
	 * Digital Object Identifier (variable length and character set).
	 */
	DOI("06"), //

	/**
	 * International Standard Text Code (16 characters: numerals and letters A-F, unhyphenated).
	 */
	ISTC("11"), //

	/**
	 * 13-character ISBN of manifestation of work, when this is the only work identifier available.
	 */
	ISBN_13("15"), //

	/**
	 * International Standard Recording Code.
	 */
	ISRC("18");

	public final String value;

	private List16(String value)
	{
		this.value = value;
	}

	public static List16 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List16 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
