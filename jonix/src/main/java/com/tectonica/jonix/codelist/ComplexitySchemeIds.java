package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 32
 * 
 * @author Zach Melamed
 * 
 */
public enum ComplexitySchemeIds
{
	/**
	 * For example AD or HL. DEPRECATED in ONIX 3 – use <Audience> instead.
	 */
	Lexile_code("01"),

	/**
	 * For example 880L. DEPRECATED in ONIX 3 – use <Audience> instead.
	 */
	Lexile_number("02"),

	/**
	 * DEPRECATED in ONIX 3 – Use <Audience> instead. Fry readability metric based on number of sentences and syllables per 100 words. Expressed as a number from 1 to 15 in <ComplexityCode>.
	 */
	Fry_Readability_score("03");

	public final String code;

	private ComplexitySchemeIds(String code)
	{
		this.code = code;
	}

	private static ComplexitySchemeIds[] values = ComplexitySchemeIds.values();
	public static ComplexitySchemeIds fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ComplexitySchemeIds item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

