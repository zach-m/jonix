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

package com.tectonica.jonix.composite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tectonica.jonix.basic.Onix3Util;
import com.tectonica.jonix.codelist.SubjectSchemeIdentifiers;

@SuppressWarnings("serial")
public class Subject implements Serializable
{
	public final SubjectSchemeIdentifiers subjectSchemeIdentifier;
	public final String subjectCode;
	public final String subjectHeadingText;

	public Subject(SubjectSchemeIdentifiers subjectSchemeIdentifier, String subjectCode, String subjectHeadingText)
	{
		this.subjectSchemeIdentifier = subjectSchemeIdentifier;
		this.subjectCode = subjectCode;
		this.subjectHeadingText = subjectHeadingText;
	}

	@Override
	public String toString()
	{
		String subjectSchemeIdentifierStr = (subjectSchemeIdentifier == null) ? null : subjectSchemeIdentifier.name();
		return String.format(getClass().getSimpleName() + " [%s]: %s | %s", subjectSchemeIdentifierStr, subjectCode,
				subjectHeadingText);
	}

	private static void add(Map<SubjectSchemeIdentifiers, List<Subject>> map, SubjectSchemeIdentifiers type,
			String subjectCode, String subjectHeadingText)
	{
		add(map, type, subjectCode, subjectHeadingText, false);
	}

	private static void add(Map<SubjectSchemeIdentifiers, List<Subject>> map, SubjectSchemeIdentifiers type,
			String subjectCode, String subjectHeadingText, boolean isMain)
	{
		List<Subject> subjects = map.get(type);
		if (subjects == null)
			map.put(type, subjects = new ArrayList<Subject>());
		Subject subject = new Subject(type, subjectCode, subjectHeadingText);
		if (isMain)
			subjects.add(0, subject);
		else
			subjects.add(subject);
	}

	public static Map<SubjectSchemeIdentifiers, List<Subject>> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		Map<SubjectSchemeIdentifiers, List<Subject>> map = new HashMap<>();

		String bisacMainSubject = product.getBASICMainSubjectValue();
		if (bisacMainSubject != null)
			add(map, SubjectSchemeIdentifiers.BISAC_Subject_Heading, bisacMainSubject, null);

		String bicMainSubject = product.getBICMainSubjectValue();
		if (bicMainSubject != null)
			add(map, SubjectSchemeIdentifiers.BIC_subject_category, bicMainSubject, null);

		if (product.subjects != null)
		{
			for (com.tectonica.jonix.onix2.Subject s : product.subjects)
				add(map, s.getSubjectSchemeIdentifierValue(), s.getSubjectCodeValue(), s.getSubjectHeadingTextValue());
		}
		return map;
	}

	public static Map<SubjectSchemeIdentifiers, List<Subject>> listFrom(com.tectonica.jonix.onix3.Product product)
	{
		Map<SubjectSchemeIdentifiers, List<Subject>> map = new HashMap<>();
		if (product.descriptiveDetail.subjects != null)
		{
			for (com.tectonica.jonix.onix3.Subject s : product.descriptiveDetail.subjects)
			{
				add(map, s.getSubjectSchemeIdentifierValue(), s.getSubjectCodeValue(),
						Onix3Util.pickSubjectHeadingText(s), s.isMainSubject());
			}
		}
		return map;
	}
}