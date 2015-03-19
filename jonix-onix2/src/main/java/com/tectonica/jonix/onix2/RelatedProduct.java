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

package com.tectonica.jonix.onix2;

import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.BookFormDetails;
import com.tectonica.jonix.codelist.EpublicationFormats;
import com.tectonica.jonix.codelist.EpublicationTypes;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.ProductContentTypes;
import com.tectonica.jonix.codelist.ProductFormDetails;
import com.tectonica.jonix.codelist.ProductForms;
import com.tectonica.jonix.codelist.ProductPackagingTypes;
import com.tectonica.jonix.codelist.ProductRelations;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TradeCategorys;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class RelatedProduct
{
	public static final String refname = "RelatedProduct";
	public static final String shortname = "relatedproduct";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public RelationCode relationCode; // Required
	public ISBN isbn; // Required
	public EAN13 ean13; // Optional
	public List<ProductIdentifier> productIdentifiers; // ZeroOrMore
	public List<Website> websites; // ZeroOrMore
	public ProductForm productForm; // Optional
	public List<ProductFormDetail> productFormDetails; // ZeroOrMore
	public List<ProductFormFeature> productFormFeatures; // ZeroOrMore
	public List<BookFormDetail> bookFormDetails; // ZeroOrMore
	public ProductPackaging productPackaging; // Optional
	public ProductFormDescription productFormDescription; // Optional
	public NumberOfPieces numberOfPieces; // Optional
	public TradeCategory tradeCategory; // Optional
	public List<ProductContentType> productContentTypes; // ZeroOrMore
	public EpubType epubType; // Optional
	public EpubTypeVersion epubTypeVersion; // Optional
	public EpubTypeDescription epubTypeDescription; // Optional
	public EpubFormat epubFormat; // Optional
	public EpubFormatVersion epubFormatVersion; // Optional
	public EpubFormatDescription epubFormatDescription; // Optional
	public EpubTypeNote epubTypeNote; // Optional
	public List<Publisher> publishers; // ZeroOrMore

	public static RelatedProduct fromDoc(org.w3c.dom.Element element)
	{
		final RelatedProduct x = new RelatedProduct();

		x.textformat = TextFormats.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(RelationCode.refname) || name.equals(RelationCode.shortname))
					x.relationCode = RelationCode.fromDoc(element);
				else if (name.equals(ISBN.refname) || name.equals(ISBN.shortname))
					x.isbn = ISBN.fromDoc(element);
				else if (name.equals(EAN13.refname) || name.equals(EAN13.shortname))
					x.ean13 = EAN13.fromDoc(element);
				else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					x.productIdentifiers = DU.addToList(x.productIdentifiers, ProductIdentifier.fromDoc(element));
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
				else if (name.equals(ProductForm.refname) || name.equals(ProductForm.shortname))
					x.productForm = ProductForm.fromDoc(element);
				else if (name.equals(ProductFormDetail.refname) || name.equals(ProductFormDetail.shortname))
					x.productFormDetails = DU.addToList(x.productFormDetails, ProductFormDetail.fromDoc(element));
				else if (name.equals(ProductFormFeature.refname) || name.equals(ProductFormFeature.shortname))
					x.productFormFeatures = DU.addToList(x.productFormFeatures, ProductFormFeature.fromDoc(element));
				else if (name.equals(BookFormDetail.refname) || name.equals(BookFormDetail.shortname))
					x.bookFormDetails = DU.addToList(x.bookFormDetails, BookFormDetail.fromDoc(element));
				else if (name.equals(ProductPackaging.refname) || name.equals(ProductPackaging.shortname))
					x.productPackaging = ProductPackaging.fromDoc(element);
				else if (name.equals(ProductFormDescription.refname) || name.equals(ProductFormDescription.shortname))
					x.productFormDescription = ProductFormDescription.fromDoc(element);
				else if (name.equals(NumberOfPieces.refname) || name.equals(NumberOfPieces.shortname))
					x.numberOfPieces = NumberOfPieces.fromDoc(element);
				else if (name.equals(TradeCategory.refname) || name.equals(TradeCategory.shortname))
					x.tradeCategory = TradeCategory.fromDoc(element);
				else if (name.equals(ProductContentType.refname) || name.equals(ProductContentType.shortname))
					x.productContentTypes = DU.addToList(x.productContentTypes, ProductContentType.fromDoc(element));
				else if (name.equals(EpubType.refname) || name.equals(EpubType.shortname))
					x.epubType = EpubType.fromDoc(element);
				else if (name.equals(EpubTypeVersion.refname) || name.equals(EpubTypeVersion.shortname))
					x.epubTypeVersion = EpubTypeVersion.fromDoc(element);
				else if (name.equals(EpubTypeDescription.refname) || name.equals(EpubTypeDescription.shortname))
					x.epubTypeDescription = EpubTypeDescription.fromDoc(element);
				else if (name.equals(EpubFormat.refname) || name.equals(EpubFormat.shortname))
					x.epubFormat = EpubFormat.fromDoc(element);
				else if (name.equals(EpubFormatVersion.refname) || name.equals(EpubFormatVersion.shortname))
					x.epubFormatVersion = EpubFormatVersion.fromDoc(element);
				else if (name.equals(EpubFormatDescription.refname) || name.equals(EpubFormatDescription.shortname))
					x.epubFormatDescription = EpubFormatDescription.fromDoc(element);
				else if (name.equals(EpubTypeNote.refname) || name.equals(EpubTypeNote.shortname))
					x.epubTypeNote = EpubTypeNote.fromDoc(element);
				else if (name.equals(Publisher.refname) || name.equals(Publisher.shortname))
					x.publishers = DU.addToList(x.publishers, Publisher.fromDoc(element));
			}
		});

		return x;
	}

	public ProductRelations getRelationCodeValue()
	{
		return (relationCode == null) ? null : relationCode.value;
	}

	public String getISBNValue()
	{
		return (isbn == null) ? null : isbn.value;
	}

	public String getEAN13Value()
	{
		return (ean13 == null) ? null : ean13.value;
	}

	public ProductForms getProductFormValue()
	{
		return (productForm == null) ? null : productForm.value;
	}

	public List<ProductFormDetails> getProductFormDetailValues()
	{
		if (productFormDetails != null)
		{
			List<ProductFormDetails> list = new ArrayList<>();
			for (ProductFormDetail i : productFormDetails)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<BookFormDetails> getBookFormDetailValues()
	{
		if (bookFormDetails != null)
		{
			List<BookFormDetails> list = new ArrayList<>();
			for (BookFormDetail i : bookFormDetails)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public ProductPackagingTypes getProductPackagingValue()
	{
		return (productPackaging == null) ? null : productPackaging.value;
	}

	public String getProductFormDescriptionValue()
	{
		return (productFormDescription == null) ? null : productFormDescription.value;
	}

	public String getNumberOfPiecesValue()
	{
		return (numberOfPieces == null) ? null : numberOfPieces.value;
	}

	public TradeCategorys getTradeCategoryValue()
	{
		return (tradeCategory == null) ? null : tradeCategory.value;
	}

	public List<ProductContentTypes> getProductContentTypeValues()
	{
		if (productContentTypes != null)
		{
			List<ProductContentTypes> list = new ArrayList<>();
			for (ProductContentType i : productContentTypes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public EpublicationTypes getEpubTypeValue()
	{
		return (epubType == null) ? null : epubType.value;
	}

	public String getEpubTypeVersionValue()
	{
		return (epubTypeVersion == null) ? null : epubTypeVersion.value;
	}

	public String getEpubTypeDescriptionValue()
	{
		return (epubTypeDescription == null) ? null : epubTypeDescription.value;
	}

	public EpublicationFormats getEpubFormatValue()
	{
		return (epubFormat == null) ? null : epubFormat.value;
	}

	public String getEpubFormatVersionValue()
	{
		return (epubFormatVersion == null) ? null : epubFormatVersion.value;
	}

	public String getEpubFormatDescriptionValue()
	{
		return (epubFormatDescription == null) ? null : epubFormatDescription.value;
	}

	public String getEpubTypeNoteValue()
	{
		return (epubTypeNote == null) ? null : epubTypeNote.value;
	}
}
