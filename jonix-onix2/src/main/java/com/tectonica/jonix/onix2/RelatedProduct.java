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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.BookFormDetails;
import com.tectonica.jonix.codelist.EpublicationFormats;
import com.tectonica.jonix.codelist.EpublicationTypes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.ProductContentTypes;
import com.tectonica.jonix.codelist.ProductFormDetails;
import com.tectonica.jonix.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.codelist.ProductForms;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.ProductPackagingTypes;
import com.tectonica.jonix.codelist.ProductRelations;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TradeCategorys;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixProductFormFeature;
import com.tectonica.jonix.struct.JonixProductIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Related product composite</h1>
 * <p>
 * A repeatable group of data elements which together describe a product which has a specified relationship to the
 * product which is described in the ONIX record. Although for reasons of upwards compatibility the composite includes
 * individual fields for ISBN and EAN-13 number, use of the nested &lt;ProductIdentifier&gt; composite is to be
 * preferred, since it allows any recognized identifier scheme (<em>eg</em> DOI) to be used.
 * </p>
 * <p>
 * The minimum required content of an occurrence of the &lt;RelatedProduct&gt; composite is a &lt;RelationCode&gt; and
 * either a product identifier or a &lt;ProductForm&gt; value. In other words, it is valid to list related products by
 * relationship and identifier only, or by relationship and form only.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;RelatedProduct&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;relatedproduct&gt;</td>
 * </tr>
 * </table>
 */
