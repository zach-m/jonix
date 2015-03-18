package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 56
 * 
 * @author Zach Melamed
 * 
 */
public enum AudienceRestrictionFlags
{
	Restrictions_apply__see_note("R"),

	/**
	 * Indexed for the German market – in Deutschland indiziert.
	 */
	Indiziert("X");

	public final String code;

	private AudienceRestrictionFlags(String code)
	{
		this.code = code;
	}

	private static AudienceRestrictionFlags[] values = AudienceRestrictionFlags.values();
	public static AudienceRestrictionFlags fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (AudienceRestrictionFlags item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

