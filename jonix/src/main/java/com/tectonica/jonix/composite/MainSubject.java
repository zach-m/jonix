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
import java.util.Collections;
import java.util.List;

import com.tectonica.jonix.codelist.MainSubjectSchemeIdentifiers;

@SuppressWarnings("serial")
public class MainSubject implements Serializable
{
	public final MainSubjectSchemeIdentifiers mainSubjectSchemeIdentifier;
	public final String subjectCode;
	public final String subjectHeadingText;

	public MainSubject(MainSubjectSchemeIdentifiers mainSubjectSchemeIdentifier, String subjectCode, String subjectHeadingText)
	{
		this.mainSubjectSchemeIdentifier = mainSubjectSchemeIdentifier;
		this.subjectCode = subjectCode;
		this.subjectHeadingText = subjectHeadingText;
	}

	@Override
	public String toString()
	{
		String subjectSchemeIdentifierStr = (mainSubjectSchemeIdentifier == null) ? null : mainSubjectSchemeIdentifier.name();
		return String.format(getClass().getSimpleName() + " [%s]: %s | %s", subjectSchemeIdentifierStr, subjectCode, subjectHeadingText);
	}

	public static List<MainSubject> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.mainSubjects != null)
		{
			List<MainSubject> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.MainSubject i : product.mainSubjects)
				result.add(new MainSubject(i.getMainSubjectSchemeIdentifierValue(), i.getSubjectCodeValue(), i.getSubjectHeadingTextValue()));
			return result;
		}
		return Collections.emptyList();
	}
}