package com.tectonica.jonix.composites;

import com.tectonica.jonix.codelists.ProductIDTypes;

@SuppressWarnings("serial")
public class ProductIdentifiers extends JonixBaseComposite<ProductIdentifiers.ProductIdentifier>
{
	public static class ProductIdentifier
	{
		public final ProductIDTypes productIDType;
		public final String idTypeName;
		public final String idValue;

		public ProductIdentifier(ProductIDTypes productIDType, String idTypeName, String idValue)
		{
			this.productIDType = productIDType;
			this.idTypeName = idTypeName;
			this.idValue = idValue;
		}

		@Override
		public String toString()
		{
			return String.format("ProductIdentifier [%s/%s]: %s", (productIDType == null) ? null : productIDType.name(), idTypeName, idValue);
		}
	}

	public void setNewItem(String productIDTypeCode, String idTypeName, String idValue)
	{
		add(new ProductIdentifier(ProductIDTypes.fromCode(productIDTypeCode), idTypeName, idValue));
	}
}
