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
import java.util.List;

import com.tectonica.jonix.codelist.EditionTypes;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.struct.JonixAudience;
import com.tectonica.jonix.struct.JonixLanguage;

/**
 * Bundles together some descriptive information included in an ONIX product
 * <p>
 * NOTE: to access the information, use the public fields directly. No getters() are included..
 * 
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BasicDescription implements Serializable
{
	public EditionTypes editionType;
	public Integer editionNumber;
	public String productForm;
	public String numberOfPages;
	public List<JonixLanguage> languages;
	public List<JonixAudience> audiences;

	public JonixLanguage findLanguage(LanguageRoles requestedType)
	{
		if (languages != null)
		{
			for (JonixLanguage lang : languages)
			{
				if (lang.languageRole == requestedType)
					return lang;
			}
		}
		return null;
	}
}
