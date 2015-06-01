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

@SuppressWarnings("serial")
public class Series implements Serializable
{
	public final String titleOfSeries;
	public final String seriesISSN;
	public final List<SeriesIdentifier> seriesIdentifiers;
	public final List<Title> titles;
	public final List<Contributor> contributors;

	public Series(String titleOfSeries, String seriesISSN, List<SeriesIdentifier> seriesIdentifiers,
			List<Title> titles, List<Contributor> contributors)
	{
		this.titleOfSeries = titleOfSeries;
		this.seriesISSN = seriesISSN;
		this.seriesIdentifiers = seriesIdentifiers;
		this.titles = titles;
		this.contributors = contributors;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (SeriesIdentifier seriesIdentifier : seriesIdentifiers)
			sb.append("\n    ").append(seriesIdentifier.toString());
		for (Title title : titles)
			sb.append("\n    ").append(title.toString());
		for (Contributor contributor : contributors)
			sb.append("\n    ").append(contributor.toString());
		return String.format("Series: %s (%s) %s", titleOfSeries, seriesISSN, sb.toString());
	}

	public static List<Series> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.seriess != null)
		{
			List<Series> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.Series i : product.seriess)
				result.add(new Series(i.getTitleOfSeriesValue(), i.getSeriesISSNValue(), SeriesIdentifier.listFrom(i),
						Title.listFrom(i), Contributor.listFrom(i)));
			return result;
		}
		return Collections.emptyList();
	}

	public static List<Series> listFrom(com.tectonica.jonix.onix3.Product product)
	{
		if (product.descriptiveDetail.collections != null)
		{
			List<Series> result = new ArrayList<>();
			for (com.tectonica.jonix.onix3.Collection i : product.descriptiveDetail.collections)
			{
				result.add(new Series(i.getTitleOfSeriesValue(), i.getSeriesISSNValue(), SeriesIdentifier.listFrom(i),
						Title.listFrom(i), Contributor.listFrom(i)));
			}
			return result;
		}
		return Collections.emptyList();
	}
}