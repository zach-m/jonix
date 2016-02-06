package com.tectonica.jonix;

import java.util.List;

import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.onix3.TitleDetail;
import com.tectonica.jonix.onix3.TitleElement;
import com.tectonica.jonix.struct.JonixProductIdentifier;

public class Onix3Essentials implements JonixEssentials
{
	private final Product product;

	public Onix3Essentials(Product product)
	{
		this.product = product;
	}

	@Override
	public String get(TextFields fieldType)
	{
		switch (fieldType)
		{
		case Isbn13:
			return getProductIdentifier(ProductIdentifierTypes.ISBN_13);

		case Isbn10:
			return getProductIdentifier(ProductIdentifierTypes.ISBN_10);

		case Title:
			if (product.descriptiveDetail != null)
			{
				List<TitleDetail> titleDetails = product.descriptiveDetail.titleDetails;
				if (titleDetails != null)
				{
					for (TitleDetail titleDetail : titleDetails)
					{
						if (titleDetail.getTitleTypeValue() == TitleTypes.Distinctive_title_book)
						{
							TitleElement titleElement = titleDetail.titleElements.get(0); // at least 1 is mandatory
							return titleElement.getTitleTextValue();
						}
					}
				}
			}
			return null;
		}
		return null;
	}

	public String getProductIdentifier(ProductIdentifierTypes idType)
	{
		JonixProductIdentifier productIdentifier = product.findProductIdentifier(idType);
		return (productIdentifier == null) ? null : productIdentifier.idValue;
	}
}
