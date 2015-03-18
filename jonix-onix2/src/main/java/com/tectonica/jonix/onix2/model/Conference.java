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

import java.util.List;

import com.tectonica.jonix.onix2.DU;
import com.tectonica.jonix.onix2.codelist.List138;
import com.tectonica.jonix.onix2.codelist.List14;
import com.tectonica.jonix.onix2.codelist.List3;
import com.tectonica.jonix.onix2.codelist.List34;
import com.tectonica.jonix.onix2.codelist.List74;

public class Conference
{
	public static final String refname = "Conference";
	public static final String shortname = "conference";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
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
				if (name.equalsIgnoreCase(ConferenceRole.refname) || name.equalsIgnoreCase(ConferenceRole.shortname))
					x.conferenceRole = ConferenceRole.fromDoc(element);
				else if (name.equalsIgnoreCase(ConferenceName.refname) || name.equalsIgnoreCase(ConferenceName.shortname))
					x.conferenceName = ConferenceName.fromDoc(element);
				else if (name.equalsIgnoreCase(ConferenceAcronym.refname) || name.equalsIgnoreCase(ConferenceAcronym.shortname))
					x.conferenceAcronym = ConferenceAcronym.fromDoc(element);
				else if (name.equalsIgnoreCase(ConferenceNumber.refname) || name.equalsIgnoreCase(ConferenceNumber.shortname))
					x.conferenceNumber = ConferenceNumber.fromDoc(element);
				else if (name.equalsIgnoreCase(ConferenceTheme.refname) || name.equalsIgnoreCase(ConferenceTheme.shortname))
					x.conferenceTheme = ConferenceTheme.fromDoc(element);
				else if (name.equalsIgnoreCase(ConferenceDate.refname) || name.equalsIgnoreCase(ConferenceDate.shortname))
					x.conferenceDate = ConferenceDate.fromDoc(element);
				else if (name.equalsIgnoreCase(ConferencePlace.refname) || name.equalsIgnoreCase(ConferencePlace.shortname))
					x.conferencePlace = ConferencePlace.fromDoc(element);
				else if (name.equalsIgnoreCase(ConferenceSponsor.refname) || name.equalsIgnoreCase(ConferenceSponsor.shortname))
					x.conferenceSponsors = DU.addToList(x.conferenceSponsors, ConferenceSponsor.fromDoc(element));
				else if (name.equalsIgnoreCase(Website.refname) || name.equalsIgnoreCase(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
			}
		});

		return x;
	}
}
