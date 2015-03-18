package com.tectonica.jonix.composites;

import com.tectonica.jonix.codelists.PublishingRoles;

@SuppressWarnings("serial")
public class Publishers extends JonixComposite<Publishers.Publisher>
{
	public Publishers()
	{
		super(Publisher.class);
	}
	
	public static class Publisher
	{
		public PublishingRoles publishingRole;
		public String publisherName;

		@Override
		public String toString()
		{
			String publishingRoleStr = (publishingRole == null) ? null : publishingRole.name();
			return String.format("Publisher [%s]: %s", publishingRoleStr, publisherName);
		}
	}
}
