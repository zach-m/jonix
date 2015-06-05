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
public class BasicPublishers extends ArrayList<BasicPublisher>
{
	public List<BasicPublisher> extractFrom(com.tectonica.jonix.onix2.Product product)
	{
		clear();
		if (product.publishers != null)
		{
			for (com.tectonica.jonix.onix2.Publisher i : product.publishers)
				add(new BasicPublisher().extractFrom(i));
		}
		return this;
	}

	public List<BasicPublisher> extractFrom(com.tectonica.jonix.onix3.Product product)
	{
		clear();
		if (product.publishingDetail.publishers != null)
		{
			for (com.tectonica.jonix.onix3.Publisher i : product.publishingDetail.publishers)
				add(new BasicPublisher().extractFrom(i));
		}
		return this;
	}
}
