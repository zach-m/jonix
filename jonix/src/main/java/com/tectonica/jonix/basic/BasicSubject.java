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

package com.tectonica.jonix.basic;

import java.io.Serializable;

import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.onix3.Subject;
import com.tectonica.jonix.onix3.SubjectHeadingText;

/**
 * Contains the essential information included in ONIX &lt;Subject&gt;
 * <p>
 * NOTE: to access the information, read the (public final) fields directly. No getters() are included..
 * <p>
 * May be constructed from either a {@link com.tectonica.jonix.onix2.Subject} or a
 * {@link com.tectonica.jonix.onix3.Subject}.
 * 
 * @author Zach Melamed
 */
public class BasicSubject implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final SubjectSchemeIdentifiers subjectSchemeIdentifier;
	public final String subjectCode;
	public final String subjectHeadingText;

	public BasicSubject(SubjectSchemeIdentifiers subjectSchemeIdentifier, String subjectCode, String subjectHeadingText)
	{
		this.subjectSchemeIdentifier = subjectSchemeIdentifier;
		this.subjectCode = subjectCode;
		this.subjectHeadingText = subjectHeadingText;
	}

	public BasicSubject(com.tectonica.jonix.onix2.Subject s)
	{
		subjectSchemeIdentifier = s.getSubjectSchemeIdentifierValue();
		subjectCode = s.getSubjectCodeValue();
		subjectHeadingText = s.getSubjectHeadingTextValue();
	}

	public BasicSubject(com.tectonica.jonix.onix3.Subject s)
	{
		subjectSchemeIdentifier = s.getSubjectSchemeIdentifierValue();
		subjectCode = s.getSubjectCodeValue();
		subjectHeadingText = pickSubjectHeadingText(s);
	}

	private String pickSubjectHeadingText(Subject subject)
	{
		if (subject.subjectHeadingTexts != null)
		{
			for (SubjectHeadingText sht : subject.subjectHeadingTexts)
			{
				if (sht.language == null || sht.language == LanguageCodes.English)
					return sht.value;
			}
			return subject.subjectHeadingTexts.get(0).value; // return whatever language we have
		}
		return null;
	}

}