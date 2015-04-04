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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.RightsTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class CopyrightStatement implements OnixSuperComposite, Serializable
{
	public static final String refname = "CopyrightStatement";
	public static final String shortname = "copyrightstatement";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public CopyrightType copyrightType; // Optional
	public List<CopyrightYear> copyrightYears; // OneOrMore
	public List<CopyrightOwner> copyrightOwners; // ZeroOrMore

	public CopyrightStatement()
	{}

	public CopyrightStatement(org.w3c.dom.Element element)
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
				if (name.equals(CopyrightType.refname) || name.equals(CopyrightType.shortname))
					copyrightType = new CopyrightType(element);
				else if (name.equals(CopyrightYear.refname) || name.equals(CopyrightYear.shortname))
					copyrightYears = JPU.addToList(copyrightYears, new CopyrightYear(element));
				else if (name.equals(CopyrightOwner.refname) || name.equals(CopyrightOwner.shortname))
					copyrightOwners = JPU.addToList(copyrightOwners, new CopyrightOwner(element));
			}
		});
	}

	public RightsTypes getCopyrightTypeValue()
	{
		return (copyrightType == null) ? null : copyrightType.value;
	}

	public List<String> getCopyrightYearValues()
	{
		if (copyrightYears != null)
		{
			List<String> list = new ArrayList<>();
			for (CopyrightYear i : copyrightYears)
				list.add(i.value);
			return list;
		}
		return null;
	}
}
