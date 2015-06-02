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
import java.util.List;

import com.tectonica.jonix.struct.JonixCollectionIdentifier;
import com.tectonica.jonix.struct.JonixSeriesIdentifier;

@SuppressWarnings("serial")
public class Series implements Serializable
{
	public final String mainTitle;
	public final List<JonixCollectionIdentifier> seriesIdentifiers;
	public final List<Title> titles;
	public final List<Contributor> contributors;

	public Series(String mainTitle, List<JonixCollectionIdentifier> seriesIdentifiers, List<Title> titles,
			List<Contributor> contributors)
	{
		this.mainTitle = mainTitle;
		this.seriesIdentifiers = seriesIdentifiers;
		this.titles = titles;
		this.contributors = contributors;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (JonixCollectionIdentifier seriesIdentifier : seriesIdentifiers)
			sb.append("\n    ").append(String.format("(%d) %d", seriesIdentifier.idTypeName, seriesIdentifier.idValue));
		for (Title title : titles)
			sb.append("\n    ").append(title.toString());
		for (Contributor contributor : contributors)
			sb.append("\n    ").append(contributor.toString());
		return String.format("Series: %s %s", mainTitle, sb.toString());
	}

	public static List<Series> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.seriess != null)
		{
			List<Series> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.Series c : product.seriess)
			{
				List<Title> titles = Title.listFrom(c);
				String title = c.getTitleOfSeriesValue();
				if (title == null)
					title = titles.get(0).titleText;
				result.add(new Series(title, sidsToCids(c.findSeriesIdentifiers(null)), titles, Contributor.listFrom(c)));
			}
			return result;
		}
		return Collections.emptyList();
	}

	private static List<JonixCollectionIdentifier> sidsToCids(List<JonixSeriesIdentifier> sids)
	{
		if (sids == null)
			return null;

		List<JonixCollectionIdentifier> result = new ArrayList<>();
		for (JonixSeriesIdentifier sid : sids)
		{
			JonixCollectionIdentifier cid = new JonixCollectionIdentifier();
			cid.collectionIDType = sid.seriesIDType;
			cid.idTypeName = sid.idTypeName;
			cid.idValue = sid.idValue;
			result.add(cid);
		}
		return result;
	}

	public static List<Series> listFrom(com.tectonica.jonix.onix3.Product product)
	{
		if (product.descriptiveDetail.collections != null)
		{
			List<Series> result = new ArrayList<>();
			for (com.tectonica.jonix.onix3.Collection c : product.descriptiveDetail.collections)
			{
				List<Title> titles = Title.listFrom(c);
				String title = titles.get(0).titleText;
				result.add(new Series(title, c.findCollectionIdentifiers(null), titles, Contributor.listFrom(c)));
			}
			return result;
		}
		return Collections.emptyList();
	}
}