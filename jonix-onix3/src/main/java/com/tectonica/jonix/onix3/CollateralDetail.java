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
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class CollateralDetail implements OnixSuperComposite, Serializable
{
	public static final String refname = "CollateralDetail";
	public static final String shortname = "collateraldetail";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this list may be empty)
	 */
	public List<TextContent> textContents;

	/**
	 * (this list may be empty)
	 */
	public List<CitedContent> citedContents;

	/**
	 * (this list may be empty)
	 */
	public List<SupportingResource> supportingResources;

	/**
	 * (this list may be empty)
	 */
	public List<Prize> prizes;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public CollateralDetail()
	{}

	public CollateralDetail(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(TextContent.refname) || name.equals(TextContent.shortname))
					textContents = JPU.addToList(textContents, new TextContent(element));
				else if (name.equals(CitedContent.refname) || name.equals(CitedContent.shortname))
					citedContents = JPU.addToList(citedContents, new CitedContent(element));
				else if (name.equals(SupportingResource.refname) || name.equals(SupportingResource.shortname))
					supportingResources = JPU.addToList(supportingResources, new SupportingResource(element));
				else if (name.equals(Prize.refname) || name.equals(Prize.shortname))
					prizes = JPU.addToList(prizes, new Prize(element));
			}
		});
	}
}
