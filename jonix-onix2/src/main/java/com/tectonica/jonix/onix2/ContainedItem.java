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
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.ProductContentTypes;
import com.tectonica.jonix.codelist.ProductFormDetails;
import com.tectonica.jonix.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.codelist.ProductForms;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.ProductPackagingTypes;
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
 * <h1>Contained item composite</h1>
 * <p>
 * A repeatable group of data elements which together describe an item which is part of or contained within the current
 * product. The composite may be used to specify the item(s) and item quantity/ies carried in a dumpbin, or included in
 * (eg) a classroom pack, or simply to state the product forms contained within a mixed media product, without
 * specifying their identifiers or quantity. The composite is used only when the product form coding for the product as
 * a whole indicates that the product includes two or more different items, or multiple copies of the same item.
 * </p>
 * <p>
 * Each instance of the &lt;ContainedItem&gt; composite must carry at least either a product identifier, or a product
 * form code, or both. In other words, it is valid to send an instance of the composite with an identifier and no
 * product form code, or with a product form code and no identifier.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ContainedItem&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;containeditem&gt;</td>
 * </tr>
 * </table>
 */
public class ContainedItem implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ContainedItem";
	public static final String shortname = "containeditem";

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
	public ItemQuantity itemQuantity;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ContainedItem()
	{}

	public ContainedItem(org.w3c.dom.Element element)
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
				if (name.equals(ISBN.refname) || name.equals(ISBN.shortname))
					isbn = new ISBN(element);
				else if (name.equals(EAN13.refname) || name.equals(EAN13.shortname))
					ean13 = new EAN13(element);
				else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(element));
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
				else if (name.equals(ItemQuantity.refname) || name.equals(ItemQuantity.shortname))
					itemQuantity = new ItemQuantity(element);
			}
		});
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

	public String getItemQuantityValue()
	{
		return (itemQuantity == null) ? null : itemQuantity.value;
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
