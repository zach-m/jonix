package com.tectonica.jonix.composites;

import com.tectonica.jonix.codelists.LanguageRoles;

@SuppressWarnings("serial")
public class Languages extends JonixBaseComposite<Languages.Language>
{
	public static class Language
	{
		public final LanguageRoles languageRole;
		public final String languageCode;

		public Language(LanguageRoles languageRole, String languageCode)
		{
			this.languageRole = languageRole;
			this.languageCode = languageCode;
		}

		@Override
		public String toString()
		{
			return String.format("Language [%s]: %s", (languageRole == null) ? null : languageRole.name(), languageCode);
		}
	}

	public void setNewItem(String languageRoleCode, String languageCode)
	{
		add(new Language(LanguageRoles.fromCode(languageRoleCode), languageCode));
	}
}
