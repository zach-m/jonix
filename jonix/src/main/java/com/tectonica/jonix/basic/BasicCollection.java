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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tectonica.jonix.struct.JonixCollectionIdentifier;
import com.tectonica.jonix.struct.JonixSeriesIdentifier;

@SuppressWarnings("serial")
public class BasicCollection implements Serializable
{
	public final String mainTitle;
	public final List<JonixCollectionIdentifier> seriesIdentifiers;
	public final List<BasicTitle> titles;
	public final List<BasicContributor> contributors;

	public BasicCollection(String mainTitle, List<JonixCollectionIdentifier> seriesIdentifiers, List<BasicTitle> titles,
			List<BasicContributor> contributors)
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
		for (BasicTitle title : titles)
			sb.append("\n    ").append(title.toString());
		for (BasicContributor contributor : contributors)
			sb.append("\n    ").append(contributor.toString());
		return String.format("Collection: %s %s", mainTitle, sb.toString());
	}

	public static List<BasicCollection> extractFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.seriess != null)
		{
			List<BasicCollection> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.Series c : product.seriess)
			{
				List<BasicTitle> titles = BasicTitle.extractFrom(c);
				String title = c.getTitleOfSeriesValue();
				if (title == null)
					title = titles.get(0).titleText;
				result.add(new BasicCollection(title, sidsToCids(c.findSeriesIdentifiers(null)), titles, BasicContributor.extractFrom(c)));
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

	public static List<BasicCollection> extractFrom(com.tectonica.jonix.onix3.Product product)
	{
		if (product.descriptiveDetail.collections != null)
		{
			List<BasicCollection> result = new ArrayList<>();
			for (com.tectonica.jonix.onix3.Collection c : product.descriptiveDetail.collections)
			{
				List<BasicTitle> titles = BasicTitle.extractFrom(c);
				String title = titles.get(0).titleText;
				result.add(new BasicCollection(title, c.findCollectionIdentifiers(null), titles, BasicContributor.extractFrom(c)));
			}
			return result;
		}
		return Collections.emptyList();
	}
}