public class RelatedProduct implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "RelatedProduct";
	public static final String shortname = "relatedproduct";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	public TextFormats textformat;

	public TextCaseFlags textcase;

	public LanguageCodes language;

	public TransliterationSchemes transliteration;

	/**
	 * (type: DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this field is required)
	 */
	public RelationCode relationCode;

	/**
	 * (this field is required)
	 */
	public ISBN isbn;

	/**
	 * (this field is optional)
	 */
	public EAN13 ean13;

	/**
	 * (this list may be empty)
	 */
	public List<ProductIdentifier> productIdentifiers;

	/**
	 * (this list may be empty)
	 */
	public List<Website> websites;

	/**
	 * (this field is optional)
	 */
	public ProductForm productForm;

	/**
	 * (this list may be empty)
	 */
	public List<ProductFormDetail> productFormDetails;

	/**
	 * (this list may be empty)
	 */
	public List<ProductFormFeature> productFormFeatures;

	/**
	 * (this list may be empty)
	 */
	public List<BookFormDetail> bookFormDetails;

	/**
	 * (this field is optional)
	 */
	public ProductPackaging productPackaging;

	/**
	 * (this field is optional)
	 */
	public ProductFormDescription productFormDescription;

	/**
	 * (this field is optional)
	 */
	public NumberOfPieces numberOfPieces;

	/**
	 * (this field is optional)
	 */
	public TradeCategory tradeCategory;

	/**
	 * (this list may be empty)
	 */
	public List<ProductContentType> productContentTypes;

	/**
	 * (this field is optional)
	 */
	public EpubType epubType;

	/**
	 * (this field is optional)
	 */
	public EpubTypeVersion epubTypeVersion;

	/**
	 * (this field is optional)
	 */
	public EpubTypeDescription epubTypeDescription;

	/**
	 * (this field is optional)
	 */
	public EpubFormat epubFormat;

	/**
	 * (this field is optional)
	 */
	public EpubFormatVersion epubFormatVersion;

	/**
	 * (this field is optional)
	 */
	public EpubFormatDescription epubFormatDescription;

	/**
	 * (this field is optional)
	 */
	public EpubTypeNote epubTypeNote;

	/**
	 * (this list may be empty)
	 */
	public List<Publisher> publishers;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public RelatedProduct()
	{}

	public RelatedProduct(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(RelationCode.refname) || name.equals(RelationCode.shortname))
					relationCode = new RelationCode(element);
				else if (name.equals(ISBN.refname) || name.equals(ISBN.shortname))
					isbn = new ISBN(element);
				else if (name.equals(EAN13.refname) || name.equals(EAN13.shortname))
					ean13 = new EAN13(element);
				else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(element));
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					websites = JPU.addToList(websites, new Website(element));
				else if (name.equals(ProductForm.refname) || name.equals(ProductForm.shortname))
					productForm = new ProductForm(element);
				else if (name.equals(ProductFormDetail.refname) || name.equals(ProductFormDetail.shortname))
					productFormDetails = JPU.addToList(productFormDetails, new ProductFormDetail(element));
				else if (name.equals(ProductFormFeature.refname) || name.equals(ProductFormFeature.shortname))
					productFormFeatures = JPU.addToList(productFormFeatures, new ProductFormFeature(element));
				else if (name.equals(BookFormDetail.refname) || name.equals(BookFormDetail.shortname))
					bookFormDetails = JPU.addToList(bookFormDetails, new BookFormDetail(element));
				else if (name.equals(ProductPackaging.refname) || name.equals(ProductPackaging.shortname))
					productPackaging = new ProductPackaging(element);
				else if (name.equals(ProductFormDescription.refname) || name.equals(ProductFormDescription.shortname))
					productFormDescription = new ProductFormDescription(element);
				else if (name.equals(NumberOfPieces.refname) || name.equals(NumberOfPieces.shortname))
					numberOfPieces = new NumberOfPieces(element);
				else if (name.equals(TradeCategory.refname) || name.equals(TradeCategory.shortname))
					tradeCategory = new TradeCategory(element);
				else if (name.equals(ProductContentType.refname) || name.equals(ProductContentType.shortname))
					productContentTypes = JPU.addToList(productContentTypes, new ProductContentType(element));
				else if (name.equals(EpubType.refname) || name.equals(EpubType.shortname))
					epubType = new EpubType(element);
				else if (name.equals(EpubTypeVersion.refname) || name.equals(EpubTypeVersion.shortname))
					epubTypeVersion = new EpubTypeVersion(element);
				else if (name.equals(EpubTypeDescription.refname) || name.equals(EpubTypeDescription.shortname))
					epubTypeDescription = new EpubTypeDescription(element);
				else if (name.equals(EpubFormat.refname) || name.equals(EpubFormat.shortname))
					epubFormat = new EpubFormat(element);
				else if (name.equals(EpubFormatVersion.refname) || name.equals(EpubFormatVersion.shortname))
					epubFormatVersion = new EpubFormatVersion(element);
				else if (name.equals(EpubFormatDescription.refname) || name.equals(EpubFormatDescription.shortname))
					epubFormatDescription = new EpubFormatDescription(element);
				else if (name.equals(EpubTypeNote.refname) || name.equals(EpubTypeNote.shortname))
					epubTypeNote = new EpubTypeNote(element);
				else if (name.equals(Publisher.refname) || name.equals(Publisher.shortname))
					publishers = JPU.addToList(publishers, new Publisher(element));
			}
		});
	}

	public ProductRelations getRelationCodeValue()
	{
		return (relationCode == null) ? null : relationCode.value;
	}

	/**
	 * Format: Fixed-length, 10 characters, all numeric except last character, which may be letter X.
	 */
	public String getISBNValue()
	{
		return (isbn == null) ? null : isbn.value;
	}

	/**
	 * Format: Fixed-length, 13 numeric digits.
	 */
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

	/**
	 * Format: Variable-length text, suggested maximum length 200 characters.
	 */
	public String getProductFormDescriptionValue()
	{
		return (productFormDescription == null) ? null : productFormDescription.value;
	}

	/**
	 * Format: Variable-length integer, suggested maximum length 4 digits.
	 */
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

	/**
	 * Format: Variable-length text, suggested maximum 10 characters
	 */
	public String getEpubTypeVersionValue()
	{
		return (epubTypeVersion == null) ? null : epubTypeVersion.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum 200 characters
	 */
	public String getEpubTypeDescriptionValue()
	{
		return (epubTypeDescription == null) ? null : epubTypeDescription.value;
	}

	public EpublicationFormats getEpubFormatValue()
	{
		return (epubFormat == null) ? null : epubFormat.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum 10 characters
	 */
	public String getEpubFormatVersionValue()
	{
		return (epubFormatVersion == null) ? null : epubFormatVersion.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum 200 characters
	 */
	public String getEpubFormatDescriptionValue()
	{
		return (epubFormatDescription == null) ? null : epubFormatDescription.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum 200 characters
	 */
	public String getEpubTypeNoteValue()
	{
		return (epubTypeNote == null) ? null : epubTypeNote.value;
	}

	public JonixProductIdentifier findProductIdentifier(ProductIdentifierTypes productIDType)
	{
		if (productIdentifiers != null)
		{
			for (ProductIdentifier x : productIdentifiers)
			{
				if (x.getProductIDTypeValue() == productIDType)
					return x.asJonixProductIdentifier();
			}
		}
		return null;
	}

	public List<JonixProductIdentifier> findProductIdentifiers(java.util.Set<ProductIdentifierTypes> productIDTypes)
	{
		if (productIdentifiers != null)
		{
			List<JonixProductIdentifier> matches = new ArrayList<>();
			for (ProductIdentifier x : productIdentifiers)
			{
				if (productIDTypes == null || productIDTypes.contains(x.getProductIDTypeValue()))
					matches.add(x.asJonixProductIdentifier());
			}
			return matches;
		}
		return null;
	}

	public JonixProductFormFeature findProductFormFeature(ProductFormFeatureTypes productFormFeatureType)
	{
		if (productFormFeatures != null)
		{
			for (ProductFormFeature x : productFormFeatures)
			{
				if (x.getProductFormFeatureTypeValue() == productFormFeatureType)
					return x.asJonixProductFormFeature();
			}
		}
		return null;
	}

	public List<JonixProductFormFeature> findProductFormFeatures(
			java.util.Set<ProductFormFeatureTypes> productFormFeatureTypes)
	{
		if (productFormFeatures != null)
		{
			List<JonixProductFormFeature> matches = new ArrayList<>();
			for (ProductFormFeature x : productFormFeatures)
			{
				if (productFormFeatureTypes == null
						|| productFormFeatureTypes.contains(x.getProductFormFeatureTypeValue()))
					matches.add(x.asJonixProductFormFeature());
			}
			return matches;
		}
		return null;
	}
}
