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

import com.tectonica.jonix.BasicColumn;
import com.tectonica.jonix.JonixColumn;

@SuppressWarnings("serial")
public class BasicProduct implements Serializable
{
	public BasicInfo info = new BasicInfo();
	public BasicDescription description = new BasicDescription();
	public BasicPublishingDetails publishingDetails = new BasicPublishingDetails();

	public BasicTitles titles = new BasicTitles();
	public BasicContributors contributors = new BasicContributors();
	public BasicCollections collections = new BasicCollections();
	public BasicSubjects subjects = new BasicSubjects();
	public BasicTexts texts = new BasicTexts();
	public BasicPublishers publishers = new BasicPublishers();
	public BasicImprints imprints = new BasicImprints();
	public BasicSupplyDetails supplyDetails = new BasicSupplyDetails();
	public BasicSalesRightss salesRightss = new BasicSalesRightss();

	private Object productObject;

	public BasicProduct extractFrom(com.tectonica.jonix.onix3.Product product)
	{
		productObject = product;
		info.extractFrom(product);
		description.extractFrom(product);
		publishingDetails.extractFrom(product);
		titles.extractFrom(product);
		contributors.extractFrom(product);
		collections.extractFrom(product);
		subjects.extractFrom(product);
		texts.extractFrom(product);
		publishers.extractFrom(product);
		imprints.extractFrom(product);
		supplyDetails.extractFrom(product);
		salesRightss.extractFrom(product);
		return this;
	}

	public BasicProduct extractFrom(com.tectonica.jonix.onix2.Product product)
	{
		productObject = product;
		info.extractFrom(product);
		description.extractFrom(product);
		publishingDetails.extractFrom(product);
		titles.extractFrom(product);
		contributors.extractFrom(product);
		collections.extractFrom(product);
		subjects.extractFrom(product);
		texts.extractFrom(product);
		publishers.extractFrom(product);
		imprints.extractFrom(product);
		supplyDetails.extractFrom(product);
		salesRightss.extractFrom(product);
		return this;
	}

	public Object getProductObject()
	{
		return productObject;
	}

	public String getLabel()
	{
		return (titles.size() > 0) ? titles.get(0).titleText : info.recordReference;
	}

	public static JonixColumn[] getDefaultColumns()
	{
		return BasicColumn.all;
	}

	public static JonixColumn getDefaultIdColumn()
	{
		return BasicColumn.ISBN13;
	}
}
