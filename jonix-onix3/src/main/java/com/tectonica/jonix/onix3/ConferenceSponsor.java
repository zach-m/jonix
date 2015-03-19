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
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class ConferenceSponsor
{
	public static final String refname = "ConferenceSponsor";
	public static final String shortname = "conferencesponsor";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public List<ConferenceSponsorIdentifier> conferenceSponsorIdentifiers; // OneOrMore
	public PersonName personName; // Optional
	public CorporateName corporateName; // Optional

	public static ConferenceSponsor fromDoc(org.w3c.dom.Element element)
	{
		final ConferenceSponsor x = new ConferenceSponsor();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ConferenceSponsorIdentifier.refname) || name.equals(ConferenceSponsorIdentifier.shortname))
					x.conferenceSponsorIdentifiers = DU.addToList(x.conferenceSponsorIdentifiers,
							ConferenceSponsorIdentifier.fromDoc(element));
				else if (name.equals(PersonName.refname) || name.equals(PersonName.shortname))
					x.personName = PersonName.fromDoc(element);
				else if (name.equals(CorporateName.refname) || name.equals(CorporateName.shortname))
					x.corporateName = CorporateName.fromDoc(element);
			}
		});

		return x;
	}

	public String getPersonNameValue()
	{
		return (personName == null) ? null : personName.value;
	}

	public String getCorporateNameValue()
	{
		return (corporateName == null) ? null : corporateName.value;
	}
}
