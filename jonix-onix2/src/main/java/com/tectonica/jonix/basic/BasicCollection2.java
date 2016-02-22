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

import com.tectonica.jonix.basic.BasicCollection;
import com.tectonica.jonix.basic.LazyList;
import com.tectonica.jonix.onix2.Series;
import com.tectonica.jonix.struct.JonixCollectionIdentifier;
import com.tectonica.jonix.struct.JonixSeriesIdentifier;

/**
 * ONIX2 concrete implementation for {@link BasicCollection}
 * 
 * @author Zach Melamed
 */
public class BasicCollection2 extends BasicCollection
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("serial")
	public BasicCollection2(final Series c)
	{
		mainTitle = c.getTitleOfSeriesValue();
		seriesIdentifiers = new LazyList<JonixCollectionIdentifier>()
		{
			@Override
			protected List<JonixCollectionIdentifier> initialize()
			{
				return sidsToCids(c.findSeriesIdentifiers(null));
			}
		};
		titles = new BasicTitles2(c);
		contributors = new BasicContributors2(c);
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
}