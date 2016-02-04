package com.tectonica.jonix;

import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.struct.JonixProductIdentifier;
import com.tectonica.jonix.struct.JonixTitle;

public class Onix2Essentials implements JonixEssentials
{
	private final Product product;

	public Onix2Essentials(Product product)
	{
		this.product = product;
	}

	@Override
	public String get(TextFields fieldType)
	{
		switch (fieldType)
		{
		case Isbn13:
			JonixProductIdentifier isbn13Tag = product.findProductIdentifier(ProductIdentifierTypes.ISBN_13);
			return (isbn13Tag == null) ? null : isbn13Tag.idValue;
			
		case Isbn10:
			JonixProductIdentifier isbn10Tag = product.findProductIdentifier(ProductIdentifierTypes.ISBN_10);
			return (isbn10Tag == null) ? null : isbn10Tag.idValue;
			
		case Title:
			JonixTitle titleTag = product.findTitle(TitleTypes.Distinctive_title_book);
			return (titleTag == null) ? null : titleTag.titleText;
		}
		return null;
	}
}
