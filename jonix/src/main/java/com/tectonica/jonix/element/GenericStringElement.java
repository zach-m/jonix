package com.tectonica.jonix.element;

import com.tectonica.jonix.JonixElement;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.resolve.ONIX;

public class GenericStringElement extends JonixElement<String>
{
	public GenericStringElement(ONIX onix)
	{
		super(onix);
	}

	@Override
	protected String consume(Object o)
	{
		return JonixUtils.getValueAsStr(o);
	}
}
