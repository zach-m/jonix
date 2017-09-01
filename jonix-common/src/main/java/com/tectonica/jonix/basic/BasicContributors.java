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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import com.tectonica.jonix.codelist.ContributorRoles;

/**
 * A {@link List} containing the multiple instances of ONIX &lt;Contributor&gt; that may exist in an ONIX product or an
 * ONIX collection (series)
 * 
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BasicContributors extends LazyList<BasicContributor>
{
	public static void sortBySequence(List<BasicContributor> contributors)
	{
		// run a quick test to see if the list is at all sequenced. If it is, then this loop should really stop after
		// one iteration. The only reason to run a loop (rather than examining the first item) is that we want to
		// support a hybrid, ill-posed sequencing, where only SOME of the items are sequenced
		boolean isSequenced = false;
		for (BasicContributor contributor : contributors)
		{
			if (contributor.sequenceNumber != null)
			{
				isSequenced = true;
				break;
			}
		}

		if (!isSequenced)
			return;

		Collections.sort(contributors, new Comparator<BasicContributor>()
		{
			@Override
			public int compare(BasicContributor o1, BasicContributor o2)
			{
				return Integer.compare(toInt(o1.sequenceNumber), toInt(o2.sequenceNumber));
			}

			private int toInt(String s1)
			{
				try
				{
					return Integer.parseInt(s1);
				}
				catch (NumberFormatException nfe)
				{
					return Integer.MAX_VALUE; // i.e. un-sequenced or ill-sequenced items go to the end of the list
				}
			}
		});
	}

	public List<BasicContributor> findByRole(ContributorRoles... requestedRoles)
	{
		List<BasicContributor> result = new ArrayList<>();

		if (requestedRoles == null || requestedRoles.length == 0)
		{
			// if no filtering by role is required, we take all contributors and avoid unnecessary search
			// copying is needed so that consequent sorting won't affect the original
			result = new ArrayList<>(this);
		}
		else
		{
			// we perform a search according to the roles filter
			HashSet<ContributorRoles> rolesSet = new HashSet<>(Arrays.asList(requestedRoles));
			for (BasicContributor contributor : this)
			{
				for (ContributorRoles role : contributor.contributorRoles)
				{
					if (rolesSet.contains(role))
						result.add(contributor);
				}
			}
		}

		return result;
	}

	public List<String> getDisplayNames(ContributorRoles... requestedRoles)
	{
		List<String> result = new ArrayList<>();
		for (BasicContributor c : findByRole(requestedRoles))
			result.add(c.getDisplayName());
		return result;
	}
}
