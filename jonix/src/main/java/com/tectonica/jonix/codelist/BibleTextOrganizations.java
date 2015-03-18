package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 86
 * 
 * @author Zach Melamed
 * 
 */
public enum BibleTextOrganizations
{
	/**
	 * A Bible with the text organized in the order in which events are believed to have happened.
	 */
	Chronological("CHR"),

	/**
	 * A Bible which explores keywords or themes by referring text to preceding or following text.
	 */
	Chain_reference("CHA"),

	/**
	 * A Bible or other text in which different versions are printed one line above the other, so that the variations can easily be detected.
	 */
	Interlinear("INT"),

	/**
	 * A Bible with two or more versions printed side by side.
	 */
	Parallel("PAR"),

	/**
	 * A Bible in which the text is presented in the traditional order.
	 */
	Standard("STN");

	public final String code;

	private BibleTextOrganizations(String code)
	{
		this.code = code;
	}

	private static BibleTextOrganizations[] values = BibleTextOrganizations.values();
	public static BibleTextOrganizations fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (BibleTextOrganizations item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

