package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 28
 * 
 * @author Zach Melamed
 * 
 */
public enum AudienceCodes
{
	/**
	 * For a non-specialist adult audience.
	 */
	General_trade("01"),

	/**
	 * For a juvenile audience, not specifically for any educational purpose.
	 */
	Children_juvenile("02"),

	/**
	 * For a teenage audience, not specifically for any educational purpose.
	 */
	Young_adult("03"),

	/**
	 * Kindergarten, pre-school, primary/elementary or secondary/high school education.
	 */
	Primary_and_secondary_elementary_and_high_school("04"),

	/**
	 * For universities and colleges of further and higher education.
	 */
	College_higher_education("05"),

	/**
	 * For an expert adult audience, including academic research.
	 */
	Professional_and_scholarly("06"),

	/**
	 * Intended for use in teaching English as a second language.
	 */
	ELT_ESL("07"),

	/**
	 * For centres providing academic, vocational or recreational courses for adults.
	 */
	Adult_education("08");

	public final String code;

	private AudienceCodes(String code)
	{
		this.code = code;
	}

	private static AudienceCodes[] values = AudienceCodes.values();
	public static AudienceCodes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (AudienceCodes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

