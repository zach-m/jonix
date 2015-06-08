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
import java.util.List;

import com.tectonica.jonix.struct.JonixCollectionIdentifier;
import com.tectonica.jonix.struct.JonixSeriesIdentifier;

/**
 * Contains the essential information included in ONIX2 &lt;Series&gt; / ONIX3 &lt;Collection&gt;
 * <p>
 * NOTE: to access the information, read the (public final) fields directly. No getters() are included..
 * <p>
 * May be constructed from either a {@link com.tectonica.jonix.onix2.Series} or a
 * {@link com.tectonica.jonix.onix3.Collection}.
 * 
 * @author Zach Melamed
 */
public class BasicCollection implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final String mainTitle;
	public final List<JonixCollectionIdentifier> seriesIdentifiers;
	public final BasicTitles titles;
	public final BasicContributors contributors;

	public BasicCollection(com.tectonica.jonix.onix2.Series c)
	{
		mainTitle = c.getTitleOfSeriesValue();
		seriesIdentifiers = sidsToCids(c.findSeriesIdentifiers(null));
		titles = new BasicTitles(c);
		contributors = new BasicContributors(c);
	}

	public BasicCollection(com.tectonica.jonix.onix3.Collection c)
	{
		titles = new BasicTitles(c);
		mainTitle = titles.get(0).titleText;
		seriesIdentifiers = c.findCollectionIdentifiers(null);
		contributors = new BasicContributors(c);
	}

	private List<JonixCollectionIdentifier> sidsToCids(List<JonixSeriesIdentifier> sids)
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