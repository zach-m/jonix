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

package com.tectonica.jonix.codelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 138</b>
 * <p>
 * Description: Transliteration scheme code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum TransliterationSchemes
{
	/**
	 * Transliteration of Cyrillic characters &#8211; Slavic languages
	 */
	Finnish_standard_SFS_4900("SFS4900"), //

	/**
	 * Transliteration and transcription of Greek characters
	 */
	Finnish_standard_SFS_5807("SFS5807"), //

	/**
	 * Transliteration of Arabic characters
	 */
	Finnish_standard_SFS_5755("SFS5755"), //

	/**
	 * Transliteration of Hebrew characters
	 */
	Finnish_standard_SFS_5824("SFS3602"), //

	/**
	 * Documentation &#8211; Romanization of Japanese (kana script)
	 */
	ISO_3602("ISO3602"), //

	/**
	 * Information and documentation &#8211; Romanization of Chinese
	 */
	ISO_7098("ISO7098");

	public final String value;

	private TransliterationSchemes(String value)
	{
		this.value = value;
	}

	public static TransliterationSchemes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (TransliterationSchemes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
