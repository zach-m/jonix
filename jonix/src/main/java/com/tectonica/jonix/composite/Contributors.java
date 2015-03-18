package com.tectonica.jonix.composite;

import java.io.Serializable;

import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.JonixConsumer;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;

public class Contributors extends JonixComposite<Contributors.Contributor>
{
	private static final long serialVersionUID = 4910114984296735847L;

	public static class Contributor implements Serializable
	{
		private static final long serialVersionUID = -8273773964449064455L;

		public ContributorRoles contributorRole;
		public String personName;
		public String personNameKey;
		public String personNameBeforeKey;
		public String corporateName;
		public String biographicalNote;

		public String displayName()
		{
			if (personName != null)
				return personName;

			if (personNameKey != null)
			{
				if (personNameBeforeKey != null)
					return personNameBeforeKey + " " + personNameKey;
				return personNameKey;
			}

			if (personNameBeforeKey != null)
				return personNameBeforeKey;

			return corporateName;
		}

		@Override
		public String toString()
		{
			String contributorRoleStr = (contributorRole == null) ? null : contributorRole.name();
			String biographicalNoteStr = biographicalNote == null ? "" : " (" + biographicalNote + ")";
			return String.format("Contributor [%s]: %s%s", contributorRoleStr, personName, biographicalNoteStr);
		}
	}

	private transient Contributor activeItem;

	@Override
	public JonixConsumer consume(Object o, Object parent, Object grandParent, JonixResolver resolver)
	{
		if (resolver.onixTypeOf(o) == ONIX.Contributor)
		{
			add(activeItem = new Contributor());
			return this;
		}
		
		if (resolver.onixTypeOf(parent) == ONIX.Contributor)
		{
			switch (resolver.onixTypeOf(o))
			{
				case ContributorRole:
					activeItem.contributorRole = ContributorRoles.fromCode((String) JonixUtils.getProperty(o, "value", "value")); // List17
					break;
					
				case PersonName:
					activeItem.personName = JonixUtils.getValueAsStr(o);
					break;
					
				case KeyNames:
					activeItem.personNameKey = JonixUtils.getValueAsStr(o);
					break;
					
				case NamesBeforeKey:
					activeItem.personNameBeforeKey = JonixUtils.getValueAsStr(o);
					break;
					
				case CorporateName:
					activeItem.corporateName = JonixUtils.getValueAsStr(o);
					break;
					
				case BiographicalNote:
					activeItem.biographicalNote = JonixUtils.getContentAsStr(o);
					break;
					
				default:
					break;
			}
		}
		
		return null;
	}
}