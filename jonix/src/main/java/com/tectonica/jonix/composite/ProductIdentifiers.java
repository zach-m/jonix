package com.tectonica.jonix.composite;

import java.io.Serializable;

import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.JonixConsumer;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.codelist.ProductIdTypes;
import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;

public class ProductIdentifiers extends JonixComposite<ProductIdentifiers.ProductIdentifier>
{
	private static final long serialVersionUID = -2593731203018877487L;

	public static class ProductIdentifier implements Serializable
	{
		private static final long serialVersionUID = 5615166960112938899L;
		
		public final ProductIdTypes productIDType;
		public final String idTypeName;
		public final String idValue;

		public ProductIdentifier(ProductIdTypes productIDType, String idTypeName, String idValue)
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

	@Override
	public JonixConsumer consume(Object o, Object parent, Object grandParent, JonixResolver resolver)
	{
		if (resolver.onixTypeOf(o) == ONIX.ProductIdentifier)
		{
			String productIDTypeCode = (String) JonixUtils.getProperty(o, resolver.onixPropOf(ONIX.ProductIDType), "value");
			String idTypeName = (String) JonixUtils.getProperty(o, resolver.onixPropOf(ONIX.IDTypeName), "value");
			String idValue = (String) JonixUtils.getProperty(o, resolver.onixPropOf(ONIX.IDValue), "value");
			add(new ProductIdentifier(ProductIdTypes.fromCode(productIDTypeCode), idTypeName, idValue));
			return this;
		}
		
		return null;
	}
}
