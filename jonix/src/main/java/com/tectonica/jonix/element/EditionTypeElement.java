package com.tectonica.jonix.element;

import com.tectonica.jonix.JonixElement;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.codelist.EditionTypes;
import com.tectonica.jonix.resolve.ONIX;

public final class EditionTypeElement extends JonixElement<EditionTypes>
{
	public EditionTypeElement()
	{
		super(ONIX.EditionType);
	}

	@Override
	protected EditionTypes consume(Object o)
	{
		return EditionTypes.fromCode((String) JonixUtils.getProperty(o, "value", "name()"));
	}
}