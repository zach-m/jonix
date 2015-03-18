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

package com.tectonica.jonix.onix3.model;

import java.util.List;

import com.tectonica.jonix.onix3.DU;
import com.tectonica.jonix.onix3.codelist.List3;

public class PublisherRepresentative
{
	public static final String refname = "PublisherRepresentative";
	public static final String shortname = "publisherrepresentative";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
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
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(AgentRole.refname) || name.equalsIgnoreCase(AgentRole.shortname))
					x.agentRole = AgentRole.fromDoc(element);
				else if (name.equalsIgnoreCase(AgentIdentifier.refname) || name.equalsIgnoreCase(AgentIdentifier.shortname))
					x.agentIdentifiers = DU.addToList(x.agentIdentifiers, AgentIdentifier.fromDoc(element));
				else if (name.equalsIgnoreCase(AgentName.refname) || name.equalsIgnoreCase(AgentName.shortname))
					x.agentName = AgentName.fromDoc(element);
				else if (name.equalsIgnoreCase(TelephoneNumber.refname) || name.equalsIgnoreCase(TelephoneNumber.shortname))
					x.telephoneNumbers = DU.addToList(x.telephoneNumbers, TelephoneNumber.fromDoc(element));
				else if (name.equalsIgnoreCase(FaxNumber.refname) || name.equalsIgnoreCase(FaxNumber.shortname))
					x.faxNumbers = DU.addToList(x.faxNumbers, FaxNumber.fromDoc(element));
				else if (name.equalsIgnoreCase(EmailAddress.refname) || name.equalsIgnoreCase(EmailAddress.shortname))
					x.emailAddresss = DU.addToList(x.emailAddresss, EmailAddress.fromDoc(element));
				else if (name.equalsIgnoreCase(Website.refname) || name.equalsIgnoreCase(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
			}
		});

		return x;
	}
}
