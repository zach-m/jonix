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

import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class EpubLicense
{
	public static final String refname = "EpubLicense";
	public static final String shortname = "epublicense";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<EpubLicenseName> epubLicenseNames; // OneOrMore
	public List<EpubLicenseExpression> epubLicenseExpressions; // ZeroOrMore

	public static EpubLicense fromDoc(org.w3c.dom.Element element)
	{
		final EpubLicense x = new EpubLicense();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(EpubLicenseName.refname) || name.equals(EpubLicenseName.shortname))
					x.epubLicenseNames = DU.addToList(x.epubLicenseNames, EpubLicenseName.fromDoc(element));
				else if (name.equals(EpubLicenseExpression.refname) || name.equals(EpubLicenseExpression.shortname))
					x.epubLicenseExpressions = DU.addToList(x.epubLicenseExpressions, EpubLicenseExpression.fromDoc(element));
			}
		});

		return x;
	}

	public List<String> getEpubLicenseNameValues()
	{
		if (epubLicenseNames != null)
		{
			List<String> list = new ArrayList<>();
			for (EpubLicenseName i : epubLicenseNames)
				list.add(i.value);
			return list;
		}
		return null;
	}
}
