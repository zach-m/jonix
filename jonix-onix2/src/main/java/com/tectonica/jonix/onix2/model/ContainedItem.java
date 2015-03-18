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

package com.tectonica.jonix.onix2.model;

import java.util.List;

import com.tectonica.jonix.onix2.DU;
import com.tectonica.jonix.onix2.codelist.List138;
import com.tectonica.jonix.onix2.codelist.List14;
import com.tectonica.jonix.onix2.codelist.List3;
import com.tectonica.jonix.onix2.codelist.List34;
import com.tectonica.jonix.onix2.codelist.List74;

public class ContainedItem
{
	public static final String refname = "ContainedItem";
	public static final String shortname = "containeditem";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public ISBN isbN; // Required
	public EAN13 ean13; // Optional
	public List<ProductIdentifier> productIdentifiers; // ZeroOrMore
	public ProductForm productForm; // Optional
	public List<ProductFormDetail> productFormDetails; // ZeroOrMore
	public List<ProductFormFeature> productFormFeatures; // ZeroOrMore
	public List<BookFormDetail> bookFormDetails; // ZeroOrMore
	public ProductPackaging productPackaging; // Optional
	public ProductFormDescription productFormDescription; // Optional
	public NumberOfPieces numberOfPieces; // Optional
	public TradeCategory tradeCategory; // Optional
	public List<ProductContentType> productContentTypes; // ZeroOrMore
	public ItemQuantity itemQuantity; // Optional

	public static ContainedItem fromDoc(org.w3c.dom.Element element)
	{
		final ContainedItem x = new ContainedItem();

		x.textformat = List34.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = List14.byValue(DU.getAttribute(element, "textcase"));
		x.language = List74.byValue(DU.getAttribute(element, "language"));
		x.transliteration = List138.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(ISBN.refname) || name.equalsIgnoreCase(ISBN.shortname))
					x.isbN = ISBN.fromDoc(element);
				else if (name.equalsIgnoreCase(EAN13.refname) || name.equalsIgnoreCase(EAN13.shortname))
					x.ean13 = EAN13.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductIdentifier.refname) || name.equalsIgnoreCase(ProductIdentifier.shortname))
					x.productIdentifiers = DU.addToList(x.productIdentifiers, ProductIdentifier.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductForm.refname) || name.equalsIgnoreCase(ProductForm.shortname))
					x.productForm = ProductForm.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductFormDetail.refname) || name.equalsIgnoreCase(ProductFormDetail.shortname))
					x.productFormDetails = DU.addToList(x.productFormDetails, ProductFormDetail.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductFormFeature.refname) || name.equalsIgnoreCase(ProductFormFeature.shortname))
					x.productFormFeatures = DU.addToList(x.productFormFeatures, ProductFormFeature.fromDoc(element));
				else if (name.equalsIgnoreCase(BookFormDetail.refname) || name.equalsIgnoreCase(BookFormDetail.shortname))
					x.bookFormDetails = DU.addToList(x.bookFormDetails, BookFormDetail.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductPackaging.refname) || name.equalsIgnoreCase(ProductPackaging.shortname))
					x.productPackaging = ProductPackaging.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductFormDescription.refname) || name.equalsIgnoreCase(ProductFormDescription.shortname))
					x.productFormDescription = ProductFormDescription.fromDoc(element);
				else if (name.equalsIgnoreCase(NumberOfPieces.refname) || name.equalsIgnoreCase(NumberOfPieces.shortname))
					x.numberOfPieces = NumberOfPieces.fromDoc(element);
				else if (name.equalsIgnoreCase(TradeCategory.refname) || name.equalsIgnoreCase(TradeCategory.shortname))
					x.tradeCategory = TradeCategory.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductContentType.refname) || name.equalsIgnoreCase(ProductContentType.shortname))
					x.productContentTypes = DU.addToList(x.productContentTypes, ProductContentType.fromDoc(element));
				else if (name.equalsIgnoreCase(ItemQuantity.refname) || name.equalsIgnoreCase(ItemQuantity.shortname))
					x.itemQuantity = ItemQuantity.fromDoc(element);
			}
		});

		return x;
	}
}
