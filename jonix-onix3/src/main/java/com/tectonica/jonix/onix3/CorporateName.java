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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextScriptCodeIso15924s;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class CorporateName
{
	public static final String refname = "CorporateName";
	public static final String shortname = "b047";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;
	public String collationkey;
	public TextScriptCodeIso15924s textscript;
	public LanguageCodeIso6392Bs language;

	public String value; // dt.NonEmptyString

	public static CorporateName fromDoc(org.w3c.dom.Element element)
	{
		final CorporateName x = new CorporateName();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");
		x.collationkey = DU.getAttribute(element, "collationkey");
		x.textscript = TextScriptCodeIso15924s.byValue(DU.getAttribute(element, "textscript"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));

		x.value = DU.getContentAsString(element);

		return x;
	}
}
