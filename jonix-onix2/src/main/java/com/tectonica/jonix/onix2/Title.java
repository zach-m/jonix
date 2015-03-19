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

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormatCodes;
import com.tectonica.jonix.codelist.TitleTypeCodes;
import com.tectonica.jonix.codelist.TransliterationSchemeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Title
{
	public static final String refname = "Title";
	public static final String shortname = "title";

	public TextFormatCodes textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemeCodes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public TitleType titleType; // Required
	public AbbreviatedLength abbreviatedLength; // Optional
	public TextCaseFlag textCaseFlag; // Optional
	public TitleText titleText; // Required
	public TitlePrefix titlePrefix; // Optional
	public TitleWithoutPrefix titleWithoutPrefix; // Optional
	public Subtitle subtitle; // Optional

	public static Title fromDoc(org.w3c.dom.Element element)
	{
		final Title x = new Title();

		x.textformat = TextFormatCodes.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemeCodes.byValue(DU.getAttribute(element, "transliteration"));
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
				else if (name.equals(AbbreviatedLength.refname) || name.equals(AbbreviatedLength.shortname))
					x.abbreviatedLength = AbbreviatedLength.fromDoc(element);
				else if (name.equals(TextCaseFlag.refname) || name.equals(TextCaseFlag.shortname))
					x.textCaseFlag = TextCaseFlag.fromDoc(element);
				else if (name.equals(TitleText.refname) || name.equals(TitleText.shortname))
					x.titleText = TitleText.fromDoc(element);
				else if (name.equals(TitlePrefix.refname) || name.equals(TitlePrefix.shortname))
					x.titlePrefix = TitlePrefix.fromDoc(element);
				else if (name.equals(TitleWithoutPrefix.refname) || name.equals(TitleWithoutPrefix.shortname))
					x.titleWithoutPrefix = TitleWithoutPrefix.fromDoc(element);
				else if (name.equals(Subtitle.refname) || name.equals(Subtitle.shortname))
					x.subtitle = Subtitle.fromDoc(element);
			}
		});

		return x;
	}

	public TitleTypeCodes getTitleTypeValue()
	{
		return (titleType == null) ? null : titleType.value;
	}

	public String getAbbreviatedLengthValue()
	{
		return (abbreviatedLength == null) ? null : abbreviatedLength.value;
	}

	public TextCaseFlags getTextCaseFlagValue()
	{
		return (textCaseFlag == null) ? null : textCaseFlag.value;
	}

	public String getTitleTextValue()
	{
		return (titleText == null) ? null : titleText.value;
	}

	public String getTitlePrefixValue()
	{
		return (titlePrefix == null) ? null : titlePrefix.value;
	}

	public String getTitleWithoutPrefixValue()
	{
		return (titleWithoutPrefix == null) ? null : titleWithoutPrefix.value;
	}

	public String getSubtitleValue()
	{
		return (subtitle == null) ? null : subtitle.value;
	}
}
