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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Reissue
{
	public static final String refname = "Reissue";
	public static final String shortname = "reissue";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public ReissueDate reissueDate; // Required
	public ReissueDescription reissueDescription; // Optional
	public List<Price> prices; // ZeroOrMore
	public List<MediaFile> mediaFiles; // ZeroOrMore

	public static Reissue fromDoc(org.w3c.dom.Element element)
	{
		final Reissue x = new Reissue();

		x.textformat = TextFormats.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ReissueDate.refname) || name.equals(ReissueDate.shortname))
					x.reissueDate = ReissueDate.fromDoc(element);
				else if (name.equals(ReissueDescription.refname) || name.equals(ReissueDescription.shortname))
					x.reissueDescription = ReissueDescription.fromDoc(element);
				else if (name.equals(Price.refname) || name.equals(Price.shortname))
					x.prices = DU.addToList(x.prices, Price.fromDoc(element));
				else if (name.equals(MediaFile.refname) || name.equals(MediaFile.shortname))
					x.mediaFiles = DU.addToList(x.mediaFiles, MediaFile.fromDoc(element));
			}
		});

		return x;
	}

	public String getReissueDateValue()
	{
		return (reissueDate == null) ? null : reissueDate.value;
	}

	public String getReissueDescriptionValue()
	{
		return (reissueDescription == null) ? null : reissueDescription.value;
	}
}
