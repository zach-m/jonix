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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tectonica.jonix.codelist.ContributorRoles;

@SuppressWarnings("serial")
public class Contributor implements Serializable
{
	public final Set<ContributorRoles> contributorRoles;
	public final String personName;
	public final String personNameKey;
	public final String personNameBeforeKey;
	public final String corporateName;
	public final String biographicalNote;

	public Contributor(Set<ContributorRoles> contributorRoles, String personName, String personNameKey, String personNameBeforeKey,
			String corporateName, String biographicalNote)
	{
		this.contributorRoles = contributorRoles;
		this.personName = personName;
		this.personNameKey = personNameKey;
		this.personNameBeforeKey = personNameBeforeKey;
		this.corporateName = corporateName;
		this.biographicalNote = biographicalNote;
	}

	public String displayName()
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

	@Override
	public String toString()
	{
		String contributorRoleStr = (contributorRoles == null) ? null : contributorRoles.toString();
		String biographicalNoteStr = biographicalNote == null ? "" : " (" + biographicalNote + ")";
		return String.format("Contributor [%s]: %s%s", contributorRoleStr, personName, biographicalNoteStr);
	}

	public static List<Contributor> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		return listFrom(product.contributors);
	}

	public static List<Contributor> listFrom(com.tectonica.jonix.onix2.Series series)
	{
		return listFrom(series.contributors);
	}

	private static List<Contributor> listFrom(final List<com.tectonica.jonix.onix2.Contributor> contributors)
	{
		if (contributors != null)
		{
			List<Contributor> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.Contributor i : contributors)
				result.add(new Contributor(new HashSet<>(i.getContributorRoleValues()), i.getPersonNameValue(), i.getKeyNamesValue(), i
						.getNamesBeforeKeyValue(), i.getCorporateNameValue(), i.getBiographicalNoteValue()));
			return result;
		}
		return Collections.emptyList();
	}
}