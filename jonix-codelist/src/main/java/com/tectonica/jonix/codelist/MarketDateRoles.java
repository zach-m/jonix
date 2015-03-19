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
 * Market date role
 */
public enum MarketDateRoles
{
	/**
	 * The nominal date of publication in this market. If there is a strict embargo on retail sales before the expected date, it should be
	 * specified separately as an embargo date.
	 */
	Publication_date("01"), //

	/**
	 * If there is an embargo on retail sales in this market before a certain date, the date from which the embargo is lifted and retail
	 * sales are permitted.
	 */
	Embargo_date("02");

	public final String value;

	private MarketDateRoles(String value)
	{
		this.value = value;
	}

	public static MarketDateRoles byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (MarketDateRoles e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
