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

import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.LanguageRoles;

@SuppressWarnings("serial")
public class Language implements Serializable
{
	public final LanguageRoles languageRole;
	public final LanguageCodeIso6392Bs languageCode;

	public Language(LanguageRoles languageRole, LanguageCodeIso6392Bs languageCode)
	{
		this.languageRole = languageRole;
		this.languageCode = languageCode;
	}

	@Override
	public String toString()
	{
		return String.format("Language [%s]: %s", (languageRole == null) ? null : languageRole.name(), languageCode);
	}

	public static List<Language> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.languages != null)
		{
			List<Language> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.Language i : product.languages)
				result.add(new Language(i.getLanguageRoleValue(), i.getLanguageCodeValue()));
			return result;
		}
		return Collections.emptyList();
	}
}