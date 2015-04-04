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
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.PublishingRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Publisher implements OnixComposite, Serializable
{
	public static final String refname = "Publisher";
	public static final String shortname = "publisher";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public PublishingRole publishingRole; // Optional
	public PublisherName publisherName; // Optional
	public NameCodeType nameCodeType; // Required
	public NameCodeTypeName nameCodeTypeName; // Optional
	public NameCodeValue nameCodeValue; // Required
	public List<Website> websites; // ZeroOrMore

	public Publisher()
	{}

	public Publisher(org.w3c.dom.Element element)
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
				if (name.equals(PublishingRole.refname) || name.equals(PublishingRole.shortname))
					publishingRole = new PublishingRole(element);
				else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname))
					publisherName = new PublisherName(element);
				else if (name.equals(NameCodeType.refname) || name.equals(NameCodeType.shortname))
					nameCodeType = new NameCodeType(element);
				else if (name.equals(NameCodeTypeName.refname) || name.equals(NameCodeTypeName.shortname))
					nameCodeTypeName = new NameCodeTypeName(element);
				else if (name.equals(NameCodeValue.refname) || name.equals(NameCodeValue.shortname))
					nameCodeValue = new NameCodeValue(element);
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					websites = JPU.addToList(websites, new Website(element));
			}
		});
	}

	public PublishingRoles getPublishingRoleValue()
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
