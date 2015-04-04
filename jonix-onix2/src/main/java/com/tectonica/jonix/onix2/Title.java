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
import com.tectonica.jonix.OnixComposite;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixTitle;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Title implements OnixComposite, Serializable
{
	public static final String refname = "Title";
	public static final String shortname = "title";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public TitleType titleType; // Required
	public AbbreviatedLength abbreviatedLength; // Optional
	public TextCaseFlag textCaseFlag; // Optional
	public TitleText titleText; // Required
	public TitlePrefix titlePrefix; // Optional
	public TitleWithoutPrefix titleWithoutPrefix; // Optional
	public Subtitle subtitle; // Optional

	public Title()
	{}

	public Title(org.w3c.dom.Element element)
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
				if (name.equals(TitleType.refname) || name.equals(TitleType.shortname))
					titleType = new TitleType(element);
				else if (name.equals(AbbreviatedLength.refname) || name.equals(AbbreviatedLength.shortname))
					abbreviatedLength = new AbbreviatedLength(element);
				else if (name.equals(TextCaseFlag.refname) || name.equals(TextCaseFlag.shortname))
					textCaseFlag = new TextCaseFlag(element);
				else if (name.equals(TitleText.refname) || name.equals(TitleText.shortname))
					titleText = new TitleText(element);
				else if (name.equals(TitlePrefix.refname) || name.equals(TitlePrefix.shortname))
					titlePrefix = new TitlePrefix(element);
				else if (name.equals(TitleWithoutPrefix.refname) || name.equals(TitleWithoutPrefix.shortname))
					titleWithoutPrefix = new TitleWithoutPrefix(element);
				else if (name.equals(Subtitle.refname) || name.equals(Subtitle.shortname))
					subtitle = new Subtitle(element);
			}
		});
	}

	public TitleTypes getTitleTypeValue()
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

	public JonixTitle asJonixTitle()
	{
		JonixTitle x = new JonixTitle();
		x.abbreviatedLength = getAbbreviatedLengthValue();
		x.textCaseFlag = getTextCaseFlagValue();
		x.titleText = getTitleTextValue();
		x.titlePrefix = getTitlePrefixValue();
		x.titleWithoutPrefix = getTitleWithoutPrefixValue();
		x.subtitle = getSubtitleValue();
		return x;
	}
}
