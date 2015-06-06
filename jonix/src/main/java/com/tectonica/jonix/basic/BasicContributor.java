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
import java.util.HashSet;
import java.util.Set;

import com.tectonica.jonix.codelist.ContributorRoles;

@SuppressWarnings("serial")
public class BasicContributor implements Serializable
{
	public final Set<ContributorRoles> contributorRoles;
	public final String displayName;
	public final String personName;
	public final String personNameKey;
	public final String personNameBeforeKey;
	public final String corporateName;
	public final String biographicalNote;

	public BasicContributor(com.tectonica.jonix.onix2.Contributor c)
	{
		contributorRoles = new HashSet<>(c.getContributorRoleValues());
		personName = c.getPersonNameValue();
		personNameKey = c.getKeyNamesValue();
		personNameBeforeKey = c.getNamesBeforeKeyValue();
		corporateName = c.getCorporateNameValue();
		biographicalNote = c.getBiographicalNoteValue();
		displayName = phraseDisplayName();
	}

	public BasicContributor(com.tectonica.jonix.onix3.Contributor c)
	{
		contributorRoles = new HashSet<>(c.getContributorRoleValues());
		personName = c.getPersonNameValue();
		personNameKey = c.getKeyNamesValue();
		personNameBeforeKey = c.getNamesBeforeKeyValue();
		corporateName = c.getCorporateNameValue();
		biographicalNote = BasicPicker.pickBiographicalNote(c);
		displayName = phraseDisplayName();
	}

	private String phraseDisplayName()
	{
		if (personName != null)
			return personName;

		if (personNameKey != null)
		{
			if (personNameBeforeKey != null)
				return personNameBeforeKey + " " + personNameKey;
			return personNameKey;
		}

		if (personNameBeforeKey != null)
			return personNameBeforeKey;

		return corporateName;
	}
}