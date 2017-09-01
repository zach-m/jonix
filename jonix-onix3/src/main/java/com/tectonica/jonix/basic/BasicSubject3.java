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

import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.onix3.Subject;
import com.tectonica.jonix.onix3.SubjectHeadingText;

/**
 * ONIX3 concrete implementation for {@link BasicSubject}
 * 
 * @author Zach Melamed
 */
public class BasicSubject3 extends BasicSubject
{
	private static final long serialVersionUID = 1L;

	public BasicSubject3(SubjectSchemeIdentifiers subjectSchemeIdentifier, String subjectCode,
			String subjectHeadingText)
	{
		super(subjectSchemeIdentifier, subjectCode, subjectHeadingText);
	}

	public BasicSubject3(Subject s)
	{
		subjectSchemeIdentifier = s.subjectSchemeIdentifier().value;
		subjectCode = s.subjectCode().value;
		subjectHeadingText = pickSubjectHeadingText(s);
	}

	private String pickSubjectHeadingText(Subject subject)
	{
		if (!subject.subjectHeadingTexts().isEmpty())
		{
			for (SubjectHeadingText sht : subject.subjectHeadingTexts())
			{
				if (sht.language == null || sht.language == LanguageCodes.English)
					return sht.value;
			}
			return subject.subjectHeadingTexts().get(0).value; // return whatever language we have
		}
		return null;
	}
}