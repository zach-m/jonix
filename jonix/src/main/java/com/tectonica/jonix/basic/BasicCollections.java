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

@SuppressWarnings("serial")
public class BasicCollections extends ArrayList<BasicCollection>
{
	public List<BasicCollection> extractFrom(com.tectonica.jonix.onix2.Product product)
	{
		clear();
		if (product.seriess != null)
		{
			for (com.tectonica.jonix.onix2.Series c : product.seriess)
				add(new BasicCollection().extractFrom(c));
		}
		return this;
	}

	public List<BasicCollection> extractFrom(com.tectonica.jonix.onix3.Product product)
	{
		clear();
		if (product.descriptiveDetail.collections != null)
		{
			for (com.tectonica.jonix.onix3.Collection c : product.descriptiveDetail.collections)
				add(new BasicCollection().extractFrom(c));
		}
		return this;
	}
}
