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

import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.onix3.TitleElement;

@SuppressWarnings("serial")
public class BasicTitle implements Serializable
{
	public final TitleTypes titleType;
	public final String titleText;
	public final String titleWithoutPrefix;
	public final String subtitle;

	public BasicTitle(TitleTypes titleType, String titleText, String titleWithoutPrefix, String subtitle)
	{
		this.titleType = titleType;
		this.titleText = noBreaks(titleText);
		this.titleWithoutPrefix = noBreaks(titleWithoutPrefix);
		this.subtitle = noBreaks(subtitle);
	}

	private static String noBreaks(String s)
	{
		return (s == null || s.isEmpty()) ? s : s.replaceAll("\\t|\\n|\\r", " ");
	}

	@Override
	public String toString()
	{
		String titleTypeStr = (titleType == null) ? null : titleType.name();
		String titleTestStr = titleText + ((titleWithoutPrefix != null) ? "*" : "");
		String subtitleStr = subtitle == null ? "" : ": " + subtitle;
		return String.format("Title [%s]: %s%s", titleTypeStr, titleTestStr, subtitleStr);
	}

	public static List<BasicTitle> extractFrom(com.tectonica.jonix.onix2.Product product)
	{
		return extractFrom2(product.titles);
	}

	public static List<BasicTitle> extractFrom(com.tectonica.jonix.onix2.Series series)
	{
		return extractFrom2(series.titles);
	}

	private static List<BasicTitle> extractFrom2(final List<com.tectonica.jonix.onix2.Title> titles)
	{
		if (titles != null)
		{
			List<BasicTitle> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.Title title : titles)
				result.add(new BasicTitle(title.getTitleTypeValue(), title.getTitleTextValue(), title.getTitleWithoutPrefixValue(),
						title.getSubtitleValue()));
			return result;
		}
		return Collections.emptyList();
	}

	public static List<BasicTitle> extractFrom(com.tectonica.jonix.onix3.Product product)
	{
		return extractFrom3(product.descriptiveDetail.titleDetails);
	}

	public static List<BasicTitle> extractFrom(com.tectonica.jonix.onix3.Collection collection)
	{
		return extractFrom3(collection.titleDetails);
	}

	private static List<BasicTitle> extractFrom3(final List<com.tectonica.jonix.onix3.TitleDetail> titles)
	{
		if (titles != null)
		{
			List<BasicTitle> result = new ArrayList<>();
			for (com.tectonica.jonix.onix3.TitleDetail title : titles)
			{
				TitleElement titleElement = title.titleElements.get(0); // at least 1 is mandatory
				result.add(new BasicTitle(title.getTitleTypeValue(), titleElement.getTitleTextValue(), titleElement
						.getTitleWithoutPrefixValue(), titleElement.getSubtitleValue()));
			}
			return result;
		}
		return Collections.emptyList();
	}
}