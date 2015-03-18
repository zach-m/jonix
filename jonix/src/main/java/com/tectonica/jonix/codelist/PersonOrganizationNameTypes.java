package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 18
 * 
 * @author Zach Melamed
 * 
 */
public enum PersonOrganizationNameTypes
{
	Unspecified("00"),

	/**
	 * May be used to give a well-known pseudonym, where the primary name is a ‘real’ name.
	 */
	Pseudonym("01"),

	Authoritycontrolled_name("02"),

	Earlier_name("03"),

	/**
	 * May be used to identify a well-known real name, where the primary name is a pseudonym.
	 */
	_Real_name("04"),

	/**
	 * Use only within <AlternativeName>, when the primary name type is unspecified.
	 */
	Transliterated_form_of_primary_name("05");

	public final String code;

	private PersonOrganizationNameTypes(String code)
	{
		this.code = code;
	}

	private static PersonOrganizationNameTypes[] values = PersonOrganizationNameTypes.values();
	public static PersonOrganizationNameTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PersonOrganizationNameTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

