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
import com.tectonica.jonix.codelist.TitleTypeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class TitleDetail
{
	public static final String refname = "TitleDetail";
	public static final String shortname = "titledetail";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public TitleType titleType; // Required
	public List<TitleElement> titleElements; // OneOrMore
	public TitleStatement titleStatement; // Optional

	public static TitleDetail fromDoc(org.w3c.dom.Element element)
	{
		final TitleDetail x = new TitleDetail();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(TitleType.refname) || name.equals(TitleType.shortname))
					x.titleType = TitleType.fromDoc(element);
				else if (name.equals(TitleElement.refname) || name.equals(TitleElement.shortname))
					x.titleElements = DU.addToList(x.titleElements, TitleElement.fromDoc(element));
				else if (name.equals(TitleStatement.refname) || name.equals(TitleStatement.shortname))
					x.titleStatement = TitleStatement.fromDoc(element);
			}
		});

		return x;
	}

	public TitleTypeCodes getTitleTypeValue()
	{
		return (titleType == null) ? null : titleType.value;
	}

	public String getTitleStatementValue()
	{
		return (titleStatement == null) ? null : titleStatement.value;
	}
}
