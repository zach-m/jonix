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
import java.util.Set;

import com.tectonica.jonix.JonixUtil;
import com.tectonica.jonix.codelist.ContributorRoles;

/**
 * Contains the essential information included in ONIX &lt;Contributor&gt;
 * <p>
 * NOTE: to access the information, use the public fields directly. No getters() are included..
 * 
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BasicContributor implements Serializable
{
	public Set<ContributorRoles> contributorRoles;
	public String sequenceNumber;
	public String personName;
	public String personNameKey;
	public String personNameBeforeKey;
	public String personNameInverted;
	public String corporateName;
	public String biographicalNote;

	public String getDisplayName()
	{
		return JonixUtil.contributorDisplayName(personName, personNameKey, personNameBeforeKey, personNameInverted,
				corporateName);
	}

	public String[] getNameParts()
	{
		if (personNameInverted != null)
		{
			String[] splits = personNameInverted.split(",");
			String[] names = new String[splits.length];
			for (int i = 0; i < splits.length; i++)
				names[i] = splits[splits.length - 1 - i].trim();
			return names;
		}

		if (personName != null)
		{
			String[] names = personName.split(" ");
			for (int i = 0; i < names.length; i++)
				names[i] = names[i].trim();
			return names;
		}

		return new String[0];
	}

}