package com.tectonica.jonix.composites;

import com.tectonica.jonix.codelists.ContributorRoles;

@SuppressWarnings("serial")
public class Contributors extends JonixComposite<Contributors.Contributor>
{
	public Contributors()
	{
		super(Contributor.class);
	}
	
	public static class Contributor
	{
		public ContributorRoles contributorRole;
		public String personName;
		public String biographicalNote;

		@Override
		public String toString()
		{
			String contributorRoleStr = (contributorRole == null) ? null : contributorRole.name();
			String biographicalNoteStr = biographicalNote == null ? "" : " (" + biographicalNote + ")";
			return String.format("Contributor [%s]: %s%s", contributorRoleStr, personName, biographicalNoteStr);
		}
	}
}