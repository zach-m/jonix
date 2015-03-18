package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 177
 * 
 * @author Zach Melamed
 * 
 */
public enum PersonOrganizationDateRoles
{
	Date_of_birth("50"),

	Date_of_death("51");

	public final String code;

	private PersonOrganizationDateRoles(String code)
	{
		this.code = code;
	}

	private static PersonOrganizationDateRoles[] values = PersonOrganizationDateRoles.values();
	public static PersonOrganizationDateRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PersonOrganizationDateRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

