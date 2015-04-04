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
import com.tectonica.jonix.OnixComposite;
import com.tectonica.jonix.codelist.IllustrationAndOtherContentTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixAncillaryContent;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class AncillaryContent implements OnixComposite, Serializable
{
	public static final String refname = "AncillaryContent";
	public static final String shortname = "ancillarycontent";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public AncillaryContentType ancillaryContentType; // Required
	public List<AncillaryContentDescription> ancillaryContentDescriptions; // ZeroOrMore
	public Number number; // Optional

	public AncillaryContent()
	{}

	public AncillaryContent(org.w3c.dom.Element element)
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
				if (name.equals(AncillaryContentType.refname) || name.equals(AncillaryContentType.shortname))
					ancillaryContentType = new AncillaryContentType(element);
				else if (name.equals(AncillaryContentDescription.refname) || name.equals(AncillaryContentDescription.shortname))
					ancillaryContentDescriptions = JPU.addToList(ancillaryContentDescriptions, new AncillaryContentDescription(element));
				else if (name.equals(Number.refname) || name.equals(Number.shortname))
					number = new Number(element);
			}
		});
	}

	public IllustrationAndOtherContentTypes getAncillaryContentTypeValue()
	{
		return (ancillaryContentType == null) ? null : ancillaryContentType.value;
	}

	public List<String> getAncillaryContentDescriptionValues()
	{
		if (ancillaryContentDescriptions != null)
		{
			List<String> list = new ArrayList<>();
			for (AncillaryContentDescription i : ancillaryContentDescriptions)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public Integer getNumberValue()
	{
		return (number == null) ? null : number.value;
	}

	public JonixAncillaryContent asJonixAncillaryContent()
	{
		JonixAncillaryContent x = new JonixAncillaryContent();
		x.ancillaryContentDescriptions = getAncillaryContentDescriptionValues();
		x.number = getNumberValue();
		return x;
	}
}
