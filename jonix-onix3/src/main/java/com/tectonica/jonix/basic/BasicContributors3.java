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

import com.tectonica.jonix.basic.BasicContributor;
import com.tectonica.jonix.basic.BasicContributors;
import com.tectonica.jonix.onix3.Contributor;
import com.tectonica.jonix.onix3.Product;

/**
 * ONIX3 concrete implementation for {@link BasicContributors}
 * 
 * @author Zach Melamed
 */
public class BasicContributors3 extends BasicContributors
{
	private static final long serialVersionUID = 1L;

	private transient final List<Contributor> contributors;

	@Override
	protected List<BasicContributor> initialize()
	{
		List<BasicContributor> list = new ArrayList<>();
		if (contributors != null)
		{
			for (Contributor contributor : contributors)
				list.add(new BasicContributor3(contributor));
		}
		return list;
	}

	public BasicContributors3(Product product)
	{
		contributors = (product.descriptiveDetail != null) ? product.descriptiveDetail.contributors : null;
	}

	public BasicContributors3(com.tectonica.jonix.onix3.Collection collection)
	{
		contributors = collection.contributors;
	}
}
