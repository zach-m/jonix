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

package com.tectonica.jonix.onix3.model;

import java.util.List;

import com.tectonica.jonix.onix3.DU;
import com.tectonica.jonix.onix3.codelist.List3;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Subject
{
	public static final String refname = "Subject";
	public static final String shortname = "subject";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public MainSubject mainSubject; // Optional
	public SubjectSchemeIdentifier subjectSchemeIdentifier; // Required
	public SubjectSchemeName subjectSchemeName; // Optional
	public SubjectSchemeVersion subjectSchemeVersion; // Optional
	public SubjectCode subjectCode; // Required
	public List<SubjectHeadingText> subjectHeadingTexts; // ZeroOrMore

	public static Subject fromDoc(org.w3c.dom.Element element)
	{
		final Subject x = new Subject();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(MainSubject.refname) || name.equals(MainSubject.shortname))
					x.mainSubject = MainSubject.fromDoc(element);
				else if (name.equals(SubjectSchemeIdentifier.refname) || name.equals(SubjectSchemeIdentifier.shortname))
					x.subjectSchemeIdentifier = SubjectSchemeIdentifier.fromDoc(element);
				else if (name.equals(SubjectSchemeName.refname) || name.equals(SubjectSchemeName.shortname))
					x.subjectSchemeName = SubjectSchemeName.fromDoc(element);
				else if (name.equals(SubjectSchemeVersion.refname) || name.equals(SubjectSchemeVersion.shortname))
					x.subjectSchemeVersion = SubjectSchemeVersion.fromDoc(element);
				else if (name.equals(SubjectCode.refname) || name.equals(SubjectCode.shortname))
					x.subjectCode = SubjectCode.fromDoc(element);
				else if (name.equals(SubjectHeadingText.refname) || name.equals(SubjectHeadingText.shortname))
					x.subjectHeadingTexts = DU.addToList(x.subjectHeadingTexts, SubjectHeadingText.fromDoc(element));
			}
		});

		return x;
	}
}
