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
 * Image/audio/video file link type
 */
public enum List40
{
	URL("01"), //

	DOI("02"), //

	PURL("03"), //

	URN("04"), //

	FTP_address("05"), //

	filename("06");

	public final String value;

	private List40(String value)
	{
		this.value = value;
	}

	public static List40 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List40 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
