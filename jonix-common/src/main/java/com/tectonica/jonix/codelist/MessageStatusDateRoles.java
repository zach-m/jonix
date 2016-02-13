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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 222</b>
 * <p>
 * Description: Message status date role &lt;p&gt;NOTE: Introduced in Onix3
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist222">ONIX
 *      Codelist 222 in Reference Guide</a>
 */
public enum MessageStatusDateRoles
{
	/**
	 * Expected or actual date of processing and ingestion of data to recipient&#8217;s system
	 */
	Ingest_date("01", "Ingest date"), //

	/**
	 * Expected or actual date for data to be available from the recipient&#8217;s system to downstream supply chain
	 * partners (or where the recipient is a retailer, to consumers)
	 */
	Export_date("02", "Export date");

	public final String value;
	public final String label;

	private MessageStatusDateRoles(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static MessageStatusDateRoles byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (MessageStatusDateRoles e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
