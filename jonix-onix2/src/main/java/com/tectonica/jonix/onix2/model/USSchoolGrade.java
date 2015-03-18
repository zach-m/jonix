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

package com.tectonica.jonix.onix2.model;

import com.tectonica.jonix.onix2.DU;
import com.tectonica.jonix.onix2.codelist.List138;
import com.tectonica.jonix.onix2.codelist.List14;
import com.tectonica.jonix.onix2.codelist.List3;
import com.tectonica.jonix.onix2.codelist.List34;
import com.tectonica.jonix.onix2.codelist.List74;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class USSchoolGrade
{
	public static final String refname = "USSchoolGrade";
	public static final String shortname = "b189";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public String value; // NonEmptyString

	public static USSchoolGrade fromDoc(org.w3c.dom.Element element)
	{
		final USSchoolGrade x = new USSchoolGrade();

		x.textformat = List34.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = List14.byValue(DU.getAttribute(element, "textcase"));
		x.language = List74.byValue(DU.getAttribute(element, "language"));
		x.transliteration = List138.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		x.value = DU.getContentAsString(element);

		return x;
	}
}
