package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 19
 * 
 * @author Zach Melamed
 * 
 */
public enum UnnamedPersons
{
	Unknown("01"),

	Anonymous("02"),

	/**
	 * And others: additional contributors not listed.
	 */
	et_al("03"),

	/**
	 * When the product is a pack of books by different authors.
	 */
	Various_authors("04"),

	/**
	 * Use with Contributor role code E07 “read by”, for audio books for the blind.
	 */
	Synthesized_voice___male("05"),

	/**
	 * Use with Contributor role code E07 “read by”, for audio books for the blind.
	 */
	Synthesized_voice___female("06"),

	/**
	 * Use with Contributor role code E07 “read by”, for audio books for the blind.
	 */
	Synthesized_voice___unspecified("07");

	public final String code;

	private UnnamedPersons(String code)
	{
		this.code = code;
	}

	private static UnnamedPersons[] values = UnnamedPersons.values();
	public static UnnamedPersons fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (UnnamedPersons item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

