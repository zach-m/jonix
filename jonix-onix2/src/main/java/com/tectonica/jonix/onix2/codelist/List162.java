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
 * Resource version feature type
 */
public enum List162
{
	/**
	 * Resource Version Feature Value carries a code from List 178.
	 */
	File_format("01"), //

	/**
	 * Resource Version Feature Value carries an integer.
	 */
	Image_height_in_pixels("02"), //

	/**
	 * Resource Version Feature Value carries an integer.
	 */
	Image_width_in_pixels("03"), //

	/**
	 * Resource Version Feature Value carries the filename of the supporting resource.
	 */
	Filename("04"), //

	/**
	 * Resource Version Feature Value carries a decimal number only, suggested no more than 2 significant digits (eg 1.7, not 1.7462).
	 */
	Approximate_download_file_size_in_megabytes("05"), //

	/**
	 * MD5 hash value of the resource file. <ResourceVersionFeatureValue> should contain the hash value (as 32 hexadecimal digits). Can be
	 * used as a cryptographic check on the integrity of a resource after it has been retrieved.
	 */
	MD5_hash_value("06"), //

	/**
	 * Resource Version Feature Value carries a integer number only (eg 1831023).
	 */
	Exact_download_file_size_in_bytes("07");

	public final String value;

	private List162(String value)
	{
		this.value = value;
	}

	public static List162 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List162 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
