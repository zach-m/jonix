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
import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixCopyrightOwnerIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class CopyrightOwner implements JonixComposite, Serializable
{
	public static final String refname = "CopyrightOwner";
	public static final String shortname = "copyrightowner";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<CopyrightOwnerIdentifier> copyrightOwnerIdentifiers; // OneOrMore
	public PersonName personName; // Optional
	public CorporateName corporateName; // Optional

	public CopyrightOwner()
	{}

	public CopyrightOwner(org.w3c.dom.Element element)
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
				if (name.equals(CopyrightOwnerIdentifier.refname) || name.equals(CopyrightOwnerIdentifier.shortname))
					copyrightOwnerIdentifiers = JPU.addToList(copyrightOwnerIdentifiers, new CopyrightOwnerIdentifier(element));
				else if (name.equals(PersonName.refname) || name.equals(PersonName.shortname))
					personName = new PersonName(element);
				else if (name.equals(CorporateName.refname) || name.equals(CorporateName.shortname))
					corporateName = new CorporateName(element);
			}
		});
	}

	public String getPersonNameValue()
	{
		return (personName == null) ? null : personName.value;
	}

	public String getCorporateNameValue()
	{
		return (corporateName == null) ? null : corporateName.value;
	}

	public JonixCopyrightOwnerIdentifier findCopyrightOwnerIdentifier(NameCodeTypes copyrightOwnerIDType)
	{
		if (copyrightOwnerIdentifiers != null)
		{
			for (CopyrightOwnerIdentifier x : copyrightOwnerIdentifiers)
			{
				if (x.getCopyrightOwnerIDTypeValue() == copyrightOwnerIDType)
					return x.asJonixCopyrightOwnerIdentifier();
			}
		}
		return null;
	}

	public List<JonixCopyrightOwnerIdentifier> findCopyrightOwnerIdentifiers(java.util.Set<NameCodeTypes> copyrightOwnerIDTypes)
	{
		if (copyrightOwnerIdentifiers != null)
		{
			List<JonixCopyrightOwnerIdentifier> matches = new ArrayList<>();
			for (CopyrightOwnerIdentifier x : copyrightOwnerIdentifiers)
			{
				if (copyrightOwnerIDTypes == null || copyrightOwnerIDTypes.contains(x.getCopyrightOwnerIDTypeValue()))
					matches.add(x.asJonixCopyrightOwnerIdentifier());
			}
			return matches;
		}
		return null;
	}
}
