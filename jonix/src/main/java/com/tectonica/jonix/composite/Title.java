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

import com.tectonica.jonix.codelist.TitleTypes;

@SuppressWarnings("serial")
public class Title implements Serializable
{
	public final TitleTypes titleType;
	public final String titleText;
	public final String titleWithoutPrefix;
	public final String subtitle;

	public Title(TitleTypes titleType, String titleText, String titleWithoutPrefix, String subtitle)
	{
		this.titleType = titleType;
		this.titleText = titleText;
		this.titleWithoutPrefix = titleWithoutPrefix;
		this.subtitle = subtitle;
	}

	@Override
	public String toString()
	{
		String titleTypeStr = (titleType == null) ? null : titleType.name();
		String titleTestStr = titleText + ((titleWithoutPrefix != null) ? "*" : "");
		String subtitleStr = subtitle == null ? "" : ": " + subtitle;
		return String.format("Title [%s]: %s%s", titleTypeStr, titleTestStr, subtitleStr);
	}

	public static List<Title> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		return listFrom(product.titles);
	}

	public static List<Title> listFrom(com.tectonica.jonix.onix2.Series series)
	{
		return listFrom(series.titles);
	}

	private static List<Title> listFrom(final List<com.tectonica.jonix.onix2.Title> titles)
	{
		if (titles != null)
		{
			List<Title> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.Title i : titles)
				result.add(new Title(i.getTitleTypeValue(), noBreaks(i.getTitleTextValue()), noBreaks(i.getTitleWithoutPrefixValue()),
						noBreaks(i.getSubtitleValue())));
			return result;
		}
		return Collections.emptyList();
	}

	public static String noBreaks(String s)
	{
		return (s == null || s.isEmpty()) ? s : s.replaceAll("\\t|\\n|\\r", " ");
	}
}