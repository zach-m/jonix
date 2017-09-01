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

import com.tectonica.jonix.onix3.Product;

/**
 * ONIX3 concrete implementation for {@link BasicProduct}
 * 
 * @author Zach Melamed
 */
public class BasicProduct3 extends BasicProduct
{
	private static final long serialVersionUID = 1L;

	public BasicProduct3(Product product)
	{
		onixProduct = product;
		info = new BasicInfo3(product);
		description = new BasicDescription3(product);
		publishingDetails = new BasicPublishingDetails3(product);
		titles = new BasicTitles3(product);
		contributors = new BasicContributors3(product);
		collections = new BasicCollections3(product);
		subjects = new BasicSubjects3(product);
		texts = new BasicTexts3(product);
		publishers = new BasicPublishers3(product);
		imprints = new BasicImprints3(product);
		supplyDetails = new BasicSupplyDetails3(product);
		salesRightss = new BasicSalesRightss3(product);
	}
}
