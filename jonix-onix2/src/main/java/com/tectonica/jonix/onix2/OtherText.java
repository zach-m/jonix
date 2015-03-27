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

package com.tectonica.jonix.onix2;

import java.io.Serializable;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TextLinkTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixOtherText;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class OtherText implements Serializable
{
	public static final String refname = "OtherText";
	public static final String shortname = "othertext";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
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

	public OtherText()
	{}

	public OtherText(org.w3c.dom.Element element)
	{
		this.textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		this.textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		this.language = LanguageCodeIso6392Bs.byValue(JPU.getAttribute(element, "language"));
		this.transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(TextTypeCode.refname) || name.equals(TextTypeCode.shortname))
					textTypeCode = new TextTypeCode(element);
				else if (name.equals(TextFormat.refname) || name.equals(TextFormat.shortname))
					textFormat = new TextFormat(element);
				else if (name.equals(Text.refname) || name.equals(Text.shortname))
					text = new Text(element);
				else if (name.equals(TextLinkType.refname) || name.equals(TextLinkType.shortname))
					textLinkType = new TextLinkType(element);
				else if (name.equals(TextLink.refname) || name.equals(TextLink.shortname))
					textLink = new TextLink(element);
				else if (name.equals(TextAuthor.refname) || name.equals(TextAuthor.shortname))
					textAuthor = new TextAuthor(element);
				else if (name.equals(TextSourceCorporate.refname) || name.equals(TextSourceCorporate.shortname))
					textSourceCorporate = new TextSourceCorporate(element);
				else if (name.equals(TextSourceTitle.refname) || name.equals(TextSourceTitle.shortname))
					textSourceTitle = new TextSourceTitle(element);
				else if (name.equals(TextPublicationDate.refname) || name.equals(TextPublicationDate.shortname))
					textPublicationDate = new TextPublicationDate(element);
				else if (name.equals(StartDate.refname) || name.equals(StartDate.shortname))
					startDate = new StartDate(element);
				else if (name.equals(EndDate.refname) || name.equals(EndDate.shortname))
					endDate = new EndDate(element);
			}
		});
	}

	public OtherTextTypes getTextTypeCodeValue()
	{
		return (textTypeCode == null) ? null : textTypeCode.value;
	}

	public TextFormats getTextFormatValue()
	{
		return (textFormat == null) ? null : textFormat.value;
	}

	public String getTextValue()
	{
		return (text == null) ? null : text.value;
	}

	public TextLinkTypes getTextLinkTypeValue()
	{
		return (textLinkType == null) ? null : textLinkType.value;
	}

	public String getTextLinkValue()
	{
		return (textLink == null) ? null : textLink.value;
	}

	public String getTextAuthorValue()
	{
		return (textAuthor == null) ? null : textAuthor.value;
	}

	public String getTextSourceCorporateValue()
	{
		return (textSourceCorporate == null) ? null : textSourceCorporate.value;
	}

	public String getTextSourceTitleValue()
	{
		return (textSourceTitle == null) ? null : textSourceTitle.value;
	}

	public String getTextPublicationDateValue()
	{
		return (textPublicationDate == null) ? null : textPublicationDate.value;
	}

	public String getStartDateValue()
	{
		return (startDate == null) ? null : startDate.value;
	}

	public String getEndDateValue()
	{
		return (endDate == null) ? null : endDate.value;
	}

	public JonixOtherText asStruct()
	{
		JonixOtherText x = new JonixOtherText();
		x.textFormat = getTextFormatValue();
		x.text = getTextValue();
		x.textLinkType = getTextLinkTypeValue();
		x.textLink = getTextLinkValue();
		x.textAuthor = getTextAuthorValue();
		x.textSourceCorporate = getTextSourceCorporateValue();
		x.textSourceTitle = getTextSourceTitleValue();
		x.textPublicationDate = getTextPublicationDateValue();
		x.startDate = getStartDateValue();
		x.endDate = getEndDateValue();
		return x;
	}
}
