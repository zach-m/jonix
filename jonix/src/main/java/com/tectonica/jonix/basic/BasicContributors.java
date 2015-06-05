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
import java.util.List;

import com.tectonica.jonix.codelist.ContributorRoles;

@SuppressWarnings("serial")
public class BasicContributors extends ArrayList<BasicContributor>
{
	public List<BasicContributor> extractFrom(com.tectonica.jonix.onix2.Product product)
	{
		return extractFrom2(product.contributors);
	}

	public List<BasicContributor> extractFrom(com.tectonica.jonix.onix2.Series series)
	{
		return extractFrom2(series.contributors);
	}

	public List<BasicContributor> extractFrom(com.tectonica.jonix.onix3.Product product)
	{
		return extractFrom3(product.descriptiveDetail.contributors);
	}

	public List<BasicContributor> extractFrom(com.tectonica.jonix.onix3.Collection collection)
	{
		return extractFrom3(collection.contributors);
	}

	private List<BasicContributor> extractFrom2(final List<com.tectonica.jonix.onix2.Contributor> contributors)
	{
		clear();
		if (contributors != null)
		{
			for (com.tectonica.jonix.onix2.Contributor c : contributors)
				add(new BasicContributor().extractFrom(c));
		}
		return this;
	}

	private List<BasicContributor> extractFrom3(final List<com.tectonica.jonix.onix3.Contributor> contributors)
	{
		clear();
		if (contributors != null)
		{
			for (com.tectonica.jonix.onix3.Contributor c : contributors)
				add(new BasicContributor().extractFrom(c));
		}
		return this;
	}

	public List<BasicContributor> findContributors(ContributorRoles requestedType)
	{
		List<BasicContributor> matches = new ArrayList<BasicContributor>();
		for (BasicContributor contributor : this)
		{
			if (contributor.contributorRoles.contains(requestedType))
				matches.add(contributor);
		}
		return matches;
	}
}
