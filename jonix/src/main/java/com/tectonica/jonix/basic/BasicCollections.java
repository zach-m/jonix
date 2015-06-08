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

/**
 * A {@link List} containing the multiple instances of ONIX2 &lt;Series&gt; / ONIX3 &lt;Collection&gt; that may exist in
 * an ONIX product
 * 
 * @author Zach Melamed
 */
public class BasicCollections extends ArrayList<BasicCollection>
{
	private static final long serialVersionUID = 1L;

	public BasicCollections(com.tectonica.jonix.onix2.Product product)
	{
		if (product.seriess != null)
		{
			for (com.tectonica.jonix.onix2.Series series : product.seriess)
				add(new BasicCollection(series));
		}
	}

	public BasicCollections(com.tectonica.jonix.onix3.Product product)
	{
		if (product.descriptiveDetail != null && product.descriptiveDetail.collections != null)
		{
			for (com.tectonica.jonix.onix3.Collection collection : product.descriptiveDetail.collections)
				add(new BasicCollection(collection));
		}
	}
}
