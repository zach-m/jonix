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

import com.tectonica.jonix.codelist.TitleTypes;

@SuppressWarnings("serial")
public class BasicTitles extends ArrayList<BasicTitle>
{
	public List<BasicTitle> extractFrom(com.tectonica.jonix.onix2.Product product)
	{
		return extractFrom2(product.titles);
	}

	public List<BasicTitle> extractFrom(com.tectonica.jonix.onix2.Series series)
	{
		return extractFrom2(series.titles);
	}

	public List<BasicTitle> extractFrom(com.tectonica.jonix.onix3.Product product)
	{
		return extractFrom3(product.descriptiveDetail.titleDetails);
	}

	public List<BasicTitle> extractFrom(com.tectonica.jonix.onix3.Collection collection)
	{
		return extractFrom3(collection.titleDetails);
	}

	private List<BasicTitle> extractFrom2(final List<com.tectonica.jonix.onix2.Title> titles)
	{
		clear();
		if (titles != null)
		{
			for (com.tectonica.jonix.onix2.Title title : titles)
				add(new BasicTitle().extractFrom(title));
		}
		return this;
	}

	private List<BasicTitle> extractFrom3(final List<com.tectonica.jonix.onix3.TitleDetail> titles)
	{
		clear();
		if (titles != null)
		{
			for (com.tectonica.jonix.onix3.TitleDetail title : titles)
				add(new BasicTitle().extractFrom(title));
		}
		return this;
	}

	public BasicTitle findTitle(TitleTypes requestedType)
	{
		for (BasicTitle title : this)
		{
			if (title.titleType == requestedType)
				return title;
		}
		return null;
	}
}
