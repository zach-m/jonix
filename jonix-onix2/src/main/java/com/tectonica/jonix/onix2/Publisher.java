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
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.PublishingRoleCodes;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormatCodes;
import com.tectonica.jonix.codelist.TransliterationSchemeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Publisher
{
	public static final String refname = "Publisher";
	public static final String shortname = "publisher";

	public TextFormatCodes textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemeCodes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public PublishingRole publishingRole; // Optional
	public PublisherName publisherName; // Optional
	public NameCodeType nameCodeType; // Required
	public NameCodeTypeName nameCodeTypeName; // Optional
	public NameCodeValue nameCodeValue; // Required
	public List<Website> websites; // ZeroOrMore

	public static Publisher fromDoc(org.w3c.dom.Element element)
	{
		final Publisher x = new Publisher();

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
				if (name.equals(PublishingRole.refname) || name.equals(PublishingRole.shortname))
					x.publishingRole = PublishingRole.fromDoc(element);
				else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname))
					x.publisherName = PublisherName.fromDoc(element);
				else if (name.equals(NameCodeType.refname) || name.equals(NameCodeType.shortname))
					x.nameCodeType = NameCodeType.fromDoc(element);
				else if (name.equals(NameCodeTypeName.refname) || name.equals(NameCodeTypeName.shortname))
					x.nameCodeTypeName = NameCodeTypeName.fromDoc(element);
				else if (name.equals(NameCodeValue.refname) || name.equals(NameCodeValue.shortname))
					x.nameCodeValue = NameCodeValue.fromDoc(element);
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
			}
		});

		return x;
	}

	public PublishingRoleCodes getPublishingRoleValue()
	{
		return (publishingRole == null) ? null : publishingRole.value;
	}

	public String getPublisherNameValue()
	{
		return (publisherName == null) ? null : publisherName.value;
	}

	public NameCodeTypes getNameCodeTypeValue()
	{
		return (nameCodeType == null) ? null : nameCodeType.value;
	}

	public String getNameCodeTypeNameValue()
	{
		return (nameCodeTypeName == null) ? null : nameCodeTypeName.value;
	}

	public String getNameCodeValueValue()
	{
		return (nameCodeValue == null) ? null : nameCodeValue.value;
	}
}
