package com.tectonica.jonix.element;

import com.tectonica.jonix.JonixElement;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.codelist.NotificationTypes;
import com.tectonica.jonix.resolve.ONIX;

public final class NotificationTypeElement extends JonixElement<NotificationTypes>
{
	public NotificationTypeElement()
	{
		super(ONIX.NotificationType);
	}

	@Override
	protected NotificationTypes consume(Object o)
	{
		return NotificationTypes.fromCode(JonixUtils.getValueAsStr(o));
	}
}