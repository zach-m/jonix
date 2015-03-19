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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList215
 * <p>
 * Proximity
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum Proximitys
{
	Less_than("01"), //

	Not_more_than("02"), //

	/**
	 * The supplier’s true figure, or at least a best estimate expected to be within 10% of the true figure (ie a quoted figure of 100 could
	 * in fact be anything between 91 and 111).
	 */
	Exactly("03"), //

	/**
	 * Generally interpreted as within 25% of the true figure (ie a quoted figure of 100 could in fact be anything between 80 and 133). The
	 * supplier may introduce a deliberate approximation to reduce the commercial sensitivity of the figure.
	 */
	Approximately("04"), //

	/**
	 * Generally interpreted as within a factor of two of the true figure (ie a quoted figure of 100 could in fact be anything between 50
	 * and 200). The supplier may introduce a deliberate approximation to reduce the commercial sensitivity of the figure.
	 */
	About("05"), //

	Not_less_than("06"), //

	More_than("07");

	public final String value;

	private Proximitys(String value)
	{
		this.value = value;
	}

	public static Proximitys byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (Proximitys e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
