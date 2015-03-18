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

public class Website
{
	public static final String refname = "Website";
	public static final String shortname = "website";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public WebsiteRole websiteRole; // Optional
	public List<WebsiteDescription> websiteDescriptions; // ZeroOrMore
	public WebsiteLink websiteLink; // Required

	public static Website fromDoc(org.w3c.dom.Element element)
	{
		final Website x = new Website();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(WebsiteRole.refname) || name.equalsIgnoreCase(WebsiteRole.shortname))
					x.websiteRole = WebsiteRole.fromDoc(element);
				else if (name.equalsIgnoreCase(WebsiteDescription.refname) || name.equalsIgnoreCase(WebsiteDescription.shortname))
					x.websiteDescriptions = DU.addToList(x.websiteDescriptions, WebsiteDescription.fromDoc(element));
				else if (name.equalsIgnoreCase(WebsiteLink.refname) || name.equalsIgnoreCase(WebsiteLink.shortname))
					x.websiteLink = WebsiteLink.fromDoc(element);
			}
		});

		return x;
	}
}
