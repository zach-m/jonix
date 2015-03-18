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

import com.tectonica.jonix.onix2.DU;
import com.tectonica.jonix.onix2.codelist.List138;
import com.tectonica.jonix.onix2.codelist.List14;
import com.tectonica.jonix.onix2.codelist.List3;
import com.tectonica.jonix.onix2.codelist.List34;
import com.tectonica.jonix.onix2.codelist.List74;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class OtherText
{
	public static final String refname = "OtherText";
	public static final String shortname = "othertext";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public TextTypeCode textTypeCode; // Required
	public TextFormat textFormat; // Optional
	public Text text; // Optional
	public TextLinkType textLinkType; // Required
	public TextLink textLink; // Required
	public TextAuthor textAuthor; // Optional
	public TextSourceCorporate textSourceCorporate; // Optional
	public TextSourceTitle textSourceTitle; // Optional
	public TextPublicationDate textPublicationDate; // Optional
	public StartDate startDate; // Optional
	public EndDate endDate; // Optional

	public static OtherText fromDoc(org.w3c.dom.Element element)
	{
		final OtherText x = new OtherText();

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
				if (name.equals(TextTypeCode.refname) || name.equals(TextTypeCode.shortname))
					x.textTypeCode = TextTypeCode.fromDoc(element);
				else if (name.equals(TextFormat.refname) || name.equals(TextFormat.shortname))
					x.textFormat = TextFormat.fromDoc(element);
				else if (name.equals(Text.refname) || name.equals(Text.shortname))
					x.text = Text.fromDoc(element);
				else if (name.equals(TextLinkType.refname) || name.equals(TextLinkType.shortname))
					x.textLinkType = TextLinkType.fromDoc(element);
				else if (name.equals(TextLink.refname) || name.equals(TextLink.shortname))
					x.textLink = TextLink.fromDoc(element);
				else if (name.equals(TextAuthor.refname) || name.equals(TextAuthor.shortname))
					x.textAuthor = TextAuthor.fromDoc(element);
				else if (name.equals(TextSourceCorporate.refname) || name.equals(TextSourceCorporate.shortname))
					x.textSourceCorporate = TextSourceCorporate.fromDoc(element);
				else if (name.equals(TextSourceTitle.refname) || name.equals(TextSourceTitle.shortname))
					x.textSourceTitle = TextSourceTitle.fromDoc(element);
				else if (name.equals(TextPublicationDate.refname) || name.equals(TextPublicationDate.shortname))
					x.textPublicationDate = TextPublicationDate.fromDoc(element);
				else if (name.equals(StartDate.refname) || name.equals(StartDate.shortname))
					x.startDate = StartDate.fromDoc(element);
				else if (name.equals(EndDate.refname) || name.equals(EndDate.shortname))
					x.endDate = EndDate.fromDoc(element);
			}
		});

		return x;
	}
}
