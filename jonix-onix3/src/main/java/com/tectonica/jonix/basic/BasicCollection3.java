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

import java.util.List;

import com.tectonica.jonix.basic.BasicCollection;
import com.tectonica.jonix.basic.LazyList;
import com.tectonica.jonix.onix3.Collection;
import com.tectonica.jonix.struct.JonixCollectionIdentifier;

/**
 * ONIX3 concrete implementation for {@link BasicCollection}
 * 
 * @author Zach Melamed
 */
public class BasicCollection3 extends BasicCollection
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("serial")
	public BasicCollection3(final Collection c)
	{
		titles = new BasicTitles3(c);
		mainTitle = titles.get(0).titleText;
		seriesIdentifiers = new LazyList<JonixCollectionIdentifier>()
		{
			@Override
			protected List<JonixCollectionIdentifier> initialize()
			{
				return c.findCollectionIdentifiers(null);
			}
		};
		contributors = new BasicContributors3(c);
	}
}