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
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixTitle;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Title composite</h1>
 * <p>
 * A repeatable group of data elements which together give the text of a title of a content item and specify its type,
 * used here to give alternate forms of title for a content item. <strong>Please see Group&nbsp;PR.7 for
 * details.</strong>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Title&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;title&gt;</td>
 * </tr>
 * </table>
 */
public class Title implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Title";
	public static final String shortname = "title";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	public TextFormats textformat;

	public TextCaseFlags textcase;

	public LanguageCodes language;

	public TransliterationSchemes transliteration;

	/**
	 * (type: DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this field is required)
	 */
	public TitleType titleType;

	/**
	 * (this field is optional)
	 */
	public AbbreviatedLength abbreviatedLength;

	/**
	 * (this field is optional)
	 */
	public TextCaseFlag textCaseFlag;

	/**
	 * (this field is required)
	 */
	public TitleText titleText;

	/**
	 * (this field is optional)
	 */
	public TitlePrefix titlePrefix;

	/**
	 * (this field is optional)
	 */
	public TitleWithoutPrefix titleWithoutPrefix;

	/**
	 * (this field is optional)
	 */
	public Subtitle subtitle;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Title()
	{}

	public Title(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

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

	/**
	 * Format: Variable-length integer, suggested maximum 3 digits
	 */
	public String getAbbreviatedLengthValue()
	{
		return (abbreviatedLength == null) ? null : abbreviatedLength.value;
	}

	public TextCaseFlags getTextCaseFlagValue()
	{
		return (textCaseFlag == null) ? null : textCaseFlag.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum 300 characters
	 */
	public String getTitleTextValue()
	{
		return (titleText == null) ? null : titleText.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum length 20 characters
	 */
	public String getTitlePrefixValue()
	{
		return (titlePrefix == null) ? null : titlePrefix.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum length 300 characters
	 */
	public String getTitleWithoutPrefixValue()
	{
		return (titleWithoutPrefix == null) ? null : titleWithoutPrefix.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum 300 characters
	 */
	public String getSubtitleValue()
	{
		return (subtitle == null) ? null : subtitle.value;
	}

	public JonixTitle asJonixTitle()
	{
		JonixTitle x = new JonixTitle();
		x.titleType = getTitleTypeValue();
		x.abbreviatedLength = getAbbreviatedLengthValue();
		x.textCaseFlag = getTextCaseFlagValue();
		x.titleText = getTitleTextValue();
		x.titlePrefix = getTitlePrefixValue();
		x.titleWithoutPrefix = getTitleWithoutPrefixValue();
		x.subtitle = getSubtitleValue();
		return x;
	}
}
