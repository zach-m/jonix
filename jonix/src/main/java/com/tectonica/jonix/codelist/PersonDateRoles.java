package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 75
 * 
 * @author Zach Melamed
 * 
 */
public enum PersonDateRoles
{
	Date_of_birth("007"),

	Date_of_death("008");

	public final String code;

	private PersonDateRoles(String code)
	{
		this.code = code;
	}

	private static PersonDateRoles[] values = PersonDateRoles.values();
	public static PersonDateRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PersonDateRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

