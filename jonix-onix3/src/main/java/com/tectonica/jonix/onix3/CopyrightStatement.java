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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.RightsTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class CopyrightStatement
{
	public static final String refname = "CopyrightStatement";
	public static final String shortname = "copyrightstatement";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public CopyrightType copyrightType; // Optional
	public List<CopyrightYear> copyrightYears; // OneOrMore
	public List<CopyrightOwner> copyrightOwners; // ZeroOrMore

	public static CopyrightStatement fromDoc(org.w3c.dom.Element element)
	{
		final CopyrightStatement x = new CopyrightStatement();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(CopyrightType.refname) || name.equals(CopyrightType.shortname))
					x.copyrightType = CopyrightType.fromDoc(element);
				else if (name.equals(CopyrightYear.refname) || name.equals(CopyrightYear.shortname))
					x.copyrightYears = DU.addToList(x.copyrightYears, CopyrightYear.fromDoc(element));
				else if (name.equals(CopyrightOwner.refname) || name.equals(CopyrightOwner.shortname))
					x.copyrightOwners = DU.addToList(x.copyrightOwners, CopyrightOwner.fromDoc(element));
			}
		});

		return x;
	}

	public RightsTypes getCopyrightTypeValue()
	{
		return (copyrightType == null) ? null : copyrightType.value;
	}
}
