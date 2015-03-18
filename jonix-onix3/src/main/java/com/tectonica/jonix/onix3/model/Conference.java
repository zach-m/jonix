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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Conference
{
	public static final String refname = "Conference";
	public static final String shortname = "conference";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public ConferenceRole conferenceRole; // Optional
	public ConferenceName conferenceName; // Required
	public ConferenceAcronym conferenceAcronym; // Optional
	public ConferenceNumber conferenceNumber; // Optional
	public ConferenceTheme conferenceTheme; // Optional
	public ConferenceDate conferenceDate; // Optional
	public ConferencePlace conferencePlace; // Optional
	public List<ConferenceSponsor> conferenceSponsors; // ZeroOrMore
	public List<Website> websites; // ZeroOrMore

	public static Conference fromDoc(org.w3c.dom.Element element)
	{
		final Conference x = new Conference();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ConferenceRole.refname) || name.equals(ConferenceRole.shortname))
					x.conferenceRole = ConferenceRole.fromDoc(element);
				else if (name.equals(ConferenceName.refname) || name.equals(ConferenceName.shortname))
					x.conferenceName = ConferenceName.fromDoc(element);
				else if (name.equals(ConferenceAcronym.refname) || name.equals(ConferenceAcronym.shortname))
					x.conferenceAcronym = ConferenceAcronym.fromDoc(element);
				else if (name.equals(ConferenceNumber.refname) || name.equals(ConferenceNumber.shortname))
					x.conferenceNumber = ConferenceNumber.fromDoc(element);
				else if (name.equals(ConferenceTheme.refname) || name.equals(ConferenceTheme.shortname))
					x.conferenceTheme = ConferenceTheme.fromDoc(element);
				else if (name.equals(ConferenceDate.refname) || name.equals(ConferenceDate.shortname))
					x.conferenceDate = ConferenceDate.fromDoc(element);
				else if (name.equals(ConferencePlace.refname) || name.equals(ConferencePlace.shortname))
					x.conferencePlace = ConferencePlace.fromDoc(element);
				else if (name.equals(ConferenceSponsor.refname) || name.equals(ConferenceSponsor.shortname))
					x.conferenceSponsors = DU.addToList(x.conferenceSponsors, ConferenceSponsor.fromDoc(element));
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
			}
		});

		return x;
	}
}
