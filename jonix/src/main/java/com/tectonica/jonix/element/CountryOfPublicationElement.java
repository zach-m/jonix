package com.tectonica.jonix.element;

import com.tectonica.jonix.JonixElement;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.resolve.ONIX;

public final class CountryOfPublicationElement extends JonixElement<String>
{
	public CountryOfPublicationElement()
	{
		super(ONIX.CountryOfPublication);
	}

	@Override
	protected String consume(Object o)
	{
		return (String) JonixUtils.getProperty(o, "value", "name()");
	}
}