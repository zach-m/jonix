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

import com.tectonica.jonix.onix2.Product;

/**
 * ONIX2 concrete implementation for {@link BasicProduct}
 * 
 * @author Zach Melamed
 */
public class BasicProduct2 extends BasicProduct
{
	private static final long serialVersionUID = 1L;

	public BasicProduct2(Product product)
	{
		onixProduct = product;
		info = new BasicInfo2(product);
		description = new BasicDescription2(product);
		publishingDetails = new BasicPublishingDetails2(product);
		titles = new BasicTitles2(product);
		contributors = new BasicContributors2(product);
		collections = new BasicCollections2(product);
		subjects = new BasicSubjects2(product);
		texts = new BasicTexts2(product);
		publishers = new BasicPublishers2(product);
		imprints = new BasicImprints2(product);
		supplyDetails = new BasicSupplyDetails2(product);
		salesRightss = new BasicSalesRightss2(product);
	}
}
