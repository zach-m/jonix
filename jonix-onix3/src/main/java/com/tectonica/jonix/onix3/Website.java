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
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.WebsiteRoles;
import com.tectonica.jonix.struct.JonixWebsite;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Website implements OnixDataComposite, Serializable
{
	public static final String refname = "Website";
	public static final String shortname = "website";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public WebsiteRole websiteRole; // Optional
	public List<WebsiteDescription> websiteDescriptions; // ZeroOrMore
	public WebsiteLink websiteLink; // Required

	public Website()
	{}

	public Website(org.w3c.dom.Element element)
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
				if (name.equals(WebsiteRole.refname) || name.equals(WebsiteRole.shortname))
					websiteRole = new WebsiteRole(element);
				else if (name.equals(WebsiteDescription.refname) || name.equals(WebsiteDescription.shortname))
					websiteDescriptions = JPU.addToList(websiteDescriptions, new WebsiteDescription(element));
				else if (name.equals(WebsiteLink.refname) || name.equals(WebsiteLink.shortname))
					websiteLink = new WebsiteLink(element);
			}
		});
	}

	public WebsiteRoles getWebsiteRoleValue()
	{
		return (websiteRole == null) ? null : websiteRole.value;
	}

	public List<String> getWebsiteDescriptionValues()
	{
		if (websiteDescriptions != null)
		{
			List<String> list = new ArrayList<>();
			for (WebsiteDescription i : websiteDescriptions)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public String getWebsiteLinkValue()
	{
		return (websiteLink == null) ? null : websiteLink.value;
	}

	public JonixWebsite asJonixWebsite()
	{
		JonixWebsite x = new JonixWebsite();
		x.websiteDescriptions = getWebsiteDescriptionValues();
		x.websiteLink = getWebsiteLinkValue();
		x.websiteRole = getWebsiteRoleValue();
		return x;
	}
}
