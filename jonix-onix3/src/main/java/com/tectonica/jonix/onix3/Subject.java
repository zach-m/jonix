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
import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SubjectSchemeIdentifiers;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Subject implements JonixComposite, Serializable
{
	public static final String refname = "Subject";
	public static final String shortname = "subject";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public MainSubject mainSubject; // Optional
	public SubjectSchemeIdentifier subjectSchemeIdentifier; // Required
	public SubjectSchemeName subjectSchemeName; // Optional
	public SubjectSchemeVersion subjectSchemeVersion; // Optional
	public SubjectCode subjectCode; // Required
	public List<SubjectHeadingText> subjectHeadingTexts; // ZeroOrMore

	public Subject()
	{}

	public Subject(org.w3c.dom.Element element)
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
				if (name.equals(MainSubject.refname) || name.equals(MainSubject.shortname))
					mainSubject = new MainSubject(element);
				else if (name.equals(SubjectSchemeIdentifier.refname) || name.equals(SubjectSchemeIdentifier.shortname))
					subjectSchemeIdentifier = new SubjectSchemeIdentifier(element);
				else if (name.equals(SubjectSchemeName.refname) || name.equals(SubjectSchemeName.shortname))
					subjectSchemeName = new SubjectSchemeName(element);
				else if (name.equals(SubjectSchemeVersion.refname) || name.equals(SubjectSchemeVersion.shortname))
					subjectSchemeVersion = new SubjectSchemeVersion(element);
				else if (name.equals(SubjectCode.refname) || name.equals(SubjectCode.shortname))
					subjectCode = new SubjectCode(element);
				else if (name.equals(SubjectHeadingText.refname) || name.equals(SubjectHeadingText.shortname))
					subjectHeadingTexts = JPU.addToList(subjectHeadingTexts, new SubjectHeadingText(element));
			}
		});
	}

	public SubjectSchemeIdentifiers getSubjectSchemeIdentifierValue()
	{
		return (subjectSchemeIdentifier == null) ? null : subjectSchemeIdentifier.value;
	}

	public String getSubjectSchemeNameValue()
	{
		return (subjectSchemeName == null) ? null : subjectSchemeName.value;
	}

	public String getSubjectSchemeVersionValue()
	{
		return (subjectSchemeVersion == null) ? null : subjectSchemeVersion.value;
	}

	public String getSubjectCodeValue()
	{
		return (subjectCode == null) ? null : subjectCode.value;
	}

	public List<String> getSubjectHeadingTextValues()
	{
		if (subjectHeadingTexts != null)
		{
			List<String> list = new ArrayList<>();
			for (SubjectHeadingText i : subjectHeadingTexts)
				list.add(i.value);
			return list;
		}
		return null;
	}
}
