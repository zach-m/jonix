package com.tectonica.jonix.element;

import com.tectonica.jonix.JonixElement;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.codelist.ProductForms;
import com.tectonica.jonix.resolve.ONIX;

public final class ProductFormElement extends JonixElement<ProductForms>
{
	public ProductFormElement()
	{
		super(ONIX.ProductForm);
	}

	@Override
	protected ProductForms consume(Object o)
	{
		return ProductForms.fromCode(JonixUtils.getValueAsStr(o));
	}
}