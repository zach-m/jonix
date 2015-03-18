package com.tectonica.jonix.composite;

import java.io.Serializable;

import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.JonixConsumer;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.codelist.PublishingRoles;
import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;

public class Publishers extends JonixComposite<Publishers.Publisher>
{
	private static final long serialVersionUID = -514229628960743727L;

	public static class Publisher implements Serializable
	{
		private static final long serialVersionUID = -2939044736433147423L;

		public PublishingRoles publishingRole;
		public String publisherName;

		@Override
		public String toString()
		{
			String publishingRoleStr = (publishingRole == null) ? null : publishingRole.name();
			return String.format("Publisher [%s]: %s", publishingRoleStr, publisherName);
		}
	}

	private transient Publisher activeItem;

	@Override
	public JonixConsumer consume(Object o, Object parent, Object grandParent, JonixResolver resolver)
	{
		if (resolver.onixTypeOf(o) == ONIX.Publisher)
		{
			add(activeItem = new Publisher());
			return this;
		}

		if (resolver.onixTypeOf(parent) == ONIX.Publisher)
		{
			switch (resolver.onixTypeOf(o))
			{
				case PublishingRole:
					activeItem.publishingRole = PublishingRoles.fromCode(JonixUtils.getValueAsStr(o));
					break;

				case PublisherName:
					activeItem.publisherName = JonixUtils.getValueAsStr(o);
					break;

				default:
					break;
			}
		}

		return null;
	}
}
