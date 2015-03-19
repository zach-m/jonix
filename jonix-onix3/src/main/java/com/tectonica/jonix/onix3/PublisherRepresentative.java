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
import com.tectonica.jonix.codelist.AgentRoles;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class PublisherRepresentative
{
	public static final String refname = "PublisherRepresentative";
	public static final String shortname = "publisherrepresentative";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public AgentRole agentRole; // Required
	public List<AgentIdentifier> agentIdentifiers; // OneOrMore
	public AgentName agentName; // Optional
	public List<TelephoneNumber> telephoneNumbers; // ZeroOrMore
	public List<FaxNumber> faxNumbers; // ZeroOrMore
	public List<EmailAddress> emailAddresss; // ZeroOrMore
	public List<Website> websites; // ZeroOrMore

	public static PublisherRepresentative fromDoc(org.w3c.dom.Element element)
	{
		final PublisherRepresentative x = new PublisherRepresentative();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(AgentRole.refname) || name.equals(AgentRole.shortname))
					x.agentRole = AgentRole.fromDoc(element);
				else if (name.equals(AgentIdentifier.refname) || name.equals(AgentIdentifier.shortname))
					x.agentIdentifiers = DU.addToList(x.agentIdentifiers, AgentIdentifier.fromDoc(element));
				else if (name.equals(AgentName.refname) || name.equals(AgentName.shortname))
					x.agentName = AgentName.fromDoc(element);
				else if (name.equals(TelephoneNumber.refname) || name.equals(TelephoneNumber.shortname))
					x.telephoneNumbers = DU.addToList(x.telephoneNumbers, TelephoneNumber.fromDoc(element));
				else if (name.equals(FaxNumber.refname) || name.equals(FaxNumber.shortname))
					x.faxNumbers = DU.addToList(x.faxNumbers, FaxNumber.fromDoc(element));
				else if (name.equals(EmailAddress.refname) || name.equals(EmailAddress.shortname))
					x.emailAddresss = DU.addToList(x.emailAddresss, EmailAddress.fromDoc(element));
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
			}
		});

		return x;
	}

	public AgentRoles getAgentRoleValue()
	{
		return (agentRole == null) ? null : agentRole.value;
	}

	public String getAgentNameValue()
	{
		return (agentName == null) ? null : agentName.value;
	}
}
