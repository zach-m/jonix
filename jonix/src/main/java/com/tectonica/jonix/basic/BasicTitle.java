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

import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.onix3.TitleElement;

/**
 * Contains the essential information included in ONIX2 &lt;Title&gt; / ONIX3 &lt;TitleDetail&gt;
 * <p>
 * NOTE: to access the information, read the (public final) fields directly. No getters() are included..
 * <p>
 * May be constructed from either a {@link com.tectonica.jonix.onix2.Title} or a
 * {@link com.tectonica.jonix.onix3.TitleDetail}.
 * 
 * @author Zach Melamed
 */
public class BasicTitle implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final TitleTypes titleType;
	public final String titleText;
	public final String titleWithoutPrefix;
	public final String subtitle;

	public BasicTitle(com.tectonica.jonix.onix2.Title title)
	{
		titleType = title.getTitleTypeValue();
		titleText = noBreaks(title.getTitleTextValue());
		titleWithoutPrefix = noBreaks(title.getTitleWithoutPrefixValue());
		subtitle = noBreaks(title.getSubtitleValue());
	}

	public BasicTitle(com.tectonica.jonix.onix3.TitleDetail title)
	{
		TitleElement titleElement = title.titleElements.get(0); // at least 1 is mandatory
		titleType = title.getTitleTypeValue();
		titleText = noBreaks(titleElement.getTitleTextValue());
		titleWithoutPrefix = noBreaks(titleElement.getTitleWithoutPrefixValue());
		subtitle = noBreaks(titleElement.getSubtitleValue());
	}

	private String noBreaks(String s)
	{
		return (s == null || s.isEmpty()) ? s : s.replaceAll("\\t|\\n|\\r", " ");
	}
}