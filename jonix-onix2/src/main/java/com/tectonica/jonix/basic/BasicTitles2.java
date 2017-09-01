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

import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.onix2.Series;
import com.tectonica.jonix.onix2.Title;

/**
 * ONIX2 concrete implementation for {@link BasicTitles}
 * 
 * @author Zach Melamed
 */
public class BasicTitles2 extends BasicTitles
{
	private static final long serialVersionUID = 1L;

	private transient final List<Title> titles;

	public BasicTitles2(Product product)
	{
		titles = product.titles();
	}

	public BasicTitles2(Series series)
	{
		titles = series.titles();
	}

	@Override
	protected List<BasicTitle> initialize()
	{
		List<BasicTitle> list = new ArrayList<>();
		for (Title title : titles)
			list.add(new BasicTitle2(title));
		return list;
	}
}
