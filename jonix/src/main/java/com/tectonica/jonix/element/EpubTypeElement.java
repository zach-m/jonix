package com.tectonica.jonix.element;

import com.tectonica.jonix.JonixElement;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.codelist.EpubTypes;
import com.tectonica.jonix.resolve.ONIX;

public final class EpubTypeElement extends JonixElement<EpubTypes>
{
	public EpubTypeElement()
	{
		super(ONIX.EpubType);
	}

	@Override
	protected EpubTypes consume(Object o)
	{
		return EpubTypes.fromCode(JonixUtils.getValueAsStr(o));
	}
}