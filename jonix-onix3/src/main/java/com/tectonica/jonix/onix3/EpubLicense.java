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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite;
import com.tectonica.jonix.codelist.LicenseExpressionTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixEpubLicenseExpression;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class EpubLicense implements OnixComposite, Serializable
{
	public static final String refname = "EpubLicense";
	public static final String shortname = "epublicense";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<EpubLicenseName> epubLicenseNames; // OneOrMore
	public List<EpubLicenseExpression> epubLicenseExpressions; // ZeroOrMore

	public EpubLicense()
	{}

	public EpubLicense(org.w3c.dom.Element element)
	{
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(EpubLicenseName.refname) || name.equals(EpubLicenseName.shortname))
					epubLicenseNames = JPU.addToList(epubLicenseNames, new EpubLicenseName(element));
				else if (name.equals(EpubLicenseExpression.refname) || name.equals(EpubLicenseExpression.shortname))
					epubLicenseExpressions = JPU.addToList(epubLicenseExpressions, new EpubLicenseExpression(element));
			}
		});
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

	public JonixEpubLicenseExpression findEpubLicenseExpression(LicenseExpressionTypes epubLicenseExpressionType)
	{
		if (epubLicenseExpressions != null)
		{
			for (EpubLicenseExpression x : epubLicenseExpressions)
			{
				if (x.getEpubLicenseExpressionTypeValue() == epubLicenseExpressionType)
					return x.asJonixEpubLicenseExpression();
			}
		}
		return null;
	}

	public List<JonixEpubLicenseExpression> findEpubLicenseExpressions(java.util.Set<LicenseExpressionTypes> epubLicenseExpressionTypes)
	{
		if (epubLicenseExpressions != null)
		{
			List<JonixEpubLicenseExpression> matches = new ArrayList<>();
			for (EpubLicenseExpression x : epubLicenseExpressions)
			{
				if (epubLicenseExpressionTypes == null || epubLicenseExpressionTypes.contains(x.getEpubLicenseExpressionTypeValue()))
					matches.add(x.asJonixEpubLicenseExpression());
			}
			return matches;
		}
		return null;
	}
}
