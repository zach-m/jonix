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

public class Imprint
{
	public static final String refname = "Imprint";
	public static final String shortname = "imprint";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public ImprintName imprintName; // Optional
	public NameCodeType nameCodeType; // Required
	public NameCodeTypeName nameCodeTypeName; // Optional
	public NameCodeValue nameCodeValue; // Required

	public static Imprint fromDoc(org.w3c.dom.Element element)
	{
		final Imprint x = new Imprint();

		x.textformat = List34.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = List14.byValue(DU.getAttribute(element, "textcase"));
		x.language = List74.byValue(DU.getAttribute(element, "language"));
		x.transliteration = List138.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(ImprintName.refname) || name.equalsIgnoreCase(ImprintName.shortname))
					x.imprintName = ImprintName.fromDoc(element);
				else if (name.equalsIgnoreCase(NameCodeType.refname) || name.equalsIgnoreCase(NameCodeType.shortname))
					x.nameCodeType = NameCodeType.fromDoc(element);
				else if (name.equalsIgnoreCase(NameCodeTypeName.refname) || name.equalsIgnoreCase(NameCodeTypeName.shortname))
					x.nameCodeTypeName = NameCodeTypeName.fromDoc(element);
				else if (name.equalsIgnoreCase(NameCodeValue.refname) || name.equalsIgnoreCase(NameCodeValue.shortname))
					x.nameCodeValue = NameCodeValue.fromDoc(element);
			}
		});

		return x;
	}
}
