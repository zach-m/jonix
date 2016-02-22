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

import com.tectonica.jonix.basic.BasicTitle;
import com.tectonica.jonix.basic.BasicTitles;
import com.tectonica.jonix.onix3.Collection;
import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.onix3.TitleDetail;

/**
 * ONIX3 concrete implementation for {@link BasicTitles}
 * 
 * @author Zach Melamed
 */
public class BasicTitles3 extends BasicTitles
{
	private static final long serialVersionUID = 1L;

	private transient final List<TitleDetail> titles;

	@Override
	protected List<BasicTitle> initialize()
	{
		List<BasicTitle> list = new ArrayList<>();
		if (titles != null)
		{
			for (TitleDetail title : titles)
				list.add(new BasicTitle3(title));
		}
		return list;
	}

	public BasicTitles3(Product product)
	{
		titles = (product.descriptiveDetail != null) ? product.descriptiveDetail.titleDetails : null;
	}

	public BasicTitles3(Collection collection)
	{
		titles = collection.titleDetails;
	}
}
