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

import com.tectonica.jonix.onix3.TitleDetail;
import com.tectonica.jonix.onix3.TitleElement;

/**
 * ONIX3 concrete implementation for {@link BasicTitle}
 * 
 * @author Zach Melamed
 */
public class BasicTitle3 extends BasicTitle
{
	private static final long serialVersionUID = 1L;

	public BasicTitle3(TitleDetail title)
	{
		// TODO: check out the TitleElementLevel of the TitleElement, especially in collections
		TitleElement titleElement = title.titleElements().get(0); // at least 1 is mandatory
		titleType = title.titleType().value;
		titleText = noBreaks(titleElement.titleText().value);
		titleWithoutPrefix = noBreaks(titleElement.titleWithoutPrefix().value);
		subtitle = noBreaks(titleElement.subtitle().value);
	}
}