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

package com.tectonica.jonix.onix3.model;

import com.tectonica.jonix.onix3.DU;
import com.tectonica.jonix.onix3.codelist.List121;
import com.tectonica.jonix.onix3.codelist.List3;
import com.tectonica.jonix.onix3.codelist.List74;

public class NamesBeforeKey
{
	public static final String refname = "NamesBeforeKey";
	public static final String shortname = "b039";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;
	public String collationkey;
	public List121 textscript;
	public List74 language;

	public String value; // dt.NonEmptyString

	public static NamesBeforeKey fromDoc(org.w3c.dom.Element element)
	{
		final NamesBeforeKey x = new NamesBeforeKey();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");
		x.collationkey = DU.getAttribute(element, "collationkey");
		x.textscript = List121.byValue(DU.getAttribute(element, "textscript"));
		x.language = List74.byValue(DU.getAttribute(element, "language"));

		x.value = DU.getContentAsString(element);

		return x;
	}
}
