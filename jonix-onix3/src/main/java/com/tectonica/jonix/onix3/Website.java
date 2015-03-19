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
import com.tectonica.jonix.codelist.WebsiteRoles;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Website
{
	public static final String refname = "Website";
	public static final String shortname = "website";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public WebsiteRole websiteRole; // Optional
	public List<WebsiteDescription> websiteDescriptions; // ZeroOrMore
	public WebsiteLink websiteLink; // Required

	public static Website fromDoc(org.w3c.dom.Element element)
	{
		final Website x = new Website();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(WebsiteRole.refname) || name.equals(WebsiteRole.shortname))
					x.websiteRole = WebsiteRole.fromDoc(element);
				else if (name.equals(WebsiteDescription.refname) || name.equals(WebsiteDescription.shortname))
					x.websiteDescriptions = DU.addToList(x.websiteDescriptions, WebsiteDescription.fromDoc(element));
				else if (name.equals(WebsiteLink.refname) || name.equals(WebsiteLink.shortname))
					x.websiteLink = WebsiteLink.fromDoc(element);
			}
		});

		return x;
	}

	public WebsiteRoles getWebsiteRoleValue()
	{
		return (websiteRole == null) ? null : websiteRole.value;
	}

	public String getWebsiteLinkValue()
	{
		return (websiteLink == null) ? null : websiteLink.value;
	}
}
