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

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.DateFormats;
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class MarketDate
{
	public static final String refname = "MarketDate";
	public static final String shortname = "marketdate";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public MarketDateRole marketDateRole; // Required
	public DateFormat dateFormat; // Optional
	public Date date; // Required

	public static MarketDate fromDoc(org.w3c.dom.Element element)
	{
		final MarketDate x = new MarketDate();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(MarketDateRole.refname) || name.equals(MarketDateRole.shortname))
					x.marketDateRole = MarketDateRole.fromDoc(element);
				else if (name.equals(DateFormat.refname) || name.equals(DateFormat.shortname))
					x.dateFormat = DateFormat.fromDoc(element);
				else if (name.equals(Date.refname) || name.equals(Date.shortname))
					x.date = Date.fromDoc(element);
			}
		});

		return x;
	}

	public PublishingDateRoles getMarketDateRoleValue()
	{
		return (marketDateRole == null) ? null : marketDateRole.value;
	}

	public DateFormats getDateFormatValue()
	{
		return (dateFormat == null) ? null : dateFormat.value;
	}

	public String getDateValue()
	{
		return (date == null) ? null : date.value;
	}
}
