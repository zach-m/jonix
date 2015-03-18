package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 20
 * 
 * @author Zach Melamed
 * 
 */
public enum ConferenceRoles
{
;

	public final String code;

	private ConferenceRoles(String code)
	{
		this.code = code;
	}

	private static ConferenceRoles[] values = ConferenceRoles.values();
	public static ConferenceRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ConferenceRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

