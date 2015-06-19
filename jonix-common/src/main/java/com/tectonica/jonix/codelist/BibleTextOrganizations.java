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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList86
 * <p>
 * Bible text organization
 * 
 * @see <a href="http://www.editeur.org/14/code-lists/">http://www.editeur.org/14/code-lists/</a>
 */
public enum BibleTextOrganizations
{
	/**
	 * A Bible with the text organized in the order in which events are believed to have happened.
	 */
	Chronological("CHR"), //

	/**
	 * A Bible which explores keywords or themes by referring text to preceding or following text.
	 */
	Chain_reference("CHA"), //

	/**
	 * A Bible or other text in which different versions are printed one line above the other, so that the variations can easily be
	 * detected.
	 */
	Interlinear("INT"), //

	/**
	 * A Bible with two or more versions printed side by side.
	 */
	Parallel("PAR"), //

	/**
	 * A Bible in which the text is presented in the traditional order.
	 */
	Standard("STN");

	public final String value;

	private BibleTextOrganizations(String value)
	{
		this.value = value;
	}

	public static BibleTextOrganizations byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (BibleTextOrganizations e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
