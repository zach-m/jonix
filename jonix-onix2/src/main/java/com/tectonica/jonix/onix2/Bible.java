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
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormatCodes;
import com.tectonica.jonix.codelist.TransliterationSchemeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Bible
{
	public static final String refname = "Bible";
	public static final String shortname = "bible";

	public TextFormatCodes textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemeCodes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public List<BibleContents> bibleContentss; // OneOrMore
	public List<BibleVersion> bibleVersions; // OneOrMore
	public StudyBibleType studyBibleType; // Optional
	public List<BiblePurpose> biblePurposes; // ZeroOrMore
	public BibleTextOrganization bibleTextOrganization; // Optional
	public BibleReferenceLocation bibleReferenceLocation; // Optional
	public List<BibleTextFeature> bibleTextFeatures; // ZeroOrMore

	public static Bible fromDoc(org.w3c.dom.Element element)
	{
		final Bible x = new Bible();

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
				if (name.equals(BibleContents.refname) || name.equals(BibleContents.shortname))
					x.bibleContentss = DU.addToList(x.bibleContentss, BibleContents.fromDoc(element));
				else if (name.equals(BibleVersion.refname) || name.equals(BibleVersion.shortname))
					x.bibleVersions = DU.addToList(x.bibleVersions, BibleVersion.fromDoc(element));
				else if (name.equals(StudyBibleType.refname) || name.equals(StudyBibleType.shortname))
					x.studyBibleType = StudyBibleType.fromDoc(element);
				else if (name.equals(BiblePurpose.refname) || name.equals(BiblePurpose.shortname))
					x.biblePurposes = DU.addToList(x.biblePurposes, BiblePurpose.fromDoc(element));
				else if (name.equals(BibleTextOrganization.refname) || name.equals(BibleTextOrganization.shortname))
					x.bibleTextOrganization = BibleTextOrganization.fromDoc(element);
				else if (name.equals(BibleReferenceLocation.refname) || name.equals(BibleReferenceLocation.shortname))
					x.bibleReferenceLocation = BibleReferenceLocation.fromDoc(element);
				else if (name.equals(BibleTextFeature.refname) || name.equals(BibleTextFeature.shortname))
					x.bibleTextFeatures = DU.addToList(x.bibleTextFeatures, BibleTextFeature.fromDoc(element));
			}
		});

		return x;
	}
}
