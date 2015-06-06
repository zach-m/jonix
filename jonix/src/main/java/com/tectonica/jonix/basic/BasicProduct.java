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
	public final BasicInfo info;
	public final BasicDescription description;
	public final BasicPublishingDetails publishingDetails;

	public final BasicTitles titles;
	public final BasicContributors contributors;;
	public final BasicCollections collections;
	public final BasicSubjects subjects;
	public final BasicTexts texts;
	public final BasicPublishers publishers;
	public final BasicImprints imprints;
	public final BasicSupplyDetails supplyDetails;
	public final BasicSalesRightss salesRightss;

	private final Object productObject;

	public BasicProduct(com.tectonica.jonix.onix3.Product product)
	{
		productObject = product;
		info = new BasicInfo(product);
		description = new BasicDescription(product);
		publishingDetails = new BasicPublishingDetails(product);
		titles = new BasicTitles(product);
		contributors = new BasicContributors(product);
		collections = new BasicCollections(product);
		subjects = new BasicSubjects(product);
		texts = new BasicTexts(product);
		publishers = new BasicPublishers(product);
		imprints = new BasicImprints(product);
		supplyDetails = new BasicSupplyDetails(product);
		salesRightss = new BasicSalesRightss(product);
	}

	public BasicProduct(com.tectonica.jonix.onix2.Product product)
	{
		productObject = product;
		info = new BasicInfo(product);
		description = new BasicDescription(product);
		publishingDetails = new BasicPublishingDetails(product);
		titles = new BasicTitles(product);
		contributors = new BasicContributors(product);
		collections = new BasicCollections(product);
		subjects = new BasicSubjects(product);
		texts = new BasicTexts(product);
		publishers = new BasicPublishers(product);
		imprints = new BasicImprints(product);
		supplyDetails = new BasicSupplyDetails(product);
		salesRightss = new BasicSalesRightss(product);
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
